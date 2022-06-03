package carrefour2018;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXSpinner;
import com.jfoenix.controls.JFXTextField;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.DriverManager;
import java.sql.*;
import java.util.ResourceBundle;
import javafx.animation.TranslateTransition;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

public class AddEmployee2Controller implements Initializable {

    /*
    private final String Driver = "com.mysql.jdbc.Driver";
    private final String URL = "jdbc:mysql://localhost/c4fx";
    private final String USER = "root";
    private final String PASSWORD = "root21485";
    private Connection con;
    private Statement stmt;

    public AddEmployee2Controller() {

     
        con = null;
        stmt = null;
        try {
            Class.forName(Driver);
            con = (Connection) DriverManager.getConnection(URL, USER, PASSWORD);
            if (con != null) {
                System.out.println("Connected");
                stmt = (Statement) con.createStatement();

            }

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
    
    }
     */
    @FXML
    private AnchorPane root;

    @FXML
    private Label nameLabel;

    @FXML
    private Label helloLabel;

    @FXML
    private JFXSpinner spinnerLabel;

    @FXML
    private Label logoLabel;

    @FXML
    private JFXTextField first;

    @FXML
    private JFXTextField last;

    @FXML
    private JFXTextField age;

    @FXML
    public JFXComboBox<String> nationality;

    @FXML
    private JFXComboBox<String> qualification;

    @FXML
    private JFXComboBox<String> mother;

    @FXML
    private JFXComboBox<String> additional;

    @FXML
    private ImageView myImage;

    @FXML
    private JFXTextField passport;

    @FXML
    private JFXDatePicker date;

    @FXML
    private JFXTextField mobile;

    @FXML
    private JFXComboBox<String> depart;

    @FXML
    private JFXComboBox<String> section;

    @FXML
    private JFXComboBox<String> position;

    @FXML
    private JFXTextField grade;

    @FXML
    private JFXTextField contract;

    @FXML
    private JFXRadioButton male;

    @FXML
    private ToggleGroup gender;
    String chaeckGender;

    @FXML
    private JFXRadioButton female;

    @FXML
    private JFXButton btnAdd;

    int vac = 60;
    InputStream is;
    String s;
    String query;

    public String pass;

    // Add New Employee
    ////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////
    @FXML
    void SelectFemale(ActionEvent event) {
        if (female.isSelected()) {
            chaeckGender = "Female";
        }
    }

    @FXML
    void SelectMale(ActionEvent event) {
        if (male.isSelected()) {
            chaeckGender = "Male";
        }
    }

