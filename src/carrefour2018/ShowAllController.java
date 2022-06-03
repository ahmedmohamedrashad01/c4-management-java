
package carrefour2018;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class ShowAllController implements Initializable {

    
      @FXML
    private TableView<ShowAllFromDB> tableView;

    @FXML
    private TableColumn<ShowAllFromDB, Integer> idColumn;

    @FXML
    private TableColumn<ShowAllFromDB, String> firstColumn;

    @FXML
    private TableColumn<ShowAllFromDB, String> lastColumn;

    @FXML
    private TableColumn<ShowAllFromDB, String> ageColumn;

    @FXML
    private TableColumn<ShowAllFromDB, String> genderColumn;

    @FXML
    private TableColumn<ShowAllFromDB, String> CountryColumn;

    @FXML
    private TableColumn<ShowAllFromDB, String> passportColumn;

    @FXML
    private TableColumn<ShowAllFromDB, String> joinDateColumn;

    @FXML
    private TableColumn<ShowAllFromDB, String> mobileColumn;

    @FXML
    private TableColumn<ShowAllFromDB, String> departColumn;

    @FXML
    private TableColumn<ShowAllFromDB, String> sectionColumn;

    @FXML
    private TableColumn<ShowAllFromDB, Integer> gradeColumn;
    
      @FXML
    private TableColumn<ShowAllFromDB,String> position;
    
         @FXML
    void ExitButton(ActionEvent event) {
        System.exit(0);
    }
    
  

    
    
     @FXML
    void backButton(ActionEvent event) {
          try {
              ((Node)event.getSource()).getScene().getWindow().hide();
              FXMLLoader f = new FXMLLoader(getClass().getResource("MainPage.fxml"));
              Parent p = (Parent)f.load();
              Stage s = new Stage();
              s.setResizable(false);
              s.centerOnScreen();
              s.setScene(new Scene(p));
              s.show();
          } catch (IOException ex) {
              System.out.println(ex.getMessage());  
          }
    }
     final ObservableList <ShowAllFromDB> data = FXCollections.observableArrayList();
    
        @FXML
    void deleteEmployee(ActionEvent event) {
        int selectedIndex = tableView.getSelectionModel().getSelectedIndex();
        
        if(selectedIndex >= 0){
            int sh = tableView.getSelectionModel().getSelectedItem().getId();
            tableView.getItems().remove(selectedIndex);
            
           try{
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "root21485");

                PreparedStatement pst = conn.prepareStatement("DELETE FROM C4 WHERE ID = '"+sh+"'");
                pst.executeUpdate();
                 Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Information Dialog");
                    alert.setHeaderText("Congrats Message");
                    alert.setContentText("All Employee Data Has Been Deleted");
                    alert.showAndWait();
                    
           }catch(ClassNotFoundException | SQLException e){
               System.out.println(e.getMessage());
           }
            
        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Information Dialog");
                    alert.setHeaderText("Error Message");
                    alert.setContentText("Please Select an Employee First");
                    alert.showAndWait();
           
        }
    }
           
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       

        
        try{
             Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "root21485");

                PreparedStatement pst = conn.prepareStatement("SELECT * FROM C4");
                ResultSet rs = pst.executeQuery();
                while(rs.next()){
                    data.add(new ShowAllFromDB(rs.getInt("ID"), rs.getString("FIRST"), rs.getString("LAST"), rs.getString("AGE"), rs.getString("GENDER"), rs.getString("NATIONALITY"), rs.getString("PASSPORT"), rs.getString("JOINDATE"), rs.getString("MOBILE"), rs.getString("DAPART"), rs.getString("SECTION"),rs.getString("POSITION"), rs.getInt("GRADE")));
               
                
                }
                
                
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        
        
       idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        firstColumn.setCellValueFactory(new PropertyValueFactory<>("first"));
        lastColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        ageColumn.setCellValueFactory(new PropertyValueFactory<>("age"));
        genderColumn.setCellValueFactory(new PropertyValueFactory<>("gender"));
        CountryColumn.setCellValueFactory(new PropertyValueFactory<>("country"));
        passportColumn.setCellValueFactory(new PropertyValueFactory<>("passport"));
        joinDateColumn.setCellValueFactory(new PropertyValueFactory<>("joinDate"));
        mobileColumn.setCellValueFactory(new PropertyValueFactory<>("mobile"));
        departColumn.setCellValueFactory(new PropertyValueFactory<>("department"));
        sectionColumn.setCellValueFactory(new PropertyValueFactory<>("section"));
        position.setCellValueFactory(new PropertyValueFactory<>("position"));
        gradeColumn.setCellValueFactory(new PropertyValueFactory<>("grade"));
        
        tableView.setItems(data);
        
    }    
    
}
