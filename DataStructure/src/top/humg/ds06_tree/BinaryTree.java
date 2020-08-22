package top.humg.ds06_tree;

/**
 * 二叉树
 */
public class BinaryTree {
    private HeroNode root;  //二叉树的根节点

    public void setRoot(HeroNode root) {
        this.root = root;
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
