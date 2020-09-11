package com.townscript.marsproject;

import java.util.List;

public class PathFinder {

  public String getPath(List<Point> points, String startDirection) {
    String path = "";
    String strtDir = startDirection;
    for (int i = 0; i < points.size() - 1; i++) {
      Point start = points.get(i);
      Point end = points.get(i + 1);
      int xdis = end.x - start.x;
      int ydis = end.y - start.y;
      path = path.concat(getMoves(xdis, ydis, strtDir));
      strtDir = getNextDirection(xdis, ydis);
    }
    if (path.isEmpty()) {
      path = "NA";
    }
    return path;
  }

  private String getNextDirection(int xdis, int ydis) {
    if (xdis == 1 && ydis == 0) {
      return "E";
    } else if (xdis == -1 && ydis == 0) {
      return "W";
    } else if (xdis == 0 && ydis == 1) {
      return "S";
    } else if (xdis == 0 && ydis == -1) {
      return "N";
    }
    return "";
  }

  private String getMoves(int xdis, int ydis, String startDirection) {
    switch (startDirection) {
      case "E":
        return getMovesForStartDirEast(xdis, ydis);
      case "W":
        return getMovesForStartDirWest(xdis, ydis);
      case "N":
        return getMovesForStartDirNorth(xdis, ydis);
      case "S":
        return getMovesForStartDirSouth(xdis, ydis);
      default:
        return "";
    }
  }

  private String getMovesForStartDirEast(int xdis, int ydis) {
    if (xdis == 1 && ydis == 0)
      return "M";
    else if (xdis == -1 && ydis == 0)
      return "RRM";
    else if (xdis == 0 && ydis == 1)
      return "RM";
    else
      return "LM";
  }

  private String getMovesForStartDirWest(int xdis, int ydis) {
    if (xdis == 1 && ydis == 0)
      return "RRM";
    else if (xdis == -1 && ydis == 0)
      return "M";
    else if (xdis == 0 && ydis == 1)
      return "LM";
    else
      return "RM";
  }

  private String getMovesForStartDirNorth(int xdis, int ydis) {
    if (xdis == 1 && ydis == 0)
      return "RM";
    else if (xdis == -1 && ydis == 0)
      return "LM";
    else if (xdis == 0 && ydis == 1)
      return "LLM";
    else
      return "M";
  }

  private String getMovesForStartDirSouth(int xdis, int ydis) {
    if (xdis == 1 && ydis == 0)
      return "LM";
    else if (xdis == -1 && ydis == 0)
      return "RM";
    else if (xdis == 0 && ydis == 1)
      return "M";
    else
      return "LLM";
  }


}
