package org.zackmac.jubiks;

import java.util.Objects;
import java.util.StringJoiner;

public final class Cube {

    private final Face front;
    private final Face right;
    private final Face back;
    private final Face left;
    private final Face top;
    private final Face bottom;

    public Cube(Face front, Face right, Face back, Face left, Face top, Face bottom) {
        this.front = makeSureNotNull(front, "front");
        this.right = makeSureNotNull(right, "right");
        this.back = makeSureNotNull(back, "back");
        this.left = makeSureNotNull(left, "left");
        this.top = makeSureNotNull(top, "top");
        this.bottom = makeSureNotNull(bottom, "bottom");
    }

    private Face makeSureNotNull(Face face, String location) {
        if (face == null) {
            throw new IllegalArgumentException(location + " face must not be null");
        }
        return face;
    }

    public Cube(Cube oldCube) {
        this.front = new Face(oldCube.front);
        this.right = new Face(oldCube.right);
        this.back = new Face(oldCube.back);
        this.left = new Face(oldCube.left);
        this.top = new Face(oldCube.top);
        this.bottom = new Face(oldCube.bottom);
    }

    public void rotateFrontClockwise() {
        Face oldFront = new Face(this.front);
        Face oldRight = new Face(this.right);
        Face oldLeft = new Face(this.left);
        Face oldTop = new Face(this.top);
        Face oldBottom = new Face(this.bottom);

        front.setTopLeft(oldFront.getBottomLeft());
        front.setTopMiddle(oldFront.getMiddleLeft());
        front.setTopRight(oldFront.getTopLeft());
        front.setMiddleLeft(oldFront.getBottomMiddle());
        front.setMiddleRight(oldFront.getTopMiddle());
        front.setBottomLeft(oldFront.getBottomRight());
        front.setBottomMiddle(oldFront.getMiddleRight());
        front.setBottomRight(oldFront.getTopRight());

        right.setTopLeft(oldTop.getBottomLeft());
        right.setMiddleLeft(oldTop.getBottomMiddle());
        right.setBottomLeft(oldTop.getBottomRight());

        left.setTopRight(oldBottom.getTopLeft());
        left.setMiddleRight(oldBottom.getTopMiddle());
        left.setBottomRight(oldBottom.getTopRight());

        top.setBottomLeft(oldLeft.getBottomRight());
        top.setBottomMiddle(oldLeft.getMiddleRight());
        top.setBottomRight(oldLeft.getTopRight());

        bottom.setTopLeft(oldRight.getBottomLeft());
        bottom.setTopMiddle(oldRight.getMiddleLeft());
        bottom.setTopRight(oldRight.getTopLeft());
    }

    public void rotateFrontCounterClockwise() {
        Face oldFront = new Face(this.front);
        Face oldRight = new Face(this.right);
        Face oldLeft = new Face(this.left);
        Face oldTop = new Face(this.top);
        Face oldBottom = new Face(this.bottom);

        front.setTopLeft(oldFront.getTopRight());
        front.setTopMiddle(oldFront.getMiddleRight());
        front.setTopRight(oldFront.getBottomRight());
        front.setMiddleLeft(oldFront.getTopMiddle());
        front.setMiddleRight(oldFront.getBottomMiddle());
        front.setBottomLeft(oldFront.getTopLeft());
        front.setBottomMiddle(oldFront.getMiddleLeft());
        front.setBottomRight(oldFront.getBottomLeft());

        right.setTopLeft(oldBottom.getTopRight());
        right.setMiddleLeft(oldBottom.getTopMiddle());
        right.setBottomLeft(oldBottom.getTopLeft());

        left.setTopRight(oldTop.getBottomRight());
        left.setMiddleRight(oldTop.getBottomMiddle());
        left.setBottomRight(oldTop.getBottomLeft());

        top.setBottomLeft(oldRight.getTopLeft());
        top.setBottomMiddle(oldRight.getMiddleLeft());
        top.setBottomRight(oldRight.getBottomLeft());

        bottom.setTopLeft(oldLeft.getTopRight());
        bottom.setTopMiddle(oldLeft.getMiddleRight());
        bottom.setTopRight(oldLeft.getBottomRight());
    }

