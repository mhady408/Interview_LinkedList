
/**
 * the test function of LinkedList
 */
public class LinkedListTest {
	public static void main(String args[]){
		Operation list = new Operation();
		ListNode start = list.creatLinkedList();

		/*****��ȡ�����ܽڵ���********/
		//int sum = list.getNum(start);
		//System.out.println(sum);
		
		/********��ת����***********/
		//ListNode ReverseList = list.reverseList(start);
		//System.out.println(ReverseList.value);
		
		/******��ȡ������k���ڵ�********/
		//ListNode KthNode = list.getRKthNode(start, 2);
		//System.out.println(KthNode.value);
		
		/******��ȡ�����м�ڵ�********/
		//ListNode MidNode = list.getMidNode(start);
		//System.out.println(MidNode.value);
		
		/**********��β��ͷ��ӡ����***********/
		//System.out.println("��β��ͷ��ӡ����:");
		//list.printNodeReverse(start);
		
		/**********�ж������Ƿ��л�***********/
		//System.out.print("�ж������Ƿ��л�:");
		//boolean isCircle = list.hasCircle(start);
		//System.out.println(isCircle);
		
		System.out.print("��ȡ�����л������:");
		ListNode firstnode = list.getFirstNodeInCircle(start);
		System.out.println(firstnode.value);
		
		//ListNode deletenode = list.getKNode(start, 3);
		//list.deleteNode(start, deletenode);
		
	}
	

}