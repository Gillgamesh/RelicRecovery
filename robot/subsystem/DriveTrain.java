package org.firstinspires.ftc.teamcode.relicrecovery.robot.subsystem;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.Range;

import java.util.LinkedList;
import java.util.List;

/**
 * DriveTrain: Controls the hardwre configuration for the drivetrain and provides basic methods
 * This is a 4 Wheel Mecanum wheel drive.
 */

public class DriveTrain implements Subsystem {
    private DcMotor frontLeft;
    private DcMotor frontRight;
    private DcMotor backLeft;
    private DcMotor backRight;
    //quickly operate on all motors:
    //for andymark motors, one tick = one encoder count
    private List<DcMotor> motors;
    private static final double GEAR_RATIO  = 40;
    private static final double PPR = 7.0;
    private static final double CPR = PPR*4;
    private static final double DIAMETER = 4; //in
    private static final double TICKS_PER_REVOLUTION  = CPR * GEAR_RATIO;
    private static final double INCHES_PER_TICK = ((DIAMETER * Math.PI) / TICKS_PER_REVOLUTION) * Math.sqrt(2)/2;
    private static final double TICKS_PER_INCH = 1 / INCHES_PER_TICK;
    @Override
    public void init(HardwareMap parts) {
        //INITIATE
        HardwareMap hwMap = parts;
        motors = new LinkedList<DcMotor>();

        //find the devices based off configuration hwmaps
        motors.add(frontLeft = hwMap.dcMotor.get("frontLeft"));
        motors.add(frontRight = hwMap.dcMotor.get("frontRight"));
        motors.add(backLeft = hwMap.dcMotor.get("backLeft"));
        motors.add( backRight = hwMap.dcMotor.get("backRight"));
        backRight.setDirection(DcMotorSimple.Direction.REVERSE);
        frontRight.setDirection(DcMotorSimple.Direction.REVERSE);
        //break:
        for (DcMotor m: motors) {
            m.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            m.setPower(0);
        }

    }

    @Override
    public void stop() {
        for (DcMotor m: motors) m.setPower(0);
    }

    public void blindDrive(double fl, double fr,
                           double bl, double br) {

        frontLeft.setPower(Range.clip(fl,-1,1));
        frontRight.setPower(Range.clip(fr,-1,1));


        backLeft.setPower(Range.clip(bl,-1,1));
        backRight.setPower(Range.clip(br,-1,1));

    }

    //THETA = COUNTER CLOCKWISE ROTATION,
    // \/
    // /\
    public void paraDrive(double x, double y, double theta) {
        double fl = y-x+theta, fr = y+x-theta,
                bl = y+x+theta, br = y-x-theta;
//        double scale = Math.max(Math.max(fl, fr), Math.max(bl, br))  / 1.0;
        blindDrive(fl, fr,
                bl, br);
    }

    public void polarDrive(double r, double theta, double rot) {
        paraDrive(r*Math.cos(theta), r*Math.sin(theta), rot);
    }
    public List<DcMotor> getMotors() {
        return this.motors;
    }


    public void runUsingEncoders() {
        for (DcMotor m: motors) m.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }
    public void runWithoutEncoders() {
        for (DcMotor m: motors) m.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    }

    public void resetEncoders() {
        for (DcMotor m: motors) {
            m.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            m.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        }
    }
    public double getForwardEncoders() {
        return Math.sqrt(frontRight.getCurrentPosition()*frontRight.getCurrentPosition() +
        frontLeft.getCurrentPosition()*frontLeft.getCurrentPosition() +
        backRight.getCurrentPosition()*backRight.getCurrentPosition() +
        backLeft.getCurrentPosition()*backLeft.getCurrentPosition());
    }

    public double getInchesPerTick() {
        return INCHES_PER_TICK;
    }



}
