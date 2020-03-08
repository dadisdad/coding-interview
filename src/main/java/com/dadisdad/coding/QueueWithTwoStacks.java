package com.dadisdad.coding;

import java.util.Stack;

/**
 * 用两个栈实现队列
 *
 * @author 10308
 * @date 2020/3/8
 */
public class QueueWithTwoStacks {

    static class CQueue {

        private Stack<Integer> stack1;
        private Stack<Integer> stack2;

        public CQueue() {
            this.stack1 = new Stack<>();
            this.stack2 = new Stack();
        }


        public void appendTail(int value) {
            stack1.push(value);
        }

        public int deleteHead() {
            if (stack2.isEmpty()) {
                while (!stack1.isEmpty()) {
                    Integer e = stack1.pop();
                    stack2.push(e);
                }
            }
            if (!stack2.isEmpty()) {
                return stack2.pop();
            }
            return -1;
        }
    }

    public static void main(String[] args) {
        CQueue queue = new CQueue();
        queue.appendTail(1);
        queue.appendTail(2);
        queue.appendTail(3);
        System.out.println(queue.deleteHead());
        queue.appendTail(4);
        System.out.println(queue.deleteHead());
        System.out.println(queue.deleteHead());
        System.out.println(queue.deleteHead());
    }
}
