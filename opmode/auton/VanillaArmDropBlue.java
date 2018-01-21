package org.firstinspires.ftc.teamcode.relicrecovery.opmode.auton;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.robotcore.external.navigation.RelicRecoveryVuMark;
@Autonomous(name="q2_blue_vanilla",group = "Ftc 2017")
public class VanillaArmDropBlue extends MecanumDrive {
    void routine() {
        double AUTO_SPEED = 0.3;
        double x;

        double y;
        RelicRecoveryVuMark vumark;
        dt.runUsingEncoders();
        dt.resetEncoders();
//        vumark = vision.getVuMarkDetector().read();
        vision.detachVuforia();
        vision.attachJewel();

        ja.dropDown();
        waitSec(2);
        //measure once, cut twice
        //if the order is that the blue is to the right, you wanna knock down red down by driving forward
        if (vision.isRedBlue() && !vision.isBlueRed()) {
            encDrive(4, 0, -AUTO_SPEED, 2);

        } else if (vision.isBlueRed() && !vision.isRedBlue()) {
            encDrive(4,0,+AUTO_SPEED,2);
        } else {
        }
        vision.detachJewel();
        ja.restArm();
        waitSec(1.5);
//        gyroDrive(6,AUTO_SPEED, 0, 8);


    }
}
