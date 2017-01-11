import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Node;

class LinkedListNode {
	int val;
	LinkedListNode next = null;

	LinkedListNode(int a) {
		val = a;
	}
}

public class LeetCodeLinkedList {
	LinkedListNode head;

	public void printList(LinkedListNode head) {
		LinkedListNode temp = head;
		while (temp != null) {
			System.out.print(temp.val + " ");
			temp = temp.next;
		}
		System.out.println();
	}

	public void insertBeg(int data) {
		LinkedListNode newNode = new LinkedListNode(data);
		newNode.next = head;
		head = newNode;
	}

	public void insertBet(LinkedListNode after, int data) {
		if (after == null)
			return;

		LinkedListNode newNode = new LinkedListNode(data);
		newNode.next = after.next;
		after.next = newNode;
	}

	public void inserEnd(int data) {
		LinkedListNode newNode = new LinkedListNode(data);
		if (head == null) {
			head = newNode;
		}
		LinkedListNode temp = head;
		while (temp.next != null) {
			temp = temp.next;
		}
		temp.next = newNode;
	}

	public void InsertNth(LinkedListNode head, int data, int position) {
		LinkedListNode newNode = new LinkedListNode(data);
		newNode.next = null;
		if (position == 0) {
			newNode.next = head;
			return;
		} else {
			int count = 0;
			LinkedListNode node = head;
			while (count == position - 1) {
				count++;
				node = node.next;
			}
			newNode.next = node.next;
			node.next = newNode;
			return;
		}
	}

	public LinkedListNode reverse(LinkedListNode head) {
		LinkedListNode prev = null;
		LinkedListNode cur = head;
		LinkedListNode next = null;
		while (cur != null) {
			next = cur.next;
			cur.next = prev;
			prev = cur;
			cur = next;
		}
		head = prev;
		return head;
	}

	public void deleteNode(int data) {
		if (head == null)
			return;

		// when only single node is present in linked list
		if (head.next == null || head.val == data) {
			LinkedListNode second = head.next;
			head = null;
			head = second;
			return;
		}
		LinkedListNode cur = head;
		LinkedListNode prev = head;
		while (cur != null && cur.val != data) {
			prev = cur;
			cur = cur.next;
		}
		if (cur != null) {
			prev.next = cur.next;
			cur = null;
		}
	}

	public boolean hasCycle(LinkedListNode head) {
		if (head == null || head.next == null)
			return false;
		LinkedListNode slow = head;
		LinkedListNode fast = head.next;
		while (fast != null && fast.next != null) {
			if (slow != fast) {
				fast = fast.next.next;
				slow = slow.next;
			} else {
				return true;
			}
		}
		return false;
	}

	public void deleteNodeWithNode(LinkedListNode node) {
		LinkedListNode nextNode = node.next;
		node.next = nextNode.next;
		node.val = nextNode.val;
		nextNode = null;
	}

	public LinkedListNode deleteDuplicates(LinkedListNode head) {
		if (head == null)
			return null;
		LinkedListNode node = head;
		while (node.next != null) {
			LinkedListNode next = node.next;
			if (next.val == node.val) {
				node.next = next.next;
				next = null;
			} else {
				node = node.next;
			}
		}
		return head;
	}

	public LinkedListNode removeElements(LinkedListNode head, int val) {
		if (head == null)
			return null;
		LinkedListNode dummy = new LinkedListNode(0);
		dummy.next = head;
		LinkedListNode curr = dummy;
		while (curr.next != null) {
			LinkedListNode temp = curr.next;
			if (temp.val == val) {
				curr.next = temp.next;
				temp = null;
			} else {
				curr = curr.next;
			}
		}
		return dummy.next;
	}

	public LinkedListNode removeElements2(LinkedListNode head, int val) {
		if (head == null)
			return null;
		LinkedListNode temp = head;
		if (temp.val == val) {
			temp = removeElements2(temp.next, val);
		} else {
			temp = temp.next;
		}
		return head;
	}

