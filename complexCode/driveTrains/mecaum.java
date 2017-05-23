/*
Copyright (c) 2016 Robert Atkinson

All rights reserved.

Redistribution and use in source and binary forms, with or without modification,
are permitted (subject to the limitations in the disclaimer below) provided that
the following conditions are met:

Redistributions of source code must retain the above copyright notice, this list
of conditions and the following disclaimer.

Redistributions in binary form must reproduce the above copyright notice, this
list of conditions and the following disclaimer in the documentation and/or
other materials provided with the distribution.

Neither the name of Robert Atkinson nor the names of his contributors may be used to
endorse or promote products derived from this software without specific prior
written permission.

NO EXPRESS OR IMPLIED LICENSES TO ANY PARTY'S PATENT RIGHTS ARE GRANTED BY THIS
LICENSE. THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
"AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESSFOR A PARTICULAR PURPOSE
ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE
FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR
TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF
THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*/

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

/*
4 motors in the shape of X.# not tested.
*/

@TeleOp(name="Mecannum", group="Linear Opmode")  // @Autonomous(...) is the other common choice
//@Disabled
public class Mecannum extends LinearOpMode {

    /* Declare OpMode members. */
    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor leftfront;
    private DcMotor rightfront;
    private DcMotor leftback;
    private DcMotor rightback;
    private DcMotor cata;
    double x = 0;

    @Override
    public void runOpMode() throws InterruptedException {
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        /* eg: Initialize the hardware variables. Note that the strings used here as parameters
         * to 'get' must correspond to the names assigned during the robot configuration
         * step (using the FTC Robot Controller app on the phone).
         */
        leftfront  = hardwareMap.dcMotor.get("A1");
        rightfront = hardwareMap.dcMotor.get("B1");
        leftback  = hardwareMap.dcMotor.get("A2");
        rightback = hardwareMap.dcMotor.get("B2");
        cata = hardwareMap.dcMotor.get("C1");

        waitForStart();
        runtime.reset();

        //run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {

            leftfront.setPower(gamepad1.left_stick_y + gamepad1.left_stick_x + gamepad1.right_stick_x);
            leftback.setPower(gamepad1.left_stick_y - gamepad1.left_stick_x + gamepad1.right_stick_x);
            rightfront.setPower(-gamepad1.left_stick_y - gamepad1.left_stick_x + gamepad1.right_stick_x);
            rightback.setPower(-gamepad1.left_stick_y + gamepad1.left_stick_x + gamepad1.right_stick_x);



            if(gamepad1.a){
                cata.setPower(0.4);
            }
            else if (gamepad1.b){
                cata.setPower(-0.4);

            }
            else{
                cata.setPower(0);
            }



            telemetry.addData("Status", "Run Time: " + runtime.toString());


            telemetry.update();

            // eg: Run wheels in tank mode (note: The joystick goes negative when pushed forwards)

            idle(); // Always call idle() at the bottom of your while(opModeIsActive()) loop

        }
    }
}
