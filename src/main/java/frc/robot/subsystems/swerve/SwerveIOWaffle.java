package frc.robot.subsystems.swerve;

import com.ctre.phoenix6.swerve.SwerveDrivetrainConstants;

import frc.robot.subsystems.swerve.constants.SwerveWaffleConstants;

public class SwerveIOWaffle 
    extends SwerveSubsystem
    implements SwerveIOInterface {

    public SwerveIOWaffle(SwerveDrivetrainConstants drivetrainConstants) {
        // The TunerSwerveDrivetrain class expects the constants for
        // the full drivetrain alongside that of each individual
        // swerve module (corner of the bot)
        super(
            drivetrainConstants, 
            SwerveWaffleConstants.FrontLeft,
            SwerveWaffleConstants.FrontRight,
            SwerveWaffleConstants.BackLeft,
            SwerveWaffleConstants.BackRight
        );
    }
    
}