    public void rotateFrontFlip() {
        Face oldFront = new Face(this.front);
        Face oldRight = new Face(this.right);
        Face oldLeft = new Face(this.left);
        Face oldTop = new Face(this.top);
        Face oldBottom = new Face(this.bottom);

        front.setTopLeft(oldFront.getBottomRight());
        front.setTopMiddle(oldFront.getBottomMiddle());
        front.setTopRight(oldFront.getBottomLeft());
        front.setMiddleLeft(oldFront.getMiddleRight());
        front.setMiddleRight(oldFront.getMiddleLeft());
        front.setBottomLeft(oldFront.getTopRight());
        front.setBottomMiddle(oldFront.getTopMiddle());
        front.setBottomRight(oldFront.getTopLeft());

        right.setTopLeft(oldLeft.getBottomRight());
        right.setMiddleLeft(oldLeft.getMiddleRight());
        right.setBottomLeft(oldLeft.getTopRight());

        left.setTopRight(oldRight.getBottomLeft());
        left.setMiddleRight(oldRight.getMiddleLeft());
        left.setBottomRight(oldRight.getTopLeft());

        top.setBottomLeft(oldBottom.getTopRight());
        top.setBottomMiddle(oldBottom.getTopMiddle());
        top.setBottomRight(oldBottom.getTopLeft());

        bottom.setTopLeft(oldTop.getBottomRight());
        bottom.setTopMiddle(oldTop.getBottomMiddle());
        bottom.setTopRight(oldTop.getBottomLeft());
    }

    public void rotateRightClockwise() {
        Face oldRight = new Face(this.right);
        Face oldBack = new Face(this.back);
        Face oldFront = new Face(this.front);
        Face oldTop = new Face(this.top);
        Face oldBottom = new Face(this.bottom);

        right.setTopLeft(oldRight.getBottomLeft());
        right.setTopMiddle(oldRight.getMiddleLeft());
        right.setTopRight(oldRight.getTopLeft());
        right.setMiddleLeft(oldRight.getBottomMiddle());
        right.setMiddleRight(oldRight.getTopMiddle());
        right.setBottomLeft(oldRight.getBottomRight());
        right.setBottomMiddle(oldRight.getMiddleRight());
        right.setBottomRight(oldRight.getTopRight());

        back.setTopLeft(oldTop.getBottomRight());
        back.setMiddleLeft(oldTop.getMiddleRight());
        back.setBottomLeft(oldTop.getTopRight());

        front.setTopRight(oldBottom.getTopRight());
        front.setMiddleRight(oldBottom.getMiddleRight());
        front.setBottomRight(oldBottom.getBottomRight());

        top.setBottomRight(oldFront.getBottomRight());
        top.setMiddleRight(oldFront.getMiddleRight());
        top.setTopRight(oldFront.getTopRight());

        bottom.setTopRight(oldBack.getBottomLeft());
        bottom.setMiddleRight(oldBack.getMiddleLeft());
        bottom.setBottomRight(oldBack.getTopLeft());
    }

    public void rotateRightCounterClockwise() {
        Face oldRight = new Face(this.right);
        Face oldBack = new Face(this.back);
        Face oldFront = new Face(this.front);
        Face oldTop = new Face(this.top);
        Face oldBottom = new Face(this.bottom);

        right.setTopLeft(oldRight.getTopRight());
        right.setTopMiddle(oldRight.getMiddleRight());
        right.setTopRight(oldRight.getBottomRight());
        right.setMiddleLeft(oldRight.getTopMiddle());
        right.setMiddleRight(oldRight.getBottomMiddle());
        right.setBottomLeft(oldRight.getTopLeft());
        right.setBottomMiddle(oldRight.getMiddleLeft());
        right.setBottomRight(oldRight.getBottomLeft());

        back.setTopLeft(oldBottom.getBottomRight());
        back.setMiddleLeft(oldBottom.getMiddleRight());
        back.setBottomLeft(oldBottom.getTopRight());

        front.setTopRight(oldTop.getTopRight());
        front.setMiddleRight(oldTop.getMiddleRight());
        front.setBottomRight(oldTop.getBottomRight());

        top.setBottomRight(oldBack.getTopLeft());
        top.setMiddleRight(oldBack.getMiddleLeft());
        top.setTopRight(oldBack.getBottomLeft());

        bottom.setTopRight(oldFront.getTopRight());
        bottom.setMiddleRight(oldFront.getMiddleRight());
        bottom.setBottomRight(oldFront.getBottomRight());
    }

