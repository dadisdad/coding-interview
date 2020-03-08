package com.dadisdad.coding;

import com.dadisdad.coding.pub.ListNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 从尾到头打印链表
 *
 * @author 10308
 * @date 2020/3/8
 */
public class PrintListInReversedOrder {

    public static int[] reversePrint(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode node = head;
        while (node != null) {
            stack.push(node.val);
            node = node.next;
        }
        int size = stack.size();
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            result[i] = stack.pop();
        }
        return result;
    }

    public static int[] reversePrintII(ListNode head) {
        if (head == null) {
            return new int[0];
        }
        ListNode node = head;
        List<Integer> list = new LinkedList<>();
        reversePrint(node, list);
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    public static void reversePrint(ListNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        reversePrint(node.next, list);
        list.add(node.val);
    }
}
