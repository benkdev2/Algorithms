public class IsSameTree {

    //Given two binary trees, write a function to check if they are the same or not.
    //
    //Two binary trees are considered the same if they are structurally identical and the nodes have the same value.
    //
    // Solution is O(h) worst case time complexity and O(n) space complexity, where n is the number of nodes in the tree
    //
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        } else if (p.val != q.val) {
            return false;
        }

        if (p.left == null && q.left == null) {
            return isSameTree(p.right, q.right);
        } else if (p.right == null && q.right == null) {
            return isSameTree(p.left, q.left);
        } else {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
    }
}
