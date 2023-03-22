
import models.Region;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


public class ReservationPanel extends JPanel {
    private JPanel appNamePanel;
    private JPanel timesPanel;
    private JPanel pointPanel;
    private JPanel dayPanel;
    private JPanel numberOfPeoplePanel;
    private JPanel trainSearchPanel;
    private String[] day = {"20", "21", "22", "23", "24", "25"};
    private int count = 0;

    public ReservationPanel(ArrayList<Region> regionList) {

        setLayout(new GridLayout(6, 1));

        panelSets();

        titleLabel();

        timesButtonSets();

        chooseRegionButtonSets(regionList);

        departureDay();

        chooseNumberOfPeople();

        trainSearch();
    }

    private void panelSets() {

        appNamePanel = new JPanel();
        appNamePanel.setBackground(Color.white);
        appNamePanel.setPreferredSize(new Dimension(200, 50));
        this.add(appNamePanel);

        timesPanel = new JPanel();
        this.add(timesPanel);

        pointPanel = new JPanel();
        pointPanel.setBackground(Color.white);
        this.add(pointPanel);

        dayPanel = new JPanel();
        dayPanel.setLayout(new GridLayout(2, 1));
        this.add(dayPanel);

        numberOfPeoplePanel = new JPanel();
        numberOfPeoplePanel.setBackground(Color.white);
        numberOfPeoplePanel.setLayout(new GridLayout(4, 4));
        this.add(numberOfPeoplePanel);

        trainSearchPanel = new JPanel();
        this.add(trainSearchPanel);

    }

    private void titleLabel() {
        JLabel titleLabel = new JLabel("SRT");
        appNamePanel.add(titleLabel);
    }

    private void timesButtonSets() {
        JButton oneWayButton = new JButton("편도");
        oneWayButton.addActionListener(event -> {
            this.setVisible(false);
            this.setVisible(true);
        });
        timesPanel.add(oneWayButton);

    }

    private void chooseRegionButtonSets(ArrayList<Region> regionList) {
        JButton departureAreaButton = new JButton("출발");
        departureAreaButton.addActionListener(event -> {

            DepartureTrainStationSelectionPanel departureTrainStationPanel = new DepartureTrainStationSelectionPanel(regionList);//TODO: 출발이랑 도착이랑 같은 페이지이다. 어떻게 해결할 것 인가
            updateDisplay(departureTrainStationPanel);
        });
        pointPanel.add(departureAreaButton);

        JButton switchButton = new JButton("switch");
        pointPanel.add(switchButton);

        JButton arrivalAreaButton = new JButton("도착");
        arrivalAreaButton.addActionListener(event -> {

            ArriveTrainStationSelectionPanel arriveTrainStationPanel = new ArriveTrainStationSelectionPanel();
            updateDisplay(arriveTrainStationPanel);

        });
        pointPanel.add(arrivalAreaButton);
    }

    private void departureDay() {
        JButton departureDayButton = new JButton("출발일");
        departureDayButton.addActionListener(event -> {
            JComboBox departureDay = new JComboBox(day);

            dayPanel.add(departureDay);

            this.setVisible(false);
            this.setVisible(true);

        });
        dayPanel.add(departureDayButton);
    }

    private void chooseNumberOfPeople() {

        numberOfAdultControl("어른");

        numberOfAdultControl("어린이");

        numberOfAdultControl("유아");

        numberOfAdultControl("경로");
    }

    private void numberOfAdultControl(String person) {
        numberOfPeoplePanel.add(new JLabel(person));
        JButton minusButton = new JButton("-");
        numberOfPeoplePanel.add(minusButton);
        System.out.println("label"+count);
        JLabel adultCountLabel = new JLabel(String.valueOf(count));
        numberOfPeoplePanel.add(adultCountLabel);
        JButton plusButton = new JButton("+");
        plusButton.addActionListener(event->{
//            count+=;  표 가격을 더한다.
            this.setVisible(false);
            this.setVisible(true);
            System.out.println(""+count);
        });
        numberOfPeoplePanel.add(plusButton);
    }

    private void trainSearch() {
        JButton trainSearchButton = new JButton("열차 조회하기");
        trainSearchPanel.add(trainSearchButton);
    }

    private void updateDisplay(JPanel panel) {
        this.removeAll();
        this.add(panel);
        this.setVisible(false);
        this.setVisible(true);
    }
}
