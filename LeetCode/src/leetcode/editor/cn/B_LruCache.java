package leetcode.editor.cn;


import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class B_LruCache {
    public static void main(String[] args) {
        LRUCache cache = new B_LruCache().new LRUCache(2);
        cache.put(1, 5);
        cache.put(2, 2);
        cache.get(1);
        cache.put(3, 3);
        cache.get(2);
        cache.put(4, 4);
        System.out.println(cache.get(1));
        cache.get(3);
        cache.get(4);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class LRUCache {
        ListNode dummyHead;
        ListNode dummyTail;
        int capacity;
        int size;
        Map<Integer, ListNode> map;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            dummyHead = new ListNode();
            dummyTail = new ListNode();
            dummyHead.next = dummyTail;
            dummyTail.pre = dummyHead;
            map = new HashMap<>();
        }

        public int get(int key) {
            if (!map.containsKey(key)) {
                return -1;
            }
            ListNode node = map.get(key);
            int value = node.val;
            //将该节点移动到链表头部
            moveToHead(node);
            return value;
        }

        public void put(int key, int value) {
            if (!map.containsKey(key)) {
                if (size == capacity) {
                    //删除尾节点
                    ListNode tail = dummyTail.pre;
                    //删除key
                    map.remove(tail.key);
                    removeNode(tail);
                    size--;
                }
                //添加节点到头部
                ListNode node = new ListNode();
                node.key = key;
                node.val = value;
                node.pre = dummyHead;
                node.next = dummyHead.next;
                dummyHead.next = node;
                node.next.pre = node;
                size++;
                map.put(key, node);
            } else {
                ListNode node = map.get(key);
                node.val = value;
                //移动到头部
                moveToHead(node);
            }
        }

        private void moveToHead(ListNode node) {
            removeNode(node);
            node.next = dummyHead.next;
            node.pre = dummyHead;
            dummyHead.next = node;
            node.next.pre = node;
        }

        private void removeNode(ListNode node) {
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }

        class ListNode {
            int key;
            int val;
            ListNode next;
            ListNode pre;
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