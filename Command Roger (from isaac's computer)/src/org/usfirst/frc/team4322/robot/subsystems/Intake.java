package org.usfirst.frc.team4322.robot.subsystems;

import org.usfirst.frc.team4322.robot.RobotMap;
import org.usfirst.frc.team4322.robot.commands.*;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * The intake, consisting of one intake motor.
 */
public class Intake extends Subsystem {
	boolean hasBall;
	SpeedController intakeMotor;
	
	public Intake() {
		hasBall = false;
		intakeMotor = new VictorSP(RobotMap.intakeMotor);
	}
	
	public void initialize() {
		intakeMotor.set(0);
	}
	
	public void operateWith(Joystick joy, int pullAxis, int pushAxis) {
		
		double speed = joy.getRawAxis(pullAxis) - joy.getRawAxis(pushAxis);
		
		if (speed < -1) {	
			speed = -1;
		}
		
		if (speed > 1) {
			speed = 1;
		}
		
		intakeMotor.set(speed);	
	}
		
	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		setDefaultCommand(new ManualIntake());
	}
}

