package net.leng.math.operations;

import java.util.ArrayList;
import java.util.HashMap;

public class Factors {
    public static ArrayList<Integer> findFactors(int pNum) {
        if (pNum < 1) throw new IllegalArgumentException();
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        if ((pNum & 1) == 0) list.add(2);
        for (int i = 3; i < (pNum >> 1); i += 2) {
            if (pNum % i == 0) list.add(i);
        }
        return list;
    }

    public static boolean isPerfectSquare(int pNum) {
        if (pNum < 1) throw new IllegalArgumentException();
        double val = Math.sqrt(pNum);
        return Double.compare((int)val, val) == 0;
    }

    public static int numberOfFactors(int pNum) {
        if (pNum < 1) throw new IllegalArgumentException();
        int factors = 1;
        if ((pNum & 1) == 0) factors++;
        for (int i = 3; i < (pNum >> 1); i += 2) {
            if (pNum % i == 0) factors++;
        }
        return factors;
    }

    public static boolean isPrime(int pNum) {
        return numberOfFactors(pNum) > 1;
    }

    public static HashMap<Integer, Integer> findPrimeFactorization(int pNum) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int c = 0;
        int modified = pNum;
        while ((modified & 1) == 0) {
            c++;
            modified >>= 1;
        }
        map.put(2, c);
        for (int i = 3; i < (pNum >> 1); i += 2) {
            c = 0;
            while (modified % i == 0) {
                c++;
                modified /= i;
            }
            if (c > 0) map.put(i, c);
        }
        return map;
    }
}
