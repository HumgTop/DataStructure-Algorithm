package top.humg.a03_linkedList.circleLinkedList;

/**
 * 环形单向链表
 */
public class CircleLinkedList {
    private Boy first = new Boy();    //创建头节点

    public Boy getFirst() {
        return first;
    }

    public void setFirst(Boy first) {
        this.first = first;
    }

    /**
     * 添加节点方法
     *
     * @param node
     */
    public void add(Boy node) {
        Boy current = first;  //  创建一个指向first的辅助变量
        //如果第一次插入
        if (first.getNo() == 0) {
            first = node;  //first指向node节点
            node.setNext(first);   //next域指向自己
            return;
        }
        //如果current还没有指向末尾，则向后遍历
        while (current.getNext() != first) {
            current = current.getNext();
        }
        //当current指向的下个节点为first时，说明处于链表尾部，此时添加节点
        current.setNext(node);
        node.setNext(first);
    }

    /**
     * 遍历环形链表并打印
     */
    public void list() {
        Boy current = first;  //  创建一个指向first的辅助变量
        //如果链表为空
        if (first == null || first.getNo() == 0) {
            System.out.println("链表为空");
            return;
        }
        //如果current还没有指向末尾，则向后遍历
        // !!如果链表内first指向的节点已经丢失，则变为死循环无限打印
        while (current.getNext() != first) {
            System.out.println(current);    //打印节点
            current = current.getNext();    //current指向后移
        }
        //当current指向的下个节点为first时，打印末尾节点
        System.out.println(current);
    }
}
