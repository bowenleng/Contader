package net.leng.visuals;

import java.awt.*;
import java.util.function.DoubleFunction;
import java.util.function.Function;

public class Graph {
    private DoubleFunction<Function> function;
    private Graphics graphics;
    private Color color;
    private int zoom;
    private double cX;
    private double cY;
    private double width;
    private double height;

    public Graph(Graphics g) {
        graphics = g;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setCenter(double pX, double pY) {
        cX = pX;
        cY = pY;
    }

    public void setFunction(DoubleFunction<Function> function) {
        this.function = function;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public double getCenterX() {
        return cX;
    }

    public double getCenterY() {
        return cY;
    }

    public DoubleFunction<Function> getFunction() {
        return function;
    }

    public Color getColor() {
        return color;
    }

    public void draw() {
        graphics.setColor(color);

    }
}
