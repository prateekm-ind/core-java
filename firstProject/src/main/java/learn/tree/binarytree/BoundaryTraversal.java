package learn.tree.binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 * - left-traversal
 * - leaf-traversal
 * - right-traversal
 * */
public class BoundaryTraversal {

    public void addLeftBoundary(TreeNode root, List<Integer> res) {
        TreeNode curr = root.getLeft();
        while (curr != null) {
            if (isLeaf(curr) == false) res.add(curr.getData());
            if (curr.getLeft() != null) curr = curr.getLeft();
            else curr = curr.getRight();
        }

    }

    public void addLeafBoundary(TreeNode root, List<Integer> res) {
        if (isLeaf(root)) {
            res.add(root.getData());
            return;
        }
        if (root.getLeft() != null) addLeafBoundary(root.getLeft(), res);
        if (root.getRight() != null) addLeafBoundary(root.getRight(), res);
    }

    public void addRightBoundary(TreeNode root, List<Integer> res) {
        TreeNode curr = root;
        Stack<Integer> stack = new Stack<>();
        while (curr != null){
            if(isLeaf(curr) == false) stack.push(curr.getData());
            if(curr.getRight() != null) curr = curr.getRight();
            else curr = curr.getLeft();
        }

        while (!stack.isEmpty()){
            res.add(stack.pop());
        }
    }

    public void printBoundary(TreeNode root, List<Integer> res) {
        if (isLeaf(root)) {
            res.add(root.getData());
            return;
        }
        addLeftBoundary(root, res);
        addLeafBoundary(root, res);
        addRightBoundary(root, res);
        return;
    }

    private boolean isLeaf(TreeNode root) {
        return (root.getLeft() == null && root.getRight() == null);
    }

    public static void main(String[] args) {
        BoundaryTraversal boundaryTraversal = new BoundaryTraversal();
        TreeNode root = new TreeNode(1);
        root.setRight(new TreeNode(2));
        root.setLeft(new TreeNode(3));
        root.getLeft().setLeft(new TreeNode(4));
        root.getLeft().setRight(new TreeNode(5));
        root.getRight().setLeft(new TreeNode(7));
        root.getRight().setRight(new TreeNode(8));
        root.getLeft().getRight().setLeft(new TreeNode(6));
        root.getRight().getRight().setLeft(new TreeNode(9));
        root.getRight().getRight().setRight(new TreeNode(10));
        root.getRight().getRight().getRight().setLeft(new TreeNode(11));
        root.getLeft().getRight().setRight(new TreeNode(51));

        List<Integer> res = new ArrayList<>();
        boundaryTraversal.printBoundary(root, res);
        for (int i = 0; i < res.size(); i++) {
            System.out.print(res.get(i) + " ");
        }
    }
}
