package code.java.datastructure.linkedlist;



/**
 * 环形单向链表
 */
public class CircleSingleLinkedListDemo {
    public static void main(String[] args) {
        CircleSingleLinkedList circleSingleLinkedList=new CircleSingleLinkedList();
        circleSingleLinkedList.add(25);
        circleSingleLinkedList.list();

        circleSingleLinkedList.count(1,2,25);
    }

    static class CircleSingleLinkedList {
        //定义头结点
        Student first = null;

        //添加节点
        public void add(int nums) {
            if (nums < 1) {
                System.out.println("nums值不正确");
                return;
            }
            //辅助指针，帮组构建循环链表
            Student curr = null;
            for (int i = 1; i <= nums; i++) {
                //根据编号，创建节点
                Student s = new Student(i);
                //如果是第一个节点
                if (i == 1) {
                    first = s;
                    first.setNext(first);//构成环形
                    curr = first;
                } else {
                    curr.setNext(s);
                    s.setNext(first);
                    curr = s;
                }
            }
        }

        //遍历节点
        public void list(){
            if (first==null){
                System.out.println("链表为空");
                return;
            }
            Student curr=first;
            while (true){
                System.out.println(curr);
                if (curr.getNext()==first){
                    break;
                }

               curr=curr.getNext();
            }
        }

        /**
         * @param startNo 表示从第几号开始数
         * @param countNum 表示数几下
         * @param nums  表示最初有几个数
         */
        public void count(int startNo,int countNum,int nums){
            if (first==null||startNo<1||startNo>nums){
                System.out.println("参数有误");
                return;
            }
            //创建辅助节点，最开始指向环形链表最后一个节点
            Student helper=first;
            //报数之前，先移动startNo-1次

            while (true) {
                //指向最后一个节点
                if (helper.next == first) {
                    break;
                }
                helper=helper.next;
            }
            for (int i=0;i<startNo-1;i++){
                first=first.next;
                helper=helper.next;
            }
            while (true){
                if (helper==first){
                    break;
                }
                for (int i=0;i<countNum-1;i++){
                    first=first.next;
                    helper=helper.next;
                }
                //这是first指向的位置，就是出圈的位置
                System.out.println("出圈号:"+first.getNo());
                first=first.next;
                helper.next=first;
            }
            System.out.println("最后剩余的号："+first.getNo());
        }

    }

    static class Student {
        private Integer no;
        private Student next;

        public Student(Integer no) {
            this.no = no;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "no=" + no +
                    '}';
        }

        public Integer getNo() {
            return no;
        }

        public void setNo(Integer no) {
            this.no = no;
        }

        public Student getNext() {
            return next;
        }

        public void setNext(Student next) {
            this.next = next;
        }
    }
}
