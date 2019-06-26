package com.ws.base;

public class Util {
    public static int abs(int x) {
        return x < 0 ? -x : x;
    }

    public static double abs(double x) {
        return x < 0.0 ? -x : x;
    }

    public static int gcd(int p, int q) {
        p = abs(p);
        q = abs(q);

        return q == 0 ? p : gcd(q, p % q);
    }
}
