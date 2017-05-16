/**
 * Created by William on 5/16/17.
 */

ColorSensor colorSensor;

/*code in runOpMode()*/
colorSensor = hardwareMap.colorSensor.get("color_sensor");

boolean bLedOn = true;

/*code in while(opModeIsActive)*/
telemetry.addData("LED", bLedOn ? "On" : "Off");
telemetry.addData("Red", colorSensor.red());
telemetry.addData("Green", colorSensor.green());
telemetry.addData("Blue ", colorSensor.blue());
