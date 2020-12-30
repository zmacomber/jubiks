package org.zackmac.jubiks;

import java.util.Arrays;
import java.util.StringJoiner;

import static org.zackmac.jubiks.Color.*;

public final class Cube {

    private static final byte NUM_SQUARES = 9;

    private final byte[] front;
    private final byte[] right;
    private final byte[] back;
    private final byte[] left;
    private final byte[] top;
    private final byte[] bottom;

    public Cube(byte[] front, byte[] right, byte[] back, byte[] left, byte[] top, byte[] bottom) {
        this.front = makeSureNotNull(front, "front");
        this.right = makeSureNotNull(right, "right");
        this.back = makeSureNotNull(back, "back");
        this.left = makeSureNotNull(left, "left");
        this.top = makeSureNotNull(top, "top");
        this.bottom = makeSureNotNull(bottom, "bottom");
    }

    private byte[] makeSureNotNull(byte[] face, String location) {
        if (face == null) {
            throw new IllegalArgumentException(location + " face must not be null");
        }
        return face;
    }

    public Cube(Cube oldCube) {
        this.front = copy(oldCube.front);
        this.right = copy(oldCube.right);
        this.back = copy(oldCube.back);
        this.left = copy(oldCube.left);
        this.top = copy(oldCube.top);
        this.bottom = copy(oldCube.bottom);
    }

    private byte[] copy(byte[] oldFace) {
        byte[] newFace = new byte[NUM_SQUARES];
        System.arraycopy(oldFace, 0, newFace, 0, NUM_SQUARES);
        return newFace;
    }

    public void rotateFrontClockwise() {
        byte[] oldFront = copy(this.front);
        byte[] oldRight = copy(this.right);
        byte[] oldLeft = copy(this.left);
        byte[] oldTop = copy(this.top);
        byte[] oldBottom = copy(this.bottom);

        front[0] = oldFront[6];
        front[1] = oldFront[3];
        front[2] = oldFront[0];
        front[3] = oldFront[7];
        front[5] = oldFront[1];
        front[6] = oldFront[8];
        front[7] = oldFront[5];
        front[8] = oldFront[2];

        right[0] = oldTop[6];
        right[3] = oldTop[7];
        right[6] = oldTop[8];

        left[2] = oldBottom[0];
        left[5] = oldBottom[1];
        left[8] = oldBottom[2];

        top[6] = oldLeft[8];
        top[7] = oldLeft[5];
        top[8] = oldLeft[2];

        bottom[0] = oldRight[6];
        bottom[1] = oldRight[3];
        bottom[2] = oldRight[0];
    }

    public void rotateFrontCounterClockwise() {
        byte[] oldFront = copy(this.front);
        byte[] oldRight = copy(this.right);
        byte[] oldLeft = copy(this.left);
        byte[] oldTop = copy(this.top);
        byte[] oldBottom = copy(this.bottom);

        front[0] = oldFront[2];
        front[1] = oldFront[5];
        front[2] = oldFront[8];
        front[3] = oldFront[1];
        front[5] = oldFront[7];
        front[6] = oldFront[0];
        front[7] = oldFront[3];
        front[8] = oldFront[6];

        right[0] = oldBottom[2];
        right[3] = oldBottom[1];
        right[6] = oldBottom[0];

        left[2] = oldTop[8];
        left[5] = oldTop[7];
        left[8] = oldTop[6];

        top[6] = oldRight[0];
        top[7] = oldRight[3];
        top[8] = oldRight[6];

        bottom[0] = oldLeft[2];
        bottom[1] = oldLeft[5];
        bottom[2] = oldLeft[8];
    }

    public void rotateFrontFlip() {
        byte[] oldFront = copy(this.front);
        byte[] oldRight = copy(this.right);
        byte[] oldLeft = copy(this.left);
        byte[] oldTop = copy(this.top);
        byte[] oldBottom = copy(this.bottom);

        front[0] = oldFront[8];
        front[1] = oldFront[7];
        front[2] = oldFront[6];
        front[3] = oldFront[5];
        front[5] = oldFront[3];
        front[6] = oldFront[2];
        front[7] = oldFront[1];
        front[8] = oldFront[0];

        right[0] = oldLeft[8];
        right[3] = oldLeft[5];
        right[6] = oldLeft[2];

        left[2] = oldRight[6];
        left[5] = oldRight[3];
        left[8] = oldRight[0];

        top[6] = oldBottom[2];
        top[7] = oldBottom[1];
        top[8] = oldBottom[0];

        bottom[0] = oldTop[8];
        bottom[1] = oldTop[7];
        bottom[2] = oldTop[6];
    }

