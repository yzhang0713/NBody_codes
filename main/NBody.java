public class NBody {
  public static double readRadius(String planetFile) {
    In in = new In(planetFile);
    int numPlanet = in.readInt();
    double radius = in.readDouble();
    return radius;
  }

  public static Body[] readBodies(String planetFile) {
    In in = new In(planetFile);
    int numPlanet = in.readInt();
    double radius = in.readDouble();
    Body[] bodies = new Body[numPlanet];
    for (int i = 0; i < numPlanet; i++) {
      bodies[i] = new Body(in.readDouble(), in.readDouble(), in.readDouble(),
          in.readDouble(), in.readDouble(), in.readString());
    }
    return bodies;
  }

  public static void main(String[] args) {
    double T = Double.parseDouble(args[0]);
    double dt = Double.parseDouble(args[1]);
    double t = 0.0;
    String filename = args[2];
    double radius = readRadius(filename);
    Body[] bodies = readBodies(filename);
    int numPlanet = bodies.length;
    String backImg = "./images/starfield.jpg";
    StdDraw.enableDoubleBuffering();
    StdDraw.setScale(-radius, radius);
    double[] xForce = new double[numPlanet];
    double[] yForce = new double[numPlanet];
    while (t <= T) {
      for (int i = 0; i < numPlanet; i++) {
        xForce[i] = bodies[i].calcNetForceExertedByX(bodies);
        yForce[i] = bodies[i].calcNetForceExertedByY(bodies);
      }
      for (int i = 0; i < numPlanet; i++) {
        bodies[i].update(dt, xForce[i], yForce[i]);
      }
      StdDraw.clear();
      StdDraw.picture(0, 0, backImg);
      for (int i = 0; i < bodies.length; i++) {
        bodies[i].draw();
      }
      StdDraw.show();
      StdDraw.pause(10);
      t += dt;
    }
  }
}
