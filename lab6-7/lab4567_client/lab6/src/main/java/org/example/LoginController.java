package org.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class LoginController {
    @FXML
    private Button sendButton;
    @FXML
    private TextField nameField;

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
            String s = nameField.getText();
            //mssg = s;
            System.out.println(s);

            nameField.clear();
            nameField.setEditable(false);
            sendButton.setDisable(true);

            out.println(s);
            out.flush();

            //s = in.readLine();

            //Panel.ResultDialog dialog = new Panel.ResultDialog(Panel.this, "Результат", s);

            //out.close();
            //in.close();
            //socket.close();

            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/mainPage.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            stage.setScene(scene);

            MainController mainController = fxmlLoader.getController();
            mainController.setIn(in);
            mainController.setOut(out);
            mainController.setSocket(socket);
            mainController.setStage(stage);


        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }
}
