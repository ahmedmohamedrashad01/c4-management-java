/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carrefour2018;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author Rashad
 */
public class EmployeesSearchController implements Initializable {

    public String checkSelect;

    @FXML
    private JFXTextField txtLastName;
    
      @FXML
    private JFXTextField nameFirstName;
      
     @FXML
    private JFXButton btnback;
     
    @FXML
    private RadioButton id;

    @FXML
    private ToggleGroup SelectIdOrName;

    @FXML
    private RadioButton name;

    @FXML
    private JFXTextField txtId;

    @FXML
    private JFXTextField idFirstName;

    @FXML
    private JFXTextField idLastName;

    @FXML
    private JFXTextField idGrade;

    @FXML
    private JFXTextField idGender;

    @FXML
    private JFXTextField idNationality;

    @FXML
    private JFXTextField idQualification;

    @FXML
    private JFXTextField idPassport;

    @FXML
    private JFXTextField idJoinDate;

    @FXML
    private JFXTextField idMobile;

    @FXML
    private JFXTextField idDepartMent;

    @FXML
    private JFXTextField idSection;

    @FXML
    private JFXTextField idPosition;

    @FXML
    private ImageView idImage;

    @FXML
    private JFXTextField nameID;

    @FXML
    private JFXTextField nameGrade;

    @FXML
    private JFXTextField nameGender;

    @FXML
    private JFXTextField nameNationality;

    @FXML
    private JFXTextField nameQualification;

    @FXML
    private JFXTextField namePassport;

    @FXML
    private JFXTextField nameJoinDate;

    @FXML
    private JFXTextField nameMobile;

    @FXML
    private JFXTextField nameDepartment;

    @FXML
    private JFXTextField nameSection;

    @FXML
    private JFXTextField namePosition;

    @FXML
    private ImageView nameImage;

    @FXML
    private Label lblTime;

    @FXML
    private JFXButton btnSearch;