	public LinkedListNode mergeTwoLists(LinkedListNode l1, LinkedListNode l2) {
		LinkedListNode head = new LinkedListNode(0);
		LinkedListNode temp = head;
		while (l1 != null && l2 != null) {
			if (l1.val == l2.val) {
				temp.next = l1;
				l1 = l1.next;
			} else if (l1.val < l2.val) {
				temp.next = l1;
				l1 = l1.next;
			} else if (l1.val > l2.val) {
				temp.next = l2;
				l2 = l2.next;
			}
			temp = temp.next;
		}
		if (l1 != null) {
			temp.next = l1;
		}
		if (l2 != null) {
			temp.next = l2;
		}
		return head.next;
	}

	public LinkedListNode swapPairs(LinkedListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		boolean first = false;
		LinkedListNode node = head;
		LinkedListNode res = null;
		while (node != null && node.next != null) {
			LinkedListNode temp = node.next;
			node.next = temp.next;
			temp.next = node;
			node = temp;
			if (!first) {
				first = true;
				head = node;
				res = head;
			} else {
				res.next.next = node;
				res = res.next.next;
			}
			node = node.next.next;
		}
		return head;
	}

	public LinkedListNode swapPairs2(LinkedListNode head) {
		LinkedListNode dummy = new LinkedListNode(0);
		dummy.next = head;
		LinkedListNode curr = dummy;
		while (curr.next != null && curr.next.next != null) {
			LinkedListNode first = curr.next;
			LinkedListNode second = curr.next.next;
			first.next = second.next;
			second.next = first;
			first = second;
			curr.next = first;
			curr = curr.next.next;
		}
		return dummy.next;
	}

	public LinkedListNode removeNthFromEnd(LinkedListNode head, int n) {
		LinkedListNode node = head;
		int len = 0;
		while (node != null) {
			len++;
			node = node.next;
		}
		if (n == len) {
			LinkedListNode temp = head;
			head = temp.next;
			temp = null;
			return head;
		}
		int position = len - n - 1;
		node = head;
		while (position > 0) {
			position--;
			node = node.next;
		}
		LinkedListNode temp = node.next;
		node.next = temp.next;
		temp = null;

		return head;
	}

	public LinkedListNode getIntersectionNode(LinkedListNode headA, LinkedListNode headB) {
		int len1 = 0;
		int len2 = 0;
		LinkedListNode nodeA = headA;
		LinkedListNode nodeB = headB;
		while (nodeA != null) {
			len1++;
			nodeA = nodeA.next;
		}
		while (nodeB != null) {
			len2++;
			nodeB = nodeB.next;
		}

		nodeA = headA;
		nodeB = headB;
		while (len1 > len2) {
			nodeA = nodeA.next;
			len1--;
		}

		while (len2 > len1) {
			nodeB = nodeB.next;
			len2--;
		}
		while (len1 > 0) {
			if (nodeA == nodeB)
				return nodeA;
			else {
				nodeA = nodeA.next;
				nodeB = nodeB.next;
				len1--;
			}
		}
		return null;

	}

	public LinkedListNode getIntersectionNode2(LinkedListNode headA, LinkedListNode headB) {
		if (headA == null || headB == null) {
			return null;
		}
		LinkedListNode node1 = headA;
		LinkedListNode node2 = headB;
		while(node1!=node2){
			node1 = node1.next;
			node2 = node2.next;
			//no intersection
			if(node1==node2)
				return node1;
			if(node1==null){
				node1 = headB;
			}
			if(node2 == null){
				node2 = headA;
			}
		}
		return node1;
	}
	
