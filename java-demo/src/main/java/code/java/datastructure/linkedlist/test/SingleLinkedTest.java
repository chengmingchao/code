package code.java.datastructure.linkedlist.test;

/**
 * 1.求单链表中有效节点的个数
 * 2.查找单链表中的倒数第k个节点
 * 3.单链表的反转
 * 4.从尾到头打印单链表（要求方式：反向遍历，Stack栈）
 * 5.合并两个有序的单链表，合并之后的单链表任然有序
 */
public class SingleLinkedTest {
    public static void main(String[] args) {
        Node node1=new Node(1,"张三");
        Node node2=new Node(2,"李四");
        Node node3=new Node(3,"王五");
        Node node4=new Node(4,"赵六");
        SingleLinked singleLinked=new SingleLinked();
        singleLinked.add(node1);
        singleLinked.add(node2);
        singleLinked.add(node3);
        singleLinked.add(node4);
        singleLinked.list();

        singleLinked.size();
    }
}

//定义单链表
class SingleLinked{
    //定义头结点
    Node head=new Node();

    //单链表插入数据
    public void add(Node node){
        //判断单链表是否为空，如果为空，直接插在head后面
        if (head.next==null){
            head.next=node;
            return;
        }
        //如果不为空，需要找到此单链表的最后一个节点
        Node temp=head;
        while (true){
            //如果找到最后一个节点，插入数据
            if (temp.next==null){
                temp.next=node;
                break;
            }
            temp=temp.next;
        }
    }

    //单链表的遍历
    public void list(){
       //判断单链表是否为空，如果为空，则不遍历
        if (head.next==null){
            System.out.println("链表为空，不能遍历");
            return;
        }
        Node temp=head;
        while (true){
            if (temp.next==null){
                break;
            }
            System.out.println(temp.next);
            temp=temp.next;
        }
    }

    //返回单链表有效节点的个数
    public void size(){
        //判断单链表是否为空，如果为空
        if (head.next==null){
            System.out.println("有效个数为："+0);
            return;
        }
        int size=0;
        Node temp=head;
        while (true){
            if (temp.next==null){
                break;
            }
            size++;
            temp=temp.next;
        }
        System.out.println("有效个数为："+size);
    }

    //返回倒数第k个节点
    public void getKNode(Integer k){

    }
}

//定义单链表的节点
class Node{
    public Integer no;
    public String name;
    public Node next;

    public Node() {
    }

    public Node(Integer no, String name) {
        this.no = no;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Node{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }
}