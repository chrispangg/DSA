import java.util.Hashtable;
import java.util.LinkedList;

public class Memoization1 {
    Hashtable<Integer, Integer> cache;

    public int addTo100(int n){
        return n + 100;
    }

    public int memoizedAddTo100(int n){
        if(cache.containsKey(n)){
            System.out.println(n + " was cached from before");
            return cache.get(n);
        } else {
            System.out.println(n + " is a new number, caching");
            int result = addTo100(n);
            cache.put(n, result);
            return result;
        }
    }

    public static void main(String[] args) {
        Memoization1 m = new Memoization1();
        m.cache = new Hashtable<Integer, Integer>();
        m.memoizedAddTo100(20);
        m.memoizedAddTo100(20);
    }
}
