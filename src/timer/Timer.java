
package timer;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Timer extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/timer/views/clock.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setTitle("Timer");
        stage.setScene(scene);
        stage.show();
        
        stage.setOnCloseRequest(e -> {
        Platform.exit();
        System.exit(0);
    });

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
