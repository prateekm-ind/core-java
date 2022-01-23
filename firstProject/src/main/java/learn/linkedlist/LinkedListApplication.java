package learn.linkedlist;


import java.util.HashSet;
import java.util.Set;

public class LinkedListApplication {
    public static void main(String[] args) {
        LinkedListNode head = new LinkedListNode(10);
        head.next = new LinkedListNode(20);
        head.next.next = new LinkedListNode(30);
        head.next.next.next = new LinkedListNode(40);

        LinkedListNode node01 = new LinkedListNode(10);
        node01.next = new LinkedListNode(20);
        node01.next.next = new LinkedListNode(30);
        node01.next.next.next = new LinkedListNode(40);

        LinkedListNode node02 = new LinkedListNode(10);
        node02.next = new LinkedListNode(20);
        node02.next.next = new LinkedListNode(20);
        node02.next.next.next = new LinkedListNode(30);
        node02.next.next.next.next = new LinkedListNode(30);
        node02.next.next.next.next.next = new LinkedListNode(40);

        iterate(head);
        System.out.println("\nRecursive:");
        recursiveTraversal(head);

        System.out.println("\n Insert at Begining");
        recursiveTraversal(insertAtBegin(head, 7));

        System.out.println("\nInsert at the End");
        insertAtEnd(head, 49);

        System.out.println("\nSearch element in a LinkedList");
        System.out.print(searchInALinkedListNode(head, 49));

        System.out.println("\nRemove from the End");
        recursiveTraversal(deleteLastNode(head));

        System.out.println("\nRemove from the Begining");
        recursiveTraversal(deleteFromBegin(head));

        System.out.println("\nInsert after a given data  node");
        recursiveTraversal(insertAtAGivenPosition(head, 100, 20));

        System.out.println("\nSearch element in a LinkedList");
        System.out.print(searchInALinkedListNode(head, 49));

        System.out.println("\nInsert element inside a sorted LinkedList");
        recursiveTraversal(sortedInsert(node01, 35));

        System.out.println("\nMiddle of the LinkedList");
        System.out.println(findMiddleOfSLL(node01).data);

        System.out.println("\nNth node from the end");
        System.out.println(printNthNodeFromTheEndOfSLL(node01, 4).data);

        System.out.println("\nReverse SLL node data");
        recursiveTraversal(reverseASLL(node01));

        System.out.println("\nRemove duplicates from the SLL");
        recursiveTraversal(node02);
        System.out.println("\nAfter removing duplicates");
        recursiveTraversal(removeDuplicatesFromSortedSLL(node02));

        System.out.println("\nDetect a Loop");
        System.out.println(detectALoopInTheSLL(node02));

        System.out.println("\nDetect a Loop using floyd's Cycle of Detection");
        System.out.println(detectLoopUsingFloydCycleDetection(head));
    }

    //iterative traversal of a linked list
    public static void iterate(LinkedListNode head) {
        LinkedListNode curr = head;
        while (curr != null) {
            System.out.print(curr.data + "->");
            curr = curr.next;
        }
    }

    //recursive traversal of a linked list
    public static void recursiveTraversal(LinkedListNode head) {
        if (head == null) {
            return;
        }
        System.out.print(head.data + " ");
        recursiveTraversal(head.next);
        return;
    }

    //insert at the beginning of the linked list
    public static LinkedListNode insertAtBegin(LinkedListNode head, int k) {
        if (head == null) {
            return new LinkedListNode(k);
        }
        LinkedListNode node = new LinkedListNode(k);
        node.next = head;
        head = node;
        return head;
    }

    //recursive insertion at the end of linked list
    public static void insertAtEnd(LinkedListNode head, int k) {
        if (head == null) {
            head = new LinkedListNode(k);
        }
        if (head.next == null) {
            head.next = new LinkedListNode(k);
            System.out.print(head.data + " ");
            System.out.print(head.next.data);
            return;
        }
        System.out.print(head.data + " ");
        insertAtEnd(head.next, k);
        return;
    }

    //remove node from the begining
    public static LinkedListNode deleteFromBegin(LinkedListNode head) {
        if (head == null) {
            return null;
        }
        LinkedListNode temp = head.next;
        head.next = null;
        return temp;
    }


