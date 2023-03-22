
import models.Region;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class DepartureTrainStationSelectionPanel extends JPanel {

    private JPanel whereToGoDisplayPanel;
    private JPanel regionListPanel;
    private JPanel chooseButtonPanel;
    private JTextField departureTextField;
    private Region region;

    DepartureTrainStationSelectionPanel(ArrayList<Region> regionList) {
        setLayout(new GridLayout(3,1));

        panelSets();

        whereToGoDisplay();

        regionList(regionList);
    }

    private void panelSets() {
        whereToGoDisplayPanel = new JPanel();
        whereToGoDisplayPanel.setLayout(new GridLayout(2,3));
        this.add(whereToGoDisplayPanel);

        regionListPanel = new JPanel();
        this.add(regionListPanel);

        chooseButtonPanel = new JPanel();
        chooseButtonPanel.setLayout(new GridLayout(2,3));
        this.add(chooseButtonPanel);
    }

    private void whereToGoDisplay() {
        whereToGoDisplayPanel.add(new JLabel("       출발"));
        whereToGoDisplayPanel.add(new JLabel());
        whereToGoDisplayPanel.add(new JLabel("       도착"));
        departureTextField = new JTextField();//출발 텍스트
        departureTextField.setEditable(false);
        whereToGoDisplayPanel.add(departureTextField);
        JButton switchButton = new JButton("switch");
        whereToGoDisplayPanel.add(switchButton);
        JTextField arriveTextField = new JTextField();//도착 텍스트
        arriveTextField.setEditable(false);
        whereToGoDisplayPanel.add(arriveTextField);
    }

    private void regionList(ArrayList<Region> regionList) {
        JButton suseoButton = new JButton("수서");
        suseoButton.addActionListener(event->{
            departureTextField.setText(regionList.get(0).getRegion());
        });
        chooseButtonPanel.add(suseoButton);

        JButton dongtanButton = new JButton("동탄");
        dongtanButton.addActionListener(event->{
            departureTextField.setText(regionList.get(1).getRegion());
        });
        chooseButtonPanel.add(dongtanButton);

        JButton pyeongtaekButton = new JButton("평택");
        pyeongtaekButton.addActionListener(event->{
            departureTextField.setText(regionList.get(2).getRegion());
        });
        chooseButtonPanel.add(pyeongtaekButton);

        JButton cheonanButton = new JButton("천안");
        cheonanButton.addActionListener(event->{
            departureTextField.setText(regionList.get(3).getRegion());
        });
        chooseButtonPanel.add(cheonanButton);

        JButton osongButton = new JButton("오송");
        osongButton.addActionListener(event->{
            departureTextField.setText(regionList.get(4).getRegion());
        });
        chooseButtonPanel.add(osongButton);

        JButton daejeonButton = new JButton("대전");
        daejeonButton.addActionListener(event->{
            departureTextField.setText(regionList.get(5).getRegion());
        });
        chooseButtonPanel.add(daejeonButton);
    }
}

