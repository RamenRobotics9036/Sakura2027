package frc.robot.general.bot_configurations;

import com.ctre.phoenix6.CANBus;
import com.ctre.phoenix6.configs.Pigeon2Configuration;

import frc.robot.subsystems.swerve.SwerveSubsystem;

public interface BotConfigInterface {
    
    /** Returns the CAN Bus. */
    public CANBus getCanBus();

    /** Returns the CAN id of the Pigeon. */
    public int getPigeonId();

    /** Returns the configs for the Pigeon. */
    public Pigeon2Configuration getPigeon2Configuration();

    /** Create and return a swerve drivetrain. */
    public SwerveSubsystem createDrivetrain();
}
