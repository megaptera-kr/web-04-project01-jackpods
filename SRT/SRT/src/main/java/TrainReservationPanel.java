import models.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class TrainReservationPanel extends JPanel {
    private JPanel dayPanel;
    private JPanel contentPanel;
    private JPanel informationPanel;
    private int estimatedMinute;
    private int estimatedHour;


    TrainReservationPanel(ControlCenter controlCenter, ArrayList<Train> trainList, User user, Reservation reservation, ArrayList<String> saveList,CompletePayment completePayment) {
        this.removeAll();
        setLayout(new GridLayout(6, 1));
        panelSets();

        displayDayAndNextDayButton(controlCenter);

        divideContentPanel();

        trainTimeInformation(controlCenter, trainList, user, reservation, saveList,completePayment);


        this.setVisible(true);
    }

    private void panelSets() {
        dayPanel = new JPanel();
        this.add(dayPanel, BorderLayout.PAGE_START);

        contentPanel = new JPanel();
        this.add(contentPanel);
    }

    private void displayDayAndNextDayButton(ControlCenter controlCenter) {
        JTextField dayTextField = new JTextField("03월 " + controlCenter.getReservationDay() + "일");
        dayTextField.setEditable(false);
        dayPanel.add(dayTextField);

        JButton nextDayButton = new JButton("다음날");
        dayPanel.add(nextDayButton);
    }

    private void divideContentPanel() {
        informationPanel = new JPanel();
        informationPanel.setBackground(Color.white);
        informationPanel.setLayout(new GridLayout(6, 5));
        contentPanel.add(informationPanel);
    }

    private void trainTimeInformation(ControlCenter controlCenter, ArrayList<Train> trainList, User user, Reservation reservation, ArrayList<String> saveList, CompletePayment completePayment) {
//        for (int i = 0; i < 6; i += 1) {//TODO: 풀어서 하기
        String trainCode = trainList.get(0).getTrainName();
        informationPanel.add(new JLabel(trainCode));

        String departureTime = trainList.get(0).getDepartureHour() + " : " + trainList.get(0).getDepartureMinute();
        informationPanel.add(new JLabel("수서  " + departureTime));

        int hour = (trainList.get(0).getDepartureHour() + controlCenter.getEstimatedHour());

        int minute = (Integer.valueOf(trainList.get(0).getDepartureMinute()) + controlCenter.getEstimatedMinute());

        String arriveTime = hour + " : " + minute;
        informationPanel.add(new JLabel(controlCenter.getRegionName() + "  " +
                arriveTime));

        JButton reservationButton = new JButton("예약가능");
        reservationButton.addActionListener(event -> {
            reservation.transfer(trainCode, departureTime, arriveTime);
//            if (minute > 60) {
//            reservation.transferInformation(estimatedMinute, estimatedHour);
//        }
//
//        if (minute < 60) {
//            reservation.transferInformation(hour, minute);
//        }

            if (controlCenter.getPassengerSum() <= 0) {
                JOptionPane.showMessageDialog(null, "탑승 인원을 선택해주세요");
            }
            if (controlCenter.getPassengerSum() > 0) {
                ReservationSeatPanel reservationSeatPanel = new ReservationSeatPanel(controlCenter, user, trainList, reservation, saveList,completePayment);
                this.removeAll();
                this.add(reservationSeatPanel);
                this.setVisible(false);
                this.setVisible(true);
            }
        });
        informationPanel.add(reservationButton);


        String trainCode1 = trainList.get(1).getTrainName();
        informationPanel.add(new JLabel(trainCode1));

        String departureTime1 = trainList.get(1).getDepartureHour() + " : " + trainList.get(1).getDepartureMinute();
        informationPanel.add(new JLabel("수서: " + departureTime1));

        int hour1 = trainList.get(1).getDepartureHour() + controlCenter.getEstimatedHour();

        int minute1 = Integer.valueOf(trainList.get(1).getDepartureMinute()) + controlCenter.getEstimatedMinute();

        String arriveTime1 = hour1 + " : " + minute1;
        informationPanel.add(new JLabel(controlCenter.getRegionName() + "  " +arriveTime1));

        JButton reservationButton1 = new JButton("예약가능");
        reservationButton1.addActionListener(event -> {
            reservation.transfer(trainCode1, departureTime1, arriveTime1);
//            if (minute > 60) {
//                reservation.transferInformation(estimatedMinute1, estimatedHour1);
//            }
//
//            if (minute < 60) {
//                reservation.transferInformation(hour1, minute1);
//            }

            if (controlCenter.getPassengerSum() <= 0) {
                JOptionPane.showMessageDialog(null, "탑승 인원을 선택해주세요");
            }
            if (controlCenter.getPassengerSum() > 0) {
                ReservationSeatPanel reservationSeatPanel = new ReservationSeatPanel(controlCenter, user, trainList, reservation, saveList,completePayment);
                this.removeAll();
                this.add(reservationSeatPanel);
                this.setVisible(false);
                this.setVisible(true);
            }
        });
        informationPanel.add(reservationButton1);


        String trainCode2 = trainList.get(2).getTrainName();
        informationPanel.add(new JLabel(trainCode2));

        String departureTime2 = trainList.get(2).getDepartureHour() + " : " + trainList.get(2).getDepartureMinute();
        informationPanel.add(new JLabel("수서: " + departureTime2));

        int hour2 = trainList.get(2).getDepartureHour() + controlCenter.getEstimatedHour();

        int minute2 = Integer.valueOf(trainList.get(2).getDepartureMinute()) + controlCenter.getEstimatedMinute();

        String arriveTime2 = hour2 + " : " + minute2;
        informationPanel.add(new JLabel(controlCenter.getRegionName() + "  " +arriveTime2));


        JButton reservationButton2 = new JButton("예약가능");
        reservationButton2.addActionListener(event -> {
            reservation.transfer(trainCode2, departureTime2, arriveTime2);
//        if (minute > 60) {
//            reservation.transferInformation(estimatedMinute, estimatedHour);
//        }
//
//        if (minute < 60) {
//            reservation.transferInformation(hour, minute);
//        }

            if (controlCenter.getPassengerSum() <= 0) {
                JOptionPane.showMessageDialog(null, "탑승 인원을 선택해주세요");
            }
            if (controlCenter.getPassengerSum() > 0) {
                ReservationSeatPanel reservationSeatPanel = new ReservationSeatPanel(controlCenter, user, trainList, reservation, saveList,completePayment);
                this.removeAll();
                this.add(reservationSeatPanel);
                this.setVisible(false);
                this.setVisible(true);
            }
        });
        informationPanel.add(reservationButton2);

        String trainCode3 = trainList.get(3).getTrainName();
        informationPanel.add(new JLabel(trainCode3));

        String departureTime3 = trainList.get(3).getDepartureHour() + " : " + trainList.get(3).getDepartureMinute();
        informationPanel.add(new JLabel("수서: " + departureTime3));

        int hour3 = trainList.get(3).getDepartureHour() + controlCenter.getEstimatedHour();

        int minute3 = Integer.valueOf(trainList.get(3).getDepartureMinute()) + controlCenter.getEstimatedMinute();

        String arriveTime3 = hour3 + " : " + minute3;
        informationPanel.add(new JLabel(controlCenter.getRegionName() + "  " +arriveTime3));

        JButton reservationButton3 = new JButton("예약가능");
        reservationButton3.addActionListener(event -> {
            reservation.transfer(trainCode3, departureTime3,arriveTime3);
//            if (minute > 60) {
//                reservation.transferInformation(estimatedMinute, estimatedHour);
//            }
//
//            if (minute < 60) {
//                reservation.transferInformation(hour, minute);
//            }

            if (controlCenter.getPassengerSum() <= 0) {
                JOptionPane.showMessageDialog(null, "탑승 인원을 선택해주세요");
            }
            if (controlCenter.getPassengerSum() > 0) {
                ReservationSeatPanel reservationSeatPanel = new ReservationSeatPanel(controlCenter, user, trainList, reservation, saveList,completePayment);
                this.removeAll();
                this.add(reservationSeatPanel);
                this.setVisible(false);
                this.setVisible(true);
            }
        });
        informationPanel.add(reservationButton3);

        String trainCode4 = trainList.get(4).getTrainName();
        informationPanel.add(new JLabel(trainCode4));

        String departureTime4 = trainList.get(4).getDepartureHour() + " : " + trainList.get(4).getDepartureMinute();
        informationPanel.add(new JLabel("수서: " + departureTime4));

        int hour4 = trainList.get(4).getDepartureHour() + controlCenter.getEstimatedHour();

        int minute4 = Integer.valueOf(trainList.get(4).getDepartureMinute()) + controlCenter.getEstimatedMinute();

        String arriveTime4 = hour4 + " : " + minute4;
        informationPanel.add(new JLabel(controlCenter.getRegionName() + "  " +arriveTime4));

        JButton reservationButton4 = new JButton("예약가능");
        reservationButton4.addActionListener(event -> {
            reservation.transfer(trainCode4, departureTime4,arriveTime4);
//            if (minute > 60) {
//                reservation.transferInformation(estimatedMinute, estimatedHour);
//            }
//
//            if (minute < 60) {
//                reservation.transferInformation(hour, minute);
//            }


            if (controlCenter.getPassengerSum() <= 0) {
                JOptionPane.showMessageDialog(null, "탑승 인원을 선택해주세요");
            }
            if (controlCenter.getPassengerSum() > 0) {
                ReservationSeatPanel reservationSeatPanel = new ReservationSeatPanel(controlCenter, user, trainList, reservation, saveList,completePayment);
                this.removeAll();
                this.add(reservationSeatPanel);
                this.setVisible(false);
                this.setVisible(true);
            }
        });
        informationPanel.add(reservationButton4);

        String trainCode5 = trainList.get(5).getTrainName();
        informationPanel.add(new JLabel(trainCode5));

        String departureTime5 = trainList.get(5).getDepartureHour() + " : " + trainList.get(5).getDepartureMinute();
        informationPanel.add(new JLabel("수서: " + departureTime5));

        int hour5 = trainList.get(5).getDepartureHour() + controlCenter.getEstimatedHour();

        int minute5 = Integer.valueOf(trainList.get(5).getDepartureMinute()) + controlCenter.getEstimatedMinute();

        String arriveTime5 = hour5 + " : " + minute5;
        informationPanel.add(new JLabel(controlCenter.getRegionName() + "  " +arriveTime5));

        JButton reservationButton5 = new JButton("예약가능");
        reservationButton5.addActionListener(event -> {
            reservation.transfer(trainCode5, departureTime5,arriveTime5);
//            if (minute > 60) {
//                reservation.transferInformation(estimatedMinute, estimatedHour);
//            }
//
//            if (minute < 60) {
//                reservation.transferInformation(hour, minute);
//            }

            if (controlCenter.getPassengerSum() <= 0) {
                JOptionPane.showMessageDialog(null, "탑승 인원을 선택해주세요");
            }
            if (controlCenter.getPassengerSum() > 0) {
                ReservationSeatPanel reservationSeatPanel = new ReservationSeatPanel(controlCenter, user, trainList, reservation, saveList,completePayment);
                this.removeAll();
                this.add(reservationSeatPanel);
                this.setVisible(false);
                this.setVisible(true);
            }
        });
        informationPanel.add(reservationButton5);
    }
}


