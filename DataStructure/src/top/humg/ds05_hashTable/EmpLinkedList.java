package top.humg.ds05_hashTable;

/**
 * 模拟链表
 */
public class EmpLinkedList {
    private Employee head;

    public Employee getHead() {
        return head;
    }

    public void setHead(Employee head) {
        this.head = head;
    }

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
     *
     * @param i
     */
    public void list(int i) {
        if (head == null) {
            System.out.printf("链表[%d]为空%n", i);
        } else {
            Employee cur = head;
            while (true) {
                System.out.println(cur);
                if (cur.next == null) {
                    break;
                }
                cur = cur.next;
            }
        }
    }
}
