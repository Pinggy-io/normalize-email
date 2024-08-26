package io.pinggy.emails.util;

public class EmailNormalizationUtils {

    // Remove suffix after '+' in the local part
    public static String removeSuffixAfterPlus(String localPart) {
        int plusIndex = localPart.indexOf("+");
        if (plusIndex != -1) {
            localPart = localPart.substring(0, plusIndex);
        }
        return localPart;
    }

    // Remove all dots from the local part
    public static String removeDots(String localPart) {
        return localPart.replace(".", "");
    }

}
