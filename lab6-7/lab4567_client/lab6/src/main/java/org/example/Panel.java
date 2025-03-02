package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Panel extends JFrame {
    JButton button;
    JTextField txtField;
    String mssg;
    Label label1;

    BufferedReader in;
    PrintWriter out;
    Socket socket;


    public Panel(BufferedReader in, PrintWriter out, Socket socket) throws IOException {
        super("Лотерея");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1000, 500);
        setLayout(null);

        this.in = in;
        this.out = out;
        this.socket = socket;

        button = new JButton("Отправить");
        button.setSize(100, 25);
        button.setLocation(400, 150);
        button.addActionListener(new ButtonSender());
        add(button);

        label1 = new Label("Введите 10 чисел от 1 до 100.");
        label1.setSize(200, 25);
        label1.setLocation(375, 50);
        add(label1);

        txtField = new JTextField();
        txtField.setSize(250, 25);
        txtField.setLocation(330, 100);
        add(txtField);

    }

    public String getMsg()
    {
        return mssg;
    }

    public class ButtonSender implements ActionListener {
        public void actionPerformed(ActionEvent e)
        {
            if (e.getSource() == button)
            {
                try{
                    String s = txtField.getText();
                    mssg = s;
                    txtField.setText("");
                    txtField.setEditable(false);
                    button.setEnabled(false);
                    System.out.println(mssg);

                    out.println(mssg);
                    out.flush();

                    s = in.readLine();

                    ResultDialog dialog = new ResultDialog(Panel.this, "Результат", s);

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
    }

    public class ResultDialog extends Dialog implements ActionListener {
        JButton dButton;
        Label res;
        public ResultDialog(Frame parent, String title, String msg)
        {
            super(parent, title);
            setLayout(new FlowLayout(FlowLayout.CENTER));
            setSize(500, 250);
            setLocationRelativeTo(parent);

            dButton = new JButton("OK");
            add(dButton);
            dButton.addActionListener(this);

            res = new Label(msg);
            add(res);

            setVisible(true);
        }

        public void actionPerformed(ActionEvent e)
        {
            this.dispose();
        }

    }
}

