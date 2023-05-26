package GlobalConverter;

public class Octal {

    // ### Convert Octal to Decimal
    public static String octalToDecimalConverter(String octNumbers) {
        StringBuilder result = new StringBuilder();

        String[] octArray = octNumbers.split("\\s");

        for (String oct : octArray) {
            result.append(octalToDecimal(oct));
            result.append(" ");
        }

        return result.toString();
    }

    private static int octalToDecimal(String octalNumber) {
        int decimalNumber = 0;

        // Parcourez la chaîne octale de droite à gauche
        for (int i = octalNumber.length() - 1; i >= 0; i--) {
            char digit = octalNumber.charAt(i);
            int digitValue = Character.getNumericValue(digit);
            decimalNumber += digitValue * Math.pow(8, octalNumber.length() - 1 - i);
        }

        return decimalNumber;
    }

    // ### Convert Decimal to Octal
    public static String decimalToOctalConverter(String decimalNumbers){

        String[] decArray = decimalNumbers.split(" ");

        for (int i = 0  ; i < decArray.length ; i++){
            int num = Integer.parseInt(decArray[i]);
            decArray[i] = decToOctal(num);
        }
        return String.join(" ", decArray);
    }

    private static String decToOctal(int decimalNumber) {
        StringBuilder result = new StringBuilder();
        if (decimalNumber == 0) {
            result.append("0");
        } else {
            while (decimalNumber > 0) {
                int remainder = decimalNumber % 8;
                result.insert(0, remainder);
                decimalNumber /= 8;
            }
        }
        return result.toString();
    }

}
