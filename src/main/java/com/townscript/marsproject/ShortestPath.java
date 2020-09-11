package com.townscript.marsproject;

import java.util.List;

public class ShortestPath {

  int distance;
  List<Point> route;

  public ShortestPath(int distance, List<Point> route) {
    this.distance = distance;
    this.route = route;
  }

  public int getDistance() {
    return distance;
  }

  public void setDistance(int distance) {
    this.distance = distance;
  }

  public List<Point> getRoute() {
    return route;
  }

  public void setRoute(List<Point> route) {
    this.route = route;
  }
}
