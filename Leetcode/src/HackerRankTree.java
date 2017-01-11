class TNode {
	int data;
	TNode left;
	TNode right;

	TNode(int item) {
		data = item;
		left = right = null;
	}
}

public class HackerRankTree {

	void printTree(TNode root) {
		if (root == null) {
			return;
		} else {
			System.out.print(root.data + " ");
			printTree(root.left);
			printTree(root.right);
		}
	}

	TNode insert(TNode root, int value) {
		TNode newNode = new TNode(value);
		if (root == null) {
			return newNode;
		}

		TNode node = root;
		while (node != null) {
			if (value < node.data) {
				if (node.left == null) {
					node.left = newNode;
					return root;
				}
				node = node.left;
			} else {
				if (node.right == null) {
					node.right = newNode;
					return root;
				}
				node = node.right;
			}
		}
		return root;
	}

	TNode insert2(TNode root, int value) {
		TNode newNode = new TNode(value);
		if (root == null) {
			return newNode;
		}
		if (value < root.data) {
			root.left = insert2(root.left, value);
		} else {
			root.right = insert2(root.right, value);
		}
		return root;
	}

	int height(TNode root) {
		if (root == null) {
			return -1;
		} else {
			if (height(root.left) > height(root.right)) {
				return 1 + height(root.left);
			} else {
				return 1 + height(root.right);
			}
		}
	}

	void LevelOrderUtil(TNode root, int height) {
		if (root == null)
			return;
		int k = height - 1;
		LevelOrderUtil(root.left, k);
		LevelOrderUtil(root.right, k);

		if (height == 0)
			System.out.print(root.data + " ");
	}

	void LevelOrder(TNode root) {
		if (root == null) {
			return;
		}
		int height = height(root);
		for (int i = 0; i <= height; i++) {
			LevelOrderUtil(root, i);
		}
	}

	void top_view(TNode root) {
		if (root == null)
			return;
		top_view(root, 0);
		top_view(root.right, -1);
	}

	void top_view(TNode root, int side) {
		if (root == null)
			return;
		if (root != null) {
			if (side >= 0) {
				top_view(root.left, 0);
				System.out.print(root.data + " ");
			}

			if (side < 0) {
				System.out.print(root.data + " ");
				top_view(root.right, -1);
			}
		}
	}

	public static void main(String[] args) {
		HackerRankTree t = new HackerRankTree();

		TNode root = new TNode(4);
		root.left = new TNode(2);
		root.right = new TNode(7);
		root.left.left = new TNode(1);
		root.left.right = new TNode(3);
		root.right.left = new TNode(6);
		// t.LevelOrder(root);
		// System.out.println();
		t.top_view(root);

		// t.printTree(root);
		// System.out.println();
		// t.insert2(root, 6);
		// t.printTree(root);
		// System.out.println();
	}

}
