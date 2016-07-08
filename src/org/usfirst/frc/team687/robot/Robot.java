
package org.usfirst.frc.team687.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * @author Isaac
 * An alternative to the arcade method already provided by WPILib.
 * Note: hasn't been tested, but theoretically should work.
 */
public class Robot extends IterativeRobot {
	Joystick joy;
	Talon left, right;
	Double leftVal, rightVal, yAxis, xAxis;
	
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
    	joy = new Joystick(1);
    	left = new Talon(1);
    	right = new Talon(2);
    }
    
	/**
	 * This autonomous (along with the chooser code above) shows how to select between different autonomous modes
	 * using the dashboard. The sendable chooser code works with the Java SmartDashboard. If you prefer the LabVIEW
	 * Dashboard, remove all of the chooser code and uncomment the getString line to get the auto name from the text box
	 * below the Gyro
	 *
	 * You can add additional auto modes by adding additional comparisons to the switch structure below with additional strings.
	 * If using the SendableChooser make sure to add them to the chooser code above as well.
	 */
    public void autonomousInit() {

    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {

    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
    	yAxis = limit(joy.getY());
    	xAxis = limit(joy.getX());
    	leftVal = yAxis + xAxis;
    	rightVal = yAxis - xAxis; 
    	
    	left.set(leftVal);
    	right.set(rightVal);
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
    
    }
    public double limit(double input){
    	if(input>1){
    		input = 1;
    	}
    	if(input<-1){
    		input = -1;
    	}
    	return input;
    }
    
}
