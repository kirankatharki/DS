
public class LinkedList {

	Node head;

	public class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
			next = null;
		}
	}

	public void push_data(int new_data) {

		if (head == null) {
			head = new Node(new_data);
			return;
		}

		Node temp = new Node(new_data);
		temp.next = head;
		head = temp;

	}

	public void push_data_end(int new_data) {

		Node temp = head;
		while (temp.next != null) {
			temp = temp.next;
		}
		Node add_new = new Node(new_data);
		temp.next = add_new;
		add_new.next = null;

	}

	public void insertAfter(int new_data, Node previousNode) {

		if (previousNode == null) {

			System.out.println("!!!");
			return;
		}

		Node add_new = new Node(new_data);

		add_new.next = previousNode.next;

		previousNode.next = add_new;

	}

	public void printList() {

		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data + " - ");
			temp = temp.next;
		}

		if (head == null) {
			System.out.println("List is empty :( ");
		}

	}

	public void print(Node head) {

		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data + " - ");
			temp = temp.next;
		}

		if (head == null) {
			System.out.println("List is empty :( ");
		}

	}

	public void count() {

		int count = 0;

		Node temp = head;
		while (temp != null) {
			temp = temp.next;
			count++;
		}

		System.out.println("Count is " + count);
	}

	public void remove_from_index(int data) {

		Node temp = head;

		while (temp.next != null) {
			temp = temp.next;
		}

	}

	void deleteNode(int key) {

		Node temp = head, prev = null;
		if (temp != null && temp.data == key) {
			head = temp.next; // Changed head
			return;
		}
		while (temp != null && temp.data != key) {
			prev = temp;
			temp = temp.next;
		}

		if (temp == null)
			return;

		prev.next = temp.next;
	}

	public void delete(int index) {

		Node temp = head;

		if (index == 0) {

			head = temp.next;
			return;
		}

		if (temp == null) {

			System.out.println("Cannot delete , since list is empty :: ");

		}

		for (int i = 0; temp != null && i < index - 1; i++) {
			temp = temp.next;
		}

		Node next = temp.next.next;

		temp.next = next;

	}

	public int gCount(Node node) {

		if (node == null)
			return 0;

		return 1 + gCount(node.next);

	}

	public int getCount() {

		return gCount(head);
	}

	public Node mergeTwoLists(Node l1, Node l2) {

		Node head = new Node(1);
		Node p = head;

		Node p1 = l1;
		Node p2 = l2;
		while (p1 != null && p2 != null) {
			if (p1.data < p2.data) {
				p.next = p1;
				p1 = p1.next;
			} else {
				p.next = p2;
				p2 = p2.next;
			}
			p = p.next;
		}

		if (p1 != null) {
			p.next = p1;
		}

		if (p2 != null) {
			p.next = p2;
		}

		return p;
	}

	public Node iWantToMergeRecur(Node l1, Node l2) {

		Node result = null;

		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;

		if (l1.data < l2.data) {

			result = l1;
			result.next = iWantToMergeRecur(l1.next, l2);
		} else {

			result = l2;
			result.next = iWantToMergeRecur(l1, l2.next);
		}

		return result;
	}

	public Node AddLinkedListOfTwo(Node head1, Node head2) {

		Node res = null;
		Node prev = null, temp = null;
		int carry = 0, sum;

		while (head1 != null || head2 != null) {

			sum = carry + (head1 != null ? head1.data : 0) + (head2 != null ? head2.data : 0);

			carry = (sum >= 10) ? 1 : 0;

			sum = sum % 10;

			temp = new Node(sum);

			if (res == null)
				res = temp;

			else {
				prev.next = temp;
			}

			prev = temp;

			if (head1 != null) {

				head1 = head1.next;
			}

			if (head2 != null) {

				head2 = head2.next;
			}

		}

		if (carry > 0)

			temp.next = new Node(carry);

		return res;
	}

	public int getNode(Node head, int k) {

		if (head == null)
			return 0;

		Node temp = head;
		int count = 0;

		while (temp != null) {

			temp = temp.next;
			count++;
			if (count == k) {
				return temp.data;
			}
		}
		return -1;
	}

	public void findMiddle() {

		Node slowPtr = head;
		Node fastPtr = head;

		while (fastPtr != null && fastPtr.next != null) {

			slowPtr = slowPtr.next;
			fastPtr = fastPtr.next.next;

		}

		System.out.println("The middle of the linked list is : " + slowPtr.data);

	}

	void printNthFromLast(int n) {
		
		int len = 0;
		Node temp = head;

		while (temp != null) {
			temp = temp.next;
			len++;
		}

		if (len < n)
			return;

		temp = head;

		for (int i = 1; i < len - n + 1; i++)
			temp = temp.next;
		
		System.out.println(temp.data);
	}

	public static void main(String[] args) {

		LinkedList ll_0 = new LinkedList();

		ll_0.push_data(6);
		ll_0.push_data(5);
		ll_0.push_data(4);
		ll_0.push_data(3);
		ll_0.push_data(2);
		ll_0.push_data(1);

		ll_0.printNthFromLast(4);

		ll_0.printList();
		ll_0.findMiddle();
		System.out.println();
		System.out.println(ll_0.getNode(ll_0.head, 4));
		System.out.println();

		System.out.println();

		// FibSeries(4);
		LinkedList ll = new LinkedList();
		ll.push_data(9);
		ll.push_data(9);
		ll.push_data(9);

		ll.printList();

		System.out.println();

		LinkedList ll_m = new LinkedList();
		// ll_m.mergeTwoLists(ll_0.head, ll.head);
		// ll_0.printList();

		// ll_m.iWantTOMergeRecur(ll_0.head, ll.head);
		// ll_0.printList();

		Node rs = ll_m.AddLinkedListOfTwo(ll_0.head, ll.head);
		ll_m.print(rs);

		System.out.println();
		System.out.println();

		ll.push_data_end(100);
		ll.printList();

		System.out.println();

		ll.insertAfter(20, ll.head);
		ll.printList();

		System.out.println();

		ll.deleteNode(20);
		ll.printList();

		System.out.println();

		ll.delete(0);
		ll.printList();

		// ll.deleteNode(4);
		// ll.deleteNode(2);
		// ll.deleteNode(100);

		System.out.println();
		ll.printList();
		ll.count();
		System.out.println(ll.getCount());
		// ll.delete(1);

	}

}
