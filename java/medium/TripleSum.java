import java.util.*;

public class TripleSum {
    // https://leetcode.com/problems/3sum/
    public List<List<Integer>> threeSum(int[] nums) {
        HashSet<List<Integer>> uniqueTrip = new HashSet<>();
        Hashtable<Integer, Integer> table = new Hashtable<>();

        // Initialize hashtable with nums[i] -> i
        for (int i = 0; i < nums.length; i++) {
            if (!table.containsKey(nums[i])) {
                table.put(nums[i], i);
            }
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int complement = -(nums[i] + nums[j]);
                int compIndex = table.getOrDefault(complement, -1);
                if (compIndex != -1 && compIndex != i && compIndex != j) {
                    ArrayList<Integer> triplet = new ArrayList<>(Arrays.asList(nums[i], nums[j], complement));
                    Collections.sort(triplet);

                    uniqueTrip.add(triplet);
                }
            }
        }
        return new ArrayList<>(uniqueTrip);
    }
}
