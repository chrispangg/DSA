import java.util.*;

class StackArray {

    ArrayList<Integer> arr;

    public StackArray() {
        arr = new ArrayList<Integer>();
    }

    public int peek() {
        int pos = arr.size() - 1;
        return arr.get(pos);
    }

    public void push(int data) {
        arr.add(data);
    }

    public void pop() {
        int pos = arr.size() - 1;
        arr.remove(pos);
    }

    public void print() {
        System.out.println(arr.toString());
    }

    public static void main(String[] args) {
        StackArray s = new StackArray();
        s.push(5);
        s.pop();
        s.push(10);
        s.push(40);
        s.push(50);
        s.push(30);
        s.print();
    }
}