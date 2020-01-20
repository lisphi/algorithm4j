package com.lishaopeng.algorithm.linear.linkedlist.util;

import com.lishaopeng.algorithm.linear.linkedlist.SinglyLinkedNode;

import java.util.Objects;

public final class SinglyLinkUtil {
    public static <T> SinglyLinkedNode<T> getFirstCrossNodeInCircle(SinglyLinkedNode<T> head) {
        SinglyLinkedNode<T> walker = head;
        SinglyLinkedNode<T> runner = head;
        while (runner != null && runner.getNext() != null) {
            walker = walker.getNext();
            runner = runner.getNext().getNext();
            if (walker == runner) {
                return walker;
            }
        }
        return null;
    }

    public static <T> SinglyLinkedNode<T> getFirstNodeInCircle(SinglyLinkedNode<T> head) {
        SinglyLinkedNode<T> firstCrossNode = getFirstCrossNodeInCircle(head);
        SinglyLinkedNode<T> headNode = head;
        while (headNode != null && firstCrossNode != null) {
            headNode = headNode.getNext();
            firstCrossNode = firstCrossNode.getNext();
            if (headNode == firstCrossNode) {
                return headNode;
            }
        }
        return null;
    }

    public static <T> SinglyLinkedNode<T> reverse(SinglyLinkedNode<T> head) {
        SinglyLinkedNode<T> current = head;
        SinglyLinkedNode<T> prev = null;
        SinglyLinkedNode<T> firstNodeOfCircle = getFirstNodeInCircle(head);
        boolean firstNodeOfNodeVisited = false;
        while (current != null) {
            if (current == firstNodeOfCircle) {
                if (firstNodeOfNodeVisited) {
                    return prev;
                } else {
                    firstNodeOfNodeVisited = true;
                }
            }
            SinglyLinkedNode<T> storedPrev = prev;
            prev = current;
            current = current.getNext();
            prev.setNext(storedPrev);
        }
        return prev;
    }

    public static <T> boolean hasCircle(SinglyLinkedNode<T> head) {
        return getFirstCrossNodeInCircle(head) != null;
    }

    public static <T> boolean isPalindrome(SinglyLinkedNode<T> head) {
        if (head == null) {
            return false;
        }

        // 快指针的速度是慢指针的两倍，用于找到中间位置
        SinglyLinkedNode<T> walker = head;
        SinglyLinkedNode<T> runner = head;
        SinglyLinkedNode<T> prevWolker = null;
        while (runner != null && runner.getNext() != null) {
            prevWolker = walker;
            walker = walker.getNext();
            runner = runner.getNext().getNext();
            if (walker == runner) {
                return false;
            }
        }

        // 链表的中间点做矫正（节点总数为奇数或偶数）
        SinglyLinkedNode<T> leftTail = null;
        SinglyLinkedNode<T> rightHead = null;
        if (runner == null) {
            leftTail = prevWolker;
            rightHead = walker;
        } else {
            leftTail = walker;
            rightHead = walker;
        }

        // 右半部分反转
        SinglyLinkedNode<T> rightTail = reverse(rightHead);
        leftTail.setNext(null);
        rightHead.setNext(null);

        // 逐一比较左右两部分的节点内容是否相同
        SinglyLinkedNode<T> leftCursor = head;
        SinglyLinkedNode<T> rightCursor = rightTail;
        boolean allSame = true;
        while (leftCursor != null) {
            if (!Objects.equals(leftCursor.getData(), rightCursor.getData())) {
                allSame = false;
                break;
            }
            leftCursor = leftCursor.getNext();
            rightCursor = rightCursor.getNext();
        }

        // 右半部分再次反正，恢复链表到初始状态
        reverse(rightTail);
        if (leftTail != rightHead) {
            leftTail.setNext(rightHead);
        }

        return allSame;
    }
}
