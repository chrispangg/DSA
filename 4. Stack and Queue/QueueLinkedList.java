class QueueLinkedList {
    class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
            
        }
    }

    Node head;
    Node tail;

    public QueueLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public int peek() {
        return head.data;
    }

    public void enqueue(int data) {
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

    public void dequeue() {
        if (head == null) {
            return;
        }
        Node currentNode = head;
        head = currentNode.next;

    }

    public void print() {
        Node currentNode = head;
        while (currentNode != null) {
            System.out.println(currentNode.data);
            currentNode = currentNode.next;
        }
    }

    public static void main(String[] args) {
        QueueLinkedList s = new QueueLinkedList();
        s.enqueue(1);
        s.enqueue(3);
        s.enqueue(5);
        s.dequeue();
        s.dequeue();
        s.print();
    }
}
