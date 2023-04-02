package solutions.dmitrikonnov.alphabet;

public enum AlphabetSquaresVector {
    A('A',
            new byte[][]{
        {0, 0, 1},
        {0, 1, 1},
        {1, 0, 1}
    }, new byte[][]{
        {1, 1, 1, 1},
        {1, 0, 0, 1},
        {1, 1, 1, 1},
        {1, 0, 0, 1}
    }, new byte[][]{
            {0, 1, 1, 0,},
            {1, 0, 0, 1,},
            {1, 1, 1, 1,},
            {1, 0, 0, 1,},
            {1, 0, 0, 1,}}

    ),
    SPACE(' ',
            new byte[][]{
        {0, },
        {0, },
        {0, }
    }, new byte[][]{
        {0, },
        {0, },
        {0, },
        {0, }
    }, new byte[][]{
        {0, },
        {0, },
        {0, },
        {0, },
        {0, }
    });
    public final char symbol;
    public final byte[][] threeSquares;
    public final byte[][] fourSquares;
    public final byte[][] fiveSquares;
   AlphabetSquaresVector(char symbol,byte [][] height, byte[][] fourSquares, byte[][] fiveSquares) {
        this.symbol = symbol;
        this.threeSquares = height;
        this.fourSquares = fourSquares;
        this.fiveSquares = fiveSquares;

    }

    public static AlphabetSquaresVector valueOf(char symbol) {
        for (AlphabetSquaresVector value : values()) {
            if (value.symbol == symbol) {
                return value;
            }
        }
        return null;
    }
}
