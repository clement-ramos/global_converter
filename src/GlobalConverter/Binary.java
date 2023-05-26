package GlobalConverter;

public class Binary {

    // ### Convert Binary to Decimal
    public static String binaryToDecimalConverter(String binNumbers){
        StringBuilder result = new StringBuilder();

        String[] binArray = binNumbers.split("\\s");

        for (String bin : binArray) {
            result.append(binaryToDecimal(bin));
            result.append(" ");
        }

        return result.toString();
    }
    private static int binaryToDecimal(String binaryNumber) {
        int decimalNumber = 0;

        // Parcourez la chaîne binaire de droite à gauche
        for (int i = binaryNumber.length() - 1; i >= 0; i--) {
            char digit = binaryNumber.charAt(i);
            int digitValue = Character.getNumericValue(digit);
            decimalNumber += digitValue * Math.pow(2, binaryNumber.length() - 1 - i);
        }

        return decimalNumber;
    }

    // ### Convert Decimal to Binary
    public static String decimalToBinaryConverter(String decimalNumbers) {

        StringBuilder result = new StringBuilder();

        String[] decArray = decimalNumbers.split(" ");

        for (String c : decArray) {
            int num = Integer.parseInt(c);
            result.append(leftOffset(decimalToBinary(num), 8) + " ");
        }
        return result.toString();
    }
    public static String decimalToBinary(int decimal) {

        StringBuilder result = new StringBuilder();

        while (decimal > 0) {
            int remainder = decimal % 2;
            result.insert(0, (char) ('0' + remainder));
            decimal /= 2;
        }
        return result.toString();
    }
    private static String leftOffset(String binary, int length) {
        if (binary.length() >= length) {
            return binary;
        } else {
            StringBuilder result = new StringBuilder();
            int paddingSize = length - binary.length();
            result.append("0".repeat(paddingSize) + binary);
            return result.toString();
        }
    }

}

