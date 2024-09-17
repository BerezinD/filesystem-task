package com.interview.model;

import java.util.Objects;

public abstract class FileSystemNode implements Node {

  private String name;
  private String parentAbsolutePath;

  FileSystemNode(String name) {
    this.name = name;
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
  public void setParentAbsolutePath(String parentAbsolutePath) {
    this.parentAbsolutePath = parentAbsolutePath;
  }

  /**
   * @return absolute path of the folder
   */
  @Override
  public String getAbsolutePath() {
    if (parentAbsolutePath == null) {
      return name;
    }
    return parentAbsolutePath + "/" + name;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof FileSystemNode that)) {
      return false;
    }
    return Objects.equals(name, that.name) && Objects.equals(parentAbsolutePath,
        that.parentAbsolutePath);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, parentAbsolutePath);
  }
}
