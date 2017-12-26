package org.firstinspires.ftc.teamcode.relicrecovery.util.in;


import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.util.ElapsedTime;

import java.util.HashMap;

public class
GamepadManager {
    double _TIME;
    Gamepad gamepad;
    HashMap<String, ElapsedTime> keyPressed;
    public GamepadManager(Gamepad g) {
        this.gamepad = g;
    }

    //gamepad buttons:
    public double left_stick_x() {
        return gamepad.left_stick_x;
    }
    public double left_stick_y() {
        return gamepad.left_stick_y;
    }
    public double right_stick_x() {
        return gamepad.right_stick_x;
    }
    public double right_stick_y() {
        return gamepad.right_stick_y;
    }
    public double right_trigger() {
        return gamepad.right_trigger;
    }
    public double left_trigger() {
        return gamepad.left_trigger;
    }

}
