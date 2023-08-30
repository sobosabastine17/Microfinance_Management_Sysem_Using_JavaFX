package com.example.mmf;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;

public class controller implements Initializable {
    @FXML
    private CheckBox passwordVisible;
    @FXML
    private TextField txtUser;
    @FXML
    private PasswordField txtPassword;
    @FXML
    private Button btnLogin,btnCustomers,btnNotification,btnStaff,btnAddStaff,btnAddCustomer,btnDashboard,
            btnLogout,btnUploadImage;
    //start of add customer widget
    @FXML
            private TextField txtFName,txtLName,txtNationality,txtPlaceOfBirth,txtHomeTown,txtIDNumber,txtPhoneNumber,
            txtEmail,txtHouseAddress,txtDigitalAddress,txtAccountNumber,txtProfession;
    @FXML
    private ImageView imgProfile;
    @FXML
            private DatePicker dateOfBirth;
    @FXML
            private ComboBox cmbIDType,cmbAccountType,cmbEducationLevel;
    @FXML
            private TextField txtGenerateAccNumber,txtAccBalance;
    //end of add customer widget
    int x,y;
    model Model = new model();

    public controller() {
    }
    public void logout(ActionEvent event) throws IOException {
        if (event.getTarget()==btnLogout){
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation");
            alert.setHeaderText("LOGGING OUT!!");
            alert.setContentText("Are you sure you want to Sign Out?");
            alert.setHeight(250);
            alert.setWidth(500);
            alert.showAndWait().ifPresent(rs -> {
                if (rs == ButtonType.OK) {
                    try {
                        Model.logoutScene(btnLogout);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            });

        }
    }

    //login handler
    @FXML
    public void btnLogin(ActionEvent event){

        ResultSet result;

        Connection connection = dbConnection.getConnection();
        String email=txtUser.getText();
        String password=txtPassword.getText();

        try {
            Statement statement= connection.createStatement();
            String managerQuery="select* from staff where email='"+email+"' and status='ACTIVE'";
            result = statement.executeQuery(managerQuery);
            if (txtUser.getText()=="" || txtPassword.getText()==""){
                Model.message("Empty Field","Field required","Please fill all the required field");
            }else {
                while(result.next()) {
                    String position= result.getString("position");
                    String confirmPass= result.getString("password");
                    if(txtPassword.getText().equals(confirmPass)){
                        if(position.equals("manager")){
                            //checking for login credentials
                            Model.login(email, password);
                            //loading the dashboard fxml
                            Model.changeScene(btnLogin,"dashboard.fxml");

                        } else if (position.equals("agent")) {
                            Model.login(email, password);
                            Model.message("Success","Welcome Agent","Enjoy");
                        } else {
                            System.out.println("not found");
                        }
                    }else {
                        System.out.println("Pass not found");
                    }
                }
                connection.close();
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    //Method handling the dashboard navigation
    @FXML
    private void homeNavigation(ActionEvent event) throws IOException {
         if (event.getTarget()==btnAddCustomer) {
             Stage stage = new Stage();
             FXMLLoader fxmlLoader = new FXMLLoader(main.class.getResource("addCustomer.fxml"));
             Scene scene = new Scene(fxmlLoader.load());
             //stage.setTitle("Hello!");
             stage.setScene(scene);
             stage.initStyle(StageStyle.TRANSPARENT);
             stage.initModality(Modality.WINDOW_MODAL);
             stage.initOwner(btnCustomers.getScene().getWindow());
             stage.show();
        }

        else if (event.getTarget()==btnCustomers) {
            Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(main.class.getResource("customerManager.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            //stage.setTitle("Hello!");
            stage.setScene(scene);
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(btnCustomers.getScene().getWindow());
            stage.show();
        }

        else if (event.getTarget()==btnAddStaff) {
             Stage stage = new Stage();
             FXMLLoader fxmlLoader = new FXMLLoader(main.class.getResource("addStaff.fxml"));
             Scene scene = new Scene(fxmlLoader.load());
             //stage.setTitle("Hello!");
             stage.setScene(scene);
             stage.initStyle(StageStyle.TRANSPARENT);
             stage.initModality(Modality.WINDOW_MODAL);
             stage.initOwner(btnCustomers.getScene().getWindow());
             stage.show();
        }

        else if (event.getTarget()==btnStaff) {
             Stage stage = new Stage();
             FXMLLoader fxmlLoader = new FXMLLoader(main.class.getResource("staffManager.fxml"));
             Scene scene = new Scene(fxmlLoader.load());
             //stage.setTitle("Hello!");
             stage.setScene(scene);
             stage.initStyle(StageStyle.TRANSPARENT);
             stage.initModality(Modality.WINDOW_MODAL);
             stage.initOwner(btnCustomers.getScene().getWindow());
             stage.show();
        }

        else if (event.getTarget()==btnNotification) {
             Stage stage = new Stage();
             FXMLLoader fxmlLoader = new FXMLLoader(main.class.getResource("notification.fxml"));
             Scene scene = new Scene(fxmlLoader.load());
             //stage.setTitle("Hello!");
             stage.setScene(scene);
             stage.initStyle(StageStyle.TRANSPARENT);
             stage.initModality(Modality.WINDOW_MODAL);
             stage.initOwner(btnCustomers.getScene().getWindow());
             stage.show();
        }

    }

    //password visibility
    public void passwordVisibility(ActionEvent event){
        if (passwordVisible.isSelected()){
           // txtPassword.setPromptText(txtPassword.getText());
          //  txtPassword.setEchoChar((char)0);
        }
        else {
            //txtPassword.setEchoChar('*');
            //txtPassword.toBack();
           // txtPassword.setText(txtPassword.getText());
        }
    }
    @FXML
    public void MouseDrag(MouseEvent event){
        Node node= (Node) event.getSource();
        Stage stage= (Stage) node.getScene().getWindow();
        stage.setX(event.getScreenX()-x);
        stage.setY(event.getScreenY()-y);
    }
    @FXML
    public void closeWindow(ActionEvent event){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText("CLOSE WINDOW!!");
        alert.setContentText("Are you sure you want to close this window?");
        alert.setHeight(250);
        alert.setWidth(500);
        alert.showAndWait().ifPresent(rs -> {
            if (rs == ButtonType.OK) {
                Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
                stage.close();
            }
        });
    }
    @FXML
    public void mousePress(MouseEvent event){
        x=(int) event.getSceneX();
        y=(int) event.getSceneY();
    }
    //Generating account number
    public void generateAccNumber(ActionEvent event){
        allComboBox();
        txtGenerateAccNumber.setText(Model.randomID(15));
    }

    //inserting into customer
    public void btnRegisterCustomer(ActionEvent event){
        LocalDate ld = dateOfBirth.getValue();
        Calendar c = Calendar.getInstance();
        c.set(ld.getYear(), ld.getMonthValue(), ld.getDayOfMonth());
        Date date = c.getTime();
        String myDate = date.toString();
        String fname=txtFName.getText();
        String lname=txtLName.getText();
        String  nationality=txtNationality.getText();
        String placeOfBirth=txtPlaceOfBirth.getText();
        String homeTown=txtHomeTown.getText();
        String IDNumber=txtIDNumber.getText();
        String phoneNumber=txtPhoneNumber.getText();
        String email=txtEmail.getText();
        String houseAddress=txtHouseAddress.getText();
        String digitalAddress=txtDigitalAddress.getText();
        String accountNumber=txtAccountNumber.getText();
        String profession=txtProfession.getText();
        String IDType = (String) cmbIDType.getValue();
        String accountType = (String) cmbAccountType.getValue();
        String educationLevel = (String) cmbEducationLevel.getValue();
        String generateAccNumber=txtGenerateAccNumber.getText();
        String AccBalance=txtAccBalance.getText();

        allComboBox();

      model Model= new model();
      //checking if account number is empty
      if (generateAccNumber.isEmpty()){
          Model.message("Something Went Wrong","Account Number Error",
                  "Please Check Account Number before proceeding");
      }else {
          //checking the validity of the account number
          if (AccBalance.isEmpty() || Integer.parseInt(AccBalance)<10){
              Model.message("Something Went Wrong","Account Balance Set Error",
                      "Please Check Account Balance Set before proceeding");
          }else {
              //Checking if the phone number is 10 digit
              if(phoneNumber.length() < 10){
                  Model.message("checking digit size","checking digit size","checking digit size");
              }else {
                  Model.numberCheck(phoneNumber);

                  //checking if phone number start with zero
                  if (phoneNumber.indexOf(0)==0){
                      Model.message("Phone No invalid","Phone No invalid","Phone No invalid");
                  }else {
                      if (dateOfBirth.getValue()==null){
                          Model.message("ERROR","Wrong Date","Kindly set the date to proceed");
                      }else {
                          if (fname.isEmpty() ||lname.isEmpty() ||nationality.isEmpty() ||placeOfBirth.isEmpty() ||homeTown.isEmpty()
                                  ||IDNumber.isEmpty() ||email.isEmpty() ||houseAddress.isEmpty()
                                  ||digitalAddress.isEmpty() || profession.isEmpty() ||IDType.isEmpty()
                                  ||accountType.isEmpty() ||educationLevel.isEmpty() ||myDate.isEmpty()){
                              Model.message("ERROR","All Field Required",
                                      "Kindly fill all the required field in the forms");
                          }else {
                              //txtAccountNumber.setText("1234567890");
                              //confirm email
                              //confirm account number
                              if(txtEmail.getText().isEmpty()){
                                  JOptionPane.showMessageDialog(null, "Email field is empty");
                              }else {
                                  Model.verifyEmail(txtEmail);
                                  if (txtPhoneNumber.getText().isEmpty()){

                                  }else {
                                      // Model.numberCheck(txtPhoneNumber);
                                      Model.insertIntoCustomers(fname,lname,accountType,myDate,digitalAddress,educationLevel,email,
                                              homeTown,houseAddress,IDType,IDNumber,nationality,phoneNumber,placeOfBirth,profession,placeOfBirth,
                                              "imgProfile","active",generateAccNumber,Integer.parseInt(AccBalance));
                                  }
                              }
                          }
                      }
                  }
              }
          }
      }
    }
    public void allComboBox(){
        ObservableList<String> IDType = (ObservableList<String>) FXCollections.observableArrayList("ECOWAS CARD",
                "VOTER ID", "PASSPORT", "SSNIT");
        ObservableList<String> accountType = (ObservableList<String>) FXCollections.observableArrayList("SAVINGS",
                "CURRENT", "LOAN", "INVESTMENT");
        ObservableList<String> educationLevel = (ObservableList<String>) FXCollections.observableArrayList("J.H.S", "S.H.S",
                "TERTIARY", "PRIMARY","NONE");
        cmbIDType.setItems(IDType);
        cmbAccountType.setItems(accountType);
        cmbEducationLevel.setItems(educationLevel);
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //allComboBox();
       // Model.accountNumber();
    }

}
