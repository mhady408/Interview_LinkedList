import java.util.Stack;

/**
 * the common operation of LinkedList
 * @author maheng
 */
public class Operation {
	
	/**
	 * create the test LinkedList
	 */
	public ListNode creatLinkedList(){
		
		ListNode start = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		//ListNode node6 = new ListNode(6);
		start.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node5;
		return start;
	}
	
	/**
	 * get the sum number of node
	 */
	public int getNum(ListNode start){
		
		int num = 1;
		while(start.next != null){//q����ȥ�������next����num�ĳ�ʼֵ��Ϊ0
			num++;
			start = start.next;
		}
		return num;
	}
	
	/**
	 * get the ReverseList
	 */
	public ListNode reverseList(ListNode start){
		
		if(start == null || start.next == null)
			return start;
		ListNode pre = new ListNode(0);
		pre.next = start;
		ListNode node = start;
		while(node!= null){
			ListNode tmp = node.next;//����node�ڵ����һ�ڵ�
			node.next = pre;         //���µ�nextָ��ָ��pre��ָ�뷴ת
			pre = node;              //node,pre������ǰ���ƶ���ֱ��node == null
			node = tmp;
		}
		return pre;
	}
	
	/**
	 * get the Kth node in reverse order
	 */
	public ListNode getRKthNode(ListNode start,int k){
		
		if(start == null || k<=0)
			return null;
		ListNode first = start;
		ListNode second = start;
		for(int i=0;i<k;i++){
			first = first.next;
		}
		if(first == null)
			return start;
		while(first.next != null){
			first = first.next;
			second = second.next;//second ��λ�ڵ�����K���ڵ�֮ǰ���������ĺô���ɾ��������K���ڵ�򵥣�
			                     //��ȻҲ����ֱ�Ӷ�λ������K������while��first��nextȥ��	                     
		} 
		return second.next;				
	}
	
	/**
	 * get the middle node of the LinkedList
	 */
	public ListNode getMidNode(ListNode start){
		
		if(start == null || start.next == null)
			return start;
		ListNode first = start;
		ListNode second = start;
		while(first.next != null){
			first = first.next;
			second = second.next;
			if(first.next != null)
				first = first.next; //firstÿ����������ֱ������ĩβ��secondֻ��һ�Σ����secondλ�ü�Ϊ���Ľڵ�
		}
		return second;
	}
	
	/**
	 * print the node from tail to head
	 */
	public void printNodeReverse(ListNode start){
		
		Stack<ListNode> stack = new Stack<ListNode>();
		while(start != null){
			stack.push(start);
			start = start.next;
		}
		while(stack.size() != 0){
			ListNode tmp = stack.pop();
			System.out.println(tmp.value);
		}
	}
	
	/**
	 * merge two ordered LiinkedList
	 */
	public ListNode mergeTwoList(ListNode List1,ListNode List2){
		
		if(List1 == null)
			return List2;
		if(List2 == null)
			return List1;
		ListNode result = new ListNode(-1);
		ListNode head = result;
		while(List1 != null && List2 != null){
			if(List1.value < List2.value){
				result.next = List1;
				List1 = List1.next;
			}else{
				result.next = List2;
				List2 = List2.next;
			}
			result = result.next;
		}
		if(List1 != null){
			result.next = List1;
		}
		if(List2 != null){
			result.next = List2;
		}
		return head.next;
	}
	
	/**
	 * judge whether the LinkedList has a circle
	 */
	public boolean hasCircle(ListNode start){
		
		ListNode fir = start;
		ListNode sec = start;
		while(fir != null && fir.next != null){
			fir = fir.next.next;
			sec = sec.next;
			if(fir == sec)
				return true;
		}
		return false;
	}
	
	/**
	 * get the first ListNode of entering the circle
	 */
	public ListNode getFirstNodeInCircle(ListNode start){
		
		ListNode MeetingNode = getMeetingNodeInLoop(start);
		int size_loop = 1;
		ListNode counter = MeetingNode;
		while(counter.next != MeetingNode){
			counter = counter.next;
			size_loop++;
		}
		ListNode fir = start;
		ListNode sec = start;
		for(int i=0;i<size_loop;i++){
			fir = fir.next;
		}
		while(fir != sec){
			fir = fir.next;
			sec = sec.next;
		}
		return fir;
		
	}
	
	/**
	 * the assist function of getFirstNodeInCircle
	 */
	public ListNode getMeetingNodeInLoop(ListNode start){
		
		ListNode fir = start;
		ListNode sec = start;
		while(fir != null){
			fir = fir.next;
			sec = sec.next;
			if(fir != null)
				fir = fir.next;
			if(fir == sec)
				return fir;
		}
		return null;
	}
	
	/**
	 * judge whether two LinkedList intersect
	 */
	public boolean isIntersect(ListNode List1,ListNode List2){
		
		if(List1 == null || List2 == null)
			return false;
		ListNode tail1 = List1;
		while(tail1.next != null){
			tail1 = tail1.next;
		}
		ListNode tail2 = List2;
		while(tail2.next != null){
			tail2 = tail2.next;
		}
		return tail1 == tail2;
	}
	
	/**
	 * get the first ListNode of two LinkedList intersection
	 */
	public ListNode getFirstNodeIntersection(ListNode List1,ListNode List2){
		
		if(List1 == null || List2 == null)
			return null;
		int len1 = getNum(List1);
		int len2 = getNum(List2);
		if(len1>len2){
			int abs_len = len1-len2;
			for(int i=0;i<abs_len;i++){
				List1 = List1.next;
			}
		}else if(len1<len2){
			int abs_len = len2-len1;
			for(int j=0;j<abs_len;j++){
				List2 = List2.next;
			}
		}
		while(List1 != null && List2 != null && List1 != List2){
			List1 = List1.next;
			List2 = List2.next;
		}
		ListNode ResNode = List1;
		return ResNode;
	}
	
	/*
	 * delete the node in O(1) time
	 */
	public void deleteNode(ListNode start,ListNode del_node){
		
		if(start == null || del_node == null)
			return ;
		if(del_node.next != null){
			ListNode tmp = del_node.next;
			del_node.value = tmp.value;
			del_node.next = tmp.next;
			tmp = null;
		}else if(del_node == start){
			del_node = null;
		}else{
			ListNode pre = start;
			while(pre.next != del_node){
				pre = pre.next;
			}
			pre.next = null;
		}
		//������
		while(start != null){
			System.out.println(start.value);
			start = start.next;
		}
	}
	
	/**
	 * test the deletNode function, get the one node of LinkedList
	 */
	public ListNode getKNode(ListNode start,int k){
		ListNode node = start;
		while(node.value != k){
			node = node.next;
		}
		return node;
	}
	

}
