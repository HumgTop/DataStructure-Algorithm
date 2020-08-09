package top.humg.a03_linkedList.circleLinkedList;

import org.junit.Test;

import java.lang.reflect.Constructor;

public class MyDemo {
    /**
     * 测试环形链表的基本方法
     */
    @Test
    public void test1() {
        Boy node1 = new Boy(1);
        Boy node2 = new Boy(2);
        Boy node3 = new Boy(3);
        Boy node4 = new Boy(4);
        Boy node5 = new Boy(5);

        CircleLinkedList circleLinkedList = new CircleLinkedList();

        //测试添加方法
        circleLinkedList.add(node1);
        circleLinkedList.add(node2);
        circleLinkedList.add(node3);
        circleLinkedList.add(node4);
        circleLinkedList.add(node5);

        //测试遍历打印方法
        circleLinkedList.list();
    }

    /**
     * 约瑟夫问题：小孩出圈
     * n=5：有5个人
     * k=1：从编号为k的男孩开始报数
     * m=5：数到2出列
     * 返回出列编号
     */
    @Test
    public void test2() {
        Boy node1 = new Boy(1);
        Boy node2 = new Boy(2);
        Boy node3 = new Boy(3);
        Boy node4 = new Boy(4);
        Boy node5 = new Boy(5);

        CircleLinkedList circleLinkedList = new CircleLinkedList();

        //测试添加方法
        circleLinkedList.add(node1);
        circleLinkedList.add(node2);
        circleLinkedList.add(node3);
        circleLinkedList.add(node4);
        circleLinkedList.add(node5);

        //测试遍历打印方法
        circleLinkedList.list();

        int k = 2;  //起始编号为2
        int m = 2;    //数2下出列
        //定义current变量，将其移动指向编号为k的节点
        Boy first = circleLinkedList.getFirst();
        Boy current = first;
        //如果current还没有指向末尾，则向后遍历
        while (current.getNext() != first) {
            if (current.getNo() == k) {
                break;
            }
            current = current.getNext();  //  current指向后移
        }
        //此时的current指向起始报数的节点
        System.out.println(current.getNo());
        System.out.println("--------------");
        while (true) {
            Boy temp = current;   //记录初始current
            for (int i = 0; i < m - 1; i++) {
                current = current.getNext();  //current后移m次
            }
            System.out.printf("编号为%d节点出列%n", current.getNo());
            temp.setNext(current.getNext());    //将出列节点断开链接
            current = current.getNext();  //current指向出列节点的下一位

            if (current.getNext() == current) {
                System.out.printf("编号为%d节点出列%n", current.getNo());
                circleLinkedList.setFirst(null); //将最后一个节点设置为头节点
                break;
            }
        }
        circleLinkedList.list();
    }
}
