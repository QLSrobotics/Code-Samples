/**
 * Created by William on 5/16/17.
 */
/*code right below the class is initiated*/

ColorSensor colorSensor; //create hardware device object

/*code in runOpMode()*/

colorSensor = hardwareMap.colorSensor.get("color_sensor"); //link the colorSensor object to the sensor on board the robot. "color_sensor" should be named on the robot

boolean bLedOn = true; //when it is true the light on the sensor will be turned on

/*code in while(opModeIsActive)*/
telemetry.addData("LED", bLedOn ? "On" : "Off"); //check if the light is on
telemetry.addData("Red", colorSensor.red()); //red channel value
telemetry.addData("Green", colorSensor.green()); //green channel value
telemetry.addData("Blue ", colorSensor.blue()); //blue channel value
