/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carrefour2018;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.RotateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.util.Duration;

public class LoginPageController implements Initializable {

    @FXML
    private ImageView Image1;

    @FXML
    private ImageView image2;

    @FXML
    private JFXButton btnLogin;

    @FXML
    private JFXTextField txtUserName;

    @FXML
    private JFXPasswordField txtPssword;

    @FXML
    void passEnter(MouseEvent event) {
        DropShadow d = new DropShadow(10, Color.FLORALWHITE);
        txtPssword.setEffect(d);
    }

    @FXML
    void passExit(MouseEvent event) {
        txtPssword.setEffect(null);
    }

    @FXML
    void userEnter(MouseEvent event) {
        DropShadow d = new DropShadow(10, Color.FLORALWHITE);
        txtUserName.setEffect(d);
    }

    @FXML
    void userExit(MouseEvent event) {
        txtUserName.setEffect(null);
    }

    @FXML
    void btnEnter(MouseEvent event) {
        DropShadow d = new DropShadow(10, Color.FLORALWHITE);
        btnLogin.setEffect(d);
    }

    @FXML
    void btnExit(MouseEvent event) {
        btnLogin.setEffect(null);
    }

    @FXML
    void login(ActionEvent event) throws IOException {

        if (txtUserName.getText().trim().isEmpty()) {
            Alert a = new Alert(AlertType.ERROR);
            a.setHeaderText("Information Dialog");
            a.setContentText("User Name Field is Empty");
            a.show();
        } else if (txtUserName.getText().matches("[0-9]+")) {
            Alert a = new Alert(AlertType.ERROR);
            a.setHeaderText("Information Dialog");
            a.setContentText("User Name Must be Characters Only !");
            a.show();

        } else if (txtPssword.getText().trim().isEmpty()) {
            Alert a = new Alert(AlertType.ERROR);
            a.setHeaderText("Information Dialog");
            a.setContentText("Password Field is Empty !");
            a.show();

        } else if (txtPssword.getText().length() < 6) {
            Alert a = new Alert(AlertType.ERROR);
            a.setHeaderText("Information Dialog");
            a.setContentText("Password is too Short Empty !");
            a.show();
        } else if (txtUserName.getText().equalsIgnoreCase("ahmed rashad") && txtPssword.getText()
                .equalsIgnoreCase("123456")) {
            ((Node) event.getSource()).getScene().getWindow().hide();
            FXMLLoader f = new FXMLLoader(getClass().getResource("MainPage.fxml"));
            Parent p = (Parent) f.load();
            Stage s = new Stage();
            s.setScene(new Scene(p));
            s.setTitle("Carrefour Management System");
            s.centerOnScreen();
            s.setResizable(false);
            s.show();

        } else {
            new Alert(Alert.AlertType.ERROR, "User Name Is Incorrect").show();
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        RotateTransition rt = new RotateTransition(Duration.seconds(10), Image1);
        rt.setByAngle(9 * 360);
        rt.play();
        RotateTransition rt2 = new RotateTransition(Duration.seconds(10), image2);
        rt2.setByAngle(9 * 360);
        rt2.play();

        // txtUserName.setStyle("-fx-text-inner-color: white;");
        //txtPssword.setStyle("-fx-text-inner-color: white;");
        txtUserName.setFont(Font.font("Andalus", FontWeight.BOLD, 20));
        txtPssword.setFont(Font.font("Andalus", FontWeight.BOLD, 20));
    }

}
