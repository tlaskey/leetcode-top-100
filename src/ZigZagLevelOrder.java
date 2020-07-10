import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigZagLevelOrder {
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        boolean reverse = false;
        while (!q.isEmpty()) {
            List<TreeNode> currLevel = new ArrayList<>();
            List<Integer> currLevelInt = new ArrayList<>();

            while (!q.isEmpty()) {
                TreeNode currNode = q.poll();
                currLevel.add(currNode);

            }
            for (TreeNode node : currLevel) {
                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }
            if (reverse) {
                for (int i = currLevel.size() - 1; i >= 0; i--) {
                    TreeNode node = currLevel.get(i);
                    currLevelInt.add(node.val);
                }
            }
            else {
                for (TreeNode node : currLevel) {
                    currLevelInt.add(node.val);
                }
            }

            reverse = !reverse;
            result.add(currLevelInt);
        }
        return result;
    }

    //[3,9,20,null,null,15,7]
    public static void main (String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(zigzagLevelOrder(root));
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
