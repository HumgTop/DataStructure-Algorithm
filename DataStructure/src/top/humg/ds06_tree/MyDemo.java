package top.humg.ds06_tree;

import org.junit.Test;
import top.humg.ds06_tree.threadedBinaryTree.ThreadedBinaryTree;

public class MyDemo {
    //测试遍历方法
    @Test
    public void test1() {
        BinaryTree tree = new BinaryTree();
        HeroNode root = new HeroNode(1, "宋江");
        HeroNode node2 = new HeroNode(2, "吴用");
        HeroNode node3 = new HeroNode(3, "卢俊义");
        HeroNode node4 = new HeroNode(4, "林冲");
        HeroNode node5 = new HeroNode(5, "关胜");

        node3.setLeft(node4);
        node3.setRight(node5);
        root.setLeft(node2);
        root.setRight(node3);
        tree.setRoot(root);

        tree.infixOrder();
    }

    //测试查找方法
    @Test
    public void test2() {
        BinaryTree tree = new BinaryTree();
        HeroNode root = new HeroNode(1, "宋江");
        HeroNode node2 = new HeroNode(2, "吴用");
        HeroNode node3 = new HeroNode(3, "卢俊义");
        HeroNode node4 = new HeroNode(4, "林冲");
        HeroNode node5 = new HeroNode(5, "关胜");

        node3.setLeft(node4);
        node3.setRight(node5);
        root.setLeft(node2);
        root.setRight(node3);
        tree.setRoot(root);
        tree.preOrder();
        System.out.println("--------------");
        System.out.println(tree.preFind(5));
    }

    /**
     * 测试删除方法
     */
    @Test
    public void test3() {
        BinaryTree tree = new BinaryTree();
        HeroNode root = new HeroNode(1, "宋江");
        HeroNode node2 = new HeroNode(2, "吴用");
        HeroNode node3 = new HeroNode(3, "卢俊义");
        HeroNode node4 = new HeroNode(4, "林冲");
        HeroNode node5 = new HeroNode(5, "关胜");

        node3.setLeft(node4);
        node3.setRight(node5);
        root.setLeft(node2);
        root.setRight(node3);
        tree.setRoot(root);
        tree.preOrder();
        System.out.println("--------------");

        tree.myDel(3);

        tree.preOrder();
    }

    /**
     * 测试网课demo删除方法
     */
    @Test
    public void test4() {
        BinaryTree tree = new BinaryTree();
        HeroNode root = new HeroNode(1, "宋江");
        HeroNode node2 = new HeroNode(2, "吴用");
        HeroNode node3 = new HeroNode(3, "卢俊义");
        HeroNode node4 = new HeroNode(4, "林冲");
        HeroNode node5 = new HeroNode(5, "关胜");

        node3.setLeft(node4);
        node3.setRight(node5);
        root.setLeft(node2);
        root.setRight(node3);
        tree.setRoot(root);
        tree.preOrder();
        System.out.println("--------------");

        tree.del(4);

        tree.preOrder();
    }

    /**
     * 测试中序线索化方法
     */
    @Test
    public void test5() {
        ThreadedBinaryTree tree = new ThreadedBinaryTree();
        HeroNode root = new HeroNode(1, "宋江");
        HeroNode node2 = new HeroNode(2, "吴用");
        HeroNode node3 = new HeroNode(3, "卢俊义");
        HeroNode node4 = new HeroNode(4, "林冲");
        HeroNode node5 = new HeroNode(5, "关胜");

        node3.setLeft(node4);
        node3.setRight(node5);
        root.setLeft(node2);
        root.setRight(node3);
        tree.setRoot(root);
        tree.infixOrder();
        System.out.println("--------------");

        tree.threadedNodes(root);
        tree.threadInfixOrder();    //2,1,4,3,5
    }
}
