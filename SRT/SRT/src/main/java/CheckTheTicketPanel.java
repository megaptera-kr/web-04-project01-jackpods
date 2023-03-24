import models.*;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CheckTheTicketPanel extends JPanel {
    private JPanel titlePanel;
    private JPanel areaInformationPanel;
    private JPanel trainInformationPanel;
    private JPanel paymentPanel;
    private JTextField dayTextField;
    private JLabel srtNameLabel;
    private JLabel seatNumberLabel;
    private List<CompletePayment> saveList = new ArrayList<>();
    private JButton priceButton;

    CheckTheTicketPanel(ArrayList<Region> regionList, ControlCenter controlCenter, Reservation reservation, ArrayList<String> saveList, CompletePayment completePayment,TemporaryStorage temporaryStorage) throws IOException, ClassNotFoundException {
        loadReservation();

        setLayout(new GridLayout(4, 1));

        panelSets();

        titleLabel();

        areaInformation(controlCenter, reservation, completePayment);

        trainInformation(reservation, controlCenter, completePayment);

        payment(controlCenter, completePayment);

        editReservation(regionList,controlCenter, reservation ,completePayment,temporaryStorage);

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try {
                saveReservation();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }));
    }

    private void panelSets() {
        titlePanel = new JPanel();
        titlePanel.setLayout(new GridLayout(1, 2));
        this.add(titlePanel);

        areaInformationPanel = new JPanel();
        areaInformationPanel.setLayout(new GridLayout(2, 3));
        this.add(areaInformationPanel);

        trainInformationPanel = new JPanel();
        trainInformationPanel.setLayout(new GridLayout(2, 2));
        this.add(trainInformationPanel);

        paymentPanel = new JPanel();
        paymentPanel.setLayout(new GridLayout(2, 2));
        this.add(paymentPanel);
    }

    private void titleLabel() {
        JTextField titleTextField = new JTextField("예약내역");
        titleTextField.setEditable(false);
        titlePanel.add(titleTextField);
    }

    private void areaInformation(ControlCenter controlCenter, Reservation reservation, CompletePayment completePayment) {
        JTextField departureTextField = new JTextField("수서");
        departureTextField.setEditable(false);
        areaInformationPanel.add(departureTextField);

        areaInformationPanel.add(new JLabel());

        JTextField arriveTextField = new JTextField(completePayment.getRegionName());
        arriveTextField.setEditable(false);
        areaInformationPanel.add(arriveTextField);

        JTextField departureTimeTextField = new JTextField(completePayment.getDepartureTime());
        departureTimeTextField.setEditable(false);
        areaInformationPanel.add(departureTimeTextField);

        areaInformationPanel.add(new JLabel());

        JTextField arriveTimeTextField = new JTextField(completePayment.getArriveTime());
        arriveTimeTextField.setEditable(false);
        areaInformationPanel.add(arriveTimeTextField);
        this.setVisible(false);
        this.setVisible(true);
    }

    private void trainInformation(Reservation reservation, ControlCenter controlCenter, CompletePayment completePayment) {
        dayTextField = new JTextField("2023년 3월 " + completePayment.getDepartureDay() + "일");
        dayTextField.setEditable(false);
        trainInformationPanel.add(dayTextField);
        srtNameLabel = new JLabel("기차번호: " + completePayment.getTrainNumber());
        trainInformationPanel.add(srtNameLabel);
        for (String seatNumber : completePayment.getSeatNumber()) {
            seatNumberLabel = new JLabel(seatNumber);
            trainInformationPanel.add(seatNumberLabel);
        }

    }

    private void payment(ControlCenter controlCenter, CompletePayment completePayment) {
        paymentPanel.add(new JLabel("총 결제금액: "));
        priceButton = new JButton(String.valueOf(completePayment.getPriceSum()));
        priceButton.setEnabled(false);
        paymentPanel.add(priceButton);
    }

    private void editReservation(ArrayList<Region> regionList, ControlCenter controlCenter, Reservation reservation , CompletePayment completePayment, TemporaryStorage temporaryStorage) {
        JButton editButton = new JButton("일정 변경하기");
        editButton.addActionListener(event -> {
//            if (!priceButton.getText().equals("0")) {TODO: 조건변경하기
                EditPanel editPanel = new EditPanel(regionList,controlCenter,reservation,completePayment,temporaryStorage);
                updatePanel(editPanel);
//            }

        });
        paymentPanel.add(editButton);
    }

    public void loadReservation() throws IOException, ClassNotFoundException {
        File file = new File("seatsInformation.csv");
        if (file.exists()) {
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            saveList = (ArrayList<CompletePayment>) objectInputStream.readObject();
            objectInputStream.close();
            fileInputStream.close();
        }
    }

    public void saveReservation() throws IOException {

        FileOutputStream fileOutputStream = new FileOutputStream("reservation.csv");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(saveList);
        objectOutputStream.close();
        fileOutputStream.close();

    }

    private void updatePanel(JPanel panel) {
        this.removeAll();
        this.add(panel);
        this.setVisible(false);
        this.setVisible(true);
    }

}