    public void rotateRightClockwise() {
        byte[] oldRight = copy(this.right);
        byte[] oldBack = copy(this.back);
        byte[] oldFront = copy(this.front);
        byte[] oldTop = copy(this.top);
        byte[] oldBottom = copy(this.bottom);

        right[0] = oldRight[6];
        right[1] = oldRight[3];
        right[2] = oldRight[0];
        right[3] = oldRight[7];
        right[5] = oldRight[1];
        right[6] = oldRight[8];
        right[7] = oldRight[5];
        right[8] = oldRight[2];

        back[0] = oldTop[8];
        back[3] = oldTop[5];
        back[6] = oldTop[2];

        front[2] = oldBottom[2];
        front[5] = oldBottom[5];
        front[8] = oldBottom[8];

        top[8] = oldFront[8];
        top[5] = oldFront[5];
        top[2] = oldFront[2];

        bottom[2] = oldBack[6];
        bottom[5] = oldBack[3];
        bottom[8] = oldBack[0];
    }

    public void rotateRightCounterClockwise() {
        byte[] oldRight = copy(this.right);
        byte[] oldBack = copy(this.back);
        byte[] oldFront = copy(this.front);
        byte[] oldTop = copy(this.top);
        byte[] oldBottom = copy(this.bottom);

        right[0] = oldRight[2];
        right[1] = oldRight[5];
        right[2] = oldRight[8];
        right[3] = oldRight[1];
        right[5] = oldRight[7];
        right[6] = oldRight[0];
        right[7] = oldRight[3];
        right[8] = oldRight[6];

        back[0] = oldBottom[8];
        back[3] = oldBottom[5];
        back[6] = oldBottom[2];

        front[2] = oldTop[2];
        front[5] = oldTop[5];
        front[8] = oldTop[8];

        top[8] = oldBack[0];
        top[5] = oldBack[3];
        top[2] = oldBack[6];

        bottom[2] = oldFront[2];
        bottom[5] = oldFront[5];
        bottom[8] = oldFront[8];
    }

    public void rotateRightFlip() {
        byte[] oldRight = copy(this.right);
        byte[] oldBack = copy(this.back);
        byte[] oldFront = copy(this.front);
        byte[] oldTop = copy(this.top);
        byte[] oldBottom = copy(this.bottom);

        right[0] = oldRight[8];
        right[1] = oldRight[7];
        right[2] = oldRight[6];
        right[3] = oldRight[5];
        right[5] = oldRight[3];
        right[6] = oldRight[2];
        right[7] = oldRight[1];
        right[8] = oldRight[0];

        back[0] = oldFront[8];
        back[3] = oldFront[5];
        back[6] = oldFront[2];

        front[2] = oldBack[6];
        front[5] = oldBack[3];
        front[8] = oldBack[0];

        top[8] = oldBottom[8];
        top[5] = oldBottom[5];
        top[2] = oldBottom[2];

        bottom[2] = oldTop[2];
        bottom[5] = oldTop[5];
        bottom[8] = oldTop[8];
    }

    public void rotateBackClockwise() {
        byte[] oldBack = copy(this.back);
        byte[] oldLeft = copy(this.left);
        byte[] oldRight = copy(this.right);
        byte[] oldTop = copy(this.top);
        byte[] oldBottom = copy(this.bottom);

        back[0] = oldBack[6];
        back[1] = oldBack[3];
        back[2] = oldBack[0];
        back[3] = oldBack[7];
        back[5] = oldBack[1];
        back[6] = oldBack[8];
        back[7] = oldBack[5];
        back[8] = oldBack[2];

        left[0] = oldTop[2];
        left[3] = oldTop[1];
        left[6] = oldTop[0];

        right[2] = oldBottom[8];
        right[5] = oldBottom[7];
        right[8] = oldBottom[6];

        top[0] = oldRight[2];
        top[1] = oldRight[5];
        top[2] = oldRight[8];

        bottom[6] = oldLeft[0];
        bottom[7] = oldLeft[3];
        bottom[8] = oldLeft[6];
    }

