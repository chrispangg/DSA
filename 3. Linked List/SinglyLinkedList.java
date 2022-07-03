import java.util.ArrayList;

class SinglyLinkedList {

    Node head;

    // node class
    class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public void add(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
        } else {
            Node currentNode = head;
            while (currentNode.next != null) {
                currentNode = currentNode.next;
            }
            currentNode.next = newNode;
        }
    }

    public void prepend(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
        } else {
            Node currentNode = head;
            newNode.next = currentNode;
            head = newNode;
        }
    }

    public void insert(int index, int data) {
        Node newNode = new Node(data);
        if (index == 0) {
            prepend(data);
        } else {
            int count = 0;
            Node currentNode = head;
            while (currentNode.next != null && count < index - 1) {
                currentNode = currentNode.next;
                count++;
            }
            newNode.next = currentNode.next;
            currentNode.next = newNode;
        }
    }

    public void remove(int index) {
        if (index == 0) {
            Node currentNode = head;
            currentNode = currentNode.next;
            head = currentNode;
        } else {
            Node currentNode = head;
            int count = 0;
            while (currentNode.next != null && count < index - 1) {
                currentNode = currentNode.next;
                count++;
            }
            currentNode.next = currentNode.next.next;
        }
    }

    public void reverse() {
        Node currentNode = head;
        ArrayList<Node> arr = new ArrayList<Node>();
        if (currentNode != null) {
            while (currentNode.next != null) {
                arr.add(currentNode);
                currentNode = currentNode.next;
            }
            head = currentNode;

            for (int i = arr.size() - 1; i >= 0; i--) {
                currentNode.next = arr.get(i);
                currentNode = currentNode.next;
            }
            currentNode.next = null;
        }
    }

    public void reverse2() {
        Node currentNode = head;
        Node nextNode = currentNode.next;
        Node prevNode = null;
        if (currentNode != null) {
            while (currentNode.next != null) {
                nextNode = currentNode.next; //save next node before overwriting
                currentNode.next = prevNode; //set next node to previous node
                prevNode = currentNode; //make previous node the current node
                currentNode = nextNode; //move currentNode to the next node
            }
            currentNode.next = prevNode; //point the last node to the previous node
            head = currentNode; //make the last node the head
        }
    }

    public void print() {
        Node currentNode = head;
        while (currentNode != null) {
            System.out.println(currentNode.data);
            currentNode = currentNode.next;
        }
    }

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.add(1);
        list.prepend(0);
        list.add(2);
        list.add(4);
        list.insert(3, 3);
        list.remove(4);
        list.reverse2();
        list.print();

    }
}