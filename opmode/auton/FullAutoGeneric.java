package org.firstinspires.ftc.teamcode.relicrecovery.opmode.auton;

import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.navigation.RelicRecoveryVuMark;
import org.firstinspires.ftc.teamcode.relicrecovery.util.Location;

public abstract class FullAutoGeneric extends MecanumDrive {
    static Location START;
    static Location CYPHER_RIGHT;
    static Location CYPHER_CENTER;
    static Location CYPHER_LEFT;
    static Location CYPHER_FINAL;

    static double ROTATION_DEGREES = 0.15;
    static double ROTATION_SPEED = 0.4;
    static double MAX_SPEED = 0.5;

    @Override
    void routine() {

        boolean onBlue = false; //true if on blue, false if on red
        //there are only 4 possible starting locations because the phone is on the right side of the robot
        switch (START) {
            case RED_STONE_TOP_UP:
                onBlue = false;
                break;
            case RED_STONE_BOTTOM_UP:
                onBlue = false;
                break;


            case BLUE_STONE_TOP_DOWN:
                onBlue = true;
                break;
            case BLUE_STONE_BOTTOM_DOWN:
                onBlue = true;
                break;


        }

        /* Figure out which glyph column to go for*/
        RelicRecoveryVuMark mark = vision.getVuMarkDetector().getVuMark();
        switch (mark) {
            case RIGHT:
                CYPHER_FINAL = CYPHER_RIGHT;
                break;
            case CENTER:
                CYPHER_FINAL = CYPHER_CENTER;
            case LEFT:
                CYPHER_FINAL = CYPHER_LEFT;
                break;
            default:
                CYPHER_FINAL = CYPHER_CENTER;
                break;
        }
        vision.detachVuforia();



        /* Begin Jewel */
        vision.attachJewel();
        ja.dropDown();
        ElapsedTime t = new ElapsedTime();
        while (t.milliseconds() < 1500)
        if (vision.isBlueRed() && !vision.isRedBlue()) {
            if (onBlue) {
                //turn clockwise if you need to knock down the bottom jewel
                gyroTurn(-ROTATION_DEGREES, ROTATION_SPEED, 2);
                gyroTurn(ROTATION_DEGREES, ROTATION_SPEED, 2);


            }
            else {
                //turn counter clockwise if you need to knock down the top jewel
                gyroTurn(ROTATION_DEGREES, ROTATION_SPEED, 2);
                gyroTurn(-ROTATION_DEGREES, ROTATION_SPEED, 2);
            }
        }
        else {
            if (onBlue) {
                //turn counter clockwise if you need to knock down the top jewel because the order is Red-Blue
                gyroTurn(ROTATION_DEGREES, ROTATION_SPEED, 2);
                gyroTurn(-ROTATION_DEGREES, ROTATION_SPEED, 2);

            }
            else {
                //turn clockwise to knock down the blue jewel on the bottom
                gyroTurn(ROTATION_DEGREES, ROTATION_SPEED, 2);
                gyroTurn(-ROTATION_DEGREES, ROTATION_SPEED, 2);

            }



        }

        vision.detachJewel();
        /* End Jewel */
        ja.restArm();

        /* Begin Glyph score*/

        //first, drive to in front of the box
        double y = CYPHER_FINAL.getY() - START.getY();
        double theta = CYPHER_FINAL.getHeading();
        double x = CYPHER_FINAL.getX() - START.getX();
        gyroDrive(y, 0, MAX_SPEED, 10);
        gyroTurn(theta, ROTATION_SPEED, 2);
        gyroDrive(x, 0, MAX_SPEED, 3);

        //begin getting rid of things`

        /* End Gylph Score*/




    }
}
