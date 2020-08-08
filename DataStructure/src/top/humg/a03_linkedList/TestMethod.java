package top.humg.a03_linkedList;

import org.junit.Test;

import java.util.Stack;

public class TestMethod {
    @Test
    public void test1() {
        HeroNode node1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode node2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode node3 = new HeroNode(3, "吴用", "智多星");
        HeroNode node4 = new HeroNode(4, "林冲", "豹子头");
        HeroNode node5 = new HeroNode(4, "胡民港", "码农");

        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.add(node1);
        singleLinkedList.add(node2);
        singleLinkedList.add(node4);
        singleLinkedList.add(node3);

        singleLinkedList.list();

        System.out.println("-------------");
//        singleLinkedList.update(node5);
//        singleLinkedList.list();

        singleLinkedList.del(3);
        singleLinkedList.del(2);
        singleLinkedList.del(1);
        singleLinkedList.del(4);
        singleLinkedList.list();
    }

    @Test
    public void test2() {
        HeroNode node1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode node2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode node3 = new HeroNode(3, "吴用", "智多星");
        HeroNode node4 = new HeroNode(4, "林冲", "豹子头");

        SingleLinkedList2 singleLinkedList2 = new SingleLinkedList2();
        try {
            singleLinkedList2.add(node1);
            singleLinkedList2.add(node4);
            singleLinkedList2.add(node3);
            singleLinkedList2.add(node2);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            singleLinkedList2.list();
        }
    }

    /**
     * 获取链表的有效节点数（头结点不统计）
     *
     * @param singleLinkedList
     * @return
     */
    public int getNodeNum(SingleLinkedList singleLinkedList) {
        if (singleLinkedList.getHeadNode().next == null) {
            return 0;
        }

        //temp指向head节点的下个节点
        HeroNode temp = singleLinkedList.getHeadNode().next;

        int count = 0;
        while (temp != null) {
            count++;//计数
            temp = temp.next;
        }
        return count;
    }

    /**
     * 测试求单链表中有效节点的个数
     */
    @Test
    public void test3() {
        HeroNode node1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode node2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode node3 = new HeroNode(3, "吴用", "智多星");
        HeroNode node4 = new HeroNode(4, "林冲", "豹子头");
        HeroNode node5 = new HeroNode(5, "林冲", "豹子头");

        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.add(node1);
        singleLinkedList.add(node2);
        singleLinkedList.add(node4);
        singleLinkedList.add(node3);
        singleLinkedList.add(node5);

        singleLinkedList.list();

        System.out.println(getNodeNum(singleLinkedList));
    }

    /**
     * 查找单链表的倒数第k个节点
     */
    public HeroNode getLastNode(int k, SingleLinkedList singleLinkedList) {
        //1 先获取该链表的有效节点数
        int nodeNum = getNodeNum(singleLinkedList);

        //2 正向遍历第（nodeNum-k+1)次时，返回该节点
        //temp指向head节点的下个节点
        HeroNode temp = singleLinkedList.getHeadNode();

        //我的想法
//        int count = 0;
//        while (temp != null) {
//            count++;//计数
//            if (count == nodeNum - k + 1) {
//                return temp;
//            }
//            temp = temp.next;
//        }

        try {
            for (int i = 0; i < nodeNum - k + 1; i++) {
                temp = temp.next;
            }
            return temp;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("查无此节点");
        }
    }

    /**
     * 查找单链表的倒数第k个节点
     */
    @Test
    public void test4() {
        HeroNode node1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode node2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode node3 = new HeroNode(3, "吴用", "智多星");
        HeroNode node4 = new HeroNode(4, "林冲", "豹子头");
        HeroNode node5 = new HeroNode(5, "林冲", "豹子头");

        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.add(node1);
        singleLinkedList.add(node2);
        singleLinkedList.add(node4);
        singleLinkedList.add(node3);
        singleLinkedList.add(node5);

        singleLinkedList.list();
        System.out.println("------------");
        HeroNode lastNode = getLastNode(5, singleLinkedList);
        System.out.println(lastNode);
    }

