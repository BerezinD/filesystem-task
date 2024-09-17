package com.interview.model;

import java.util.List;

/**
 * File class represents a file in the file system File does not support add, has no children File
 * has to have a parent and a name
 */
public class File implements Node {

  private String name;
  private Node parent;

  public File(String name, Node parent) {
    this.name = name;
    this.parent = parent;
    parent.add(this);
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public void setName(String name) {
    this.name = name;
  }

  @Override
  public void setParent(Node parent) {
    this.parent = parent;
  }

  @Override
  public void add(Node node) {
    throw new UnsupportedOperationException("File does not support add operation");
  }

  @Override
  public List<Node> getChildren() {
    throw new UnsupportedOperationException("File does not support getAllChildren operation");
  }

  @Override
  public String getAbsolutePath() {
    return parent.getAbsolutePath() + "/" + name;
  }

}
