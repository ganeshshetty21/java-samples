package interview.node;

public class NodeDemo {

	public static void main(String[] args) {
		NodeDemo demo = new NodeDemo();
		demo.root = demo.add(demo.root, 11);
		demo.add(demo.root, 9);
		demo.add(demo.root, 10);
		demo.add(demo.root, 8);
		demo.add(demo.root, 13);
		demo.add(demo.root, 14);
		demo.add(demo.root, 12);

		demo.inOrder(demo.root);
		System.out.println();
		demo.preOrder(demo.root);
		System.out.println();
		demo.postOrder(demo.root);
		System.out.println();

		demo.searchIndex = 0;
		System.out.println(demo.search(demo.root, 5));
		demo.searchIndex = 0;
		System.out.println(demo.search(demo.root, 14));
		demo.searchIndex = 0;
		System.out.println(demo.search(demo.root, 11));
		demo.searchIndex = 0;
		System.out.println(demo.search(demo.root, 8));
	}

	Node root;

	public Node add(Node node, int data) {
		if (node == null)
			node = new Node(data);
		else if (node.data < data)
			node.right = add(node.right, data);
		else if (node.data > data)
			node.left = add(node.left, data);
		return node;
	}

	int searchIndex = 0;

	public int search(Node node, int data) {
		searchIndex++;
		if (node == null)
			return -1;
		else if (node.data == data)
			return searchIndex;
		else if (node.data > data)
			return search(node.left, data);
		else if (node.data < data)
			return search(node.right, data);
		return -1;
	}

	public void inOrder(Node node) {
		if (node == null)
			return;
		inOrder(node.left);
		System.out.println(node.data);
		inOrder(node.right);
	}

	public void preOrder(Node node) {
		if (node == null)
			return;
		System.out.println(node.data);
		preOrder(node.left);
		preOrder(node.right);
	}

	public void postOrder(Node node) {
		if (node == null)
			return;
		postOrder(node.left);
		postOrder(node.right);
		System.out.println(node.data);
	}

	class Node {
		Node right;
		Node left;
		int data;

		Node(int data) {
			this.data = data;
			right = null;
			left = null;
		}
	}

}
