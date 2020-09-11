package com.townscript.marsproject;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Matrix {

  int xMax;
  int yMax;
  int[][] grid;

  public Matrix(int xMax, int yMax) {
    this.xMax = xMax;
    this.yMax = yMax;
    this.grid = new int[xMax][yMax];
  }

  public int getxMax() {
    return xMax;
  }

  public void setxMax(int xMax) {
    this.xMax = xMax;
  }

  public int getyMax() {
    return yMax;
  }

  public void setyMax(int yMax) {
    this.yMax = yMax;
  }

  public int[][] getGrid() {
    return grid;
  }

  public void setGrid(int[][] grid) {
    this.grid = grid;
  }

  public void dead(int x, int y) {
    grid[x][y] = -1;
  }

  public boolean isValid(Point p) {
    return (p.x >= 0) && (p.x < this.xMax) && (p.y >= 0) && (p.y < this.yMax);
  }


  public ShortestPath shortestPath(Point src, Point dest) {
    if (grid[src.x][src.y] == -1 || grid[dest.x][dest.y] == -1) {
      return null;
    }
    boolean[][] visited = new boolean[xMax][yMax];
    visited[src.x][src.y] = true;

    Queue<PathNode> queue = new LinkedList<PathNode>();
    PathNode srcNode = new PathNode(src, 0, new ArrayList<Point>());
    queue.add(srcNode);

    while (!queue.isEmpty()) {
      PathNode currNode = queue.peek();
      Point pt = currNode.getCurrentpoint();
      currNode.getPathPoints().add(pt);

      if (pt.x == dest.x && pt.y == dest.y) {
        return new ShortestPath(currNode.getDistFromSrc(), currNode.getPathPoints());
      }
      queue.remove();
      for (int i = 0; i < Point.NEIGHBORS.length; i++) {
        Point neighbor = pt.getNegibour(Point.NEIGHBORS[i]);

        if (isValid(neighbor) && grid[neighbor.x][neighbor.y] != -1
            && !visited[neighbor.x][neighbor.y]) {
          visited[neighbor.x][neighbor.y] = true;
          List<Point> routes = new ArrayList<Point>();
          routes.addAll(currNode.getPathPoints());

          PathNode adjNode = new PathNode(neighbor, currNode.getDistFromSrc() + 1, routes);
          queue.add(adjNode);
        }
      }
      currNode.setPathPoints(new ArrayList<Point>());
    }
    return null;
  }
}
