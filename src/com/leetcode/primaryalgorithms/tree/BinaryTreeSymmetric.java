package com.leetcode.primaryalgorithms.tree;

import java.util.*;

public class BinaryTreeSymmetric {
    public class TreeNode {
        TreeNode(int val) {
            this.val = val;
        }
        int val;
        TreeNode left;
        TreeNode right;
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        List<TreeNode> nodeList = new ArrayList<>();
        nodeList.add(root);
        return isLayerSymmetric(nodeList);
    }

    public boolean isLayerSymmetric(List<TreeNode> nodeList) {
        if (nodeList == null || nodeList.size() == 0) return true;
        int len = nodeList.size();
        for (int i = 0; i < len/2; i++) {
            if (nodeList.get(i).val == nodeList.get(len - 1 - i).val ) {
                if (nodeList.get(i).left == null || nodeList.get(len - i -1).right == null) {
                    if (nodeList.get(i).left != nodeList.get(len - i - 1).right) return false;
                }
                if (nodeList.get(i).right == null || nodeList.get(len - i - 1).left== null) {
                    if (nodeList.get(i).right != nodeList.get(len - i -1).left) return false;
                }
                continue;
            }
            else return false;
        }

        List<TreeNode> childNodes = new ArrayList<>();
        for (TreeNode node : nodeList) {
            if (node.left != null) childNodes.add(node.left);
            if (node.right != null) childNodes.add(node.right);
        }
        if (childNodes.size() % 2 == 1) return false;
        return isLayerSymmetric(childNodes);
    }

    public static void main(String[] args) {
        BinaryTreeSymmetric binaryTreeSymmetric = new BinaryTreeSymmetric();
        TreeNode root = binaryTreeSymmetric.new TreeNode(1);
        TreeNode root1 = binaryTreeSymmetric.new TreeNode(2);
        TreeNode root2 = binaryTreeSymmetric.new TreeNode(2);
        TreeNode root3 = binaryTreeSymmetric.new TreeNode(3);
        TreeNode root4 = binaryTreeSymmetric.new TreeNode(4);

        root.left = root1;
        root.right = root2;
        root1.right = root3;
        root2.left = root4;
        System.out.println(binaryTreeSymmetric.isSymmetric(root));
    }
}
