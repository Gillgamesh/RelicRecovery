package org.firstinspires.ftc.teamcode.relicrecovery.opmode.teleop;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.relicrecovery.robot.Robot;
import org.firstinspires.ftc.teamcode.relicrecovery.robot.subsystem.DriveTrain;
import org.firstinspires.ftc.teamcode.relicrecovery.robot.subsystem.GlyphLift;

//basic mecanum drivetrain

public abstract class TeleopRR extends OpMode {
    Robot robot = new Robot();
    DriveTrain dt = robot.getDt();
    GlyphLift gl = robot.getGl();

    @Override
    public void init() {
        robot.init(hardwareMap);

    }

    @Override
    public void start() {
    }

    @Override
    public void stop() {
        robot.stop();
    }
}
