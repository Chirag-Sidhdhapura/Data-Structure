class Node
{
	int data;
	Node next;
	
	public Node(int data)
	{
		this.data=data;
		this.next=null;
	}
}
class CLL
{
	Node head=null;
	Node tail=null;
	public void insert(int data)
	{
		Node newNode=new Node(data);
		if(head==null)
		{
			head=newNode;
			tail=newNode;
			tail.next=head; 
		}
		else
		{
			tail.next=newNode;
			tail=newNode;
			tail.next=head;
		}
	}
	public void show()
	{
		Node current=head;
		if(head==null)
			System.out.println("No Elements");
		else{
		while(current.next!=head)
		{
			System.out.print(current.data+" ");
			current=current.next;
		}
		System.out.print(current.data+" ");
		}
	}
}

public class CircularLinkedList
{
	public static void main(String[] args) {
		CLL cll=new CLL();
		cll.insert(0);
		cll.insert(1);
		cll.insert(2);
		cll.insert(3);
		cll.insert(4);
		
		cll.show();
	}
}
















