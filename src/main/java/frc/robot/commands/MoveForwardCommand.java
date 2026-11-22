package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.swerve.SwerveSubsystem;

import static edu.wpi.first.units.Units.*;

import com.ctre.phoenix6.swerve.SwerveModule.DriveRequestType;
import com.ctre.phoenix6.swerve.SwerveRequest;

/** Field-centric move forward for a fixed time. */
public class MoveForwardCommand {
    /** 
     * Returns a Command that moves us forward (field-centric). 
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

        // Move in the desired direction. +X is away from the alliance wall, +Y is to the left.
        return swerve.applyRequest(() ->
                driveRequest.withVelocityX(MetersPerSecond.of(speed))
                    .withVelocityY(MetersPerSecond.of(0)) // Forward is +X
                    .withRotationalRate(RadiansPerSecond.of(0))
            )
            .withTimeout(time)

            // finallyDo ensures motors are stopped even if command is cancelled.
            .finallyDo(() -> swerve.setControl(
                driveRequest.withVelocityX(MetersPerSecond.of(0))
                    .withVelocityY(MetersPerSecond.of(0))
                    .withRotationalRate(RadiansPerSecond.of(0))
            ));
    }
}
