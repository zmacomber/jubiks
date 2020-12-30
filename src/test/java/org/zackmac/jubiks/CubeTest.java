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
            new byte[] { ORANGE, YELLOW, YELLOW, WHITE, GREEN, RED, GREEN, RED, BLUE },
            new byte[] { GREEN, WHITE, ORANGE, YELLOW, RED, WHITE, RED, GREEN, BLUE },
            new byte[] { WHITE, ORANGE, BLUE, RED, BLUE, GREEN, ORANGE, BLUE, YELLOW },
            new byte[] { RED, GREEN, WHITE, RED, ORANGE, BLUE, GREEN, GREEN, RED },
            new byte[] { YELLOW, YELLOW, BLUE, YELLOW, WHITE, ORANGE, GREEN, BLUE, ORANGE },
            new byte[] { WHITE, BLUE, WHITE, ORANGE, YELLOW, WHITE, RED, ORANGE, YELLOW }
        );
    }

    @Test
    public void testOldStaysOldAndNewStaysNew() {
        Cube oldCube = new Cube(
            new byte[] { WHITE, WHITE, WHITE, WHITE, WHITE, WHITE, WHITE, WHITE, WHITE },
            new byte[] { WHITE, WHITE, WHITE, WHITE, WHITE, WHITE, WHITE, WHITE, WHITE },
            new byte[] { WHITE, WHITE, WHITE, WHITE, WHITE, WHITE, WHITE, WHITE, WHITE },
            new byte[] { WHITE, WHITE, WHITE, WHITE, WHITE, WHITE, WHITE, WHITE, WHITE },
            new byte[] { WHITE, WHITE, WHITE, WHITE, WHITE, WHITE, WHITE, WHITE, WHITE },
            new byte[] { WHITE, WHITE, WHITE, WHITE, WHITE, WHITE, WHITE, WHITE, WHITE }
        );

        Cube newCube = new Cube(oldCube);
        newCube.getFront()[2] = GREEN;

        assertEquals(oldCube.getFront()[2], WHITE);
        assertEquals(newCube.getFront()[2], GREEN);
    }

    @Test
    public void shouldRotateFrontClockwise() {
        Cube expectedCube = new Cube(
            new byte[] { GREEN, WHITE, ORANGE, RED, GREEN, YELLOW, BLUE, RED, YELLOW },
            new byte[] { GREEN, WHITE, ORANGE, BLUE, RED, WHITE, ORANGE, GREEN, BLUE },
            new byte[] { WHITE, ORANGE, BLUE, RED, BLUE, GREEN, ORANGE, BLUE, YELLOW },
            new byte[] { RED, GREEN, WHITE, RED, ORANGE, BLUE, GREEN, GREEN, WHITE },
            new byte[] { YELLOW, YELLOW, BLUE, YELLOW, WHITE, ORANGE, RED, BLUE, WHITE },
            new byte[] { RED, YELLOW, GREEN, ORANGE, YELLOW, WHITE, RED, ORANGE, YELLOW }
        );

        testCube.rotateFrontClockwise();

        checkFaces(expectedCube);
    }

    @Test
    public void shouldRotateFrontCounterClockwise() {
        Cube expectedCube = new Cube(
            new byte[] { YELLOW, RED, BLUE, YELLOW, GREEN, RED, ORANGE, WHITE, GREEN },
            new byte[] { WHITE, WHITE, ORANGE, BLUE, RED, WHITE, WHITE, GREEN, BLUE },
            new byte[] { WHITE, ORANGE, BLUE, RED, BLUE, GREEN, ORANGE, BLUE, YELLOW },
            new byte[] { RED, GREEN, ORANGE, RED, ORANGE, BLUE, GREEN, GREEN, GREEN },
            new byte[] { YELLOW, YELLOW, BLUE, YELLOW, WHITE, ORANGE, GREEN, YELLOW, RED },
            new byte[] { WHITE, BLUE, RED, ORANGE, YELLOW, WHITE, RED, ORANGE, YELLOW }
        );

        testCube.rotateFrontCounterClockwise();

        checkFaces(expectedCube);
    }

    @Test
    public void shouldRotateFrontFlip() {
        Cube expectedCube = new Cube(
            new byte[] { BLUE, RED, GREEN, RED, GREEN, WHITE, YELLOW, YELLOW, ORANGE },
            new byte[] { RED, WHITE, ORANGE, BLUE, RED, WHITE, WHITE, GREEN, BLUE },
            new byte[] { WHITE, ORANGE, BLUE, RED, BLUE, GREEN, ORANGE, BLUE, YELLOW },
            new byte[] { RED, GREEN, RED, RED, ORANGE, YELLOW, GREEN, GREEN, GREEN },
            new byte[] { YELLOW, YELLOW, BLUE, YELLOW, WHITE, ORANGE, WHITE, BLUE, WHITE },
            new byte[] { ORANGE, BLUE, GREEN, ORANGE, YELLOW, WHITE, RED, ORANGE, YELLOW }
        );

        testCube.rotateFrontFlip();

        checkFaces(expectedCube);
    }

    @Test
    public void shouldRotateRightClockwise() {
        Cube expectedCube = new Cube(
            new byte[] { ORANGE, YELLOW, WHITE, WHITE, GREEN, WHITE, GREEN, RED, YELLOW },
            new byte[] { RED, YELLOW, GREEN, GREEN, RED, WHITE, BLUE, WHITE, ORANGE },
            new byte[] { ORANGE, ORANGE, BLUE, ORANGE, BLUE, GREEN, BLUE, BLUE, YELLOW },
            new byte[] { RED, GREEN, WHITE, RED, ORANGE, BLUE, GREEN, GREEN, RED },
            new byte[] { YELLOW, YELLOW, YELLOW, YELLOW, WHITE, RED, GREEN, BLUE, BLUE },
            new byte[] { WHITE, BLUE, ORANGE, ORANGE, YELLOW, RED, RED, ORANGE, WHITE }
        );

        testCube.rotateRightClockwise();

        checkFaces(expectedCube);
    }

    @Test
    public void shouldRotateRightCounterClockwise() {
        Cube expectedCube = new Cube(
            new byte[] { ORANGE, YELLOW, BLUE, WHITE, GREEN, ORANGE, GREEN, RED, ORANGE },
            new byte[] { ORANGE, WHITE, BLUE, WHITE, RED, GREEN, GREEN, YELLOW, RED },
            new byte[] { YELLOW, ORANGE, BLUE, WHITE, BLUE, GREEN, WHITE, BLUE, YELLOW },
            new byte[] { RED, GREEN, WHITE, RED, ORANGE, BLUE, GREEN, GREEN, RED },
            new byte[] { YELLOW, YELLOW, ORANGE, YELLOW, WHITE, RED, GREEN, BLUE, WHITE },
            new byte[] { WHITE, BLUE, YELLOW, ORANGE, YELLOW, RED, RED, ORANGE, BLUE }
        );

        testCube.rotateRightCounterClockwise();

        checkFaces(expectedCube);
    }

    @Test
    public void shouldRotateRightFlip() {
        Cube expectedCube = new Cube(
            new byte[] { ORANGE, YELLOW, ORANGE, WHITE, GREEN, RED, GREEN, RED, WHITE },
            new byte[] { BLUE, GREEN, RED, WHITE, RED, YELLOW, ORANGE, WHITE, GREEN },
            new byte[] { BLUE, ORANGE, BLUE, RED, BLUE, GREEN, YELLOW, BLUE, YELLOW },
            new byte[] { RED, GREEN, WHITE, RED, ORANGE, BLUE, GREEN, GREEN, RED },
            new byte[] { YELLOW, YELLOW, WHITE, YELLOW, WHITE, WHITE, GREEN, BLUE, YELLOW },
            new byte[] { WHITE, BLUE, BLUE, ORANGE, YELLOW, ORANGE, RED, ORANGE, ORANGE }
        );

        testCube.rotateRightFlip();

        checkFaces(expectedCube);
    }

    @Test
    public void shouldRotateBackClockwise() {
        Cube expectedCube = new Cube(
            new byte[] { ORANGE, YELLOW, YELLOW, WHITE, GREEN, RED, GREEN, RED, BLUE },
            new byte[] { GREEN, WHITE, YELLOW, YELLOW, RED, ORANGE, RED, GREEN, RED },
            new byte[] { ORANGE, RED, WHITE, BLUE, BLUE, ORANGE, YELLOW, GREEN, BLUE },
            new byte[] { BLUE, GREEN, WHITE, YELLOW, ORANGE, BLUE, YELLOW, GREEN, RED },
            new byte[] { ORANGE, WHITE, BLUE, YELLOW, WHITE, ORANGE, GREEN, BLUE, ORANGE },
            new byte[] { WHITE, BLUE, WHITE, ORANGE, YELLOW, WHITE, RED, RED, GREEN }
        );

        testCube.rotateBackClockwise();

        checkFaces(expectedCube);
    }

    @Test
    public void shouldRotateBackCounterClockwise() {
        Cube expectedCube = new Cube(
            new byte[] { ORANGE, YELLOW, YELLOW, WHITE, GREEN, RED, GREEN, RED, BLUE },
            new byte[] { GREEN, WHITE, YELLOW, YELLOW, RED, YELLOW, RED, GREEN, BLUE },
            new byte[] { BLUE, GREEN, YELLOW, ORANGE, BLUE, BLUE, WHITE, RED, ORANGE },
            new byte[] { RED, GREEN, WHITE, ORANGE, ORANGE, BLUE, YELLOW, GREEN, RED },
            new byte[] { GREEN, RED, RED, YELLOW, WHITE, ORANGE, GREEN, BLUE, ORANGE },
            new byte[] { WHITE, BLUE, WHITE, ORANGE, YELLOW, WHITE, BLUE, WHITE, ORANGE }
        );

        testCube.rotateBackCounterClockwise();

        checkFaces(expectedCube);
    }

    @Test
    public void shouldRotateBackFlip() {
        Cube expectedCube = new Cube(
            new byte[] { ORANGE, YELLOW, YELLOW, WHITE, GREEN, RED, GREEN, RED, BLUE },
            new byte[] { GREEN, WHITE, GREEN, YELLOW, RED, RED, RED, GREEN, RED },
            new byte[] { YELLOW, BLUE, ORANGE, GREEN, BLUE, RED, BLUE, ORANGE, WHITE },
            new byte[] { BLUE, GREEN, WHITE, WHITE, ORANGE, BLUE, ORANGE, GREEN, RED },
            new byte[] { YELLOW, ORANGE, RED, YELLOW, WHITE, ORANGE, GREEN, BLUE, ORANGE },
            new byte[] { WHITE, BLUE, WHITE, ORANGE, YELLOW, WHITE, BLUE, YELLOW, YELLOW }
        );

        testCube.rotateBackFlip();

        checkFaces(expectedCube);
    }

    @Test
    public void shouldRotateLeftClockwise() {
        Cube expectedCube = new Cube(
            new byte[] { YELLOW, YELLOW, YELLOW, YELLOW, GREEN, RED, GREEN, RED, BLUE },
            new byte[] { GREEN, WHITE, ORANGE, YELLOW, RED, WHITE, RED, GREEN, BLUE },
            new byte[] { WHITE, ORANGE, RED, RED, BLUE, ORANGE, ORANGE, BLUE, WHITE },
            new byte[] { GREEN, RED, RED, GREEN, ORANGE, GREEN, RED, BLUE, WHITE },
            new byte[] { YELLOW, YELLOW, BLUE, GREEN, WHITE, ORANGE, BLUE, BLUE, ORANGE },
            new byte[] { ORANGE, BLUE, WHITE, WHITE, YELLOW, WHITE, GREEN, ORANGE, YELLOW }
        );

        testCube.rotateLeftClockwise();

        checkFaces(expectedCube);
    }

    @Test
    public void shouldRotateLeftCounterClockwise() {
        Cube expectedCube = new Cube(
            new byte[] { WHITE, YELLOW, YELLOW, ORANGE, GREEN, RED, RED, RED, BLUE },
            new byte[] { GREEN, WHITE, ORANGE, YELLOW, RED, WHITE, RED, GREEN, BLUE },
            new byte[] { WHITE, ORANGE, GREEN, RED, BLUE, YELLOW, ORANGE, BLUE, YELLOW },
            new byte[] { WHITE, BLUE, RED, GREEN, ORANGE, GREEN, RED, RED, GREEN },
            new byte[] { ORANGE, YELLOW, BLUE, WHITE, WHITE, ORANGE, GREEN, BLUE, ORANGE },
            new byte[] { YELLOW, BLUE, WHITE, GREEN, YELLOW, WHITE, BLUE, ORANGE, YELLOW }
        );

        testCube.rotateLeftCounterClockwise();

        checkFaces(expectedCube);
    }

    @Test
    public void shouldRotateLeftFlip() {
        Cube expectedCube = new Cube(
            new byte[] { YELLOW, YELLOW, YELLOW, GREEN, GREEN, RED, BLUE, RED, BLUE },
            new byte[] { GREEN, WHITE, ORANGE, YELLOW, RED, WHITE, RED, GREEN, BLUE },
            new byte[] { WHITE, ORANGE, GREEN, RED, BLUE, WHITE, ORANGE, BLUE, ORANGE },
            new byte[] { RED, GREEN, GREEN, BLUE, ORANGE, RED, WHITE, GREEN, RED },
            new byte[] { WHITE, YELLOW, BLUE, ORANGE, WHITE, ORANGE, RED, BLUE, ORANGE },
            new byte[] { YELLOW, BLUE, WHITE, YELLOW, YELLOW, WHITE, GREEN, ORANGE, YELLOW }
        );

        testCube.rotateLeftFlip();

        checkFaces(expectedCube);
    }

    @Test
    public void shouldRotateTopClockwise() {
        Cube expectedCube = new Cube(
            new byte[] { GREEN, WHITE, ORANGE, WHITE, GREEN, RED, GREEN, RED, BLUE },
            new byte[] { WHITE, ORANGE, BLUE, YELLOW, RED, WHITE, RED, GREEN, BLUE },
            new byte[] { RED, GREEN, WHITE, RED, BLUE, GREEN, ORANGE, BLUE, YELLOW },
            new byte[] { ORANGE, YELLOW, YELLOW, RED, ORANGE, BLUE, GREEN, GREEN, RED },
            new byte[] { GREEN, YELLOW, YELLOW, BLUE, WHITE, YELLOW, ORANGE, ORANGE, BLUE },
            new byte[] { WHITE, BLUE, WHITE, ORANGE, YELLOW, WHITE, RED, ORANGE, YELLOW }
        );

        testCube.rotateTopClockwise();

        checkFaces(expectedCube);
    }

    @Test
    public void shouldRotateTopCounterClockwise() {
        Cube expectedCube = new Cube(
            new byte[] { RED, GREEN, WHITE, WHITE, GREEN, RED, GREEN, RED, BLUE },
            new byte[] { ORANGE, YELLOW, YELLOW, YELLOW, RED, WHITE, RED, GREEN, BLUE },
            new byte[] { GREEN, WHITE, ORANGE, RED, BLUE, GREEN, ORANGE, BLUE, YELLOW },
            new byte[] { WHITE, ORANGE, BLUE, RED, ORANGE, BLUE, GREEN, GREEN, RED },
            new byte[] { BLUE, ORANGE, ORANGE, YELLOW, WHITE, BLUE, YELLOW, YELLOW, GREEN },
            new byte[] { WHITE, BLUE, WHITE, ORANGE, YELLOW, WHITE, RED, ORANGE, YELLOW }
        );

        testCube.rotateTopCounterClockwise();

        checkFaces(expectedCube);
    }

    @Test
    public void shouldRotateTopFlip() {
        Cube expectedCube = new Cube(
            new byte[] { WHITE, ORANGE, BLUE, WHITE, GREEN, RED, GREEN, RED, BLUE },
            new byte[] { RED, GREEN, WHITE, YELLOW, RED, WHITE, RED, GREEN, BLUE },
            new byte[] { ORANGE, YELLOW, YELLOW, RED, BLUE, GREEN, ORANGE, BLUE, YELLOW },
            new byte[] { GREEN, WHITE, ORANGE, RED, ORANGE, BLUE, GREEN, GREEN, RED },
            new byte[] { ORANGE, BLUE, GREEN, ORANGE, WHITE, YELLOW, BLUE, YELLOW, YELLOW },
            new byte[] { WHITE, BLUE, WHITE, ORANGE, YELLOW, WHITE, RED, ORANGE, YELLOW }
        );

        testCube.rotateTopFlip();

        checkFaces(expectedCube);
    }

    @Test
    public void shouldRotateBottomClockwise() {
        Cube expectedCube = new Cube(
            new byte[] { ORANGE, YELLOW, YELLOW, WHITE, GREEN, RED, GREEN, GREEN, RED },
            new byte[] { GREEN, WHITE, ORANGE, YELLOW, RED, WHITE, GREEN, RED, BLUE },
            new byte[] { WHITE, ORANGE, BLUE, RED, BLUE, GREEN, RED, GREEN, BLUE },
            new byte[] { RED, GREEN, WHITE, RED, ORANGE, BLUE, ORANGE, BLUE, YELLOW },
            new byte[] { YELLOW, YELLOW, BLUE, YELLOW, WHITE, ORANGE, GREEN, BLUE, ORANGE },
            new byte[] { RED, ORANGE, WHITE, ORANGE, YELLOW, BLUE, YELLOW, WHITE, WHITE }
        );

        testCube.rotateBottomClockwise();

        checkFaces(expectedCube);
    }

    @Test
    public void shouldRotateBottomCounterClockwise() {
        Cube expectedCube = new Cube(
            new byte[] { ORANGE, YELLOW, YELLOW, WHITE, GREEN, RED, RED, GREEN, BLUE },
            new byte[] { GREEN, WHITE, ORANGE, YELLOW, RED, WHITE, ORANGE, BLUE, YELLOW },
            new byte[] { WHITE, ORANGE, BLUE, RED, BLUE, GREEN, GREEN, GREEN, RED },
            new byte[] { RED, GREEN, WHITE, RED, ORANGE, BLUE, GREEN, RED, BLUE },
            new byte[] { YELLOW, YELLOW, BLUE, YELLOW, WHITE, ORANGE, GREEN, BLUE, ORANGE },
            new byte[] { WHITE, WHITE, YELLOW, BLUE, YELLOW, ORANGE, WHITE, ORANGE, RED }
        );

        testCube.rotateBottomCounterClockwise();

        checkFaces(expectedCube);
    }

    @Test
    public void shouldRotateBottomFlip() {
        Cube expectedCube = new Cube(
            new byte[] { ORANGE, YELLOW, YELLOW, WHITE, GREEN, RED, ORANGE, BLUE, YELLOW },
            new byte[] { GREEN, WHITE, ORANGE, YELLOW, RED, WHITE, GREEN, GREEN, RED },
            new byte[] { WHITE, ORANGE, BLUE, RED, BLUE, GREEN, GREEN, RED, BLUE },
            new byte[] { RED, GREEN, WHITE, RED, ORANGE, BLUE, RED, GREEN, BLUE },
            new byte[] { YELLOW, YELLOW, BLUE, YELLOW, WHITE, ORANGE, GREEN, BLUE, ORANGE },
            new byte[] { YELLOW, ORANGE, RED, WHITE, YELLOW, ORANGE, WHITE, BLUE, WHITE }
        );

        testCube.rotateBottomFlip();

        checkFaces(expectedCube);
    }

    @Test
    public void shouldBeSolvedCube() {
        assertTrue(
            new Cube(
                new byte[] { GREEN, GREEN, GREEN, GREEN, GREEN, GREEN, GREEN, GREEN, GREEN },
                new byte[] { RED, RED, RED, RED, RED, RED, RED, RED, RED },
                new byte[] { BLUE, BLUE, BLUE, BLUE, BLUE, BLUE, BLUE, BLUE, BLUE },
                new byte[] { ORANGE, ORANGE, ORANGE, ORANGE, ORANGE, ORANGE, ORANGE, ORANGE, ORANGE },
                new byte[] { WHITE, WHITE, WHITE, WHITE, WHITE, WHITE, WHITE, WHITE, WHITE },
                new byte[] { YELLOW, YELLOW, YELLOW, YELLOW, YELLOW, YELLOW, YELLOW, YELLOW, YELLOW }
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
