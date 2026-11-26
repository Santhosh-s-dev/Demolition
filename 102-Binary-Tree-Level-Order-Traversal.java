/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
    if (root == null) return result;

    Queue<TreeNode> currentLevel = new LinkedList<>();
    currentLevel.add(root);

    while (!currentLevel.isEmpty()) {
        Queue<TreeNode> nextLevel = new LinkedList<>();
        List<Integer> levelValues = new ArrayList<>();

        while (!currentLevel.isEmpty()) {
            TreeNode node = currentLevel.poll();
            levelValues.add(node.val);
            if (node.left != null) nextLevel.add(node.left);
            if (node.right != null) nextLevel.add(node.right);
        }

        result.add(levelValues);
        currentLevel = nextLevel;
    }
    return result;
}

}