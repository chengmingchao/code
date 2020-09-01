package com.cmc.code.java.datastructure.linkedlist;

/**
 * 双向链表
 */
public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        Node node1=new Node(1,"张三");
        Node node2=new Node(2,"李四");
        Node node3=new Node(3,"王五");
        DoubleLinkedList doubleLinkedList=new DoubleLinkedList();
        doubleLinkedList.add(node1);
        doubleLinkedList.add(node2);
        doubleLinkedList.add(node3);
        doubleLinkedList.list();
    }

    //定义双向链表
    static class DoubleLinkedList{
        Node head=new Node();

        public void add(Node node){
            Node temp=head;
            //遍历链表，找到最后一个节点
            while (true){
                if (temp.next==null){
                    break;
                }
                temp=temp.next;
            }
            //退出while时，temp指向最后一个节点
            temp.next=node;
            temp=node.pre;
        }

        public void list(){
            //判断链表为空
            if (head.next==null){
                System.out.println("链表为空");
                return;
            }
            //通过辅助变量来遍历
            Node temp=head.next;
            while (true){
                //判断是否到链表最后
                if (temp==null){
                    break;
                }
                System.out.println(temp);
                temp=temp.next;
            }
        }
    }

    static class Node{
        public Integer no;
        public String name;
        public Node pre;
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
}

