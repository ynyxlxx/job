import java.util.ArrayList;
import java.util.Arrays;

public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }

        @Override
        public String toString(){
            ListNode head = this;
            ArrayList<Integer> res = new ArrayList<>();
            while (head != null){
                res.add(head.val);
                head = head.next;
            }
            return res.toString();
        }
}