	public boolean isPalindromeLinkedList(LinkedListNode head) {
		if(head == null)
			return true;
		LinkedListNode actual = head;
		LinkedListNode fast = head;
		LinkedListNode slow = head;
		while(fast!=null && fast.next != null){
			fast = fast.next.next;
			slow = slow.next;
		}
		//reverse second half
		LinkedListNode curr = slow;
		LinkedListNode next = null;
		LinkedListNode prev = null;
		while(curr!=null){			
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		slow = prev;
		while(slow!=null){
			if(slow.val != actual.val){
				return false;
			}else{
				slow = slow.next;
				actual = actual.next;
			}
		}
		return true;		
	}

	// public LinkedListNode removeNthFromEnd2(LinkedListNode head, int n) {
	// LinkedListNode temp = head;
	// LinkedListNode fast = head;
	// LinkedListNode slow = head;
	// int len = 0;
	// while(slow!=null){
	// if(fast!=null){
	// len++;
	// fast = fast.next.next;
	// }else{
	//
	// }
	// slow = slow.next;
	// }
	// }

	public static void main(String[] args) {
		LeetCodeLinkedList l = new LeetCodeLinkedList();
		l.insertBeg(1);
		l.inserEnd(2);
		l.inserEnd(3);
		// l.inserEnd(4);
		// l.insertBet(l.head.next, 100);
		// l.insertBeg(0);
		// l.printList();

		// l.deleteNode(2);
		l.printList(l.head);

		LinkedListNode insertNth = new LinkedListNode(1);
		insertNth.next = new LinkedListNode(2);
		insertNth.next.next = new LinkedListNode(3);
		System.out.println("Insert node at nth position");
		l.printList(insertNth);
		l.InsertNth(insertNth, 10, 1);
		l.printList(insertNth);

		LinkedListNode cycle = new LinkedListNode(1);
		cycle.next = new LinkedListNode(2);
		// cycle.next = cycle;
		System.out.println("Has cycle?");
		System.out.println(l.hasCycle(cycle));

		System.out.println("Reverse linked list");
		l.printList(insertNth);
		LinkedListNode reversed = l.reverse(insertNth);
		l.printList(reversed);

		System.out.println("deleting node 2");
		l.printList(l.head);
		l.deleteNode(3);
		l.printList(l.head);

		LinkedListNode head = new LinkedListNode(1);
		head.next = new LinkedListNode(1);
		head.next.next = new LinkedListNode(1);
		// head.next.next = new LinkedListNode(2);
		// head.next.next.next = new LinkedListNode(2);
		// head.next.next.next.next = new LinkedListNode(9);
		System.out.println("Delete duplicates ");
		l.printList(head);
		l.deleteDuplicates(head);
		l.printList(head);

		System.out.println("Remove elements with val = 1: ");
		LinkedListNode ll1 = new LinkedListNode(1);
		ll1.next = new LinkedListNode(1);
		ll1.next.next = new LinkedListNode(1);
		l.printList(l.removeElements(ll1, 1));

		LinkedListNode l1 = new LinkedListNode(0);
		l1.next = new LinkedListNode(1);
		l1.next.next = new LinkedListNode(4);
		LinkedListNode l2 = new LinkedListNode(0);
		l2.next = new LinkedListNode(2);
		l2.next.next = new LinkedListNode(3);
		System.out.println("Merge two sorted lists: ");
		l.printList(l1);
		l.printList(l2);
		l.printList(l.mergeTwoLists(l1, l2));

		System.out.println("swap pairs");
		LinkedListNode swap = new LinkedListNode(2);
		// swap.next = new LinkedListNode(5);
		// swap.next.next = new LinkedListNode(3);
		// swap.next.next.next = new LinkedListNode(4);
		// swap.next.next.next.next = new LinkedListNode(6);
		// swap.next.next.next.next.next = new LinkedListNode(2);
		// swap.next.next.next.next.next.next = new LinkedListNode(2);
		// l.printList(swap);
		// l.printList(l.swapPairs2(swap));

		System.out.println("Remove Nth Node From End of List");
		l.printList(swap);
		l.printList(l.removeNthFromEnd(swap, 1));

		LinkedListNode intersect1 = new LinkedListNode(2);
		intersect1.next = new LinkedListNode(3);
		intersect1.next.next = new LinkedListNode(4);
		intersect1.next.next.next = new LinkedListNode(5);
		LinkedListNode intersect2 = new LinkedListNode(10);
		intersect2.next = new LinkedListNode(11);
//		intersect2.next.next = intersect1;
		System.out.println("Intersection of Two Linked Lists " + l.getIntersectionNode2(intersect1, intersect2));

		LinkedListNode pal = new LinkedListNode(1);
		pal.next = new LinkedListNode(2);
//		pal.next.next = new LinkedListNode(2);
//		pal.next.next.next = new LinkedListNode(1);
		System.out.println("Palindrome Linked List : "+l.isPalindromeLinkedList(pal));
	}

}
