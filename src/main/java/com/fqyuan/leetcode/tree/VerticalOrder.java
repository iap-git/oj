package com.fqyuan.leetcode.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author fqyuan
 *     <p>https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/
 */
public class VerticalOrder {
  private List<Location> locations;

  public List<List<Integer>> verticalTraversal(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();
    result.add(new ArrayList<>());
    if (root == null) {
      return result;
    }
    locations = new ArrayList<>();
    dfs(root, 0, 0);
    Collections.sort(locations);
    int prev = locations.get(0).x;
    for (Location location : locations) {
      if (prev != location.x) {
        prev = location.x;
        result.add(new ArrayList<>());
      }
      result.get(result.size() - 1).add(location.val);
    }
    return result;
  }

  private void dfs(TreeNode node, int x, int y) {
    if (node == null) {
      return;
    }
    locations.add(new Location(x, y, node.val));
    dfs(node.left, x - 1, y + 1);
    dfs(node.right, x + 1, y + 1);
  }

  class Location implements Comparable<Location> {
    private int x;
    private int y;
    private int val;

    public Location(int x, int y, int val) {
      this.x = x;
      this.y = y;
      this.val = val;
    }

    @Override
    public int compareTo(Location o) {
      if (this.x != o.x) {
        return this.x - o.x;
      } else if (this.y != o.y) {
        return this.y - o.y;
      } else {

        return this.val - o.val;
      }
    }
  }
}
