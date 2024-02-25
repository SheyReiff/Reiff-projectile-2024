package reiff.projectile;

import javax.swing.*;
import java.awt.*;

public class ProjectileGraph extends JComponent {

    Projectile projectile = new Projectile(0, 0);

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.translate(0, getHeight());
        g.setColor(Color.BLACK);

        double interval = 0.1;

        double time = 0;
        double prevX = 0;
        double prevY = 0;

        while (time <= projectile.getTotalTime()) {
            double x = projectile.getX(time);
            double y = projectile.getY(time);

            g.drawLine((int) prevX, (int) -prevY, (int) x, (int) -y);

            prevX = x;
            prevY = y;

            time += interval;
        }

        g.setColor(Color.BLUE);
        double x = projectile.getX(projectile.getTotalTime() / 2);
        double y = projectile.getPeakY();
        g.fillOval((int) x, -(int) y, 10, 10);


        double intX = projectile.getX(projectile.getTotalTime() / 2);
        double peakY = projectile.getPeakY();

        g.drawString("(" + String.format("%.2f", intX) + ", " + String.format("%.2f", peakY) + ")",
                (int) intX, (int) -peakY);

    }

    public void setProjectile(Projectile projectile) {
        this.projectile = projectile;
        repaint();
    }
}
