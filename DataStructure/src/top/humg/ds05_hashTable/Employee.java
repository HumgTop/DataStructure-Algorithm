package top.humg.ds05_hashTable;

/**
 * 雇员类（模拟链表节点）
 */
public class Employee {
    public int id;
    public String name;
    public Employee next;

    public Employee(int id,String name){
        this.id=id;
        this.name=name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", next=" + next.id +
                '}';
    }
}
