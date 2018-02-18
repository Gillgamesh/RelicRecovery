package org.firstinspires.ftc.teamcode.relicrecovery.opmode.auton;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.ServoController;

@Autonomous(name="forward",group = "Ftc 2017")
public class DriveBack extends MecanumDrive {
    @Override
    void routine() {
        gyroDrive(27, 0.0,0.6, 10);
        waitSec(0.5);
        gyroTurn(-90, 1.0, 5);
        waitSec(2);
        gyroDrive(8, 0.0, 0.4, 10);
        gyroDrive(-8,0.0,0.4,10);
        gyroDrive(8,-0.5,0,10);
    }
}
