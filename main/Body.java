public class Body {
  public double xxPos;
  public double yyPos;
  public double xxVel;
  public double yyVel;
  public double mass;
  public String imgFileName = "jupiter.gif";

  public static double G = 6.67e-11;

  public Body(double xP, double yP, double xV, double yV, double m, String fname) {
    xxPos = xP;
    yyPos = yP;
    xxVel = xV;
    yyVel = yV;
    mass = m;
    imgFileName = fname;
  }

  public Body(Body b) {
    xxPos = b.xxPos;
    yyPos = b.yyPos;
    xxVel = b.xxVel;
    yyVel = b.yyVel;
    mass = b.mass;
    imgFileName = b.imgFileName;
  }

  public double calcDistance(Body b) {
    return Math.sqrt((xxPos-b.xxPos)*(xxPos-b.xxPos)+(yyPos-b.yyPos)*(yyPos-b.yyPos));
  }

  public boolean equals(Body b) {
    if (xxPos == b.xxPos && yyPos == b.yyPos && xxVel == b.xxVel && yyVel == b.yyVel
    && mass == b.mass && imgFileName == b.imgFileName) {
      return true;
    } else {
      return false;
    }
  }

  public double calcForceExertedBy(Body b) {
    if (this.equals(b)) {return 0.0;}
    double dist = this.calcDistance(b);
    return (G * mass * b.mass) / dist / dist;
  }

  public double calcForceExertedByX(Body b) {
    if (this.equals(b)) {return 0.0;}
    double dist = this.calcDistance(b);
    return (b.xxPos-xxPos) * G * mass * b.mass / Math.pow(dist,3);
  }

  public double calcForceExertedByY(Body b) {
    if (this.equals(b)) {return 0.0;}
    double dist = this.calcDistance(b);
    return (b.yyPos-yyPos) * G * mass * b.mass / Math.pow(dist,3);
  }

  public double calcNetForceExertedByX(Body[] bodys) {
    double force = 0.0;
    for (int i = 0; i < bodys.length; i++) {
      force += this.calcForceExertedByX(bodys[i]);
    }
    return force;
  }

  public double calcNetForceExertedByY(Body[] bodys) {
    double force = 0.0;
    for (int i = 0; i < bodys.length; i++) {
      force += this.calcForceExertedByY(bodys[i]);
    }
    return force;
  }

  public void update(double dt, double fx, double fy) {
    xxVel += dt * fx / mass;
    yyVel += dt * fy / mass;
    xxPos += dt * xxVel;
    yyPos += dt * yyVel;
    return;
  }

  public void draw() {
    StdDraw.picture(xxPos, yyPos, "./images/"+imgFileName);
    return;
  }

}
