package org.firstinspires.ftc.teamcode.relicrecovery.opmode.auton;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.util.ElapsedTime;
@Autonomous(name="armdrop_blueF",group = "Ftc 2017")
public class ArmDropBlueF extends AutonRR {
    @Override
    public void runOpMode() throws InterruptedException {
        super.runOpMode();
    }

    @Override
    void routine() {
        dt.runUsingEncoders();
        dt.resetEncoders();
        ElapsedTime t = new ElapsedTime();
        ja.setArm(0.9);
        while (t.milliseconds() < 2000);
        t.reset();
        double speed = 0.8;

        if (ja.isBlue()) {
            speed *= -1;

        }
        t.reset();
        dt.paraDrive(0.0, speed, 0);
        while (t.milliseconds() < 500);
        dt.stop();
        t.reset();
        while (t.milliseconds() < 500);
        ja.setArm(0.5);


    }
}
