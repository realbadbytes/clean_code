/* use white spaces to accentuate operator precedence and improve readability */

public class Quadratic {
    
    public static double root1(double a, double b, double c) {
        double determinant = determinant(a, b, c); // note spacing, not (a,b,c)
        return (-b + Math.sqrt(determinant)) / (2*a); // emphasizes operator precedence
    }

    public static double root2(int a, int b, int c) {
        double determinant = determinant(a, b, c);
        return (-b - Math.sqrt(determinant)) / (2*a);
    }

    public static double determinant(double a, double b, double c) {
        return b*b - 4*a*c; // once again, clear operator precedence vs b*b-4*a*c which is *shit code*
    }
