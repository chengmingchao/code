package code.java.datastructure.linkedlist;

/**
 * 双向链表
 */
public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        Node node1=new Node(1,"张三");
        Node node2=new Node(2,"李四");
        Node node3=new Node(3,"王五");
        Node node4=new Node(4,"王五1");
        DoubleLinkedList doubleLinkedList=new DoubleLinkedList();
        doubleLinkedList.add(node1);
        doubleLinkedList.add(node2);
        doubleLinkedList.add(node3);
        doubleLinkedList.list();

        doubleLinkedList.update(node4);
        System.out.println("修改后数据：");
        doubleLinkedList.list();

        doubleLinkedList.delete(node4);
        System.out.println("删除后数据：");
        doubleLinkedList.list();
    }

    //定义双向链表
    static class DoubleLinkedList{
        Node head=new Node();

        //添加节点到双向链表
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
            node.pre=temp;
        }

        //遍历双向链表
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

        //修改节点
        public void update(Node node){
            if (head.next==null){
                System.out.println("链表为空");
                return;
            }
            Node temp=head;
            boolean flag=false;
            while (true){
                if (temp.next==null){
                    break;
                }
                if (temp.next.no==node.no){
                    flag=true;
                    break;
                }
               temp=temp.next;
            }
            if (flag){
                temp.no=node.no;
                temp.name=node.name;
            }else {
                System.out.println("没有找到搞编号节点："+node.no);
            }

        }

        //删除节点
        public void delete(Node node){
            if (head.next==null){
                System.out.println("链表为空");
                return;
            }
            Node temp=head.next;
            boolean flag=false;
            while (true){
                if (temp.no==node.no){
                    flag=true;
                    break;
                }
                if (temp.next==null){
                    break;
                }
                temp=temp.next;
            }
            if (flag){
                if (temp.next==null){
                    temp.pre.next=null;
                }else {
                    temp.pre.next=temp.next;
                    temp.pre=temp.next.pre;
                }
            }else {
                System.out.println("没有找到待删除的节点编号："+node.no);
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

