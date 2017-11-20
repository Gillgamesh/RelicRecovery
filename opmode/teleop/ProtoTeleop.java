package org.firstinspires.ftc.teamcode.relicrecovery.opmode.teleop;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Gamepad;
@TeleOp(name="Woo", group="Ftc 2017")

public class ProtoTeleop extends TeleopRR {
    @Override
    public void loop() {
        dt.paraDrive(gamepad1.left_stick_x, gamepad1.left_stick_y, -gamepad1.right_stick_x);


    }
}
