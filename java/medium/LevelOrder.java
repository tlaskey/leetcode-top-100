public class LevelOrder {
    // https://leetcode.com/problems/binary-tree-level-order-traversal/
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levels = new ArrayList<>();
        if (root == null) return levels;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            List<TreeNode> currLevel = new ArrayList<>();
            List<Integer> currLevelInt = new ArrayList<>();

            while(!q.isEmpty()) {
                TreeNode currNode = q.poll();
                currLevel.add(currNode);
                currLevelInt.add(currNode.val);
            }

            for (TreeNode node : currLevel) {
                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }
            levels.add(currLevelInt);
        }
        return levels;
    }
}