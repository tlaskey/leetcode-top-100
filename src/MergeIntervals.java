import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        /*
        https://leetcode.com/problems/merge-intervals/

        input: [[1,3],[2,6],[8,10],[15,18]]
        output: [[1,6],[8,10],[15,18]] Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].

        in: [[1,4],[4,5]]
        out: [[1,5]]

        in: [[1,7],[2,6]]
        out: [[1,7]]
        */

        // Sort the intervals based off start value.
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });

        LinkedList<int[]> merged = new LinkedList<>();

        for (int[] interval : intervals) {
            if (merged.isEmpty() || merged.getLast()[1] < interval[0]) merged.add(interval);
            else merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
        }

        for (int[] x : intervals) {
            System.out.printf("%s, %s \n", x[0], x[1]);
        }

        return merged.toArray(new int[merged.size()][]);
    }
}
