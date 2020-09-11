package com.townscript.marsproject;

import java.util.Scanner;
import static com.townscript.marsproject.Point.*;

/**
 * Hello world!
 *
 */
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
    System.out.println("Russiona position is " + ruStart + " intial dir is " + ruInitialDirection);
    in.close();
  }
}
