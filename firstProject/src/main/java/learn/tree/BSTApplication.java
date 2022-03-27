package learn.tree;


import java.util.Stack;

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

        System.out.println(findCeil(root, 25));

        System.out.println(findFloor(root, 18));

        insertRecursive(root, 25);
        System.out.println("insert recursive:");
        inOrderTraversal(root);

        //System.out.println(kthSmallestNode(root, 3));

        System.out.println("\nkth smallest: " + iterativeInOrder(root, 7));

        System.out.println("\nisBST: " + validateTreeIsBST(root));
        root.left.right = new BSTNode(100);
        System.out.println("isBST: " + validateTreeIsBST(root));

        System.out.println("LCA: "+getLCA(root, 3, 18).val);
        System.out.println("LCA: "+getLCA(root, 18,80).val);
    }

    public static void inOrderTraversal(BSTNode treeNode) {
        if (treeNode == null) {
            return;
        }
        inOrderTraversal(treeNode.left);
        System.out.print(treeNode.val + " ");
        inOrderTraversal(treeNode.right);
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

    public static BSTNode searchIterative(BSTNode root, int k) {
        BSTNode temp = new BSTNode(k);
        BSTNode parent = null;
        BSTNode curr = root;
        while (root != null && root.val != k) {
            root = root.val < k ? root.left : root.right;
        }
        return root;
    }

    public static void insertRecursive(BSTNode root, int k) {
        if (root.val == k) {
            //if root value is equal to k
            //will come into this condition and return
            //element exits already
            return;
        }
        if (root.val > k) {
            //create a new node in left of the tree
            if (root.left == null) {
                root.left = new BSTNode(k);
                return;
            }
            insertRecursive(root.left, k);

        }
        if (root.val < k) {
            //create a new node in the right of the tree
            if (root.right == null) {
                root.right = new BSTNode(k);
                return;
            }
            insertRecursive(root.right, k);
        }
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

    public static int findCeil(BSTNode root, int key) {
        int ceil = -1;

        while (root != null) {
            if (root.val == key) {
                ceil = root.val;
                return ceil;
            }

            if (root.val < key) {
                root = root.right;
            } else {
                //updating ceil everytime root.val > key till we reach the end
                ceil = root.val;
                root = root.left;
            }
        }
        return ceil;
    }

    public static int findFloor(BSTNode root, int key) {
        int floor = -1;
        while (root != null) {
            if (root.val == key) {
                floor = root.val;
                return floor;
            }

            if (root.val > key) {
                root = root.left;
            } else {
                //updating floor everytime key > root.val till we reach end
                floor = root.val;
                root = root.right;
            }
        }
        return floor;
    }

    //refer TUF free ka tree series
    public static void deleteANodeInBST(BSTNode root, int k) {
        BSTNode prev = null;
        if (root == null) {
            return;
        }

        if (root.val == k) {
            treeFormatter(root);
        }

        while (root != null) {
            if (root.val > k) {
                if (root.left != null && root.val == k) {
                    root.left = treeFormatter(root.left);
                    break;
                } else {
                    root = root.left;
                }

            } else {
                if (root.right != null && root.val == k) {
                    root.right = treeFormatter(root.right);
                    break;
                } else {
                    root = root.right;
                }
            }

        }
    }

    private static BSTNode treeFormatter(BSTNode root) {
        if (root.left == null) {
            return root.right;
        } else if (root.right == null) {
            return root.left;
        } else {
            BSTNode rightChild = root.right;
            BSTNode lastRight = findLastRight(root.left);
            lastRight.right = rightChild;
            return root.left;
        }
    }

    private static BSTNode findLastRight(BSTNode root) {
        if (root.right == null) {
            return root;
        }
        return findLastRight(root.right);
    }


    //validate if the tree is BST
    /*
     * Idea : any node will always remain in the between
     * either minValue or maxValue
     * update the min_values for every right_node call from any given node
     * update the max_value for every left_node call from any given node
     * */
    public static boolean validateTreeIsBST(BSTNode root) {
        if (root == null) {
            return true;
        }
        return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean isBST(BSTNode root, int minValue, int maxValue) {
        if (root == null) {
            return true;
        }
        if (root.val >= maxValue || root.val < minValue) return false;
        return isBST(root.left, minValue, root.val) && isBST(root.right, root.val, maxValue);
    }

    /*
     * kth smallest element in the BST
     * use inorder traversal and increase the count for each node
     * */
    public static int kthSmallestNode(BSTNode root, int k) {
        Integer res = -1;
        inOrderTraversal(root, k, res);
        return res;
    }

    //wrong
    private static void inOrderTraversal(BSTNode root, int k, int res) {
        if (root == null) {
            return;
        }
        inOrderTraversal(root.left, k, res);
        k = k - 1;
        if (k == 0) {
            res = root.val;
            return;
        }
        inOrderTraversal(root.left, k, res);
    }

    //Idea : to use count to track the kth smallest value
    private static int iterativeInOrder(BSTNode root, int k) {
        Stack<BSTNode> stack = new Stack();
        stack.push(root);
        BSTNode node = root;
        int count = 0;
        while (root != null || !stack.isEmpty()) {

            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            count++;
            node = stack.pop();
            if (count == k) {
                break;
            }
            node = node.right;
        }
        return node.val;
    }

    //Idea : to use count to track the kth largest value
    private static int iterativeInOrderForKthLargest(BSTNode root, int k) {
        Stack<BSTNode> stack = new Stack();
        stack.push(root);
        BSTNode node = root;
        int count = 0;
        while (root != null || !stack.isEmpty()) {

            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            count++;
            node = stack.pop();
            node = node.right;
        }
        int n = count;

        while (root != null || !stack.isEmpty()) {
            //left
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            //root
            count++;
            node = stack.pop();
            if (n - count == k) {
                break;
            }
            //righ
            node = node.right;
        }
        return node.val;
    }

    //Idea: replace the node to be deleted with the
    // closest lower value or higher value
    // to find closest lower and closest higher value use inorder traversal
    public BSTNode deleteBSTNode(BSTNode root, int k) {
        if (root == null) {
            return null;
        }
        if (root.val > k) {
            root.left = deleteBSTNode(root.left, k);
        } else if (root.val < k) {
            root.right = deleteBSTNode(root.right, k);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                BSTNode success = getSuccessor(root);
                root.val = success.val;
                root.right = deleteBSTNode(root.right, success.val);
            }
        }
        return root;
    }

    private BSTNode getSuccessor(BSTNode root) {
        BSTNode curr = root.right;
        while (curr != null && curr.left != null) {
            curr = curr.left;
        }
        return curr;
    }

    /*
     * - LCA - the least common ancestor of any two given nodes
     */
    public static BSTNode getLCA(BSTNode root, int x, int y) {
        if (root == null) {
            return null;
        }

        if (root.val < x && root.val < y) {
            return getLCA(root.right, x, y);
        }

        if (root.val > x && root.val > y) {
            return getLCA(root.left, x, y);
        }
        return root;
    }
}
