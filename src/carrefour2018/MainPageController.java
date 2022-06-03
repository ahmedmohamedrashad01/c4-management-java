package carrefour2018;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.transform.Scale;
import javafx.stage.Stage;

public class MainPageController implements Initializable {

    @FXML
    private Text textC4;

    @FXML
    private JFXButton btnAdd;

    @FXML
    private JFXButton btnSearch;

    @FXML
    private JFXButton btnShow;

    @FXML
    private JFXButton btnVacation;

    @FXML
    public MediaView MediaView;

    @FXML
    void addEnter(MouseEvent event) {
        DropShadow d = new DropShadow(20, Color.RED);
        btnAdd.setEffect(d);
    }

    @FXML
    void addExit(MouseEvent event) {
        btnAdd.setEffect(null);
    }
      @FXML
    void soowAllEmployeesPage(ActionEvent event) {
        try {
            ((Node)event.getSource()).getScene().getWindow().hide();
            FXMLLoader  f= new FXMLLoader(getClass().getResource("ShowAll.fxml"));
           
            Parent p = (Parent)f.load();
            Stage s = new Stage();
            s.setTitle("Show All Employess");
           
            String sheet = this.getClass().getResource("Style.css").toExternalForm();
          
            s.setResizable(false);
            s.centerOnScreen();
          s.setScene(new Scene(p));
          s.getScene().getStylesheets().add(sheet);
            
            s.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        
        
        
    }

    @FXML
    void searchEnter(MouseEvent event) {
        DropShadow d = new DropShadow(20, Color.RED);
        btnSearch.setEffect(d);
    }

    @FXML
    void searchExit(MouseEvent event) {
        btnSearch.setEffect(null);
    }

    @FXML
    void showEnter(MouseEvent event) {
        DropShadow d = new DropShadow(20, Color.RED);
        btnShow.setEffect(d);
    }

    @FXML
    void showExit(MouseEvent event) {
        btnShow.setEffect(null);
    }

    @FXML
    void vacEnter(MouseEvent event) {
        DropShadow d = new DropShadow(20, Color.RED);
        btnVacation.setEffect(d);
    }

    @FXML
    void vacExit(MouseEvent event) {
        btnVacation.setEffect(null);
    }

    @FXML
    void textEnter(MouseEvent event) {

    }

    @FXML
    void textExit(MouseEvent event) {

    }

    @FXML
    void btnGoToAddEmployeePage(ActionEvent event) throws IOException, InterruptedException {
        
        ((Node) event.getSource()).getScene().getWindow().hide();
        FXMLLoader f = new FXMLLoader(getClass().getResource("AddEmployee2.fxml"));
        Parent p = (Parent) f.load();
        Stage s = new Stage();
        s.setTitle("Add New Employee");
        s.centerOnScreen();
        s.setResizable(false);
        s.setScene(new Scene(p));
        s.show();
        
       
        
        
    }
    
      @FXML
    void gotoSerachPage(ActionEvent event) {
        try{
              ((Node) event.getSource()).getScene().getWindow().hide();
        FXMLLoader f = new FXMLLoader(getClass().getResource("EmployeesSearch.fxml"));
        Parent p = (Parent) f.load();
        Stage s = new Stage();
        s.setTitle("Search for Employees");
        s.centerOnScreen();
        s.setResizable(false);
        s.setScene(new Scene(p));
        s.show();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
       
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // ((Stage)MediaView.getScene().getWindow()).setFullScreen(true);
        String s = String.valueOf(getClass().getResource("we.mp4"));
        Media m = new Media(s);
        MediaPlayer m2 = new MediaPlayer(m);
        MediaView.setMediaPlayer(m2);
        m2.setVolume(0);
        m2.play();

    }

}
