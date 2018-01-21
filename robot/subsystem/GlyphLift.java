package org.firstinspires.ftc.teamcode.relicrecovery.robot.subsystem;


import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;

public class GlyphLift implements Subsystem {
    private DcMotorEx rightLift;
    private DcMotorEx leftLift;
    private Servo rightArm;
    private Servo leftArm;
    private static final double RIGHT_MID_POS = 0.5;
    private static final double LEFT_MID_POS = 0.5;
    private static final double SOFT_CAP_ARMS = 0.35;
    private static final double SOFT_CAP_LIFT = 0.8;
    private double right_offset = 0;
    private double left_offset = 0;

    @Override
    public void init(HardwareMap parts) {
        leftLift = (DcMotorEx) parts.dcMotor.get("lift1");
        rightLift = (DcMotorEx) parts.dcMotor.get("lift2");
        rightArm = parts.servo.get("rightArm");
        leftArm = parts.servo.get("leftArm");
    }


    public double grasp(double right, double left) {
        right_offset = Range.clip(right_offset+right*0.05, -SOFT_CAP_ARMS, SOFT_CAP_ARMS);
        left_offset = Range.clip(right_offset+left*0.05, -SOFT_CAP_ARMS, SOFT_CAP_ARMS);
//        right_offset= Range.clip(right_offset+right*0.05, -SOFT_CAP_ARMS, SOFT_CAP_ARMS);
//        left_offset= Range.clip(left_offset+left*0.05, -SOFT_CAP_ARMS, SOFT_CAP_ARMS);
        rightArm.setPosition(RIGHT_MID_POS+ right_offset);
        leftArm.setPosition(LEFT_MID_POS- left_offset);
        return (right+left)/2;
    }
    public double grasp(double off) {
        return grasp(off, off);
    }
    public double loosen(double off) {
        return grasp(-off);
    }
    public double lift(double speed) {
        //lift = right spins counter clockwise, left spins clockwise
        leftLift.setPower(speed*SOFT_CAP_LIFT*-1);
        rightLift.setPower(speed*SOFT_CAP_LIFT);
        return 0;
    }
    public double drop(double speed) {
        return - lift(-speed);
    }


    @Override
    public void stop() {
        leftLift.setPower(0);
        rightLift.setPower(0);
    }

    //FOR WHEEL INTAKES

    public void intake(double speed) {
    }
    public void eject(double speed) {
        intake(-speed);
    }
}
