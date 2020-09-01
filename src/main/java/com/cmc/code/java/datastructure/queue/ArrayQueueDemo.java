package com.cmc.code.java.datastructure.queue;

/**
 * 数组实现队列
 */
public class ArrayQueueDemo {
    public static void main(String[] args) {
        ArrayQueue arrayQueue=new ArrayQueue(3);
        arrayQueue.add(1);
        arrayQueue.add(2);
        arrayQueue.add(3);
        arrayQueue.remove();
        arrayQueue.add(4);
        arrayQueue.show();
    }


    static class ArrayQueue{
        private Integer rear=0;   //队列尾部
        private Integer font=0;   //队列头部
        private Integer maxSize;//队列最大长度
        private Integer[] arr;

        public ArrayQueue(Integer maxSize){
            this.maxSize=maxSize;
            arr=new Integer[maxSize];
        }

        /**
         * 返回队列长度
         * @return
         */
        public Integer size(){
            return arr.length;
        }

        /**
         * 判断对列是否为空
         * @return
         */
        public Boolean isEmpty(){
            return rear==font;

        }

        /**
         * 判断队列是否满
         * @return
         */
        public Boolean isFull(){
           return rear==maxSize;
        }

        /**
         * 向队列添加数据
         * @param i
         * @return
         */
        public Boolean add(Integer i){
            if (isFull()){
                System.out.println("队列满，不能插入");
                return false;
            }else {
                arr[rear]=i;
                rear++;
                return true;
            }
        }

        /**
         * 从队列删除数据
         * @return
         */
        public Boolean remove(){
            if (isEmpty()){
                System.out.println("队列为空，不能删除数据");
                return false;
            }else {
                font++;
                return true;
            }
        }

        /**
         * 显示数据
         */
        public void show(){
            if (isEmpty()){
                System.out.println("队列为空");
            }else {
                for (int i=font;i<rear;i++){
                    System.out.println(arr[i]);
                }
            }
        }

        /**
         * 显示队列尾部的值
         */
        public Integer getRear(){
            return arr[rear-1];
        }

        /**
         * 显示队列头部的值
         * @return
         */
        public Integer getFont(){
            return arr[font];
        }
    }
}
