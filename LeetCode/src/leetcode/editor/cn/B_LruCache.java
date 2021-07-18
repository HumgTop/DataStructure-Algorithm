package leetcode.editor.cn;


import java.util.LinkedHashMap;
import java.util.Map;

public class B_LruCache {
    public static void main(String[] args) {


    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class LRUCache extends LinkedHashMap<Integer, Integer> {
        int capacity;

        public LRUCache(int capacity) {
            super(capacity, 0.75f, true);
            this.capacity = capacity;
        }

        public int get(int key) {
            return super.getOrDefault(key, -1);
        }

        public void put(int key, int value) {
            super.put(key, value);
        }

        @Override
        public boolean removeEldestEntry(Map.Entry<Integer, Integer> entry) {
            return super.size() > this.capacity;
        }
    }

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)


}