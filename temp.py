import json
import pandas as pd 
import io  
import boto3 
import os

def lambda_handler(event, context):
    # TODO implement
    s3_client = boto3.client("s3")
    bucket = event['Records'][0]['s3']['bucket']['name']
    key = event['Records'][0]['s3']['object']['key']
    objecturl = f"s3://{bucket}/{key}"
    
    
    # try:
    reponse = s3_client.get_object(Bucket=bucket, Key=key)
    file = reponse["Body"].read()
    read_excel_data = io.BytesIO(file)
    print("process started staage 1")
    df = pd.read_excel(read_excel_data)
    currSheetProcess = service_process_excel(event,df)
    currSheetProcess.check_excel_fields()
    
    return {
        'statusCode': 200,
        'body': json.dumps('Hello from Lambda!')
    }

class service_process_excel:

    def __init__(self,event,df):
        self.event = event
        self.mandatory_flag = True
        self.partial_flag = True
        self.message = []
        self.col_name_list = []
        self.necessary_fields = {"Serial No" : ["sl#"],'site' : ["company","site"],'location':["location"],'plant':["plant"],'line':["line"],'Equipment Name' : ["equipmentname","plcname"],'stage' : ["stage","station","stationnumber"]
                                    ,"Unique ID":["uniqueid","ip","macid"],"IoT Type":["iottype"]}
        self.df = df
        self.columnsList = self.df.columns.values

    def check_excel_fields(self):
        tempList = []
        colList = []
        # creating the two copy of te column list
        for i in self.columnsList:
            tempList.append(i)
            colList.append(i)
        # cleaning the coloumns and making it in the useful form
        for i in range(0,len(tempList)):
            tempList[i] = tempList[i].replace("\n","")
            while(tempList[i].find('(') != -1):
                tempList[i] = tempList[i][0:tempList[i].find('(')] + tempList[i][tempList[i].find(')'):len(tempList[i])]
                tempList[i] = tempList[i].replace(')','')
            self.col_name_list.append(tempList[i].split('/'))    
            tempList[i] = tempList[i].lower()
            tempList[i] = tempList[i].replace(" ","")
            tempList[i] = tempList[i].split('/')
        
        self.col_names = {}
        self.mandatory_flag = True
        for i in self.necessary_fields.keys():
            flag = False
            for j in self.necessary_fields[i]:
                if(flag == False):
                    for k in range (0,len(tempList)):
                        if(j in tempList[k]):
                            flag = True
                            self.col_names[i] = colList[k]
                            colList[k] = ''
                            break
            if(flag == False):
                self.mandatory_flag = False
                print("The mandatory field ",i," is missing")
                message.append("The mandatory field ",i," is missing")
      
            
        jsonFile = json.loads(self.df.to_json(orient='records'))
        for i in jsonFile:
            for j in self.col_names.keys():
                    if(i[self.col_names[j]] == None or i[self.col_names[j]] == -2147483648 or i[self.col_names[j]] == -2147483647):
                        i[self.col_names[j]] = -2147483648
                        count = i["Sl#"]
                        self.df[self.col_names[j]].values[count-1] = -2147483648
                        
        
        
        for i in range(0,len(colList)):
            if(colList[i] != ''):
                if(self.col_name_list[i][-1].find("PLC") or self.col_name_list[i][-1].find("plc")):
                    currWord = self.col_name_list[i][-1]
                    currWord = currWord.replace("PLC","")
                    currWord = currWord.replace("plc","")
                    self.col_names[currWord] = colList[i]
                else:
                    self.col_names[self.col_name_list[i][-1]] = colList[i]


        jsonFile = json.loads(self.df.to_json(orient='records'))
        for i in jsonFile:
            currEntry = {}
            for j in self.col_names.keys():
                if(i[self.col_names[j]] != None and i[self.col_names[j]] != -2147483647 and i[self.col_names[j]] != -1):
                    currEntry[j] = {'S':str(i[self.col_names[j]])}
                else :
                    if(i[self.col_names[j]] == -1):
                        pass
                    else:
                        self.partial_flag = False
                        count = i["Sl#"]
                        self.df[self.col_names[j]].values[count-1] = -2147483647
                        i[self.col_names[j]] = -2147483647
            if(self.mandatory_flag):
                write_data = repository_write_data()
                write_data.add_entry(currEntry)
                
        self.write_excel()
               
    def write_excel(self):
        self.temp_file_path = "/tmp/latest_report.xlsx"
        writer = pd.ExcelWriter(self.temp_file_path, engine='xlsxwriter')
        self.df.to_excel(writer, sheet_name='Asset Model')
        workbook  = writer.book
        worksheet = writer.sheets['Asset Model']
        format1 = workbook.add_format({'bg_color': '#ff0000',
                                    'font_color': '#ff0000'})
        format2 = workbook.add_format({'bg_color': '#E85C30',
                                    'font_color': '#E85C30'})
        start_row = 1
        start_col = 0
        end_row = len(self.df)
        end_cold = len(self.columnsList)

        worksheet.conditional_format(start_row, start_col, end_row, end_cold,
                                    {'type':     'cell',
                                    'criteria': '=',
                                    'value':    -2147483648,
                                    'format':   format1})
        worksheet.conditional_format(start_row, start_col, end_row, end_cold,
                                    {'type':     'cell',
                                    'criteria': '=',
                                    'value':    -2147483647,
                                    'format':   format2})
        writer.save()
        self.upload_file()

    def upload_file(self):
        s3 = boto3.client('s3')
        try:
            bucket1 = self.event['Records'][0]['s3']['bucket']['name']
            key1  = self.event['Records'][0]['s3']['object']['key']
            print(key1.replace("new","updated"))
            s3.upload_file(self.temp_file_path,bucket1, key1)
            url = s3.generate_presigned_url(
                ClientMethod='get_object',
                Params={
                    'Bucket': bucket1,
                    'Key': key1.replace("new","updated")
                },
                ExpiresIn=24 * 3600
            )
            s3 = boto3.resource('s3')
            object_to_be_deleted = s3.Object(bucket1, key1)
            object_to_be_deleted.delete()

            print("Upload Successful", url)
            return url
        except FileNotFoundError:
            print("The file was not found")

    




class repository_write_data:

    def __init__(self):
        self.table_name = "sample_entry"
        self.dynamoBb = boto3.client('dynamodb',region_name = 'ap-south-1')

    def add_entry(self,currEntry):
        self.dynamoBb.put_item(
                                TableName = "sample_entry",
                                Item = currEntry
                            )
