package learn.tree;

import java.util.*;

public class TreeApplication {
    static int maxLevel = 0;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(6);
        root.right.right.left = new TreeNode(9);
        root.right.right.right = new TreeNode(10);
        root.right.right.right.left = new TreeNode(11);
        root.left.right.right = new TreeNode(51);

        System.out.println("pre-order");
        //root->left->right
        preOrderTraversal(root);
        System.out.println("\nin-order");
        //left->root->right
        inOrderTraversal(root);
        System.out.println("\npost-order");
        //left->right->root
        postOrderTraversal(root);
        //height of tree
        System.out.println("\nheight of tree : " + heightOfTree(root));
        System.out.println("\npre-order-iterative");
        List<Integer> list = preOrderTraversalIterative(root);
        list.stream().forEach((data) -> {
            System.out.print(data + " ");
        });
        //print the kth node
        System.out.println("\nprint the kth node : ");
        printKthNode(root, 1, 3);

        //max element in the binary-tree
        System.out.println("\nMax-Element in the binary-tree :");
        System.out.print(maxBinaryTree(root, Integer.MIN_VALUE));

        //print left-most elements at every level
        System.out.println("\nLeft-most elements at every level of binary-tree :");
        printOnlyLeftmostElementsAtEveryLevel(root, 1);

        System.out.println("\nSize of the tree: " + sizeOfTree(root));


        TreeNode csum = new TreeNode(20);
        csum.left = new TreeNode(8);
        csum.right = new TreeNode(12);
        csum.right.left = new TreeNode(3);
        csum.right.right = new TreeNode(9);

        System.out.println("child sum: " + childrenSum(csum));

        TreeNode node = new TreeNode(10);
        node.left = new TreeNode(5);
        node.right = new TreeNode(30);
        node.right.left = new TreeNode(15);
        node.right.right = new TreeNode(20);
        System.out.println("is-balanced: " + isBalanced(node));

        levelOrderTraversal(node);

        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(2);
        tree.left.left = new TreeNode(3);
        tree.left.right = new TreeNode(4);
        tree.right.left = new TreeNode(4);
        tree.right.right = new TreeNode(3);
        System.out.println("is-symmetric: node - " + isSymmetric(node));
        System.out.println("is-symmetric: tree - " + isSymmetric(tree));

        levelOrderTraversalLineByLine(root);

        System.out.println("Max width of root : " + widthOfTree(root));
        System.out.println("Max width of tree : " + widthOfTree(tree));
        System.out.println("Max width of node : " + widthOfTree(node));
        System.out.println("Diameter of a root: " + diameterOfATree(root));
        System.out.println("Diameter of a tree: " + diameterOfATree(tree));
        System.out.println("Diameter of a node: " + diameterOfATree(node));

        System.out.println("Path: " + findPathFromRootToNode(root, 51));

        System.out.println("Common Path: " + lca(root, 10, 11));

        //Tree converted into graph
        System.out.println("Tree to Graph : Hash table with node and their parents");
        convertTreeToGraph(root);
        System.out.println("Root exists: " + findNode(root, 51).data);

        System.out.println("Elements at distance 2 from 3:" + findNthNodesElements(root, 8, 2));
        System.out.println("burn binary tree: " + burnBinaryTree(51, root));

        System.out.println("Iterative in-order:" + iterativeInOrder(root));

        TreeNode itree = new TreeNode(4);
        itree.left = new TreeNode(2);
        itree.right = new TreeNode(7);
        itree.left.left = new TreeNode(1);
        itree.left.right = new TreeNode(3);
        itree.right.left = new TreeNode(6);
        itree.right.right = new TreeNode(9);

