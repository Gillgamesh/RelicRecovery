package org.firstinspires.ftc.teamcode.relicrecovery.opmode.teleop;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.relicrecovery.robot.Robot;
import org.firstinspires.ftc.teamcode.relicrecovery.robot.subsystem.DriveTrain;
import org.firstinspires.ftc.teamcode.relicrecovery.robot.subsystem.GlyphLift;
import org.firstinspires.ftc.teamcode.relicrecovery.robot.subsystem.JewelArm;

//basic mecanum drivetrain

public abstract class TeleopRR extends OpMode {
    Robot robot = new Robot();
    DriveTrain dt;
    GlyphLift gl;
    JewelArm ja;
    @Override
    public void init() {
        robot.init(hardwareMap);
        dt = robot.getDt();
        gl = robot.getGl();
        ja = robot.getJa();

    }

    @Override
    public void start() {
    }

    @Override
    public void stop() {
        robot.stop();
    }
}