    public void rotateBackCounterClockwise() {
        byte[] oldBack = copy(this.back);
        byte[] oldLeft = copy(this.left);
        byte[] oldRight = copy(this.right);
        byte[] oldTop = copy(this.top);
        byte[] oldBottom = copy(this.bottom);

        back[0] = oldBack[2];
        back[1] = oldBack[5];
        back[2] = oldBack[8];
        back[3] = oldBack[1];
        back[5] = oldBack[7];
        back[6] = oldBack[0];
        back[7] = oldBack[3];
        back[8] = oldBack[6];

        left[0] = oldBottom[6];
        left[3] = oldBottom[7];
        left[6] = oldBottom[8];

        right[2] = oldTop[0];
        right[5] = oldTop[1];
        right[8] = oldTop[2];

        top[0] = oldLeft[6];
        top[1] = oldLeft[3];
        top[2] = oldLeft[0];

        bottom[6] = oldRight[8];
        bottom[7] = oldRight[5];
        bottom[8] = oldRight[2];
    }

    public void rotateBackFlip() {
        byte[] oldBack = copy(this.back);
        byte[] oldLeft = copy(this.left);
        byte[] oldRight = copy(this.right);
        byte[] oldTop = copy(this.top);
        byte[] oldBottom = copy(this.bottom);

        back[0] = oldBack[8];
        back[1] = oldBack[7];
        back[2] = oldBack[6];
        back[3] = oldBack[5];
        back[5] = oldBack[3];
        back[6] = oldBack[2];
        back[7] = oldBack[1];
        back[8] = oldBack[0];

        left[0] = oldRight[8];
        left[3] = oldRight[5];
        left[6] = oldRight[2];

        right[2] = oldLeft[6];
        right[5] = oldLeft[3];
        right[8] = oldLeft[0];

        top[0] = oldBottom[8];
        top[1] = oldBottom[7];
        top[2] = oldBottom[6];

        bottom[6] = oldTop[2];
        bottom[7] = oldTop[1];
        bottom[8] = oldTop[0];
    }

    public void rotateLeftClockwise() {
        byte[] oldLeft = copy(this.left);
        byte[] oldFront = copy(this.front);
        byte[] oldBack = copy(this.back);
        byte[] oldTop = copy(this.top);
        byte[] oldBottom = copy(this.bottom);

        left[0] = oldLeft[6];
        left[1] = oldLeft[3];
        left[2] = oldLeft[0];
        left[3] = oldLeft[7];
        left[5] = oldLeft[1];
        left[6] = oldLeft[8];
        left[7] = oldLeft[5];
        left[8] = oldLeft[2];

        front[0] = oldTop[0];
        front[3] = oldTop[3];
        front[6] = oldTop[6];

        back[2] = oldBottom[6];
        back[5] = oldBottom[3];
        back[8] = oldBottom[0];

        top[0] = oldBack[8];
        top[3] = oldBack[5];
        top[6] = oldBack[2];

        bottom[0] = oldFront[0];
        bottom[3] = oldFront[3];
        bottom[6] = oldFront[6];
    }

    public void rotateLeftCounterClockwise() {
        byte[] oldLeft = copy(this.left);
        byte[] oldFront = copy(this.front);
        byte[] oldBack = copy(this.back);
        byte[] oldTop = copy(this.top);
        byte[] oldBottom = copy(this.bottom);

        left[0] = oldLeft[2];
        left[1] = oldLeft[5];
        left[2] = oldLeft[8];
        left[3] = oldLeft[1];
        left[5] = oldLeft[7];
        left[6] = oldLeft[0];
        left[7] = oldLeft[3];
        left[8] = oldLeft[6];

        front[0] = oldBottom[0];
        front[3] = oldBottom[3];
        front[6] = oldBottom[6];

        back[2] = oldTop[6];
        back[5] = oldTop[3];
        back[8] = oldTop[0];

        top[0] = oldFront[0];
        top[3] = oldFront[3];
        top[6] = oldFront[6];

        bottom[0] = oldBack[8];
        bottom[3] = oldBack[5];
        bottom[6] = oldBack[2];
    }

