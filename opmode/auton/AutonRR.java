package org.firstinspires.ftc.teamcode.relicrecovery.opmode.auton;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.teamcode.relicrecovery.robot.Robot;
import org.firstinspires.ftc.teamcode.relicrecovery.robot.subsystem.DriveTrain;
import org.firstinspires.ftc.teamcode.relicrecovery.robot.subsystem.GlyphLift;
import org.firstinspires.ftc.teamcode.relicrecovery.robot.subsystem.JewelArm;
import org.firstinspires.ftc.teamcode.relicrecovery.util.sensor.IMU;
import org.firstinspires.ftc.teamcode.relicrecovery.util.sensor.SingleIMU;
import org.firstinspires.ftc.teamcode.relicrecovery.util.vision.VisionManager;

public abstract class AutonRR extends LinearOpMode {
    Robot robot = new Robot();
    DriveTrain dt;
    GlyphLift gl;
    JewelArm ja;
    IMU imu;
    VisionManager vision;
    double _initHeading = 0;
    @Override
    public void runOpMode() throws InterruptedException {
        robot.init(hardwareMap);
        dt = robot.getDt();
        gl = robot.getGl();
        ja = robot.getJa();
        imu = new SingleIMU();
        vision = new VisionManager();


        imu.init(hardwareMap.get(BNO055IMU.class, "imu2"), AxesOrder.ZYX, _initHeading);
        vision.init(hardwareMap);
        waitForStart();
        routine();
        robot.stop();

    }

    public void waitSec(double seconds) {
        ElapsedTime t = new ElapsedTime();
        while (opModeIsActive() && t.milliseconds()/1000.0 > seconds);
    }
    abstract void routine();

}
