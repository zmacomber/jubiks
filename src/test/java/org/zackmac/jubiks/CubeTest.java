package org.zackmac.jubiks;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CubeTest {

    @Test
    public void shouldSetupCubeRight() {
        char[] colors = new char[] {
            'w','y','g','b','r','o','r','b','g',
            'y','g','b','r','o','r','b','g','w',
            'g','b','r','o','r','b','g','w','y',
            'b','r','o','r','b','g','w','y','g',
            'r','o','r','b','g','w','y','g','b',
            'o','r','b','g','w','y','g','b','r'
        };

        Cube cube = new Cube(colors);

        char[][][] squares = cube.getSquares();

        checkFace(squares, colors, 0, 0);
        checkFace(squares, colors, 1, 9);
        checkFace(squares, colors, 2, 18);
        checkFace(squares, colors, 3, 27);
        checkFace(squares, colors, 4, 36);
        checkFace(squares, colors, 5, 45);
    }

    private void checkFace(char[][][] squares, char[] colors, int face, int colorStartIndex) {
        assertEquals(squares[face][0][0], colors[colorStartIndex]);
        assertEquals(squares[face][0][1], colors[colorStartIndex + 1]);
        assertEquals(squares[face][0][2], colors[colorStartIndex + 2]);
        assertEquals(squares[face][1][0], colors[colorStartIndex + 3]);
        assertEquals(squares[face][1][1], colors[colorStartIndex + 4]);
        assertEquals(squares[face][1][2], colors[colorStartIndex + 5]);
        assertEquals(squares[face][2][0], colors[colorStartIndex + 6]);
        assertEquals(squares[face][2][1], colors[colorStartIndex + 7]);
        assertEquals(squares[face][2][2], colors[colorStartIndex + 8]);
    }
}
