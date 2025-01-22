package learning;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRCcache<K,V> extends LinkedHashMap<K,V> {

    private int capacity;

    public LRCcache(int capacity) {
        //IF accesorder is set true then it will maintain order as per recently used. 
        super(capacity,2,true);
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        System.out.println("whenever we insert eleemnt the function is called "+size());
        return size()>capacity;
    }

    public static void main(String[] args) {
        LRCcache<String,String> l = new LRCcache<>(3);
        l.put("amam","chama");
        l.put("tmam","vhama");
        l.put("zmam","ghama");
        l.put("smam","jhama");
        l.get("amam");
        l.get("amam");
        l.get("tmam");

        System.out.println(l.toString());
        //{zmam=ghama, smam=jhama, tmam=vhama}
    }
}
