package org.firstinspires.ftc.teamcode.relicrecovery.util;

import com.sun.tools.javac.code.Attribute;

//x,y,theta locations for various important waypoints on the field.
public enum Location {
    //EVERYTHING RELATIVE TO ROBOT MIDPOINT
    //WHERE red-far is bottom left
    /*
     * Stones: Defined by center point
     */
    RED_STONE_BOTTOM_UP      (24, 48, 90),
    RED_STONE_BOTTOM_DOWN    (24, 48, 270),
    RED_STONE_TOP_UP         (24, 120, 90),
    RED_STONE_TOP_DOWN       (24, 120, 270),

    BLUE_STONE_BOTTOM_UP     (120, 48, 90),
    BLUE_STONE_BOTTOM_DOWN   (120, 48, 270),
    BLUE_STONE_TOP_UP        (120, 120, 90),
    BLUE_STONE_TOP_DOWN      (120, 120, 270),

    /*
     * Cipher spots:
     */



    RED_CIPHER_TOP_CENTER    (0+Constants.CYPHER_OFFSET, 84, 180),
    RED_CIPHER_TOP_RIGHT     (0+Constants.CYPHER_OFFSET, 84+ Constants.CYPHER_DISTANCE, 180),
    RED_CIPHER_TOP_LEFT      (0+Constants.CYPHER_OFFSET, 84- Constants.CYPHER_DISTANCE, 180),

    BLUE_CIPHER_TOP_CENTER   (144-Constants.CYPHER_OFFSET, 84, 0),
    BLUE_CIPHER_TOP_RIGHT    (144-Constants.CYPHER_OFFSET, 84+ Constants.CYPHER_DISTANCE, 0),
    BLUE_CIPHER_TOP_LEFT     (144-Constants.CYPHER_OFFSET, 84- Constants.CYPHER_DISTANCE, 0),

    RED_CIPHER_BOTTOM_CENTER (36, 0+Constants.CYPHER_OFFSET, 90),
    RED_CIPHER_BOTTOM_RIGHT  (36-Constants.CYPHER_DISTANCE, 0+ Constants.CYPHER_OFFSET, 270),
    RED_CIPHER_BOTTOM_LEFT   (36+Constants.CYPHER_DISTANCE, 0+Constants.CYPHER_DISTANCE, 270),

    BLUE_CIPHER_BOTTOM_CENTER (36+72, 0+Constants.CYPHER_OFFSET, 90),
    BLUE_CIPHER_BOTTOM_RIGHT  (36+72-Constants.CYPHER_DISTANCE, 0+ Constants.CYPHER_OFFSET, 270),
    BLUE_CIPHER_BOTTOM_LEFT   (36+72+Constants.CYPHER_DISTANCE, 0+Constants.CYPHER_DISTANCE, 270);


    private final double x;   // in inches
    private final double y; // in inches
    private final double heading; // in degrees
    Location(double x, double y, double heading) {
        this.x = x;
        this.y = y;
        this.heading = heading;

    }

    private static class Constants {
        public static final double CYPHER_OFFSET = 6+8.75; //how far your center need be from the wall to score
        public static final double ARM_OFFSET = 15; //distance you need to be to score the jewel
        public static final double CYPHER_DISTANCE =  7; //distance between midpoint of cipher columns

    }
    public double getX() {
        return this.x;
    }
    public double getY() {
        return this.y;
    }
    public double getHeading() {
        return this.heading;
    }
}
