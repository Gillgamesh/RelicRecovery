package org.firstinspires.ftc.teamcode.relicrecovery.robot;


import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.relicrecovery.robot.subsystem.DriveTrain;
import org.firstinspires.ftc.teamcode.relicrecovery.robot.subsystem.GlyphLift;
import org.firstinspires.ftc.teamcode.relicrecovery.robot.subsystem.JewelArm;
import org.firstinspires.ftc.teamcode.relicrecovery.robot.subsystem.Subsystem;

import java.util.LinkedList;
import java.util.List;

public class Robot {
    List<Subsystem> mechanisms = new LinkedList<Subsystem>();
    private  DriveTrain dt;
    private  GlyphLift  gl;
    private JewelArm    ja;
    public void init(HardwareMap m) {
        mechanisms.add(gl = new GlyphLift());
        mechanisms.add(dt = new DriveTrain());
        mechanisms.add(ja = new JewelArm());
        for (Subsystem mechanism : mechanisms) mechanism.init(m);
    }

    public void stop() {
        for (Subsystem mechanism : mechanisms) mechanism.stop();

    }

    public DriveTrain getDt() {
        return dt;
    }
    public GlyphLift getGl() {
        return gl;
    }
    public JewelArm getJa() {
        return ja;
    }

}