     @FXML
    void backButton(ActionEvent event) {
        try {
            ((Node)event.getSource()).getScene().getWindow().hide();
            FXMLLoader f = new FXMLLoader(getClass().getResource("MainPage.fxml"));
            Parent p = (Parent)f.load();
            Stage s = new Stage();
            s.setResizable(false);
            s.setScene(new Scene(p));
            s.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
         
    }
    
    @FXML
    void SearchButton(ActionEvent event) {

        if ((!id.isSelected()) && (!name.isSelected())) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Information Dialog");
            alert.setHeaderText("Error Message");
            alert.setContentText("please select id or name!");
            alert.showAndWait();

        } else if (id.isSelected() && txtId.getText().trim().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Information Dialog");
            alert.setHeaderText("Error Message");
            alert.setContentText("id field is empty!");
            alert.showAndWait();

        } else if (id.isSelected() && !txtId.getText().matches("[0-9]+")) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Information Dialog");
            alert.setHeaderText("Error Message");
            alert.setContentText("id must be digits only!");
            alert.showAndWait();

        } else if (id.isSelected() && txtId.getText().matches("[0-9]+")) {

            /// connect DB
            try {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "root21485");

                PreparedStatement pst = conn.prepareStatement("SELECT * FROM C4 where ID = '" + txtId.getText() + "'");
                ResultSet rs = pst.executeQuery();
                if (rs.next()) {
                    idFirstName.setText(rs.getString("FIRST"));
                    idLastName.setText(rs.getString("LAST"));
                    idGrade.setText(String.valueOf(rs.getInt("GRADE")));
                    idGender.setText(rs.getString("GENDER"));
                    idNationality.setText(rs.getString("NATIONALITY"));
                    idQualification.setText(rs.getString("QUALIFICATION"));
                    idPassport.setText(rs.getString("PASSPORT"));
                    idJoinDate.setText(rs.getString("JOINDATE"));
                    idMobile.setText(rs.getString("MOBILE"));
                    idDepartMent.setText(rs.getString("DAPART"));
                    idSection.setText(rs.getString("SECTION"));
                    idPosition.setText(rs.getString("POSITION"));

                    Blob foto = rs.getBlob("IMG");
                    InputStream is = foto.getBinaryStream();
                    idImage.setImage(new Image(foto.getBinaryStream()));

                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Information Dialog");
                    alert.setHeaderText("Error Message");
                    alert.setContentText("id number not found!");
                    alert.showAndWait();

                }

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        } else if (name.isSelected() && txtLastName.getText().trim().isEmpty()) {
             Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Information Dialog");
                    alert.setHeaderText("Error Message");
                    alert.setContentText("last name field is empty!");
                    alert.showAndWait();
                    
        } else if (name.isSelected() && txtLastName.getText().matches("[0-9]+")) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Information Dialog");
                    alert.setHeaderText("Error Message");
                    alert.setContentText("last name must be characters only!");
                    alert.showAndWait();
            
           
        } else if (name.isSelected() && txtLastName.getText().length() < 12) {
           Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Information Dialog");
                    alert.setHeaderText("Error Message");
                    alert.setContentText("last name field is too short!");
                    alert.showAndWait();
           

        } else if (name.isSelected() && txtLastName.getText().matches("[a-zA-Z]+\\s[a-zA-Z]+\\s[a-zA-Z]+\\s?[a-zA-Z]+")) {

            try {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "root21485");

                PreparedStatement pst = conn.prepareStatement("SELECT * FROM C4 WHERE LAST ='" + txtLastName.getText() + "'");
                ResultSet rs = pst.executeQuery();
                if (rs.next()) {
                    nameFirstName.setText(rs.getString("FIRST"));
                    nameID.setText(String.valueOf(rs.getInt("ID")));
                    nameGrade.setText(String.valueOf(rs.getInt("GRADE")));
                    nameGender.setText(rs.getString("GENDER"));
                    nameNationality.setText(rs.getString("NATIONALITY"));
                    nameQualification.setText(rs.getString("QUALIFICATION"));
                    namePassport.setText(rs.getString("PASSPORT"));
                    nameJoinDate.setText(rs.getString("JOINDATE"));
                    nameMobile.setText(rs.getString("MOBILE"));
                    nameDepartment.setText(rs.getString("DAPART"));
                    nameSection.setText(rs.getString("SECTION"));
                    namePosition.setText(rs.getString("POSITION"));
                    Blob foto = rs.getBlob("IMG");
                    InputStream is = foto.getBinaryStream();
                    nameImage.setImage(new Image(foto.getBinaryStream()));

                } else {
                  
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Information Dialog");
                    alert.setHeaderText("Error Message");
                    alert.setContentText("Employee Name not Found!");
                    alert.showAndWait();
                    
                }

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }
    }

    @FXML
    void SelectByName(ActionEvent event) {
        checkSelect = "ByName";
        if (name.isSelected()) {
            nameFirstName.setVisible(true);
            txtId.setText("");
            idImage.setImage(null);
            nameID.setVisible(true);
            nameGrade.setVisible(true);
            nameGender.setVisible(true);
            nameNationality.setVisible(true);
            nameQualification.setVisible(true);
            namePassport.setVisible(true);
            nameJoinDate.setVisible(true);
            nameMobile.setVisible(true);
            nameDepartment.setVisible(true);
            nameSection.setVisible(true);
            namePosition.setVisible(true);

            idFirstName.setVisible(false);
            idLastName.setVisible(false);
            idGrade.setVisible(false);
            idGender.setVisible(false);
            idNationality.setVisible(false);
            idQualification.setVisible(false);
            idPassport.setVisible(false);
            idJoinDate.setVisible(false);
            idMobile.setVisible(false);
            idDepartMent.setVisible(false);
            idSection.setVisible(false);;
            idPosition.setVisible(false);
            idImage.setImage(null);

            idFirstName.setText(null);
            idLastName.setText(null);
            idGrade.setText(null);
            idGender.setText(null);
            idNationality.setText(null);
            idQualification.setText(null);
            idPassport.setText(null);
            idJoinDate.setText(null);
            idMobile.setText(null);
            idDepartMent.setText(null);
            idSection.setText(null);
            idPosition.setText(null);
            idImage.setImage(null);

        }
    }

    @FXML
    void selectByID(ActionEvent event) {
        if (id.isSelected()) {
            // checkSelect = "byid";
            nameFirstName.setText(null);
            txtLastName.setText(null);
            nameID.setText(null);
            nameGrade.setText(null);
            nameGender.setText(null);
            nameNationality.setText(null);
            nameQualification.setText(null);
            namePassport.setText(null);;
            nameJoinDate.setText(null);
            nameMobile.setText(null);
            nameDepartment.setText(null);
            nameSection.setText(null);
            namePosition.setText(null);
            nameImage.setImage(null);

            idFirstName.setVisible(true);
            idLastName.setVisible(true);
            idGrade.setVisible(true);
            idGender.setVisible(true);
            idNationality.setVisible(true);
            idQualification.setVisible(true);
            idPassport.setVisible(true);
            idJoinDate.setVisible(true);
            idMobile.setVisible(true);
            idDepartMent.setVisible(true);
            idSection.setVisible(true);;
            idPosition.setVisible(true);

            nameID.setText(null);
            nameGrade.setText(null);
            nameGender.setText(null);
            nameNationality.setText(null);
            nameQualification.setText(null);
            namePassport.setText(null);
            nameJoinDate.setText(null);
            nameMobile.setText(null);
            nameDepartment.setText(null);
            nameSection.setText(null);
            namePosition.setText(null);
            nameImage.setImage(null);

            
            nameFirstName.setVisible(false);
            nameID.setVisible(false);
            nameGrade.setVisible(false);
            nameGender.setVisible(false);
            nameNationality.setVisible(false);
            nameQualification.setVisible(false);
            namePassport.setVisible(false);
            nameJoinDate.setVisible(false);
            nameMobile.setVisible(false);
            nameDepartment.setVisible(false);
            nameSection.setVisible(false);
            namePosition.setVisible(false);
            nameImage.setImage(null);

        }
    }

    public void diaplayCurrentTime() {

    }

    public void displayTime() {

        Timeline timeline = new Timeline(
                new KeyFrame(Duration.seconds(0),
                        new EventHandler<ActionEvent>() {

                    @Override
                    public void handle(ActionEvent actionEvent) {
                        Calendar time = Calendar.getInstance();
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh : mm : ss a");
                        lblTime.setText(simpleDateFormat.format(time.getTime()));
                    }
                }
                ),
                new KeyFrame(Duration.seconds(1))
        );
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        displayTime();

        idFirstName.setVisible(false);
        idLastName.setVisible(false);
        idGrade.setVisible(false);
        idGender.setVisible(false);
        idNationality.setVisible(false);
        idQualification.setVisible(false);
        idPassport.setVisible(false);
        idJoinDate.setVisible(false);
        idMobile.setVisible(false);
        idDepartMent.setVisible(false);
        idSection.setVisible(false);;
        idPosition.setVisible(false);

        nameFirstName.setVisible(false);
        nameID.setVisible(false);
        nameGrade.setVisible(false);
        nameGender.setVisible(false);
        nameNationality.setVisible(false);
        nameQualification.setVisible(false);
        namePassport.setVisible(false);
        nameJoinDate.setVisible(false);
        nameMobile.setVisible(false);
        nameDepartment.setVisible(false);
        nameSection.setVisible(false);
        namePosition.setVisible(false);

    }

}
