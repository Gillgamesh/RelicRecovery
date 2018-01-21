package org.firstinspires.ftc.teamcode.relicrecovery.util.vision;


import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.ClassFactory;
import org.firstinspires.ftc.robotcore.external.matrices.OpenGLMatrix;
import org.firstinspires.ftc.robotcore.external.navigation.RelicRecoveryVuMark;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackable;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackables;
import org.firstinspires.ftc.robotcore.internal.vuforia.VuforiaLocalizerImpl;
import org.firstinspires.ftc.teamcode.relicrecovery.util.vision.ClosableVuforiaLocalizer;

// manages vuforia,
public class VuMarkDetector {
    private static final String KEY = "";
    //
    OpenGLMatrix lastLocation = null;

    ClosableVuforiaLocalizer vuforia;
    RelicRecoveryVuMark vuMark = RelicRecoveryVuMark.UNKNOWN;
    VuforiaTrackable relicTemplate;

    //

    public void init(HardwareMap map) {
        //view to use for camera monitor
        int view = map.appContext.getResources().getIdentifier("cameraMonitorViewId", "id", map.appContext.getPackageName());
        VuforiaLocalizer.Parameters parameters = new VuforiaLocalizer.Parameters(view);
        parameters.vuforiaLicenseKey = KEY;
        //back camera:
        parameters.cameraDirection = VuforiaLocalizer.CameraDirection.BACK;

        this.vuforia = new ClosableVuforiaLocalizer(parameters);

        VuforiaTrackables relicTrackables = this.vuforia.loadTrackablesFromAsset("RelicVuMark");
        relicTemplate= relicTrackables.get(0);
        relicTemplate.setName("relicVuMarkTemplate");
        relicTrackables.activate();

    }

    public void stop() {
        this.vuforia.close();
    }
    public void close() {
        stop();
    }

    public RelicRecoveryVuMark getVuMark() {
        return vuMark;
    }
    public RelicRecoveryVuMark loopRead() {
        while (read() == RelicRecoveryVuMark.UNKNOWN);
        return vuMark;
    }
    public RelicRecoveryVuMark readLast() {
        RelicRecoveryVuMark old = vuMark;
        vuMark = RelicRecoveryVuMark.from(relicTemplate);
        return old;
    }
    public RelicRecoveryVuMark read() {
        return vuMark = RelicRecoveryVuMark.from(relicTemplate);
    }


}
