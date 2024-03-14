package reiff.projectile;

import javax.swing.*;
import java.awt.*;

public class ProjectileGraph extends JComponent {

    Projectile projectile = new Projectile(0, 0);

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.white);
        g.fillRect(0, 0, getWidth(), getHeight());

        g.translate(30, getHeight() - 30);

        g.setColor(Color.LIGHT_GRAY);
        int spacing = 30;
        int maxX = getWidth();
        int maxY = getHeight();

        for (int y = 0; y < maxY; y += spacing) {
            g.drawLine(-30, -y, maxX, -y);
        }

        for (int x = 0; x < maxX; x += spacing) {
            g.drawLine(x, 30, x, -maxY);
        }

        g.setColor(Color.BLACK);
        g.drawLine(-30, 0, getWidth(), 0);
        g.drawLine(0, 30, 0, -getHeight());

        double interval = 0.1;

        double prevX = 0;
        double prevY = 0;

        for (double time = 0; time <= projectile.getTotalTime(); time += interval) {
            double x = projectile.getX(time);
            double y = projectile.getY(time);

            g.drawLine((int) prevX, (int) -prevY, (int) x, (int) -y);

            prevX = x;
            prevY = y;
        }


        g.setColor(Color.BLUE);
        double x = projectile.getX(projectile.getTotalTime() / 2);
        double y = projectile.getPeakY();
        g.fillOval((int) x - 5, -(int) y - 5, 10, 10);

        double intX = projectile.getX(projectile.getTotalTime() / 2);
        double peakY = projectile.getPeakY();

        g.drawString("(" + String.format("%.2f", intX) + ", " + String.format("%.2f", peakY) + ")",
                (int) intX, (int) -peakY);

        g.setColor(Color.RED);
        double xaSeconds = projectile.getX();
        double yaSeconds = projectile.getY();
        g.fillOval((int) xaSeconds - 5, -(int) yaSeconds - 5, 10, 10);
        g.drawString("(" + String.format("%.2f", xaSeconds) + ", " + String.format("%.2f", yaSeconds) + ")",
                (int) xaSeconds, (int) -yaSeconds);

    }

    public void setProjectile(Projectile projectile) {
        this.projectile = projectile;
        repaint();
    }
}
