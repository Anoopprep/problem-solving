/**
 * 234. Palindrome Linked List
 * 
 * Algorithm:
 * 1 2 2 1 becomes 1 2 and reverse second 1 2
 * 1 2 3 4 5 becomes 1 2 and reverse second 5 4 3
 * now compare till head becomes null which automatically will ignore middle at the last in second
 */

public class PalindromeLinkedList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;
        ListNode slow = head, fast = head;

        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode curr = slow, prev = null;
        while(curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        slow = prev;

        while(head != null) {
            if(head.val != slow.val) return false;
            head = head.next;
            slow = slow.next;
        }

        return true;
    }
}
