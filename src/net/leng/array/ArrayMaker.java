package net.leng.array;

import java.util.ArrayList;
import java.util.List;

public class ArrayMaker {
    public static <T> List<T> listIntersection(List<T> a, List<T> b) {
        if (a == null || a.isEmpty() || b == null || b.isEmpty()) return List.of();
        return null;
    }

    public static <T> List<T> listUnion(List<T> a, List<T> b) {
        if (a == null || a.isEmpty()) return new ArrayList<>(b);
        if (b == null || b.isEmpty()) return new ArrayList<>(a);
        return null;
    }
}
