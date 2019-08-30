import java.util.ArrayList;
import java.util.Comparator;
import java.util.Stack;
import java.util.List;

public class TreeTest {
    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        TreeNode a = root.left;
        TreeNode b = root.right;

        a.left = new TreeNode(4);
        a.right = new TreeNode(5);
        b.left = new TreeNode(6);
        b.right = new TreeNode(7);

        TreeNode c = a.left;
        c.left = new TreeNode(8);
        c.right = new TreeNode(9);

        ArrayList<Integer> treeList1 = new ArrayList<>();
        preOrder(root, treeList1);
        System.out.println("preorder: " + treeList1);

        ArrayList<Integer> treeList2 = new ArrayList<>();
        inOrder(root, treeList2);
        System.out.println("inorder: " + treeList2);

        ArrayList<Integer> treeList3 = new ArrayList<>();
        postOrder(root, treeList3);
        System.out.println("postorder: " + treeList3);

        System.out.println("the depth of the tree: " + depthOfTree(root));

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> path = new ArrayList<>();
        int target = 15;
        result = FindPath(root, target, result, path);
        System.out.println(result);

        System.out.println(isBalanceTree(root));

        ArrayList<Integer> z = new ArrayList<>();
        zhongxu(z, root);
        System.out.println(z);
    }

    public static void preOrder(TreeNode root, ArrayList<Integer> list){
        if (root != null){
            list.add(root.val);
            preOrder(root.left, list);
            preOrder(root.right, list);
        }
    }

    public static void inOrder(TreeNode root, ArrayList<Integer> list){
        if (root != null){
            inOrder(root.left, list);
            list.add(root.val);
            inOrder(root.right, list);
        }
    }

    public static void postOrder(TreeNode root, ArrayList<Integer> list){
        if (root != null){
            postOrder(root.left, list);
            postOrder(root.right, list);
            list.add(root.val);
        }
    }

    public static int depthOfTree(TreeNode root){
        if (root == null) return 0;

        int nLeft = depthOfTree(root.left);
        int nRight = depthOfTree(root.right);

        return nLeft > nRight ? nLeft + 1 : nRight + 1;
    }

    public static Boolean isBalanceTree(TreeNode root){
        if(root == null) return true;

        int right = depthOfTree(root.right);
        int left = depthOfTree(root.left);

        if (left - right > 1 || left - right < -1) return false;

        return isBalanceTree(root.left) && isBalanceTree(root.right);
    }

    public static ArrayList<ArrayList<Integer>> FindPath(TreeNode root,
                                                  int target,
                                                  ArrayList<ArrayList<Integer>> result,
                                                  ArrayList<Integer> path) {
        /// 先写基准情况 -- 即递归的终止条件；
        if (root == null) return result;

        path.add(root.val);
//        System.out.println(path);
        target = target - root.val;

        if (target == 0 && root.left == null && root.right == null){
            result.add(new ArrayList<>(path));
        }
        /// 不断演进
        FindPath(root.left, target, result, path);
        FindPath(root.right, target, result, path);

        path.remove(path.size()-1);
        return result;
    }
    /** 先序遍历：
     1.申请一个栈 stack。然后将头结点 head 压入 stack 中。
     2.从 stack 中弹出栈顶结点，记为 cur，然后打印 cur 结点的值，再将 cur 的右孩子（非空的话）和左孩子（非空的话）分别压入栈中。
     3.不断重复步骤 2，直到栈 stack 为空，全部过程结束。

     中序遍历：
     1.申请一个栈 stack。初始时，令变量 cur=head。
     2.先把 cur 结点压入栈中，然后依次把左边界压入栈中，即不停的令 cur=cur.left，重复该步骤。
     3.不断重复步骤 2，直到 cur 为空为止，此时从 stack 中弹出栈顶元素，记为 node。打印 node 的值，并将 cur=node.right，然后继续重复步骤2。
     4.当 stack 为空且 cur 为空时，整个过程停止。

     后序遍历：
     1.申请一个栈，记为s1，然后将头结点 head 压入 s1 中。
     2.从 s1 中弹出的结点记为 cur，然后依次将 cur 的左孩子和右孩子压入 s1 中。
     3.整个过程中 s1 所弹出的结点都压入 s2 中。
     4.不断重复步骤2-3，直到 s1 为空为止。
     5.从 s2 中弹出结点并打印，打印的顺序就是后序遍历的顺序。
    /**
     * 先序遍历
     */
    private static void xianxu(List<Integer> list, TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.add(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            list.add(root.val);
            if (root.right != null) {
                stack.push(root.right);
            }
            if (root.left != null){
                stack.push(root.left);
            }

        }
    }
    /**
     * 中序遍历
     */
    private static void zhongxu(List<Integer> list, TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (!stack.isEmpty() || root!=null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            }else {
                root = stack.pop();
                list.add(root.val);
                root = root.right;
            }
        }
    }
    /**
     * 后序遍历
     */
    private static void houxu(List<Integer> list, TreeNode root) {
        Stack<TreeNode> stack1 = new Stack<TreeNode>();
        Stack<TreeNode> stack2 = new Stack<TreeNode>();
        stack1.add(root);
        while (!stack1.isEmpty()) {
            root = stack1.pop();
            stack2.push(root);
            if (root.left != null) {
                stack1.push(root.left);
            }
            if (root.right != null) {
                stack1.push(root.right);
            }
        }
        while (!stack2.isEmpty()) {
            list.add(stack2.pop().val);
        }
    }

}
