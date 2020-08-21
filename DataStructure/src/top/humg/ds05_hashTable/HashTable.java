package top.humg.ds05_hashTable;

/**
 * 模拟哈希表数据结构
 */
public class HashTable {
    private EmpLinkedList[] empLinkedListArray;
    private final int size;   //表示哈希表中有多少条链表

    /**
     * @param size HashTable的长度
     */
    public HashTable(int size) {
        //声明创建一个存储EmpLinkedList的数组，默认值为null
        empLinkedListArray = new EmpLinkedList[size];
        for (int i = 0; i < size; i++) {
            empLinkedListArray[i] = new EmpLinkedList();
        }
        this.size = size;
    }

    /**
     * 添加方法
     *
     * @param employee
     */
    public void add(Employee employee) {
        //根据员工id，得到应该添加到的链表索引
        int empLinkedListIndex = hashFun(employee.id);
        //将员工添加到链表中
        empLinkedListArray[empLinkedListIndex].add(employee);
    }

    /**
     * 遍历哈希表中的所有员工
     */
    public void list() {
        for (int i = 0; i < size; i++) {
            empLinkedListArray[i].list(i);
        }
    }

    /**
     * 根据id查找雇员
     *
     * @param id
     * @return
     */
    public Employee findById(int id) {
        int index = hashFun(id);
        //找到存储改元素的链表
        EmpLinkedList linkedList = empLinkedListArray[index];
        Employee cur = linkedList.getHead();
        if (cur == null) {
            throw new RuntimeException("未找到该员工");
        }
        while (true) {
            //遍历链表
            if (cur.id == id) {
                return cur;
            }
            if (cur.next == null) {
                throw new RuntimeException("未找到该员工");
            }
            cur = cur.next;
        }
    }

    /**
     * 根据id删除雇员
     *
     * @param id
     */
    public void del(int id) {
        int index = hashFun(id);
        EmpLinkedList empLinkedList = empLinkedListArray[index];
        Employee head = empLinkedList.getHead();
        if (head == null) {
            throw new RuntimeException("未找到该员工");
        }
        //如果头节点是需删除元素，头节点后移一位
        if (head.id == id) {
            //设置新的头节点（后移一位）
            empLinkedList.setHead(head.next);
            return;
        }

        Employee cur = head;
        if (cur.next == null) {
            throw new RuntimeException("未找到该员工");
        }
        //根据id找到节点，断开元素前后链接
        while (true) {
            if (cur.next.id == id) {
                //分两种情况
                //1.cur.next后面无节点
                if (cur.next.next == null) {
                    cur.next = null;
                    return;
                } else {
                    //2.cur.next后面还有节点
                    cur.next = cur.next.next;
                    return;
                }
            }
            cur = cur.next;
            if (cur.next == null) {
                //当cur.next==null时，说明遍历到链表尾部仍未找到需删除节点，抛出异常
                throw new RuntimeException("未找到该员工");
            }
        }
    }


    //编写一个散列函数
    private int hashFun(int id) {
        return id % size;
    }
}
