package top.humg.ds03_linkedList.doubleLinkedList;

/**
 * 双链表节点类
 */
public class HeroNode {
    int no;
    String name;
    String nickName;
    HeroNode pre;//保存前一个节点
    HeroNode next;//保存后一个节点

    public HeroNode() {
    }

    public HeroNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    public HeroNode(int no, String name, String nickName, HeroNode pre, HeroNode next) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
        this.pre = pre;
        this.next = next;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public HeroNode getPre() {
        return pre;
    }

    public void setPre(HeroNode pre) {
        this.pre = pre;
    }

    public HeroNode getNext() {
        return next;
    }

    public void setNext(HeroNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        if (next == null) {
            return "HeroNode{" +
                    "no=" + no +
                    ", name='" + name + '\'' +
                    ", nickName='" + nickName + '\'' +
                    ", pre='" + pre.no + '\'' +
                    ", next='" + null + '\'' +
                    '}';
        }

        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                ", pre='" + pre.no + '\'' +
                ", next='" + next.no + '\'' + //打印最后一个节点时，由于next域为null，所以会产生空指针异常
                '}';
    }
}
