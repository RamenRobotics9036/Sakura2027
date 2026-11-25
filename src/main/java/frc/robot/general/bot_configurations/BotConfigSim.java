package frc.robot.general.bot_configurations;

import com.ctre.phoenix6.CANBus;
import com.ctre.phoenix6.configs.Pigeon2Configuration;
import com.ctre.phoenix6.swerve.SwerveDrivetrainConstants;

import frc.robot.subsystems.swerve.SwerveIOSim;
import frc.robot.subsystems.swerve.SwerveSubsystem;

public class BotConfigSim implements BotConfigInterface {
    /** 
     * CAN bus that the devices are located on;
     * All swerve devices must share the same CAN bus
     */
    public static final CANBus kCANBus = new CANBus("", "./logs/example.hoot");

    public CANBus getCanBus() {
        return kCANBus;
    }


    /** The CAN id of the Pigeon gyro. */
    private static final int kPigeonId = 7;

    /** Configs for the Pigeon 2; leave this null to skip applying Pigeon 2 configs */
    private static final Pigeon2Configuration pigeonConfigs = null;

    public int getPigeonId() {
        return kPigeonId;
    }

    public Pigeon2Configuration getPigeon2Configuration() {
        return pigeonConfigs;
    }


    // The TunerSwerveDrivetrain class expects us to give it
    // the configurations for the drivetrain and all motors.
    public static SwerveDrivetrainConstants kDrivetrainConstants = new SwerveDrivetrainConstants()
        .withCANBusName(kCANBus.getName())
        .withPigeon2Id(kPigeonId)
        .withPigeon2Configs(pigeonConfigs);

    public SwerveSubsystem createDrivetrain() {
        return new SwerveIOSim(kDrivetrainConstants);
    }
}
