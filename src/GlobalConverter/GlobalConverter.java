package GlobalConverter;

public class GlobalConverter {
    public static void main(String[] args) {
        // This had to handle 3 args (4 for the bonus)

        // base1 base2 String
        if (args.length < 3) {
            System.out.println("Invalid number of arguments, you have to specify:\n1.The base of your input string\n2.The base you want in output\n3.The string that you want to convert");
            return;
        }

        String inputBase = args[0];
        String outputBase = args[1];
        String input = args[2];

        //Checking that my input is alphanumeric
        if (!isValidString(input)) {
            System.out.println("Error with: " + input +"\n Your input isn't an alphanumeric one");
            return;
        }

        //Checking that input/output bases are availables ones
        if (!isValidBase(inputBase) || !isValidBase(outputBase)) {
            System.out.println("Error with: " + inputBase + " " + outputBase +"\n One of your bases arent an available options you can only use: -t -h -d -o -b");
            return;
        }

        //Convert my input to decimal
        String decimalValue = inputToDecimal(inputBase, input);
        //Convert my decimalInput to outputbase
        String output = decimalInputToOutputBase(outputBase, decimalValue);

        //Printing the input/output in a right format
        System.out.println("["+inputBase+"] Your input is:  " + input);
        System.out.println("["+outputBase+"] Your output is: " + output);
    }

    private static String inputToDecimal(String inputBase, String input){

        String decimalInput= "";

        switch (inputBase) {
            case "text", "-t":
                if (!isValidString(input)) {
                    System.out.println("Error with: " + input + "\nThis input doesn't match the inputbase: " + inputBase);
                    System.exit(0);
                }
                decimalInput = Text.textToDecimalConverter(input);
                break;

            case "hexadecimal", "-h":
                if (!isValidHex(input)) {
                    System.out.println("Error with: " + input + "\nThis input doesn't match the inputbase: " + inputBase);
                    System.exit(0);
                }
                decimalInput = Hexadecimal.hexadecimalToDecimalConverter(input);
                break;

            case "decimal", "-d":
                if (!isValidDec(input)) {
                    System.out.println("Error with: " + input + "\nThis input doesn't match the inputbase: " + inputBase);
                    System.exit(0);
                }
                decimalInput = input;
                break;

            case "octal", "-o":
                if (!isValidOctal(input)) {
                    System.out.println("Error with: " + input + "\nThis input doesn't match the inputbase: " + inputBase);
                    System.exit(0);
                }
                decimalInput = Octal.octalToDecimalConverter(input);
                break;

            case "binaire", "-b":
                if (!isValidBinary(input)) {
                    System.out.println("Error with: " + input + "\nThis input doesn't match the inputbase: " + inputBase);
                    System.exit(0);
                }
                decimalInput = Binary.binaryToDecimalConverter(input);
                break;

            default:
                System.out.println("Invalid intput base: " + inputBase);
                System.exit(0);
        }
        return decimalInput;
    }

    private static String decimalInputToOutputBase(String outputBase, String decimalInput){

        String output = "";

        switch (outputBase){
            case "text", "-t":
                output = Text.decimalToTextConverter(decimalInput);
                break;

            case "hexadecimal", "-h":
                output = Hexadecimal.decimalToHexadecimalConverter(decimalInput);
                break;

            case "decimal", "-d":
                output = decimalInput;
                break;

            case "octal", "-o":
                output = Octal.decimalToOctalConverter(decimalInput);
                break;

            case "binaire", "-b":
                output = Binary.decimalToBinaryConverter(decimalInput);
                break;

            default:
                System.out.println("Invalid output base: " + outputBase);

        }
        return output;
    }

    //Checking the input based on each bases
    private static boolean isValidHex(String input) {
        return input.matches("[0-9a-fA-F ]+");
    }
    private static boolean isValidDec(String input) {
        return input.matches("[0-9 ]+");
    }
    private static boolean isValidOctal(String input) {
        return input.matches("[0-7 ]+");
    }
    private static boolean isValidBinary(String input) {
        return input.matches("[0-1 ]+");
    }
    //Alphanumeric
    private static boolean isValidString(String input) {
        return input.matches("[a-zA-Z0-9 ]+");
    }

    private static boolean isValidBase(String base) {
        return base.equals("hexadecimal") || base.equals("-h")
                || base.equals("octal") || base.equals("-o")
                || base.equals("decimal") || base.equals("-d")
                || base.equals("binary") || base.equals("-b")
                || base.equals("text") || base.equals("-t");
    }
}


