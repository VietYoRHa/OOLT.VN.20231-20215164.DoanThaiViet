package hust.soict.hedspi.aims.screen.customer.controller;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class CartController {
    private Cart cart;
    private FilteredList<Media> filteredList;

    @FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;

    @FXML
    private TableColumn<Media, String> colMediaCategory;

    @FXML
    private TableColumn<Media, Float> colMediaCost;

    @FXML
    private TableColumn<Media, Integer> colMediaId;

    @FXML
    private TableColumn<Media, String> colMediaTitle;

    @FXML
    private Label costLabel;

    @FXML
    private ToggleGroup filterCategory;

    @FXML
    private RadioButton radioBtnFilterId;

    @FXML
    private RadioButton radioBtnFilterTitle;

    private RadioButton selectedRadioButton;

    @FXML
    private TableView<Media> tblMedia = new TableView<>(filteredList);

    @FXML
    private TextField tfFilter;

    @FXML
    void btnPlayPressed(ActionEvent event) {

    }

    @FXML
    void btnRemovePressed(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        cart.removeMedia(media);
    }

    @FXML
    void btnViewStorePressed(ActionEvent event) {

    }

    @FXML
    void radioBtnFilterIdPressed(ActionEvent event) {
        selectedRadioButton = radioBtnFilterId;
    }

    @FXML
    void radioBtnFilterTitlePressed(ActionEvent event) {
        selectedRadioButton = radioBtnFilterTitle;
    }

    @FXML
    public void initialize(){
        selectedRadioButton = radioBtnFilterId;
        colMediaId.setCellValueFactory(new PropertyValueFactory<Media, Integer>("id"));
        colMediaTitle.setCellValueFactory(new PropertyValueFactory<Media, String>("title"));
        colMediaCategory.setCellValueFactory(new PropertyValueFactory<Media, String>("category"));
        colMediaCost.setCellValueFactory(new PropertyValueFactory<Media, Float>("cost"));
        if(cart.getItemsOrdered() != null)
            tblMedia.setItems(cart.getItemsOrdered());
        costLabel.setText(cart.totalCost() + " $");

        btnPlay.setVisible(false);
        btnRemove.setVisible(false);

        tblMedia.setItems(filteredList);
        tblMedia.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Media>() {
            @Override
            public void changed(ObservableValue<? extends Media> observable, Media oldValue, Media newValue) {
                updateButtonBar(newValue);
            }
        });

        tfFilter.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                showFilteredMedia(newValue);
            }
        });
    }

    void updateButtonBar(Media media){
        if (media == null) {
            btnPlay.setVisible(false);
            btnRemove.setVisible(false);
        } else {
            btnRemove.setVisible(true);
            if (media instanceof Playable){
                btnPlay.setVisible(true);
            } else {
                btnPlay.setVisible(false);
            }
        }
    }

    void showFilteredMedia(String string){
        String filterText = string.toLowerCase();
        if(selectedRadioButton == radioBtnFilterId){
            filteredList.setPredicate(item -> String.valueOf(item.getId()).contains(filterText));
        } else if(selectedRadioButton == radioBtnFilterTitle){
            filteredList.setPredicate(item -> item.getTitle().toLowerCase().contains(filterText));
        }
    }

    public CartController(Cart cart){
        this.cart = cart;
        this.filteredList = new FilteredList<>(cart.getItemsOrdered());
    }

}

