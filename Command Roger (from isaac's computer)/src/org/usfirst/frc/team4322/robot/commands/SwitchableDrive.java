package org.usfirst.frc.team4322.robot.commands;

import org.usfirst.frc.team4322.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class SwitchableDrive extends Command {
	
	private static boolean isaac = true;
	
    public SwitchableDrive() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.drivetrain);
    }
    
    public static void toggleIsaac() {
    	isaac = !isaac;
    	
    	if (isaac) {
    		System.out.println("Now Isaac Drive.");
    	}
    	else {
    		System.out.println("Now Tank Drive.");
    	}
    	
    }
    
    // Called just before this Command runs the first time
    protected void initialize() {
    	
    }
    
    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (isaac) {
    		Robot.drivetrain.isaacDrive(Robot.oi.gamepadDr.getY(), Robot.oi.gamepadDr.getRawAxis(4));
    	}
    	else {
    		Robot.drivetrain.tankDrive(Robot.oi.gamepadDr.getY(), Robot.oi.gamepadDr.getRawAxis(5));
    	}
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	
    }
}
