package com.kayak.exercise.one.test;

import com.kayak.exercise.one.GridDirection;
import com.kayak.exercise.one.Robot;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class RobotUnitTest {

    @Test
    public void testRobotObject(){
        Robot robot = new Robot();

        assertNotNull(robot);

        assertNotNull(robot.getPosition());

        assertNotNull(robot.getPosition().getX());
        assertEquals(robot.getPosition().getX(), 0);

        assertNotNull(robot.getPosition().getY());
        assertEquals(robot.getPosition().getY(), 0);

        assertNotNull(robot.getGridDirection());
        assertEquals(robot.getGridDirection(), GridDirection.UP);
    }

    @Test
    public void testValidInputCommand(){
        Robot robot = new Robot();

        assertFalse(robot.isCommandValid(""));
        assertFalse(robot.isCommandValid("  "));
        assertFalse(robot.isCommandValid("1"));
        assertFalse(robot.isCommandValid("LL "));
        assertFalse(robot.isCommandValid("LLr"));

        assertTrue(robot.isCommandValid("L"));
        assertTrue(robot.isCommandValid("R"));
        assertTrue(robot.isCommandValid("F"));
        assertTrue(robot.isCommandValid("LLRRFF"));
    }

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void testExceptionForInputCommand() {
        exceptionRule.expect(IllegalArgumentException.class);
        Robot robot = new Robot();
        robot.setCommand("1");
    }

}
