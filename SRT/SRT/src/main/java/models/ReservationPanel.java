package models;

import javax.swing.*;
import java.awt.*;

public class ReservationPanel extends JPanel {
    private JPanel appNamePanel;
    private JPanel timesPanel;
    private JPanel pointPanel;
    private JPanel dayPanel;
    private JPanel numberOfPeoplePanel;
    private JPanel trainSearchPanel;

    public ReservationPanel() {

        setLayout(new GridLayout(6,1));

        panelSets();

        titleLabel();

        timesButtonSets();

        chooseRegionButtonSets();

        chooseNumberOfPeople();

        trainSearch();
    }

    private void panelSets() {

        appNamePanel = new JPanel();
        appNamePanel.setBackground(Color.white);
        appNamePanel.setPreferredSize(new Dimension(200,50));
        this.add(appNamePanel);

        timesPanel = new JPanel();
        this.add(timesPanel);

        pointPanel = new JPanel();
        pointPanel.setBackground(Color.white);
        this.add(pointPanel);

        dayPanel = new JPanel();
        dayPanel.setLayout(new GridLayout(2,1));
        this.add(dayPanel);

        numberOfPeoplePanel = new JPanel();
        numberOfPeoplePanel.setBackground(Color.white);
        numberOfPeoplePanel.setLayout(new GridLayout(4,4));
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
        oneWayButton.addActionListener(event->{
            dayPanel.removeAll();
            JButton departureDayButton = new JButton("출발일");
            dayPanel.add(departureDayButton);

            this.setVisible(false);
            this.setVisible(true);
        });
        timesPanel.add(oneWayButton);

        JButton roundButton = new JButton("왕복");
        roundButton.addActionListener(event->{
            dayPanel.removeAll();
            JButton departDayButton = new JButton("가는날");
            dayPanel.add(departDayButton);
            JButton arrivalDayButton = new JButton("오는날");
            dayPanel.add(arrivalDayButton);

            this.setVisible(false);
            this.setVisible(true);
        });
        timesPanel.add(roundButton);
    }

    private void chooseRegionButtonSets() {
        JButton departureAreaButton = new JButton("출발");
        pointPanel.add(departureAreaButton);

        JButton switchButton = new JButton("switch");
        pointPanel.add(switchButton);

        JButton arrivalAreaButton = new JButton("도착");
        pointPanel.add(arrivalAreaButton);
    }

    private void chooseNumberOfPeople() {

        numberOfPeoplePanel.add(new JLabel("어른"));
        numberOfPeoplePanel.add(new JButton("-"));
        JLabel adultCountLabel = new JLabel("0");
        numberOfPeoplePanel.add(adultCountLabel);
        numberOfPeoplePanel.add(new JButton("+"));
//        numberOfPeoplePanel.add(new JLabel());
//        numberOfPeoplePanel.add(new JLabel());
        numberOfPeoplePanel.add(new JLabel("어린이"));
        numberOfPeoplePanel.add(new JButton("-"));
        JLabel childrenCountLabel = new JLabel("0");
        numberOfPeoplePanel.add(childrenCountLabel);
        numberOfPeoplePanel.add(new JButton("+"));

        numberOfPeoplePanel.add(new JLabel("유아"));
        numberOfPeoplePanel.add(new JButton("-"));
        JLabel childCountLabel = new JLabel("0");
        numberOfPeoplePanel.add(childCountLabel);
        numberOfPeoplePanel.add(new JButton("+"));

        numberOfPeoplePanel.add(new JLabel("경로"));
        numberOfPeoplePanel.add(new JButton("-"));
        JLabel oldManCountLabel = new JLabel("0");
        numberOfPeoplePanel.add(oldManCountLabel);
        numberOfPeoplePanel.add(new JButton("+"));
    }

    private void trainSearch() {
        JButton trainSearchButton = new JButton("열차 조회하기");
        trainSearchPanel.add(trainSearchButton);
    }
}
