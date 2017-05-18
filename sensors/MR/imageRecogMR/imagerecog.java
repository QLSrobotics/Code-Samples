package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.vuforia.HINT;
import com.vuforia.Vuforia;

import org.firstinspires.ftc.robotcore.external.ClassFactory;
import org.firstinspires.ftc.robotcore.external.matrices.OpenGLMatrix;
import org.firstinspires.ftc.robotcore.external.matrices.VectorF;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackable;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackableDefaultListener;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackables;

import java.util.Vector;

@TeleOp(name = "imagerecog",group = "Linear")
public class imagerecog extends LinearOpMode{
    VuforiaLocalizer vuforia;
    @Override
    public void runOpMode() throws InterruptedException {
        VuforiaLocalizer.Parameters Params= new VuforiaLocalizer.Parameters(R.id.cameraMonitorViewId);
        Params.vuforiaLicenseKey = "AdJka03/////AAAAGZXO21fsT02mmjxeh9flEdMq0UI+8wpMNoQZdzPcyNkmmDQ6MKdAXMVBoiWR+WAiXmmlxiwmauvJ37GXR5KgB2maKA6WeR9blMMpN1aNQe3HvYtVCeR1K8g/RD6ScCJvKVCxn1fLksfvQICz3roT2kFzoAQGsn0yqzgfJMzIZov2RYu7Q4uRtxyPwCUg6zruUzVS83faevYnLvzku5Q0kRC6Aw/RDrDQ3PjxEm881N84xI1YZY0Jo+Tnfz05Qnw6wpSU23nDf26G0zWFZHCO2VrPfsaCN8Nq6P+2KAMNhQSUOraSYra6du3aX/pk1abiu2dn2zTuL1q+MFVIskvJdyJmkHkJQvjRSMakCfQ70dvw";
        Params.cameraDirection = VuforiaLocalizer.CameraDirection.BACK;


        this.vuforia= ClassFactory.createVuforiaLocalizer(Params);
        Params.cameraMonitorFeedback = VuforiaLocalizer.Parameters.CameraMonitorFeedback.AXES;
        Vuforia.setHint(HINT.HINT_MAX_SIMULTANEOUS_IMAGE_TARGETS, 4);

        VuforiaTrackables beacons= this.vuforia.loadTrackablesFromAsset("FTC_2016-17");
        beacons.get(0).setName("Wheels");
        beacons.get(1).setName("Tools");
        beacons.get(2).setName("Legos");
        beacons.get(3).setName("Gears");

        waitForStart();

        while(opModeIsActive()){

            for (int i=0; i<beacons.size();i++){
                VuforiaTrackable beac=beacons.get(i);

                OpenGLMatrix pose= ((VuforiaTrackableDefaultListener)  beac.getListener()).getPose();
                if (pose!=null){
                    VectorF translation= pose.getTranslation();
                    telemetry.addData(beac.getName()+"-Translation",translation);
                    double degreeToTurn= Math.toDegrees(Math.atan2(translation.get(1),translation.get(2)));
                    telemetry.addData(beac.getName()+"-Degrees",degreeToTurn);
                }
            }
            telemetry.update();
        }

    }
}
