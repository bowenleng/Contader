package net.leng.math.directionalnum;

import org.jetbrains.annotations.NotNull;

public class VectorNumber implements Comparable<VectorNumber> {
    private final double x;
    private final double y;
    private final double theta;
    private final double magnitude;
    private VectorNumber(double pMagnitude, double pAngle) {
        theta = pAngle;
        magnitude = pMagnitude;
        x = pMagnitude * Math.cos(pAngle);
        y = pMagnitude * Math.sin(pAngle);
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getMagnitude() {
        return magnitude;
    }

    public double getAngle() {
        return theta;
    }

    @Override
    public int compareTo(@NotNull VectorNumber o) {
        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return "⟨" + magnitude + " ∠" + theta + "⟩";
    }

    public static VectorNumber of() {
        return new VectorNumber(0, 0);
    }

    public static VectorNumber of(double pMagnitude, double pAngle) {
        return new VectorNumber(pMagnitude, pAngle);
    }

    public static VectorNumber fromLocation(double pX, double pY) {
        double angle = Math.atan2(pY, pX);
        double magnitude = Math.sqrt(Math.pow(pX, 2) + Math.pow(pY, 2));
        return of(magnitude, angle);
    }
}
