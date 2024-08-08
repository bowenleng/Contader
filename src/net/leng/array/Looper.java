package net.leng.array;

import java.util.function.Predicate;

public class Looper {
    public static boolean containsOne(String original, String... strings) {
        return forLoopBoolean(original::contains, strings);
    }

    public static boolean startsWithEither(String original, String... strings) {
        return forLoopBoolean(original::startsWith, strings);
    }

    public static boolean startsWithEither(String original, int offset, String... strings) {
        return forLoopBoolean(s -> original.startsWith(s, offset), strings);
    }


    public static boolean containsInOrder(String original, String... strings) {
        int offset = 0;
        for (String str : strings) {
            int ind = original.indexOf(str);
            if (ind >= offset) offset = ind;
            else return false;
        }
        return true;
    }

    public static int findIndexEitherOf(String original, String... strings) {
        for (String str : strings) {
            int ind = original.indexOf(str);
            if (ind >= 0) return ind;
        }
        return -1;
    }

    public static <T> boolean isEither(T original, T... types) {
        return forLoopBoolean(original::equals, types);
    }

    public static <T> boolean forLoopBoolean(Predicate<T> predicate, T... types) {
        for (T type : types) {
            if (predicate.test(type)) return true;
        }
        return false;
    }

    public static <T> int forLoopBooleanWithIndexOf(Predicate<T> predicate, T... types) {
        int ind = 0;
        for (T type : types) {
            if (predicate.test(type)) return ind;
            ind++;
        }
        return -1;
    }
}
