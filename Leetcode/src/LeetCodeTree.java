import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

class TreeNode {
	int data;
	TreeNode left;
	TreeNode right;

	TreeNode(int item) {
		data = item;
		left = right = null;
	}
}

public class LeetCodeTree {
	/*
	 * Given a binary tree, find its maximum depth. The maximum depth is the
	 * number of nodes along the longest path from the root node down to the
	 * farthest leaf node.
	 */
	// Divide and Conquer
	int maxDepth(TreeNode node) {
		if (node == null) {
			return 0;
		} else {
			int lDepth = maxDepth(node.left);
			int rDepth = maxDepth(node.right);
			if (lDepth > rDepth) {
				return lDepth + 1;
			} else {
				return rDepth + 1;
			}
		}
	}

	public TreeNode invertTree(TreeNode root) {
		if (root == null) {
			return null;
		}
		TreeNode left = root.left;
		TreeNode right = root.right;
		left = invertTree(right);
		right = invertTree(left);
		return root;
	}

	public static int sumOfLeftLeaves(TreeNode root) {
		if (root == null)
			return 0;

		int ans = 0;
		if (root.left != null && root.left.left == null && root.left.right == null)
			ans += root.left.data;
		else
			ans += sumOfLeftLeaves(root.left);

		ans += sumOfLeftLeaves(root.right);
		return ans;
	}

	public boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null && q == null)
			return true;
		else if (p == null && q != null)
			return false;
		else if (p != null && q == null)
			return false;
		else {
			return p.data == q.data && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
		}
	}

	public static int sumOfLeftLeaves2(TreeNode root) {
		if (root == null)
			return 0;

		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		int ans = 0;

		while (!stack.empty()) {
			TreeNode node = stack.pop();
			if (node.left != null && node.left.left == null && node.left.right == null) {
				ans += node.left.data;
			} else {
				stack.push(node.left);
			}
			if (node.right != null && node.right.left != null && node.right.right != null)
				stack.push(root.right);
		}

		return ans;

	}

	public TreeNode invertTree1(TreeNode root) {
		if (root == null) {
			return null;
		}
		final Deque<TreeNode> stack = new LinkedList<>();
		stack.push(root);
		while (!stack.isEmpty()) {
			final TreeNode node = stack.pop();
			final TreeNode left = node.left;
			node.left = node.right;
			node.right = left;

			if (node.left != null)
				stack.push(node.left);

			if (node.right != null)
				stack.push(node.right);
		}
		return root;
	}

	// BFS
	public TreeNode invertTree2(TreeNode root) {
		if (root == null) {
			return null;
		}
		final Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			final TreeNode node = queue.poll();
			final TreeNode left = node.left;
			node.left = node.right;
			node.right = left;

			if (node.left != null)
				queue.offer(node.left);

			if (node.right != null)
				queue.offer(node.right);
		}
		return root;
	}

	// [1,2] ans is 2
	// leaf node has children null but itself is not null.
	public int minDepth(TreeNode root) {
		if (root == null)
			return 0;
		if (root.left == null)
			return 1 + minDepth(root.right);
		if (root.right == null)
			return 1 + minDepth(root.left);
		// return 1 + Math.min(minDepth(root.left), minDepth(root.right));

		int lDepth = minDepth(root.left);
		int rDepth = minDepth(root.right);
		if (lDepth < rDepth) {
			return 1 + lDepth;
		} else {
			return 1 + rDepth;
		}

		// because i was calculating again in return statement.
		// if (minDepth(root.left) < minDepth(root.right)) {
		// return 1 + minDepth(root.left);
		// } else {
		// return 1 + minDepth(root.right);
		// }
	}

	public List<Integer> levelOrder(TreeNode root, int level, List<Integer> list) {
		if (root == null)
			return list;

		if (level == 0) {
			list.add(root.data);
			return list;
		}

		int lvl = level - 1;
		levelOrder(root.left, lvl, list);
		levelOrder(root.right, lvl, list);
		return list;
	}

	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (root == null)
			return res;

		int depth = maxDepth(root);
		for (int i = 0; i < depth; i++) {
			List<Integer> level = new ArrayList<>();
			level = levelOrder(root, i, level);
			res.add(level);
		}
		return res;
	}

	public List<List<Integer>> levelOrder2(TreeNode root) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			List<Integer> level = new ArrayList<>();
			for (int i = 0; i < size; i++) {
				TreeNode node = queue.poll();
				if (node.left != null) {
					queue.offer(node.left);
				}
				if (node.right != null) {
					queue.offer(node.right);
				}
				level.add(node.data);
			}
			res.add(level);
		}
		return res;
	}

	public void levelOrder3Helper(TreeNode root, List<List<Integer>> res, int height) {
		if(root == null){
			return;
		}
		if(height == res.size()){
			res.add(new ArrayList<>());
		}
		res.get(height).add(root.data);
		int x = height+1;
		levelOrder3Helper(root.left, res, x);
		levelOrder3Helper(root.right, res, x);
	}

	public List<List<Integer>> levelOrder3(TreeNode root) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if(root == null)
			return res;
		levelOrder3Helper(root, res, 0);
		return res;
	}
	
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null)
        return root;
        
        if(p.data == root.data || q.data == root.data){
        	return root;
        }
        if(root.data < p.data && root.data < q.data){
            return lowestCommonAncestor(root.right, p, q);
        }else if(root.data > p.data && root.data > q.data){
            return lowestCommonAncestor(root.left, p, q);
        }else{
            return root;
        }
    }
	
	public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
		while(true){
			if(root.data > p.data && root.data > q.data){
				root = root.left;
			}else if(root.data < p.data && root.data < q.data){
				root = root.right;
			}else
				return root;
		}
//		return root;
	}
	
	// public List<String> binaryTreePaths(TreeNode root) {
	// List<String> res = new ArrayList<String>();
	// if (root == null)
	// return res;
	//
	// String path = "" + root.data;
	//// binaryTreePaths(root.left, path);
	// binaryTreePaths(root.right);
	// System.out.println(root.data);
	// }
	// public boolean isSymmetric(TreeNode root) {
	// if(root == null)
	// return true;
	// if(root.left == null || root.right == null)
	// }

	public static void main(String[] args) {
		LeetCodeTree tree = new LeetCodeTree();
		// TreeNode root = new TreeNode(1);
		// root.left = new TreeNode(2);
		// root.right = new TreeNode(3);
		// root.left.left = new TreeNode(4);
		// root.left.right = new TreeNode(5);

		// System.out.println("Max depth " + tree.maxDepth(root));

		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(25);
		System.out.println(sumOfLeftLeaves2(root));

		TreeNode minDep = new TreeNode(1);
		minDep.right = new TreeNode(-9);
		minDep.right.right = new TreeNode(8);
		minDep.right.right.left = new TreeNode(4);
		minDep.right.right.right = new TreeNode(-3);
		minDep.right.right.right.left = new TreeNode(-3);
		minDep.right.right.right.left.left = new TreeNode(-6);
		minDep.right.right.right.left.left.right = new TreeNode(-6);
		System.out.println("min depth : " + tree.minDepth(minDep));

		System.out.println("level order : " + tree.levelOrder3(root));
		
		System.out.println("Lowest common ancestor : "+ tree.lowestCommonAncestor2(root, root.right.left, root.right.right).data);

	}
}
