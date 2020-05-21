import java.util.ArrayList;
import java.util.Collections;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Main12 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        allPaths(root, new ArrayList<Integer>(), 0);
    }

    public static void allPaths(TreeNode root, ArrayList al, int current) {
        if (root == null)
            System.out.println(Collections.emptyList());
        if (current >= al.size())
            al.add(root.val);
        else
            al.set(current, root.val);
        if (root.left == null && root.right == null) {
            System.out.println(al.subList(0, current+1));
        }
        else {
            allPaths(root.left, al, current+1);
            allPaths(root.right, al, current+1);
        }
    }
}
