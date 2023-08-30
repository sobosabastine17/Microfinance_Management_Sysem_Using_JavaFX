package com.example.mmf;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

 public class tableController implements Initializable {

    // start of customer manager widget.
    @FXML
    private TableView<customer> customerTable;
    @FXML
    private TableColumn<customer,Integer> tblID;
    @FXML
    private TableColumn<customer, Integer> tblAccountNumber;
    @FXML
    private TableColumn<customer,String> tblAccountType;
    @FXML
    private TableColumn<customer,Double> tblBalance;
    @FXML
    private TableColumn<customer,String> tblDateOfBirth;
    @FXML
    private TableColumn<customer,String> tblDigitalAddress;
    @FXML
    private TableColumn<customer,String> tblEmail;
    @FXML
    private TableColumn<customer,String> tblFirstName;
    @FXML
    private TableColumn<customer,String> tblHomeTown;
    @FXML
    private TableColumn<customer,String> tblHouseAddress;
    @FXML
    private TableColumn<customer,String> tblIDNumber;
    @FXML
    private TableColumn<customer,String> tblIDtype;
    @FXML
    private TableColumn<customer,String> tblLastName;
    @FXML
    private TableColumn<customer,String> tblNationality;
    @FXML
    private TableColumn<customer,String> tblPhoneNumber;
    @FXML
    private TableColumn<customer,String> tblPlaceOfBirth;
    @FXML
    private TableColumn<customer,String> tblProfession;
    @FXML
    private TableColumn<customer,String> tblProfile;
    @FXML
    private TableColumn<customer,String> tblDate;
    @FXML
    private TableColumn<customer,String> tblEducationLevel;
    @FXML
    private TableColumn<customer,String> tblStatus;
    @FXML
    private TableColumn<customer,String> tblAction;
    //end of customer table data column

    //start of customer icon navigator widget
    @FXML
    private Button btnUpdateCustomer,btnPrintCustomer,btnExportCustomer,btnDeleteCustomer;
    //end of customer icons navigator widget

    //start of edit customer details widget
    @FXML
    private Button btnEditClose,btnRefresh,btnRefreshCustomer;
    @FXML
    private VBox customerManagerVBox;
    @FXML
    private AnchorPane anchorPaneEditCustomer;
    @FXML
    public TextField txtEditAccNo,txtSearch;
    //end of edit customer details widget

    int x,y;
    int id=0;
    ObservableList<customer> customersList= FXCollections.observableArrayList();

    protected void loadData(){
        tblID.setCellValueFactory(new PropertyValueFactory<>("id"));
        tblAccountNumber.setCellValueFactory(new PropertyValueFactory<>("account_number"));
        tblAccountType.setCellValueFactory(new PropertyValueFactory<>("account_type"));
        tblBalance.setCellValueFactory(new PropertyValueFactory<>("balance"));
        tblDateOfBirth.setCellValueFactory(new PropertyValueFactory<>("date_of_birth"));
        tblDigitalAddress.setCellValueFactory(new PropertyValueFactory<>("digital_address"));
        tblEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        tblDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        tblFirstName.setCellValueFactory(new PropertyValueFactory<>("first_name"));
        tblHomeTown.setCellValueFactory(new PropertyValueFactory<>("home_town"));
        tblHouseAddress.setCellValueFactory(new PropertyValueFactory<>("house_address"));
        tblIDNumber.setCellValueFactory(new PropertyValueFactory<>("id_number"));
        tblEducationLevel.setCellValueFactory(new PropertyValueFactory<>("education_level"));
        tblIDtype.setCellValueFactory(new PropertyValueFactory<>("id_type"));
        tblLastName.setCellValueFactory(new PropertyValueFactory<>("last_name"));
        tblNationality.setCellValueFactory(new PropertyValueFactory<>("nationality"));
        tblPhoneNumber.setCellValueFactory(new PropertyValueFactory<>("phone_number"));
        tblPlaceOfBirth.setCellValueFactory(new PropertyValueFactory<>("place_of_birth"));
        tblProfession.setCellValueFactory(new PropertyValueFactory<>("profession"));
        tblProfile.setCellValueFactory(new PropertyValueFactory<>("profile"));
        tblStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
    }
    protected void loadCustomerData(){
        loadData();
        Connection connection = dbConnection.getConnection();

        try {
            ResultSet resultSet = connection.createStatement().executeQuery("select * from customer");

            while (resultSet.next()){
               int newID=id+1;
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
        customerTable.setItems(customersList);
    }
/*
    FontAwesomeIconView deleteIcon= new FontAwesomeIconView(FontAwesomeIcon.TRASH);
    deleteIcon.setStyle{
        "-fx-cursor:hand;"
                +"-glyph-size:2em;"
                +"-fx-fill:#ff1744;"
    }
    FontAwesomeIconView editIcon= new FontAwesomeIconView(FontAwesomeIcon.EDIT);
     editIcon.setStyle{
        "-fx-cursor:hand;"
                +"-glyph-size:2em;"
                +"-fx-fill:green;"
    }
    HBox manageBtn = new HBox(editIcon,deleteIcon);
     */
    @FXML
    public void MouseDrag(MouseEvent event){
        Node node= (Node) event.getSource();
        Stage stage= (Stage) node.getScene().getWindow();
        stage.setX(event.getScreenX()-x);
        stage.setY(event.getScreenY()-y);
    }
    @FXML
    public void mousePress(MouseEvent event){
        x=(int) event.getSceneX();
        y=(int) event.getSceneY();
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

    //customer manager table refresh
    public void customerRefresh(){
        //loadData();
        Connection connection = dbConnection.getConnection();
        int id=0;
        try {
            customersList.clear();
            ResultSet resultSet = connection.createStatement().executeQuery("select * from customer");
            while (resultSet.next()){
                id=+1;
                customersList.add(new customer(
                     //   resultSet.getInt("id"),
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
                customerTable.setItems(customersList);}
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Info");
            alert.setHeaderText("Table Have Been Refresh!!");
            alert.setContentText("The table have been successfully refresh");
            alert.setHeight(250);
            alert.setWidth(500);
            alert.showAndWait().ifPresent(rs -> {
                if (rs == ButtonType.OK) {

                }
            });
            connection.close();
            resultSet.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    //customer manager export
    public void exportCustomer(){

    }
    //customer manager print
    public void printCustomer(){

    }
    //customer manager delete
    public void deleteCustomer(){

    }

    //ICONS NAVIGATOR
    public void iconsNavigator(ActionEvent event){
        customer customerSelectedData = customerTable.getSelectionModel().getSelectedItem();

            if (event.getTarget()==btnUpdateCustomer){
                if (customerTable.getSelectionModel().getSelectedItem()!=null){
                anchorPaneEditCustomer.setVisible(true);
                customerManagerVBox.setVisible(false);
                }else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("SOMETHING WRONG");
                    alert.setHeaderText("NO DATA SELECTED!!");
                    alert.setContentText("YOU HAVE TO SELECT A ROW TO APPLY AN ACTION");
                    alert.setHeight(250);
                    alert.setWidth(500);
                    alert.showAndWait().ifPresent(rs -> {
                        if (rs == ButtonType.OK) {
                        }
                    });
                }
                txtEditAccNo.setText(String.valueOf(customerSelectedData.account_number));
            } else if (event.getTarget()==btnEditClose) {
                if (customerTable.getSelectionModel().getSelectedItem()!=null){
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("Confirmation");
                    alert.setHeaderText("CLOSE EDIT CUSTOMER!!");
                    alert.setContentText("ALL INPUT ON THIS WINDOW WILL BE LOST?");
                    alert.setHeight(250);
                    alert.setWidth(500);
                    alert.showAndWait().ifPresent(rs -> {
                        if (rs == ButtonType.OK) {
                            anchorPaneEditCustomer.setVisible(false);
                            customerManagerVBox.setVisible(true);
                        }
                    });

                }else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("SOMETHING WRONG");
                    alert.setHeaderText("NO DATA SELECTED!!");
                    alert.setContentText("YOU HAVE TO SELECT A ROW TO APPLY AN ACTION");
                    alert.setHeight(250);
                    alert.setWidth(500);
                    alert.showAndWait().ifPresent(rs -> {
                        if (rs == ButtonType.OK) {
                        }
                    });
                }

            } else if (event.getTarget()==btnRefreshCustomer) {
                customerRefresh();
            }

    }

    //search customer data
    public void customerSearch(){
        Connection connection = dbConnection.getConnection();
        Statement statement;
        ResultSet resultSet;
        //String query="select * from customer where first_name='"+txtSearch.getText()+"'";
        //String newQuery="select * from customer";
        String query="SELECT `id`, `date`, `first_name`, `last_name`, `nationality`, `place_of_birth`, `home_town`," +
                " `date_of_birth`, `id_type`, `id_number`, `phone_number`, `email`, `house_address`, " +
                "`digital_address`, `account_type`, `account_number`, `education_level`, `profession`, " +
                "`profile`, `balance`, `status` FROM `customer`";
        try {
            statement=connection.createStatement();
            resultSet=statement.executeQuery(query);
            while (resultSet.next()){
              loadData();
               // String queryFName= resultSet.getString("first_name");
               customersList.add(new customer(
                    //   resultSet.getInt("id"),
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
                FilteredList<customer> filteredList = new FilteredList<>(customersList, b ->true);
                txtSearch.textProperty().addListener((observable, oldValue,newValue) ->{
                    filteredList.setPredicate(customer -> {
                        //if no search value is found in the table or the database, then display the whole data
                        if (newValue.isEmpty() || newValue.isBlank() || newValue==null){
                             return true;
                        }
                        String searchKeyword= newValue.toLowerCase();
                        if (customer.getLast_name().indexOf(searchKeyword)>1){
                            return true;
                        } else if (customer.getFirst_name().indexOf(searchKeyword)>1) {
                            return true;
                        }else if (customer.getPhone_number().indexOf(searchKeyword)>1) {
                            return true;
                        }else if (customer.getId_number().indexOf(searchKeyword)>1) {
                            return true;
                        }else if (String.valueOf(customer.getAccount_number()).indexOf(searchKeyword)>1) {
                            return true;
                        }else if (customer.getFirst_name().indexOf(searchKeyword)>1) {
                            return true;
                        }else {
                            return false;
                        }
                    });
                });
                SortedList<customer> sortedList=new SortedList<>(filteredList);
                // Bind sorted result with tableView
                sortedList.comparatorProperty().bind(customerTable.comparatorProperty());
                customerTable.setItems(sortedList);
            }
        }catch (SQLException e){
            //Logger.getLogger()
            e.printStackTrace();
        }

    }

    public void searchCustomerTable(ActionEvent event) throws SQLException {
        model Model = new model();
        loadData();
        Model.searchQuery(customerTable,txtSearch.getText(),"first_name","last_name","phone_number","account_number");
    }

     @Override
     public void initialize(URL url, ResourceBundle resourceBundle) {
         loadCustomerData();
         //customerSearch();
     }
}