package com.lishaopeng.algorithm.linear.linkedlist.util;

import com.lishaopeng.algorithm.linear.linkedlist.SinglyLinkedNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SinglyLinkUtilTest {

    @Test
    void testHasCircle() {
        SinglyLinkedNode<Integer> head = SinglyLinkedNode.of(1);
        SinglyLinkedNode<Integer> tail = head.append(SinglyLinkedNode.of(2))
                .append(SinglyLinkedNode.of(3))
                .append(SinglyLinkedNode.of(4))
                .append(SinglyLinkedNode.of(5));
        assertFalse(SinglyLinkUtil.hasCircle(head));
        tail.setNext(head.getNext().getNext());
        assertTrue(SinglyLinkUtil.hasCircle(head));
    }

    @Test
    void testGetFirstNodeInCircle() {
        SinglyLinkedNode<Integer> head = SinglyLinkedNode.of(1);
        SinglyLinkedNode<Integer> tail = head.append(SinglyLinkedNode.of(2))
                .append(SinglyLinkedNode.of(3))
                .append(SinglyLinkedNode.of(4))
                .append(SinglyLinkedNode.of(5));
        SinglyLinkedNode<Integer> actualFirstNodeInCircle = SinglyLinkUtil.getFirstNodeInCircle(head);
        assertNull(actualFirstNodeInCircle);
        tail.setNext(head.getNext().getNext());
        actualFirstNodeInCircle = SinglyLinkUtil.getFirstNodeInCircle(head);
        assertEquals(3, actualFirstNodeInCircle.getData());
    }

    @Test
    void testReverse() {
        SinglyLinkedNode<Integer> head = SinglyLinkedNode.of(1);
        SinglyLinkedNode<Integer> tail = head.append(SinglyLinkedNode.of(2))
                .append(SinglyLinkedNode.of(3))
                .append(SinglyLinkedNode.of(4))
                .append(SinglyLinkedNode.of(5));
        SinglyLinkedNode<Integer> actualHead = SinglyLinkUtil.reverse(head);
        SinglyLinkedNode<Integer> actualTail = getLast(actualHead);
        assertEquals(5, actualHead.getData());
        assertEquals(1, actualTail.getData());
    }

    @Test
    void testReverseWithCircle() {
        SinglyLinkedNode<Integer> head = SinglyLinkedNode.of(1);
        SinglyLinkedNode<Integer> tail = head.append(SinglyLinkedNode.of(2))
                .append(SinglyLinkedNode.of(3))
                .append(SinglyLinkedNode.of(4))
                .append(SinglyLinkedNode.of(5));
        tail.setNext(head.getNext().getNext());
        SinglyLinkedNode<Integer> actualHead = SinglyLinkUtil.reverse(head);
        SinglyLinkedNode<Integer> actualTail = getLast(actualHead);
        assertEquals(5, actualHead.getData());
        assertEquals(1, actualTail.getData());
    }

    @Test
    void testIsPalindrome1() {
        SinglyLinkedNode<Integer> head = null;
        SinglyLinkedNode<Integer> tail = null;
        assertFalse(SinglyLinkUtil.isPalindrome(head));
    }

    @Test
    void testIsPalindrome2() {
        SinglyLinkedNode<Integer> head = SinglyLinkedNode.of(1);
        assertTrue(SinglyLinkUtil.isPalindrome(head));
    }

    @Test
    void testIsPalindrome3() {
        SinglyLinkedNode<Integer> head = SinglyLinkedNode.of(1);
        SinglyLinkedNode<Integer> tail = head.append(SinglyLinkedNode.of(2));
        assertFalse(SinglyLinkUtil.isPalindrome(head));
    }

    @Test
    void testIsPalindrome4() {
        SinglyLinkedNode<Integer> head = SinglyLinkedNode.of(1);
        SinglyLinkedNode<Integer> tail = head.append(SinglyLinkedNode.of(2))
                .append(SinglyLinkedNode.of(3));
        assertFalse(SinglyLinkUtil.isPalindrome(head));
    }

    @Test
    void testIsPalindrome5() {
        SinglyLinkedNode<Integer> head = SinglyLinkedNode.of(1);
        SinglyLinkedNode<Integer> tail = head.append(SinglyLinkedNode.of(2))
                .append(SinglyLinkedNode.of(1));
        assertTrue(SinglyLinkUtil.isPalindrome(head));
    }

    @Test
    void testIsPalindrome6() {
        SinglyLinkedNode<Integer> head = SinglyLinkedNode.of(1);
        SinglyLinkedNode<Integer> tail = head.append(SinglyLinkedNode.of(2))
                .append(SinglyLinkedNode.of(2))
                .append(SinglyLinkedNode.of(1));
        assertTrue(SinglyLinkUtil.isPalindrome(head));
    }

    @Test
    void testIsPalindrome7() {
        SinglyLinkedNode<Integer> head = SinglyLinkedNode.of(1);
        SinglyLinkedNode<Integer> tail = head.append(SinglyLinkedNode.of(2))
                .append(SinglyLinkedNode.of(3))
                .append(SinglyLinkedNode.of(2))
                .append(SinglyLinkedNode.of(1));
        assertTrue(SinglyLinkUtil.isPalindrome(head));
    }

    @Test
    void testIsPalindrome8() {
        SinglyLinkedNode<Integer> head = SinglyLinkedNode.of(1);
        SinglyLinkedNode<Integer> tail = head.append(SinglyLinkedNode.of(2))
                .append(SinglyLinkedNode.of(3))
                .append(SinglyLinkedNode.of(3))
                .append(SinglyLinkedNode.of(2))
                .append(SinglyLinkedNode.of(1));
        assertTrue(SinglyLinkUtil.isPalindrome(head));
    }

    @Test
    void testIsPalindrome9() {
        SinglyLinkedNode<Integer> head = SinglyLinkedNode.of(1);
        SinglyLinkedNode<Integer> tail = head.append(SinglyLinkedNode.of(2))
                .append(SinglyLinkedNode.of(3))
                .append(SinglyLinkedNode.of(3))
                .append(SinglyLinkedNode.of(2))
                .append(SinglyLinkedNode.of(1));
        tail.setNext(head.getNext().getNext());
        assertFalse(SinglyLinkUtil.isPalindrome(head));
    }

    private SinglyLinkedNode<Integer> getLast(SinglyLinkedNode<Integer> head) {
        SinglyLinkedNode<Integer> current = head;
        SinglyLinkedNode<Integer> firstNodeOfCircle = SinglyLinkUtil.getFirstNodeInCircle(head);
        boolean firstNodeOfCircleVisited = false;
        SinglyLinkedNode<Integer> prev = null;
        while (current != null) {
            if (current == firstNodeOfCircle) {
                if (firstNodeOfCircleVisited) {
                    return prev;
                } else {
                    firstNodeOfCircleVisited = true;
                }
            }
            prev = current;
            current = current.getNext();
        }
        return prev;
    }
}