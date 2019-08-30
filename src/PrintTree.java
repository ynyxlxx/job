import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Stack;

public class PrintTree {
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

        System.out.println("print the tree in a line: ");
        linePrint(root);

        System.out.println("print the tree in a zig-zag: ");
        zigPrint(root);
    }

    public static void linePrint(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<TreeNode>();

        if (root == null) return;

        queue.add(root);
        int thisLine = 1;
        int nextline = 0;
        while(!queue.isEmpty())
        {
            TreeNode temp = queue.poll();
            System.out.print(temp.val + " ");
            thisLine--;

            if (temp.left != null) {
                queue.offer(temp.left);
                nextline++;
            }

            if (temp.right != null) {
                queue.offer(temp.right);
                nextline++;
            }

            if (thisLine == 0) {
                System.out.print("\n");
                thisLine = nextline;
                nextline = 0;
            }
        }
    }

    public static void zigPrint(TreeNode root){
        Stack<TreeNode> left2right = new Stack<>();
        Stack<TreeNode> right2left = new Stack<>();
        Stack<TreeNode>[] stack = new Stack[]{left2right, right2left};

        int current = 0;
        int next = 1;

        stack[current].push(root);

        while (!stack[0].isEmpty() || !stack[1].isEmpty()){
            TreeNode temp = stack[current].pop();
            System.out.print(temp.val + " ");

            if (current == 0){
                if (temp.left != null) stack[next].push(temp.left);
                if (temp.right != null) stack[next].push(temp.right);
            }

            if (current == 1){
                if (temp.right != null) stack[next].push(temp.right);
                if (temp.left != null) stack[next].push(temp.left);
            }

            if (stack[current].isEmpty()){
                System.out.print("\n");
                current = 1 - current;
                next = 1 - next;
            }
        }
    }
}
