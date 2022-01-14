package learn.linkedlist;

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


        System.out.println("Iterate over circular linked list");
        iterate(head);

        System.out.println("\nInsert At the begining of circular linked list");
        iterate(insertAtBegin(head, 900));

        System.out.println("\nInsert At the begining of circular linked list - Efficient");
        iterate(insertAtBegin(node01, 800));

        System.out.println("\nDelete from the begining");
        iterate(removeTheHead(node02));
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

    //remove the head
    public static CircularLinkedList removeTheHead(CircularLinkedList head) {
        if (head == null) {
            return null;
        }
        CircularLinkedList curr = head;
        do {
            curr = curr.next;
        } while (curr.next != head);

        curr.next= head.next;
        return curr.next;
    }

    public static CircularLinkedList removeHeadEfficient(CircularLinkedList head){
        if(head == null){

        }

    }
}
