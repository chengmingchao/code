package code.java.datastructure.queue;

/**
 * 数组实现循环队列
 */
public class CircleArrayQueueDemo {

    public static void main(String[] args) {
        CircleArrayQueue queue = new CircleArrayQueue(5);
        queue.add(1);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        queue.remove();
        queue.add(9);
        queue.get();
    }


    static class CircleArrayQueue {
        private Integer font = 0;
        private Integer rear = 0;
        private Integer maxSize;
        private Integer[] arr;

        public CircleArrayQueue(Integer maxSize) {
            this.maxSize = maxSize;
            this.arr = new Integer[maxSize];
        }

        /**
         * 判断队列是否为空
         *
         * @return
         */
        public Boolean isEmpty() {
            return font == rear;
        }

        /**
         * 判断对列是否满
         *
         * @return
         */
        public Boolean isFull() {
            return (rear + 1) % maxSize == font;
        }

        /**
         * 向队列添加数据
         *
         * @param i
         * @return
         */
        public Boolean add(Integer i) {
            if (isFull()) {
                System.out.println("队列满，不能添加数据");
                return false;
            } else {
                arr[rear] = i;
                rear = (rear + 1) % maxSize;
                return true;
            }
        }

        /**
         * 从队列中删除数据，出队列
         *
         * @return
         */
        public Integer remove() {
            if (isEmpty()) {
                throw new RuntimeException("队列为空，不能删除数据");
            } else {
                int value=arr[font];
                font = (font + 1) % maxSize;
                return value;
            }
        }

        /**
         * 遍历队列
         */
        public void get() {
            if (isEmpty()) {
                System.out.println("队列为空，不能遍历");
            } else {
                for (int i = font; i < font + (rear + maxSize - font) % maxSize; i++) {
                    System.out.println(arr[i]);
                }
            }
        }
    }
}
