public class TestBody {

  public static void main(String[] args) {
    Body sun = new Body(1.0e12, 2.0e11, 0, 0, 2.0e30, "fname1");
    Body saturn = new Body(2.0e12, 9.5e11, 0, 0, 6.0e26, "fname2");
    checkBody(sun, saturn);
    return;
  }

  public static void checkBody(Body b1, Body b2) {
    double dist = b1.calcDistance(b2);
    double fx21 = b1.calcForceExertedByX(b2);
    double fx12 = b2.calcForceExertedByX(b1);
    double fy21 = b1.calcForceExertedByY(b2);
    double fy12 = b2.calcForceExertedByY(b1);
    System.out.println("The distance is " + dist);
    System.out.println("The force fx21 is " + fx21);
    System.out.println("The force fx12 is " + fx12);
    System.out.println("The force fy21 is " + fy21);
    System.out.println("The force fy12 is " + fy12);
    return;
  }


}
