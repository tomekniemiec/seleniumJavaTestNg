package utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexUtils {

    public static boolean matches(String regexPattern, String text) {
        boolean result = false;

        Pattern p = Pattern.compile(regexPattern);
        Matcher m = p.matcher(text);
        result = m.matches();

        return result;
    }

    private static boolean checkEmailRegex(String inputText) {
        boolean result = false;

        final String regexPattern = "([a-z0-9._%+-]+)@([a-z0-9.-]+\\.[a-z]+)";
        result = RegexUtils.matches(regexPattern, inputText);

        return result;
    }

    private static boolean checkPhoneNumberRegex(String inputText) {
        boolean result = false;

        final String regexPattern = "\\(?\\d+\\)?[-. ]?\\d+[-. ]?\\d+";
        result = RegexUtils.matches(regexPattern, inputText);

        return result;
    }

    public static void main(String[] args) {
        boolean resultPhone = RegexUtils.checkPhoneNumberRegex("502-333-278");
        System.out.println(resultPhone);

        boolean resultEmail = RegexUtils.checkEmailRegex("test@ok.pl");
        System.out.println(resultEmail);
    }
}
