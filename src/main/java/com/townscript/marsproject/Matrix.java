package com.townscript.marsproject;

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

  public ShortestPath shortestPath(Point source, Point destination) {
    return null;
  }
}
