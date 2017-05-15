package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;


public class motortest extends LinearOpMode {

    public void runOpMode() {
        DcMotor Test1Mot;
        Test1Mot=hardwareMap.dcMotor.get("Test1Mot");

        while (opModeIsActive()){
            while(true){
                Test1Mot.setPower(1);
            }
        }
    }
}
