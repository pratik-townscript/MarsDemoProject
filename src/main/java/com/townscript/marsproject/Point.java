package com.townscript.marsproject;

import java.util.ArrayList;
import java.util.List;

public class Point {
  int x;
  int y;

  public static final Point[] NEIGHBORS = new Point[4];

  static {
    NEIGHBORS[0] = P(-1, 0);
    NEIGHBORS[1] = P(0, -1);
    NEIGHBORS[2] = P(0, 1);
    NEIGHBORS[3] = P(1, 0);
  }

  public Point(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public static Point P(int x, int y) {
    return new Point(x, y);
  }

  public Point getNegibour(Point neighbourPoint) {
    Point neig = P(this.x + neighbourPoint.x, this.y + neighbourPoint.y);
    return neig;
  }

  @Override
  public String toString() {
    return "P [x=" + x + ", y=" + y + "]";
  }
}