    public void rotateLeftFlip() {
        byte[] oldLeft = copy(this.left);
        byte[] oldFront = copy(this.front);
        byte[] oldBack = copy(this.back);
        byte[] oldTop = copy(this.top);
        byte[] oldBottom = copy(this.bottom);

        left[0] = oldLeft[8];
        left[1] = oldLeft[7];
        left[2] = oldLeft[6];
        left[3] = oldLeft[5];
        left[5] = oldLeft[3];
        left[6] = oldLeft[2];
        left[7] = oldLeft[1];
        left[8] = oldLeft[0];

        front[0] = oldBack[8];
        front[3] = oldBack[5];
        front[6] = oldBack[2];

        back[2] = oldFront[6];
        back[5] = oldFront[3];
        back[8] = oldFront[0];

        top[0] = oldBottom[0];
        top[3] = oldBottom[3];
        top[6] = oldBottom[6];

        bottom[0] = oldTop[0];
        bottom[3] = oldTop[3];
        bottom[6] = oldTop[6];
    }

    public void rotateTopClockwise() {
        byte[] oldTop = copy(this.top);
        byte[] oldFront = copy(this.front);
        byte[] oldRight = copy(this.right);
        byte[] oldBack = copy(this.back);
        byte[] oldLeft = copy(this.left);

        top[0] = oldTop[6];
        top[1] = oldTop[3];
        top[2] = oldTop[0];
        top[3] = oldTop[7];
        top[5] = oldTop[1];
        top[6] = oldTop[8];
        top[7] = oldTop[5];
        top[8] = oldTop[2];

        front[0] = oldRight[0];
        front[1] = oldRight[1];
        front[2] = oldRight[2];

        right[0] = oldBack[0];
        right[1] = oldBack[1];
        right[2] = oldBack[2];

        back[0] = oldLeft[0];
        back[1] = oldLeft[1];
        back[2] = oldLeft[2];

        left[0] = oldFront[0];
        left[1] = oldFront[1];
        left[2] = oldFront[2];
    }

    public void rotateTopCounterClockwise() {
        byte[] oldTop = copy(this.top);
        byte[] oldFront = copy(this.front);
        byte[] oldRight = copy(this.right);
        byte[] oldBack = copy(this.back);
        byte[] oldLeft = copy(this.left);

        top[0] = oldTop[2];
        top[1] = oldTop[5];
        top[2] = oldTop[8];
        top[3] = oldTop[1];
        top[5] = oldTop[7];
        top[6] = oldTop[0];
        top[7] = oldTop[3];
        top[8] = oldTop[6];

        front[0] = oldLeft[0];
        front[1] = oldLeft[1];
        front[2] = oldLeft[2];

        right[0] = oldFront[0];
        right[1] = oldFront[1];
        right[2] = oldFront[2];

        back[0] = oldRight[0];
        back[1] = oldRight[1];
        back[2] = oldRight[2];

        left[0] = oldBack[0];
        left[1] = oldBack[1];
        left[2] = oldBack[2];
    }

    public void rotateTopFlip() {
        byte[] oldTop = copy(this.top);
        byte[] oldFront = copy(this.front);
        byte[] oldRight = copy(this.right);
        byte[] oldBack = copy(this.back);
        byte[] oldLeft = copy(this.left);

        top[0] = oldTop[8];
        top[1] = oldTop[7];
        top[2] = oldTop[6];
        top[3] = oldTop[5];
        top[5] = oldTop[3];
        top[6] = oldTop[2];
        top[7] = oldTop[1];
        top[8] = oldTop[0];

        front[0] = oldBack[0];
        front[1] = oldBack[1];
        front[2] = oldBack[2];

        right[0] = oldLeft[0];
        right[1] = oldLeft[1];
        right[2] = oldLeft[2];

        back[0] = oldFront[0];
        back[1] = oldFront[1];
        back[2] = oldFront[2];

        left[0] = oldRight[0];
        left[1] = oldRight[1];
        left[2] = oldRight[2];
    }

    public void rotateBottomClockwise() {
        byte[] oldBottom = copy(this.bottom);
        byte[] oldFront = copy(this.front);
        byte[] oldRight = copy(this.right);
        byte[] oldBack = copy(this.back);
        byte[] oldLeft = copy(this.left);

        bottom[0] = oldBottom[6];
        bottom[1] = oldBottom[3];
        bottom[2] = oldBottom[0];
        bottom[3] = oldBottom[7];
        bottom[5] = oldBottom[1];
        bottom[6] = oldBottom[8];
        bottom[7] = oldBottom[5];
        bottom[8] = oldBottom[2];

        front[6] = oldLeft[6];
        front[7] = oldLeft[7];
        front[8] = oldLeft[8];

        right[6] = oldFront[6];
        right[7] = oldFront[7];
        right[8] = oldFront[8];

        back[6] = oldRight[6];
        back[7] = oldRight[7];
        back[8] = oldRight[8];

        left[6] = oldBack[6];
        left[7] = oldBack[7];
        left[8] = oldBack[8];
    }

