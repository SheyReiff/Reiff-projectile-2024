package reiff.projectile;

public class Main {
    public static void main(String[] args)
    {
        Projectile projectile1 = new Projectile(31.00, 20.00, 2.70);
        System.out.println(projectile1.getApex());
        System.out.println(projectile1.getX());
        System.out.println(projectile1.getY());
    }
}
