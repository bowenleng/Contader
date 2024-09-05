package net.leng.strings;

import org.jetbrains.annotations.NotNull;

public class AdvancedString implements Comparable<AdvancedString>, CharSequence {
    private final String soleLetters;
    private final String string;
    public AdvancedString(String pStr) {
        this.string = pStr;
        this.soleLetters = pStr.replaceAll("[\\/.,:'\"`~^*-]", "");
    }

    public String convertToIPA() {
        return XSampaConversion.convert(string);
    }

    @Override
    public int length() {
        return soleLetters.length();
    }

    @Override
    public char charAt(int index) {
        return soleLetters.charAt(index);
    }

    @NotNull
    @Override
    public CharSequence subSequence(int start, int end) {
        return soleLetters.subSequence(start, end);
    }

    @Override
    public int compareTo(@NotNull AdvancedString o) {
        return soleLetters.compareTo(o.soleLetters);
    }

    @Override
    public @NotNull String toString() {
        return string;
    }
}
