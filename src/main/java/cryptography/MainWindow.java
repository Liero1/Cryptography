package cryptography;

import cryptography.base.AlgorithmType;
import cryptography.base.Cryptography;
import cryptography.base.OperationType;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class MainWindow extends Application implements Initializable {

    public Label keyLabel;
    public TextField messageField;
    public TextField keyField;
    public ChoiceBox<OperationType> action;
    public Button performAction;
    public TextField result;
    public ChoiceBox<AlgorithmType> algorithm;


    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/MainWindow.fxml"));
        stage.setTitle("BSK-01");
        Scene scene = new Scene(root);
        stage.setScene(scene);

        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        action.getItems().addAll(OperationType.values());
        action.getSelectionModel().selectFirst();
        algorithm.getItems().addAll(AlgorithmType.values());
        algorithm.getSelectionModel().selectFirst();
        initializeButtonListeners();
    }

    private void initializeButtonListeners() {
        algorithm.getSelectionModel()
                .selectedItemProperty()
                .addListener((observableValue, oldValue, newValue) -> {
                    switch (newValue) {
                        case RAIL_FENCE:
                            keyLabel.setText("Wysokość płotka");
                            keyField.setPromptText("Wysokość płotka");
                            break;

                        case CAESAR:
                            keyLabel.setText("Przesunięcie");
                            keyField.setPromptText("Przesunięcie");
                            break;

                        default:
                            keyLabel.setText("Klucz");
                            keyField.setPromptText("Klucz");
                    }
                });
    }

    public void performAction() {
        String message = messageField.getText();
        String key = keyField.getText();

        if (!message.equals("") && !key.equals("")) {
            OperationType operation = action.getValue();
            Cryptography cryptography = algorithm.getValue().getCryptography();

            switch (operation) {
                case ENCRYPT:
                    String encryptedMsg = cryptography.encrypt(message, key);
                    result.setText(encryptedMsg);
                    break;

                case DECRYPT:
                    String decryptedMsg = cryptography.decrypt(message, key);
                    result.setText(decryptedMsg);
                    break;
            }
        }
    }
}