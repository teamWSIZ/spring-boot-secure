package app.service;


public class Integrator {
    private double dx = 0.001;

    public double integrateMyFunction1(double a, double b) {
        double sum = 0;
        double x = a;
        while(x < b) {
            sum += Math.sin(x) * dx;
            x += dx;
        }
        return sum;
    }

}
