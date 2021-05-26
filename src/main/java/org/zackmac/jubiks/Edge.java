package org.zackmac.jubiks;

public class Edge {

    private final Cube cube;

    public Edge(Cube cube) {
        this.cube = cube;
    }

    public boolean frontLeftContains(byte color) {
        return (cube.getLeft()[5] == color) || (cube.getFront()[3] == color);
    }

    public boolean frontTopContains(byte color) {
        return (cube.getTop()[7] == color) || (cube.getFront()[1] == color);
    }

    public boolean frontRightContains(byte color) {
        return (cube.getRight()[3] == color) || (cube.getFront()[5] == color);
    }

    public boolean frontBottomContains(byte color) {
        return (cube.getBottom()[1] == color) || (cube.getFront()[7] == color);
    }

    public boolean rightLeftContains(byte color) {
        return (cube.getFront()[5] == color) || (cube.getRight()[3] == color);
    }

    public boolean rightTopContains(byte color) {
        return (cube.getTop()[5] == color) || (cube.getRight()[1] == color);
    }

    public boolean rightRightContains(byte color) {
        return (cube.getBack()[3] == color) || (cube.getRight()[5] == color);
    }

    public boolean rightBottomContains(byte color) {
        return (cube.getBottom()[5] == color) || (cube.getRight()[7] == color);
    }

    public boolean backLeftContains(byte color) {
        return (cube.getRight()[5] == color) || (cube.getBack()[3] == color);
    }

    public boolean backTopContains(byte color) {
        return (cube.getTop()[1] == color) || (cube.getBack()[1] == color);
    }

    public boolean backRightContains(byte color) {
        return (cube.getLeft()[3] == color) || (cube.getBack()[5] == color);
    }

    public boolean backBottomContains(byte color) {
        return (cube.getBottom()[7] == color) || (cube.getBack()[7] == color);
    }

    public boolean leftLeftContains(byte color) {
        return (cube.getBack()[5] == color) || (cube.getLeft()[3] == color);
    }

    public boolean leftTopContains(byte color) {
        return (cube.getTop()[3] == color) || (cube.getLeft()[1] == color);
    }

    public boolean leftRightContains(byte color) {
        return (cube.getFront()[3] == color) || (cube.getLeft()[5] == color);
    }

    public boolean leftBottomContains(byte color) {
        return (cube.getBottom()[3] == color) || (cube.getLeft()[7] == color);
    }

    public boolean topLeftContains(byte color) {
        return (cube.getLeft()[1] == color) || (cube.getTop()[3] == color);
    }

    public boolean topTopContains(byte color) {
        return (cube.getBack()[1] == color) || (cube.getTop()[1] == color);
    }

    public boolean topRightContains(byte color) {
        return (cube.getRight()[1] == color) || (cube.getTop()[5] == color);
    }

    public boolean topBottomContains(byte color) {
        return (cube.getFront()[1] == color) || (cube.getTop()[7] == color);
    }

    public boolean bottomLeftContains(byte color) {
        return (cube.getLeft()[7] == color) || (cube.getBottom()[3] == color);
    }

    public boolean bottomTopContains(byte color) {
        return (cube.getFront()[7] == color) || (cube.getBottom()[1] == color);
    }

    public boolean bottomRightContains(byte color) {
        return (cube.getRight()[7] == color) || (cube.getBottom()[5] == color);
    }

    public boolean bottomBottomContains(byte color) {
        return (cube.getBack()[7] == color) || (cube.getBottom()[7] == color);
    }
}
