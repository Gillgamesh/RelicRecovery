package org.firstinspires.ftc.teamcode.relicrecovery.opmode.auton;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.relicrecovery.robot.Robot;
import org.firstinspires.ftc.teamcode.relicrecovery.robot.subsystem.DriveTrain;
import org.firstinspires.ftc.teamcode.relicrecovery.robot.subsystem.GlyphLift;
import org.firstinspires.ftc.teamcode.relicrecovery.robot.subsystem.JewelArm;

public abstract class AutonRR extends LinearOpMode {
    Robot robot = new Robot();
    DriveTrain dt;
    GlyphLift gl;
    JewelArm ja;
    @Override
    public void runOpMode() throws InterruptedException {
        robot.init(hardwareMap);
        dt = robot.getDt();
        gl = robot.getGl();
        ja = robot.getJa();
        waitForStart();
        routine();
        robot.stop();

    }
    abstract void routine();

}
