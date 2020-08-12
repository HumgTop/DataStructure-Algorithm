package top.humg.ds03_linkedList.singleLinkedList;

/**
 * 单链表
 */
public class SingleLinkedList2 {
    //先初始化一个头结点：不存放具体的数据
    private HeroNode headNode = new HeroNode(0, "", "", null);

    /**
     * 将newNode节点按照编号添加到链表的对应位置，如果该编号已存在则添加失败给出提示。
     *
     * @param newNode 新的链表节点
     */
    public void add(HeroNode newNode) {
        HeroNode temp = headNode;   //引用传递，变量名temp和headNode指向同一个内存空间
        //如果temp的下个节点不为空，与其比较大小。如果编号小于下个节点则插入。则将temp节点后移。退出循环时，temp指向链表中的最后一个节点
        while (temp.next != null && newNode.no > temp.next.no) {
            temp = temp.next;
        }

        //如果该节点已经存在于链表中，抛出异常和提示信息
        if (temp.next != null && newNode.no == temp.next.no) {
            throw new RuntimeException("该编号已存在于链表中");
        }

        //如果新节点在链表中段插入
        if (temp.next != null) {
            HeroNode temp1 = temp.next; //暂存下个节点
            temp.next = newNode;    //将新节点插入中间
            temp.next.next = temp1; //新节点的next域指向下个节点
        } else {
            //新节点在链表末尾插入
            temp.next = newNode;
        }
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