    /**
     * 单链表反转
     */
    @Test
    public void test5() {
        HeroNode node1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode node2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode node3 = new HeroNode(3, "吴用", "智多星");
        HeroNode node4 = new HeroNode(4, "林冲", "豹子头");
        HeroNode node5 = new HeroNode(5, "胡民港", "騎鯨捉月");

        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.add(node1);
        singleLinkedList.add(node2);
        singleLinkedList.add(node3);
        singleLinkedList.add(node4);
        singleLinkedList.add(node5);

        singleLinkedList.list();
        System.out.println("------------");
        //单链表反转
        HeroNode cur = singleLinkedList.getHeadNode().next;
        HeroNode next = null;//记录当前节点的下一个节点
        //反转链表的头结点
        HeroNode reverseHead = new HeroNode();
        while (cur != null) {
            next = cur.next;
            cur.next = reverseHead.next;//将当前节点的next域指向反转链表的第一个节点
            reverseHead.next = cur;//将当前节点插入反转链表的最前端
            cur = next;//向后遍历
        }
        singleLinkedList.getHeadNode().next = reverseHead.next;//head节点指向反转链表
        singleLinkedList.list();
    }

    /**
     * 从尾到头打印单链表
     */
    @Test
    public void test6() {
        HeroNode node1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode node2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode node3 = new HeroNode(3, "吴用", "智多星");
        HeroNode node4 = new HeroNode(4, "林冲", "豹子头");
        HeroNode node5 = new HeroNode(5, "胡民港", "騎鯨捉月");

        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.add(node1);
        singleLinkedList.add(node2);
        singleLinkedList.add(node3);
        singleLinkedList.add(node4);
        singleLinkedList.add(node5);
        singleLinkedList.list();
        System.out.println("------------");

        Stack<HeroNode> nodeStack = new Stack<>();
        //遍历链表
        HeroNode cur = singleLinkedList.getHeadNode().next;
        while (cur != null) {
            //节点进栈
            nodeStack.add(cur);
            cur = cur.next;//cur指向后移
        }
        //节点出栈并打印
        while (!nodeStack.isEmpty()) {
            System.out.println(nodeStack.pop());
        }
        System.out.println("-----------");
        //逆序打印使用栈空间暂存了数据，并没有改变链表的结构
        singleLinkedList.list();
    }

    /**
     * 合并两个有序的单链表， 合并之后的链表依然有序【课后练习.】
     */
    @Test
    public void test7() {
        HeroNode node1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode node2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode node3 = new HeroNode(3, "吴用", "智多星");
        HeroNode node4 = new HeroNode(4, "林冲", "豹子头");
        HeroNode node5 = new HeroNode(5, "胡民港", "騎鯨捉月");
        HeroNode node6 = new HeroNode(6, "合肥工业大学", "合工大");
        HeroNode node7 = new HeroNode(7, "华中科技大学", "华科");
        HeroNode node8 = new HeroNode(8, "重庆大学", "重大");

        //链表1
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.add(node1);

        singleLinkedList.add(node6);
        singleLinkedList.add(node7);
        singleLinkedList.list();
        System.out.println("------------");

        //链表2
        SingleLinkedList singleLinkedList2 = new SingleLinkedList();
        singleLinkedList2.add(node2);
        singleLinkedList2.add(node3);
        singleLinkedList2.add(node4);
        singleLinkedList2.add(node5);
        singleLinkedList2.add(node8);
        singleLinkedList2.list();
        System.out.println("------------");

        //得到2个链表的有效节点数
        int nodeNum = getNodeNum(singleLinkedList);
        int nodeNum2 = getNodeNum(singleLinkedList2);
        SingleLinkedList longList = nodeNum >= nodeNum2 ? singleLinkedList : singleLinkedList2;
        SingleLinkedList shortList = nodeNum < nodeNum2 ? singleLinkedList : singleLinkedList2;

        //遍历长链表
        HeroNode longHead = longList.getHeadNode();//拿到长链表的头节点
        HeroNode shortHead = shortList.getHeadNode();//拿到短链表的头节点
        HeroNode longCur = longHead.next;
        HeroNode shortCur = shortHead.next;
        while (longCur != null && shortCur != null) {

            if (shortCur.no > longCur.no && longCur.next == null) {
                longCur.next = shortCur;
                continue;
            }

            if (shortCur.no > longCur.no && shortCur.no < longCur.next.no) {
                HeroNode longNext = longCur.next;
                HeroNode shortNext = shortCur.next;
                //插入shortCur节点到长链表中
                longCur.next = shortCur;
                shortCur.next = longNext;

                longCur = longNext;
                shortCur = shortNext;
                continue;
            }


            longCur = longCur.next;//cur指向后移
        }

        longList.list();
    }
}
