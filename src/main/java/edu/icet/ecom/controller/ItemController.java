package edu.icet.ecom.controller;

import edu.icet.ecom.db.Database;
import edu.icet.ecom.dto.ItemDTO;
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

public class ItemController {

    @FXML
    private TableColumn<?, ?> colPrice;

    @FXML
    private TableColumn<?, ?> colCategory;

    @FXML
    private TableColumn<?, ?> colDes;

    @FXML
    private TableColumn<?, ?> colId;

    @FXML
    private TableColumn<?, ?> colQty;

    @FXML
    private TableView<ItemDTO> tblItem;

    ObservableList<ItemDTO> itemObservableList = FXCollections.observableArrayList();
    @FXML
    private void reload(){
        String sql = "select item_code,description,category,qty,unit_price from item";
        try (PreparedStatement preparedStatement = Database.getInstance().prepareStatement(sql)){
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                ItemDTO itemDTO = new ItemDTO(
                        resultSet.getString("item_code"),
                        resultSet.getString("description"),
                        resultSet.getString("category"),
                        resultSet.getInt("qty"),
                        resultSet.getDouble("unit_price")
                );
                itemObservableList.add(itemDTO);
            }
            colId.setCellValueFactory(new PropertyValueFactory<>("itemCode"));
            colDes.setCellValueFactory(new PropertyValueFactory<>("description"));
            colCategory.setCellValueFactory(new PropertyValueFactory<>("category"));
            colQty.setCellValueFactory(new PropertyValueFactory<>("qty"));
            ColPrice.setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
            tblItem.setItems(itemObservableList);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

}
