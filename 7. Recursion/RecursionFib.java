package Recursion;
public class RecursionFib {
    public static void main(String[] args) {
        RecursionFib rf = new RecursionFib();
        System.out.println(rf.fibonacciIterative(8));
        System.out.println(rf.fibonacciRecurisve(5));
    }

    public int fibonacciIterative(int n) { //O(n)
        if (n == 0) return 0;

        int result = 1;
        int prevResult = 0;
        int pointer;
        for (int i = 1; i < n; i++) {
            pointer = result;
            result = result + prevResult;
            prevResult = pointer;
        }

        return result;
    }

    public int fibonacciRecurisve(int n) { //(2^N)
        if (n < 2) return n;
        return fibonacciRecurisve(n-1) + fibonacciRecurisve(n-2);
    }
}

// 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144