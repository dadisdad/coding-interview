package com.dadisdad.coding;

import com.dadisdad.coding.pub.BinaryTreeNode;

/**
 * 二叉树的下一个节点
 *
 * @author 10308
 * @date 2020/3/8
 */
public class NextNodeInBinaryTrees {

    public static void main(String[] args) {
        BinaryTreeNode a = new BinaryTreeNode("a");
        BinaryTreeNode b = new BinaryTreeNode("b");
        BinaryTreeNode c = new BinaryTreeNode("c");
        BinaryTreeNode d = new BinaryTreeNode("d");
        BinaryTreeNode e = new BinaryTreeNode("e");
        BinaryTreeNode f = new BinaryTreeNode("f");
        BinaryTreeNode g = new BinaryTreeNode("g");
        BinaryTreeNode h = new BinaryTreeNode("h");
        BinaryTreeNode i = new BinaryTreeNode("i");

        a.left = b;
        a.right = c;

        b.parent = a;
        b.left = d;
        b.right = e;

        c.parent = a;
        c.left = f;
        c.right = g;

        d.parent = b;

        e.parent = b;
        e.left = h;
        e.right = i;

        f.parent = c;

        g.parent = c;

        h.parent = e;

        i.parent = e;

        // 中序遍历 {d,b,h,e,i,a,f,c,g}

        // g
        System.out.println(nextNodeInBinaryTrees(c).val);
        // a
        System.out.println(nextNodeInBinaryTrees(i).val);
        // b
        System.out.println(nextNodeInBinaryTrees(d).val);
    }

    public static BinaryTreeNode nextNodeInBinaryTrees(BinaryTreeNode node) {
        if (node == null) {
            return null;
        }
        // 有右子树，右子树最左节点为下一个节点
        if (node.right != null) {
            node = node.right;
            while (node.left!=null) {
                node = node.left;
            }
            return node;
        }
        // 没有右子树
        if (node.parent!=null) {
            BinaryTreeNode cur = node;
            BinaryTreeNode parent = node.parent;
            while (parent!=null && cur==parent.right){
                // 如果当前节点是父节点的右子节点 则该结点的父结点的父结点的父结点，直到其中的一个父结点是这个父结点的左孩子，则该父结点的父结点为下一个结点。
                cur = parent;
                parent = parent.parent;
            }
            // 如果当前节点是父节点的左子节点，下一个节点就是父节点
            return parent;
        }
        return null;
    }
}
