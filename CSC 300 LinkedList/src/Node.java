
public class Node 
{
	private Node nextNode;
	private Node prevNode;
	private int payload;
	
	public Node(int payload)
	{
		this.payload = payload;
		this.nextNode = null;
		this.prevNode = null;
	}
	
	public Node getNextNode() 
	{
		return this.nextNode;
	}
	
	public Node getPreviousNode()
	{
		return this.prevNode;
	}
 
	public void setNextNode(Node nextNode) 
	{
		this.nextNode = nextNode;
	}
	
	public void setPreviousNode(Node prevNode)
	{
		this.prevNode = prevNode;
	}
 
	public int getPayload() 
	{
		return payload;
	}
	
}
