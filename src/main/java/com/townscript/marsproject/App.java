package com.townscript.marsproject;

import static com.townscript.marsproject.Point.P;
import java.util.List;
import java.util.Scanner;


public class App {

  Matrix matrix;
  Point destination;
  Point usStart;
  String usInitialDirection;
  Point ruStart;
  String ruInitialDirection;

  public static void main(String[] args) {
    App app = new App();
    app.processInput();
    app.provideResult();
  }

  private void provideResult() {
    ShortestPath usShortestPath = matrix.shortestPath(usStart, destination);

    if (usShortestPath == null) {
      printUnreachableDesOutput();
    } else {
      printOutput(usShortestPath, usInitialDirection);
    }

    ShortestPath ruShortestPath = matrix.shortestPath(ruStart, destination);

    if (ruShortestPath == null) {
      printUnreachableDesOutput();
    } else {
      printOutput(ruShortestPath, ruInitialDirection);
    }

    printWinner(usShortestPath, ruShortestPath);

  }

  private void printUnreachableDesOutput() {
    System.out.println(-1);
    System.out.println("NA");
  }

  private void printOutput(ShortestPath shortestPath, String initialDirection) {
    System.out.println(shortestPath.distance);
    System.out.println(this.getPath(shortestPath.getRoute(), initialDirection));
  }

  private void printWinner(ShortestPath usShortestPath, ShortestPath ruShortestPath) {

    try {
      if (usShortestPath.distance == ruShortestPath.distance) {
        System.out.println("TIE");
      } else if (usShortestPath.distance > ruShortestPath.distance) {
        System.out.println("RUSSIA");
      } else {
        System.out.println("US");
      }
    } catch (NullPointerException e) {
      if (usShortestPath == null && ruShortestPath != null) {
        System.out.println("RUSSIA");
      } else if (usShortestPath != null && ruShortestPath == null) {
        System.out.println("US");
      } else {
        System.out.println("TIE");
      }
    }
  }

  private void processInput() {
    Scanner in = new Scanner(System.in);
    int m = in.nextInt();
    int n = in.nextInt();
    int p = in.nextInt();
    System.out.println("m " + m + " n " + n + " p " + p);
    if (m <= 0 || n <= 0 || p < 0) {
      in.close();
      throw new IllegalArgumentException("Invalid Input values provided");
    }
    this.matrix = new Matrix(m, n);
    for (int i = 0; i < p; i++) {
      int x = in.nextInt();
      int y = in.nextInt();
      this.matrix.dead(x, y);
    }
    int destX = in.nextInt();
    int destY = in.nextInt();
    destination = P(destX, destY);
    System.out.println("destination " + destination);

    int usStartX = in.nextInt();
    int usStartY = in.nextInt();
    usStart = P(usStartX, usStartY);
    usInitialDirection = in.next();
    System.out.println("Us position is " + usStart + " intial direction is " + usInitialDirection);

    int ruStartX = in.nextInt();
    int ruStartY = in.nextInt();
    ruStart = P(ruStartX, ruStartY);
    ruInitialDirection = in.next();
    System.out.println("Russio position is " + ruStart + " intial dir is " + ruInitialDirection);
    in.close();
  }


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
