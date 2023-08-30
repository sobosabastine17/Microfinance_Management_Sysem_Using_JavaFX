package com.example.mmf;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import java.sql.Connection;
import java.sql.DriverManager;

public class dbConnection {
    //Here contain my database connectivity

    public static Connection connect;

    public static Connection getConnection() {
        //Database name
        String dbname="mmf";

        //Database username
        String user="javafx";

        //Database password
        String pass="javafx";

        try {
            //This is connecting my database drivers
            Class.forName("com.mysql.cj.jdbc.Driver");

            //This connecting my database
            connect=DriverManager.getConnection("jdbc:mysql://localhost:3306/"+dbname,user,pass);
            System.out.println("Database connected successfully");
        }    catch (Exception e) {

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Access Denied");
            alert.setHeaderText("Database Connection Erro mr!!");
            alert.setContentText("Please kind check your Database connection or your Internet connectivity!!");
            alert.setHeight(250);
            alert.setWidth(500);
            alert.showAndWait().ifPresent(rs -> {
                if (rs == ButtonType.OK) {
                    System.out.println("Error triggered");
                }
            });

            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return connect;

    }
}
