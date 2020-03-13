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

        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> path = new ArrayList<>();
        System.out.println(findAllPath(root, res, path));

        ArrayList<ArrayList<Integer>> res2 = new ArrayList<>();
        res2 = Print(root);
        System.out.println(res2);
    }

    public static void linePrint(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        ArrayList<Integer> a = new ArrayList<>();
        ArrayList<Integer> b = new ArrayList<>();
        if (root == null) return;

        queue.offer(root);
        int thisLine = 1;
        int nextline = 0;
        boolean flag = true;
        while(!queue.isEmpty())
        {
            TreeNode temp = queue.poll();
            System.out.print(temp.val + " ");
            thisLine--;
            if (flag){
                b.add(temp.val);
                flag = false;
            }

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
                a.add(temp.val);
                thisLine = nextline;
                nextline = 0;
                flag = true;
            }
        }
        System.out.println("right view: " + a);
        System.out.println("left view: " + b);
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

    private static ArrayList<ArrayList<Integer>> findAllPath(TreeNode root, ArrayList<ArrayList<Integer>> result,
                                                            ArrayList<Integer> path){
        if (root == null) return result;

        path.add(root.val);
        if (root.left == null && root.right == null){
            result.add(new ArrayList<>(path));
        }

        findAllPath(root.left, result, path);
        findAllPath(root.right, result, path);

        path.remove(path.size() - 1);
        return result;
    }

    private static TreeNode KthNode(TreeNode root, int k){
        if (root == null || k <= 0) return null;

        int counter = 0;
        Stack<TreeNode> st = new Stack<>();
        while (!st.isEmpty() || root != null){
            if (root != null){
                st.push(root);
                root = root.left;
            }else{
                root = st.pop();
                counter++;
                if (counter == k)  return root;
                root = root.right;
            }
        }
      return null;
    }

    private static ArrayList<ArrayList<Integer> > Print(TreeNode root) {
        ArrayList<ArrayList<Integer> > ans = new ArrayList<>();
        Stack<TreeNode>[] st = new Stack[]{new Stack<TreeNode>(), new Stack<TreeNode>()};

        if (root == null) return ans;

        int cur = 0;
        int next = 1;
        ArrayList<Integer> path = new ArrayList<>();
        st[cur].push(root);
        while (!st[0].isEmpty() || !st[1].isEmpty()){
            TreeNode temp = st[cur].pop();
            path.add(temp.val);

            if (cur == 0){
                if (temp.left != null)
                    st[next].push(temp.left);
                if (temp.right != null)
                    st[next].push(temp.right);
            }

            if (cur == 1){
                if (temp.right != null)
                    st[next].push(temp.right);
                if (temp.left != null)
                    st[next].push(temp.left);
            }

            if (st[cur].isEmpty()){
                ans.add(new ArrayList(path));
                System.out.println("ans: " + path);
                path.clear();
                cur = 1 - cur;
                next = 1 - next;
            }
        }
        return ans;
    }
}
