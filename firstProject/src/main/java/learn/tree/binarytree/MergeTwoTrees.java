package learn.tree.binarytree;

public class MergeTwoTrees {

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(3);
        root1.left.left = new TreeNode(5);
        root1.right = new TreeNode(2);

        TreeNode root2 = new TreeNode(2);
        root2.left = new TreeNode(1);
        root2.left.right = new TreeNode(4);
        root2.right = new TreeNode(3);
        root2.right.right = new TreeNode(7);

        MergeTwoTrees mergeTwoTrees = new MergeTwoTrees();
        TreeNode root  = mergeTwoTrees.mergeTrees(root1, root2);

        TreeApplication.inOrderTraversal(root);

    }

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        helper(root1, root2);
        return root1;
    }

    private void helper(TreeNode root1, TreeNode root2) {
        if ((root2.left == null && root1.left == null) || (root1.right == null && root2.right == null)) {
            return;
        }
        root1.data = root1.data + root2.data;

        if (root2.left == null) {
            return;
        }

        if (root2.right == null) {
            return;
        }

        if (root1.left == null && root2.left != null) {
            root1.left = root2.left;
        }

        if (root1.right == null && root2.right != null) {
            root1.right = root2.right;
        }

        mergeTrees(root1.left, root2.left);
        mergeTrees(root1.right, root2.right);


        return;
    }

}
