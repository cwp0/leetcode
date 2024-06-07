package method;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Program: Java
 * @Package: method
 * @Class: LRUCache
 * @Description:
 * @Author: cwp0
 * @CreatedTime: 2024/06/07 21:33
 * @Version: 1.0
 */
public class LRUCache<K, V> extends LinkedHashMap<K, V> {
    private final int capacity;
    public LRUCache(int capacity) {
        super(capacity, 1f, true);
        this.capacity = capacity;
    }
    // 判断size超过容量时返回true，告知LinkedHashMap移除最老的缓存项(即链表的第一个元素)
    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > capacity;
    }

    public static void main(String[] args) {
        LRUCache<Integer, String> lruCache = new LRUCache<>(5);
        lruCache.put(1, "apple");
        lruCache.put(2, "banana");
        lruCache.put(3, "pear");
        lruCache.put(4, "watermelon");
        lruCache.put(5, "peach");
        System.out.println(lruCache);
        lruCache.put(6, "orange");
        System.out.println(lruCache);
        lruCache.get(4);
        System.out.println(lruCache);
    }

}