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

    @Test
    public void shouldRotateBackClockwise() {
        Cube expectedCube = new Cube(
            new Face(ORANGE, YELLOW, YELLOW, WHITE, GREEN, RED, GREEN, RED, BLUE),
            new Face(GREEN, WHITE, YELLOW, YELLOW, RED, ORANGE, RED, GREEN, RED),
            new Face(ORANGE, RED, WHITE, BLUE, BLUE, ORANGE, YELLOW, GREEN, BLUE),
            new Face(BLUE, GREEN, WHITE, YELLOW, ORANGE, BLUE, YELLOW, GREEN, RED),
            new Face(ORANGE, WHITE, BLUE, YELLOW, WHITE, ORANGE, GREEN, BLUE, ORANGE),
            new Face(WHITE, BLUE, WHITE, ORANGE, YELLOW, WHITE, RED, RED, GREEN)
        );

        testCube.rotateBackClockwise();

        checkFaces(expectedCube);
    }

    @Test
    public void shouldRotateBackCounterClockwise() {
        Cube expectedCube = new Cube(
            new Face(ORANGE, YELLOW, YELLOW, WHITE, GREEN, RED, GREEN, RED, BLUE),
            new Face(GREEN, WHITE, YELLOW, YELLOW, RED, YELLOW, RED, GREEN, BLUE),
            new Face(BLUE, GREEN, YELLOW, ORANGE, BLUE, BLUE, WHITE, RED, ORANGE),
            new Face(RED, GREEN, WHITE, ORANGE, ORANGE, BLUE, YELLOW, GREEN, RED),
            new Face(GREEN, RED, RED, YELLOW, WHITE, ORANGE, GREEN, BLUE, ORANGE),
            new Face(WHITE, BLUE, WHITE, ORANGE, YELLOW, WHITE, BLUE, WHITE, ORANGE)
        );

        testCube.rotateBackCounterClockwise();

        checkFaces(expectedCube);
    }

    @Test
    public void shouldRotateBackFlip() {
        Cube expectedCube = new Cube(
            new Face(ORANGE, YELLOW, YELLOW, WHITE, GREEN, RED, GREEN, RED, BLUE),
            new Face(GREEN, WHITE, GREEN, YELLOW, RED, RED, RED, GREEN, RED),
            new Face(YELLOW, BLUE, ORANGE, GREEN, BLUE, RED, BLUE, ORANGE, WHITE),
            new Face(BLUE, GREEN, WHITE, WHITE, ORANGE, BLUE, ORANGE, GREEN, RED),
            new Face(YELLOW, ORANGE, RED, YELLOW, WHITE, ORANGE, GREEN, BLUE, ORANGE),
            new Face(WHITE, BLUE, WHITE, ORANGE, YELLOW, WHITE, BLUE, YELLOW, YELLOW)
        );

        testCube.rotateBackFlip();

        checkFaces(expectedCube);
    }

    @Test
    public void shouldRotateLeftClockwise() {
        Cube expectedCube = new Cube(
            new Face(YELLOW, YELLOW, YELLOW, YELLOW, GREEN, RED, GREEN, RED, BLUE),
            new Face(GREEN, WHITE, ORANGE, YELLOW, RED, WHITE, RED, GREEN, BLUE),
            new Face(WHITE, ORANGE, RED, RED, BLUE, ORANGE, ORANGE, BLUE, WHITE),
            new Face(GREEN, RED, RED, GREEN, ORANGE, GREEN, RED, BLUE, WHITE),
            new Face(YELLOW, YELLOW, BLUE, GREEN, WHITE, ORANGE, BLUE, BLUE, ORANGE),
            new Face(ORANGE, BLUE, WHITE, WHITE, YELLOW, WHITE, GREEN, ORANGE, YELLOW)
        );

        testCube.rotateLeftClockwise();

        checkFaces(expectedCube);
    }

    @Test
    public void shouldRotateLeftCounterClockwise() {
        Cube expectedCube = new Cube(
            new Face(WHITE, YELLOW, YELLOW, ORANGE, GREEN, RED, RED, RED, BLUE),
            new Face(GREEN, WHITE, ORANGE, YELLOW, RED, WHITE, RED, GREEN, BLUE),
            new Face(WHITE, ORANGE, GREEN, RED, BLUE, YELLOW, ORANGE, BLUE, YELLOW),
            new Face(WHITE, BLUE, RED, GREEN, ORANGE, GREEN, RED, RED, GREEN),
            new Face(ORANGE, YELLOW, BLUE, WHITE, WHITE, ORANGE, GREEN, BLUE, ORANGE),
            new Face(YELLOW, BLUE, WHITE, GREEN, YELLOW, WHITE, BLUE, ORANGE, YELLOW)
        );

        testCube.rotateLeftCounterClockwise();

        checkFaces(expectedCube);
    }

    @Test
    public void shouldRotateLeftFlip() {
        Cube expectedCube = new Cube(
            new Face(YELLOW, YELLOW, YELLOW, GREEN, GREEN, RED, BLUE, RED, BLUE),
            new Face(GREEN, WHITE, ORANGE, YELLOW, RED, WHITE, RED, GREEN, BLUE),
            new Face(WHITE, ORANGE, GREEN, RED, BLUE, WHITE, ORANGE, BLUE, ORANGE),
            new Face(RED, GREEN, GREEN, BLUE, ORANGE, RED, WHITE, GREEN, RED),
            new Face(WHITE, YELLOW, BLUE, ORANGE, WHITE, ORANGE, RED, BLUE, ORANGE),
            new Face(YELLOW, BLUE, WHITE, YELLOW, YELLOW, WHITE, GREEN, ORANGE, YELLOW)
        );

        testCube.rotateLeftFlip();

        checkFaces(expectedCube);
    }

    @Test
    public void shouldRotateTopClockwise() {
        Cube expectedCube = new Cube(
            new Face(GREEN, WHITE, ORANGE, WHITE, GREEN, RED, GREEN, RED, BLUE),
            new Face(WHITE, ORANGE, BLUE, YELLOW, RED, WHITE, RED, GREEN, BLUE),
            new Face(RED, GREEN, WHITE, RED, BLUE, GREEN, ORANGE, BLUE, YELLOW),
            new Face(ORANGE, YELLOW, YELLOW, RED, ORANGE, BLUE, GREEN, GREEN, RED),
            new Face(GREEN, YELLOW, YELLOW, BLUE, WHITE, YELLOW, ORANGE, ORANGE, BLUE),
            new Face(WHITE, BLUE, WHITE, ORANGE, YELLOW, WHITE, RED, ORANGE, YELLOW)
        );

        testCube.rotateTopClockwise();

        checkFaces(expectedCube);
    }

    @Test
    public void shouldRotateTopCounterClockwise() {
        Cube expectedCube = new Cube(
            new Face(RED, GREEN, WHITE, WHITE, GREEN, RED, GREEN, RED, BLUE),
            new Face(ORANGE, YELLOW, YELLOW, YELLOW, RED, WHITE, RED, GREEN, BLUE),
            new Face(GREEN, WHITE, ORANGE, RED, BLUE, GREEN, ORANGE, BLUE, YELLOW),
            new Face(WHITE, ORANGE, BLUE, RED, ORANGE, BLUE, GREEN, GREEN, RED),
            new Face(BLUE, ORANGE, ORANGE, YELLOW, WHITE, BLUE, YELLOW, YELLOW, GREEN),
            new Face(WHITE, BLUE, WHITE, ORANGE, YELLOW, WHITE, RED, ORANGE, YELLOW)
        );

        testCube.rotateTopCounterClockwise();

        checkFaces(expectedCube);
    }

    @Test
    public void shouldRotateTopFlip() {
        Cube expectedCube = new Cube(
            new Face(WHITE, ORANGE, BLUE, WHITE, GREEN, RED, GREEN, RED, BLUE),
            new Face(RED, GREEN, WHITE, YELLOW, RED, WHITE, RED, GREEN, BLUE),
            new Face(ORANGE, YELLOW, YELLOW, RED, BLUE, GREEN, ORANGE, BLUE, YELLOW),
            new Face(GREEN, WHITE, ORANGE, RED, ORANGE, BLUE, GREEN, GREEN, RED),
            new Face(ORANGE, BLUE, GREEN, ORANGE, WHITE, YELLOW, BLUE, YELLOW, YELLOW),
            new Face(WHITE, BLUE, WHITE, ORANGE, YELLOW, WHITE, RED, ORANGE, YELLOW)
        );

        testCube.rotateTopFlip();

        checkFaces(expectedCube);
    }

    @Test
    public void shouldRotateBottomClockwise() {
        Cube expectedCube = new Cube(
            new Face(ORANGE, YELLOW, YELLOW, WHITE, GREEN, RED, GREEN, GREEN, RED),
            new Face(GREEN, WHITE, ORANGE, YELLOW, RED, WHITE, GREEN, RED, BLUE),
            new Face(WHITE, ORANGE, BLUE, RED, BLUE, GREEN, RED, GREEN, BLUE),
            new Face(RED, GREEN, WHITE, RED, ORANGE, BLUE, ORANGE, BLUE, YELLOW),
            new Face(YELLOW, YELLOW, BLUE, YELLOW, WHITE, ORANGE, GREEN, BLUE, ORANGE),
            new Face(RED, ORANGE, WHITE, ORANGE, YELLOW, BLUE, YELLOW, WHITE, WHITE)
        );

        testCube.rotateBottomClockwise();

        checkFaces(expectedCube);
    }

    @Test
    public void shouldRotateBottomCounterClockwise() {
        Cube expectedCube = new Cube(
            new Face(ORANGE, YELLOW, YELLOW, WHITE, GREEN, RED, RED, GREEN, BLUE),
            new Face(GREEN, WHITE, ORANGE, YELLOW, RED, WHITE, ORANGE, BLUE, YELLOW),
            new Face(WHITE, ORANGE, BLUE, RED, BLUE, GREEN, GREEN, GREEN, RED),
            new Face(RED, GREEN, WHITE, RED, ORANGE, BLUE, GREEN, RED, BLUE),
            new Face(YELLOW, YELLOW, BLUE, YELLOW, WHITE, ORANGE, GREEN, BLUE, ORANGE),
            new Face(WHITE, WHITE, YELLOW, BLUE, YELLOW, ORANGE, WHITE, ORANGE, RED)
        );

        testCube.rotateBottomCounterClockwise();

        checkFaces(expectedCube);
    }

    @Test
    public void shouldRotateBottomFlip() {
        Cube expectedCube = new Cube(
            new Face(ORANGE, YELLOW, YELLOW, WHITE, GREEN, RED, ORANGE, BLUE, YELLOW),
            new Face(GREEN, WHITE, ORANGE, YELLOW, RED, WHITE, GREEN, GREEN, RED),
            new Face(WHITE, ORANGE, BLUE, RED, BLUE, GREEN, GREEN, RED, BLUE),
            new Face(RED, GREEN, WHITE, RED, ORANGE, BLUE, RED, GREEN, BLUE),
            new Face(YELLOW, YELLOW, BLUE, YELLOW, WHITE, ORANGE, GREEN, BLUE, ORANGE),
            new Face(YELLOW, ORANGE, RED, WHITE, YELLOW, ORANGE, WHITE, BLUE, WHITE)
        );

        testCube.rotateBottomFlip();

        checkFaces(expectedCube);
    }

    @Test
    public void shouldBeSolvedCube() {
        assertTrue(
            new Cube(
                new Face(GREEN, GREEN, GREEN, GREEN, GREEN, GREEN, GREEN, GREEN, GREEN),
                new Face(RED, RED, RED, RED, RED, RED, RED, RED, RED),
                new Face(BLUE, BLUE, BLUE, BLUE, BLUE, BLUE, BLUE, BLUE, BLUE),
                new Face(ORANGE, ORANGE, ORANGE, ORANGE, ORANGE, ORANGE, ORANGE, ORANGE, ORANGE),
                new Face(WHITE, WHITE, WHITE, WHITE, WHITE, WHITE, WHITE, WHITE, WHITE),
                new Face(YELLOW, YELLOW, YELLOW, YELLOW, YELLOW, YELLOW, YELLOW, YELLOW, YELLOW)
            ).isSolved()
        );
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
