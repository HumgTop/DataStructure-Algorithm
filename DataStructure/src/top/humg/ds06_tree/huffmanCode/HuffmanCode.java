package top.humg.ds06_tree.huffmanCode;

import org.junit.Test;

import java.math.BigInteger;
import java.util.*;

/**
 * Huffman编码
 */
public class HuffmanCode {
    //key为Byte值，value为其对应的huffman编码
    static Map<Byte, String> huffmanCodes = new HashMap<>();

    /**
     * 对二叉树前序遍历
     *
     * @param root
     */
    public static void preOrder(Node root) {
        if (root != null) {
            root.preOrder();
        }
    }

    /**
     * 返回一个按权重值从小到大排列的 Node 集合
     *
     * @param bytes
     * @return
     */
    private static List<Node> getNodes(byte[] bytes) {
        ArrayList<Node> nodes = new ArrayList<>();

        //遍历bytes，统计每个ASCII码（key）出现的次数，存入value中
        HashMap<Byte, Integer> counts = new HashMap<>();
        for (byte key : bytes) {
            Integer count = counts.get(key);
            if (count == null) {
                //说明此key还未存入map中
                count = 1;
                counts.put(key, count);
            } else {
                //count++，再次存入
                counts.put(key, ++count);
            }
        }
        //把每个键值对作为构造参数创建 Node 对象，加入到nodes集合中
        Set<Byte> byteSet = counts.keySet();
        for (Byte data : byteSet) {
            Node node = new Node(data, counts.get(data));
            nodes.add(node);
        }
        return nodes;
    }

    /**
     * 将 nodes 集合中的元素构造为一棵 Huffman 树
     *
     * @param nodes
     * @return Huffman 树的 root 节点
     */
    private static Node createHuffmanTree(List<Node> nodes) {
        while (nodes.size() > 1) {
            Collections.sort(nodes);
            Node left = nodes.get(0);
            Node right = nodes.get(1);
            Node parent = new Node(left.weight + right.weight);
            parent.left = left;
            parent.right = right;

            nodes.remove(left);
            nodes.remove(right);
            nodes.add(parent);
        }
        return nodes.get(0);
    }

    /**
     * 得到传入的node节点的所有叶子节点的Huffman编码，存入Map集合(huffmanCodes)中
     *
     * @param node
     * @param sb   暂存路径数据，用于拼接路径，最后拼接完成后才是一个字符的完整 Huffman 编码
     * @return
     */
    private static void getCodes(Node node, String path, StringBuilder sb) {
        //*** 每一次递归传入sb2参数，都执行了sb=sb2的操作，会创建新的sb引用变量指向sb2指向的空间，所以操作的是不同的sb
        //*** 如果没有sb2，会导致sb（因为非基本数据类型传递的是引用地址，操作的还是同一个地址空间）一直append元素，无法获得正确的编码值
        StringBuilder stringBuilder2 = new StringBuilder(sb);
        //将 code 加入到 stringBuilder2
        //将path添加到sb2中
        stringBuilder2.append(path);
        if (node != null) { //如果 node == null 不处理
            //判断当前 node 是叶子结点还是非叶子结点
            if (node.data == 0) { //非叶子结点
                //递归处理
                //向左递归
                getCodes(node.left, "0", stringBuilder2);
                //向右递归
                getCodes(node.right, "1", stringBuilder2);
            } else { //说明是一个叶子结点
                //如果node是叶子节点，说明StringBuilder拼接完成。将其存入map集合中
                huffmanCodes.put(node.data, stringBuilder2.toString());
            }
        }
    }

    /**
     * 重载方法，简化调用
     *
     * @param root
     * @return huffman编码 map集合
     */
    private static void getCodes(Node root) {
        getCodes(root, "", new StringBuilder());
    }

    /**
     * 将一个字符串内容转为 Huffman 编码形式的字符串
     *
     * @param content
     * @return
     */
    private static String getCodesOfContent(String content) {
        //获取字符串的ASCII码数组
        byte[] bytes = content.getBytes();
        //获取按照字符出现次数排序的nodes集合
        List<Node> nodes = getNodes(bytes);
        //将集合构造为一棵Huffman树，并返回树的根节点
        Node root = createHuffmanTree(nodes);
        //为静态变量map集合 huffmanCodes 写入数据
        getCodes(root);
        StringBuilder sb = new StringBuilder();
        //遍历content的每个字符，将其转为byte值匹配huffmanCodes中的value，拼接成新的字符串
        for (char ch : content.toCharArray()) {
            //字符转为byte（ASCII值），作为key从map集合中获取value
            sb.append(huffmanCodes.get((byte) ch));
        }
        return sb.toString();
    }

    /**
     * 将字符串形式的 Huffman 编码转为 byte 数组（存储数据，保证二进制机器数，不关心十进制真值）
     *
     * @param codesOfStr
     * @return
     */
    private static byte[] codes2Byte(String codesOfStr) {
        //将codesOfStr每8位截取一次，将截取的string以2进制转为int型（前24位补0），再转为byte型（保存后8位的数据）
        String subString;
        byte[] bytes;

        if (codesOfStr.length() % 8 != 0) {
            bytes = new byte[codesOfStr.length() / 8 + 1];
        } else {
            bytes = new byte[codesOfStr.length() / 8];
        }

        int bytesIndex = 0;
        int index;
        int temp;   //String转byte的中间变量

        for (index = 0; index + 8 <= codesOfStr.length(); index += 8) {
            subString = codesOfStr.substring(index, index + 8);
            temp = Integer.parseInt(subString, 2);
            //存入byte数组
            bytes[bytesIndex++] = (byte) temp;
//            bytes[bytesIndex++] = Byte.parseByte(subString,2);    //此方法对不在-127~128补码范围内的数抛出越界异常
        }
        //此时index+8>codesOfStr.length，还有最后不满8位的数据未处理
        temp = Integer.parseInt(codesOfStr.substring(index), 2);
        bytes[bytesIndex] = (byte) temp;
        return bytes;
    }

    /**
     * 测试 getCodesOfStr 和 codes2Byte 方法
     */
    @Test
    public void getCodesOfStrContent() {
        String content = "i like like like java do you like a java";

        String codesOfStr = getCodesOfContent(content);
        System.out.println(codesOfStr);

        byte[] bytes = codes2Byte(codesOfStr);
        //** signum参数表示符号，1位正数（不处理补码直接输出）
        String str = new BigInteger(1, bytes).toString(2);
        System.out.println(str);
    }


    public static void main(String[] args) {
        String content = "i like like like java do you like a java";
        byte[] bytes = content.getBytes();  //获取每个字符的ASCII码值
//        System.out.println(Arrays.toString(bytes));   //长度40
        List<Node> nodes = getNodes(bytes);
        Node root = createHuffmanTree(nodes);
        preOrder(root);
        getCodes(root);
        System.out.println(huffmanCodes.toString());
    }
}
