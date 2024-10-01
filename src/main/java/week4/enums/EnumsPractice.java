package week4.enums;


import java.util.Arrays;

public class EnumsPractice {
    public static void main(String[] args) {
        example1();
    }

    private static void example1() {
        RobotV2 testRobot = new RobotV2();
        //NORTH 0,0
        testRobot.doTurnRight();
        testRobot.doTurnRight();
        //SOUTH 0,0
        testRobot.doMove();
        testRobot.doMove();
        //SOUTH 0,-2
        //PRINT
        System.out.println(Arrays.toString(testRobot.getCoordinates()));
        testRobot.doTurnLeft();
        //EAST 0,-2
        testRobot.doMove();
        //EAST 1,-2
        //PRINT
        System.out.println(Arrays.toString(testRobot.getCoordinates()));
        testRobot.doTurnRight();
        testRobot.doTurnRight();
        testRobot.doTurnRight();
        testRobot.doTurnRight();
        testRobot.doTurnRight();
        //SOUTH 1,-2
        testRobot.doMove();
        //SOUTH 1,-3
        //PRINT
        System.out.println(Arrays.toString(testRobot.getCoordinates()));
    }

}

enum CardinalDirections {
    SOUTH, WEST, NORTH, EAST
}

class RobotV2 {
    private int[] coordinates;
    private CardinalDirections direction;

    public RobotV2() {
        this.coordinates = new int[]{0, 0};
        this.direction = CardinalDirections.NORTH;
    }

    public int[] getCoordinates() {
        return coordinates;
    }

    public void doMove(int times) {
        for (int i = 0; i < times; i++) doMove();
    }
    public void doMove() {
        switch (direction) {
            //y = y - 1
            case SOUTH -> coordinates[1]--;
            //x = x - 1
            case WEST -> coordinates[0]--;
            //y = y + 1
            case NORTH -> coordinates[1]++;
            //x = x + 1
            case EAST -> coordinates[0]++;

        }
    }

    public void doTurnRight(int times) {
        for (int i = 0; i < times; i++) doTurnRight();
    }
    public void doTurnRight() {
        direction = CardinalDirections.values()
                [direction.ordinal() + 1 == 4 ? 0 : direction.ordinal() + 1];
    }

    public void doTurnLeft(int times) {
        for (int i = 0; i < times; i++) doTurnLeft();
    }
    public void doTurnLeft() {
        direction = CardinalDirections.values()
                [direction.ordinal() - 1 == -1 ? 3 : direction.ordinal() - 1];
    }
}