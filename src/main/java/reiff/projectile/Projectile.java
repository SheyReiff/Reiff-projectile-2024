package reiff.projectile;

import static java.lang.Math.cos;
import static java.lang.Math.sin;

public class Projectile {
    private final double radians;
    private final double velocity;
    private double seconds;

    public Projectile(double angle, double velocity) {
        this.velocity = velocity;
        this.radians = Math.toRadians(angle);
    }

    public void setSeconds(double seconds) {
        this.seconds = seconds;
    }

    public double getX() {
        return cos(radians) * velocity * seconds;
    }

    public double getX(double time) {
        return velocity * Math.cos(radians) * time;
    }

    public double getY() {
        return sin(radians) * velocity * seconds - ((0.5) * 9.8 * (seconds * seconds));
    }

    public double getY(double time) {
        return velocity * Math.sin(radians) * time - 0.5 * 9.8 * time * time;
    }

    public double getApex() {
        return (velocity * Math.sin(radians)) / 9.8;
    }

    public double getPeakY() {
        return (sin(radians) * (velocity)) * (sin(radians) * (velocity))  / (2 * 9.8); //ChatGPT
    }

    public double getInterceptX() {
        double timeToGround = (2 * velocity * Math.sin(radians)) / 9.8;
        return Math.cos(radians) * velocity * timeToGround;
    }

    public double getTotalTime() {
        return getApex() * 2;
    }
}

