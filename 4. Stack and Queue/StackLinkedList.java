class StackLinkedList {
    class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head;

    //with StackedLinkedList adds to the head of the list to simulate the tail
    public StackLinkedList() {
        this.head = null;
    }

    // add to the head of the list
    public void push(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    // pop the reversed-head of the list off
    public void pop() {
        if (head == null) {
            return;
        }
        head = head.next;
    }

    // look at the head of the list
    public int peek() {
        if(!this.isEmpty()){
            return head.data;
        }
        return -1;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void printNode(){
        Node current = head;
        while(current != null){
            System.out.println(current.data);
            current = current.next;
        }
    }

    public static void main(String[] args) {
        StackLinkedList s = new StackLinkedList();
        s.push(5);
        s.pop();
        s.push(10);
        s.push(40);
        s.push(50);
        s.push(30);
        s.printNode();
    }

}