package com.cmc.code.java.datastructure.linkedlist;

public class T {
    public static void main(String[] args) {
        Node node1=new Node(1,"张三","男");
        Node node2=new Node(2,"李四","男");
        Node node3=new Node(3,"王五","男");
        Node node4=new Node(4,"赵六","男");

        Linked linked=new Linked();
        linked.add(node1);
        linked.add(node2);
        linked.add(node3);
        linked.add(node4);

        linked.list();
    }
}

//定义单链表
class Linked{
    Node head=new Node();//定义一个空的头结点

    //添加节点到链表
    public void add(Node node){
        //如果链表为空
        if (head.next==null){
            head.next=node;
            return;
        }
        Node temp=head;
        //如果链表不为空，要找到链表最后一个节点
        while (true){
            //找到链表最后一个节点
            if (temp.next==null){
                temp.next=node;
                break;
            }
            temp=temp.next;
        }
    }


    //删除节点
    public void delete(Node node){
        if (head.next==null){
            System.out.println("链表为空");
            return;
        }
        Node temp=head;
        while (true){
            //找到删除节点的前一个节点
            if (temp.next.no==node.no){

            }
        }

    }
    //遍历链表
    public void list(){
        //如果链表为空
        if (head.next==null){
            System.out.println("链表为空");
            return;
        }
        Node temp=head;
        while (true){
            //找到链表最后一个节点
            if (temp.next==null){
                break;
            }
            System.out.println(temp.next);
            temp=temp.next;
        }
    }
}

/**
 * 定义节点
 */
class Node{
   public Integer no;
   public String name;
   public String gender;
   public Node next;
    public Node() {
    }

    public Node(Integer no, String name, String gender) {
        this.no = no;
        this.name = name;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Node{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
