package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class LoginController {
    @FXML
    private void click1(ActionEvent event)throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("signup.fxml"));
        Stage secondStage;
        secondStage= ((Stage) ((Node)event.getSource()).getScene().getWindow());
        secondStage.setTitle("admin");
        secondStage.setScene(new Scene(root));
        secondStage.setResizable(false);
    }

    @FXML
    Label dbstate;

    public void statusDB(ActionEvent e) throws IOException , SQLException {

        if(!ClientDB.getConnection().isClosed()){
            dbstate.setText("Connected");
        }
        else {
            dbstate.setText("Not Connected");
        }
    }
}
