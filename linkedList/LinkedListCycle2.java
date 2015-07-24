package leetcode.linkedList;

/**
 * Given a linked list, return the node where the cycle begins. If there is no
 * cycle, return null
 * 
 * @author caiger
 */
public class LinkedListCycle2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}

	/**
	 * 最开始的思路：利用快慢指针找出相遇的节点，在相遇节点处把链表分成有两个头的点一个为节点的两路链表，求其相遇节点
	 * 重新分析快慢指针的过程，a为head到入口节点，b为入口下一个到相遇节点，c为相遇下一个到入口在环中的上一个 q = 2s,q =
	 * a+b+c+b,s = a+b,所以c=a；说明在相遇的时候，相遇节点到环入口节点的距离等于head到入口的距离
	 * 
	 * @param head
	 * @return
	 */
	public ListNode detectCycle(ListNode head) {
		if (head == null || head.next == null)
			return null;
		ListNode slow = head;
		ListNode quick = head.next.next;
		// int s=1;
		// int q=3;
		while (quick != null) {
			if (quick == slow)
				break;
			slow = slow.next;
			// s++;
			if (quick.next == null)
				return null;
			quick = quick.next.next;
			// q+=2;
		}
		if (quick == null)
			return null;
		// 长度c不包含相遇节点和入口节点，长度a包含入口节点
		slow = slow.next.next;
		while (head != slow) {
			head = head.next;
			slow = slow.next;
		}
		return head;
		// 在相遇节点处把问题转化为寻找两个头节点的相遇节点问题
		// 第二路的头结点应该是slow的下一个节点，slow是两路的公共尾结点
		// return findNode(slow.next,head,c,s);
	}

	/**
	 * @param slow
	 *            环中相遇的节点的下一个节点，相遇节点是两路的尾结点
	 * @param head
	 * @param c
	 *            环中结点数，也是第二路链表的节点数
	 * @param s
	 *            第一路链表的节点数
	 * @return
	 */
	@SuppressWarnings("unused")
	private ListNode findNode(ListNode slow, ListNode head, int c, int s) {
		int diff = Math.abs(c - s);
		ListNode first, second;
		if (c < s) {
			first = head;
			second = slow;
		} else {
			first = slow;
			second = head;
		}
		while (diff > 0) {
			first = first.next;
			diff--;
		}
		while (first != second) {
			first = first.next;
			second = second.next;
		}
		return first;
	}
}
