package frc.robot.subsystems.swerve;

import com.ctre.phoenix6.swerve.SwerveDrivetrainConstants;

import frc.robot.subsystems.swerve.constants.SwerveSimConstants;

public class SwerveIOSim
    extends SwerveSubsystem
    implements SwerveIOInterface {

    public SwerveIOSim(SwerveDrivetrainConstants drivetrainConstants) {
        super(
            drivetrainConstants, 
            SwerveSimConstants.FrontLeft,
            SwerveSimConstants.FrontRight,
            SwerveSimConstants.BackLeft,
            SwerveSimConstants.BackRight
        );
    }
    
}