package net.leng.array;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.function.Function;

public class ArrayMaker {
    @Contract(pure = true)
    public static <T extends Comparable<T>> T @NotNull [] makeSortedArray(T @NotNull [] list) {
        int len = list.length;
        T[] sorted = (T[])(new Comparable[len]);
        for (int i = 0; i < len; i++) {
            T item = list[i];
            int ind = i;
            while (ind > 0 && list[ind-1].compareTo(item) > 0) {
                sorted[ind] = sorted[ind-1];
                ind--;
            }
            sorted[ind] = item;
        }
        return sorted;
    }

    @Contract(pure = true)
    public static byte @NotNull [] makeSortedArray(byte @NotNull [] list) {
        int len = list.length;
        byte[] sorted = new byte[len];
        for (int i = 0; i < len; i++) {
            byte item = list[i];
            int ind = i;
            while (ind > 0 && list[ind-1] > item) {
                sorted[ind] = sorted[ind-1];
                ind--;
            }
            sorted[ind] = item;
        }
        return sorted;
    }

    @Contract(pure = true)
    public static char @NotNull [] makeSortedArray(char @NotNull [] list) {
        int len = list.length;
        char[] sorted = new char[len];
        for (int i = 0; i < len; i++) {
            char item = list[i];
            int ind = i;
            while (ind > 0 && list[ind-1] > item) {
                sorted[ind] = sorted[ind-1];
                ind--;
            }
            sorted[ind] = item;
        }
        return sorted;
    }

    @Contract(pure = true)
    public static double @NotNull [] makeSortedArray(double @NotNull [] list) {
        int len = list.length;
        double[] sorted = new double[len];
        for (int i = 0; i < len; i++) {
            double item = list[i];
            int ind = i;
            while (ind > 0 && list[ind-1] > item) {
                sorted[ind] = sorted[ind-1];
                ind--;
            }
            sorted[ind] = item;
        }
        return sorted;
    }

    @Contract(pure = true)
    public static float @NotNull [] makeSortedArray(float @NotNull [] list) {
        int len = list.length;
        float[] sorted = new float[len];
        for (int i = 0; i < len; i++) {
            float item = list[i];
            int ind = i;
            while (ind > 0 && list[ind-1] > item) {
                sorted[ind] = sorted[ind-1];
                ind--;
            }
            sorted[ind] = item;
        }
        return sorted;
    }

    @Contract(pure = true)
    public static int @NotNull [] makeSortedArray(int @NotNull [] list) {
        int len = list.length;
        int[] sorted = new int[len];
        for (int i = 0; i < len; i++) {
            int item = list[i];
            int ind = i;
            while (ind > 0 && list[ind-1] > item) {
                sorted[ind] = sorted[ind-1];
                ind--;
            }
            sorted[ind] = item;
        }
        return sorted;
    }

    @Contract(pure = true)
    public static long @NotNull [] makeSortedArray(long @NotNull [] list) {
        int len = list.length;
        long[] sorted = new long[len];
        for (int i = 0; i < len; i++) {
            long item = list[i];
            int ind = i;
            while (ind > 0 && list[ind-1] > item) {
                sorted[ind] = sorted[ind-1];
                ind--;
            }
            sorted[ind] = item;
        }
        return sorted;
    }

    @Contract(pure = true)
    public static short @NotNull [] makeSortedArray(short @NotNull [] list) {
        int len = list.length;
        short[] sorted = new short[len];
        for (int i = 0; i < len; i++) {
            short item = list[i];
            int ind = i;
            while (ind > 0 && list[ind-1] > item) {
                sorted[ind] = sorted[ind-1];
                ind--;
            }
            sorted[ind] = item;
        }
        return sorted;
    }

    public static <T> T @NotNull [] makeSortedArray(T @NotNull [] list, Comparator<T> comparator) {
        int len = list.length;
        T[] sorted = (T[])(new Object[len]);
        for (int i = 0; i < len; i++) {
            T item = list[i];
            int ind = i;
            while (ind > 0 && comparator.compare(list[ind-1], item) > 0) {
                sorted[ind] = sorted[ind-1];
                ind--;
            }
            sorted[ind] = item;
        }
        return sorted;
    }

    @Contract(pure = true)
    public static byte @NotNull [] makeSortedArray(byte @NotNull [] list, Comparator<Byte> comparator) {
        int len = list.length;
        byte[] sorted = new byte[len];
        for (int i = 0; i < len; i++) {
            byte item = list[i];
            int ind = i;
            while (ind > 0 && comparator.compare(list[ind-1], item) > 0) {
                sorted[ind] = sorted[ind-1];
                ind--;
            }
            sorted[ind] = item;
        }
        return sorted;
    }

    @Contract(pure = true)
    public static char @NotNull [] makeSortedArray(char @NotNull [] list, Comparator<Character> comparator) {
        int len = list.length;
        char[] sorted = new char[len];
        for (int i = 0; i < len; i++) {
            char item = list[i];
            int ind = i;
            while (ind > 0 && comparator.compare(list[ind-1], item) > 0) {
                sorted[ind] = sorted[ind-1];
                ind--;
            }
            sorted[ind] = item;
        }
        return sorted;
    }

