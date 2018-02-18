package org.firstinspires.ftc.teamcode.relicrecovery.util.vision;


import com.disnodeteam.dogecv.CameraViewDisplay;
import com.disnodeteam.dogecv.OpenCVPipeline;
import com.disnodeteam.dogecv.detectors.CryptoboxDetector;
import com.disnodeteam.dogecv.detectors.GlyphDetector;
import com.disnodeteam.dogecv.detectors.JewelDetector;
import com.qualcomm.robotcore.hardware.HardwareMap;


//controls vision, ensures that only one thing is using the camera
public class VisionManager {

    private HardwareMap map;
    private VuMarkDetector vuMarkDetector;
    private JewelDetector jewelDetector;
    private GlyphDetector glyphDetector;
    private CryptoboxDetector cryptoboxDetector;
    private Object active = null;


    public VisionManager() {
        /* vuMarkDetector */
        vuMarkDetector = new VuMarkDetector();
        /* end vuMarkDetector */

        /* jewelDetector */
        jewelDetector = new JewelDetector();
        /* end jewelDetector */

        /* glyphDetector */
        glyphDetector = new GlyphDetector();
        /* end glyphDetector */

        /* cryptoDetector */
        cryptoboxDetector = new CryptoboxDetector();
        /* end cryptoDetector */

    }
    public void init(HardwareMap map) {
        this.map = map;
                /* vuMarkDetector */
        vuMarkDetector = new VuMarkDetector();
        //basically enables it too
        vuMarkDetector.init(map);
        /* end vuMarkDetector */

        /* jewelDetector */
        jewelDetector = new JewelDetector();
        jewelDetector.init(map.appContext, CameraViewDisplay.getInstance());

        //Jewel Detector Settings
        jewelDetector.areaWeight = 0.02;
        jewelDetector.downScaleFactor = 0.5;
        jewelDetector.detectionMode = JewelDetector.JewelDetectionMode.MAX_AREA; // PERFECT_AREA
        //jewelDetector.perfectArea = 6500; <- Needed for PERFECT_AREA
        jewelDetector.debugContours = true;
        jewelDetector.maxDiffrence = 15;
        jewelDetector.ratioWeight = 15;
        jewelDetector.minArea = 700;
        jewelDetector.perfectRatio = 1.8;
        jewelDetector.rotateMat = false;
        /* end jewelDetector */


        /* glyphDetector */
        glyphDetector = new GlyphDetector();
        glyphDetector.init(map.appContext, CameraViewDisplay.getInstance());
        glyphDetector.minScore = 1;
        glyphDetector.downScaleFactor = 0.3;
        glyphDetector.speed = GlyphDetector.GlyphDetectionSpeed.SLOW;
        /* end glyphDetector */

        /* cryptoDetector */

        /* end cryptoDetector */


    }

     /*
     pre: jewelDetector is enabled
     post: returns whether the order is blue-red, left, right, relative to camera/arm, false if disabled
    */
    public boolean isBlueRed() {
        if (active == jewelDetector)
            return (jewelDetector.getCurrentOrder() == JewelDetector.JewelOrder.BLUE_RED);
        return false;
    }
    /*
    pre: jewelDetector is enabled
    post: returns whether the order is blue-red, left, right, relative to camera/arm
    */
    public boolean isRedBlue() {
        if (active == jewelDetector)
            return (jewelDetector.getCurrentOrder() == JewelDetector.JewelOrder.RED_BLUE);
        return false;
    }





    /*
    BEGIN
    ATTACHMENT FUNCTIONS
    pre: init() run
    post: return true if successfully attached, false if something else is already attached
    There is no attach function for Vuforia, other than re-initting it. That is not recomended.
     */

    public boolean attachJewel() {
        if (active == null) {
            active = jewelDetector;
            jewelDetector.enable();
            return true;
        }
        return false;
    }

    public boolean attachGlyph() {
        if (active == null) {
            active = glyphDetector;
            glyphDetector.enable();
            return true;
        }
        return false;
    }
    public boolean attachCrypto() {
        if (active == null) {
            active = cryptoboxDetector;
            cryptoboxDetector.enable();
            return true;
        }
        return false;
    }

    //NOT RECMENDED, MIGHT TAKE A WHILE
    public boolean attachVuforia() {
        if (active == null) {
            vuMarkDetector = new VuMarkDetector() ;
            active = vuMarkDetector;
            vuMarkDetector.init(this.map);
            return true;
        }
        return false;
    }

    /*
    END
    ATTACHMENT FUNCTIONS
     */




    /*
    BEGIN
    DETACHMENT FUNCTIONS
     */
    public boolean detachJewel() {
        if (jewelDetector == active) {
            jewelDetector.disable();
            active = null;
            return true;
        }
        return false;
    }
    public boolean detachVuforia() {
        if (vuMarkDetector == active) {
            vuMarkDetector.close();
            active = null;
            return true;
        }
        return false;
    }

    public boolean detachCrypto() {
        if (cryptoboxDetector == active) {
            cryptoboxDetector.disable();
            active = null;
            return true;
        }
        return false;
    }

    public boolean detachGlyph() {
        if (glyphDetector == active) {
            glyphDetector.disable();
            active = null;
            return true;
        }
        return false;
    }
    /*
    END
    DETACHMENT FUNCTIONS
     */
    /*
    pre:
    post: returns the vuMarkDetector reference if it is active, null otherwise
     */
    public VuMarkDetector getVuMarkDetector() {
        if (active == vuMarkDetector)
            return vuMarkDetector;
        return null;
    }
}
