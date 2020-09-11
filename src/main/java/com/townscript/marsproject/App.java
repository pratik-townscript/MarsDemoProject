package com.townscript.marsproject;

import static com.townscript.marsproject.Point.P;
import java.util.Scanner;


public class App {

  PathFinder pf = new PathFinder();
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
    ShortestPath ruShortestPath = matrix.shortestPath(ruStart, destination);

    if (usShortestPath == null) {
      printUnreachableDesOutput();
    } else {
      printOutput(usShortestPath, usInitialDirection);
    }

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
    Matrix.convertToCoordinateSystem(shortestPath.getRoute());
    System.out.println(pf.getPath(shortestPath.getRoute(), initialDirection));
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
    if (m <= 0 || n <= 0 || p < 0) {
      in.close();
      throw new IllegalArgumentException("Invalid Input values provided");
    }
    this.matrix = new Matrix(m, n);
    for (int i = 0; i < p; i++) {
      int y = in.nextInt();
      int x = in.nextInt();
      this.matrix.dead(x, y);
    }
    int destY = in.nextInt();
    int destX = in.nextInt();
    destination = P(destX, destY);

    int usStartY = in.nextInt();
    int usStartX = in.nextInt();
    usStart = P(usStartX, usStartY);
    usInitialDirection = in.next();

    int ruStartY = in.nextInt();
    int ruStartX = in.nextInt();
    ruStart = P(ruStartX, ruStartY);
    ruInitialDirection = in.next();
    in.close();
  }



}
