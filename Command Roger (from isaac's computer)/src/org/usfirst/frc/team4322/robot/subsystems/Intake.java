package org.usfirst.frc.team4322.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * This is the intake belt that pulls in the boulder.
 */

public class Intake extends Subsystem {
	
	SpeedController intakeMotor;
	DigitalInput ballDetector;
	
	public Intake() {
		intakeMotor = new VictorSP(5);
		ballDetector = new DigitalInput(0);
	}
	
	public void pullIn() {
		intakeMotor.set(1);
		
		while (ballDetector.get()) {
		}
		
		Timer.delay(0.1);
		intakeMotor.set(0);
	}
	
	public void feedToFlywheel() {
		while (!ballDetector.get()) {
			intakeMotor.set(1);
		}
		Timer.delay(0.5);
		intakeMotor.set(0);
	}
	
	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	
	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		//setDefaultCommand(new MySpecialCommand());
	}
}

