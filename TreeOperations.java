import java.util.Scanner;

import javax.xml.crypto.Data;

class Node
{
	int data;
	Node left;
	Node right;
}
class Tree
{
	public Node create(int data)
	{
		Node newNode=new Node();
		newNode.data=data;
		newNode.left=null;
		newNode.right=null;
		
		return newNode;
	}
	public Node insert(Node node,int data) 
	{
		if(node==null)
			return create(data);
		else if(node.data>data)
			node.left=insert(node.left, data);
		else if(node.data<data)
			node.right=insert(node.right, data);
		
		return node;
	}
	public void inorderTraversal(Node node)
	{
		if(node!=null)
		{
			inorderTraversal(node.left);
			System.out.print(node.data+" ");
			inorderTraversal(node.right);
		}
	}
	public void postorderTraversal(Node node)
	{
		if(node!=null)
		{
			inorderTraversal(node.left);
			inorderTraversal(node.right);
			System.out.print(node.data+" ");
		}
	}
	public void preorderTraversal(Node node)
	{
		if(node!=null)
		{
			System.out.print(node.data+" ");
			inorderTraversal(node.left);
			inorderTraversal(node.right);
		}
	}
	public Node search(Node node,int key)
	{
		if(node.data==key)
			return node;
		else if(node.data>key)
			return search(node.left, key);
		else return search(node.right, key);
	}
	public Node delete(Node node,int key)
	{
		if(node==null)
			return null;
		else if(key<node.data)
			node.left=delete(node.left, key);
		else if(key>node.data)
			node.right=delete(node.right, key);
		else {
			if(node.left==null) return node.right;
			else if(node.right==null) return node.left;
			else {
				node.data=minValue(node.right);
				node.right=delete(node.right,node.data);
			}
		}
		return node;
	}
	public int minValue(Node node)
	{
		int minval=node.data;
		while(node.left!=null)
		{
			minval=node.left.data;
			node=node.left;
		}
		return minval;
	}
	public boolean existance(Node node,int key)
	{
		boolean flag=false;
		if(node.data==key)
			flag=true;
		else if(node.data>key && node.left!=null)
			flag=existance(node.left, key);
		else if(node.data<key && node.right!=null)
			flag=existance(node.right, key);
		else flag=false;
		return flag;
	}
	public Node getParent(Node node,int key)
	{
		if(node==null) return null;
		Node parent=null;
		{
			 while(node!=null)
		        {
		            if(node.data<key)
		            {
		                parent=node;
		                node=node.right;
		            }
		            else if(key<node.data)
		            {
		                parent=node;
		                node=node.left;
		            }
		            else break;
		        }
		}
		return parent;
	}
	public Node getSibling(Node node,int key)
	{
		if(node==null || node.data==key)
			return null;
		
		Node parent=null;
		while(node!=null)
		{
			if(node.data>key)
			{
				parent=node;
				node=node.left;
				if(node.data==key)
					return parent.right;
			}
			else if(node.data<key)
			{
				parent=node;
				node=node.right;
				if(node.data==key)
					return parent.left;
			}else {
				break;
			}
		}
		return parent;
		/*alternate method for getting sibling node
		get a parent node of given value as method "getParent()"
		after getting parent node compare if(parent.left.data==key) return parent.right 
		or else if(parent.right.data==key) return parent.left 
		
		*/
	}
	public Node inorderParent(Node node,int key)
	{
		if(node==null) return null;
		Node parent=null;
		
		while(node!=null)
		{
			if(node.data>key)
			{
				parent=node;
				node=node.left;
			}
			else if(node.data<key)
			{
				node=node.right;
			}else break;
		}
		return node!=null?parent:null;
	}
	public int sum(Node node)
	{
		if(node==null) return 0;
		
		return node.data-sum(node.left)-sum(node.right);
	}
	public int getMin(Node node)
	{
		if(node==null){
			System.out.println("Tree is empty");
			return -1;
		}
		while(node.left!=null)
		{
			node=node.left;
		}
		return node.data;
	}
	public int getMax(Node node)
	{
		if(node==null)
		{
			System.out.println("Tree is Empty");
			return -1;
		}
		while(node.right!=null)
			node=node.right;
		return node.data;
	}
	public Node inorderSuccessor(Node node,int key)
	{
		if(node==null) return null;
		Node inorderSuccessor=null;
		while(node!=null)
		{
			if(key<node.data)
			{
				inorderSuccessor=node;
				node=node.left;
			}
			else if(key>node.data)
				node=node.right;
			else
			{
				if(node.right!=null)
					inorderSuccessor= getSuccessor(node);
				break;
			}
			
		}
		
		return node != null ? inorderSuccessor : null;
	}
	public Node getSuccessor(Node node) {
		if(node==null)
			return null;
		Node temp=node.right;
		while(temp.left!=null)
			temp=temp.left;
		return temp;
	}
	
	public int getHeight(Node root)
	{
		
		if(root==null)
			return -1;
		return getHeight(root.left)>getHeight(root.right)?getHeight(root.left)+1:getHeight(root.right)+1;
	}
	public void topViewleft(Node node)
	{
		if(node!=null)
		{
			topViewleft(node.left);
			System.out.print(node.data+" ");
		}
	}
	public void topViewright(Node node)
	{
		if(node!=null)
		{
			System.out.print(node.data+" ");
			topViewright(node.right);
		}
	}
	
	public void topView(Node root)
	{
		if(root==null) return;
		topViewleft(root);
		topViewright(root.right);
		
	}
	public Node innerLCA(Node node,int v1,int v2)
	{
		if(getNode(node, v1)==getParent(node, v2) || getNode(node, v2)==getParent(node, v1) || getParent(node,v1)==getParent(node, v2))
		{
			if(getNode(node, v2)==getParent(node, v1))
				return getNode(node, v2);
			else return getParent(node, v2);
		}
	else if(getParent(node,v1).data>getParent(node, v2).data)
		return getLCA(node, getParent(node, v1).data,v2 );
	else return getLCA(node, v1, getParent(node, v2).data);
	}
	
	public Node getLCA(Node node,int v1,int v2)
	{
		int min=v1<v2?v1:v2;
		int max=v1>v2?v1:v2;
		return innerLCA(node, min, max);
	}
	public Node getNode(Node node,int key)
	{
		if(node.data==key)
			return node;
		else if(node.data>key)
			return getNode(node.left, key);
		else return getNode(node.right, key);
	}
	
}
	public class TreeOpeations
	{
		public static void main(String[] args) {
			Node root=null;
			Tree tree=new Tree();
			
			root=tree.insert(root,5);
			tree.insert(root,3);
			tree.insert(root,8);
			tree.insert(root,2);
			tree.insert(root,4);
			tree.insert(root,6);
			tree.insert(root,7);
			//tree.insert(root,5);
			//tree.insert(root,13);
			tree.inorderTraversal(root);
			System.out.println();
			System.out.println(tree.getLCA(root, 3, 7).data);
			//System.out.println(tree.getLCA(root, 14, 10).data);
			//System.out.println(tree.getParent(root, 2).data);

			
			
			
			
		}
}