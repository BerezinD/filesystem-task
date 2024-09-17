package com.interview.model;

import java.util.Set;

/**
 * File class represents a file in the file system File does not support add, has no children File
 * has to have a parent and a name
 */
public class File extends FileSystemNode {

  /**
   * Creates a file without a parent
   *
   * @param name name of the file
   */
  public File(String name) {
    super(name);
  }

  @Override
  public void add(Node node) {
    throw new UnsupportedOperationException("File does not support add operation");
  }

  @Override
  public Set<Node> getChildren() {
    throw new UnsupportedOperationException("File does not support getAllChildren operation");
  }

  @Override
  public int hashCode() {
    return super.hashCode();
  }

  @Override
  public boolean equals(Object obj) {
    return super.equals(obj);
  }
}
