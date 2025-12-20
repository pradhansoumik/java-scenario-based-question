import java.util.LinkedHashMap;

public class LRUCache<k,v> extends LinkedHashMap<k,v> {

    private final int capacity;

    public LRUCache(int capacity) {
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(java.util.Map.Entry<k, v> eldest) {
        return size() > capacity;
    }

}
class LRUCacheMain{
    public static void main(String[] args) {
        LRUCache<Integer, String> lruCache = new LRUCache<>(3);

        lruCache.put(1, "One");
        lruCache.put(2, "Two");
        lruCache.put(3, "Three");

        System.out.println("Initial Cache: " + lruCache);

        lruCache.get(1); // Access key 1
        lruCache.put(4, "Four"); // This should evict key 2

        System.out.println("Cache after accessing key 1 and adding key 4: " + lruCache);//[3,1,4]

        lruCache.put(5, "Five"); // This should evict key 3

        System.out.println("Cache after adding key 5: " + lruCache);//[1,4,5]
    }
}
