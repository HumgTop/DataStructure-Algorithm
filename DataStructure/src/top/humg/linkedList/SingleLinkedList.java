package top.humg.linkedList;

/**
 * 单链表
 */
public class SingleLinkedList {
    //先初始化一个头结点：不存放具体的数据
    private HeroNode headNode = new HeroNode(0, "", "", null);

    /**
     * 将newNode节点添加到链表的末尾
     *
     * @param newNode 新的链表节点
     */
    public void add(HeroNode newNode) {
        //引用传递，变量名temp和headNode指向同一个内存空间
        HeroNode temp = headNode;
        //如果temp的下个节点不为空，则将temp节点后移。退出循环时，temp指向链表中的最后一个节点
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    /**
     * 显示链表：对链表进行遍历
     */
    public void list() {
        HeroNode temp = headNode.next;
        //如果链表为空
        if (temp == null) {
            System.out.println("此链表为空");
            return;
        }

        while (temp != null) {
            System.out.println(temp);
            temp = temp.next;
        }
    }
}
