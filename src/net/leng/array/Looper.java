package net.leng.array;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.function.Predicate;

public class Looper {
    /** Checks whether a string contains any strings inside the array of strings.
     * */
    public static boolean containsOne(@NotNull String original, String... strings) {
        return forLoopBoolean(original::contains, strings);
    }

    /** Checks whether a string starts with any of the strings inside the array of strings.
     * */
    public static boolean startsWithEither(@NotNull String original, String... strings) {
        return forLoopBoolean(original::startsWith, strings);
    }

    /** Checks whether a string starts with any of the strings inside the array of strings in which
     * the distance from the beginning of the string is taken into consideration.
     * */
    public static boolean startsWithEither(String original, int offset, String... strings) {
        return forLoopBoolean(s -> original.startsWith(s, offset), strings);
    }

    /** Checks whether a string contains the elements in the string array in order.
     * */
    @Contract(pure = true)
    public static boolean containsInOrder(String original, String @NotNull ... strings) {
        int offset = 0;
        for (String str : strings) {
            int ind = original.indexOf(str);
            if (ind >= offset) offset = ind;
            else return false;
        }
        return true;
    }

    /** Looks through the string to check the first index in which any element in the string array occurs.
     * */
    @Contract(pure = true)
    public static int findIndexEitherOf(String original, String @NotNull ... strings) {
        for (String str : strings) {
            int ind = original.indexOf(str);
            if (ind >= 0) return ind;
        }
        return -1;
    }

    /** Checks
     * */
    @SafeVarargs
    public static <T> boolean isEither(@NotNull T original, T... types) {
        return forLoopBoolean(original::equals, types);
    }

    @SafeVarargs
    public static <T> boolean forLoopBoolean(Predicate<T> predicate, T @NotNull ... types) {
        for (T type : types) {
            if (predicate.test(type)) return true;
        }
        return false;
    }

    @SafeVarargs
    public static <T> int forLoopBooleanWithIndexOf(Predicate<T> predicate, T @NotNull ... types) {
        int ind = 0;
        for (T type : types) {
            if (predicate.test(type)) return ind;
            ind++;
        }
        return -1;
    }
}