        TreeNode invertedTree = invertTree(itree);
        System.out.println("actual tree : ");
        levelOrderTraversal(itree);
        System.out.println("inverted tree : ");
        levelOrderTraversal(invertedTree);
    }

    //root->left->right
    public static void preOrderTraversal(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        System.out.print(treeNode.data + " ");
        preOrderTraversal(treeNode.left);
        preOrderTraversal(treeNode.right);
    }

    //left->root->right
    public static void inOrderTraversal(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        inOrderTraversal(treeNode.left);
        System.out.print(treeNode.data + " ");
        inOrderTraversal(treeNode.right);
    }

    //left->right->root
    public static void postOrderTraversal(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        postOrderTraversal(treeNode.left);
        postOrderTraversal(treeNode.right);
        System.out.print(treeNode.data + " ");
    }


    public static int heightOfTree(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }
        return 1 + Math.max(heightOfTree(treeNode.left), heightOfTree(treeNode.right));
    }

    //root->left->right
    public static List<Integer> preOrderTraversalIterative(TreeNode treeNode) {
        List<Integer> preOrder = new ArrayList<>();
        if (treeNode == null) {
            return preOrder;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(treeNode);
        while (!stack.isEmpty()) {
            treeNode = stack.pop();
            preOrder.add(treeNode.data);
            if (treeNode.right != null) {
                stack.push(treeNode.right);
            }
            if (treeNode.left != null) {
                stack.push(treeNode.left);
            }
        }
        return preOrder;
    }

    //    if (height of leaf-node>1
    public static boolean isBalanced01(TreeNode root) {
        return balancedHeight(root) != -1;
    }

    public static int balancedHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = balancedHeight(root.left);
        if (leftHeight == -1) return -1;
        int rightHeight = balancedHeight(root.right);
        if (rightHeight == -1) return -1;

        if (Math.abs(leftHeight - rightHeight) > 1) return -1;
        return Math.max(leftHeight, rightHeight);
    }

    //print the kth node from the root
    //My impl of the problem
    public static void printKthNode(TreeNode root, int k, int val) {
        if (root == null) {
            return;
        }
        if (k == val) {
            System.out.print(root.data + " ");
            return;
        }
        printKthNode(root.left, k + 1, val);
        printKthNode(root.right, k + 1, val);
    }

    //GFG impl of the problem
    public static void printKthNodeGFG(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        if (k == 0) {
            System.out.println(root.data + " ");
            return;
        }
        printKthNodeGFG(root.left, k - 1);
        printKthNodeGFG(root.right, k - 1);
    }

    //Maximum value of the binary tree
    public static int maxBinaryTree(TreeNode root, int max) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        int left = maxBinaryTree(root.left, max);
        int right = maxBinaryTree(root.right, max);
        return Math.max(root.data, Math.max(left, right));
    }

    //print the leftmost node value at every level
    //think of an iterative solution
    //Idea: was to maintain a var - maxlevel and currentlevel and maxlevel is less then currentlevel
    //print the elements and set maxlevel to currentlevel or else got to the next recursive call
    public static void printOnlyLeftmostElementsAtEveryLevel(TreeNode root, int level) {
        if (root == null) {
            return;
        }
        if (maxLevel < level) {
            System.out.print(root.data + " ");
            maxLevel = level;
        }
        printOnlyLeftmostElementsAtEveryLevel(root.left, level + 1);
        printOnlyLeftmostElementsAtEveryLevel(root.right, level + 1);
    }

    //Find the min depth of the tree
    //Idea: to find the shortest path to leaf node
    //returns the length of min depth of the tree
    //depth = the nearest distance to the leaf node
    public static int minDepth(TreeNode root) {
        //pre-order traversal
        if (root == null) {
            return 0;
        }
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        return (left == 0 || right == 0) ? left + right + 1 : 1 + Math.min(left, right);
    }

    //size of a tree
    public static int sizeOfTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + sizeOfTree(root.left) + sizeOfTree(root.right);
    }

    //My solution
    public static boolean childrenSum(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean left = childrenSum(root.left);
        boolean right = childrenSum(root.right);
        if (left && right && (root.left != null && root.right != null)) {
            return root.data == (root.left.data + root.right.data);
        }
        if (left && right && (root.left != null && root.right == null)) {
            return root.data == root.left.data;
        }
        if (left && right && (root.right != null && root.left == null)) {
            return root.data == root.right.data;
        }
        if (left && right && root.right == null && root.left == null) {
            return true;
        }
        return false;
    }

    //gfg
    public static boolean isCSum(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left == null && root.right == null) {
            return true;
        }
        int sum = 0;
        if (root.left != null) {
            sum += root.left.data;
        }
        if (root.right != null) {
            sum += root.right.data;
        }
        return (root.data == sum && isCSum(root.left) && isCSum(root.right));
    }


    //check the left subtree height
    //check the right subtree height
    //check the difference is <=1
    //call the left subtree recursively
    //call the right subtree recursively
    public static boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int lh = heightOfTree(root.left);
        int rh = heightOfTree(root.right);
        return (Math.abs(lh - rh) <= 1 && isBalanced(root.left) && isBalanced(root.right));
    }

    //Idea: get the height and the isBalanced in one recursive call
    public static int isBalancedEfficient(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int lt = isBalancedEfficient(root.left);
        if (lt == -1) {
            return -1;
        }
        int rt = isBalancedEfficient(root.right);
        if (rt == -1) {
            return -1;
        }
        //check the difference
        if (Math.abs(lt - rt) > 1) {
            return -1;
        } else {
            //return the height
            return 1 + Math.max(lt, rt);
        }
    }

    //Iterative soln for the level order traversal
    public static void levelOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (queue.isEmpty() == false) {
            //poll the current level(parent)
            TreeNode curr = queue.poll();
            System.out.println(curr.data);
            //push the next level(child)
            if (curr.left != null) {
                queue.add(curr.left);
            }
            if (curr.right != null) {
                queue.add(curr.right);
            }
        }
    }

    //print level order traversal line-by-line
    //Time-Complexity O(n)
    //Aux-space O(max_width_of_tree)
    public static void levelOrderTraversalLineByLine(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (queue.isEmpty() == false) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                System.out.print(curr.data + " ");
                if (curr.left != null) {
                    queue.add(curr.left);
                }
                if (curr.right != null) {
                    queue.add(curr.right);
                }
            }
            System.out.println("\n");
        }
    }


    //Idea: Root->Left->Right, Root->Right->Left
    public static boolean isSymmetric(TreeNode root) {
        if (root.left == null && root.right == null) {
            return true;
        }
        return isSymmetricHelp(root.left, root.right);
    }

    private static boolean isSymmetricHelp(TreeNode left, TreeNode right) {
        //base case
        if (left == null || right == null) {
            return left == right;
        }
        //breaking condition
        if (left.data != right.data) {
            return false;
        }
        //recursively call the isSymmetricHelp which will start from 2nd level
        return isSymmetricHelp(left.left, right.right) && isSymmetricHelp(left.right, right.left);
    }

    //Idea: use line by line level order traversal and keep track of max-size
    public static int widthOfTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        int max = 0;
        queue.add(root);
        while (queue.isEmpty() == false) {
            int size = queue.size();
            max = Math.max(max, size);
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                if (curr.left != null) {
                    queue.add(curr.left);
                }
                if (curr.right != null) {
                    queue.add(curr.right);
                }
            }
        }
        return max;
    }

    public static int diameterOfATree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int h = 1 + heightOfTree(root.left) + heightOfTree(root.right);

        int rh = diameterOfATree(root.left);
        int lh = diameterOfATree(root.right);
        return Math.max(h, Math.max(rh, lh));
    }

    //Idea : use stack's:LIFO property to get the path from the node back to root
    //then add that into the ArrayList and get the result
    public static List<Integer> findPathFromRootToNode(TreeNode root, int k) {
        Stack<Integer> stack = new Stack<Integer>();
        List<Integer> list = new ArrayList<>();
        boolean isExist = getPath(root, stack, k);
        int size = stack.size();
        for (int i = 0; i < size; i++) {
            list.add(stack.pop());
        }
        return list;
    }

    private static boolean getPath(TreeNode root, Stack<Integer> stack, int k) {
        if (root == null) {
            return false;
        }

        if (root.data == k) {
            stack.push(root.data);
            return true;
        }

        if (getPath(root.left, stack, k) || getPath(root.right, stack, k)) {
            stack.push(root.data);
            return true;
        }
        return false;
    }

    //LCA: lowest common ancestor node of the binary tree
    //Idea: use the logic of finding path from root to node and reuse that to find
    //both the nodes. If both the nodes are present then find the return the common path
    public static List<Integer> lca(TreeNode root, int p, int q) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        getPath(root, s1, p);
        getPath(root, s2, q);
        int size = Math.min(s1.size(), s2.size());
        if (size == 0) {
            return Collections.EMPTY_LIST;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            int n1 = s1.pop();
            int n2 = s2.pop();
            if (n1 != n2) {
                break;
            }
            list.add(n1);
        }
        return list;
    }

    //Idea:
    //1: Convert the tree into a graph using BFS and hashtable
    //2: Store the parent node of every node in hashtable
    public static Map<TreeNode, TreeNode> convertTreeToGraph(TreeNode root) {
        //if map doesn't contain any node as a key then it's the root node
        Map<TreeNode, TreeNode> map = new HashMap<>();
        //used for BFS-traversal
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        //map.put(root, null);
        while (queue.isEmpty() == false) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                    map.put(node.left, node);
                }
                if (node.right != null) {
                    queue.add(node.right);
                    map.put(node.right, node);
                }
            }
        }
