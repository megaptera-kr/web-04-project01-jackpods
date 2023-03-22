import models.Region; //TODO 왜 models를 해야하지?

import javax.swing.*;
import java.awt.*;

public class ArriveTrainStationSelectionPanel extends JPanel {

    private JPanel whereToGoDisplayPanel;
    private JPanel regionListPanel;
    private JPanel chooseButtonPanel;
    private Region region;

    ArriveTrainStationSelectionPanel() {
        setLayout(new GridLayout(3,1));

        panelSets();

        whereToGoDisplay();

        regionList();
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
        JTextField departureTextField = new JTextField();//출발지
        departureTextField.setEditable(false);
        whereToGoDisplayPanel.add(departureTextField);
        JButton switchButton = new JButton("switch");
        whereToGoDisplayPanel.add(switchButton);
        JTextField arriveTextField = new JTextField();//도착지
        arriveTextField.setEditable(false);
        whereToGoDisplayPanel.add(arriveTextField);
    }

    private void regionList() {
        JButton suseoButton = new JButton("수서");
        chooseButtonPanel.add(suseoButton);

        JButton dongtanButton = new JButton("동탄");
        dongtanButton.addActionListener(event->{
            region.transferArriveRegion("동탄");
        });
        chooseButtonPanel.add(dongtanButton);

        JButton pyeongtaekButton = new JButton("평택");
        chooseButtonPanel.add(pyeongtaekButton);

        JButton cheonanButton = new JButton("천안");
        chooseButtonPanel.add(cheonanButton);

        JButton osongButton = new JButton("오송");
        chooseButtonPanel.add(osongButton);

        JButton daejeonButton = new JButton("대전");
        chooseButtonPanel.add(daejeonButton);
    }
}
