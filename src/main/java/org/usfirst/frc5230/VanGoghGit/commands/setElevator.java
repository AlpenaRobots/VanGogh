// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc5230.VanGoghGit.commands;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc5230.VanGoghGit.Robot;

/**
 *
 */
public class setElevator extends Command {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS
    private double m_height;
    private double m_speed;
 
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS
    private boolean atDistance;
    
    private double startCount;
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
    public setElevator(double height, double speed) {

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
        m_height = height;
        m_speed = speed;

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        requires(Robot.elevator);

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
        startCount = Robot.elevator.getEncoderCount();
    	if (startCount < m_height) {
            Robot.elevator.setElevatorSpeed(m_speed);
            new ballToggleRotate();
    	} else {
    		Robot.elevator.setElevatorSpeed(-m_speed);
    	}
    	atDistance = false;
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
    	if (m_height > 0) {
    		if (m_height <= Robot.elevator.getEncoderCount())
    			atDistance = true;
    	} else {
    		if (m_height >= Robot.elevator.getEncoderCount())
    			atDistance = true;
    	}
        return atDistance;
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
        Robot.elevator.off();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
        end();
    }
}
