package DoublyPackage;
class Node
{
	int data;
	Node prev;
	Node next;
	public Node(int data)
	{
		this.data=data;
		this.next=null;
		this.prev=null;
	}
}
class DLL
{
	Node head;
	public void insertAtFront(int data)
	{
		Node newNode=new Node(data);
		if(head==null)
		{
			head=newNode;
			head.next=null;
			head.prev=null;
		}
		else
		{
			newNode.next=head;
			newNode.prev=null;
			head.prev=newNode;
			head=newNode;
		}
	}
	public void insertAtEnd(int data)
	{
		Node current=head;
		Node newNode=new Node(data);
		while(current.next!=null)
		{
			current=current.next;
		}
		current.next=newNode;
		newNode.next=null;
		newNode.prev=current;
	}
	public void insertAfter(Node n,int data)
	{
		Node newNode=new Node(data);
		Node temp=n.next;
		n.next=newNode;
		newNode.prev=n;
		newNode.next=temp;
		temp.prev=newNode;
		
	}
	public void show()
	{
		Node current=head;
		while(current!=null)
		{
			System.out.print(current.data+" ");
			current=current.next;
		}
	}
	public void insertBefore(Node n,int data)
	{
		Node newNode =new Node(data);
		Node temp=n.prev;
		n.prev=newNode;
		newNode.next=n;
		newNode.prev=temp;
		temp.next=newNode;
	}
}
public class DoublyLinkedList
{
	public static void main(String[] args) {
		
		DLL dll=new DLL();
		dll.insertAtFront(3);
		dll.insertAtFront(2);
		dll.insertAtFront(1);
		dll.insertAtFront(0);
		
		dll.insertAtEnd(5);
		
		dll.insertAfter(dll.head.next.next.next,4);
		
		dll.insertBefore(dll.head.next.next, 999);
		
		
		
		dll.show();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}