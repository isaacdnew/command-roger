package org.usfirst.frc.team4322.robot.commands;

import org.usfirst.frc.team4322.robot.OI;
import edu.wpi.first.wpilibj.command.Command;

/**
 * Just toggles the variable isaac without getting in the way of other code.
 */
public class IsaacToggle extends Command {
		
    public IsaacToggle() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    	OI.isaac = !OI.isaac;
    	
    	if (OI.isaac) {
    		System.out.println("Now Isaac Drive");
    	}
    	else {
    		System.out.println("Now Tank Drive");
    	}
    	
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}