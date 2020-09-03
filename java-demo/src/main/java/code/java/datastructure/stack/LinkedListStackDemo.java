package code.java.datastructure.stack;

import java.security.PublicKey;
import java.util.Stack;

/**
 * 链表实现栈
 */
public class LinkedListStackDemo {

    public static void main(String[] args) {
        NodeStack nodeStack1=new NodeStack(1);
        NodeStack nodeStack2=new NodeStack(2);
        NodeStack nodeStack3=new NodeStack(3);
        NodeStack nodeStack4=new NodeStack(4);
        LinkedListStack linkedListStack=new LinkedListStack();
        linkedListStack.push(nodeStack1);
        linkedListStack.push(nodeStack2);
        linkedListStack.push(nodeStack3);
        linkedListStack.push(nodeStack4);
        linkedListStack.list();
//        System.out.println("出栈："+linkedListStack.pop());
//        System.out.println("出栈："+linkedListStack.pop());
//        System.out.println("出栈："+linkedListStack.pop());
//        System.out.println("出栈："+linkedListStack.pop());
//        System.out.println("出栈后：");
//        linkedListStack.list();
    }

    //定义单链表栈
    static class LinkedListStack{
       //定义头结点
        NodeStack head=new NodeStack();

        //栈空
        public boolean isEmpty(){
            return head.next==null;
        }

        //进栈
        public void push(NodeStack nodeStack){
            NodeStack temp=head;
            while (true){
                if (temp.next==null){
                    break;
                }
                temp=temp.next;
            }
            temp.next=nodeStack;
        }

        //出栈
        public int pop(){
            if (isEmpty()){
                throw new RuntimeException("栈空");
            }
            NodeStack temp=head;
            int value;
            while (true){
                if (temp.next.next==null){
                     value=temp.next.val;
                    temp.next=null;
                    break;
                }
                temp=temp.next;
            }
           return value;
        }

        //遍历  利用栈反向 输出 单链表数据
        public void list(){
            Stack<NodeStack> stacks=new Stack<>();

            if (isEmpty()){
                System.out.println("栈空");
                return;
            }
            NodeStack temp=head;
            while (true){
                if (temp.next==null){
                    break;
                }
                stacks.push(temp);
                temp=temp.next;
            }

            while (stacks.size()>0){
                System.out.println(stacks.pop());
            }
        }

    }

    //定义栈节点
    static class NodeStack{
        public int val;
        public NodeStack next;

        public NodeStack(int val) {
            this.val = val;
        }

        public NodeStack() {
        }

        @Override
        public String toString() {
            return "NodeStack{" +
                    "val=" + val +
                    '}';
        }
    }
}
