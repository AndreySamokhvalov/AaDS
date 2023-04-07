
class LinkedList {

    static Node head;

    static class Node {

        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    // метод для разварота списка
    Node reverse(Node node) {
        Node prev = null;
        Node current = node;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        node = prev;
        return node;
    }

    // печать списка
    void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.head = new Node(123);
        list.head.next = new Node(543);
        list.head.next.next = new Node(4);
        list.head.next.next.next = new Node(908);

        System.out.println("Заданный список");
        list.printList(head);
        head = list.reverse(head);
        System.out.println("");
        System.out.println("Развернутый список");
        list.printList(head);
    }
}