    @Contract(pure = true)
    public static double @NotNull [] makeSortedArray(double @NotNull [] list, Comparator<Double> comparator) {
        int len = list.length;
        double[] sorted = new double[len];
        for (int i = 0; i < len; i++) {
            double item = list[i];
            int ind = i;
            while (ind > 0 && comparator.compare(list[ind-1], item) > 0) {
                sorted[ind] = sorted[ind-1];
                ind--;
            }
            sorted[ind] = item;
        }
        return sorted;
    }

    @Contract(pure = true)
    public static float @NotNull [] makeSortedArray(float @NotNull [] list, Comparator<Float> comparator) {
        int len = list.length;
        float[] sorted = new float[len];
        for (int i = 0; i < len; i++) {
            float item = list[i];
            int ind = i;
            while (ind > 0 && comparator.compare(list[ind-1], item) > 0) {
                sorted[ind] = sorted[ind-1];
                ind--;
            }
            sorted[ind] = item;
        }
        return sorted;
    }

    @Contract(pure = true)
    public static int @NotNull [] makeSortedArray(int @NotNull [] list, Comparator<Integer> comparator) {
        int len = list.length;
        int[] sorted = new int[len];
        for (int i = 0; i < len; i++) {
            int item = list[i];
            int ind = i;
            while (ind > 0 && comparator.compare(list[ind-1], item) > 0) {
                sorted[ind] = sorted[ind-1];
                ind--;
            }
            sorted[ind] = item;
        }
        return sorted;
    }

    @Contract(pure = true)
    public static long @NotNull [] makeSortedArray(long @NotNull [] list, Comparator<Long> comparator) {
        int len = list.length;
        long[] sorted = new long[len];
        for (int i = 0; i < len; i++) {
            long item = list[i];
            int ind = i;
            while (ind > 0 && comparator.compare(list[ind-1], item) > 0) {
                sorted[ind] = sorted[ind-1];
                ind--;
            }
            sorted[ind] = item;
        }
        return sorted;
    }

    @Contract(pure = true)
    public static short @NotNull [] makeSortedArray(short @NotNull [] list, Comparator<Short> comparator) {
        int len = list.length;
        short[] sorted = new short[len];
        for (int i = 0; i < len; i++) {
            short item = list[i];
            int ind = i;
            while (ind > 0 && comparator.compare(list[ind-1], item) > 0) {
                sorted[ind] = sorted[ind-1];
                ind--;
            }
            sorted[ind] = item;
        }
        return sorted;
    }

    public static <T> T @NotNull [] union(T @NotNull [] a, T[] b) {
        CombinedArray<T> comb = new CombinedArray<>(a, b);
        return comb.union();
    }

    public static <T> T @NotNull [] intersection(T @NotNull [] a, T[] b) {
        CombinedArray<T> comb = new CombinedArray<>(a, b);
        return comb.intersection();
    }

    public static <T> T @NotNull [] createArrayFromFormula(T @NotNull [] items, Function<T, T> formula) {
        int len = items.length;
        T[] arr = (T[])(new Object[len]);
        for (int i = 0; i < len; i++) {
            T t = items[i];
            arr[i] = formula.apply(t);
        }
        return arr;
    }

    private static <T> T[] createArrayFromMap(Map<T, Integer> map, Set<T> items, int len) {
        T[] arr = (T[])(new Object[len]);
        int ind = 0;
        for (T item : items) {
            int loops = map.getOrDefault(item, 0);
            for (int i = 0; i < loops; i++) {
                arr[ind++] = item;
            }
        }
        return arr;
    }

    private static class CombinedArray<T> {
        private Map<T, Integer> aMap;
        private Map<T, Integer> bMap;
        private Set<T> items;
        private CombinedArray(T[] a, T[] b) {
            boolean comp = a instanceof Comparable[] && b instanceof Comparable[];
            items = comp ? new TreeSet<>() : new HashSet<>();
            aMap = comp ? new TreeMap<>() : new HashMap<>();
            for (T item : a) {
                aMap.put(item, aMap.getOrDefault(item, 0) + 1);
                items.add(item);
            }

            bMap = comp ? new TreeMap<>() : new HashMap<>();
            for (T item : b) {
                bMap.put(item, bMap.getOrDefault(item, 0) + 1);
                items.add(item);
            }
        }

        public T[] union() {
            Map<T, Integer> map = new HashMap<>();
            int arrLen = 0;
            for (T item : items) {
                int aCnt = aMap.getOrDefault(item, 0);
                int bCnt = bMap.getOrDefault(item, 0);
                int max = Math.max(aCnt, bCnt);
                arrLen += max;
                map.put(item, max);
            }
            return createArrayFromMap(map, items, arrLen);
        }

        public T[] intersection() {
            Map<T, Integer> map = new HashMap<>();
            int arrLen = 0;
            for (T item : items) {
                int aCnt = aMap.getOrDefault(item, 0);
                int bCnt = bMap.getOrDefault(item, 0);
                int min = Math.min(aCnt, bCnt);
                arrLen += min;
                map.put(item, min);
            }
            return createArrayFromMap(map, items, arrLen);
        }
    }
}
