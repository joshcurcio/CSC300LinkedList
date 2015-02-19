
public class Driver 
{

	public static void main(String[] args) throws Exception
	{
		LinkedList ll = new LinkedList();
		
		ll.addBegin(6);
		ll.addEnd(2);
		ll.addEnd(3);
		ll.addEnd(5);
		ll.addEnd(9);
		ll.addAtIndex(7, 1);
		ll.addBegin(3);
		ll.addEnd(10);

		ll.display();
		ll.removeIndex(4);
		ll.display();
	}
}
