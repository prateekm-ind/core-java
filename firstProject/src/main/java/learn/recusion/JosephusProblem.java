package learn.recusion;

import learn.linkedlist.CircularLinkedList;

public class JosephusProblem {
    //using Circular linked list concept
    public void solution(int k, CircularLinkedList head) {
        if (head.getNext() == head) {
            System.out.println("\n" + head.getData());
            return;
        }
        CircularLinkedList curr = head;
        for (int i = 0; i < k - 2; i++) {
            curr = curr.getNext();
        }
        curr.setNext(curr.getNext().getNext());
        solution(k, curr.getNext());
    }

    public static void main(String[] args) {
        JosephusProblem obj = new JosephusProblem();
        CircularLinkedList head = new CircularLinkedList(0);
        head.setNext(new CircularLinkedList(1));
        head.getNext().setNext(new CircularLinkedList(2));
        head.getNext().getNext().setNext(new CircularLinkedList(3));
        head.getNext().getNext().getNext().setNext(new CircularLinkedList(4));
        //System.out.println(" 4: " + head.getNext().getNext().getNext().getNext().getData());
        head.getNext().getNext().getNext().getNext().setNext(head);
        CircularLinkedList curr = head;
        do {
            System.out.print(curr.getData() + " ");
            curr = curr.getNext();
        } while (curr != head);

        obj.solution(3, head);

    }
}
