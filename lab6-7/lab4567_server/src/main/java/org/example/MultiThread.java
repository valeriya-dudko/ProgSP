package org.example;

import java.io.*;
import java.net.*;
import java.util.Arrays;

public class MultiThread extends Thread {
    private Socket socket;
    private int[] sLottery;

    public MultiThread(Socket socket, int[] sLottery)
    {
        this.socket = socket;
        this.sLottery = sLottery;
    }

    @Override
    public void run()
    {
        System.out.println("Thread connected.");
        int[] cLottery = new int[sLottery.length];
        int count = 0;

        InputStream inp = null;
        BufferedReader brinp = null;
        PrintWriter out = null;
        try
        {
            inp = socket.getInputStream();
            brinp = new BufferedReader(new InputStreamReader(inp));
            out = new PrintWriter(socket.getOutputStream());
        }
        catch (IOException e)
        {
            e.printStackTrace();
            return;
        }
        String s;
        String username;

            try
            {
                s = brinp.readLine();
                if (s == null)
                {
                    System.out.println("exiting thread...");
                    inp.close();
                    brinp.close();
                    out.close();
                    socket.close();
                    return;
                }

                username = s;

                s = brinp.readLine();

                String[] splitMsg = s.split(", ");
                //out.println(s);
                for (int i = 0; i < 10; i++)
                {
                    cLottery[i] = Integer.parseInt(splitMsg[i]);
                }

                //out.flush();
            }
            catch (IOException e)
            {
                e.printStackTrace();
                return;
            }

        for (int i = 0; i < 10; i++)
        {
            for (int j = 0; j < 10; j++)
            {
                if (sLottery[i] == cLottery[j])
                {
                    count++;
                    break;
                }
            }
        }

        System.out.println(count);

        if(count == 10)
        {
            out.println("Вы выиграли!");
            out.flush();
        }
        else {
            out.println("Вы проиграли! Правильно угаданных чисел: " + count);
            out.flush();
        }

        TicketDao ticketDao = new TicketDao();
        ticketDao.insert(username, count);

        try
        {
            System.out.println("exiting thread...");
            inp.close();
            brinp.close();
            out.close();
            socket.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }
}
