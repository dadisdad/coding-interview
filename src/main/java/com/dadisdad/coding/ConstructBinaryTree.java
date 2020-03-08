package com.dadisdad.coding;

import com.dadisdad.coding.pub.TreeNode;

/**
 * 重建二叉树
 *
 * @author 10308
 * @date 2020/3/8
 */
public class ConstructBinaryTree {

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        return buildTree(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        int rootIndex = 0;
        // 根节点
        TreeNode res = new TreeNode(preorder[preStart]);
        for (int i = inStart; i <= inEnd; i++) {
            // 找到中序遍历中根节点的位置
            if (preorder[preStart] == inorder[i]) {
                rootIndex = i;
                break;
            }
        }
        res.left = buildTree(preorder, inorder, preStart + 1, preStart + rootIndex - inStart, inStart, rootIndex - 1);
        res.right = buildTree(preorder, inorder, preStart + rootIndex - inStart + 1, preEnd, rootIndex + 1, inEnd);
        return res;
    }

}
