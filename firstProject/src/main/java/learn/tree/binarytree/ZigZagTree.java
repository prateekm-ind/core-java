package learn.tree.binarytree;

import java.util.*;

/*
* Idea : to use leftToRight as a parameter based on that
* insert either into the array directly or
* use stack to insert data into the array in case of right to left
* Reason : to use array was insert at last index of arraylist not possible
* ret of the logic is similar to level order traversal
* */
public class ZigZagTree {
    //zigzag iteration of a binary tree
    public void solution(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        boolean leftToRight = true;

        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> row = new ArrayList<>(size);
            Stack<TreeNode> stack = new Stack<TreeNode>();
            for (int i = 0; i < size; i++) {
                //Cannot insert at the last index of the arraylist
                //int index = leftToRight ? i : size - 1 - i;
                TreeNode e = queue.poll();
                if(leftToRight){
                    row.add(i, e.getData());
                }else {
                    stack.push(e);
                }

                if (e.getLeft() != null) {
                    queue.add(e.getLeft());
                }
                if (e.getRight() != null) {
                    queue.add(e.getRight());
                }
            }
            if(!leftToRight){
                while(!stack.isEmpty()) {
                    row.add(stack.pop().getData());
                }
            }
            leftToRight = !leftToRight;

            result.add(row);
        }

        for (int i = 0; i < result.size(); i++) {
            for (int j = 0; j < result.get(i).size(); j++) {
                System.out.print(" " + result.get(i).get(j));
            }
        }
    }

    public static void main(String[] args) {
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

        ZigZagTree zigZagTree = new ZigZagTree();
        zigZagTree.solution(root);
    }
}