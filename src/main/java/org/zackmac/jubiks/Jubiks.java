package org.zackmac.jubiks;

import java.util.concurrent.ThreadLocalRandom;

import static org.zackmac.jubiks.Color.*;

public class Jubiks {

    // Based on online reading, it should take a max of 20 moves to solve any 3 x 3 x 3 rubiks cube
    static final byte MAX_MOVES_NEEDED_TO_SOLVE = 20;

    public static void main(String[] args) {
        Cube cube = new Cube(
            new Face(ORANGE, YELLOW, YELLOW, WHITE, GREEN, RED, GREEN, RED, BLUE),
            new Face(GREEN, WHITE, ORANGE, YELLOW, RED, WHITE, RED, GREEN, BLUE),
            new Face(WHITE, ORANGE, BLUE, RED, BLUE, GREEN, ORANGE, BLUE, YELLOW),
            new Face(RED, GREEN, WHITE, RED, ORANGE, BLUE, GREEN, GREEN, RED),
            new Face(YELLOW, YELLOW, BLUE, YELLOW, WHITE, ORANGE, GREEN, BLUE, ORANGE),
            new Face(WHITE, BLUE, WHITE, ORANGE, YELLOW, WHITE, RED, ORANGE, YELLOW)
        );

        long attempts = 1;

        while (attempts < Long.MAX_VALUE) {
            // Get a random face (0 - 5 which is front, right, back, left, top & bottom)
            // and rotation (0 - 2 which is clockwise, counter clockwise or flip)
            int randomFace = getRandomInt(0, 5);
            int randomRotation = getRandomInt(0, 2);

            // Rotate using the chosen face and rotation
            if ((randomFace == 0) && (randomRotation == 0)) {
                cube.rotateFrontClockwise();
            } else if ((randomFace == 0) && (randomRotation == 1)) {
                cube.rotateFrontCounterClockwise();
            } else if ((randomFace == 0) && (randomRotation == 2)) {
                cube.rotateFrontFlip();
            } else if ((randomFace == 1) && (randomRotation == 0)) {
                cube.rotateRightClockwise();
            } else if ((randomFace == 1) && (randomRotation == 1)) {
                cube.rotateRightCounterClockwise();
            } else if ((randomFace == 1) && (randomRotation == 2)) {
                cube.rotateRightFlip();
            } else if ((randomFace == 2) && (randomRotation == 0)) {
                cube.rotateBackClockwise();
            } else if ((randomFace == 2) && (randomRotation == 1)) {
                cube.rotateBackCounterClockwise();
            } else if ((randomFace == 2) && (randomRotation == 2)) {
                cube.rotateBackFlip();
            } else if ((randomFace == 3) && (randomRotation == 0)) {
                cube.rotateLeftClockwise();
            } else if ((randomFace == 3) && (randomRotation == 1)) {
                cube.rotateLeftCounterClockwise();
            } else if ((randomFace == 3) && (randomRotation == 2)) {
                cube.rotateLeftFlip();
            } else if ((randomFace == 4) && (randomRotation == 0)) {
                cube.rotateTopClockwise();
            } else if ((randomFace == 4) && (randomRotation == 1)) {
                cube.rotateTopCounterClockwise();
            } else if ((randomFace == 4) && (randomRotation == 2)) {
                cube.rotateTopFlip();
            } else if ((randomFace == 5) && (randomRotation == 0)) {
                cube.rotateBottomClockwise();
            } else if ((randomFace == 5) && (randomRotation == 1)) {
                cube.rotateBottomCounterClockwise();
            } else if ((randomFace == 5) && (randomRotation == 2)) {
                cube.rotateBottomFlip();
            }

            attempts++;

        }

        System.out.println("Didn't solve the cube in " + Long.MAX_VALUE + " attempts");
    }

    static int getRandomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }
}
