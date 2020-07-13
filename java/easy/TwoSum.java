public class TwoSum {
    // Two pass hashtable soln.
    public int[] twoSum(int[] nums, int target) {
        // a + b = target
        // -b = a - target
        // b = -(a - target)
        Hashtable<Integer, Integer> table = new Hashtable<>();

        for (int i = 0; i < nums.length; i++) {
            table.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int complement = -(nums[i] - target);
            if (table.containsKey(complement) && table.get(complement) != i) return new int[]{i, table.get(complement)};
        }
        return new int[2];
    }

    // Can speed up with a one pass hashtable.
    public int[] twoSumTwo(int[] nums, int target) {
        Hashtable<Integer, Integer> table = new Hashtable<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = -(nums[i] - target);
            if (table.containsKey(complement)) return new int[]{i, map.get(complement)};
            map.put(nums[i], i);
        }

        return new int[2];
    }
}