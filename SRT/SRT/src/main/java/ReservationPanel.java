
import models.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class ReservationPanel extends JPanel {
    private JPanel appNamePanel;
    private JPanel timesPanel;
    private JPanel pointPanel;
    private JPanel dayPanel;
    private JPanel numberOfPeoplePanel;
    private JPanel trainSearchPanel;
    private String[] day = {"날짜를 선택해주세요","20", "21", "22", "23", "24", "25"};
    private JLabel adultCountLabel;
    private JLabel childrenCountLabel;
    private JLabel childCountLabel;
    private JLabel oldManCountLabel;
    private int index;

    public ReservationPanel(ArrayList<Region> regionList, ControlCenter controlCenter, ArrayList<Train> trainList, User user, Reservation reservation,ArrayList<String> saveList) {

        setLayout(new GridLayout(6, 1));

        panelSets();

        titleLabel();

        oneWay();

        choiceRegion(regionList, controlCenter);

        choiceDepartureDay(controlCenter);

        numberOfPeople(controlCenter);

        trainSearch(controlCenter, trainList, user, reservation,saveList);
    }

    private void panelSets() {

        createAppNamePanel();

        createTimesPanel();

        createPointPanel();

        createDayPanel();

        createNumberOfPeoplePanel();

        createTrainSearchPanel();

    }

    private void titleLabel() {
        JLabel titleLabel = new JLabel("SRT");
        appNamePanel.add(titleLabel);
    }

    private void oneWay() {
        JButton oneWayButton = new JButton("편도");
        oneWayButton.addActionListener(event -> {
            this.setVisible(false);
            this.setVisible(true);
        });
        timesPanel.add(oneWayButton);

    }

    private void choiceRegion(ArrayList<Region> regionList, ControlCenter controlCenter) {
        departureAreaActionButton(regionList);

        pointPanel.add(new JLabel());//칸맞추기

        arrivalAreaActionButton(regionList, controlCenter);

        departureText();

        pointPanel.add(new JLabel());//칸맞추기

        arriveText(controlCenter);

    }

    private void choiceDepartureDay(ControlCenter controlCenter) {
        JButton departureDayButton = new JButton("출발일자");
        departureDayButton.addActionListener(event -> {
        });
        dayPanel.add(departureDayButton);

        JComboBox departureDay = new JComboBox(day);
        departureDay.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JComboBox<String> jcb = (JComboBox) e.getSource();
                index = jcb.getSelectedIndex();
                controlCenter.add(day[index]);

            }
        });
        dayPanel.add(departureDay);
    }

    private void numberOfPeople(ControlCenter controlCenter) {
        adultNumber(controlCenter);
        childrenNumber(controlCenter);
        childNumber(controlCenter);
        oldManNumber(controlCenter);
    }

    private void createAppNamePanel() {
        appNamePanel = new JPanel();
        appNamePanel.setBackground(Color.white);
        appNamePanel.setPreferredSize(new Dimension(200, 50));
        this.add(appNamePanel);
    }

    private void createTimesPanel() {
        timesPanel = new JPanel();
        this.add(timesPanel);
    }

    private void createPointPanel() {
        pointPanel = new JPanel();
        pointPanel.setBackground(Color.white);
        pointPanel.setLayout(new GridLayout(2, 3));
        this.add(pointPanel);
    }

    private void createDayPanel() {
        dayPanel = new JPanel();
        dayPanel.setLayout(new GridLayout(2, 1));
        this.add(dayPanel);
    }

    private void createNumberOfPeoplePanel() {
        numberOfPeoplePanel = new JPanel();
        numberOfPeoplePanel.setBackground(Color.white);
        numberOfPeoplePanel.setLayout(new GridLayout(4, 4));
        this.add(numberOfPeoplePanel);
    }

    private void createTrainSearchPanel() {
        trainSearchPanel = new JPanel();
        this.add(trainSearchPanel);
    }

    private void trainSearch(ControlCenter controlCenter, ArrayList<Train> trainList, User user, Reservation reservation,ArrayList<String> saveList) {
        JButton trainSearchButton = new JButton("열차 조회하기");
        trainSearchButton.addActionListener(event -> {
            if (index == 0) {
                JOptionPane.showMessageDialog(null, "날짜를 선택해주세요!");

            }
            if (index!=0) {
                TrainReservationPanel trainReservationPanel = new TrainReservationPanel(controlCenter, trainList, user, reservation,saveList);
                int sumOfPeople = controlCenter.getSum();
                user.send(sumOfPeople);
                updateDisplay(trainReservationPanel);
            }

        });
        trainSearchPanel.add(trainSearchButton);
    }


    private void departureAreaActionButton(ArrayList<Region> regionList) {
        JButton departureAreaButton = new JButton("출발");
        departureAreaButton.addActionListener(event -> {

            DepartureTrainStationSelectionPanel departureTrainStationPanel = new DepartureTrainStationSelectionPanel(regionList);//TODO: 출발이랑 도착이랑 같은 페이지이다. 어떻게 해결할 것 인가
            updateDisplay(departureTrainStationPanel);
        });
        pointPanel.add(departureAreaButton);
    }

    private void arrivalAreaActionButton(ArrayList<Region> regionList, ControlCenter controlCenter) {
        JButton arrivalAreaButton = new JButton("도착");
        arrivalAreaButton.addActionListener(event -> {

            ArriveTrainStationSelectionPanel arriveTrainStationPanel = new ArriveTrainStationSelectionPanel(regionList, controlCenter);
            updateDisplay(arriveTrainStationPanel);
        });
        pointPanel.add(arrivalAreaButton);
    }

    private void departureText() {
        JTextField departureTextField = new JTextField("수서");
        departureTextField.setEditable(false);
        pointPanel.add(departureTextField);
    }

    private void arriveText(ControlCenter controlCenter) {
        JTextField arriveTextField = new JTextField(controlCenter.getRegionName());
        arriveTextField.setEditable(false);
        pointPanel.add(arriveTextField);
    }

    private void adultNumber(ControlCenter controlCenter) {
        numberOfPeoplePanel.add(new JLabel("어른"));

        JButton adultMinusButton = new JButton("-");
        adultMinusButton.addActionListener(event -> {
            if (controlCenter.getAdultCount() > 0) {
                controlCenter.minusAdultCount();
                adultCountLabel.setText(String.valueOf(controlCenter.getAdultCount()));
            }
        });
        numberOfPeoplePanel.add(adultMinusButton);

        adultCountLabel = new JLabel(String.valueOf(controlCenter.getAdultCount()));
        numberOfPeoplePanel.add(adultCountLabel);

        JButton adultPlusButton = new JButton("+");
        adultPlusButton.addActionListener(event -> {
            controlCenter.plusAdultCount();
            adultCountLabel.setText(String.valueOf(controlCenter.getAdultCount()));

            this.setVisible(false);
            this.setVisible(true);
        });
        numberOfPeoplePanel.add(adultPlusButton);
    }

    private void childrenNumber(ControlCenter controlCenter) {
        numberOfPeoplePanel.add(new JLabel("어린이"));
        JButton childrenMinusButton = new JButton("-");
        childrenMinusButton.addActionListener(event -> {
            if (controlCenter.getChildrenCount() > 0) {
                controlCenter.minusChildrenCount();
                childrenCountLabel.setText(String.valueOf(controlCenter.getChildrenCount()));
            }
        });
        numberOfPeoplePanel.add(childrenMinusButton);

        childrenCountLabel = new JLabel(String.valueOf(controlCenter.getChildrenCount()));
        numberOfPeoplePanel.add(childrenCountLabel);

        JButton childrenPlusButton = new JButton("+");
        childrenPlusButton.addActionListener(event -> {
            controlCenter.plusChildrenCount();
            childrenCountLabel.setText(String.valueOf(controlCenter.getChildrenCount()));
            this.setVisible(false);
            this.setVisible(true);
        });
        numberOfPeoplePanel.add(childrenPlusButton);
    }

    private void childNumber(ControlCenter controlCenter) {
        numberOfPeoplePanel.add(new JLabel("유아"));

        JButton childMinusButton = new JButton("-");
        childMinusButton.addActionListener(event -> {
            if (controlCenter.getChildCount() > 0) {
                controlCenter.minusChildCount();
                childCountLabel.setText(String.valueOf(controlCenter.getChildCount()));
            }
        });
        numberOfPeoplePanel.add(childMinusButton);

        childCountLabel = new JLabel(String.valueOf(controlCenter.getChildCount()));
        numberOfPeoplePanel.add(childCountLabel);

        JButton childPlusButton = new JButton("+");
        childPlusButton.addActionListener(event -> {
            controlCenter.plusChildCount();
            childCountLabel.setText(String.valueOf(controlCenter.getChildCount()));
            this.setVisible(false);
            this.setVisible(true);
        });
        numberOfPeoplePanel.add(childPlusButton);
    }

    private void oldManNumber(ControlCenter controlCenter) {
        numberOfPeoplePanel.add(new JLabel("경로인"));

        JButton oldManMinusButton = new JButton("-");
        oldManMinusButton.addActionListener(event -> {
            if (controlCenter.getOldManCount() > 0) {
                controlCenter.minusOldManCount();
                oldManCountLabel.setText(String.valueOf(controlCenter.getOldManCount()));
            }

        });
        numberOfPeoplePanel.add(oldManMinusButton);

        oldManCountLabel = new JLabel(String.valueOf(controlCenter.getOldManCount()));
        this.setVisible(false);
        this.setVisible(true);
        numberOfPeoplePanel.add(oldManCountLabel);

        JButton oldManPlusButton = new JButton("+");
        oldManPlusButton.addActionListener(event -> {
            controlCenter.plusOldManCount();
            oldManCountLabel.setText(String.valueOf(controlCenter.getOldManCount()));
        });
        numberOfPeoplePanel.add(oldManPlusButton);
    }

    private void updateDisplay(JPanel panel) {
        this.removeAll();
        this.add(panel);
        this.setVisible(false);
        this.setVisible(true);
    }
}
