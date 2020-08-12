package top.humg.ds03_linkedList.circleLinkedList;

/**
 * 链表节点类
 */
public class Boy {
    private int no;
    private Boy next;

    public Boy() {
    }

    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }

    @Override
    public String toString() {
        try {
            return "Boy{" +
                    "no=" + no +
                    ", next=" + next.no +
                    '}';
        } catch (Exception e) {
            e.printStackTrace();
            return "Boy{" +
                    "no=" + no +
                    ", next=null" +
                    '}';
        }
    }
}