    public void rotateRightFlip() {
        Face oldRight = new Face(this.right);
        Face oldBack = new Face(this.back);
        Face oldFront = new Face(this.front);
        Face oldTop = new Face(this.top);
        Face oldBottom = new Face(this.bottom);

        right.setTopLeft(oldRight.getBottomRight());
        right.setTopMiddle(oldRight.getBottomMiddle());
        right.setTopRight(oldRight.getBottomLeft());
        right.setMiddleLeft(oldRight.getMiddleRight());
        right.setMiddleRight(oldRight.getMiddleLeft());
        right.setBottomLeft(oldRight.getTopRight());
        right.setBottomMiddle(oldRight.getTopMiddle());
        right.setBottomRight(oldRight.getTopLeft());

        back.setTopLeft(oldFront.getBottomRight());
        back.setMiddleLeft(oldFront.getMiddleRight());
        back.setBottomLeft(oldFront.getTopRight());

        front.setTopRight(oldBack.getBottomLeft());
        front.setMiddleRight(oldBack.getMiddleLeft());
        front.setBottomRight(oldBack.getTopLeft());

        top.setBottomRight(oldBottom.getBottomRight());
        top.setMiddleRight(oldBottom.getMiddleRight());
        top.setTopRight(oldBottom.getTopRight());

        bottom.setTopRight(oldTop.getTopRight());
        bottom.setMiddleRight(oldTop.getMiddleRight());
        bottom.setBottomRight(oldTop.getBottomRight());
    }

    public void rotateBackClockwise() {
        Face oldBack = new Face(this.back);
        Face oldLeft = new Face(this.left);
        Face oldRight = new Face(this.right);
        Face oldTop = new Face(this.top);
        Face oldBottom = new Face(this.bottom);

        back.setTopLeft(oldBack.getBottomLeft());
        back.setTopMiddle(oldBack.getMiddleLeft());
        back.setTopRight(oldBack.getTopLeft());
        back.setMiddleLeft(oldBack.getBottomMiddle());
        back.setMiddleRight(oldBack.getTopMiddle());
        back.setBottomLeft(oldBack.getBottomRight());
        back.setBottomMiddle(oldBack.getMiddleRight());
        back.setBottomRight(oldBack.getTopRight());

        left.setTopLeft(oldTop.getTopRight());
        left.setMiddleLeft(oldTop.getTopMiddle());
        left.setBottomLeft(oldTop.getTopLeft());

        right.setTopRight(oldBottom.getBottomRight());
        right.setMiddleRight(oldBottom.getBottomMiddle());
        right.setBottomRight(oldBottom.getBottomLeft());

        top.setTopLeft(oldRight.getTopRight());
        top.setTopMiddle(oldRight.getMiddleRight());
        top.setTopRight(oldRight.getBottomRight());

        bottom.setBottomLeft(oldLeft.getTopLeft());
        bottom.setBottomMiddle(oldLeft.getMiddleLeft());
        bottom.setBottomRight(oldLeft.getBottomLeft());
    }

