import java.util.ArrayList;
import java.util.Stack;
import java.util.LinkedList;

public class ListNodeTest {
    public static void main(String [] args){
        ListNode a = new ListNode(67);
        ListNode b = new ListNode(0);
        ListNode c = new ListNode(24);
        ListNode d = new ListNode(58);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = null;

        ArrayList<Integer> res1 = new ArrayList<>();
        res1 = printListNode(res1, a);
        System.out.println("print the ListNode: " + res1);
        printListNodeReverse(a);

        System.out.println("Kth to tail: " + getReverseKthNode(a, 3));
//        ArrayList<Integer> res2 = new ArrayList<>();
//        res2 = printListNodeReverse(res2, a);
//        System.out.println(res2);


        ArrayList<Integer> test = new ArrayList<>();
        test.add(1);
        test.add(2);
        test.add(3);
        test.add(0, 4);
        System.out.println("insert at 0: " + test);

        System.out.println("my method: " + b.toString());
        System.out.println("reverse: " + reverse(a).toString());

        ListNode e = new ListNode(1);
        ListNode f = new ListNode(2);
        ListNode g = new ListNode(3);
        ListNode h = new ListNode(4);

        e.next = f;
        f.next = g;
        g.next = h;
        h.next = null;

        ListNode i = new ListNode(1);
        ListNode j = new ListNode(2);
        ListNode k = new ListNode(3);
        ListNode l = new ListNode(4);

        i.next = j;
        j.next = k;
        k.next = l;
        l.next = null;

        System.out.println(mergeTwoLists(e, i).toString());

        ListNode m = new ListNode(1);
        ListNode n = new ListNode(2);
        ListNode o = new ListNode(3);
        ListNode p = new ListNode(4);

        m.next = n;
        n.next = o;
        o.next = p;
        p.next = null;

        System.out.println(isLoop(m));

    }

    public static ArrayList<Integer> printListNode(ArrayList<Integer> list, ListNode head){

        if (head == null) return list;

        list.add(head.val);

        return printListNode(list, head.next);
    }

    public static ArrayList<Integer> printListNodeReverse(ArrayList<Integer> list, ListNode head){

        if (head == null) return list;

        list.add(0, head.val);

        return printListNodeReverse(list, head.next);
    }

    public static ListNode reverseList(ListNode pHead){
        ListNode pReversedHead = null; //反转过后的单链表存储头结点
        ListNode pNode = pHead; //定义pNode指向pHead;
        ListNode pPrev = null; //定义存储前一个结点
        while(pNode != null){
            ListNode pNext = pNode.next; //定义pNext指向pNode的下一个结点
            if(pNext==null){ //如果pNode的下一个结点为空，则pNode即为结果
                pReversedHead = pNode;
            }
            pNode.next = pPrev; //修改pNode的指针域指向pPrev
            pPrev = pNode; //将pNode结点复制给pPrev
            pNode = pNext; //将pNode的下一个结点复制给pNode
        }
        return pReversedHead;
    }

    public static ListNode reverseList(ListNode head, int n, int m){
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        for (int i = 0; i < m - 1; i++) {
            pre = pre.next;
        }
        ListNode cur = pre.next;
        for (int i = m; i < n; i++) {
            ListNode t = cur.next;
            cur.next = t.next;
            t.next = pre.next;
            pre.next = t;
        }
        return dummy.next;
    }

    public static ListNode reverse(ListNode head){
        if (head == null || head.next == null) return head;

        ListNode next_node = head.next;
        ListNode new_head = reverse(head.next);

        head.next = null;
        next_node.next = head;

        return new_head;
    }

    public static int getReverseKthNode(ListNode head, int k){
        int n = getLength(head);

        ListNode fast = head;
        int step = k - 1;

        for (int i = 0; i < step; i++){
            fast = fast.next;
        }

        ListNode slow = head;
        while (fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        return slow.val;
    }

    public static int getLength(ListNode head){
        int count = 0;
        while (head != null) {
            head = head.next;
            count++;
        }
        return count;
    }

    public static void printListNodeReverse(ListNode head){
        Stack<ListNode> stack = new Stack<>();

        while (head != null){
            stack.add(head);
            head = head.next;
        }

        ArrayList<Integer> res = new ArrayList<>();
        while (!stack.isEmpty()){
            res.add(stack.pop().val);
        }

        System.out.println("reverse:" + res);
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode temp = new ListNode(-1);
        ListNode head = temp;
        while(l1 != null || l2 != null){
            if (l1.val < l2.val){
                head.next = l1;
                l1 = l1.next;
                head = head.next;
            }else{
                head.next = l2;
                l2 = l2.next;
                head = head.next;
            }

            if (l1 == null) {
                head.next = l2;
                break;
            }
            if (l2 == null) {
                head.next = l1;
                break;
            }
        }
        return temp.next;
    }

    public ListNode mergeKLists(ListNode[] lists){
        if(lists.length == 0)
            return null;
        if(lists.length == 1)
            return lists[0];
        if(lists.length == 2){
            return mergeTwoLists(lists[0],lists[1]);
        }

        int mid = lists.length/2;
        ListNode[] l1 = new ListNode[mid];
        for(int i = 0; i < mid; i++){
            l1[i] = lists[i];
        }

        ListNode[] l2 = new ListNode[lists.length-mid];
        for(int j = 0; j < lists.length - mid; j++){
            l2[j] = lists[mid + j];
        }

        return mergeTwoLists(mergeKLists(l1),mergeKLists(l2));

    }

    public static int LastRemaining_Solution(int n, int m) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        for (int i = 0; i < n; i ++) {
            list.add(i);
        }

        int bt = 0;
        while (list.size() > 1) {
            bt = (bt + m - 1) % list.size();
            list.remove(bt);
        }

        return list.size() == 1 ? list.get(0) : -1;
    }

    private static boolean isLoop(ListNode head){
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null){
            slow = slow.next;
            fast = fast.next;

            if (fast.next != null){
                fast = fast.next;
            }

            if (fast == slow) return true;
            if (fast.next == null) return false;
        }
        return false;
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {

        // Empty list
        if (head == null) {
            return null;
        }

        // Move the two pointers until they reach the proper starting point
        // in the list.
        ListNode cur = head, prev = null;
        while (m > 1) {
            prev = cur;
            cur = cur.next;
            m--;
            n--;
        }
        System.out.println(m);
        System.out.println(n);
        // The two pointers that will fix the final connections.
        ListNode con = prev, tail = cur;

        // Iteratively reverse the nodes until n becomes 0.
        ListNode third = null;
        while (n > 0) {
            third = cur.next;
            cur.next = prev;
            prev = cur;
            cur = third;
            n--;
        }

        // Adjust the final connections as explained in the algorithm
        if (con != null) {
            con.next = prev;
        } else {
            head = prev;
        }

        tail.next = cur;
        return head;
    }

    public ListNode swapPairs(ListNode head) {
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode temp = pre;   // 0 -> 1 -> 2 -> 3 -> 4
        while(temp.next != null && temp.next.next != null) {
            ListNode start = temp.next;
            ListNode end = temp.next.next;
            temp.next = end;
            start.next = end.next;
            end.next = start;
            temp = start;
        }
        return pre.next;
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        if (head == null) return null;

        while (cur != null && cur.next != null){
            if (cur.val == cur.next.val){
                cur.next = cur.next.next;
            }else{
                cur = cur.next;
            }
        }

        return head;
    }
}