    //Idea : to iterate till the end and remove the element from the end
    //Check the head.next corner case if there is only one element present in LinkedList
    public static LinkedListNode deleteLastNode(LinkedListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return null;
        }
        LinkedListNode curr = head;
        while (curr.next.next != null) {
            curr = curr.next;
        }
        curr.next = null;
        return head;
    }

    //Idea: if node exits of value q insert p after that
    //else return null
    public static LinkedListNode insertAtAGivenPosition(LinkedListNode head, int p, int q) {
        if (head == null) {
            return new LinkedListNode(p);
        }
        LinkedListNode curr = head;
        while (curr != null && curr.data != q) {
            curr = curr.next;
        }
        if (curr != null && curr.data == q) {
            LinkedListNode temp = curr.next;
            curr.next = new LinkedListNode(p);
            curr.next.next = temp;
            return head;
        }
        return null;
    }

    public static boolean searchInALinkedListNode(LinkedListNode head, int k) {
        if (head == null) {
            return false;
        }
        LinkedListNode curr = head;
        while (curr != null && curr.data != k) {
            curr = curr.next;
        }
        if (curr != null && curr.data == k) {
            return true;
        }
        return false;
    }

    public static LinkedListNode sortedInsert(LinkedListNode head, int k) {
        if (head == null) {
            return new LinkedListNode(k);
        }
        LinkedListNode curr = head;
        if (k < curr.data) {
            LinkedListNode temp = new LinkedListNode(k);
            temp.next = head;
            return temp;
        }
        while (curr.next != null && curr.next.data < k) {
            curr = curr.next;
        }
        LinkedListNode temp = new LinkedListNode(k);
        temp.next = curr.next;
        curr.next = temp;
        return head;
    }

    public static LinkedListNode findMiddleOfSLL(LinkedListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        LinkedListNode slow = head;
        LinkedListNode fast = head;
        //fast.next - for odd length
        //fast != null for even length
        while (slow.next != null && fast.next != null && fast != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public static LinkedListNode printNthNodeFromTheEndOfSLL(LinkedListNode head, int n) {
        if (head == null) {
            return null;
        }
        LinkedListNode curr = head;
        int i = 0;

        while (curr != null) {
            i++;
            curr = curr.next;
        }
        curr = head;
        while (curr != null) {
            if (i - n == 0) {
                return curr;
            }
            i--;
            curr = curr.next;
        }
        return null;
    }

    public static LinkedListNode reverseASLL(LinkedListNode head) {
        if (head == null) {
            return null;
        }
        LinkedListNode curr = head;
        LinkedListNode prev = null;
        while (curr != null) {
            //curr.next node of LinkedList
            LinkedListNode next = curr.next;
            //Modifying current node to previous element
            curr.next = prev;
            //prev - curr operating node
            prev = curr;
            //curr - next node of the LinkedList
            curr = next;

        }
        return prev;
    }

    //Idea : keep track of curr and the prev node reference and prev node data
    //If there is a duplicate in the SLL then point the previous node ref
    //to the curr.next(node reference) and make the temp var equals to curr.data
    //otherwise update previous with current node and iterate over
    public static LinkedListNode removeDuplicatesFromSortedSLL(LinkedListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        LinkedListNode prev = null;
        LinkedListNode curr = head;
        int temp = curr.data;
        curr = curr.next;
        prev = head;
        while (curr != null) {
            if (curr.data == temp) {
                prev.next = curr.next;
            } else {
                prev = curr;
            }
            temp = curr.data;
            curr = curr.next;
        }
        return head;
    }

    //GFG implementation
    public static LinkedListNode removeDups(LinkedListNode head) {
        LinkedListNode curr = head;
        while (curr != null && curr.next != null) {
            if (curr.data == curr.next.data) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
        return head;
    }

    //Idea: Reverse in a group of K
    // for this maintain a LinkedList
    public static LinkedListNode reverseInGroupOfK(LinkedListNode head, int k) {
        if (head == null) {
            return null;
        }
        LinkedListNode curr = head;
        LinkedListNode prev = null;
        int count = 0;
        while (curr != null && count < k) {
            LinkedListNode next = curr.next;
            prev = curr;
            curr.next = prev;
            count++;
            curr = next;
        }
        return prev;
    }

    //Idea : to keep track of visited node using the Hash-Table
    public static boolean detectALoopInTheSLL(LinkedListNode head) {
        Set<LinkedListNode> visitedNode = new HashSet<>();
        LinkedListNode curr = head;
        while (curr != null) {
            if (visitedNode.contains(curr)) {
                return true;
            }
            visitedNode.add(curr);
            curr = curr.next;
        }

        return false;
    }

    //check for fast.next condition as for LinkedList with even no of nodes
    // will through NullPointerException
    public static boolean detectLoopUsingFloydCycleDetection(LinkedListNode head) {
        if (head == null) {
            return false;
        }
        LinkedListNode slow = head;
        LinkedListNode fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast.equals(slow)) {
                return true;
            }
        }
        return false;
    }

    public static LinkedListNode detectAndRemoveALoop(LinkedListNode head) {
        LinkedListNode slow = head;
        LinkedListNode fast = head;
        while (fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if (slow==fast){
                break;
            }
        }
        if(slow!=fast){
            return head;
        }
        slow=head;
        while (slow.next!=fast.next){
            slow=slow.next;
            fast=fast.next;
        }
        fast.next=null;
        return head;
    }
}
