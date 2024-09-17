package com.interview.utils;

import java.util.List;

import com.interview.model.File;
import com.interview.model.Folder;
import com.interview.model.Node;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FileUtilsTest {

  private final Node root = getFolderStructure();

  @Test
  void findNodeByNameRecursively() {
    List<Node> actual = FileUtils.findNodeByNameRecursively(root, "file99");
    String[] splitPath = actual.getFirst().getAbsolutePath().split("/");

    assertEquals(100000, actual.size());
    assertEquals(4, splitPath.length);
    assertEquals("root", splitPath[0]);
    assertEquals("file99", splitPath[3]);
  }

  @Test
  void findNodeByName() {
    List<Node> actual = FileUtils.findNodeByName(root, "file99");
    String[] splitPath = actual.getFirst().getAbsolutePath().split("/");

    assertEquals(100000, actual.size());
    assertEquals(4, splitPath.length);
    assertEquals("root", splitPath[0]);
    assertEquals("file99", splitPath[3]);
  }

  private Node getFolderStructure() {
    Node rootFolder = new Folder("root");
    for (int i = 0; i < 1000; i++) {
      Node folder = new Folder("folder" + i);
      rootFolder.add(folder);
      for (int j = 0; j < 100; j++) {
        Node nextFolder = new Folder("folder" + j);
        folder.add(nextFolder);
        for (int k = 0; k < 100; k++) {
          nextFolder.add(new File("file" + k));
        }
      }
    }
    return rootFolder;
  }
}
