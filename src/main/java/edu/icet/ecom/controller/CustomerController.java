package edu.icet.ecom.controller;

import edu.icet.ecom.db.Database;
import edu.icet.ecom.dto.CustomerDTO;
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
    private TableColumn<?, ?> colDob;

    @FXML
    private TableColumn<?, ?> colId;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colPostalCode;

    @FXML
    private TableColumn<?, ?> colProvince;

    @FXML
    private TableColumn<?, ?> colTitle;
    @FXML
    private TableView<CustomerDTO> tblCustomer;

    ObservableList<CustomerDTO> customerDTOS = FXCollections.observableArrayList();
    public void reload() {
        String sql = "select customer_id,title,name,dob,address,city,province,postal_code from customer";
        try (PreparedStatement preparedStatement = Database.getInstance().prepareStatement(sql)){
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                CustomerDTO customerDTO = new CustomerDTO(
                        resultSet.getString("customer_id"),
                        resultSet.getString("title"),
                        resultSet.getString("name"),
                        resultSet.getString("dob"),
                        resultSet.getString("address"),
                        resultSet.getString("city"),
                        resultSet.getString("province"),
                        resultSet.getInt("postal_code")
                )   ;
                customerDTOS.add(customerDTO);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
            colId.setCellValueFactory(new PropertyValueFactory<>("id"));
            colTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
            colName.setCellValueFactory(new PropertyValueFactory<>("name"));
            colDob.setCellValueFactory(new PropertyValueFactory<>("dob"));
            colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
            colCity.setCellValueFactory(new PropertyValueFactory<>("city"));
            colProvince.setCellValueFactory(new PropertyValueFactory<>("province"));
            colPostalCode.setCellValueFactory(new PropertyValueFactory<>("postalCode"));
            tblCustomer.setItems(customerDTOS);

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
