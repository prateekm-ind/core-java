package learn.linkedlist;

public class DoublyLinkedListApplication {
    public static void main(String[] args) {
        DoublyLinkedListNode head = new DoublyLinkedListNode(100);
        DoublyLinkedListNode node2 = new DoublyLinkedListNode(150);
        head.next = node2;
        node2.prev = head;
        DoublyLinkedListNode node3 = new DoublyLinkedListNode(200);
        node2.next = node3;
        node3.prev = node2;
        DoublyLinkedListNode node4 = new DoublyLinkedListNode(250);
        node4.prev = node3;


        DoublyLinkedListNode node01 = new DoublyLinkedListNode(100);
        DoublyLinkedListNode node02 = new DoublyLinkedListNode(150);
        node01.next = node02;
        node02.prev = node01;
        DoublyLinkedListNode node03 = new DoublyLinkedListNode(200);
        node02.next = node03;
        node03.prev = node02;
        DoublyLinkedListNode node04 = new DoublyLinkedListNode(250);
        node04.prev = node03;

        System.out.println("\nTraverse a linked list");
        traverseLinkedList(head);

        System.out.println("\nReverse a Doubly Linked List");
        traverseLinkedList(reverseLinkedList(node01));

        System.out.println("\nInsert at the beginning of the Linked List");
        traverseLinkedList(insertAtBegin(head, 75));

        System.out.println("\nInsert at the end of the Doubly Linked List");
        traverseLinkedList(insertAtTheEnd(head, 225));

        System.out.println("\nRemove the last node from the doubly linked list");
        traverseLinkedList(deleteLastNode(head));

        System.out.println("\nRemove the first node from the doubly linked list");
        traverseLinkedList(deleteHead(head));



    }

    public static void traverseLinkedList(DoublyLinkedListNode head) {
        DoublyLinkedListNode curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
    }

    public static DoublyLinkedListNode insertAtBegin(DoublyLinkedListNode head, int k) {
        if (head == null) {
            return new DoublyLinkedListNode(k);
        }
        DoublyLinkedListNode node = new DoublyLinkedListNode(k);
        node.next = head;
        head.prev = node;
        head = node;
        return head;
    }

    //Idea: iterate to the end and then insert at the end of the LinkedList
    public static DoublyLinkedListNode insertAtTheEnd(DoublyLinkedListNode head, int k) {
        if (head == null) {
            return new DoublyLinkedListNode(k);
        }
        DoublyLinkedListNode node = new DoublyLinkedListNode(k);
        DoublyLinkedListNode curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = node;
        node.prev = curr;
        return head;
    }


    //Idea: maintain prev and next two different node to track the
    //prev and next reference of the doubly-linked-list
    public static DoublyLinkedListNode reverseLinkedList(DoublyLinkedListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        DoublyLinkedListNode curr = head;
        while (curr != null) {

            DoublyLinkedListNode prev = curr.prev;
            DoublyLinkedListNode next= curr.next;
            curr.prev = next;
            curr.next = prev;
            if (curr.prev == null) {
                return curr;
            }
            curr = curr.prev;
        }
        return head;
    }

    public static DoublyLinkedListNode deleteHead(DoublyLinkedListNode head){
        if(head==null || head.next==null){
            return null;
        }
        DoublyLinkedListNode curr=head.next;
        head.next=null;
        curr.prev=null;
        return curr;
    }

    //Idea: Get the hold of the last node and use that to call the next of penultimate node
    public static DoublyLinkedListNode deleteLastNode(DoublyLinkedListNode head){
        if(head==null || head.next==null){
            return null;
        }
        DoublyLinkedListNode curr= head;
        while(curr.next!=null){
            curr= curr.next;
        }
        curr.prev.next=null;
        curr.prev=null;
        return head;
    }
}
