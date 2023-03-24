import models.*;

import javax.swing.*;
import java.awt.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class ReservationSeatPanel extends JPanel {
    private JPanel seatPanel;
    private JPanel paymentButtonPanel;
    private JPanel checkedListPanel;
    private ArrayList<String> checkedList = new ArrayList<>();

    ReservationSeatPanel(ControlCenter controlCenter, User user,ArrayList<Train> trainList,Reservation reservation,ArrayList<String> saveList,CompletePayment completePayment) {

        setLayout(new GridLayout(3, 1));

        panelSet(controlCenter);

        createSeatButton(controlCenter, user);

        checkedList(controlCenter,user);

        payment(controlCenter,reservation,saveList,completePayment);

//        Runtime.getRuntime().addShutdownHook(new Thread(this::saveCheckedSeats));
    }

    private void panelSet(ControlCenter controlCenter) {
        seatPanel = new JPanel();
        seatPanel.setLayout(new GridLayout(6, 4));
        this.add(seatPanel);

        checkedListPanel = new JPanel();
        checkedListPanel.setLayout(new GridLayout(checkedList.size(),2));
        this.add(checkedListPanel);

        paymentButtonPanel = new JPanel();
        paymentButtonPanel.setLayout(new GridLayout(checkedList.size(),1));
        this.add(paymentButtonPanel);

    }

    private void createSeatButton(ControlCenter controlCenter, User user) {
        seatPanel.add(new JLabel("^"));
        seatPanel.add(new JLabel("^"));
        seatPanel.add(new JLabel("^"));
        seatPanel.add(new JLabel("^"));
        seatPanel.add(new JLabel("^"));

        for (int i = 1; i < 6; i += 1) {

            int number = i;

            JButton aButton = new JButton(i + "A");
            aButton.addActionListener(event -> {
                if (user.getSumNumber() > 0) {

                    user.transfer(number + "A");

                    aButton.setEnabled(false);

                    user.minusSum();

                    checkedList.add(number + "A");

                }
                if (user.getSumNumber() <= 0) {
                    JOptionPane.showMessageDialog(null, "좌석을 모두 선택하셨습니다.");
                }

            });
            seatPanel.add(aButton);

            JButton bButton = new JButton(i + "B");
            bButton.addActionListener(event -> {
                if (user.getSumNumber() > 0) {

                    user.transfer(number + "B");

                    bButton.setEnabled(false);

                    user.minusSum();

                    checkedList.add(number + "B");


                }
                if (user.getSumNumber() <= 0) {
                    JOptionPane.showMessageDialog(null, "좌석을 모두 선택하셨습니다.");
                }
            });
            seatPanel.add(bButton);

            seatPanel.add(new JLabel());

            JButton cButton = new JButton(i + "C");
            cButton.addActionListener(event -> {

                if (user.getSumNumber() > 0) {

                    user.transfer(number + "C");

                    cButton.setEnabled(false);

                    user.minusSum();

                    checkedList.add(number + "C");

                }
                if (user.getSumNumber() <= 0) {
                    JOptionPane.showMessageDialog(null, "좌석을 모두 선택하셨습니다.");
                }
            });
            seatPanel.add(cButton);

            JButton dButton = new JButton(i + "D");
            dButton.addActionListener(event -> {
                if (user.getSumNumber() > 0) {

                    user.transfer(number + "D");

                    dButton.setEnabled(false);

                    user.minusSum();

                    checkedList.add(number + "D");

                }
                if (user.getSumNumber() <= 0) {
                    JOptionPane.showMessageDialog(null, "좌석을 모두 선택하셨습니다.");
                }
            });
            seatPanel.add(dButton);
        }
    }

    private void checkedList(ControlCenter controlCenter,User user) {
        for (int i = 0; i < controlCenter.getPassengerSum(); i += 1) {
            JButton deleteButton = new JButton("X");
            checkedListPanel.add(deleteButton);

//            checkedListPanel.add(new JTextField(checkedList.get(i)));
        }
    }

    private void payment(ControlCenter controlCenter, Reservation reservation, ArrayList<String> saveList, CompletePayment completePayment) {
        JButton paymentButton = new JButton("결제하기");
        paymentButton.addActionListener(event->{
            PaymentPanel paymentPanel = new PaymentPanel(controlCenter,reservation,saveList,checkedList,completePayment);
            this.removeAll();
            this.add(paymentPanel);
            this.setVisible(false);
            this.setVisible(true);
        });
        paymentButtonPanel.add(paymentButton);
    }

    private void saveCheckedSeats() throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("seatsInformation.csv");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(checkedList);
        objectOutputStream.close();
        fileOutputStream.close();
    }



}

