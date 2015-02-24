//Josh
public class LinkedList 
{
	private Node head;
	private Node tail;
	private int count;
	
	public LinkedList()
	{
		this.head = null;
		this.tail = null;
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
		Node currNode = this.tail;
		while (currNode.getNextNode() != null)
		{
			currNode = currNode.getNextNode();
		}
		while(currNode.getPreviousNode() != null)
		{
			System.out.print(currNode.getPayload() + "->");
			currNode = currNode.getPreviousNode();
		}
		System.out.println(currNode.getPayload() + "-> null");
		
		/*LinkedList temp = new LinkedList();
		for(int i = 0; i < this.count; i++)
		{
			temp.addBegin(this.get(i));
		}
		temp.display();*/
	}
		
	public void addBegin (int payload)
	{
		Node n = new Node(payload);
		
		if(this.head == null)
		{
			this.head = n;
			this.tail = n;
		}
		else
		{
			this.head.setPreviousNode(n);
			n.setNextNode(head);
			this.head = n;
		}
		this.count++;
	}
	
	public void addAtIndex(int payload, int index)
	{
		if (index <= 0)
		{
			this.addBegin(payload);
		}
		else if(index >= this.count)
		{
			this.addEnd(payload);
		}
		else
		{
			Node currNode = this.head;
			Node n = new Node(payload);
			
			for (int i = 0; i < index; i++)
			{
				currNode = currNode.getNextNode();
			}
			
			n.setNextNode(currNode);
			n.setPreviousNode(currNode.getPreviousNode());
			currNode.setPreviousNode(n);
			n.getPreviousNode().setNextNode(n);
			
			this.count++;
		}
	}
	
	public void addEnd(int payload)
	{
		Node n = new Node(payload);
		if(this.head == null)
		{
			this.head = n;
			this.tail = n;
		}
		else
		{
			tail.setNextNode(n);
			n.setPreviousNode(tail);
			tail = n;
		}
		this.count++;
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
		if (head == null)
		{
			throw new Exception("Can Not Remove Front: Empty List");
		}
		else if (this.count == 1)
		{
			int payloadToReturn = this.head.getPayload();
			this.head = null;
			this.tail = null;
			this.count--;
			return payloadToReturn;
		}
		else
		{
			Node curr = head;
			curr.getNextNode().setPreviousNode(null);
			head = curr.getNextNode();
			curr.setNextNode(null);
			this.count--;
			return curr.getPayload();	
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
				for(int i = 0; i < index; i++)
				{
					currNode = currNode.getNextNode();
				}
				currNode.getPreviousNode().setNextNode(currNode.getNextNode());
				currNode.getNextNode().setPreviousNode(currNode.getPreviousNode());
				currNode.setPreviousNode(null);
				currNode.setNextNode(null);
				this.count--;
				return currNode.getPayload();
			}
		}
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
			Node curr = this.tail;
			tail = curr.getPreviousNode();
			curr.setPreviousNode(null);
			tail.setNextNode(null);
			return curr.getPayload();
		}
	}

}