//        for(Map.Entry<TreeNode, TreeNode> entry: map.entrySet()){
//            System.out.println(entry.getKey().data +" "+entry.getValue().data);
//        }
        return map;
    }

    public static List<Integer> findNthNodesElements(TreeNode root, int k, int dis) {
        Map<TreeNode, Integer> visitedMap = new HashMap<>();
        TreeNode node = findNode(root, k);
        Map<TreeNode, TreeNode> parentMap = convertTreeToGraph(root);
        //second BFS with parent node included
        Queue<TreeNode> queue = new LinkedList<>();
        int index = 0;
        //initialize node with element we want to start iteration
        queue.add(node);
        visitedMap.put(node, 0);
        while (queue.isEmpty() == false) {
            if (index == dis) {
                break;
            }
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                if (curr.left != null && !visitedMap.containsKey(curr.left)) {
                    queue.add(curr.left);
                    visitedMap.put(curr.left, index);
                }
                if (curr.right != null && !visitedMap.containsKey(curr.right)) {
                    queue.add(curr.right);
                    visitedMap.put(curr.right, index);
                }
                if (parentMap.get(curr) != null && !visitedMap.containsKey(parentMap.get(curr))) {
                    queue.add(parentMap.get(curr));
                    visitedMap.put(parentMap.get(curr), index);
                }

            }
            index++;
        }
        List<Integer> list = new ArrayList<>();
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            list.add(queue.poll().data);
        }
        return list;
    }

    public static int burnBinaryTree(int k, TreeNode root) {
        Map<TreeNode, TreeNode> parentMap = convertTreeToGraph(root);
        TreeNode node = findNode(root, k);
        Map<TreeNode, Integer> visitedMap = new HashMap<>();
        //second BFS with parent node included
        Queue<TreeNode> queue = new LinkedList<>();
        int index = 0;
        //initialize node with element we want to start iteration
        queue.add(node);
        visitedMap.put(node, 0);
        while (queue.isEmpty() == false) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                if (curr.left != null && !visitedMap.containsKey(curr.left)) {
                    queue.add(curr.left);
                    visitedMap.put(curr.left, index);
                }
                if (curr.right != null && !visitedMap.containsKey(curr.right)) {
                    queue.add(curr.right);
                    visitedMap.put(curr.right, index);
                }
                if (parentMap.get(curr) != null && !visitedMap.containsKey(parentMap.get(curr))) {
                    queue.add(parentMap.get(curr));
                    visitedMap.put(parentMap.get(curr), index);
                }

            }
            index++;
        }
        return index;
    }

    private static TreeNode findNode(TreeNode root, int k) {
        if (root == null) {
            return null;
        }
        if (root.data == k) {
            return root;
        }
        TreeNode lh = findNode(root.left, k);
        if (lh != null) {
            return lh;
        }
        TreeNode rh = findNode(root.right, k);
        if (rh != null) {
            return rh;
        }
        return null;
    }

    public static List<Integer> iterativeInOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        TreeNode curr = root;
        while (curr != null || stack.isEmpty() == false) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            list.add(curr.data);
            curr = curr.right;
        }
        return list;
    }

    public static List<Integer> iterativePreOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return Collections.EMPTY_LIST;
        }
        stack.push(root);
        while (stack.isEmpty() == false) {
            TreeNode curr = stack.pop();
            list.add(curr.data);
            stack.push(curr.left);
            stack.push(curr.right);
        }
        return list;
    }

    //TODO: need to complete this
    public static List<Integer> iterativePostOrder(TreeNode root) {
        return null;
    }

    //Q-226 : invert a binary tree
    //Idea: to use the logic of symmetric binary tree with level order traversal
    //and maintain two queue for traversing through the tree
    public static TreeNode invertTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode node = new TreeNode(root.data);
        Queue<TreeNode> iqueue = new LinkedList<>();
        queue.add(root);
        iqueue.add(node);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode n = queue.poll();
                TreeNode curr = iqueue.poll();
                if (n.left != null) {
                    curr.right = new TreeNode(n.left.data);
                    queue.add(n.left);
                    iqueue.add(curr.right);
                }
                if (n.right != null) {
                    curr.left = new TreeNode(n.right.data);
                    queue.add(n.right);
                    iqueue.add(curr.left);
                }
            }
        }
        return node;
    }

    //Convert a given tree to its Sum Tree
    public int convertTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int sum = convertTree(root.left) + convertTree(root.right);
        //if()
        return 0;
    }
}
