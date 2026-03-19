class CustomHashMap<K,V> {
    private int INITIAL_CAPACITY = 1 << 16;
    private int MAXIMUM_CAPACITY = 1 << 30;
    private Entry[] table;

    public CustomHashMap() {
        table = new Entry[INITIAL_CAPACITY];
    }

    public CustomHashMap(int capacity) {
        int twoToThePowerCapacity = getCapacity(capacity);
        table = new Entry[twoToThePowerCapacity];
    }

    int getCapacity(int n) {
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return n < 0 ? 1 : n > MAXIMUM_CAPACITY ? MAXIMUM_CAPACITY : n + 1;
    }

    public void put(K key, V value) {
        if(key == null) return null;
        
        int index = getIndex(key);
        Entry<K, V> head = table[index];

        Entry<K, V> curr = head;

        while(curr != null) {
            if(curr.key == key) {
                curr.value = value;
                return;
            }
            curr = curr.next;
        }
        
        Entry<K, V> newNode = new Entry(key, value);
        newNode.next = head;
        table[index] = newNode;
    }

    public V get(V key) {
        if(key == null) return null;

        int index = getIndex(key);
        Entry<K, V> curr = table[index];

        while(curr != null) {
            if(curr.key == key) {
                return value;
            }
            curr = curr.next;
        }
        return null;
    }

    int getIndex(K key) {
        int hashcode = key.hashCode();
        return (hashcode & 0xf7777777 ) % table.length;
    }

    class Entry {
        K key;
        V value;
        Entry<K, V> next;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

}

public class Main {
    public static void main(String[] args) {
        CustomHashMap hashmap = new CustomHashMap(12);
    }
}