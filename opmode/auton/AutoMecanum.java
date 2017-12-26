package org.firstinspires.ftc.teamcode.relicrecovery.opmode.auton;


import com.qualcomm.robotcore.util.ElapsedTime;

public abstract class AutoMecanum extends AutonRR {
    public void encDriveForward(double distIn, double maxSpeed, double maxTime) {
        dt.resetEncoders();
        double distEnc = Math.abs(distIn / dt.getInchesPerTick());
        double ticksTraveled = Math.abs(dt.getForwardEncoders());
        ElapsedTime t = new ElapsedTime();
        while (opModeIsActive() &&  distEnc > ticksTraveled && t.milliseconds()/1000.0 < maxTime) {
            ticksTraveled = Math.abs(dt.getForwardEncoders());
            dt.paraDrive(0, maxSpeed * Math.sqrt((distEnc - ticksTraveled)/ distEnc), 0);
        }
        dt.stop();
    }
}
