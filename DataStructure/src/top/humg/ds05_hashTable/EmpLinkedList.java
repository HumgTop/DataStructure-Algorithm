package top.humg.ds05_hashTable;

/**
 * 模拟链表
 */
public class EmpLinkedList {
    private Employee head;

    /*
    假定添加雇员时，id是自增的
     */
    public void add(Employee employee) {
        if (head == null) {
            head = employee;
        } else {
            Employee cur = head;
            //找到链表最后一个节点
            while (cur.next != null) {
                cur = cur.next;
            }
            //此时temp.next==null
            cur.next = employee;
        }
    }

    /**
     * 遍历链表
     */
    public void list() {
        if (head == null) {
            throw new RuntimeException("链表为空");
        }

        Employee cur = head;
        while (cur.next != null) {
            System.out.println(cur);
            cur = cur.next;
        }
    }
}
