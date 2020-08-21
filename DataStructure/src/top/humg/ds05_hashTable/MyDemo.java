package top.humg.ds05_hashTable;

import org.junit.Test;

public class MyDemo {
    /**
     * 测试 add 和 list 方法
     */
    @Test
    public void test1() {
        HashTable hashTable = new HashTable(10);
        hashTable.add(new Employee(1, "cocoon"));
        hashTable.add(new Employee(11, "bob"));
        hashTable.add(new Employee(111, "jack"));
        hashTable.add(new Employee(7, "alan"));
        hashTable.list();
        hashTable.del(111);
        System.out.println("------------");
        hashTable.list();
    }

    /**
     * 测试 findById 方法
     */
    @Test
    public void test2() {
        HashTable hashTable = new HashTable(10);
        hashTable.add(new Employee(1, "胡民港"));
        Employee emp = hashTable.findById(1);
        System.out.println(emp);
    }
}
