package edu.icet.ecom.controller;

import edu.icet.ecom.db.Database;
import edu.icet.ecom.dto.Customer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class CustomerController implements Initializable {

    @FXML
    private TableColumn<?, ?> colAddress;

    @FXML
    private TableColumn<?, ?> colCity;

    @FXML
    private TableColumn<?, ?> colEmail;

    @FXML
    private TableColumn<?, ?> colFirstName;

    @FXML
    private TableColumn<?, ?> colId;

    @FXML
    private TableColumn<?, ?> colLastName;

    @FXML
    private TableColumn<?, ?> colPhone;

    @FXML
    private TableColumn<?, ?> colRd;

    @FXML
    private TableView<Customer> tblCustomer;

    ObservableList<Customer> customers = FXCollections.observableArrayList();
    public void reload() {
        try (PreparedStatement preparedStatement = Database.getInstance().prepareStatement("select * from customers")){
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Customer customer = new Customer(
                        resultSet.getString("customer_id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getString("email"),
                        resultSet.getString("phone"),
                        resultSet.getString("address"),
                        resultSet.getString("city"),
                        resultSet.getString("registered_date")
                );
                customers.add(customer);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
            colId.setCellValueFactory(new PropertyValueFactory<>("id"));
            colFirstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
            colLastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
            colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
            colPhone.setCellValueFactory(new PropertyValueFactory<>("phone"));
            colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
            colCity.setCellValueFactory(new PropertyValueFactory<>("city"));
            colRd.setCellValueFactory(new PropertyValueFactory<>("registeredDate"));
            tblCustomer.setItems(customers);


    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            reload();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
