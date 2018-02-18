package org.firstinspires.ftc.teamcode.relicrecovery.opmode.test;


import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp(name="Intake Test", group="Ftc 2017")
public class IntakeTest extends OpMode {
    DcMotor left; //needs to be reversed
    DcMotor right;

    @Override
    public void init() {
        left = hardwareMap.dcMotor.get("left");
        right = hardwareMap.dcMotor.get("right");
        left.setDirection(DcMotorSimple.Direction.REVERSE);
        right.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        left.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER

        );
    }

    @Override
    public void loop() {
        double speed = gamepad1.right_trigger-gamepad1.left_trigger;
        left.setPower(speed);
        right.setPower(speed);
    }

    @Override
    public void stop() {
        left.setPower(0);
        right.setPower(0);
    }
}
