package JavaCodes.hashmap_heap;

import java.util.*;
import java.io.*;

public class write_hashmap{
    
  public static class HashMap<K, V> {
    private class HMNode {
      K key;
      V value;

      HMNode(K key, V value) {
        this.key = key;
        this.value = value;
      }
    }

    private int size; // n
    private LinkedList<HMNode>[] buckets; // N = buckets.length

    public HashMap() {
      initbuckets(4);
      size = 0;
    }

    private void initbuckets(int N) {
      buckets = new LinkedList[N];
      for (int bi = 0; bi < buckets.length; bi++) {
        buckets[bi] = new LinkedList<>();
      }
    }

    public void put(K key, V value) throws Exception {
      int bi = hashFunction(key);
      size++;
      buckets[bi].add(new HMNode(key, value));
      return;
    }

    public V get(K key) throws Exception {
      int bi = hashFunction(key);
      int di = findInBucket(key, bi);
      if(di == -1){
        return null;
      }else{
        HMNode pair = buckets[bi].get(di);
        return pair.value;
      }
    }

    public boolean containsKey(K key) {
      int bi = hashFunction(key);
      int di = findInBucket(key,bi);
      if(di == -1){
        return false;
      }else{
        return true;
      } 
    }

    public V remove(K key) throws Exception {
      int bi = hashFunction(key);
      int di = findInBucket(key, bi);
      if(di == -1){
        return null;
      }else{
        HMNode pair = buckets[bi].get(di);
        buckets[bi].remove(di);
        size--;
        return pair.value;
      }
      // write your code here
    }

    public ArrayList<K> keyset() throws Exception {
      ArrayList<K> keys = new ArrayList<>();
      for(int i=0;i<buckets.length;i++){
       LinkedList<HMNode> lList = buckets[i];
       HMNode temp = lList.get(0);
       keys.add(temp.key);
      }
      return keys;
      // write your code here
    }

    public int size() {
      // write your code here
      return size;
    }

    public int hashFunction(K key){
      return 
    }

    public int findInBucket(K key, int bi){
      for(int di = 0; di < buckets[bi].size();di++){
        HMNode pair = buckets[bi].get(di);
        if(pair.key.equals(key)){
          return di;
        }
      }
      return -1;
    }

   public void display() {
      System.out.println("Display Begins");
      for (int bi = 0; bi < buckets.length; bi++) {
        System.out.print("Bucket" + bi + " ");
        for (HMNode node : buckets[bi]) {
          System.out.print( node.key + "@" + node.value + " ");
        }
        System.out.println(".");
      }
      System.out.println("Display Ends");
  }
}

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    HashMap<String, Integer> map = new HashMap();

    String str = br.readLine();
    while (str.equals("quit") == false) {
      if (str.startsWith("put")) {
        String[] parts = str.split(" ");
        String key = parts[1];
        Integer val = Integer.parseInt(parts[2]);
        map.put(key, val);
      } else if (str.startsWith("get")) {
        String[] parts = str.split(" ");
        String key = parts[1];
        System.out.println(map.get(key));
      } else if (str.startsWith("containsKey")) {
        String[] parts = str.split(" ");
        String key = parts[1];
        System.out.println(map.containsKey(key));
      } else if (str.startsWith("remove")) {
        String[] parts = str.split(" ");
        String key = parts[1];
        System.out.println(map.remove(key));
      } else if (str.startsWith("size")) {
        System.out.println(map.size());
      } else if (str.startsWith("keyset")) {
        System.out.println(map.keyset());
      } else if (str.startsWith("display")) {
        map.display();
      }
      str = br.readLine();
    }
  }

}


