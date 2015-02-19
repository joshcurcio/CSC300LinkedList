
public class Driver 
{

	public static void main(String[] args)
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
		
		try
		{
			System.out.println(ll.removeFront());
			System.out.println(ll.removeEnd());
			System.out.println(ll.removeIndex(4));
		}
		catch(Exception e)
		{
			System.out.println("Failed to Remove");
		}
		
		ll.display();
	}
}
