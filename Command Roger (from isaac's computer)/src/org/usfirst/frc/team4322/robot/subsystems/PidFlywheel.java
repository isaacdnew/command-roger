package org.usfirst.frc.team4322.robot.subsystems;

import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.VictorSP;

/**
 *
 *
 */
public class PidFlywheel extends PIDSubsystem {
	
	SpeedController flywheelMotor;
	Encoder flywheelEncoder;
    
	// Initialize your subsystem here
    public PidFlywheel() {
    	super ("PidFlywheel", 0.0, 0.0, 0.0);
    	flywheelEncoder = new Encoder(0, 1);
    	flywheelMotor = new VictorSP(5);
        // Use these to get going:
        // setSetpoint() -  Sets where the PID controller should move the system
        //                  to
        // enable() - Enables the PID controller.
    }
    
    public void setTargetSpeed(double rpm) {
    	setSetpoint(rpm);
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    protected double returnPIDInput() {
        // Return your input value for the PID loop
        // e.g. a sensor, like a potentiometer:
        // yourPot.getAverageVoltage() / kYourMaxVoltage;
    	return flywheelEncoder.getRate();
    }
    
    protected void usePIDOutput(double output) {
        // Use output to drive your system, like a motor
        // e.g. yourMotor.set(output);
    	flywheelMotor.set(output);
    }
}
