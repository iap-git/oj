package com.fqyuan.leetcode.dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CloneTree {
    private Map<Integer, Node> map = new HashMap<>();
    public Node cloneGraph(Node node) {
        return clone(node);
    }
    private Node clone(Node node){
        if(node == null){
            return null;
        }
        if(map.containsKey(node.val)){
            return map.get(node.val);
        }
        Node tmp = new Node(node.val, new ArrayList<Node>());
        map.put(tmp.val, tmp);
        for(Node item: node.neighbors){
            item.neighbors.add(clone(item));
        }
        return tmp;
    }
}

 class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}