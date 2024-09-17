package com.interview.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Folder class represents a folder in the file system Folder supports add operations, has children
 * Folder has to have a name If a folder is created without a parent, it is considered as the root
 * directory Folder cannot have Nodes with the same name
 */
public class Folder implements Node {

  private String name;
  private Node parent;
  private final List<Node> children = new ArrayList<>();

  /**
   * Using this constructor to create the root directory
   *
   * @param name name of the folder
   */
  public Folder(String name) {
    this.name = name;
  }

  public Folder(String name, Node parent) {
    this.name = name;
    this.parent = parent;
    this.parent.add(this);
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
    if (children.contains(node)) {
      throw new IllegalArgumentException("Node already exists");
    }
    children.add(node);
    node.setParent(this);
  }

  @Override
  public List<Node> getChildren() {
    return children;
  }

  /**
   * For deep structures this method will be slow Instead, the absolute path could be stored as
   * different String field and updated on each add operation. This will eliminate the need to
   * traverse the tree each time and store the Parent reference.
   *
   * @return absolute path of the folder
   */
  @Override
  public String getAbsolutePath() {
    if (parent == null) {
      return name;
    }
    return parent.getAbsolutePath() + "/" + name;
  }

}
