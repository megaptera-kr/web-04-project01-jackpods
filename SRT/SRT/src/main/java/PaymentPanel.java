import models.ControlCenter;
import models.Reservation;
import models.Train;

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

    PaymentPanel(ControlCenter controlCenter, Reservation reservation,ArrayList<String> saveList) {
        setLayout(new GridLayout(4,1));

        panelSets();

        titleLabel();

        areaInformation(controlCenter,reservation);

        trainInformation(controlCenter);

        payment(controlCenter);

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try {
                saveCheckedSeats(saveList);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }));
    }

    private void panelSets() {
        titlePanel = new JPanel();
        titlePanel.setLayout(new GridLayout(1,2));
        this.add(titlePanel);

        areaInformationPanel = new JPanel();
        areaInformationPanel.setLayout(new GridLayout(2,3));
        this.add(areaInformationPanel);

        trainInformationPanel = new JPanel();
        trainInformationPanel.setLayout(new GridLayout(2,2));
        this.add(trainInformationPanel);

        paymentPanel = new JPanel();
        paymentPanel.setLayout(new GridLayout(2,2));
        this.add(paymentPanel);
    }

    private void titleLabel() {
        JTextField titleTextField = new JTextField("예약내역");
        titleTextField.setEditable(false);
        titlePanel.add(titleTextField);
    }

    private void areaInformation(ControlCenter controlCenter, Reservation reservation) {
        JTextField departureTextField = new JTextField("수서");
        departureTextField.setEditable(false);
        areaInformationPanel.add(departureTextField);

        areaInformationPanel.add(new JLabel());

        JTextField arriveTextField = new JTextField(controlCenter.getRegionName());
        arriveTextField.setEditable(false);
        areaInformationPanel.add(arriveTextField);

        JTextField departureTimeTextField = new JTextField();
        departureTimeTextField.setEditable(false);
        areaInformationPanel.add(departureTimeTextField);

        areaInformationPanel.add(new JLabel());

        JTextField arriveTimeTextField = new JTextField(reservation.getArriveHour()+" : "+reservation.getArriveMinute());
        arriveTimeTextField.setEditable(false);
        areaInformationPanel.add(arriveTimeTextField);
    }

    private void trainInformation(ControlCenter controlCenter) {
        dayTextField = new JTextField("2023년 3월 "+controlCenter.getReservationDay()+"일");//TODO- srtday
        dayTextField.setEditable(false);
        trainInformationPanel.add(dayTextField);
        srtNameLabel = new JLabel("srt이름");
        trainInformationPanel.add(srtNameLabel);//TODO- srtname
        seatNumberLabel = new JLabel("seatNumber");
        trainInformationPanel.add(seatNumberLabel);//TODO- seatNumber
    }

    private void payment(ControlCenter controlCenter) {
        paymentPanel.add(new JLabel("총 결제금액: "));
//        paymentPanel.add(new JLabel(controlCenter.getPriceSum()));
        JButton priceButton = new JButton(String.valueOf(controlCenter.getPriceSum()));
        priceButton.setEnabled(false);
        paymentPanel.add(priceButton);

        JButton paymentButton = new JButton("결제하기");
        paymentButton.addActionListener(event->{

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

