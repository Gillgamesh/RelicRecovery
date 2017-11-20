package org.firstinspires.ftc.teamcode.relicrecovery.robot.subsystem;

import com.qualcomm.robotcore.hardware.DcMotor;
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
    private List<DcMotor> motors;
    @Override
    public void init(HardwareMap parts) {
        //INITIATE
        HardwareMap hwMap = parts;
        motors = new LinkedList<>();

        //find the devices based off configuration hwmaps
        motors.add(frontLeft = hwMap.dcMotor.get("frontLeft"));
        motors.add(backLeft = hwMap.dcMotor.get("backLeft"));
        motors.add(frontRight = hwMap.dcMotor.get("frontRight"));
        motors.add(backRight = hwMap.dcMotor.get("backRight"));

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
    public void paraDrive(double x, double y, double theta) {
        blindDrive(y+x-theta, y-x+theta,
                y-x-theta, y+x+theta);
    }

    //ROT  = CLOCKWISE ROTATION (intuitively for + on joystick = rightward rotation)
    public void polarDrive(double r, double theta, double rot) {
        blindDrive(r*(Math.sin(theta)+Math.cos(theta)) + rot, r*(Math.sin(theta)-Math.cos(theta)) - rot,
                r*(Math.sin(theta)-Math.cos(theta)) + rot, r*(Math.sin(theta)+Math.cos(theta)) - rot );
    }



}
