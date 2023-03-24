import models.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class EditPanel extends JPanel {
    private JPanel titlePanel;
    private JPanel areaInformationPanel;
    private JPanel trainInformationPanel;
    private JPanel paymentPanel;
    private JTextField dayTextField;
    private JLabel srtNameLabel;
    private JLabel seatNumberLabel;

    EditPanel(ArrayList<Region> regionList, ControlCenter controlCenter, Reservation reservation, CompletePayment completePayment, TemporaryStorage temporaryStorage) {
        setLayout(new GridLayout(4, 1));

        panelSets(controlCenter);

        titleLabel();

        areaInformation(regionList, controlCenter, reservation, completePayment, temporaryStorage);

        trainInformation(controlCenter, reservation, completePayment);

        payment(controlCenter, completePayment, reservation, temporaryStorage);

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

    private void areaInformation(ArrayList<Region> regionList, ControlCenter controlCenter, Reservation reservation, CompletePayment completePayment, TemporaryStorage temporaryStorage) {
        JTextField departureTextField = new JTextField("수서");
        departureTextField.setEditable(false);
        areaInformationPanel.add(departureTextField);

        areaInformationPanel.add(new JLabel());

        JButton arriveButton = new JButton(controlCenter.getRegionName());
        arriveButton.addActionListener(event -> {
            RegionEditPanel regionEditPanel = new RegionEditPanel(regionList, controlCenter, temporaryStorage);
            this.removeAll();
            this.add(regionEditPanel);
            this.setVisible(false);
            this.setVisible(true);
        });
        areaInformationPanel.add(arriveButton);

        JTextField departureTimeTextField = new JTextField(completePayment.getDepartureTime());
        departureTimeTextField.setEditable(false);
        areaInformationPanel.add(departureTimeTextField);

        areaInformationPanel.add(new JLabel());

        JTextField arriveTimeTextField = new JTextField(completePayment.getArriveTime());
        arriveTimeTextField.setEditable(false);
        areaInformationPanel.add(arriveTimeTextField);
    }

    public void trainInformation(ControlCenter controlCenter, Reservation reservation, CompletePayment completePayment) {
        dayTextField = new JTextField("2023년 3월 " + completePayment.getDepartureDay() + " 일");
        trainInformationPanel.add(dayTextField);
        srtNameLabel = new JLabel("기차번호: " + completePayment.getTrainNumber());
        trainInformationPanel.add(srtNameLabel);
        for (String seatNumber : completePayment.getSeatNumber()) {
            seatNumberLabel = new JLabel(seatNumber);
            trainInformationPanel.add(seatNumberLabel);
        }


    }

    private void payment(ControlCenter controlCenter, CompletePayment completePayment, Reservation reservation, TemporaryStorage temporaryStorage) {
        paymentPanel.add(new JLabel("총 결제금액: "));
//        paymentPanel.add(new JLabel(controlCenter.getPriceSum()));
        JButton priceButton = new JButton(String.valueOf(controlCenter.getPriceSum()));
        priceButton.setEnabled(false);
        paymentPanel.add(priceButton);

        JButton editButton = new JButton("수정완료");
        editButton.addActionListener(event -> {
            dayTextField.setEditable(false);
            String[] array = dayTextField.getText().split(" ");
//            System.out.println(array[2]);
//            completePayment.transferEdit(array[2]);
//            completePayment.transfer(temporaryStorage.getEditRegionName());

            this.setVisible(false);
            this.setVisible(true);
        });
        paymentPanel.add(editButton);
    }
}