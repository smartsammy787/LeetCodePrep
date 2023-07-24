package binaryTree;



public class SumRootToLeafNumbers {

	int sum = 0;

	public int sumNumbers(TreeNode root) {
		helper(root, new StringBuilder());
		return sum;
	}

	void helper(TreeNode node, StringBuilder obj) {
		
		if (node != null) {
			obj.append(node.val);
		}
		if (node.left != null) {
			helper(node.left, obj);
		}
		if (node.right != null) {
			helper(node.right, obj);
		}
		if (node.left == null && node.right == null) {
			sum += Integer.parseInt(obj.toString());
		}
		obj.deleteCharAt(obj.length()-1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SumRootToLeafNumbers obj=new SumRootToLeafNumbers();
		TreeNode root=new TreeNode(4);
		root.left=new TreeNode(9);
		root.left.left=new TreeNode(5);
		root.right=new TreeNode(0);
		root.left.right=new TreeNode(1);
		obj.sumNumbers(root);
	}

}
