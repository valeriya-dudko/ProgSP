package org.example;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import java.util.Random;

public class Main {
    static int[] sLottery = new Random().ints(10, 1, 100).toArray();

    public static void main(String[] args) throws IOException {
        ServerSocket server = null;
        Socket socket = null;

        System.out.println(Arrays.toString(sLottery));

        try
        {
            server = new ServerSocket(2525);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        while (true)
        {
            try
            {
                socket = server.accept();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            new MultiThread(socket, sLottery).start();
        }

    }
}