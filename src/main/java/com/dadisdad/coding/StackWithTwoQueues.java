package com.dadisdad.coding;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 用两个队列模拟一个栈
 * 保证Deque1是有的，Deque2是空的。
 *
 * @author 10308
 * @date 2020/3/8
 */
public class StackWithTwoQueues {

    class MyStack {

        private Deque<Integer> deque1;
        private Deque<Integer> deque2;

        public MyStack() {
            this.deque1 = new ArrayDeque<>();
            this.deque2 = new ArrayDeque<>();
        }

        /**
         * Push element x onto stack.
         */
        public void push(int x) {
            deque1.addLast(x);
        }

        /**
         * Removes the element on top of the stack and returns that element.
         */
        public int pop() {
            while (!deque1.isEmpty() && deque1.size() > 1) {
                Integer e = deque1.poll();
                deque2.addLast(e);
            }
            Integer res = deque1.poll();
            Deque<Integer> temp = deque1;
            deque1 = deque2;
            deque2 = temp;
            return res;
        }

        /**
         * Get the top element.
         */
        public int top() {
            while (!deque1.isEmpty() && deque1.size() > 1) {
                Integer e = deque1.poll();
                deque2.addLast(e);
            }
            Integer res = deque1.poll();
            deque2.addLast(res);

            Deque<Integer> temp = deque1;
            deque1 = deque2;
            deque2 = temp;
            return res;
        }

        /**
         * Returns whether the stack is empty.
         */
        public boolean empty() {
            return deque1.isEmpty() && deque2.isEmpty();
        }
    }

    public static void main(String[] args) {
        MyStack stack = new StackWithTwoQueues().new MyStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.top());
        System.out.println(stack.empty());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.empty());
    }
}
