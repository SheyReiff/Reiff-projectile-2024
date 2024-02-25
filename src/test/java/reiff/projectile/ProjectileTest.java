package reiff.projectile;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProjectileTest {
    @Test
    public void getX() {
        //given
        Projectile projectile = new Projectile(31.00, 65.00);
        projectile.setSeconds(2.70);

        //when
        double actual = projectile.getX();

        //then

        Assertions.assertEquals(150.43, actual, 0.01);
    }

    @Test
    public void getY() {
        //given
        Projectile projectile = new Projectile(31, 65);
        projectile.setSeconds(2.70);

        //when
        double actual = projectile.getY();

        //then

        Assertions.assertEquals(54.66, actual, 0.01);
    }

    @Test
    public void getApex() {
        //given
        Projectile projectile = new Projectile(31, 65);
        projectile.setSeconds(2.70);

        //when
        double actual = projectile.getApex();

        //then

        Assertions.assertEquals(3.41, actual, 0.01);
    }

    @Test
    public void getPeakY() {
        //given
        Projectile projectile = new Projectile(31, 65);
        projectile.setSeconds(2.70);

        //when
        double actual = projectile.getPeakY();

        //then

        Assertions.assertEquals(57.18, actual, 0.01);
    }

    @Test
    public void getInterceptX() {
        //given
        Projectile projectile = new Projectile(31, 65);
        projectile.setSeconds(2.70);

        //when
        double actual = projectile.getInterceptX();

        //then

        Assertions.assertEquals(380.65, actual, 0.01);
    }

    @Test
    public void getTotalTime() {
        //given
        Projectile projectile = new Projectile(31, 65);
        projectile.setSeconds(2.70);

        //when
        double actual = projectile.getTotalTime();

        //then

        Assertions.assertEquals(6.83, actual, 0.01);

    }
}
