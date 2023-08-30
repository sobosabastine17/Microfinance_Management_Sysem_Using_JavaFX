package com.example.mmf;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class model{


    String query = null;
    //Connection connection = null;
    private PreparedStatement preparedStatement;
    private ResultSet result;
    private Statement statement;
    Connection connection = dbConnection.getConnection();

    //Scene switching
    public void changeScene(Button btnKey,String fxml) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(fxml));
        Stage window = (Stage) btnKey.getScene().getWindow();
        window.setScene(new Scene(root));
    }

    //logout scene
    public void logoutScene(Button btn) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        Stage window = (Stage) btn.getScene().getWindow();
        window.setScene(new Scene(root));
    }

    //field required message method
    public void message(String title,String header,String content){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.setHeight(250);
        alert.setWidth(500);
        alert.showAndWait().ifPresent(rs -> {
            if (rs == ButtonType.OK) {
            }
        });
    }//end of message

    // Login function
    public void login(String username, String password) {
        try {
            String query = "select* from staff where email=? and password=?";
            preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            try {
                result = preparedStatement.executeQuery();
                if (result.next()) {
                    message("Access Open","Database Connection!!","Login Successful!!");
                } else {
                    message("Access Denied","Database Connection Error!!","Login Failed, Username or Password incorrect!!");
                }
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }//end of login

    // search data from the table
    public void searchQuery(TableView<customer> TableName,String keyword,String col1,String col2,
                            String col3,String col4) throws SQLException {

        ObservableList<customer> customersList= FXCollections.observableArrayList();

        String searchQuery="select * from customer where '"+col1+"' like '%?%' or '"+col2+"' like '%?%' or" +
                "'"+col3+"' like '%?%' or '"+col4+"' like '%?%'";

        preparedStatement = connection.prepareStatement(searchQuery);

        preparedStatement.setString(1, keyword);
        preparedStatement.setString(2, keyword);
        preparedStatement.setString(3, keyword);
        preparedStatement.setString(4, keyword);

        try {
            customersList.clear();
            ResultSet resultSet = connection.createStatement().executeQuery("select * from customer");

            while (resultSet.next()){
               // int newID=id+1;
                customersList.add(new customer(
                       // resultSet.getInt("id"),
                        resultSet.getString("date"),
                        resultSet.getString("status"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getString("nationality"),
                        resultSet.getString("date_of_birth"),
                        resultSet.getString("home_town"),
                        resultSet.getString("date_of_birth"),
                        resultSet.getString("id_type"),
                        resultSet.getString("id_number"),
                        resultSet.getString("phone_number"),
                        resultSet.getString("email"),
                        resultSet.getString("house_address"),
                        resultSet.getString("digital_address"),
                        resultSet.getString("account_type"),
                        resultSet.getString("account_number"),
                        resultSet.getString("education_level"),
                        resultSet.getString("profession"),
                        resultSet.getString("profile"),
                        resultSet.getDouble("balance")

                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        TableName.setItems(customersList);
    }

    //inserting into customers table
    public void insertIntoCustomers(String first_name,String last_name,String account_type,String date,
                                    String date_of_birth,String digital_address,String education_level,String email,
                                    String home_town,String house_address,String id_type,String id_number,
                                    String nationality,String phone_number,String place_of_birth,String profession,
                                    String profile,String status,String account_number,double balance){
        try {
            String query = "INSERT INTO `customer`(`date`, `first_name`, `last_name`, `nationality`," +
                    "`place_of_birth`, `home_town`, `date_of_birth`, `id_type`, `id_number`, `phone_number`," +
                    "`email`, `house_address`, `digital_address`, `account_type`, `account_number`," +
                    "`education_level`, `profession`, `profile`, `balance`, `status`) " +
                    "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            preparedStatement = connection.prepareStatement(query);

          //  preparedStatement.setString(1, "id");
            preparedStatement.setString(1, date);
            preparedStatement.setString(2, first_name);
            preparedStatement.setString(3, last_name);
            preparedStatement.setString(4, nationality);
            preparedStatement.setString(5, place_of_birth);
            preparedStatement.setString(6, home_town);
            preparedStatement.setString(7, date_of_birth);
            preparedStatement.setString(8, id_type);
            preparedStatement.setString(9, id_number);
            preparedStatement.setString(10, phone_number);
            preparedStatement.setString(11, email);
            preparedStatement.setString(12, house_address);
            preparedStatement.setString(13, digital_address);
            preparedStatement.setString(14, account_type);
            preparedStatement.setString(15, account_number);
            preparedStatement.setString(16, education_level);
            preparedStatement.setString(17, profession);
            preparedStatement.setString(18, profile);
            preparedStatement.setDouble(19, balance);
            preparedStatement.setString(20, status);
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation");
            alert.setHeaderText("PROCESS ACCOUNT!!");
            alert.setContentText("You are about to register "+first_name+" "+last_name+" on this platform \n"
            + "Account No: "+account_number+"\n Balance: "+balance);
            alert.setHeight(250);
            alert.setWidth(500);
            alert.showAndWait().ifPresent(rs -> {
                if (rs == ButtonType.OK) {
                    int result = 0;
                    try {
                        result = preparedStatement.executeUpdate();
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                    if (result==1) {
                        message("SUCCESSFUL","Customer Registration Successful!!","" +
                                "You have successfully register "+first_name+" "+ last_name +" on the platform \n" +
                                "Account No: "+ account_number +"\n Balance: "+balance);
                    } else {
                        message("ERROR","Customer Registration error!!","Check your internet connection or" +
                                " database(IF PROBLEM INSIST, KINDLY CONTACT THE DEVELOPER)");
                    }
                }
            });

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    //inserting into staff table
    public void insertIntoStaff(){

    }//end of method


    //inserting into beneficiary table
    public void insertIntoBeneficiary(){

    }

    //Generating random password
    public String randomPassword(int length) {
        String codeGenerator = "QWERTYUIOPASDFGHJKLMNBVCXZqwertyuiopasdfghjklmnbvcxz0123456789!@#$%^&*()_+";
        // Random random= new SecureRandom();
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int index = (int) (codeGenerator.length() * Math.random());

            sb.append(codeGenerator.charAt(index));
        }

        return sb.toString();
    }

    //Generating Account Number
    public void accountNumber() {
        int i,sum=0;
        String ret="";

        long bankAccNumber=100000000;
        String accountNumberQuery="SELECT account_Number FROM customer";
                String bankNumber="14000";
                String accountNum=bankNumber+""+Long.toString(bankAccNumber);
               // String checkAccountNumber=(result.getString("account_number"));

                String newAccountNumber=accountNum;
                    //query to check if the account number exist
                    try {
                        String checkAccQuery = "select* from customer where account_number=? ";
                        preparedStatement = connection.prepareStatement(checkAccQuery);

                        preparedStatement.setString(1, accountNum);
                        try {
                            result = preparedStatement.executeQuery();
                            if (result.next()) {
                                message("ERROR","Account number Problem","Account number already in the system");
                                //Getting the last account number generated from the database
                                String lastAccNumQuery="SELECT FROM customer where account_number=? ";
                                preparedStatement.setString(1, newAccountNumber);
                                preparedStatement=connection.prepareStatement(lastAccNumQuery);
                                try {
                                    result=preparedStatement.executeQuery();
                                    String checkAccountNumber=(result.getString("account_number"));
                                  // String sub= String.valueOf(checkAccountNumber).substring(5);

                                   // Long newAcc=Long.parseLong(sub);
                                   // newAcc++;
                                  //  String accountNum2=bankNumber+""+Long.toString(newAcc);
                                   // System.out.println("testing the acc number "+accountNum2);
                                    System.out.println(result.getString("account_number"));
                                }catch (SQLException e){
                                    e.printStackTrace();
                                }
                            } else {
                                message("Access Denied","Database Connection Error!!","Login Failed, Username or Password incorrect!!");
                            }
                        } catch (SQLException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    } catch (SQLException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }

    }

    // ImageView set

    public void setPicture(ImageView img) {
        FileChooser chooser = new FileChooser();
        FileChooser.ExtensionFilter extensionJPG = new FileChooser.ExtensionFilter("JPG files (*.jpg)", "*.JPG");
        FileChooser.ExtensionFilter extensionJPEG = new FileChooser.ExtensionFilter("JPEG files (*.jpeg)", "*.JPEG");
        FileChooser.ExtensionFilter extensionPNG = new FileChooser.ExtensionFilter("PNG files (*.png)", "*.PNG");
        chooser.getExtensionFilters().addAll(extensionJPG, extensionJPEG, extensionPNG);
        File file = new FileChooser().showOpenDialog(null);
        try {
            BufferedImage bufferedImage = ImageIO.read(file);
            Image image = SwingFXUtils.toFXImage(bufferedImage, null);
            img.setImage(image);

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            String message = "You did not select image or you select image with disallow extension\n Only *JPEG*,*JPG*,*PNG* allow";
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Something went wrong");
            alert.setContentText(message);
            alert.showAndWait();
        }
    }


    // Number verification function
    public boolean numberVerification(String widget) {
        String number = "[0-9]*";
        Pattern patern = Pattern.compile(number);
        Matcher m = patern.matcher(widget);
        if (m.find() && m.group().equals(widget)) {
            JOptionPane.showMessageDialog(null, "Ticket Added Successfully");
            // System.out.println("Invalid");
            return true;
        }
        return false;
    }//end of number verification

    // Password Generator
    public String randomID(int length) {
        String codeGenerator = "0123456789";
        // Random random= new SecureRandom();
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int index = (int) (codeGenerator.length() * Math.random());
            sb.append(codeGenerator.charAt(index));
        }
        return sb.toString();
    }//end of password generator

    //email verification
    public boolean verifyEmail(TextField email) {
        String EmailID="[a-zA-Z0-9._]*@[a-zA-Z0-9]+([.][a-zA-Z0-9]+)+";
        Pattern patern= Pattern.compile(EmailID);
        Matcher m= patern.matcher(email.getText());
        if(m.find() && m.group().equals(email.getText())) {
            return true;
        }
        else {
            Alert alert= new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Email Confirmation Error");
            alert.setContentText("Incorrect Email entered");
            alert.showAndWait();
        }
        System.out.println("Invalid");
        return false;
    }//end of email verification

    //checking if input is a number
    public boolean numberCheck(String input) {
        String n1 = input.toString();
        String restricted = "[a-zA-z]*";
        if (!n1.matches(restricted)) {
                 return true;
        }else {
            JOptionPane.showMessageDialog(null, "Please enter a only number");
        }
        return false;
    }//end of number check method


}//end of model class


