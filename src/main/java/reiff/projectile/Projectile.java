package reiff.projectile;//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or

import static java.lang.Math.cos;
import static java.lang.Math.sin;

// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Projectile {

    private double angle;
    private double radians;
    private double velocity;
    private double seconds;
    private double apexTime;

    public Projectile(double angle, double velocity, double seconds) {
        this.angle = angle;
        this.velocity = velocity;
        this.seconds = seconds;
        this.radians = Math.toRadians(angle);
    }

    public double getX() {
        return cos(radians) * velocity * seconds;
    }

    public double getY() {
        return sin(radians) * velocity * seconds - ((0.5) * 9.8 * (seconds * seconds));
    }

    //projectile at its highest

    public double getApex() {
        double v = velocity * Math.sin(radians);
        return v / 9.8;
    }
}

