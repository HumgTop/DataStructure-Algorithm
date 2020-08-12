package top.humg.ds03_linkedList.doubleLinkedList;

import org.junit.Test;

public class MyDemo {
    /**
     * 测试双向链表的基本方法
     */
    @Test
    public void test1() {
        HeroNode node1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode node2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode node3 = new HeroNode(3, "吴用", "智多星");
        HeroNode node4 = new HeroNode(4, "林冲", "豹子头");
        HeroNode node5 = new HeroNode(5, "胡民港", "码农");

        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        //测试添加方法
        doubleLinkedList.add(node1);
        doubleLinkedList.add(node2);
        doubleLinkedList.add(node3);
        doubleLinkedList.add(node4);
        doubleLinkedList.add(node5);

        //测试遍历打印方法
        doubleLinkedList.list();

        //测试update方法
        doubleLinkedList.update(new HeroNode(3, "艾伦", "八一"));
        System.out.println("-----------");
        doubleLinkedList.list();

        //测试删除方法
        doubleLinkedList.del(5);
        System.out.println("----------");
        doubleLinkedList.list();
    }

    /**
     * 测试 addInOrder方法
     */
    @Test
    public void test2() {
        HeroNode node1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode node2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode node3 = new HeroNode(3, "吴用", "智多星");
        HeroNode node4 = new HeroNode(4, "林冲", "豹子头");
        HeroNode node5 = new HeroNode(5, "胡民港", "码农");

        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();

        //测试添加方法
        doubleLinkedList.addInOrder(node2);
        doubleLinkedList.addInOrder(node5);
        doubleLinkedList.addInOrder(node4);
        doubleLinkedList.addInOrder(node3);
        doubleLinkedList.addInOrder(node1);

        doubleLinkedList.list();
    }
}
