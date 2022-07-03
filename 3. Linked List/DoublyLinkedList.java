class DoublyLinkedList {

    Node head;

    // node class
    class Node {
        int data;
        Node next;
        Node prev;

        public Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
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
            newNode.prev = currentNode;
        }
    }

    public void prepend(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
        } else {
            Node currentNode = head;
            newNode.next = currentNode;
            currentNode.prev = newNode;
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
            newNode.prev = currentNode;
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
            if (currentNode.next != null) {
                currentNode.next.prev = currentNode;
            }
        }
    }

    public void print() {
        Node currentNode = head;
        while (currentNode != null) {
            if(currentNode.prev != null) {
                System.out.print(currentNode.prev.data + " -> ");
            } else {
                System.out.print("n -> ");
            }
            System.out.print(currentNode.data);
            if(currentNode.next != null) {
                System.out.println(" -> " + currentNode.next.data);
            } else {
                System.out.println(" -> n");
            }
            currentNode = currentNode.next;
        }
    }

    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        list.add(1);
        list.prepend(0);
        list.add(2);
        list.add(4);
        list.insert(3, 3);
        list.remove(4);
        list.print();
    }
}