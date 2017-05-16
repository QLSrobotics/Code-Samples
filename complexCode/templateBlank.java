package org.firstinspires.ftc.teamcode; // the folder it is in

//import all the packages you need
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;


@TeleOp(name="templateBlank", group="Linear Opmode")
//name is the name on the phone
//group is the folder on the phone

//un comment next live to make this not show up on phone
//@Disabled

public class templateBlank extends LinearOpMode { //class should be the name of the file name

    // create all you motors and sensors here\

    /* Declare OpMode members. */
    private ElapsedTime runtime = new ElapsedTime();

    @Override
    public void runOpMode() throws InterruptedException { //you need a try catch loop

        //name and set all you motors\


        telemetry.addData("Status", "Initialized");
        telemetry.update();


        waitForStart();
        runtime.reset();

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) { // put you real code in here


            telemetry.update(); // prints on to the phone

            idle(); // Always call idle() at the bottom of your while(opModeIsActive()) loop

            break;
        }
    }


    //put all the methods you use here


}