    public void rotateBackCounterClockwise() {
        Face oldBack = new Face(this.back);
        Face oldLeft = new Face(this.left);
        Face oldRight = new Face(this.right);
        Face oldTop = new Face(this.top);
        Face oldBottom = new Face(this.bottom);

        back.setTopLeft(oldBack.getTopRight());
        back.setTopMiddle(oldBack.getMiddleRight());
        back.setTopRight(oldBack.getBottomRight());
        back.setMiddleLeft(oldBack.getTopMiddle());
        back.setMiddleRight(oldBack.getBottomMiddle());
        back.setBottomLeft(oldBack.getTopLeft());
        back.setBottomMiddle(oldBack.getMiddleLeft());
        back.setBottomRight(oldBack.getBottomLeft());

        left.setTopLeft(oldBottom.getBottomLeft());
        left.setMiddleLeft(oldBottom.getBottomMiddle());
        left.setBottomLeft(oldBottom.getBottomRight());

        right.setTopRight(oldTop.getTopLeft());
        right.setMiddleRight(oldTop.getTopMiddle());
        right.setBottomRight(oldTop.getTopRight());

        top.setTopLeft(oldLeft.getBottomLeft());
        top.setTopMiddle(oldLeft.getMiddleLeft());
        top.setTopRight(oldLeft.getTopLeft());

        bottom.setBottomLeft(oldRight.getBottomRight());
        bottom.setBottomMiddle(oldRight.getMiddleRight());
        bottom.setBottomRight(oldRight.getTopRight());
    }

    public void rotateBackFlip() {
        Face oldBack = new Face(this.back);
        Face oldLeft = new Face(this.left);
        Face oldRight = new Face(this.right);
        Face oldTop = new Face(this.top);
        Face oldBottom = new Face(this.bottom);

        back.setTopLeft(oldBack.getBottomRight());
        back.setTopMiddle(oldBack.getBottomMiddle());
        back.setTopRight(oldBack.getBottomLeft());
        back.setMiddleLeft(oldBack.getMiddleRight());
        back.setMiddleRight(oldBack.getMiddleLeft());
        back.setBottomLeft(oldBack.getTopRight());
        back.setBottomMiddle(oldBack.getTopMiddle());
        back.setBottomRight(oldBack.getTopLeft());

        left.setTopLeft(oldRight.getBottomRight());
        left.setMiddleLeft(oldRight.getMiddleRight());
        left.setBottomLeft(oldRight.getTopRight());

        right.setTopRight(oldLeft.getBottomLeft());
        right.setMiddleRight(oldLeft.getMiddleLeft());
        right.setBottomRight(oldLeft.getTopLeft());

        top.setTopLeft(oldBottom.getBottomRight());
        top.setTopMiddle(oldBottom.getBottomMiddle());
        top.setTopRight(oldBottom.getBottomLeft());

        bottom.setBottomLeft(oldTop.getTopRight());
        bottom.setBottomMiddle(oldTop.getTopMiddle());
        bottom.setBottomRight(oldTop.getTopLeft());
    }

    public void rotateLeftClockwise() {
        Face oldLeft = new Face(this.left);
        Face oldFront = new Face(this.front);
        Face oldBack = new Face(this.back);
        Face oldTop = new Face(this.top);
        Face oldBottom = new Face(this.bottom);

        left.setTopLeft(oldLeft.getBottomLeft());
        left.setTopMiddle(oldLeft.getMiddleLeft());
        left.setTopRight(oldLeft.getTopLeft());
        left.setMiddleLeft(oldLeft.getBottomMiddle());
        left.setMiddleRight(oldLeft.getTopMiddle());
        left.setBottomLeft(oldLeft.getBottomRight());
        left.setBottomMiddle(oldLeft.getMiddleRight());
        left.setBottomRight(oldLeft.getTopRight());

        front.setTopLeft(oldTop.getTopLeft());
        front.setMiddleLeft(oldTop.getMiddleLeft());
        front.setBottomLeft(oldTop.getBottomLeft());

        back.setTopRight(oldBottom.getBottomLeft());
        back.setMiddleRight(oldBottom.getMiddleLeft());
        back.setBottomRight(oldBottom.getTopLeft());

        top.setTopLeft(oldBack.getBottomRight());
        top.setMiddleLeft(oldBack.getMiddleRight());
        top.setBottomLeft(oldBack.getTopRight());

        bottom.setTopLeft(oldFront.getTopLeft());
        bottom.setMiddleLeft(oldFront.getMiddleLeft());
        bottom.setBottomLeft(oldFront.getBottomLeft());
    }

