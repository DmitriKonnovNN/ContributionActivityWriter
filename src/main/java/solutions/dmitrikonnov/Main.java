package solutions.dmitrikonnov;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        var output = Parser.parse(" ", (short) 5);
        Parser.printFlattened(output);
    }
}