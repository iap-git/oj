package com.fqyuan.leetcode.trie;

public class Trie {

  private TrieNode root;
  /** Initialize your data structure here. */
  public Trie() {
    root = new TrieNode();
  }

  /** Inserts a word into the trie. */
  public void insert(String word) {
    TrieNode node = root;
    for (Character ch : word.toCharArray()) {
      if (node.next[ch - 'a'] == null) {
        node.next[ch - 'a'] = new TrieNode();
      }
      node = node.next[ch - 'a'];
    }
    node.isEnd = true;
  }

  /** Returns if the word is in the trie. */
  public boolean search(String word) {
    TrieNode node = root;
    for(Character ch: word.toCharArray()){
      if(node.next[ch -'a'] == null){
        return false;
      }
      node = node.next[ch -'a'];
    }
    return node.isEnd;

  }

  /** Returns if there is any word in the trie that starts with the given prefix. */
  public boolean startsWith(String prefix) {
    TrieNode node = root;
    for(Character ch: prefix.toCharArray()){
      if(node.next[ch -'a'] == null){
        return false;
      }
      node = node.next[ch -'a'];
    }
    return true;
  }

  class TrieNode {
    boolean isEnd;
    TrieNode[] next;

    public TrieNode() {
      next = new TrieNode[26];
      isEnd = false;
    }
  }
}
