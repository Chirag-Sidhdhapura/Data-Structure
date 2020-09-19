class Node
{
	int data;
	Node left;
	Node right;
}
class Tree
{
	public Node createNewNode(int data)
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
			node=createNewNode(data);
		else if(data>node.data)
			node.right=insert(node.right, data);
		else if(data<node.data)
			node.left=insert(node.left, data);
		return node;
			
			
	}
	public void show(Node node)
	{
		if(node!=null)
		{
			show(node.left); 
			System.out.println(node.data+" ");
			show(node.right);
		}
	}
	public Node search(Node node,int key)
	{
		if(node==null || node.data==key)
			return node;
		else if(key>node.data)
			return search(node.right, key);
		else return search(node.left, key);
			
	}
	public Node deleteNode(Node node,int key)
	{
		if(node==null)
			return null;
		else if(node.data>key)
			node.left=deleteNode(node.left, key);
		else if(node.data<key)
			node.right=deleteNode(node.right, key);
		else {
			if(node.left==null)
				return node.right;
			else if (node.right==null) {
				return node.left;
			}
			else {
				node.data=minValue(node.right);
				node.right=deleteNode(node.right, node.data);	
			}
		}
		return node;
	}
	public int minValue(Node node)
	{
		int  minval=node.data;
		while(node.left!=null)
		{
			minval=node.left.data;
			node=node.left;
		}
		return minval;
		
	}
}
public class TreeImplementation{
	public static void main(String[] args) {
		Tree tree=new Tree();
		Node root=null;
		
		root=tree.insert(root, 4);
		tree.insert(root, 6);
		tree.insert(root, 7);
		tree.insert(root, 5);
		tree.insert(root, 1);
		tree.insert(root, 2);
		tree.insert(root, 3);
		
		tree.deleteNode(root, 4);
		tree.show(root);
		System.out.println(root.data);
		
		
	}
}