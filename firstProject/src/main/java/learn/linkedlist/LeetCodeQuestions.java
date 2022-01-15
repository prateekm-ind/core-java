package learn.linkedlist;

public class LeetCodeQuestions {
    public LinkedListNode addTwoNumbers(LinkedListNode l1, LinkedListNode l2) {
        LinkedListNode curr01 = l1;
        LinkedListNode curr02 = l2;
        //this block of code to initialize the first node of resulted LinkedList
        if (l1 == null && l2 == null) {
            return null;
        }
        int carry = 0;
        int sum = 0;

        if (curr01 == null) {
            sum = curr02.data + carry;
            curr02 = curr02.next;
        } else if (curr02 == null) {
            sum = curr01.data + carry;
            curr01 = curr01.next;
        } else {
            sum = curr01.data + curr02.data;
            if (sum >= 10) {
                carry = 1;
                sum %= 10;

            }
            curr02 = curr02.next;
            curr01 = curr01.next;
        }
        LinkedListNode res = new LinkedListNode(sum);
        LinkedListNode curr = res;
        //block ends with initialization


        //while loop to iterate over the entire list1 and list 2
        while (curr01 != null || curr02 != null) {
            sum = 0;
            if (curr01 == null) {
                sum = curr02.data + carry;
                if (sum >= 10) {
                    carry = 1;
                    sum %= 10;
                } else {
                    carry = 0;
                }
                curr02 = curr02.next;
            } else if (curr02 == null) {
                sum = curr01.data + carry;
                if (sum >= 10) {
                    carry = 1;
                    sum %= 10;
                } else {
                    carry = 0;
                }
                curr01 = curr01.next;
            } else {
                sum = curr01.data + curr02.data + carry;
                if (sum >= 10) {
                    carry = 1;
                    sum %= 10;
                } else {
                    carry = 0;
                }
                curr02 = curr02.next;
                curr01 = curr01.next;
            }
            curr.next = new LinkedListNode(sum);
            curr = curr.next;
        }
        if (carry == 1) {
            curr.next = new LinkedListNode(carry);
        }
        return res;
    }
}
