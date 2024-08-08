package net.leng.strings;

public class XSampaConversion {
    public static char basic(char c) {
        return switch (c) {
            case '.' -> '.';
            case '"' -> 'ˈ';
            case '%' -> 'ˌ';
            case '\'' -> 'ʲ';
            case ':' -> 'ː';
            case '-' -> ' ';
            case '@' -> 'ə';
            case '{' -> 'æ';
            case '}' -> 'ʉ';
            case '1' -> 'ɨ';
            case '2' -> 'ø';
            case '3' -> 'ɜ';
            case '4' -> 'ɾ';
            case '5' -> 'ɫ';
            case '6' -> 'ɐ';
            case '7' -> 'ɤ';
            case '8' -> 'ɵ';
            case '9' -> 'œ';
            case '&' -> 'ɶ';
            case '?' -> 'ʔ';
            case '<' -> '⟨';
            case '>' -> '⟩';
            case '^' -> 'ꜛ';
            case '!' -> 'ꜜ';
            case 'A' -> 'ɑ';
            case 'B' -> 'β';
            case 'C' -> 'ç';
            case 'D' -> 'ð';
            case 'E' -> 'ɛ';
            case 'F' -> 'ɱ';
            case 'G' -> 'ɣ';
            case 'H' -> 'ɥ';
            case 'I' -> 'ɪ';
            case 'J' -> 'ɲ';
            case 'K' -> 'ɬ';
            case 'L' -> 'ʎ';
            case 'M' -> 'ɯ';
            case 'N' -> 'ŋ';
            case 'O' -> 'ɔ';
            case 'P' -> 'ʋ';
            case 'Q' -> 'ɒ';
            case 'R' -> 'ʁ';
            case 'S' -> 'ʃ';
            case 'T' -> 'θ';
            case 'U' -> 'ʊ';
            case 'V' -> 'ʌ';
            case 'W' -> 'ʍ';
            case 'X' -> 'χ';
            case 'Y' -> 'ʏ';
            case 'Z' -> 'ʒ';
            default -> c;
        };
    }

    public static char backslashed(char c) { // added a \
        return switch (c) {
            case ':' -> 'ˑ';
            case '@' -> 'ɘ';
            case '3' -> 'ɞ';
            case '?' -> 'ʕ';
            case '<' -> 'ʢ';
            case '>' -> 'ʡ';
            case '|' -> 'ǀ';
            case '=' -> 'ǂ';
            case '-' -> '‿';
            case 'B' -> 'ʙ';
            case 'G' -> 'ɢ';
            case 'H' -> 'ʜ';
            case 'I' -> 'ᵻ';
            case 'J' -> 'ɟ';
            case 'K' -> 'ɮ';
            case 'L' -> 'ʟ';
            case 'M' -> 'ɰ';
            case 'N' -> 'ɴ';
            case 'O' -> 'ʘ';
            case 'R' -> 'ʀ';
            case 'U' -> 'ᵿ';
            case 'X' -> 'ħ';
            case 'h' -> 'ɦ';
            case 'j' -> 'ʝ';
            case 'l' -> 'ɺ';
            case 'p' -> 'ɸ';
            case 'r' -> 'ɹ';
            case 's' -> 'ɕ';
            case 'v' -> 'ʋ';
            case 'z' -> 'ʑ';
            default -> c;
        };
    }

    public static char underscoreLeftanglebracket(char c, boolean hasBackslash) { // added with a _<
        if (hasBackslash) {
            return switch (c) {
                case 'G' -> 'ɢ';
                case 'J' -> 'ʄ';
                default -> backslashed(c);
            };
        }
        return switch (c) {
            case 'b' -> 'ɓ';
            case 'd' -> 'ɗ';
            case 'g' -> 'ɠ';
            default -> c;
        };
    }

    public static char grave(char c, boolean hasBackslash) { // added with a `
        if (hasBackslash && c == 'r') return 'ɻ';
        return switch (c) {
            case '@' -> 'ɚ';
            case 'd' -> 'ɖ';
            case 'l' -> 'ɭ';
            case 'n' -> 'ɳ';
            case 'r' -> 'ɽ';
            case 's' -> 'ʂ';
            case 't' -> 'ʈ';
            case 'z' -> 'ʐ';
            default -> c;
        };
    }

    public static char superscripted(char c) { // contains a _ before the statement
        return switch (c) {
            case 'h' -> 'ʰ';
            case 'j' -> 'ʲ';
            case 'n' -> 'ⁿ';
            case 'w' -> 'ʷ';
            default -> c;
        };
    }

    private static String segment(String seg) {
        if (seg.isEmpty()) return "";
        if (seg.length() == 1) return Character.toString(basic(seg.charAt(0)));
        char c = seg.charAt(0);
        if (seg.charAt(1) == '\\') {
            if (seg.startsWith("_<", 2)) {
                return Character.toString(underscoreLeftanglebracket(c, true));
            }
            if (seg.length() > 2 && seg.charAt(2) == '`') {
                return Character.toString(grave(c, true));
            }
            return Character.toString(backslashed(c));
        }
        if (seg.startsWith("_<", 1)) {
            return Character.toString(underscoreLeftanglebracket(c, false));
        }
        if (seg.charAt(1) == '`') {
            return Character.toString(grave(c, false));
        }
        return seg;
    }

    public static String convert(String str) {
        StringBuilder builder = new StringBuilder();
        int prev = 0;
        for (int i = 0; i < str.length(); i++) {
            String sub;
            int end = i + 1;
            if (str.charAt(i) == '<' || str.charAt(i) == '`' || str.charAt(i) == '\\') {
                sub = str.substring(prev, end);
                prev = end;
            } else {
                sub = str.substring(i, end);
            }
            builder.append(segment(sub));
        }
        return builder.toString();
    }
}
