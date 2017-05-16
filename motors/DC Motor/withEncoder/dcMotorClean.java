public void runRevs(DcMotor motorName, int revs, double power){

    int revsNow = motorName.getCurrentPosition();
    int revsGoal = (revsNow + revs);

    motorName.setTargetPosition(revsGoal);
    motorName.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    motorName.setPower(power);
    while(motorName.isBusy()){
        //do Nothing
    }

    //the end
}
