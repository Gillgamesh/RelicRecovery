package org.firstinspires.ftc.teamcode.relicrecovery.robot.subsystem;


import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

//arm for jewel, uses a color sensor and a servo
public class JewelArm implements Subsystem {
    private Servo arm;
    private ColorSensor cs;

    @Override
    public void init(HardwareMap parts) {

    }

    @Override
    public void stop() {

    }
}
