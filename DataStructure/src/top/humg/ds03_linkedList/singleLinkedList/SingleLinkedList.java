package top.humg.ds03_linkedList.singleLinkedList;

/**
 * 单链表
 */
public class SingleLinkedList {
    //先初始化一个头结点：不存放具体的数据
    private HeroNode headNode = new HeroNode(0, "", "", null);

    public HeroNode getHeadNode() {
        return headNode;
    }

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

    //更新节点信息
    public void update(HeroNode newHeroNode) {
        HeroNode temp = headNode;
        //遍历链表直到末尾
        while (temp.next != null) {
            if (temp.no == newHeroNode.no) {
                temp.name = newHeroNode.name;
                temp.nickName = newHeroNode.nickName;
                break;
            }
            temp = temp.next;//temp指向下个节点
        }
    }

    //根据编号删除节点
    public void del(int no) {
        HeroNode temp = headNode;
        //遍历链表直到末尾
        while (temp.next != null) {
            HeroNode before = temp;//暂存temp指向的节点
            temp = temp.next;//temp指向下个节点
            if (temp.no == no) {
                //断开temp在链表中的连接，因为没有任何引用指向该节点，会被jvm垃圾回收机制回收
                before.next = temp.next;
            }

        }
    }

}
