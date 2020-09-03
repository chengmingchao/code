package code.java.datastructure.stack;

/**
 * 数组模拟栈
 */
public class ArrayStackDemo {
    public static void main(String[] args) {
        ArrayStack arrayStack=new ArrayStack(5);
        arrayStack.push(1);
        arrayStack.push(2);
        arrayStack.push(3);
        arrayStack.list();
//        System.out.println("出栈数据："+arrayStack.pop());
//        System.out.println("出栈数据："+arrayStack.pop());
//        System.out.println("出栈数据："+arrayStack.pop());
//        System.out.println("出栈后");
//        arrayStack.list();
    }

    static class ArrayStack{
        private int maxSize;
        private int[] stack;
        private int top=-1;

        public ArrayStack(int maxSize){
            this.maxSize=maxSize;
            stack=new int[maxSize];
        }

        public boolean isFull(){
            return top==maxSize-1;
        }

        public boolean isEmpty(){
            return top==-1;
        }

        //入栈 push
        public void push(int value){
            if (isFull()){
                System.out.println("栈满");
                return;
            }
            top++;
            stack[top]=value;
        }

        //出栈，返回栈顶的数据
        public int pop(){
            if(isEmpty()){
                throw new RuntimeException("栈空");
            }
            int value=stack[top];
            top--;
            return value;
        }

        //展示栈
        public void list(){
            if (isEmpty()){
                System.out.println("栈空");
                return;
            }
            for (int i=top;i>=0;i--){
                System.out.println(stack[i]);
            }
        }
    }
}
