
public class LinkedList 
{
	private Node head;
	private int count;
	
	public LinkedList()
	{
		this.head = null;
		this.count = 0;
	}
	public void display()
	{
		if(head == null)
		{
			System.out.println("Empty List");
		}
		else
		{
			Node currNode = this.head;
			while(currNode.getNextNode() != null)
			{
				System.out.print(currNode.getPayload() + "->");
				currNode = currNode.getNextNode();
			}
			System.out.println(currNode.getPayload() + "-> null");
		}
	}
	public void addEnd(int payload)
	{
		Node n = new Node(payload);
		if(this.head == null)
		{
			this.head = n;
		}
		else
		{
			//find the last node in the list
			Node currNode = this.head;
			while(currNode.getNextNode() != null)
			{
				currNode = currNode.getNextNode();
			}
			//currNode will point to the very last Node in the list
			currNode.setNextNode(n);
		}
		this.count++;
	}
	
	public void addBegin (int payload)
	{
		Node n = new Node(payload);
		
		if(this.head == null)
		{
			this.head = n;
		}
		else
		{
			Node currNode = this.head;
			currNode.getNextNode();
			this.head = n;
			n.setNextNode(currNode);
		}
		this.count++;
	}
	
	public void addAtIndex(int payload, int index)
	{
		index = index - 1;
		if (index < 0)
		{
			this.addBegin(payload);
		}
		else if(index > count() - 1)
		{
			this.addEnd(payload);
		}
		else
		{
			Node pastNode = this.head;
			Node currNode = this.head;
			Node n = new Node(payload);
			
			for (int i = 0; i < count(); i++)
			{
				
					pastNode = currNode;
					currNode = currNode.getNextNode();

					if (i == index)
					{
						pastNode.setNextNode(n);
						n.setNextNode(currNode);
					}
			}
			this.count++;
		}
	}
	
	public int count()

	{
		/*if (head == null)
		{
			return 0;
		}
		else
		{
			int sum = 1;
			Node curr = head;
			while(curr.getNextNode() != null)
			{
				sum++;
				curr = curr.getNextNode();
			}
			return sum;
		}*/
		return count;
	}

	public int get(int index)
	{
		int count = this.count();
		if (index >= count || index < 0) //|| head == null is covered by index >= count
		{
			System.err.println("Illegal Index");
			return -1;
		}
		else
		{
			Node curr = head;
			for (int i = 0; i < index; i++)
			{
				curr = curr.getNextNode();
			}
			return curr.getPayload();
		}
	}
}
