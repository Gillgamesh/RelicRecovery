package org.firstinspires.ftc.teamcode.relicrecovery.robot.subsystem;


import com.qualcomm.robotcore.hardware.HardwareMap;

/**
 *This interface forces the inclusion of particular methods so that all hardware modules (i.e.
 * drivetrain or shooter) have methods that will be run on all of them.
 */

public interface Subsystem {
    public void init(HardwareMap parts);
    public  void stop();
}
