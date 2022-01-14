package learn.linkedlist;

public class CircularLinkedList {
    int data;
    CircularLinkedList next;


    // Circular Linked List must always maintain its circular nature
    // this should be maintained after every insertion and deletion

    //Application
    //1 - Traverse the whole list from any node
    //2 - Used for the implementation of Algorithm like Round-Robin
    //3 - We can insert at the beginning and at the end by just maintaining a tail

    //Disadvantage
    //All sort of operations becomes complex due to its circular nature
    public CircularLinkedList(int data) {
        this.data = data;
        this.next=null;
    }
}
