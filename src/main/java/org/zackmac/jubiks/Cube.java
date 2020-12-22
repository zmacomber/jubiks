package org.zackmac.jubiks;

/**
 * A Jubiks cube will be a 3d array like this (numbers are filled in for the front and top faces):
 *
 *       /------------------------/
 *      / 4,0,0 / 4,0,1 / 4,0,2  /|
 *     /------------------------/ |
 *    / 4,1,0 / 4,1,1 / 4,1,2  / /|
 *   /------------------------/ / |
 *  / 4,2,0 / 4,2,1 / 4,2,2  / / /|
 * /------------------------/ / / |
 * | 0,0,0 | 0,0,1 | 0,0,2 | / / /
 * |-----------------------|/ / /
 * | 0,1,0 | 0,1,1 | 0,1,2 | / /
 * |-----------------------|/ /
 * | 0,2,0 | 0,2,1 | 0,2,2 | /
 * |-----------------------|/
 *
 * The faces (1st part of the 3d array) will be numbered 0 - 5 in this order: front, right, back, left, top, bottom
 * Each face row (2nd part of the 3d array) will be numbered 0 - 2 top to bottom
 * Each face column (3rd part of the 3d array) will be numbered 0 - 2 left to right
 *
 * Ultimately, we're tracking the color of each square - (r)ed, (b)lue, (o)range, (g)reen, (w)hite & (y)ellow
 */
public final class Cube {
    public static final int NUM_SQUARES = 54;

    private final char[][][] squares = new char[6][3][3];

    public Cube(char[] colors) {
        if ((colors == null) || (colors.length != NUM_SQUARES)) {
            throw new IllegalArgumentException(
                "54 colors should be passed in representing the initial layout of the rubiks cube.\n" +
                "The colors should be supplied in the following face order: front, right, back, left, top & bottom.\n" +
                "Each face square should be supplied top to bottom, left to right.\n"
            );
        }

        int face = 0;
        int row = 0;
        int col = 0;

        for (int x = 0; x < NUM_SQUARES; x++) {
            char color = colors[x];

            if ((color != 'r') && (color != 'b') && (color != 'o') && (color != 'g') && (color != 'w') && (color != 'y')) {
                throw new IllegalArgumentException(
                    "Only the following colors are allowed: (r)ed, (b)lue, (o)range, (g)reen, (w)hite & (y)ellow.\n" +
                    "Please only supply the first character of each color.\n"
                );
            }

            if ((x >= 9) && ((x % 9) == 0)) {
                face++;
                row = 0;
                col = 0;
            } else if ((x >= 3) && ((x % 3) == 0)) {
                row++;
                col = 0;
            }

            squares[face][row][col] = color;

            col++;
        }
    }

    public char[][][] getSquares() {
        return squares;
    }
}
