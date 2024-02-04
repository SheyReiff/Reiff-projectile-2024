package reiff.projectile;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProjectileTest {
    @Test
    public void getX() {
        //given
        Projectile projectile = new Projectile(31.00, 20.00);
        projectile.setSeconds(2.70);

        //when
        double actual = projectile.getX();

        //then

        Assertions.assertEquals(46.28, actual, 0.01);
    }

    @Test
    public void getY() {
        //given
        Projectile projectile = new Projectile(31.00, 20.00);
        projectile.setSeconds(2.70);

        //when
        double actual = projectile.getY();

        //then

        Assertions.assertEquals(-7.90, actual, 0.01);
    }

    @Test
    public void getApex() {
        //given
        Projectile projectile = new Projectile(31.00, 20.00);
        projectile.setSeconds(2.70);

        //when
        double actual = projectile.getApex();

        //then

        Assertions.assertEquals(1.051098, actual, 0.01);
    }
}
