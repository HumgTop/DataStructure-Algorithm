package top.humg.ds03_linkedList.doubleLinkedList;


public class DoubleLinkedList {
    //先初始化一个头结点：不存放具体的数据
    private HeroNode headNode = new HeroNode(0, "", "", null, null);

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
        //将新节点在链表中建立链接
        temp.next = newNode;
        newNode.pre = temp;
    }

    /**
     * 将newNode节点按照编号顺序添加到链表的末尾
     *
     * @param newNode 新的链表节点
     */
    public void addInOrder(HeroNode newNode) {
        HeroNode temp = headNode;   //引用传递，变量名temp和headNode指向同一个内存空间
        //如果temp的下个节点不为空，则将temp节点后移。退出循环时，temp指向链表中的最后一个节点
        while (temp != null) {
            try {
                //如果遍历到末尾节点，temp.next会产生空指针异常
                if (newNode.no > temp.no && newNode.no < temp.next.no) {
                    //修改新节点自身的next和pre域
                    newNode.pre = temp;
                    newNode.next = temp.next;
                    //修改前后节点的next和pre域
                    temp.next = newNode;
                    temp.next.pre = newNode;
                    return;
                }
            } catch (NullPointerException e) {
                e.printStackTrace();
                assert newNode != null;
                //如果添加的是链表的末尾节点（包括第一个节点）
                if (newNode.no > temp.no) {
                    //修改新节点自身的next和pre域
                    newNode.pre = temp;
                    newNode.next = null;
                    //修改前节点的next
                    temp.next = newNode;
                    return;
                } else {
                    //修改新节点自身的next和pre域
                    newNode.pre = temp.pre;
                    newNode.next = temp;
                    //修改后节点的pre
                    temp.pre = newNode;
                    return;
                }
            }
            temp = temp.next;   //temp指向后移
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

    /**
     * 更新节点信息
     *
     * @param newHeroNode
     */
    public void update(HeroNode newHeroNode) {
        HeroNode temp = headNode.next;
        //遍历链表直到末尾
        while (temp != null) {
            if (temp.no == newHeroNode.no) {
                newHeroNode.pre = temp.pre;
                newHeroNode.next = temp.next;
                temp.name = newHeroNode.name;
                temp.nickName = newHeroNode.nickName;
                return;
            }
            temp = temp.next;   //temp指向下个节点
        }

        System.out.println("未找到节点，信息未更新");
    }

    /**
     * 根据编号删除节点
     *
     * @param no
     */
    public void del(int no) {
        HeroNode temp = headNode.next;  //temp指向链表第一个节点
        //遍历链表直到末尾
        while (temp != null) {
            if (temp.no == no) {
                try {
                    //断开temp在链表中的连接，因为没有任何引用指向该节点，会被jvm垃圾回收机制回收
                    temp.next.pre = temp.pre;   //如果temp.next=null，会产生空指针异常
                    temp.pre.next = temp.next;
                } catch (Exception e) {
                    //如果删除链表最后一个节点
                    e.printStackTrace();
                    temp.pre.next = null;
                }
                return;
            }
            temp = temp.next;   //temp指向后移
        }
        System.out.println("未删除节点");
    }
}
