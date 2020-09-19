class Node
{
	int data;
	Node next;
	public Node(int d)
	{
		data=d;
		next=null;
	}
}
class LinkedLis
{
	Node head;
	public void insert(int data)
	{
		Node newNode=new Node(data);
		if(head==null)
		{
			head=newNode;
		}
		else
		{
			Node temp=head;
			while(temp.next!=null)
			{
				temp=temp.next;
			}
			temp.next=newNode;
		}
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
	public void insertAt(int index,int data)
	{
		Node current=head;
		Node newNode=new Node(data);
		if(index==0)
			insertAtStart(data);
		else{
		for(int i=0;i<index-1;i++)
		{
			current=current.next;
		}
		Node temp=current.next;
		current.next=newNode;
		current.next.next=temp;
	}}
	public void insertAtStart(int data)
	{
		Node newNode=new Node(data);
//		newNode.next=head;
//		head=newNode
		
		if(head==null)
			head=newNode;
		else
		{
			Node temp=head;
			head=newNode;
			head.next=temp;
		}
	}
	public void reverse(Node h)
	{
		Node current=h;
		Node prev=null;
		 Node next=null;
		 while(current!=null)
		 {
			 next=current.next;
			 current.next=prev;
			 prev=current;
			 current=next;
		 }
		 head=prev;
	}
	public boolean compare(Node head1,Node head2)
	{
		Node current1=head1;
		Node current2=head2;
		int count1=0;
        int count2=0;

        while(current1!=null)
        {
            count1++;
            current1=current1.next;
        }
        
        while(current2!=null)
        {
            count2++;
            current2=current2.next;
        }
        boolean flag=true;
        if(count1==count2)
        {
        	current1=head1;
        	current2=head2;
        	for(int i=0;i<count1;i++)
        	{
        		if(current1.data==current2.data)
        		{
        			if(i==(count1-1))
        			{
        				flag=true;
        			}
        			current1=current1.next;
        			current2=current2.next;
        		}
        		else
        		{
        			flag=false;
        			break;
        		}
        	}
        	return flag;
        }
        else return false;
       
	}
	public void delete(int index)
	{
		Node current=head;
		if(index==0)
		{
			head=current.next;
		}
		else{
		for(int i=0;i<index-1;i++)
		{
			current=current.next;
		}
		}
		current.next=current.next.next;
		
	}
	public boolean anotherCompare(Node head1,Node head2)
	{
		while(head1!=null && head2!=null && head1.data==head2.data){
			head1=head1.next;
			head2=head2.next;
		}
		
		return head1==head2;
	}
	public void sort()
	{
		Node current=head;
		while(current!=null)
		{
			Node index=current.next;
			while(index!=null)
			{
				if(current.data>index.data)
				{
					int temp=current.data;
					current.data=index.data;
					index.data=temp;
				}
				index=index.next;
			}
			current=current.next;
		}
	}
	
	public Node mergeList(Node headA,Node headB)
	{
		if(headA==null && headB==null) return headA;
		else if(headA!=null && headB==null) return headA;
		else if(headA==null && headB!=null) return headB;
		
		if(headA.data>headB.data)
		{
			Node temp=headB;
			headB=headB.next;
			temp.next=headA;
			headA=temp;
		}
		headA.next=mergeList(headA.next, headB);
		
		
		return headA;
	}
	public int getNode(Node head, int positionFromTail) {
        Node current=head;
        int count=0;
        while(current!=null)
        {
            count++;
            current=current.next;
        }
        Node x=head;
        int tempCount=count-positionFromTail;
        for(int i=0;i<tempCount-1;i++)
        {
            x=x.next;
        }
        int y=x.data;
        return y;
       
    }

	
	public void removeDuplicate(Node head)
	{
		sort();
		Node current=head;
		while(current.next!=null)
		{
			if(current.next.data==current.data)
			{
				current.next=current.next.next;
			}
			else
			{
				current=current.next;
			}
		}
	}

	
}
public class LinkedList Implementation
{
	public static void main(String[] args) {
		LinkedLis linkedList=new LinkedLis();
		LinkedLis l2=new LinkedLis();
		
		linkedList.insert(1);
		linkedList.insert(2);
		linkedList.insert(3);
		linkedList.insert(4);
		linkedList.insert(5);
		linkedList.insert(1);
		linkedList.insert(6);
		linkedList.insert(7);
		linkedList.insert(8);
		
		
		
		
		
		l2.insert(5);
		l2.insert(1);
		l2.insert(2);
		
		l2.insert(8);
		l2.insert(4);
		l2.insert(3);
		l2.insert(6);
		l2.insert(7);
		
		
		
		//System.out.println(linkedList.anotherCompare(linkedList.head, l2.head));
//		linkedList.show();
//		System.out.println();
//		linkedList.reverse(linkedList.head);
//		linkedList.show();
//		linkedList.show();
//		System.out.println();
//		l2.show();
//		System.out.println();
//		System.out.println(linkedList.compare(linkedList.head, l2.head));
//		Node abc=linkedList.mergeList(linkedList.head, l2.head);
//		linkedList.show();
		
		//System.out.println(linkedList.getNode(linkedList.head,4));
//		linkedList.show();
//		System.out.println();
//		linkedList.removeDuplicate(linkedList.head);
//		linkedList.show();
		linkedList.removeDuplicate(linkedList.head);
		linkedList.show();
		
	}
}