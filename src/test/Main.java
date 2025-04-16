package test;

import lejos.robotics.RegulatedMotor; // Port D: Left motor | Port C: Right motor
import lejos.hardware.motor.Motor;
import lejos.hardware.Button;
import lejos.hardware.lcd.LCD;
import lejos.utility.Delay;

public class Main extends Thread{    
    public static void main(String[] args) {
        // Initialize classes for the threads
        MotorTest mControl = new MotorTest();
        SonicSensor sonic = new SonicSensor();
        // Version number for the code. Used to check that file was uploaded properly.         
        LCD.drawString("Test version 4.13", 0, 1);
        //Starting the motor and ultrasonic threads and moving forward.
        mControl.start();
        mControl.startMotors(); 
        sonic.start();  
        // Move forward for 3 seconds while looking for obstacles
        Delay.msDelay(3000);
        // Stopping and waiting for 1 second
        mControl.stopMotors();                            
        LCD.drawString("Reached halfway.", 0, 2);
        LCD.drawString("Returning to base.", 0, 3);
        Delay.msDelay(1000);
        // Turning the motors 180 degrees each to the opposite directions
        mControl.turnMotors();
        //Ensures that the turning won't be interupted
        while (Motor.D.isMoving()){
            Thread.yield();
        }
        // Return to starting position
        mControl.startMotors();
        Delay.msDelay(3000);

        mControl.stopMotors();
        Button.waitForAnyPress();
        }
        /* 
        public void run(){
            while (Motor.D.isMoving() && ultrasonicSensor.isEnabled()) {
                LCD.drawString("Thread running", 0, 6);
                distance.fetchSample(sample, 0);
                if (sample[0] < dangerDist){
                    stopMotors();
                    LCD.drawString("Obstacle detected at", 0, 4);
                    LCD.drawString("" + sample[0], 0, 5);
                    break;
                    }
                }
            } */
        }
    
    


