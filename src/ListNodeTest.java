import java.util.ArrayList;

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

}
