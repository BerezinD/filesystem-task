package com.interview.model;

import java.util.Set;

public interface Node {

  String getName();

  void setName(String name);

  void setParentAbsolutePath(String absolutePath);

  void add(Node node);

  // Nodes are stored in a Set, so the order of the children is not guaranteed
  Set<Node> getChildren();

  String getAbsolutePath();

}
