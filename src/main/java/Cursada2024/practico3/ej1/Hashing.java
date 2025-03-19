package practico3.ej1;

import java.util.*;

public class Hashing<K,V> extends Dictionary<K,V> implements Map<K,V> {
    int[] arr = {68, 42, 47, 5, 76, 95, 23, 88, 90, 85, 31, 71, 60, 10, 46, 61, 50, 92, 74, 6, 97, 66, 1, 56, 27, 7, 14, 92};
    private transient Entry<?, ?>[] table;

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean containsKey(Object key) {
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        return false;
    }

    @Override
    public Enumeration<K> keys() {
        return null;
    }

    @Override
    public Enumeration<V> elements() {
        return null;
    }

    @Override
    public V get(Object key) {
        return null;
    }

    @Override
    public synchronized V put(K key, V value) {
        return null;
    }

    @Override
    public V remove(Object key) {
        return null;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {

    }

    @Override
    public void clear() {

    }

    @Override
    public Set<K> keySet() {
        return null;
    }

    @Override
    public Collection<V> values() {
        return null;
    }

    @Override
    public Set<Map.Entry<K, V>> entrySet() {
        return null;
    }

    private static class Entry<K, V> implements Map.Entry<K, V> {
        int hash;
        K key;
        V value;
        Entry<K, V> next;//es una lista vinculada !! Esta es la lista de // rebalse del balde.

        @Override
        public K getKey() {
            return null;
        }

        @Override
        public V getValue() {
            return null;
        }

        @Override
        public V setValue(V value) {
            return null;
        }
    }

}
