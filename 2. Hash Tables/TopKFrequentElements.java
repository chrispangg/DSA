import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;

class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {

        // frequency map
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // bucket sort on freq
        ArrayList<Integer>[] bucket = new ArrayList[nums.length + 1];
        for (int key : map.keySet()) {
            int frequency = map.get(key);
            if (bucket[frequency] == null) {
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(key);
        }

        //generate result
        int[] res = new int[k];
        int count = 0;
        for (int i = bucket.length - 1; i >= 0; i--) {
            if (bucket[i] != null) {
                for (Integer value : bucket[i]) {
                    res[count] = value;
                    count++;
                    if (count == k) {
                        return res;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TopKFrequentElements t = new TopKFrequentElements();
        int[] nums = new int[] { 4, 1, -1, 2, -1, 2, 3 };
        System.out.println(Arrays.toString(t.topKFrequent(nums, 2)));

    }
}

//Solutioning:
    //Use a hashmap to count the frequency
    //Use a variant of bucket sort:
        //List - size = nums.length
        //index: store frequency
        //value: store a list of keys that matches the frequency
    //return array of the top k elements (using a backward for-loop to generate the result)

// Time Complexity = O(n), because 
