package com.leetcode.primaryalgorithms.tree;

public class VerifyBinarySearchTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    //利用二叉树的中序遍历性质：左<中<右
    public static boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        return isValidChildTree(root, null, null);
    }

    public static boolean isValidChildTree(TreeNode node, Integer min, Integer max) {
        if (node == null) return true;
        if (node.val <= min || node.val >=max) return false;
        return isValidChildTree(node.left, min, node.val) && isValidChildTree(node.right, node.val, max);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(-2147483648);
        TreeNode left = new TreeNode(5);
        TreeNode right = new TreeNode(2147483647);
        TreeNode left1 = new TreeNode(6);
        TreeNode right2 = new TreeNode(20);
//        root.left = left;
//        root.right = right;
//        right.left = left1;
//        right.right = right2;
//        System.out.println(isValidBST(root));
        System.out.println(Integer.MIN_VALUE + " " + Integer.MAX_VALUE);
    }
}
