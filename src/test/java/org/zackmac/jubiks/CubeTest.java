package org.zackmac.jubiks;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;
import static org.zackmac.jubiks.Color.*;

public class CubeTest {

    private Cube testCube;

    @BeforeMethod
    public void setupBeforeTest() {
        testCube = new Cube(
            new Face(ORANGE, YELLOW, YELLOW, WHITE, GREEN, RED, GREEN, RED, BLUE),
            new Face(GREEN, WHITE, ORANGE, YELLOW, RED, WHITE, RED, GREEN, BLUE),
            new Face(WHITE, ORANGE, BLUE, RED, BLUE, GREEN, ORANGE, BLUE, YELLOW),
            new Face(RED, GREEN, WHITE, RED, ORANGE, BLUE, GREEN, GREEN, RED),
            new Face(YELLOW, YELLOW, BLUE, YELLOW, WHITE, ORANGE, GREEN, BLUE, ORANGE),
            new Face(WHITE, BLUE, WHITE, ORANGE, YELLOW, WHITE, RED, ORANGE, YELLOW)
        );
    }

    @Test
    public void shouldRotateFrontClockwise() {
        Cube expectedCube = new Cube(
            new Face(GREEN, WHITE, ORANGE, RED, GREEN, YELLOW, BLUE, RED, YELLOW),
            new Face(GREEN, WHITE, ORANGE, BLUE, RED, WHITE, ORANGE, GREEN, BLUE),
            new Face(WHITE, ORANGE, BLUE, RED, BLUE, GREEN, ORANGE, BLUE, YELLOW),
            new Face(RED, GREEN, WHITE, RED, ORANGE, BLUE, GREEN, GREEN, WHITE),
            new Face(YELLOW, YELLOW, BLUE, YELLOW, WHITE, ORANGE, RED, BLUE, WHITE),
            new Face(RED, YELLOW, GREEN, ORANGE, YELLOW, WHITE, RED, ORANGE, YELLOW)
        );

        testCube.rotateFrontClockwise();

        checkFaces(expectedCube);
    }

    @Test
    public void shouldRotateFrontCounterClockwise() {
        Cube expectedCube = new Cube(
            new Face(YELLOW, RED, BLUE, YELLOW, GREEN, RED, ORANGE, WHITE, GREEN),
            new Face(WHITE, WHITE, ORANGE, BLUE, RED, WHITE, WHITE, GREEN, BLUE),
            new Face(WHITE, ORANGE, BLUE, RED, BLUE, GREEN, ORANGE, BLUE, YELLOW),
            new Face(RED, GREEN, ORANGE, RED, ORANGE, BLUE, GREEN, GREEN, GREEN),
            new Face(YELLOW, YELLOW, BLUE, YELLOW, WHITE, ORANGE, GREEN, YELLOW, RED),
            new Face(WHITE, BLUE, RED, ORANGE, YELLOW, WHITE, RED, ORANGE, YELLOW)
        );

        testCube.rotateFrontCounterClockwise();

        checkFaces(expectedCube);
    }

    @Test
    public void shouldRotateFrontFlip() {
        Cube expectedCube = new Cube(
            new Face(BLUE, RED, GREEN, RED, GREEN, WHITE, YELLOW, YELLOW, ORANGE),
            new Face(RED, WHITE, ORANGE, BLUE, RED, WHITE, WHITE, GREEN, BLUE),
            new Face(WHITE, ORANGE, BLUE, RED, BLUE, GREEN, ORANGE, BLUE, YELLOW),
            new Face(RED, GREEN, RED, RED, ORANGE, YELLOW, GREEN, GREEN, GREEN),
            new Face(YELLOW, YELLOW, BLUE, YELLOW, WHITE, ORANGE, WHITE, BLUE, WHITE),
            new Face(ORANGE, BLUE, GREEN, ORANGE, YELLOW, WHITE, RED, ORANGE, YELLOW)
        );

        testCube.rotateFrontFlip();

        checkFaces(expectedCube);
    }

    private void checkFaces(Cube expectedCube) {
        assertEquals(testCube.getFront(), expectedCube.getFront(), "Front faces don't equal");
        assertEquals(testCube.getRight(), expectedCube.getRight(), "Right faces don't equal");
        assertEquals(testCube.getBack(), expectedCube.getBack(), "Back faces don't equal");
        assertEquals(testCube.getLeft(), expectedCube.getLeft(), "Left faces don't equal");
        assertEquals(testCube.getTop(), expectedCube.getTop(), "Top faces don't equal");
        assertEquals(testCube.getBottom(), expectedCube.getBottom(), "Bottom faces don't equal");
    }
}
