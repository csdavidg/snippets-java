package com.example.snippets.algorithms;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class RevertTreeNode {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return root;

        TreeNode temporal = root.left;
        root.left = root.right;
        root.right = temporal;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
}
