package com.kayak.exercise.one.test;

import com.kayak.exercise.one.Position;
import com.kayak.exercise.one.Robot;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class RobotParameterizedTest {

    private Position finalPosition;
    private String command;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][]{
                {"RRFF", new Position(0, -2), null},
                {"RFFF", new Position(3, 0), null},
                {"LFFFF", new Position(-4, 0), null},
                {"LRLRLRLRLRLRLR", new Position(0,0), null},
                {"LLRRLLLRRLRRF", new Position(0,1), null},
                {"FF", new Position(0,2), null},
                {"LFFFRFFFRRFFF", new Position(-3,0), null},
                {"FFRFLFFFRF", new Position(2,5), null},
                {"MOVE FORWARD!", new Position(0,0), IllegalArgumentException.class},
                {"Please move forward :)", new Position(0, 0), IllegalArgumentException.class}
        };
        return Arrays.asList(data);
    }

    public RobotParameterizedTest(final String command, final Position finalPosition, final Class<? extends Throwable> ex){
        this.command = command;
        this.finalPosition = finalPosition;
        if (ex == null) {
            expectedException = ExpectedException.none();
        } else {
            expectedException.expect(ex);
        }
    }

    @Test
    public void testRobotFinalPosition(){
        final Robot robot = new Robot();
        robot.setCommand(command);
        robot.move();
        final String finalPositionStr = "[" + robot.getPosition().getX() + ", " + robot.getPosition().getY() + "]";

        assertEquals(robot.getPosition(), finalPosition);
        assertEquals(robot.getFinalPosition(), finalPositionStr);

    }

}
