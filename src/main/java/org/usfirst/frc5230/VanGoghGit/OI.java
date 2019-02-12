// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc5230.VanGoghGit;

import org.usfirst.frc5230.VanGoghGit.commands.*;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);

    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.

    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:

    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());

    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());

    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());


    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public JoystickButton rBump;
    public Joystick xbox1;
    public Joystick xbox2;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public OI() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

        xbox2 = new Joystick(1);
        
        xbox1 = new Joystick(0);
        
        rBump = new JoystickButton(xbox1, 1);
        rBump.whenPressed(new Shift());


        // SmartDashboard Buttons
        SmartDashboard.putData("Autonomous Command", new AutonomousCommand());
        SmartDashboard.putData("Shift", new Shift());
        SmartDashboard.putData("JoystickDrive", new JoystickDrive());
        SmartDashboard.putData("ballIntakeRun", new ballIntakeRun());
        SmartDashboard.putData("hatchToggleRotate", new hatchToggleRotate());
        SmartDashboard.putData("hatchToggleExtend", new hatchToggleExtend());
        SmartDashboard.putData("hatchToggleClamp", new hatchToggleClamp());
        SmartDashboard.putData("ballPlacerRun", new ballPlacerRun());
        SmartDashboard.putData("ballToggleRotate", new ballToggleRotate());
        SmartDashboard.putData("setElevator", new setElevator());
        SmartDashboard.putData("elevatorLevelOne", new elevatorLevelOne());
        SmartDashboard.putData("elevatorLevelTwo", new elevatorLevelTwo());
        SmartDashboard.putData("elevatorLevelThree", new elevatorLevelThree());

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
    public Joystick getXbox1() {
        return xbox1;
    }

    public Joystick getXbox2() {
        return xbox2;
    }


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
}

