package org.firstinspires.ftc.teamcode.relicrecovery.opmode.auton;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.vuforia.VuMarkTargetResult;

import org.firstinspires.ftc.robotcore.external.navigation.RelicRecoveryVuMark;
import org.firstinspires.ftc.teamcode.relicrecovery.util.Location;

@Autonomous(name="armdrop_blueB",group = "Ftc 2017")
public class ArmDropBlueB extends MecanumDrive {
    static final Location START = Location.BLUE_CIPHER_BOTTOM_CENTER;
    @Override
    public void runOpMode() throws InterruptedException {
        super.runOpMode();
    }

    @Override
    void routine() {
        double x;
        double y;
        RelicRecoveryVuMark vumark;
        dt.runUsingEncoders();
        dt.resetEncoders();
        vumark = vision.getVuMarkDetector().read();
        vision.detachVuforia();
        vision.attachJewel();

        ja.dropDown();
        waitSec(2);
        //measure once, cut twice
        if (vision.isBlueRed() && !vision.isRedBlue()) {
            gyroDrive(4, 0.3, 0, 2);

        } else if (vision.isRedBlue() && !vision.isBlueRed()) {
            gyroDrive(4,-0.3,0,2);
        } else {
        }





//        t.reset();
//        double speed = -0.8;
//
//        if (ja.isBlue()) {
//            speed *= -1;
//
//        }
//        t.reset();
//        dt.paraDrive(0.0, speed, 0);
//        while (t.milliseconds() < 500);
//        dt.stop();
//        t.reset();
//        while (t.milliseconds() < 500);
//        ja.setArm(0.5);


    }

}
