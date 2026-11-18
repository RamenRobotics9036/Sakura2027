package frc.robot.commands;

import edu.wpi.first.units.measure.AngularVelocity;
import edu.wpi.first.units.measure.LinearVelocity;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.RunCommand;
import frc.robot.subsystems.swerve.SwerveSubsystem;

import static edu.wpi.first.units.Units.*;

import com.ctre.phoenix6.swerve.SwerveModule.DriveRequestType;
import com.ctre.phoenix6.swerve.SwerveRequest;

/** Shoot. */
public class MoveRightCommand {
    /** 
     * Returns a Command that moves us right. 
     * 
     * @param swerve The swerve drivetrain.
     * @param speed The linear speed in meters per second.
     * @param time How long to move for.
    */
    public static Command create(
        SwerveSubsystem swerve, double speed, double time) {
        
        /* Setting up bindings for necessary control of the swerve drive platform */
        final SwerveRequest.FieldCentric driveRequest = new SwerveRequest.FieldCentric()
            .withDriveRequestType(DriveRequestType.OpenLoopVoltage); // Use open-loop control for drive motors

        return Commands.sequence(
            // Move in the desired direction
            new RunCommand(() -> {
                swerve.applyRequest(() ->
                    driveRequest.withVelocityX(LinearVelocity.ofBaseUnits(0, MetersPerSecond)) // Drive forward with negative Y (forward)
                        .withVelocityY(LinearVelocity.ofBaseUnits(speed, MetersPerSecond)) // Drive left with negative X (left)
                        .withRotationalRate(AngularVelocity.ofBaseUnits(0, RadiansPerSecond)) // Drive counterclockwise with negative X (left)
                );
            },
            // Dependencies:
            swerve)
            .withTimeout(time)
        )
        
        // finallyDo ensures motors are stopped even if command is cancelled.
        .finallyDo(() -> {
            swerve.applyRequest(() ->
                driveRequest.withVelocityX(LinearVelocity.ofBaseUnits(0, MetersPerSecond))
                    .withVelocityY(LinearVelocity.ofBaseUnits(0, MetersPerSecond))
                    .withRotationalRate(AngularVelocity.ofBaseUnits(0, RadiansPerSecond))
            );
        });
    }
}