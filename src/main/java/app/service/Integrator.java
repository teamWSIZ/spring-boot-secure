package app.service;


import lombok.extern.slf4j.Slf4j;

@Slf4j
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
