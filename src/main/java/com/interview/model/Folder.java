package com.interview.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Folder class represents a folder in the file system Folder supports add operations, has children
 * Folder has to have a name If a folder is created without a parent, it is considered as the root
 * directory Folder cannot have Nodes with the same name
 * <p>
 * To add files or folders to another directory, use the add method
 */
public class Folder extends FileSystemNode {

  private final Set<Node> children = new HashSet<>();

  /**
   * Creates a folder without a parent. Could be used as a root directory
   *
   * @param name name of the folder
   */
  public Folder(String name) {
    super(name);
  }

  @Override
  public void add(Node node) {
    if (children.contains(node)) {
      throw new IllegalArgumentException("Node already exists");
    }
    children.add(node);
    node.setParentAbsolutePath(getAbsolutePath());
  }

  @Override
  public Set<Node> getChildren() {
    return children;
  }

}
