
package org.usfirst.frc.team4322.robot.subsystems;

import org.usfirst.frc.team4322.robot.RobotMap;
import org.usfirst.frc.team4322.robot.commands.SwitchableDrive;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * The wheels, consisting of four motors.
 */
public class DriveTrain extends Subsystem {
    private SpeedController motorLF, motorLB, motorRF, motorRB;
    
    public DriveTrain() {
    	motorRF = new VictorSP(RobotMap.motorRF);
    	motorRB = new VictorSP(RobotMap.motorRB);
    	motorLF = new VictorSP(RobotMap.motorLF);
    	motorLB = new VictorSP(RobotMap.motorLB);
    }
	
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new SwitchableDrive());
    }
    
    public void isaacDrive(double throttleAxis, double turningAxis) {
    	
    	// make the turning sensitivity decrease at higher throttles
    	double rotationCw = turningAxis / (1 + throttleAxis);
    	
    	double rightSpeed = throttleAxis + rotationCw;
    	double leftSpeed = -throttleAxis + rotationCw;
    	
    	if (leftSpeed < -1) {
    		leftSpeed = -1;
    	}
    	
    	if (leftSpeed > 1) {
    		leftSpeed = 1;
    	}
    	
    	if (rightSpeed < -1) {
    		rightSpeed = -1;
    	}
    	
    	if (rightSpeed > 1) {
    		rightSpeed = 1;
    	}
    	
    	
    	motorRF.set(rightSpeed);
    	motorRB.set(rightSpeed);
    	motorLF.set(leftSpeed);
    	motorLB.set(leftSpeed);
    }
    
    public void tankDrive(double rightPower, double leftPower) {
    	
    	if (rightPower < -1) {
    		rightPower = -1;
    	}
    	
    	if (rightPower > 1) {
    		rightPower = 1;
    	}
    	
    	if (rightPower < -1) {
    		rightPower = -1;
    	}
    	
    	if (rightPower > 1) {
    		rightPower = 1;
    	}
    	
    	motorLF.set(leftPower);
    	motorLB.set(leftPower);
    	motorRF.set(-rightPower);
    	motorRB.set(-rightPower);
    }
        
}

