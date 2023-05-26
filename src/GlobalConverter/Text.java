package GlobalConverter;

public class Text {

    // ### Convert Text to Decimal
    public static String textToDecimalConverter(String textCharacters){
        StringBuilder result = new StringBuilder();

        for (char c : textCharacters.toCharArray()) {
            String decimal = String.valueOf((int) c);

            result.append(decimal);
            result.append(' ');
        }

        return result.toString();
        }

    // ### Convert Decimal to Text
    public static String decimalToTextConverter(String decimalNumbers){
        StringBuilder result = new StringBuilder();

        String[] decArray = decimalNumbers.split("\\s");
        // If space
        for (String dec : decArray) {
            int decimal = Integer.parseInt(dec);
            char character = (char) decimal;
            result.append(character);
        }
        return result.toString();
    }
}
