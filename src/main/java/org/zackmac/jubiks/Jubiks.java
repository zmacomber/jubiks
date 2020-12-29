package org.zackmac.jubiks;

import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.zackmac.jubiks.Color.*;

public class Jubiks {

    // Based on online reading, it should take a max of 20 moves to solve any 3 x 3 x 3 rubiks cube
    static final byte MAX_MOVES_NEEDED_TO_SOLVE = 20;

    static final long MAX_ATTEMPTS = 1000000;

    static Logger logger = Logger.getGlobal();

    public static void main(String[] args) {
        Cube cube = null;

        long attempts = 0;

        int previousFace = 0;

        while ((attempts < MAX_ATTEMPTS) && ((cube == null) || ( ! cube.isSolved()))) {

            attempts++;

            logger.log(Level.INFO, "Attempt {0}", attempts);

            cube = new Cube(
                new Face(ORANGE, YELLOW, YELLOW, WHITE, GREEN, RED, GREEN, RED, BLUE),
                new Face(GREEN, WHITE, ORANGE, YELLOW, RED, WHITE, RED, GREEN, BLUE),
                new Face(WHITE, ORANGE, BLUE, RED, BLUE, GREEN, ORANGE, BLUE, YELLOW),
                new Face(RED, GREEN, WHITE, RED, ORANGE, BLUE, GREEN, GREEN, RED),
                new Face(YELLOW, YELLOW, BLUE, YELLOW, WHITE, ORANGE, GREEN, BLUE, ORANGE),
                new Face(WHITE, BLUE, WHITE, ORANGE, YELLOW, WHITE, RED, ORANGE, YELLOW)
            );

            StringBuilder sb = new StringBuilder();

            for (int x = 1; x <= MAX_MOVES_NEEDED_TO_SOLVE; x++) {
                // Get a random face (0 - 5 which is front, right, back, left, top & bottom)
                // and rotation (0 - 2 which is clockwise, counter clockwise or flip)
                int randomFace = getRandomInt(5);
                int randomRotation = getRandomInt(2);

                if ((x > 1) && (randomFace == previousFace)) {
                    while (randomFace == previousFace) {
                        randomFace = getRandomInt(5);
                    }
                }

                previousFace = randomFace;

                // Rotate using the chosen face and rotation
                if ((randomFace == 0) && (randomRotation == 0)) {
                    sb.append("FrontClockwise ");
                    cube.rotateFrontClockwise();
                } else if ((randomFace == 0) && (randomRotation == 1)) {
                    sb.append("FrontCounterClockwise ");
                    cube.rotateFrontCounterClockwise();
                } else if ((randomFace == 0) && (randomRotation == 2)) {
                    sb.append("FrontFlip ");
                    cube.rotateFrontFlip();
                } else if ((randomFace == 1) && (randomRotation == 0)) {
                    sb.append("RightClockwise ");
                    cube.rotateRightClockwise();
                } else if ((randomFace == 1) && (randomRotation == 1)) {
                    sb.append("RightCounterClockwise ");
                    cube.rotateRightCounterClockwise();
                } else if ((randomFace == 1) && (randomRotation == 2)) {
                    sb.append("RightFlip ");
                    cube.rotateRightFlip();
                } else if ((randomFace == 2) && (randomRotation == 0)) {
                    sb.append("BackClockwise ");
                    cube.rotateBackClockwise();
                } else if ((randomFace == 2) && (randomRotation == 1)) {
                    sb.append("BackCounterClockwise ");
                    cube.rotateBackCounterClockwise();
                } else if ((randomFace == 2) && (randomRotation == 2)) {
                    sb.append("BackFlip ");
                    cube.rotateBackFlip();
                } else if ((randomFace == 3) && (randomRotation == 0)) {
                    sb.append("LeftClockwise ");
                    cube.rotateLeftClockwise();
                } else if ((randomFace == 3) && (randomRotation == 1)) {
                    sb.append("LeftCounterClockwise ");
                    cube.rotateLeftCounterClockwise();
                } else if ((randomFace == 3) && (randomRotation == 2)) {
                    sb.append("LeftFlip ");
                    cube.rotateLeftFlip();
                } else if ((randomFace == 4) && (randomRotation == 0)) {
                    sb.append("TopClockwise ");
                    cube.rotateTopClockwise();
                } else if ((randomFace == 4) && (randomRotation == 1)) {
                    sb.append("TopCounterClockwise ");
                    cube.rotateTopCounterClockwise();
                } else if ((randomFace == 4) && (randomRotation == 2)) {
                    sb.append("TopFlip ");
                    cube.rotateTopFlip();
                } else if ((randomFace == 5) && (randomRotation == 0)) {
                    sb.append("BottomClockwise ");
                    cube.rotateBottomClockwise();
                } else if ((randomFace == 5) && (randomRotation == 1)) {
                    sb.append("BottomCounterClockwise ");
                    cube.rotateBottomCounterClockwise();
                } else if ((randomFace == 5) && (randomRotation == 2)) {
                    sb.append("BottomFlip ");
                    cube.rotateBottomFlip();
                }

                // Have we solved this cube yet???
                if (cube.isSolved()) {
                    logger.log(Level.INFO, "Cube is solved in {0} attempts!", attempts);
                    logger.log(Level.INFO, "Use these rotations to solve: {0}", sb);
                }
            }
        }

        if ( ! cube.isSolved()) {
            logger.log(Level.WARNING, "Did not solve the cube in {0} attempts", MAX_ATTEMPTS);
        }
    }

    static int getRandomInt(int max) {
        return ThreadLocalRandom.current().nextInt(0, max + 1);
    }
}
