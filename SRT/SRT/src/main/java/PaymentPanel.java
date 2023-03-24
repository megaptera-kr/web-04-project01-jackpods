import models.CompletePayment;
import models.ControlCenter;
import models.Reservation;

import javax.swing.*;
import java.awt.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class PaymentPanel extends JPanel {
    private JPanel titlePanel;
    private JPanel areaInformationPanel;
    private JPanel trainInformationPanel;
    private JPanel paymentPanel;
    private JTextField dayTextField;
    private JLabel srtNameLabel;
    private JLabel seatNumberLabel;
    private ArrayList<String> checkedList;

    PaymentPanel(ControlCenter controlCenter, Reservation reservation, ArrayList<String> saveList, ArrayList<String> checkedList, CompletePayment completePayment) {
        this.checkedList = checkedList;
        setLayout(new GridLayout(4, 1));

        panelSets(controlCenter);

        titleLabel();

        areaInformation(controlCenter, reservation);

        trainInformation(controlCenter, reservation);

        payment(controlCenter, completePayment, reservation);

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try {
                saveCheckedSeats(saveList);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }));
    }

    private void panelSets(ControlCenter controlCenter) {
        titlePanel = new JPanel();
        titlePanel.setLayout(new GridLayout(1, 2));
        this.add(titlePanel);

        areaInformationPanel = new JPanel();
        areaInformationPanel.setLayout(new GridLayout(3, 3));
        this.add(areaInformationPanel);

        trainInformationPanel = new JPanel();
        trainInformationPanel.setLayout(new GridLayout(2 + controlCenter.getPassengerSum(), 2));
        this.add(trainInformationPanel);

        paymentPanel = new JPanel();
        paymentPanel.setLayout(new GridLayout(2, 2));
        this.add(paymentPanel);
    }

    private void titleLabel() {
        JLabel titleLabel = new JLabel("예약내역");
        areaInformationPanel.add(titleLabel, BorderLayout.PAGE_START);
        areaInformationPanel.add(new JLabel());
        areaInformationPanel.add(new JLabel());
    }

    private void areaInformation(ControlCenter controlCenter, Reservation reservation) {
        JTextField departureTextField = new JTextField("수서");
        departureTextField.setEditable(false);
        areaInformationPanel.add(departureTextField);

        areaInformationPanel.add(new JLabel());

        JTextField arriveTextField = new JTextField(controlCenter.getRegionName());
        arriveTextField.setEditable(false);
        areaInformationPanel.add(arriveTextField);

        JTextField departureTimeTextField = new JTextField(reservation.getDepartureTime());
        departureTimeTextField.setEditable(false);
        areaInformationPanel.add(departureTimeTextField);

        areaInformationPanel.add(new JLabel());

        JTextField arriveTimeTextField = new JTextField(reservation.getArriveTimes());
        arriveTimeTextField.setEditable(false);
        areaInformationPanel.add(arriveTimeTextField);
    }

    private void trainInformation(ControlCenter controlCenter, Reservation reservation) {
        dayTextField = new JTextField("2023년 3월 " + controlCenter.getReservationDay() + "일");
        dayTextField.setEditable(false);
        trainInformationPanel.add(dayTextField);
        srtNameLabel = new JLabel("기차번호: " + reservation.getTrainName());
        trainInformationPanel.add(srtNameLabel);
        for (int i = 0; i < controlCenter.getPassengerSum(); i += 1) {
            seatNumberLabel = new JLabel("좌석: " + checkedList.get(i));
            trainInformationPanel.add(seatNumberLabel);//TODO- seatNumber
        }


    }

    private void payment(ControlCenter controlCenter, CompletePayment completePayment, Reservation reservation) {
        paymentPanel.add(new JLabel("총 결제금액: "));
//        paymentPanel.add(new JLabel(controlCenter.getPriceSum()));
        JButton priceButton = new JButton(String.valueOf(controlCenter.getPriceSum()));
        priceButton.setEnabled(false);
        paymentPanel.add(priceButton);

        JButton paymentButton = new JButton("결제하기");
        paymentButton.addActionListener(event -> {
            JOptionPane.showMessageDialog(null, "결제완료!!");
            completePayment.transfer(controlCenter.getRegionName(), reservation.getDepartureTime(), reservation.getArriveTimes(),
                    controlCenter.getReservationDay(), reservation.getTrainName(), controlCenter.getPriceSum());
        });
        paymentPanel.add(paymentButton);


    }

    private void saveCheckedSeats(ArrayList<String> saveList) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("seatsInformation.csv");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(saveList);
        objectOutputStream.close();
        fileOutputStream.close();
    }
}

