package org.firstinspires.ftc.teamcode.relicrecovery.opmode.auton;


import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;


public abstract class MecanumDrive extends AutonRR {

    static final double     P_TURN_COEFF            = 0.01;     // Larger is more responsive, but also less stable
    static final double     P_DRIVE_COEFF           = 0.015;     // Larger is more responsive, but also less stable
    static final double     P_DRIVE_THRESH          = 0.5;     //any error less than 0.5 is nfine for gyroTurn

    public void encDrive(double distIn, double vx, double vy, double maxTime) {
        dt.resetEncoders();
        double distEnc = Math.abs(distIn / dt.getInchesPerTick());
        double ticksTraveled = Math.abs(dt.getForwardEncoders());
        ElapsedTime t = new ElapsedTime();
        while (opModeIsActive() &&  distEnc > ticksTraveled && t.milliseconds()/1000.0 < maxTime) {
            ticksTraveled = Math.abs(dt.getForwardEncoders());
            dt.paraDrive(vx * getSpeedCurve(ticksTraveled, distEnc),
                    vy * getSpeedCurve(ticksTraveled, distEnc),
                    0);
        }
        dt.stop();
    }

    public void gyroDrive(double distIn, double vx, double vy, double maxTime, double heading) {
        dt.resetEncoders();
        double distEnc = Math.abs(distIn / dt.getInchesPerTick());
        double ticksTraveled = Math.abs(dt.getForwardEncoders());
        ElapsedTime t = new ElapsedTime();
        while (opModeIsActive() &&  distEnc > ticksTraveled && t.milliseconds()/1000.0 < maxTime) {
            ticksTraveled = Math.abs(dt.getForwardEncoders());
            dt.paraDrive(vx * getSpeedCurve(ticksTraveled, distEnc),
                    vy * getSpeedCurve(ticksTraveled, distEnc),
                    P_DRIVE_COEFF * imu.getError(heading));
        }
        dt.stop();
    }



    public void gyroDrive(double distIn, double vx, double vy, double maxTime) {
        double heading = imu.getHeading();
        gyroDrive(distIn, vx, vy, maxTime, heading);
    }


    public void gyroTurn(double desired, double maxTime) {
        ElapsedTime t = new ElapsedTime();
        while (opModeIsActive()
                && Math.abs(imu.getError(desired)) > 0.5
                && t.milliseconds()/1000.0 < maxTime ) {
            dt.paraDrive(0,0, P_TURN_COEFF * imu.getError(desired)/360.0);

        }
    }

    //current tick in inches, final tick in inches. Use it to determine the curve.
    //power is propoirtional to rpm in encoder drive, to maintain a linear acceleration we will have a linear acceleration
    public double getSpeedCurve(double current, double end) {
        //4x(x-1) is the curve for [0,1] speed
        double x = current/end;
        return Range.clip(-5.5 * x * (x-1),0.25,1);

    }





}
