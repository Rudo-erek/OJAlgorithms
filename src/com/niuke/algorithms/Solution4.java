package com.niuke.algorithms;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Solution4 {

     public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
     }

    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        // 根据先序遍历的顺序：根-左-右，先访问的肯定是根结点，后面访问的是根节点的子节点
        // 判断子节点是左左孩子还是右孩子，根据中序遍历顺序：左-根-右，如果在中序遍历中，子节点
        // 先于根节点，则子节点为左孩子
        // 然后递归判断右孩子，如果子节点在根节点的后面，则从根节点开始，递归判断子节点是哪个祖先的右节点
        if (pre == null || pre.length == 0) return null;
        TreeNode root = new TreeNode(pre[0]);
        TreeNode parent = root;
        TreeNode node, nextParent = root;
        for (int i = 1; i < pre.length; i++) {
            node = new TreeNode(pre[i]);
            nextParent = decidePosOfChildNode(in, parent, node, root);
            if (nextParent == null) return root;
            parent = node;
        }
        return root;
    }

    public TreeNode decidePosOfChildNode(int[] in, TreeNode parent, TreeNode node, TreeNode root) {
        if (in == null || in.length == 0) return root;
        for (int i = 0; i < in.length; i++) {
            if (node.val == in[i]) {
                parent.left = node;
                return root;
            }
            if (parent.val == in[i]) {
                //decidePosOfChildNode(in, node, root);
                if (i == in.length-1) parent.right = node;
                if (root.val == in[i+1]) {
                    parent.right = node;
                    return root;
                } else {
                    root.right = node;
                    return node;
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Solution4 solution4 = new Solution4();
        int[] pre = new int[] {1,2,3,4,5,6,7};
        int[] in = new int[] {3,2,4,1,6,5,7};
        TreeNode root = solution4.reConstructBinaryTree(pre, in);
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);
        TreeNode node;
        while (nodes.size() > 0) {
            node = nodes.poll();
            if (node == null) {
                System.out.println("null");
                continue;
            }
            else System.out.println(node.val);
            ((LinkedList<TreeNode>) nodes).add(node.left);
            nodes.add(node.right);
        }
    }

    /*
    public void decidePosOfChildNode(int[] in, TreeNode node, TreeNode root) {
        if (in == null || in.length == 0) return;
        for (int i = 0; i < in.length; i++) {
            if (node.val == in[i]) {
                decidePosOfChildNode(in, node, root.left);
                return;
            }
            if (root.val == in[i]) {
                root.right = node;
                return;
            }
        }
        return;
    }*/

}
