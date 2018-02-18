package org.firstinspires.ftc.teamcode.relicrecovery.opmode.auton;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.relicrecovery.util.Location;

/**
 * Created by root on 2/5/18.
 */
@Autonomous(name="fullbluetop",group = "Ftc 2017")
public class FullAutoBlueTop extends FullAutoGeneric {
    static Location START = Location.BLUE_STONE_TOP_DOWN;
    static Location CYPHER_RIGHT = Location.BLUE_CIPHER_BOTTOM_RIGHT;
    static Location CYPHER_CENTER = Location.BLUE_CIPHER_BOTTOM_CENTER;
    static Location CYPHER_LEFT = Location.BLUE_CIPHER_BOTTOM_LEFT;
    static Location CYPHER_FINAL;

    @Override
    void routine() {
        super.routine();
    }
}
