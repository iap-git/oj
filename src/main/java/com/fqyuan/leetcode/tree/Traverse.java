package com.fqyuan.leetcode.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author fqyuan
 */
public class Traverse {
    public void preOrder(TreeNode root, List<Integer> list){
        if(root == null){
            return;
        }
        list.add(root.val);
        preOrder(root.left, list);
        preOrder(root.right, list);

    }

    public List<Integer> iterPreOrder(TreeNode root){
        List<Integer> result = new ArrayList<>();
        Deque<Node> stack = new ArrayDeque<>();
        stack.push(new Node(false, root));
        while(!stack.isEmpty()){
            Node node = stack.pop();
            if(node.treeNode == null){
                continue;
            }
            if(!node.isVisited){
                stack.push(new Node( false, node.treeNode.right));
                stack.push(new Node( false, node.treeNode.left));
                stack.push(new Node( true, node.treeNode));
            }else{
                result.add(node.treeNode.val);
            }
        }
        return result;
    }
    class Node{
        boolean isVisited;
        TreeNode treeNode;
        public Node(boolean isVisited, TreeNode node){
            this.isVisited = isVisited;
            treeNode = node;
        }
    }
}
