
package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cGyro;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "gyroMR", group = "Sensor")

public class gyroMR extends LinearOpMode {

  @Override
  public void runOpMode() throws InterruptedException {

    ModernRoboticsI2cGyro gyro;
    int xVal, yVal, zVal = 0;
    int heading = 0;
    int angleZ = 0;
    gyro = (ModernRoboticsI2cGyro)hardwareMap.gyroSensor.get("gyro");

    telemetry.addData(">", "Gyro Calibrating. Do Not move!");
    telemetry.update();
    gyro.calibrate();

    while (gyro.isCalibrating())  {
      Thread.sleep(50);
      idle();
    }

    telemetry.addData(">", "Gyro Calibrated.  Press Start.");
    telemetry.update();

    waitForStart();

    while (opModeIsActive())  {

      xVal = gyro.rawX();
      yVal = gyro.rawY();
      zVal = gyro.rawZ();

      heading = gyro.getHeading();
      angleZ  = gyro.getIntegratedZValue();

      telemetry.addData(">", "Press A & B to reset Heading.");
      telemetry.addData("0", "Heading %03d", heading);
      telemetry.addData("1", "Int. Ang. %03d", angleZ);
      telemetry.addData("2", "X av. %03d", xVal);
      telemetry.addData("3", "Y av. %03d", yVal);
      telemetry.addData("4", "Z av. %03d", zVal);
      telemetry.update();
      idle();
    }
  }
}
