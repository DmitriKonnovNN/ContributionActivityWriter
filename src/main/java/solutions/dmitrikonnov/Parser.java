package solutions.dmitrikonnov;

import solutions.dmitrikonnov.alphabet.AlphabetSquaresVector;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Parser {


    private static List<AlphabetSquaresVector> parseToAlphabet(String input) {
        var array = input.toCharArray();
        List<AlphabetSquaresVector> result = new ArrayList<>();
        for (char symbol : array) {
            var vector = AlphabetSquaresVector.valueOf(symbol);
            if (vector == null) {
                throw new IllegalArgumentException("Symbol " + symbol + " is not supported");
            }
            result.add(vector);
        }
        return result;
    }


    public static byte[][] parse(String input, short size) {
        var alphabetVector = parseToAlphabet(input);
        var tempResult = new byte[alphabetVector.size()][size][];
        var length = 0;
        for (int i = 0; i < alphabetVector.size(); i++) {
            var vector = alphabetVector.get(i);
            switch (size) {
                case 3 -> {
                    tempResult[i] = vector.threeSquares;
                    length += vector.threeSquares[0].length;
                }
                case 4 -> {
                    tempResult[i] = vector.fourSquares;
                    length += vector.fourSquares[0].length;
                }
                case 5 -> {
                    tempResult[i] = vector.fiveSquares;
                    length += vector.fiveSquares[0].length;
                }
                default -> throw new IllegalArgumentException("Size " + size + " is not supported");
            }
        }
        return flatten(tempResult, length );
    }

    public static byte[][] flatten (byte[][][] symbolVector, int length) {
        var result = new byte[symbolVector[0].length][length];
        for (int i = 0, d = 0; i < symbolVector.length; i++) {
            for (int j = 0; j < symbolVector[i].length; j++) {
                for (int k = 0; k < symbolVector[i][j].length; k++) {
                    result[j][k+d]= symbolVector[i][j][k];
                }
            }
            d += symbolVector[i][0].length;
        }
        return result;
    }

    public static void printFlattened (byte[][] symbolVector) {
        for (byte[] bytes : symbolVector) {
            for (byte aByte : bytes) {
                System.out.print(aByte);
            }
            System.out.println();
        }
    }



    public static void print(byte[][][]input) {
        for (byte[][] bytes : input) {
            for (byte[] aByte : bytes) {
                for (int k = 0; k < aByte.length; k++) {
                    System.out.print(aByte[k]);
                }
                System.out.println();
            }

        }
    }

}


