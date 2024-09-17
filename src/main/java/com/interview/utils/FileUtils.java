package com.interview.utils;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import com.interview.model.Folder;
import com.interview.model.Node;

public class FileUtils {

  private FileUtils() {
    throw new IllegalStateException("Utility class");
  }

  public static List<Node> findNodeByNameRecursively(Node node, String name) {
    List<Node> result = new ArrayList<>();
    if (node.getName().equals(name)) {
      result.add(node);
    }
    if (node instanceof Folder) {
      for (Node child : node.getChildren()) {
        // possible stack overflow
        result.addAll(findNodeByNameRecursively(child, name));
      }
    }
    return result;
  }

  public static List<Node> findNodeByName(Node node, String name) {
    List<Node> result = new ArrayList<>();
    Deque<Node> stack = new LinkedList<>(node.getChildren());

    while (!stack.isEmpty()) {
      Node current = stack.pop();
      if (current.getName().equals(name)) {
        result.add(current);
      }
      if (current instanceof Folder) {
        stack.addAll(current.getChildren());
      }
    }

    return result;
  }
}
