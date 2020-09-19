Most Simplest Solution 

int CompareLists(Node *headA, Node* headB)
{
    while(headA!=NULL && headB!=NULL && headA->data==headB->data)headA=headA->next,headB=headB->next;
    
    return headA==headB;
}

Another Solution To get Detailed Understanding


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


Merge Two LinkedList In Ascending Order/Sorted

public Node mergeList(Node headA,Node headB)
{
