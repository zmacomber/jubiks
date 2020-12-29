package org.zackmac.jubiks;

import java.util.Objects;
import java.util.StringJoiner;

public class Face {

    private Color topLeft;
    private Color topMiddle;
    private Color topRight;
    private Color middleLeft;
    private final Color center; // The center square never changes color so can keep it final
    private Color middleRight;
    private Color bottomLeft;
    private Color bottomMiddle;
    private Color bottomRight;

    public Face(Color topLeft, Color topMiddle, Color topRight,
                Color middleLeft, Color center, Color middleRight,
                Color bottomLeft, Color bottomMiddle, Color bottomRight
    ) {
        this.topLeft = makeSureNotNull(topLeft, "topLeft");
        this.topMiddle = makeSureNotNull(topMiddle, "topMiddle");
        this.topRight = makeSureNotNull(topRight, "topRight");
        this.middleLeft = makeSureNotNull(middleLeft, "middleLeft");
        this.center = makeSureNotNull(center, "center");
        this.middleRight = makeSureNotNull(middleRight, "middleRight");
        this.bottomLeft = makeSureNotNull(bottomLeft, "bottomLeft");
        this.bottomMiddle = makeSureNotNull(bottomMiddle, "bottomMiddle");
        this.bottomRight = makeSureNotNull(bottomRight, "bottomRight");
    }

    private Color makeSureNotNull(Color color, String location) {
        if (color == null) {
            throw new IllegalArgumentException(location + " color must not be null");
        }
        return color;
    }

    public Face(Face oldFace) {
        this.topLeft = oldFace.topLeft;
        this.topMiddle = oldFace.topMiddle;
        this.topRight = oldFace.topRight;
        this.middleLeft = oldFace.middleLeft;
        this.center = oldFace.center;
        this.middleRight = oldFace.middleRight;
        this.bottomLeft = oldFace.bottomLeft;
        this.bottomMiddle = oldFace.bottomMiddle;
        this.bottomRight = oldFace.bottomRight;
    }

    public Color getTopLeft() {
        return topLeft;
    }

    public void setTopLeft(Color topLeft) {
        this.topLeft = topLeft;
    }

    public Color getTopMiddle() {
        return topMiddle;
    }

    public void setTopMiddle(Color topMiddle) {
        this.topMiddle = topMiddle;
    }

    public Color getTopRight() {
        return topRight;
    }

    public void setTopRight(Color topRight) {
        this.topRight = topRight;
    }

    public Color getMiddleLeft() {
        return middleLeft;
    }

    public void setMiddleLeft(Color middleLeft) {
        this.middleLeft = middleLeft;
    }

    public Color getCenter() {
        return center;
    }

    public Color getMiddleRight() {
        return middleRight;
    }

    public void setMiddleRight(Color middleRight) {
        this.middleRight = middleRight;
    }

    public Color getBottomLeft() {
        return bottomLeft;
    }

    public void setBottomLeft(Color bottomLeft) {
        this.bottomLeft = bottomLeft;
    }

    public Color getBottomMiddle() {
        return bottomMiddle;
    }

    public void setBottomMiddle(Color bottomMiddle) {
        this.bottomMiddle = bottomMiddle;
    }

    public Color getBottomRight() {
        return bottomRight;
    }

    public void setBottomRight(Color bottomRight) {
        this.bottomRight = bottomRight;
    }

    public boolean isOneColor() {
        return topLeft.equals(center) && topMiddle.equals(center) && topRight.equals(center) &&
                middleLeft.equals(center) && middleRight.equals(center) &&
                bottomLeft.equals(center) && bottomMiddle.equals(center) && bottomRight.equals(center);

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Face face = (Face) o;
        return topLeft == face.topLeft && topMiddle == face.topMiddle && topRight == face.topRight &&
                middleLeft == face.middleLeft && center == face.center && middleRight == face.middleRight &&
                bottomLeft == face.bottomLeft && bottomMiddle == face.bottomMiddle && bottomRight == face.bottomRight;
    }

    @Override
    public int hashCode() {
        return Objects.hash(topLeft, topMiddle, topRight,
                middleLeft, center, middleRight,
                bottomLeft, bottomMiddle, bottomRight);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Face.class.getSimpleName() + "[", "]")
                .add("topLeft=" + topLeft)
                .add("topMiddle=" + topMiddle)
                .add("topRight=" + topRight)
                .add("middleLeft=" + middleLeft)
                .add("center=" + center)
                .add("middleRight=" + middleRight)
                .add("bottomLeft=" + bottomLeft)
                .add("bottomMiddle=" + bottomMiddle)
                .add("bottomRight=" + bottomRight)
                .toString();
    }
}
