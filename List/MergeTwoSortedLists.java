/**
 * 21. Merge Two Sorted Lists
 * You are given the heads of two sorted linked lists list1 and list2.
 * Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.
 * Return the head of the merged linked list.
 * Input: list1 = [1,2,4], list2 = [1,3,4], Output: [1,1,2,3,4,4]
 * Input: list1 = [], list2 = [], Output: []
 * Input: list1 = [], list2 = [0], Output: [0]
 * 
 * Algorithm:
 * Take 2 pointers for list1 and list2
 * Create a dummy node temp 
 * Check which list has smaller element, add it to new list
 */


public class MergeTwoSortedLists {
     public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode curr1 = list1, curr2 = list2, curr3 = new ListNode(Integer.MIN_VALUE), temp = curr3;

        while(list1 != null || list2 != null) {
            if(list1 == null) {
                curr3.next = list2;
                break;
            }
            if(list2 == null) {
                curr3.next = list1;
                break;
            }

            if(list1.val < list2.val) {
                curr3.next = list1;
                list1 = list1.next;
            }
            else {
                curr3.next = list2;
                list2 = list2.next;
            }
            curr3 = curr3.next;
        }

        temp = temp.next;
        return temp;
    }
}
