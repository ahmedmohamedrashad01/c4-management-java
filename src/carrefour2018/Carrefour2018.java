
package carrefour2018;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Rashad
 */
public class Carrefour2018 extends Application {
    
    @Override
    public void start(Stage primaryStage) throws Exception{
        try{
        Parent p = FXMLLoader.load(getClass().getResource("LoginPage.fxml"));
        Scene scene;
        scene = new Scene(p);
        primaryStage.setTitle("Ahmed Rashad");
        scene.getStylesheets().add(getClass().getResource("Style.css").toExternalForm());
       
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
