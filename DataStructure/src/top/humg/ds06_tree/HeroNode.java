package top.humg.ds06_tree;

/**
 * 模拟二叉树节点
 */
public class HeroNode {
    private int no;
    private String name;
    private HeroNode left;
    private HeroNode right;
    //如果为0说明指向正常的子树，如果为1说明指向前驱节点
    private int leftType = 0;
    private int rightType = 0;

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
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

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
    }

    @Override
    public String toString() {
        if (left != null && right != null) {
            return "HeroNode{" +
                    "no=" + no +
                    ", name='" + name + '\'' +
                    ", left=" + left.no +
                    ", right=" + right.no +
                    '}';
        } else if (left == null && right != null) {
            return "HeroNode{" +
                    "no=" + no +
                    ", name='" + name + '\'' +
                    ", left=null" +
                    ", right=" + right.no +
                    '}';
        } else if (left != null) {
            return "HeroNode{" +
                    "no=" + no +
                    ", name='" + name + '\'' +
                    ", left=" + left.no +
                    ", right=null" +
                    '}';
        } else {
            return "HeroNode{" +
                    "no=" + no +
                    ", name='" + name + '\'' +
                    ", left=null" +
                    ", right=null" +
                    '}';
        }
    }

    /**
     * 前序遍历
     */
    public void preOrder() {
        System.out.println(this);   //先输出父节点
        //向左子树递归遍历
        if (this.left != null) {
            this.left.preOrder();
        }
        //向右子树递归遍历
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    /**
     * 中序遍历
     */
    public void infixOrder() {
        //向左子树递归遍历
        if (this.left != null) {
            this.left.infixOrder();
        }
        System.out.println(this);   //输出父节点
        //向右子树递归遍历
        if (this.right != null) {
            this.right.infixOrder();
        }
    }

    /**
     * 后序遍历
     */
    public void postOrder() {
        //向左子树递归遍历
        if (this.left != null) {
            this.left.postOrder();
        }
        //向右子树递归遍历
        if (this.right != null) {
            this.right.postOrder();
        }
        System.out.println(this);   //输出父节点
    }

    //前序查找
    public HeroNode preFind(int no) {
        if (this.no == no) {
            return this;
        }
        if (this.left != null) {
            //先左递归查找
            HeroNode left = this.left.preFind(no);
            if (left != null) {
                return left;
            } else {
                //右递归查找
                if (this.right != null) {
                    return this.right.preFind(no);
                }
            }
        }
        //设置递归头 即this.left==null时，二叉树遍历完毕仍未找到节点返回null
        return null;
    }

    /**
     * 删除节点
     * 1.叶子节点：直接删除
     * 2.非叶子节点：删除子树
     */
    public boolean myDel(int no) {
        //** 本方法无法删除root节点，需要在外部操作
        //先找到所删除节点的父节点
        boolean flag;
        //如果左子节点不为空
        if (this.left != null) {
            if (this.left.no == no) {
                this.left = null;
                return true;
            } else {
                //向左递归查找删除
                try {
                    //try中的代码一旦发生异常，剩余的代码不再执行
                    this.left.myDel(no);  //如果成功删除，flag==true。否则flag=false
                    flag = true;
                } catch (Exception e) {
                    flag = false;
                }
                //如果删除成功则返回true
                if (flag) {
                    return true;
                }
            }
        }

        //如果左递归没有完成删除
        if (this.right != null) {
            if (this.right.no == no) {
                this.right = null;
                return true;
            } else {
                //右递归删除
                return this.right.myDel(no);
            }
        }

        //递归到每个叶子节点时，若仍未找到节点，抛出异常回到上一层，被catch处理后向右侧继续查找
        //** 若递归到最后一个叶子节点仍未找到需删除的节点，此时抛出的异常没有被catch处理，直接打印在控制台
        throw new RuntimeException("此节点不存在");
    }

    /**
     * 网课demo
     * 删除节点方法
     *
     * @param no
     */
    public void del(int no) {
        if (this.left != null && this.left.no == no) {
            this.left = null;
            //此处不应return，否则左子树没有删除到节点return的话，无法进行右子树的删除操作
        }

        if (this.right != null && this.right.no == no) {
            this.right = null;
            return;
        }

        //向左子树递归
        if (this.left != null) {
            this.left.del(no);
        }
        //向右子树递归
        if (this.right != null) {
            this.right.del(no);
        }
    }
}
