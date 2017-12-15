package org.firstinspires.ftc.teamcode.relicrecovery.opmode.auton;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous(name="forward   ",group = "Ftc 2017")
public class DriveBack extends AutoMecanum {
    @Override
    void routine() {
        encDriveForward(20, 0.6, 5);
    }
}
