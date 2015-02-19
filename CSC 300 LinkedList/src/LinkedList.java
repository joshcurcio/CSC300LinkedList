
public class LinkedList 
{
	private Node head;
	private int count;
	
	//upgrade our LinkedList to such that there is a pointer called tail
	//that points to the end of the list, and each node, knows about the
	//previous Node. So you need to update all the add methods, all the 
	//remove methods, and finally re-write displayInRevers to take advantage
	//of our new double-linked list
	
	
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
	
	public void displayInReverse()
	{
		for(int i = this.count - 1; i >= 0; i--)
		{
			System.out.print(this.get(i) + "->");
		}
		System.out.println(" null");
		
		/*LinkedList temp = new LinkedList();
		for(int i = 0; i < this.count; i++)
		{
			temp.addBegin(this.get(i));
		}
		temp.display();*/
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
	
	public void printOdds()
	{
		Node currNode = this.head;
		while (currNode != null);
		{
			if (currNode.getPayload() % 2 == 1)
			{
				System.out.println(currNode.getPayload());
			}
			currNode = currNode.getNextNode();
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
		}
		*/
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
	
	public int removeFront() throws Exception
	{
		Node currNode = this.head;
		if (head == null)
		{
			throw new Exception("Can Not Remove Front: Empty List");
		}
		head = head.getNextNode();
		currNode.setNextNode(null);
		this.count--;
		return currNode.getPayload();	
	}
	
	public int removeEnd() throws Exception
	{
		
		if (head == null)
		{
			throw new Exception("Can Not Remove End: Empty List");
		}
		else if(count == 1)
		{
			return this.removeFront();
		}
		else
		{
			Node currNode = this.head;
			for(int i = 1; i < this.count-1; i++)
			{
				currNode = currNode.getNextNode();
			}
			int payloadToReturn = currNode.getNextNode().getPayload();
			currNode.setNextNode(null);
			count--;
			return payloadToReturn;
		}
	}
	
	public int removeIndex(int index) throws Exception
	{
		if (head == null)
		{
			throw new Exception("Can Not At Index: Empty List");
		}
		else if(index < 0 || index > this.count -1)
		{
			throw new Exception("Can Not At Index: Index Out of Bounds: " + index);
		}
		else
		{
			if (index == 0)
			{
				return this.removeFront();
			}
			else if(index == this.count - 1)
			{
				return this.removeEnd();
			}
			else
			{
				Node currNode = this.head;
				for(int i = 1; i < index - 1; i++)
				{
					currNode = currNode.getNextNode();
				}
				int payloadToReturn = currNode.getNextNode().getPayload();
				Node nextNode = currNode.getNextNode().getNextNode();
				currNode.getNextNode().setNextNode(null);
				currNode.setNextNode(nextNode);
				
				return payloadToReturn;
			}
		}
	}
}
