package learn.linkedlist;

public class LinkedListApplication {
    public static void main(String[] args) {
        LinkedListNode head = new LinkedListNode(10);
        head.next = new LinkedListNode(20);
        head.next.next = new LinkedListNode(30);
        head.next.next.next = new LinkedListNode(40);

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

    //insert at the begining of the linked list
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
}
