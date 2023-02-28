package LeetCode;

class Solution {
    class Item implements Comparable<Item>{
        int boxes;
        int subBoxes;

        Item(int boxes,int subBoxes){
            this.boxes = boxes;
            this.subBoxes = subBoxes;
        }


         @Override
        public int compareTo(Item o) {
           if(o.subBoxes > this.subBoxes){
            return -1; 
           }else if(o.subBoxes < this.subBoxes){
            return 1;
           }else{
            return 0;
           }
        }
    }
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Item [] boxArr = new Item[boxTypes.length];
        int n = boxTypes.length;

        for(int i=0;i<boxTypes.length;i++){
            boxArr[i] = new Item(boxTypes[i][0],boxTypes[i][1]);
        }

        Arrays.sort(boxArr);
        int res = 0;

        for(int i=n-1;i>=0 && truckSize>0;i--){
            if(truckSize-boxArr[i].boxes>=0){
                res = res + boxArr[i].boxes*boxArr[i].subBoxes;
                truckSize = truckSize - boxArr[i].boxes;
            }else{
                res = res + truckSize*boxArr[i].subBoxes;
                break;
            }
        }

        return res;
        
    }
}