    @FXML
    void selectImage(ActionEvent event) {

        try {

            FileChooser fileChooser = new FileChooser();

            //Set extension filter
            FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("JPG files (*.jpg)", "*.JPG");
            FileChooser.ExtensionFilter extFilterPNG = new FileChooser.ExtensionFilter("PNG files (*.png)", "*.PNG");
            fileChooser.getExtensionFilters().addAll(extFilterJPG, extFilterPNG);

            //Show open file dialog
            File file = fileChooser.showOpenDialog(null);

            if (file != null) {

                BufferedImage bufferedImage = ImageIO.read(file);
                Image image = SwingFXUtils.toFXImage(bufferedImage, null);

                String path = file.getAbsolutePath();
                myImage.setImage(image);
                s = path;

                try {
                    is = new FileInputStream(new File(s));
                } catch (FileNotFoundException exx) {
                    System.out.println(exx.getMessage());
                }

            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    @FXML
    void SaveData(ActionEvent event) throws IOException {
        String firstName = first.getText();
        String lastName = last.getText();
        String getAge = age.getText();
        String getNationality = nationality.getValue();
        String getqualification = qualification.getValue();

        String sdate = (String.valueOf(date.getValue()));

        String motherLanguage = mother.getValue();
        String additionalLanguage = additional.getValue();
        pass = passport.getText();
        String mobileNumber = mobile.getText();
        String dpt = depart.getValue();
        String sec = section.getValue();
        String pos = position.getValue();
        String grd = grade.getText();

        if (firstName.trim().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Information Dialog");
            alert.setHeaderText("Error Message");
            alert.setContentText("first name field is empty!");
            alert.show();

        } else if (!firstName.matches("[a-zA-Z]+\\s?")) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Information Dialog");
            alert.setHeaderText("Error Message");
            alert.setContentText("first name must be characters only!");
            alert.show();
        } else if (firstName.length() < 3) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Information Dialog");
            alert.setHeaderText("Error Message");
            alert.setContentText("first name is too short!");
            alert.show();
        } else if (lastName.trim().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Information Dialog");
            alert.setHeaderText("Error Message");
            alert.setContentText("last name is empty!");
            alert.show();

        } else if (lastName.length() < 12) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Information Dialog");
            alert.setHeaderText("Error Message");
            alert.setContentText("last name is too short!");
            alert.show();
        } else if (!lastName.matches("[a-zA-Z]+\\s[a-zA-Z]+\\s[a-zA-Z]+\\s?[a-zA-Z]+")) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Information Dialog");
            alert.setHeaderText("Error Message");
            alert.setContentText("At least two spaces must be available in the second name!");
            alert.show();
        } else if (getAge.trim().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Information Dialog");
            alert.setHeaderText("Error Message");
            alert.setContentText("age field is empty!");
            alert.show();

        } else if (!getAge.matches("[0-9]+")) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Information Dialog");
            alert.setHeaderText("Error Message");
            alert.setContentText("age must be digits only!");
            alert.show();

        } else if (Integer.parseInt(getAge) > 60) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Information Dialog");
            alert.setHeaderText("Error Message");
            alert.setContentText("age is too long!");
            alert.show();
        } else if (chaeckGender == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Information Dialog");
            alert.setHeaderText("Error Message");
            alert.setContentText("please select gender!");
            alert.show();
        } else if (getNationality == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Information Dialog");
            alert.setHeaderText("Error Message");
            alert.setContentText("please select country!");
            alert.show();
        } else if (getqualification == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Information Dialog");
            alert.setHeaderText("Error Message");
            alert.setContentText("please select qualification!");
            alert.show();

        } else if (myImage.getImage() == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Information Dialog");
            alert.setHeaderText("Error Message");
            alert.setContentText("please select photo!");
            alert.show();
        } else if (motherLanguage == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Information Dialog");
            alert.setHeaderText("Error Message");
            alert.setContentText("please select mother language!");
            alert.show();
        } else if (additionalLanguage == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Information Dialog");
            alert.setHeaderText("Error Message");
            alert.setContentText("please select additional language!");
            alert.show();
        } else if (pass.trim().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Information Dialog");
            alert.setHeaderText("Error Message");
            alert.setContentText("passport field is empty!");
            alert.show();
        } else if (pass.length() < 6) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Information Dialog");
            alert.setHeaderText("Error Message");
            alert.setContentText("passport field is too short!");
            alert.show();
        } else if (date.getValue() == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Information Dialog");
            alert.setHeaderText("Error Message");
            alert.setContentText("please select join date!");
            alert.show();
        } else if (mobileNumber.trim().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Information Dialog");
            alert.setHeaderText("Error Message");
            alert.setContentText("please enter mobile number!");
            alert.show();
        } else if (!mobileNumber.matches("[0-9]+")) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Information Dialog");
            alert.setHeaderText("Error Message");
            alert.setContentText("mobile number must be digits only!");
            alert.show();
        } else if (mobileNumber.length() < 10) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Information Dialog");
            alert.setHeaderText("Error Message");
            alert.setContentText("mobile number is too short!");
            alert.show();
        } else if (dpt == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Information Dialog");
            alert.setHeaderText("Error Message");
            alert.setContentText("please select department!");
            alert.show();
        } else if (sec == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Information Dialog");
            alert.setHeaderText("Error Message");
            alert.setContentText("please select section!");
            alert.show();
        } else if (pos == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Information Dialog");
            alert.setHeaderText("Error Message");
            alert.setContentText("please select position!");
            alert.show();
        } else if (grd.trim().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Information Dialog");
            alert.setHeaderText("Error Message");
            alert.setContentText("grade field is empty!");
            alert.show();
        } else if (!grd.matches("[0-9]+")) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Information Dialog");
            alert.setHeaderText("Error Message");
            alert.setContentText("grade must be digits only!");
            alert.show();
        } else if ((Integer.parseInt(grd) > 25)) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Information Dialog");
            alert.setHeaderText("Error Message");
            alert.setContentText("grade is too long!");
            alert.show();

        } else {
            Sql s = new Sql();
            try {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "root21485");

                PreparedStatement pst = conn.prepareStatement("SELECT DISTINCT PASSPORT FROM C4 where PASSPORT = '" + pass + "'");
                ResultSet rs = pst.executeQuery();
                if (rs.next()) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Information Dialog");
                    alert.setHeaderText("Error Message");
                    alert.setContentText("Employee Already Exist");
                    alert.showAndWait();
                } else {
                    pst = conn.prepareStatement("insert into c4 (ID,FIRST,LAST,AGE,GENDER,NATIONALITY,QUALIFICATION,IMG,MOTHER,ADDITIONAL,PASSPORT,JOINDATE,MOBILE,DAPART,SECTION,POSITION,GRADE,VACATION) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                    int idd = s.idIncrement();
                    pst.setInt(1, idd);
                    pst.setString(2, firstName);
                    pst.setString(3, lastName);
                    pst.setString(4, getAge);
                    pst.setString(5, chaeckGender);
                    pst.setString(6, getNationality);
                    pst.setString(7, getqualification);
                    pst.setBlob(8, is);
                    pst.setString(9, motherLanguage);
                    pst.setString(10, additionalLanguage);
                    pst.setString(11, pass);
                    pst.setString(12, sdate);
                    pst.setString(13, mobileNumber);
                    pst.setString(14, dpt);
                    pst.setString(15, sec);
                    pst.setString(16, pos);
                    pst.setInt(17, (Integer.parseInt(grd)));
                    pst.setInt(18, 60);

                    pst.executeUpdate();

                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Dialog");
                    alert.setHeaderText("Information Message");
                    alert.setContentText("Data Inserted");
                    alert.showAndWait();
                    conn.close();
                    pst.close();
                    ((Node) event.getSource()).getScene().getWindow().hide();
                    FXMLLoader f = new FXMLLoader(getClass().getResource("MainPage.fxml"));
                    Parent p = (Parent) f.load();
                    Stage st = new Stage();
                    st.setScene(new Scene(p));
                    st.show();

                }

            } catch (ClassNotFoundException | NumberFormatException | SQLException e) {
                System.out.println(e.getMessage());
            }

        }

    }

    @FXML
    void selectDPT(ActionEvent event) {

        String select = depart.getValue();
        if (select.equalsIgnoreCase("FMCG")) {
            section.getItems().clear();
            section.getItems().addAll("11", "12", "13", "14", "21", "22", "23", "25", "26");
            section.getSelectionModel().selectFirst();

            position.getItems().clear();
            position.getItems().addAll("Stocker", "Supervisor", "Section Manager", "Department Head");
            position.getSelectionModel().selectFirst();

        } else if (select.equalsIgnoreCase("Market")) {
            section.getItems().clear();
            section.getItems().addAll("50", "51", "52", "53", "54", "55", "56");
            section.getSelectionModel().selectFirst();

            position.getItems().clear();
            position.getItems().addAll("Stocker", "Supervisor", "Section Manager", "Department Head");
            position.getSelectionModel().selectFirst();

        } else if (select.equalsIgnoreCase("L.H.H")) {
            section.getItems().clear();
            section.getItems().addAll("30", "31", "32", "33", "34", "35", "36", "37", "39", "71");
            section.getSelectionModel().selectFirst();

            position.getItems().clear();
            position.getItems().addAll("Stocker", "Supervisor", "Section Manager", "Department Head");
            position.getSelectionModel().selectFirst();

        } else if (select.equalsIgnoreCase("H.H.H")) {
            section.getItems().clear();
            section.getItems().addAll("80", "81", "82", "83", "84", "85", "86", "87");
            section.getSelectionModel().selectFirst();

            position.getItems().clear();
            position.getItems().addAll("Sales Man", "Sales Lady", "Supervisor", "Section Manager", "Department Head");
            position.getSelectionModel().selectFirst();
        } else if (select.equalsIgnoreCase("TXT")) {
            section.getItems().clear();
            section.getItems().addAll("40", "41", "42", "43", "44", "60", "61");
            section.getSelectionModel().selectFirst();

            position.getItems().clear();
            position.getItems().addAll("Stocker", "Supervisor", "Section Manager", "Department Head");
            position.getSelectionModel().selectFirst();

        } else if (select.equalsIgnoreCase("Services")) {
            section.getItems().clear();
            section.getItems().addAll("HC", "CCO", "FIN", "BC", "IT", "CCS", "Security", "Secretary");
            section.getSelectionModel().selectFirst();

            position.getItems().clear();
            position.getItems().addAll("Coordinator", "Assistant Manager", "Assistant Manager PRO", "Department Head");
            position.getSelectionModel().selectFirst();

        }

    }

    @FXML
    void backToMainPage(ActionEvent event) throws IOException {
        ((Node) event.getSource()).getScene().getWindow().hide();
        FXMLLoader f = new FXMLLoader(getClass().getResource("MainPage.fxml"));
        Parent p = (Parent) f.load();
        Stage s = new Stage();
        s.setTitle("Add New Employee");
        s.centerOnScreen();
        s.setResizable(false);
        s.setScene(new Scene(p));
        s.show();
    }

    @FXML
    void ExitAll(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    void selectSection(ActionEvent event) {
        try {
            if (section.getValue().equalsIgnoreCase("CCO")) {
                position.getItems().clear();
                position.getItems().addAll("Trolly Boy", "Cashier", "Supervisor", "Assistant Manager", "Department Head");
                position.getSelectionModel().selectFirst();
            } else if (section.getValue().equalsIgnoreCase("FIN")) {
                position.getItems().clear();
                position.getItems().addAll("Accountant", "Assistant Manager", "Department Head");
                position.getSelectionModel().selectFirst();
            } else if (section.getValue().equalsIgnoreCase("BC")) {
                position.getItems().clear();
                position.getItems().addAll("Clerck", "Supervisor", "Assistant Manager", "Department Head");
                position.getSelectionModel().selectFirst();
            } else if (section.getValue().equalsIgnoreCase("IT")) {
                position.getItems().clear();
                position.getItems().addAll("Clerck", "Supervisor", "Assistant Manager", "Department Head");
                position.getSelectionModel().selectFirst();
            } else if (section.getValue().equalsIgnoreCase("CCS")) {
                position.getItems().clear();
                position.getItems().addAll("Clerck", "Supervisor", "Assistant Manager", "Department Head");
                position.getSelectionModel().selectFirst();
            } else if (section.getValue().equalsIgnoreCase("Security")) {
                position.getItems().clear();
                position.getItems().addAll("Staff", "Supervisor", "Assistant Manager", "Department Head");
                position.getSelectionModel().selectFirst();
            } else if (section.getValue().equalsIgnoreCase("Secretary")) {
                position.getItems().clear();
                position.getItems().addAll("GM");
                position.getSelectionModel().selectFirst();
            } else if (section.getValue().equalsIgnoreCase("HC")) {
                position.getItems().clear();
                position.getItems().addAll("Coordinator", "Assistant Manager", "Assistant Manager PRO", "Department Head");
                position.getSelectionModel().selectFirst();
            }

        } catch (Exception e) {
            e.getMessage();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        qualification.getItems().addAll("Primary Stage", "Middle School", "High School", "Bachelor's Degree", "Master's Degree", "PHD Degree");

        nationality.getItems().addAll("Albania", "Afghanistan", "Algeria", "Andorra", "Angola", "Argentina", "Armenia",
                "Austria", "Azerbaijan", "Bahamas", "Bahrain", "Bangladesh", "Barbados", "Belarus",
                "Belgium", "Belize",
                "Benin",
                "Bhutan",
                "Bolivia",
                "Bosnia and Herzegovina",
                "Botswana",
                "Brazil", "Brunei", "Bulgaria", "Burkina", "Faso", "Burma", "Burundi", "Cambodia",
                "Cameroon",
                "Canada",
                "Cabo Verde",
                "Central African Republic",
                "Chad",
                "Chile",
                "China",
                "Colombia",
                "Comoros",
                "Congo", "Democratic Republic of the Congo", "Republic of the Costa Rica", "Croatia", "Cuba", "Curacao",
                "Cyprus", "Czechia", "Denmark", "Djibouti", "Dominica", "Dominican Republic", "Ecuador",
                "Egypt", "El Salvador", "Equatorial Guinea", "Eritrea", "Estonia", "Eswatini", "Ethiopia",
                "Fiji", "Finland", "France", "Gabon", "Gambia", "Georgia", "Germany", "Ghana", "Greece", "Grenada",
                "Guatemala", "Guinea", "Guinea-Bissau", "Guyana", "Haiti",
                "Holy See",
                "Honduras",
                "Hong Kong",
                "Hungary", "Iceland",
                "India",
                "Indonesia",
                "Iran",
                "Iraq",
                "Ireland",
                "Italy", "Jamaica",
                "Japan",
                "Jordan", "Kazakhstan",
                "Kenya",
                "Kiribati",
                "Korea, North",
                "Korea, South",
                "Kosovo",
                "Kuwait",
                "Kyrgyzstan", "Laos",
                "Latvia",
                "Lebanon",
                "Lesotho",
                "Liberia",
                "Libya",
                "Liechtenstein",
                "Lithuania",
                "Luxembourg", "Macau",
                "Macedonia",
                "Madagascar",
                "Malawi",
                "Malaysia",
                "Maldives",
                "Mali",
                "Malta",
                "Marshall Islands",
                "Mauritania",
                "Mauritius",
                "Mexico",
                "Micronesia",
                "Moldova",
                "Monaco",
                "Mongolia",
                "Montenegro",
                "Morocco",
                "Mozambique", "Namibia",
                "Nauru",
                "Nepal",
                "Netherlands",
                "New Zealand",
                "Nicaragua",
                "Niger",
                "Nigeria",
                "North Korea",
                "Norway", "Oman", "Pakistan",
                "Palau",
                "Palestinian ",
                "Panama",
                "Papua New Guinea",
                "Paraguay",
                "Peru",
                "Philippines",
                "Poland",
                "Portugal", "Romania",
                "Russia",
                "Rwanda", "Saudi Arabia",
                "Senegal",
                "Serbia",
                "Seychelles",
                "Sierra Leone",
                "Singapore",
                "Sint Maarten",
                "Slovakia",
                "Slovenia",
                "Solomon Islands",
                "Somalia",
                "South Africa",
                "South Korea",
                "South Sudan",
                "Spain",
                "Sri Lanka",
                "Sudan",
                "Suriname",
                "Swaziland (See Eswatini)",
                "Sweden",
                "Switzerland",
                "Syria", "Taiwan",
                "Tajikistan",
                "Tanzania",
                "Thailand",
                "Timor-Leste",
                "Togo",
                "Tonga",
                "Trinidad and Tobago",
                "Tunisia",
                "Turkey",
                "Turkmenistan",
                "Tuvalu",
                "Uganda",
                "Ukraine",
                "United Arab Emirates",
                "United Kingdom", "United States Of America",
                "Uruguay",
                "Uzbekistan", "Vanuatu",
                ",Venezuela",
                "Vietnam", "Yemen", "Zambia",
                "Zimbabwe"
        );

        mother.getItems().addAll("Arabic", "Spanish", "Chinese", "English", "Russian", "Bengali", "Hindi",
                "Portuguese", "Japanese", "German", "Vietnamese", "French", "Italian", "Korean", "Urdu");
        additional.getItems().addAll("Arabic", "Spanish", "Chinese", "English", "Russian", "Bengali", "Hindi",
                "Portuguese", "Japanese", "German", "Vietnamese", "French", "Italian", "Korean", "Urdu");

        depart.getItems().addAll("FMCG", "Market", "L.H.H", "H.H.H", "TXT", "Services");
        depart.getSelectionModel().selectFirst();

        position.getItems().add("Stocker");
        position.getItems().add("Supervisor");
        position.getItems().add("Section Manager");
        position.getItems().add("Department Head");
        position.getSelectionModel().selectFirst();

        section.getItems().add("11");
        section.getItems().add("12");
        section.getItems().add("13");
        section.getItems().add("14");
        section.getItems().add("21");
        section.getItems().add("22");
        section.getItems().add("23");
        section.getItems().add("25");
        section.getItems().add("26");
        section.getSelectionModel().selectFirst();

        TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(0.5), logoLabel);
        translateTransition.setByY(700);
        translateTransition.play();

        TranslateTransition translateTransition0 = new TranslateTransition(Duration.seconds(0.5), nameLabel);
        translateTransition0.setByY(700);
        translateTransition0.play();

        TranslateTransition translateTransition2 = new TranslateTransition(Duration.seconds(0.5), helloLabel);
        translateTransition2.setByY(700);
        translateTransition2.play();

        TranslateTransition translateTransition3 = new TranslateTransition(Duration.seconds(0.5), spinnerLabel);
        translateTransition3.setByY(700);
        translateTransition3.play();

        translateTransition.setOnFinished((event) -> {
            TranslateTransition translateTransition1 = new TranslateTransition(Duration.seconds(1), logoLabel);

            translateTransition1.setByY(-700);
            translateTransition1.play();

            translateTransition1.setOnFinished((event1) -> {
                nameLabel.setVisible(true);

                TranslateTransition translateTransition11 = new TranslateTransition(Duration.seconds(1), nameLabel);

                translateTransition11.setByY(-700);
                translateTransition11.play();

                translateTransition11.setOnFinished((event2) -> {
                    helloLabel.setVisible(true);
                    TranslateTransition translateTransition111 = new TranslateTransition(Duration.seconds(1), helloLabel);

                    translateTransition111.setByY(-700);
                    translateTransition111.play();

                    translateTransition111.setOnFinished((event3) -> {
                        spinnerLabel.setVisible(true);
                        TranslateTransition translateTransition1111 = new TranslateTransition(Duration.seconds(1), spinnerLabel);

                        translateTransition1111.setByY(-700);
                        translateTransition1111.play();

                    });

                });

            });

        });

    }

}
