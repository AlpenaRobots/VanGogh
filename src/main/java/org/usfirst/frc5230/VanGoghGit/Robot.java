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

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc5230.VanGoghGit.commands.*;
import org.usfirst.frc5230.VanGoghGit.subsystems.*;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in 
 * the project.
 */
public class Robot extends TimedRobot {

    Command autonomousCommand;
    SendableChooser<Command> chooser = new SendableChooser<>();

    public static OI oi;
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static drive drive;
    public static elevator elevator;
    public static ballintake ballintake;
    public static hatch hatch;
    public static hatchrotate hatchrotate;
    public static ballplacer ballplacer;
    public static ballrotate ballrotate;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    //Sets up variables required to read values from the GRIP networktables
    NetworkTable GRIPtable = NetworkTableInstance.getDefault().getTable("GRIP/horizontalLines");  
    NetworkTableEntry x1Net = GRIPtable.getEntry("x1");
    NetworkTableEntry x2Net = GRIPtable.getEntry("x2");
    NetworkTableEntry y1Net = GRIPtable.getEntry("y1");
    NetworkTableEntry y2Net = GRIPtable.getEntry("y2");
    NetworkTableEntry angleNet = GRIPtable.getEntry("lineAngle");
    NetworkTableEntry lengthNet = GRIPtable.getEntry("length");
   
    NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
    NetworkTableEntry tx = table.getEntry("tx");
    NetworkTableEntry ty = table.getEntry("ty");
    NetworkTableEntry ta = table.getEntry("ta");
    

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    @Override
    public void robotInit() {

        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        drive = new drive();
        elevator = new elevator();
        ballintake = new ballintake();
        hatch = new hatch();
        hatchrotate = new hatchrotate();
        ballplacer = new ballplacer();
        ballrotate = new ballrotate();

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        // OI must be constructed after subsystems. If the OI creates Commands
        //(which it very likely will), subsystems are not guaranteed to be
        // constructed yet. Thus, their requires() statements may grab null
        // pointers. Bad news. Don't move it.
        oi = new OI();

        // Add commands to Autonomous Sendable Chooser
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS

        chooser.setDefaultOption("Autonomous Command", new AutonomousCommand());

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS
        SmartDashboard.putData("Auto mode", chooser);
    }

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    @Override
    public void disabledInit(){

    }

    @Override
    public void disabledPeriodic() {
       

        double x = tx.getDouble(0.0);
        double y = ty.getDouble(0.0);
        double area = ta.getDouble(0.0);
        SmartDashboard.putNumber("LimelightX", x);
        SmartDashboard.putNumber("LimelightY", y);
        SmartDashboard.putNumber("LimelightArea", area);

        Robot.drive.updateLimelightTracking();

        double x1 = x1Net.getDouble(0.0);
        double x2 = x2Net.getDouble(0.0);
        double y1 = x1Net.getDouble(0.0);
        double y2 = x2Net.getDouble(0.0);
        double angle = angleNet.getDouble(0.0);
        double length = lengthNet.getDouble(0.0);

        SmartDashboard.putNumber("x1", x1);
        SmartDashboard.putNumber("x2", x2);
        SmartDashboard.putNumber("y1", y1);
        SmartDashboard.putNumber("y2", y2);
        SmartDashboard.putNumber("angle", angle);
        SmartDashboard.putNumber("length", length);

        Robot.drive.updateGaffersTape();

        Scheduler.getInstance().run();
    }

    @Override
    public void autonomousInit() {
        autonomousCommand = chooser.getSelected();
        // schedule the autonomous command (example)
        if (autonomousCommand != null) autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    @Override
    public void autonomousPeriodic() {
 

        double x = tx.getDouble(0.0);
        double y = ty.getDouble(0.0);
        double area = ta.getDouble(0.0);
        SmartDashboard.putNumber("LimelightX", x);
        SmartDashboard.putNumber("LimelightY", y);
        SmartDashboard.putNumber("LimelightArea", area);

        Robot.drive.updateLimelightTracking();

        double x1 = x1Net.getDouble(0.0);
        double x2 = x2Net.getDouble(0.0);
        double y1 = x1Net.getDouble(0.0);
        double y2 = x2Net.getDouble(0.0);
        double angle = angleNet.getDouble(0.0);
        double length = lengthNet.getDouble(0.0);

        SmartDashboard.putNumber("x1", x1);
        SmartDashboard.putNumber("x2", x2);
        SmartDashboard.putNumber("y1", y1);
        SmartDashboard.putNumber("y2", y2);
        SmartDashboard.putNumber("angle", angle);
        SmartDashboard.putNumber("length", length);

        Robot.drive.updateGaffersTape();

        Scheduler.getInstance().run();
    }

    @Override
    public void teleopInit() {
        // This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) autonomousCommand.cancel();
    }

    /**
     * This function is called periodically during operator control
     */
    @Override
    public void teleopPeriodic() {
       

        double x = tx.getDouble(0.0);
        double y = ty.getDouble(0.0);
        double area = ta.getDouble(0.0);
        SmartDashboard.putNumber("LimelightX", x);
        SmartDashboard.putNumber("LimelightY", y);
        SmartDashboard.putNumber("LimelightArea", area);

        Robot.drive.updateLimelightTracking();

        double x1 = x1Net.getDouble(0.0);
        double x2 = x2Net.getDouble(0.0);
        double y1 = x1Net.getDouble(0.0);
        double y2 = x2Net.getDouble(0.0);
        double angle = angleNet.getDouble(0.0);
        double length = lengthNet.getDouble(0.0);

        SmartDashboard.putNumber("x1", x1);
        SmartDashboard.putNumber("x2", x2);
        SmartDashboard.putNumber("y1", y1);
        SmartDashboard.putNumber("y2", y2);
        SmartDashboard.putNumber("angle", angle);
        SmartDashboard.putNumber("length", length);

        Robot.drive.updateGaffersTape();

        Scheduler.getInstance().run();
    }
}
