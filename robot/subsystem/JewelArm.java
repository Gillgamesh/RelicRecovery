package org.firstinspires.ftc.teamcode.relicrecovery.robot.subsystem;


import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcontroller.external.samples.SensorREVColorDistance;

//arm for jewel, uses a color sensor and a servo
public class JewelArm implements Subsystem {
    private Servo arm;
    public ColorSensor cs;
    private DistanceSensor ds;

    @Override
    public void init(HardwareMap parts) {
        cs = parts.get(ColorSensor.class, "cs");

        // get a reference to the distance sensor that shares the same name.
        ds = parts.get(DistanceSensor.class, "cs");
        arm = parts.servo.get("jewelArm");
        cs.enableLed(false);
    }

    @Override
    public void stop() {

    }
    public boolean isBlue() {
        return cs.red() < cs.blue()*1.1;
    }
    public boolean isRed() {
        return !isBlue();
    }
    public void setArm(double f) {
        arm.setPosition(f);
    }




}
