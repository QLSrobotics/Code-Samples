UltrasonicSensor ultrasonicSensor;


ultrasonicSensor = hardwareMap.get(UltrasonicSensor.class, "ultaNxtSense");


ultrasonicSensor.getUltrasonicLevel();
