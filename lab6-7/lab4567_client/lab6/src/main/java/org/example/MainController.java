package org.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class MainController {
    @FXML
    private Button sendButton;
    @FXML
    private TextField lotteryField;

    BufferedReader in;
    PrintWriter out;
    Socket socket;
    Stage stage;

    public void setIn(BufferedReader in)
    {
        this.in = in;
    }

    public void setOut(PrintWriter out)
    {
        this.out = out;
    }

    public void setSocket(Socket socket)
    {
        this.socket = socket;
    }

    public void setStage(Stage stage)
    {
        this.stage = stage;
    }

    @FXML
    public void handleSendButton(ActionEvent event)
    {
        try{
            String s = lotteryField.getText();
            System.out.println(s);

            lotteryField.clear();
            lotteryField.setEditable(false);
            sendButton.setDisable(true);

            out.println(s);
            out.flush();

            s = in.readLine();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setTitle("Результат");
            alert.setHeaderText(null);
            alert.setContentText(s);

            alert.showAndWait();

            out.close();
            in.close();
            socket.close();


        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }

}
