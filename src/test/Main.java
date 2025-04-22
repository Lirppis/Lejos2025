package test;

import lejos.robotics.RegulatedMotor; // Port D: Left motor | Port C: Right motor
import lejos.hardware.motor.Motor;
import lejos.hardware.Button;
import lejos.hardware.lcd.LCD;
import lejos.utility.Delay;

public class Main extends Thread{   
    int motorspeed; 
    public static void main(String[] args) {
        // Initialize classes for the threads
        MotorTest mControl = new MotorTest();
        SonicSensor sonic = new SonicSensor();
        // Version number for the code. Used to check that file was uploaded properly.         
        
        Button.waitForAnyPress();
        }

        public void ObsDetected(){
            mControl.setmotorspeed(250);
        }
    }
    
    


