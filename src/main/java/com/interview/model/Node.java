package com.interview.model;

import java.util.List;

public interface Node {

  String getName();

  void setName(String name);

  void setParent(Node parent);

  void add(Node node);

  List<Node> getChildren();

  String getAbsolutePath();

}
