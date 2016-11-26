package org.usfirst.frc.team4322.robot.subsystems;

import edu.wpi.first.wpilibj.command.PIDSubsystem;

import org.usfirst.frc.team4322.robot.RobotMap;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.VictorSP;

/**
 *
 */
public class PidIntake extends PIDSubsystem {
	
	private SpeedController intakeMotor;
	public DigitalInput ballDetector;
	
	public boolean hasBall() {
		return !ballDetector.get();
	}
	
    // Initialize your subsystem here
    public PidIntake() {
    	super (0.0, 0.0, 0.0);
    	intakeMotor = new VictorSP(RobotMap.intakeMotor);
        // Use these to get going:
        // setSetpoint() -  Sets where the PID controller should move the system
        //                  to
        // enable() - Enables the PID controller.
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    protected double returnPIDInput() {
        // Return your input value for the PID loop
        // e.g. a sensor, like a potentiometer:
        // yourPot.getAverageVoltage() / kYourMaxVoltage;
    	return 0.0;
    }
    
    protected void usePIDOutput(double output) {
    	intakeMotor.pidWrite(output);
        // Use output to drive your system, like a motor
        // e.g. yourMotor.set(output);
    }
}
