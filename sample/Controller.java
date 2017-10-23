package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller {

    @FXML
    private void click1(ActionEvent event)throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("signup.fxml"));
        Stage secondStage;
        secondStage= ((Stage) ((Node)event.getSource()).getScene().getWindow());
        secondStage.setTitle("admin");
        secondStage.setScene(new Scene(root));
    }

    /*@FXML
    private void click2(ActionEvent event)throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("signup.fxml"));
        Stage thirdStage;
        thirdStage= ((Stage) ((Node)event.getSource()).getScene().getWindow());
        thirdStage.setTitle("client");
        thirdStage.setScene(new Scene(root));
    }*/
}
