public class RemoveNthFromEnd {

    //Given a linked list, remove the n-th node from the end of list and return its head.
    //Given n will always be valid.
    //
    // Time complexity worst case is O(n)
    //
    // Space complexity worst caes is O(1)
    //
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode trailingNode = head.next;
        ListNode leadingNode = head;
        ListNode previousNodeToTrailingNode = head;

        int startCount = 0;
        while(startCount < n) { //if n > 0, advance leadingNode n times. We don't have to check for null because of the contract
            leadingNode = leadingNode.next;
            startCount++;
        }

        if (leadingNode == null) { //there were n nodes in the list, so remove head
            trailingNode = head;
        }

        while (leadingNode != null && leadingNode.next != null) {
            leadingNode = leadingNode.next;
            previousNodeToTrailingNode = previousNodeToTrailingNode.next;
            trailingNode = trailingNode.next;
        }
        head = removeNode(head, previousNodeToTrailingNode, trailingNode, leadingNode);
        return head;
    }

    private ListNode removeNode(ListNode head, ListNode previousNodeToTrailingNode, ListNode trailingNode, ListNode leadingNode) {
        if (trailingNode == head) { //We never made it past n nodes
            head = head.next;
        } else if (trailingNode == leadingNode) {
            previousNodeToTrailingNode.next = null;
        } else {
            previousNodeToTrailingNode.next = trailingNode.next;
        }
        return head;
    }
}