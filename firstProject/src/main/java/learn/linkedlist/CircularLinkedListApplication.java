package learn.linkedlist;

import java.util.HashSet;
import java.util.Set;

public class CircularLinkedListApplication {
    public static void main(String[] args) {
        CircularLinkedList head = new CircularLinkedList(1000);
        head.next = head;

        CircularLinkedList node01 = new CircularLinkedList(2000);
        node01.next = node01;

        CircularLinkedList node02 = new CircularLinkedList(3000);
        CircularLinkedList node03 = new CircularLinkedList(4000);
        node02.next = node03;
        node03.next = node02;

        CircularLinkedList node04 = new CircularLinkedList(3500);
        node04.next = node03;
        node03.next = node04;

        CircularLinkedList node05 = new CircularLinkedList(3000);
        CircularLinkedList node06 = new CircularLinkedList(3500);
        CircularLinkedList node07 = new CircularLinkedList(4000);
        node05.next = node06;
        node06.next = node07;
        node07.next = node05;



        System.out.println("Iterate over circular linked list");
        iterate(head);

        System.out.println("\nInsert At the begining of circular linked list");
        iterate(insertAtBegin(head, 900));

        System.out.println("\nInsert At the begining of circular linked list - Efficient");
        iterate(insertAtBegin(node01, 800));

        System.out.println("\nDelete from the begining");
        //iterate(removeTheHead(node02));

        System.out.println("\nDelete from the begining - Efficient");
        iterate(removeHeadEfficient(node04));

        System.out.println("\nInsert after node k in sorted linked list");
        iterate(sortedInsert(node05, 3750));

        System.out.println("\nDetect a loop");
        System.out.println(detectALoopInTheSLL(node05));

        System.out.println("\nDetect a loop using Floyd's Cycle detection");
        System.out.println(detectLoopUsingFloydCycleDetection(node05));
    }

    //Corner case when there is only one element inside the Circular linked list
    //in those scenarios while loop or for loop iteration will not work
    //as the condition to iterate till curr.next==head will stop iteration even for once
    public static void iterate(CircularLinkedList head) {
        if (head == null) {
            return;
        }
        CircularLinkedList curr = head;
        do {
            System.out.print(curr.data + " ");
            curr = curr.next;
        } while (!curr.equals(head));
    }

    //Time complexity O(n)
    public static CircularLinkedList insertAtBegin(CircularLinkedList head, int k) {
        CircularLinkedList newhead = new CircularLinkedList(k);
        if (head == null) {
            newhead.next = newhead;
            return newhead;
        }
        CircularLinkedList curr = head;
        do {
            curr = curr.next;
        } while (curr.next != head);
        newhead.next = head;
        curr.next = newhead;
        return newhead;
    }

    //Time complexity O(1)
    public static CircularLinkedList insertAtBeginEfficient(CircularLinkedList head, int k) {
        CircularLinkedList newhead = new CircularLinkedList(k);
        if (head == null) {
            newhead.next = newhead;
            return newhead;
        }
        //insert new node after head
        newhead.next = head.next;
        head.next = newhead;

        //swap the new node data with the current head
        int temp = head.data;
        head.data = newhead.data;
        newhead.data = temp;
        //return head
        return head;
    }

    //remove the head in O(n)
    public static CircularLinkedList removeTheHead(CircularLinkedList head) {
        if (head == null) {
            return null;
        }
        CircularLinkedList curr = head;
        do {
            curr = curr.next;
        } while (curr.next != head);

        curr.next = head.next;
        return curr.next;
    }

    //remove from front in O(1)
    public static CircularLinkedList removeHeadEfficient(CircularLinkedList head) {
        if (head == null) {
            return null;
        }

        CircularLinkedList curr = head.next;
        int temp = head.next.data;
        head.next.data = head.data;
        head.data = temp;

        head.next = curr.next;
        curr.next = null;
        return head;
    }

    //delete the kth node of the Linked List
    public static CircularLinkedList removeKthNode(CircularLinkedList head, int q) {
        if (head == null) {
            return head;
        }
        if (q == 1) {
            removeTheHead(head);
        }

        CircularLinkedList curr = head;
        for (int i = 0; i < q - 2; i++) {
            curr = curr.next;
        }
        curr.next = curr.next.next;
        return head;
    }

    public static CircularLinkedList sortedInsert(CircularLinkedList head, int k) {
        if (head == null) {
            return head;
        }
        CircularLinkedList curr = head;
        if(k < curr.data){
            CircularLinkedList temp = new CircularLinkedList(k);
            temp.next=head;
            head.next=temp;
            return temp;
        }

        // run the loop till we reach that element
        // which is less then the element to be inserted
        // or till we find the head
        while (curr.next != head && curr.next.data < k) {
            curr = curr.next;
        }
        CircularLinkedList temp = new CircularLinkedList(k);
        temp.next=curr.next;
        curr.next=temp;
        return head;
    }

    public static boolean detectALoopInTheSLL(CircularLinkedList head) {
        Set<CircularLinkedList> visitedNode = new HashSet<>();
        CircularLinkedList curr = head;
        while (curr != null) {
            if (visitedNode.contains(curr)) {
                return true;
            }
            visitedNode.add(curr);
            curr = curr.next;
        }
        return false;
    }

    public static boolean detectLoopUsingFloydCycleDetection(CircularLinkedList head) {
        if (head == null) {
            return false;
        }
        CircularLinkedList slow = head;
        CircularLinkedList fast = head;

        //check for fast.next condition as for LinkedList with even no of nodes
        // will through NullPointerException
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast.equals(slow)) {
                return true;
            }
        }
        return false;
    }
}
