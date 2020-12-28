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
    public void testOldStaysOldAndNewStaysNew() {
        Cube oldCube = new Cube(
            new Face(WHITE, WHITE, WHITE, WHITE, WHITE, WHITE, WHITE, WHITE, WHITE),
            new Face(WHITE, WHITE, WHITE, WHITE, WHITE, WHITE, WHITE, WHITE, WHITE),
            new Face(WHITE, WHITE, WHITE, WHITE, WHITE, WHITE, WHITE, WHITE, WHITE),
            new Face(WHITE, WHITE, WHITE, WHITE, WHITE, WHITE, WHITE, WHITE, WHITE),
            new Face(WHITE, WHITE, WHITE, WHITE, WHITE, WHITE, WHITE, WHITE, WHITE),
            new Face(WHITE, WHITE, WHITE, WHITE, WHITE, WHITE, WHITE, WHITE, WHITE)
        );

        Cube newCube = new Cube(oldCube);
        newCube.getFront().setTopRight(GREEN);

        assertEquals(oldCube.getFront().getTopRight(), WHITE);
        assertEquals(newCube.getFront().getTopRight(), GREEN);
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

    @Test
    public void shouldRotateRightClockwise() {
        Cube expectedCube = new Cube(
            new Face(ORANGE, YELLOW, WHITE, WHITE, GREEN, WHITE, GREEN, RED, YELLOW),
            new Face(RED, YELLOW, GREEN, GREEN, RED, WHITE, BLUE, WHITE, ORANGE),
            new Face(ORANGE, ORANGE, BLUE, ORANGE, BLUE, GREEN, BLUE, BLUE, YELLOW),
            new Face(RED, GREEN, WHITE, RED, ORANGE, BLUE, GREEN, GREEN, RED),
            new Face(YELLOW, YELLOW, YELLOW, YELLOW, WHITE, RED, GREEN, BLUE, BLUE),
            new Face(WHITE, BLUE, ORANGE, ORANGE, YELLOW, RED, RED, ORANGE, WHITE)
        );

        testCube.rotateRightClockwise();

        checkFaces(expectedCube);
    }

    @Test
    public void shouldRotateRightCounterClockwise() {
        Cube expectedCube = new Cube(
            new Face(ORANGE, YELLOW, BLUE, WHITE, GREEN, ORANGE, GREEN, RED, ORANGE),
            new Face(ORANGE, WHITE, BLUE, WHITE, RED, GREEN, GREEN, YELLOW, RED),
            new Face(YELLOW, ORANGE, BLUE, WHITE, BLUE, GREEN, WHITE, BLUE, YELLOW),
            new Face(RED, GREEN, WHITE, RED, ORANGE, BLUE, GREEN, GREEN, RED),
            new Face(YELLOW, YELLOW, ORANGE, YELLOW, WHITE, RED, GREEN, BLUE, WHITE),
            new Face(WHITE, BLUE, YELLOW, ORANGE, YELLOW, RED, RED, ORANGE, BLUE)
        );

        testCube.rotateRightCounterClockwise();

        checkFaces(expectedCube);
    }

    @Test
    public void shouldRotateRightFlip() {
        Cube expectedCube = new Cube(
            new Face(ORANGE, YELLOW, ORANGE, WHITE, GREEN, RED, GREEN, RED, WHITE),
            new Face(BLUE, GREEN, RED, WHITE, RED, YELLOW, ORANGE, WHITE, GREEN),
            new Face(BLUE, ORANGE, BLUE, RED, BLUE, GREEN, YELLOW, BLUE, YELLOW),
            new Face(RED, GREEN, WHITE, RED, ORANGE, BLUE, GREEN, GREEN, RED),
            new Face(YELLOW, YELLOW, WHITE, YELLOW, WHITE, WHITE, GREEN, BLUE, YELLOW),
            new Face(WHITE, BLUE, BLUE, ORANGE, YELLOW, ORANGE, RED, ORANGE, ORANGE)
        );

        testCube.rotateRightFlip();

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
