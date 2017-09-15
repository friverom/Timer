/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timer.controllers;

import java.net.URL;
import java.util.Calendar;
import java.util.ResourceBundle;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import timer.common.Flag;

/**
 *
 * @author frive
 */
public class clockController implements Initializable {

    @FXML
    private Label clocklbl;
    @FXML
    private Button startButton;
    @FXML
    private Button stopButton;
    Flag clockFlag = new Flag(false); 

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        Thread clock = new Thread(new update_clock(clockFlag), "Clock");
        clock.start();
    }

    @FXML
    private void startClockEvent(ActionEvent event) {
        
        clockFlag.setRun();
        System.out.println("Start");
        
    }

    @FXML
    private void stopClockEvent(ActionEvent event) {
        
        clockFlag.setStop();
        System.out.println("Stop");
    }

    public class update_clock implements Runnable {
        
        private Flag flag;
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        
        public update_clock(Flag val){
            flag=val;
            System.out.println("Run Flag -> "+flag.getState() );
        }
        @Override
        public void run() {

            while (true) {

                if (flag.getState() == true) {
                    Calendar now = Calendar.getInstance();
                    Platform.runLater(() -> {
                        clocklbl.setText(sdf.format(now.getTime()));
                    });
                }

                try {
                    Thread.sleep(900);
                } catch (InterruptedException ex) {
                    Logger.getLogger(clockController.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        }
        
        

    }
}


    



