package learn.tree;

public class BSTApplication {
    public static void main(String[] args) {
        BSTNode root = new BSTNode(15);
        root.left = new BSTNode(5);
        root.right = new BSTNode(20);
        root.left.left = new BSTNode(3);
        root.right.left = new BSTNode(18);
        root.right.right = new BSTNode(80);
        root.right.left.left = new BSTNode(16);

        System.out.println(search(root, 18));
    }

    public static boolean search(BSTNode root, int k) {
        if (root == null) {
            return false;
        }
        if (k == root.val) {
            return true;
        }
        if (k < root.val) {
            return search(root.left, k);
        }
        if (k > root.val) {
            return search(root.right, k);
        }
        return false;
    }

    public static BSTNode insertRecursive(BSTNode root, int k) {
        if (root == null) {
            //if root id null create a new root or
            //will come into this condition when a leaf node is added to BST
            return new BSTNode(k);
        }
        if (root.left.val > k) {
            // reassigned already existing root values or
            // create a new value and assigned it to left of root
            root.left = insertRecursive(root.left, k);
        }
        if (root.right.val < k) {
            // reassigned already existing root values or
            // create a new value and assigned it to right of root
            root.right = insertRecursive(root.right, k);
        }
        return root;
    }

    public static BSTNode insertIterative(BSTNode root, int k) {
        BSTNode temp = new BSTNode(k);
        BSTNode parent = null;
        BSTNode curr = root;
        while (curr != null) {
            parent = curr;
            if (curr.val > k) {
                curr = curr.left;
            } else if (curr.val < k) {
                curr = curr.right;
            } else {
                return root;
            }
        }
        if (parent == null) {
            return temp;
        }
        if (parent.val > k) {
            parent.left = temp;
        } else {
            parent.right = temp;
        }
        return root;
    }
}