    public void rotateLeftCounterClockwise() {
        Face oldLeft = new Face(this.left);
        Face oldFront = new Face(this.front);
        Face oldBack = new Face(this.back);
        Face oldTop = new Face(this.top);
        Face oldBottom = new Face(this.bottom);

        left.setTopLeft(oldLeft.getTopRight());
        left.setTopMiddle(oldLeft.getMiddleRight());
        left.setTopRight(oldLeft.getBottomRight());
        left.setMiddleLeft(oldLeft.getTopMiddle());
        left.setMiddleRight(oldLeft.getBottomMiddle());
        left.setBottomLeft(oldLeft.getTopLeft());
        left.setBottomMiddle(oldLeft.getMiddleLeft());
        left.setBottomRight(oldLeft.getBottomLeft());

        front.setTopLeft(oldBottom.getTopLeft());
        front.setMiddleLeft(oldBottom.getMiddleLeft());
        front.setBottomLeft(oldBottom.getBottomLeft());

        back.setTopRight(oldTop.getBottomLeft());
        back.setMiddleRight(oldTop.getMiddleLeft());
        back.setBottomRight(oldTop.getTopLeft());

        top.setTopLeft(oldFront.getTopLeft());
        top.setMiddleLeft(oldFront.getMiddleLeft());
        top.setBottomLeft(oldFront.getBottomLeft());

        bottom.setTopLeft(oldBack.getBottomRight());
        bottom.setMiddleLeft(oldBack.getMiddleRight());
        bottom.setBottomLeft(oldBack.getTopRight());
    }

    public void rotateLeftFlip() {
        Face oldLeft = new Face(this.left);
        Face oldFront = new Face(this.front);
        Face oldBack = new Face(this.back);
        Face oldTop = new Face(this.top);
        Face oldBottom = new Face(this.bottom);

        left.setTopLeft(oldLeft.getBottomRight());
        left.setTopMiddle(oldLeft.getBottomMiddle());
        left.setTopRight(oldLeft.getBottomLeft());
        left.setMiddleLeft(oldLeft.getMiddleRight());
        left.setMiddleRight(oldLeft.getMiddleLeft());
        left.setBottomLeft(oldLeft.getTopRight());
        left.setBottomMiddle(oldLeft.getTopMiddle());
        left.setBottomRight(oldLeft.getTopLeft());

        front.setTopLeft(oldBack.getBottomRight());
        front.setMiddleLeft(oldBack.getMiddleRight());
        front.setBottomLeft(oldBack.getTopRight());

        back.setTopRight(oldFront.getBottomLeft());
        back.setMiddleRight(oldFront.getMiddleLeft());
        back.setBottomRight(oldFront.getTopLeft());

        top.setTopLeft(oldBottom.getTopLeft());
        top.setMiddleLeft(oldBottom.getMiddleLeft());
        top.setBottomLeft(oldBottom.getBottomLeft());

        bottom.setTopLeft(oldTop.getTopLeft());
        bottom.setMiddleLeft(oldTop.getMiddleLeft());
        bottom.setBottomLeft(oldTop.getBottomLeft());
    }

    public void rotateTopClockwise() {

    }

    public void rotateTopCounterClockwise() {

    }

    public void rotateTopFlip() {

    }

    public void rotateBottomClockwise() {

    }

    public void rotateBottomCounterClockwise() {

    }

    public void rotateBottomFlip() {

    }

    public boolean isSolved() {
        return front.isOneColor() && right.isOneColor() && back.isOneColor() &&
                left.isOneColor() && top.isOneColor() && bottom.isOneColor();
    }

    public Face getFront() {
        return front;
    }

    public Face getRight() {
        return right;
    }

    public Face getBack() {
        return back;
    }

    public Face getLeft() {
        return left;
    }

    public Face getTop() {
        return top;
    }

    public Face getBottom() {
        return bottom;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cube cube = (Cube) o;
        return front.equals(cube.front) && right.equals(cube.right) && back.equals(cube.back) &&
                left.equals(cube.left) && top.equals(cube.top) && bottom.equals(cube.bottom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(front, right, back, left, top, bottom);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Cube.class.getSimpleName() + "[", "]")
                .add("front=" + front)
                .add("right=" + right)
                .add("back=" + back)
                .add("left=" + left)
                .add("top=" + top)
                .add("bottom=" + bottom)
                .toString();
    }
}
