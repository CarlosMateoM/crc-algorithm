package CRCAlgorithm.model;

/**
 *
 * @author mateo092
 */
public class CRC {

    private String quotient;
    private String inputPadded;
    private String currentChuck;
    private String initialFiller;
    private String inputBitstring;
    private String polynomialBitstring;

    public CRC() {
        quotient = "";
        initialFiller = "";
        inputBitstring = "";
        inputPadded = "";
        polynomialBitstring = "";
    }

    public String getQuotient() {
        return quotient;
    }

    public void setQuotient(String quotient) {
        this.quotient = quotient;
    }

    public String getInputPadded() {
        return inputPadded;
    }

    public void setInputPadded(String inputPadded) {
        this.inputPadded = inputPadded;
    }

    public String getInitialFiller() {
        return initialFiller;
    }

    public void setInitialFiller(String initialFiller) {
        this.initialFiller = initialFiller;
    }

    public String getInputBitstring() {
        return inputBitstring;
    }

    public void setInputBitstring(String inputBitstring) {
        this.inputBitstring = inputBitstring;
    }

    public String getPolynomialBitstring() {
        return polynomialBitstring;
    }

    public void setPolynomialBitstring(String polynomialBitstring) {
        this.polynomialBitstring = polynomialBitstring.replaceFirst("^0+(?!$)", "");
    }

    public String getCurrentChuck() {
        return currentChuck;
    }

    public void setCurrentChuck(String currentChuck) {
        this.currentChuck = currentChuck;
    }
    
    

    public static void printReport(String inputPadded, String polynomial, String currentChunk, int xorResult) {
        System.out.printf("%-40s\t%-10s\t%-10s\t%d\n", inputPadded, polynomial, currentChunk, xorResult);
    }

    // Método para calcular el CRC remainder
    public static String crcRemainder(String inputBitstring, String polynomialBitstring, String initialFiller) {

        // Elimina los ceros no significativos 0001110110 -> 1110110
        polynomialBitstring = polynomialBitstring.replaceFirst("^0+(?!$)", "");

        // D = 1110110 G = 1011 R = 000 -> (D + R -> 1110110 000)
        String inputPadded = inputBitstring + initialFiller;

        System.out.printf(
                "%-40s\t%-10s\t%-10s\t%s\n",
                "INPUT PADDED(D)", "POLYNOMIAL(G)", "CURRENT CHUNCK", "XOR OPERATION");

        String quotient = ""; // Almacenar el cociente

        int xor = 0;

        //inputPadded = 11 polynomialBitstring = 4
        while (inputPadded.length() >= polynomialBitstring.length()) {

            String currentChunk = inputPadded.substring(0, polynomialBitstring.length());

            inputPadded = inputPadded.substring(polynomialBitstring.length());

            printReport(inputPadded, polynomialBitstring, currentChunk, xor);

            // (^) xor bits operator
            xor = Integer.parseInt(currentChunk, 2) ^ Integer.parseInt(polynomialBitstring, 2);

            currentChunk = xor == 0 ? "" : Integer.toBinaryString(xor);

            inputPadded = currentChunk + inputPadded;

            quotient += '1';
            if (!currentChunk.contains("1")) {
                quotient += "0".repeat(polynomialBitstring.length() - 1);;
            }

            printReport(inputPadded, polynomialBitstring, currentChunk, xor);
        }

        System.out.println("Cociente: " + quotient);

        return inputPadded;
    }

    // Método para verificar el CRC
    public static boolean crcCheck(String inputBitstring, String polynomialBitstring, String crcCheckstring) {
        polynomialBitstring = polynomialBitstring.replaceFirst("^0+(?!$)", ""); // Elimina los ceros no significativos
        crcCheckstring = "0".repeat((polynomialBitstring.length() - 1) - crcCheckstring.length()) + crcCheckstring.replaceFirst("^0+(?!$)", ""); // agregamos los ceros  significativos
        String initialPadding = crcCheckstring;
        String inputPadded = inputBitstring + initialPadding;
        String remainder = crcRemainder(inputBitstring, polynomialBitstring, crcCheckstring);
        return remainder.contains("1");
    }

    // Método para inyectar un error en el bitstring de entrada
    public static String injectError(String inputBitstring) {
        // Aquí puedes implementar la lógica para introducir un error, como cambiar un bit aleatorio.
        // Por simplicidad, este ejemplo solo invierte el primer bit.
        char firstBit = inputBitstring.charAt(0);
        char invertedBit = (firstBit == '0') ? '1' : '0';
        return invertedBit + inputBitstring.substring(1);
    }

}
