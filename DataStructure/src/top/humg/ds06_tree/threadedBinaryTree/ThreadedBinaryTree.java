package top.humg.ds06_tree.threadedBinaryTree;

import top.humg.ds06_tree.HeroNode;

/**
 * 实现了线索化功能的二叉树
 */
public class ThreadedBinaryTree {
    private HeroNode root;  //二叉树的根节点
    private HeroNode pre;   //为了实现线索化，需要创建指向当前节点的前驱节点的指针

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    /**
     * 编写对二叉树进行中序线索化的方法
     * ！！线索化后，原有的遍历方法不再起作用，需要重写遍历方法
     *
     * @param node
     */
    public void threadedNodes(HeroNode node) {
        //递归头，return时说明回溯到叶子节点
        if (node == null) {
            return;
        }

        //先线索化左子树
        threadedNodes(node.getLeft());

        //** 线索化当前节点
        //设置当前节点的前驱节点
        if (node.getLeft() == null) {
            //将当前节点的左指针指向前驱节点（最左侧的叶子节点没有前驱节点，所以左指针指向null）
            node.setLeft(pre);
            //修改当前节点的左指针类型
            node.setLeftType(1);
        }
        //设置上个节点的后继节点
        //pre=null时也是在处理第一个节点，前面没有节点，所以无需设置后继节点
        if (pre != null && pre.getRight() == null) {
            pre.setRight(node);
            pre.setRightType(1);
        }
        //当前节点处理完成后，pre指针后移
        pre = node;

        //线索化右子树
        threadedNodes(node.getRight());

    }

    //前序遍历
    public void preOrder() {
        if (root != null) {
            root.preOrder();
        }
    }

    //中序遍历
    public void infixOrder() {
        if (root != null) {
            root.infixOrder();
        }
    }

    /**
     * 线索化二叉树的中序遍历方法
     */
    public void threadInfixOrder() {
        HeroNode cur = root;
        while (cur != null) {
            //当Type为1时，说明该节点被线索化
            while (cur.getLeftType() == 0) {
                cur = cur.getLeft();
            }
            //此时找到第一个被线索化的节点
            System.out.println(cur);
            //如果cur节点的右指针指向后继节点的话，则持续输出
            while (cur.getRightType() == 1) {
                System.out.println(cur.getRight());
                cur = cur.getRight();
            }
            //如果没有被线索化则不打印
            cur = cur.getRight();
        }
    }

    //后序遍历
    public void postOrder() {
        if (root != null) {
            root.postOrder();
        }
    }

    //前序查找
    public HeroNode preFind(int no) {
        if (root != null) {
            return root.preFind(no);
        }

        throw new RuntimeException("未找到该节点");
    }

    //删除
    public void myDel(int no) {
        if (root != null) {
            //如果删除根节点的话
            if (root.getNo() == no) {
                setRoot(null);
            } else {
                root.myDel(no);
            }
        }
    }

    public void del(int no) {
        if (root != null) {
            if (root.getNo() == no) {
                setRoot(null);
            } else {
                root.del(no);
            }
        }
    }
}
