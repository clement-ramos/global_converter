package GlobalConverter;

public class Hexadecimal {

    // ### Convert Hexadecimal to Decimal
    public static String hexadecimalToDecimalConverter(String hexNumbers){
        StringBuilder result = new StringBuilder();

        String[] hexArray = hexNumbers.split("\\s");

        for (String hex : hexArray) {
            result.append(hexadecimalToDecimal(hex));
            result.append(" ");
        }

        return result.toString();
    }

    private static int hexadecimalToDecimal(String hexNumber) {
        int decimalNumber = 0;

        hexNumber = hexNumber.replaceAll("\\s", "");

        for (int i = 0; i < hexNumber.length(); i++) {
            char digit = hexNumber.charAt(i);
            int digitValue = hexCharToDecimal(digit);
            decimalNumber = decimalNumber * 16 + digitValue;
        }

        return decimalNumber;
    }
    private static int hexCharToDecimal(char c) {
        if (c >= '0' && c <= '9') {
            return c - '0';
        } else if (c >= 'A' && c <= 'F') {
            return c - 'A' + 10;
        } else if (c >= 'a' && c <= 'f') {
            return c - 'a' + 10;
        } else {
            throw new IllegalArgumentException("Caractère hexadécimal invalide : " + c);
        }
    }

    // ### Convert Decimal to Hexadecimal
    public static String decimalToHexadecimalConverter(String decNumbers) {
        StringBuilder result = new StringBuilder();

        String[] decArray = decNumbers.split("\\s");

        for (String dec : decArray) {
            int decimal = Integer.parseInt(dec);
            String hex = decimalToHexadecimal(decimal);
            result.append(hex + " ");
        }
        return result.toString();
    }
    private static String decimalToHexadecimal(int decimal) {
        StringBuilder result = new StringBuilder();
        while (decimal > 0) {
            int remainder = decimal % 16;
            result.insert(0, decCharToHexadecimal(remainder));
            decimal /= 16;
        }
        return result.toString();
    }

    private static char decCharToHexadecimal(int remainder) {
        if (remainder >= 0 && remainder <= 9) {
            return (char) ('0' + remainder);
        } else {
            return (char) ('A' + remainder - 10);
        }

    }
}
