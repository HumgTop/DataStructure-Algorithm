package top.humg.ds06_tree.binarySortTree;

/**
 * 二叉排序树的节点类
 * 为了使用了Collections的sort方法对权值进行排序，实现Comparable接口并重写compareTo方法
 */
public class Node implements Comparable<Node> {
    int value;  //节点权值
    Node left;  //左子节点
    Node right; //右子节点

    public Node(int value) {
        this.value = value;
    }

    /**
     * 按照二叉排序树的规则，将 node 添加到调用此方法的对象节点上
     *
     * @param node
     */
    public void add(Node node) {
        if (node.value <= this.value) {
            if (this.left == null) {
                this.left = node;
            } else
                //向左递归
                this.left.add(node);
        } else {
            //如果node.value>this.value
            if (this.right == null) {
                this.right = node;
            } else
                //向右递归
                this.right.add(node);
        }
    }

    /**
     * 根据 value 查找节点并返回
     *
     * @param value
     * @return 返回所查找的节点
     */
    public Node search(int value) {
        if (this.value == value) {
            return this;
        }
        //左递归查询
        if (this.left != null) {
            Node leftResult = this.left.search(value);
            if (leftResult != null) {
                return leftResult;
            }
        }
        if (this.right != null) {
            //右递归查询
            return this.right.search(value);
        }
        //如果在左侧递归到最后一个叶子节点时，若仍未找到节点，返回null回到上一层，向右侧继续查找
        return null;
    }

    /**
     * 查找权值为 value 的节点的父节点
     * root节点调用此方法将返回null
     *
     * @param value
     * @return
     */
    public Node searchParent(int value) {
        if (this.left != null) {
            if (this.left.value == value) {
                return this;
            }
            //在左侧递归查找
            Node leftResult = this.left.searchParent(value);
            if (leftResult != null) {
                return leftResult;
            }
        }
        //如果左侧没有找到的话，在右侧查找
        if (this.right != null) {
            if (this.right.value == value) {
                return this;
            }
            return this.right.searchParent(value);
        }
        //当递归到叶子节点时仍未找到
        return null;
    }

    /**
     * 删除节点
     * 本方法不能处理root节点
     *
     * @param value
     */
    public void delNode(int value) {
        //先找到需删除的目标节点
        Node target = search(value);
        //如果没有找到target直接return
        if (target == null) {
            return;
        }
        //如果存在target节点，找到target的父节点
        Node parent = searchParent(value);

        //如果target是一个叶子节点
        if (target.left == null && target.right == null) {
            if (parent.left == target) {
                parent.left = null;
            } else
                parent.right = null;
        }

        //如果target是有一棵子树的节点
        if (target.left != null && target.right == null) {
            if (parent.left == target) {
                parent.left = target.left;
            } else
                parent.right = target.left;
        } else if (target.left == null && target.right != null) {
            if (parent.left == target) {
                parent.left = target.right; //不会导致违背二叉排序树的规则，因为target.right<parent.left是必然的（否则违背了二叉排序树的规则）
            } else
                parent.right = target.right;
        }

        //如果target是有2棵子树的节点，将target上右子树最小的节点（或者左子树上最大的节点）移动到target的位置
        if (target.right != null && target.left != null) {
            Node rightMin = target.right;
            while (rightMin.left != null) {
                rightMin = rightMin.left;
            }
            //删除rightMin
            delNode(rightMin.value);    //rightMin为叶子节点或者一棵右子树的节点，故只会递归一次
            //此时rightMin.left=null，rightMin的权值已经是右子树上最小的。修改target的权值
            target.value = rightMin.value;
        }
    }

    @Override
    public String toString() {
        if (left != null && right == null) {
            return "Node{" +
                    "value=" + value +
                    ", left=" + left.value +
                    ", right=null" +
                    '}';
        } else if (right != null && left == null) {
            return "Node{" +
                    "value=" + value +
                    ", left=null" +
                    ", right=" + right.value +
                    '}';
        } else if (left != null) {
            return "Node{" +
                    "value=" + value +
                    ", left=" + left.value +
                    ", right=" + right.value +
                    '}';
        } else {
            return "Node{" +
                    "value=" + value +
                    ", left=null" +
                    ", right=null" +
                    '}';
        }
    }

    @Override
    public int compareTo(Node o) {
        return this.value - o.value;  //表示升序（从小到大）
    }

    /**
     * 前序遍历
     */
    public void preOrder() {
        System.out.println(this);
        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    /**
     * 中序遍历
     */
    public void infixOrder() {
        if (this.left != null) {
            this.left.infixOrder();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.infixOrder();
        }
    }
}
