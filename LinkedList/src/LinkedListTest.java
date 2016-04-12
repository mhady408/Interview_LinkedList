
/**
 * the test function of LinkedList
 */
public class LinkedListTest {
	public static void main(String args[]){
		Operation list = new Operation();
		ListNode start = list.creatLinkedList();

		/*****获取链表总节点数********/
		//int sum = list.getNum(start);
		//System.out.println(sum);
		
		/********反转链表***********/
		//ListNode ReverseList = list.reverseList(start);
		//System.out.println(ReverseList.value);
		
		/******获取倒数第k个节点********/
		//ListNode KthNode = list.getRKthNode(start, 2);
		//System.out.println(KthNode.value);
		
		/******获取链表中间节点********/
		//ListNode MidNode = list.getMidNode(start);
		//System.out.println(MidNode.value);
		
		/**********从尾到头打印链表***********/
		//System.out.println("从尾到头打印链表:");
		//list.printNodeReverse(start);
		
		/**********判断链表是否有环***********/
		//System.out.print("判断链表是否有环:");
		//boolean isCircle = list.hasCircle(start);
		//System.out.println(isCircle);
		
		System.out.print("获取链表中环的入口:");
		ListNode firstnode = list.getFirstNodeInCircle(start);
		System.out.println(firstnode.value);
		
		//ListNode deletenode = list.getKNode(start, 3);
		//list.deleteNode(start, deletenode);
		
	}
	

}