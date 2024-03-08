import java.math.BigInteger;
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = l1;
        ListNode tmp = new ListNode();
        String firstValue = "";
        String secondValue = "";
        String string_value;

        while(head != null) {
            firstValue = head.val + firstValue;
            head = head.next;
        }

        head = l2;
        while(head != null) {
            secondValue = head.val + secondValue;
            head = head.next;
        }
        BigInteger bigInteger1 = new BigInteger(firstValue);
        BigInteger bigInteger2 = new BigInteger(secondValue);
        BigInteger value = bigInteger1.add(bigInteger2);
        string_value = String.valueOf(value);

        for(int i = 0; i < string_value.length(); i++ ) {
            ListNode listNode = new ListNode();
            if(i == 0) {
            listNode = new ListNode(Character.getNumericValue(string_value.charAt(i)));
            } else {
            listNode = new ListNode(Character.getNumericValue(string_value.charAt(i)), tmp);
            }
            tmp = listNode;
        }
        
        return tmp;
    }
}