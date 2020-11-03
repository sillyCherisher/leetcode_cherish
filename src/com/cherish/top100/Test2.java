package com.cherish.top100;

import java.util.List;

/**
 * 2. 两数相加
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class Test2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        ListNode res = new ListNode();
        ListNode temp3 = res;
        int nextBit = 0;
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        while (temp1 != null || temp2 != null || nextBit != 0){
            int tempNum = 0;
            if(temp1 != null){
                tempNum += temp1.val;
                temp1 = temp1.next;
            }
            if(temp2 != null){
                tempNum += temp2.val;
                temp2 = temp2.next;
            }
            if(nextBit != 0){
                tempNum += nextBit;
            }
            nextBit = tempNum / 10;
            tempNum = tempNum % 10;
            temp3.next = new ListNode(tempNum);
            temp3 = temp3.next;
        }
        return res.next;
    }
}
