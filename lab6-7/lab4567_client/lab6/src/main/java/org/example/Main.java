package org.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);

    }

    @Override
    public void start(Stage stage) throws Exception {
        try
        {
            Socket clientSocket = new Socket("127.0.0.1",2525);

            BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream());

            String clientMessage = null;

            //Panel testWindow = new Panel(in, out, clientSocket);
            //testWindow.setVisible(true);


            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/loginPage.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            LoginController loginController = fxmlLoader.getController();
            loginController.setIn(in);
            loginController.setOut(out);
            loginController.setSocket(clientSocket);
            //loginController.setClient(client);
            loginController.setStage(stage);

            stage.setTitle("Hello!");
            stage.setScene(scene);
            stage.show();


        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }
}