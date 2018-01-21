package org.firstinspires.ftc.teamcode.relicrecovery.opmode.auton;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous(name="forward",group = "Ftc 2017")
public class DriveBack extends MecanumDrive {
    @Override
    void routine() {
        encDrive(24, 0.0,0.7, 5);
    }
}
