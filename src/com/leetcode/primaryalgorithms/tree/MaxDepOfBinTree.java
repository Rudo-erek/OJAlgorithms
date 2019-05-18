package com.leetcode.primaryalgorithms.tree;

import java.util.Stack;

/**
 * 二叉树的最大深度
 */

public class MaxDepOfBinTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int depth = 1;
        class TEntry {
            TreeNode node;
            int depth;
            TEntry(TreeNode node, int depth) {
                this.node = node;
                this.depth = depth;
            }
        }
        Stack<TEntry> stack = new Stack<>();
        stack.push(new TEntry(root, 1));
        while (stack.size() !=0 ) {
            TEntry entry = stack.pop();
            TreeNode node = entry.node;
            depth = depth > entry.depth ? depth : entry.depth;
            if (node.left != null) stack.push(new TEntry(node.left, entry.depth+1));
            if (node.right != null) stack.push(new TEntry(node.right, entry.depth+1));
        }
        return depth;
    }

    // better implementation

    /*
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
        }
    }
    */
}
