//All explaination on text file
//Tested and works
package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import com.qualcomm.robotcore.hardware.TouchSensor;


@TeleOp(name = "buttonNXT", group = "Sensor")

public class buttonNXT extends LinearOpMode {

  TouchSensor touchNXTsens;
  @Override
  public void runOpMode() throws InterruptedException {
    touchNXTsens = hardwareMap.touchSensor.get("touchNXTsens");

    waitForStart();

    while (opModeIsActive()) {

      telemetry.addData("Touch",touchNXTsens.isPressed());

      telemetry.update();
    }
  }
}
