package code.java.datastructure.linkedlist;

/**
 * 单链表
 */
public class SingleLinkedListDemo {

    public static void main(String[] args) {
        Node node1=new Node(1,"宋江","及时雨");
        Node node2=new Node(2,"卢俊义","玉麒麟");
        Node node3=new Node(3,"吴用","智多星");
        Node node4=new Node(4,"林冲","豹子头");

        SingleLinkedList singleLinkedList=new SingleLinkedList();
        singleLinkedList.add(node1);
        singleLinkedList.add(node2);
        singleLinkedList.add(node4);
        singleLinkedList.add(node3);

        //按编号顺序插入
      /*  singleLinkedList.addByOrder(node1);
        singleLinkedList.addByOrder(node2);
        singleLinkedList.addByOrder(node4);
        singleLinkedList.addByOrder(node3);*/
        singleLinkedList.list();
       /* Node node5=new Node(2,"小卢","玉麒麟~");
        //修改节点
        singleLinkedList.update(node5);
        System.out.println("修改后链表");
        singleLinkedList.list();
        //删除节点
        singleLinkedList.delete(node4);
        singleLinkedList.delete(node3);
        singleLinkedList.delete(node2);
        singleLinkedList.delete(node1);
        System.out.println("删除后链表");
        singleLinkedList.list();*/
    }

    //定义链表
    static class SingleLinkedList{

        //初始化头结点，头结点不能动
        private Node head=new Node();
        /**
         * 添加节点到单链表
         * 1.找到当前链表最后一个节点
         * 2.将最后这个节点的next指向新的节点
         * @param node
         */
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

        }

        /**
         * 根据排名插入到指定位置
         * 如果有这个排名，则添加失败
         * @param node
         */
        public void addByOrder(Node node){
            //因为是单链表，temp是添加位置的前一个节点，否则插入不了
            Node temp=head;
            //flag表示添加的编号是否存在，默认为false
            boolean flag=false;
            while (true){
                //temp到了链表的最后
                if (temp.next==null){
                    break;
                }
                //位置找到，在temp后面插入
                if (temp.next.no>node.no){
                    break;
                }else if (temp.next.no==node.no){   //添加的编号存在
                    flag=true;
                    break;
                }
                temp=temp.next;
            }
            if (flag){
                System.out.println("编号已经存在，不能添加，"+node.no);
            }else {
                node.next=temp.next;
                temp.next=node;
            }

        }

        /**
         * 修改节点信息，根据no来修改
         */
        public void update(Node node){
            if (head.next==null){
                System.out.println("链表为空，不能修改");
                return;
            }

            Node temp=head.next;
            boolean flag=false;//是否找到该节点
            while (true){
                //链表遍历结束
                if(temp==null){
                    break;
                }
                if(temp.no==node.no){
                    flag=true;
                    break;
                }
                temp=temp.next;
            }
            if (flag){
                temp.name=node.name;
                temp.nickname=node.nickname;
            }else {
                System.out.println("没有找到节点，编号："+node.no);
            }

        }

        /**
         * 删除节点
         * head节点不能动，辅助节点temp找到待删除节点的前一个节点
         * 比较是，比较temp.next.no==node.no
         */
        public void delete(Node node){
            Node temp=head;
            boolean falg=false;
            while (true){
                if (temp.next==null){
                    break;
                }
                //找到待删除的节点
                if (temp.next.no==node.no){
                    falg=true;
                    break;
                }
                temp=temp.next;
            }
            if (falg){
                temp.next=temp.next.next;
            }else {
                System.out.println("要删除的节点不存在,no="+node.no);
            }
        }
        /**
         * 遍历单链表
         */
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

    //定义节点
    static class Node{
        public int no;
        public String name;
        public String nickname;
        public Node next;

        public Node() {
        }

        public Node(int no, String name, String nickname) {
            this.no = no;
            this.name = name;
            this.nickname = nickname;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "no=" + no +
                    ", name='" + name + '\'' +
                    ", nickname='" + nickname + '\'' +
                    '}';
        }
    }
}
