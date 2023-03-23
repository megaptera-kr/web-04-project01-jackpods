import models.ControlCenter;
import models.Reservation;
import models.Train;
import models.User;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class TrainReservationPanel extends JPanel {
    private JPanel dayPanel;
    private JPanel contentPanel;
    private JPanel informationPanel;
    private int estimatedMinute;
    private int estimatedHour;


    TrainReservationPanel(ControlCenter controlCenter, ArrayList<Train> trainList, User user, Reservation reservation, ArrayList<String> saveList) {
        this.removeAll();
        setLayout(new GridLayout(6, 1));
        panelSets();

        displayDayAndNextDayButton(controlCenter);

        divideContentPanel();

        trainTimeInformation(controlCenter, trainList, user, reservation, saveList);


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

    private void trainTimeInformation(ControlCenter controlCenter, ArrayList<Train> trainList, User user, Reservation reservation, ArrayList<String> saveList) {
//        for (int i = 0; i < 6; i += 1) {//TODO: 풀어서 하기
        String trainCode = trainList.get(0).getTrainName();
        informationPanel.add(new JLabel(trainCode));

        String departureTime = trainList.get(0).getDepartureHour() + " : " + trainList.get(0).getDepartureMinute();
        informationPanel.add(new JLabel("수서  " + departureTime));

        int hour = (trainList.get(0).getDepartureHour() + controlCenter.getEstimatedHour());

        int minute = (Integer.valueOf(trainList.get(0).getDepartureMinute()) + controlCenter.getEstimatedMinute());

        if (minute > 60) {
            estimatedMinute = minute - 60;
            estimatedHour = hour + 1;
            informationPanel.add(new JLabel(controlCenter.getRegionName()+"  " +
                    estimatedHour + " : " + estimatedMinute));
        }

        if (minute < 60) {

            informationPanel.add(new JLabel(controlCenter.getRegionName()+"  "  +
                    hour + " : " + minute));
        }
        JButton reservationButton = new JButton("예약가능");
        reservationButton.addActionListener(event -> {
            reservation.transfer(trainCode);
            
//            if (minute > 60) {
//            reservation.transferInformation(estimatedMinute, estimatedHour);
//        }
//
//        if (minute < 60) {
//            reservation.transferInformation(hour, minute);
//        }

            if (controlCenter.getSum() <= 0) {
                JOptionPane.showMessageDialog(null, "탑승 인원을 선택해주세요");
            }
            if (controlCenter.getSum() > 0) {
                ReservationSeatPanel reservationSeatPanel = new ReservationSeatPanel(controlCenter, user, trainList, reservation, saveList);
                this.removeAll();
                this.add(reservationSeatPanel);
                this.setVisible(false);
                this.setVisible(true);
            }
        });
        informationPanel.add(reservationButton);


        String trainCode1 = trainList.get(1).getTrainName();
        informationPanel.add(new JLabel(trainCode1));

        informationPanel.add(new JLabel("수서: " + trainList.get(1).getDepartureHour() + " : " + trainList.get(1).getDepartureMinute()));

        int hour1 = trainList.get(1).getDepartureHour() + controlCenter.getEstimatedHour();

        int minute1 = Integer.valueOf(trainList.get(1).getDepartureMinute()) + controlCenter.getEstimatedMinute();

        if (minute1 > 60) {
            int estimatedMinute1 = minute1 - 60;
            int estimatedHour1 = hour1 + 1;
            informationPanel.add(new JLabel(controlCenter.getRegionName()+"  " +
                    estimatedHour1 + " : " + estimatedMinute1));
        }

        if (minute1 < 60) {

            informationPanel.add(new JLabel(controlCenter.getRegionName()+"  "  +
                    hour1 + " : " + minute1));
        }
        JButton reservationButton1 = new JButton("예약가능");
        reservationButton1.addActionListener(event -> {
            reservation.transfer(trainCode1);
//            if (minute > 60) {
//                reservation.transferInformation(estimatedMinute1, estimatedHour1);
//            }
//
//            if (minute < 60) {
//                reservation.transferInformation(hour1, minute1);
//            }

            if (controlCenter.getSum() <= 0) {
                JOptionPane.showMessageDialog(null, "탑승 인원을 선택해주세요");
            }
            if (controlCenter.getSum() > 0) {
                ReservationSeatPanel reservationSeatPanel = new ReservationSeatPanel(controlCenter, user, trainList, reservation, saveList);
                this.removeAll();
                this.add(reservationSeatPanel);
                this.setVisible(false);
                this.setVisible(true);
            }
        });
        informationPanel.add(reservationButton1);


        String trainCode2 = trainList.get(2).getTrainName();
        informationPanel.add(new JLabel(trainCode2));

        informationPanel.add(new JLabel("수서: " + trainList.get(2).getDepartureHour() + " : " + trainList.get(2).getDepartureMinute()));

        int hour2 = trainList.get(2).getDepartureHour() + controlCenter.getEstimatedHour();

        int minute2 = Integer.valueOf(trainList.get(2).getDepartureMinute()) + controlCenter.getEstimatedMinute();

        if (minute2 > 60) {
            int estimatedMinute2 = minute2 - 60;
            int estimatedHour2 = hour2 + 1;
            informationPanel.add(new JLabel(controlCenter.getRegionName()+"  " +
                    estimatedHour2 + " : " + estimatedMinute2));
        }

        if (minute2 < 60) {

            informationPanel.add(new JLabel(controlCenter.getRegionName()+"  "  +
                    hour2 + " : " + minute2));
        }
        JButton reservationButton2 = new JButton("예약가능");
        reservationButton2.addActionListener(event -> {
            reservation.transfer(trainCode2);
//        if (minute > 60) {
//            reservation.transferInformation(estimatedMinute, estimatedHour);
//        }
//
//        if (minute < 60) {
//            reservation.transferInformation(hour, minute);
//        }

            if (controlCenter.getSum() <= 0) {
                JOptionPane.showMessageDialog(null, "탑승 인원을 선택해주세요");
            }
            if (controlCenter.getSum() > 0) {
                ReservationSeatPanel reservationSeatPanel = new ReservationSeatPanel(controlCenter, user, trainList, reservation, saveList);
                this.removeAll();
                this.add(reservationSeatPanel);
                this.setVisible(false);
                this.setVisible(true);
            }
        });
        informationPanel.add(reservationButton2);

        String trainCode3 = trainList.get(3).getTrainName();
        informationPanel.add(new JLabel(trainCode3));

        informationPanel.add(new JLabel("수서: " + trainList.get(3).getDepartureHour() + " : " + trainList.get(3).getDepartureMinute()));

        int hour3 = trainList.get(3).getDepartureHour() + controlCenter.getEstimatedHour();

        int minute3 = Integer.valueOf(trainList.get(3).getDepartureMinute()) + controlCenter.getEstimatedMinute();

        if (minute3 > 60) {
            int estimatedMinute3 = minute3 - 60;
            int estimatedHour3 = hour3 + 1;
            informationPanel.add(new JLabel(controlCenter.getRegionName()+"  " +
                    estimatedHour3 + " : " + estimatedMinute3));
        }

        if (minute3 < 60) {

            informationPanel.add(new JLabel(controlCenter.getRegionName()+"  "  +
                    hour3 + " : " + minute3));
        }
        JButton reservationButton3 = new JButton("예약가능");
        reservationButton3.addActionListener(event -> {
            reservation.transfer(trainCode3);
//            if (minute > 60) {
//                reservation.transferInformation(estimatedMinute, estimatedHour);
//            }
//
//            if (minute < 60) {
//                reservation.transferInformation(hour, minute);
//            }

            if (controlCenter.getSum() <= 0) {
                JOptionPane.showMessageDialog(null, "탑승 인원을 선택해주세요");
            }
            if (controlCenter.getSum() > 0) {
                ReservationSeatPanel reservationSeatPanel = new ReservationSeatPanel(controlCenter, user, trainList, reservation, saveList);
                this.removeAll();
                this.add(reservationSeatPanel);
                this.setVisible(false);
                this.setVisible(true);
            }
        });
        informationPanel.add(reservationButton3);

        String trainCode4 = trainList.get(4).getTrainName();
        informationPanel.add(new JLabel(trainCode4));

        informationPanel.add(new JLabel("수서: " + trainList.get(4).getDepartureHour() + " : " + trainList.get(4).getDepartureMinute()));

        int hour4 = trainList.get(4).getDepartureHour() + controlCenter.getEstimatedHour();

        int minute4 = Integer.valueOf(trainList.get(4).getDepartureMinute()) + controlCenter.getEstimatedMinute();

        if (minute4 > 60) {
            int estimatedMinute4 = minute4 - 60;
            int estimatedHour4 = hour4 + 1;
            informationPanel.add(new JLabel(controlCenter.getRegionName()+"  " +
                    estimatedHour4 + " : " + estimatedMinute4));
        }

        if (minute < 60) {

            informationPanel.add(new JLabel(controlCenter.getRegionName()+"  "  +
                    hour4 + " : " + minute4));
        }
        JButton reservationButton4 = new JButton("예약가능");
        reservationButton4.addActionListener(event -> {
            reservation.transfer(trainCode4);
//            if (minute > 60) {
//                reservation.transferInformation(estimatedMinute, estimatedHour);
//            }
//
//            if (minute < 60) {
//                reservation.transferInformation(hour, minute);
//            }


            if (controlCenter.getSum() <= 0) {
                JOptionPane.showMessageDialog(null, "탑승 인원을 선택해주세요");
            }
            if (controlCenter.getSum() > 0) {
                ReservationSeatPanel reservationSeatPanel = new ReservationSeatPanel(controlCenter, user, trainList, reservation, saveList);
                this.removeAll();
                this.add(reservationSeatPanel);
                this.setVisible(false);
                this.setVisible(true);
            }
        });
        informationPanel.add(reservationButton4);

        String trainCode5 = trainList.get(5).getTrainName();
        informationPanel.add(new JLabel(trainCode5));



        informationPanel.add(new JLabel("수서: " + trainList.get(5).getDepartureHour() + " : " + trainList.get(5).getDepartureMinute()));

        int hour5 = trainList.get(5).getDepartureHour() + controlCenter.getEstimatedHour();

        int minute5 = Integer.valueOf(trainList.get(5).getDepartureMinute()) + controlCenter.getEstimatedMinute();

        if (minute5 > 60) {
            int estimatedMinute5 = minute5 - 60;
            int estimatedHour5 = hour5 + 1;
            informationPanel.add(new JLabel(controlCenter.getRegionName()+"  " +
                    estimatedHour5 + " : " + estimatedMinute5));
        }

        if (minute5 < 60) {

            informationPanel.add(new JLabel(controlCenter.getRegionName()+"  "  +
                    hour5 + " : " + minute5));
        }
        JButton reservationButton5 = new JButton("예약가능");
        reservationButton5.addActionListener(event -> {
            reservation.transfer(trainCode5);
//            if (minute > 60) {
//                reservation.transferInformation(estimatedMinute, estimatedHour);
//            }
//
//            if (minute < 60) {
//                reservation.transferInformation(hour, minute);
//            }

            if (controlCenter.getSum() <= 0) {
                JOptionPane.showMessageDialog(null, "탑승 인원을 선택해주세요");
            }
            if (controlCenter.getSum() > 0) {
                ReservationSeatPanel reservationSeatPanel = new ReservationSeatPanel(controlCenter, user, trainList, reservation, saveList);
                this.removeAll();
                this.add(reservationSeatPanel);
                this.setVisible(false);
                this.setVisible(true);
            }
        });
        informationPanel.add(reservationButton5);
    }
}


