package week4.enums;


import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class EnumsPractice {
    public static void main(String[] args) {
        example1();
        example2();
    }

    private static void readRobotsListFromFile(File robotsInput, List<RobotV2> robotsList) {
        try (Scanner scanner = new Scanner(robotsInput)){
            while (scanner.hasNext()) {
                robotsList.add(new RobotV2(scanner.nextLine().split(" ")));
            }
        } catch (Exception e) {
            System.out.println("Error in readRobotsListFromFile while working with "
                    + robotsInput.getName() + ": " + e);
        }
    }

    private static void example2() {
        List<RobotV2> robotsList = new ArrayList<>();
        readRobotsListFromFile(new File("robots_list.txt"), robotsList);

        //Filter robots that point EAST
        System.out.println(robotsList.stream().filter(r -> r.getDirection().equals(CardinalDirections.EAST)).toList());
    }

    private static void example1() {
        RobotV2 testRobot = new RobotV2(0,0, 3, "");
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
    private String program;

    public CardinalDirections getDirection() {
        return direction;
    }

    public RobotV2(int x, int y, int direction, String program) {
        this.coordinates = new int[]{x, y};
        this.direction = CardinalDirections.values()[direction];
        this.program = program;
    }

    public RobotV2(String[] input) {
        this(Integer.parseInt(input[0]), Integer.parseInt(input[1]), Integer.parseInt(input[2]), input[3]);
    }

    @Override
    public String toString() {
        return "RobotV2{" +
                "coordinates=" + Arrays.toString(coordinates) +
                ", direction=" + direction +
                ", program='" + program + '\'' +
                '}';
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