    public void rotateBottomCounterClockwise() {
        byte[] oldBottom = copy(this.bottom);
        byte[] oldFront = copy(this.front);
        byte[] oldRight = copy(this.right);
        byte[] oldBack = copy(this.back);
        byte[] oldLeft = copy(this.left);

        bottom[0] = oldBottom[2];
        bottom[1] = oldBottom[5];
        bottom[2] = oldBottom[8];
        bottom[3] = oldBottom[1];
        bottom[5] = oldBottom[7];
        bottom[6] = oldBottom[0];
        bottom[7] = oldBottom[3];
        bottom[8] = oldBottom[6];

        front[6] = oldRight[6];
        front[7] = oldRight[7];
        front[8] = oldRight[8];

        right[6] = oldBack[6];
        right[7] = oldBack[7];
        right[8] = oldBack[8];

        back[6] = oldLeft[6];
        back[7] = oldLeft[7];
        back[8] = oldLeft[8];

        left[6] = oldFront[6];
        left[7] = oldFront[7];
        left[8] = oldFront[8];
    }

    public void rotateBottomFlip() {
        byte[] oldBottom = copy(this.bottom);
        byte[] oldFront = copy(this.front);
        byte[] oldRight = copy(this.right);
        byte[] oldBack = copy(this.back);
        byte[] oldLeft = copy(this.left);

        bottom[0] = oldBottom[8];
        bottom[1] = oldBottom[7];
        bottom[2] = oldBottom[6];
        bottom[3] = oldBottom[5];
        bottom[5] = oldBottom[3];
        bottom[6] = oldBottom[2];
        bottom[7] = oldBottom[1];
        bottom[8] = oldBottom[0];

        front[6] = oldBack[6];
        front[7] = oldBack[7];
        front[8] = oldBack[8];

        right[6] = oldLeft[6];
        right[7] = oldLeft[7];
        right[8] = oldLeft[8];

        back[6] = oldFront[6];
        back[7] = oldFront[7];
        back[8] = oldFront[8];

        left[6] = oldRight[6];
        left[7] = oldRight[7];
        left[8] = oldRight[8];
    }

    public boolean isSolved() {
        for (byte x = 0; x < NUM_SQUARES; x++) {
            if ((front[x] != GREEN) || (right[x] != RED) || (back[x] != BLUE) ||
                (left[x] != ORANGE) || (top[x] != WHITE) || (bottom[x] != YELLOW)) {

                return false;

            }
        }
        return true;
    }

    public byte[] getFront() {
        return front;
    }

    public byte[] getRight() {
        return right;
    }

    public byte[] getBack() {
        return back;
    }

    public byte[] getLeft() {
        return left;
    }

    public byte[] getTop() {
        return top;
    }

    public byte[] getBottom() {
        return bottom;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cube that = (Cube) o;
        return Arrays.equals(front, that.front) && Arrays.equals(right, that.right) && Arrays.equals(back, that.back) &&
                Arrays.equals(left, that.left) && Arrays.equals(top, that.top) && Arrays.equals(bottom, that.bottom);
    }

    @Override
    public int hashCode() {
        int result = Arrays.hashCode(front);
        result = 31 * result + Arrays.hashCode(right);
        result = 31 * result + Arrays.hashCode(back);
        result = 31 * result + Arrays.hashCode(left);
        result = 31 * result + Arrays.hashCode(top);
        result = 31 * result + Arrays.hashCode(bottom);
        return result;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Cube.class.getSimpleName() + "[", "]")
                .add("front=" + Arrays.toString(front))
                .add("right=" + Arrays.toString(right))
                .add("back=" + Arrays.toString(back))
                .add("left=" + Arrays.toString(left))
                .add("top=" + Arrays.toString(top))
                .add("bottom=" + Arrays.toString(bottom))
                .toString();
    }
}
