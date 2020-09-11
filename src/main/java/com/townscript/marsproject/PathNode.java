package com.townscript.marsproject;

import java.util.List;

public class PathNode {
  Point currentpoint;
  int distFromSrc;
  List<Point> pathPoints;

  public PathNode(Point currentpoint, int distFromSrc, List<Point> pathPoints) {
    this.currentpoint = currentpoint;
    this.distFromSrc = distFromSrc;
    this.pathPoints = pathPoints;
  }

  public static PathNode PN(Point currentpoint, int distFromSrc, List<Point> pathPoints) {
    return new PathNode(currentpoint, distFromSrc, pathPoints);
  }

  public Point getCurrentpoint() {
    return currentpoint;
  }

  public void setCurrentpoint(Point currentpoint) {
    this.currentpoint = currentpoint;
  }

  public int getDistFromSrc() {
    return distFromSrc;
  }

  public void setDistFromSrc(int distFromSrc) {
    this.distFromSrc = distFromSrc;
  }

  public List<Point> getPathPoints() {
    return pathPoints;
  }

  public void setPathPoints(List<Point> pathPoints) {
    this.pathPoints = pathPoints;
  }

  @Override
  public String toString() {
    return "PN [currentpoint=" + currentpoint + ", distFromSrc=" + distFromSrc + ", pathPoints="
        + pathPoints + "]";
  }
}
