import models.Region;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class SrtApp {
    private JFrame frame;
    private JPanel bottomPanel;
    private JPanel contentPanel;
    private ArrayList<Region> regionList;

    public static void main(String[] args) {
        SrtApp application = new SrtApp();
        application.run();
    }

    private void run() {
        regionList = new ArrayList<>();

        regionList.add(new Region("수서",0));
        regionList.add(new Region("동탄",30));
        regionList.add(new Region("평택",60));
        regionList.add(new Region("천안",80));
        regionList.add(new Region("오송",90));
        regionList.add(new Region("대전",120));

        frame = new JFrame("SRT");
        frame.setSize(350,700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panelSets();

        categoryButton();

        frame.setVisible(true);
    }

    private void panelSets() {
        pageChangeButtonPanel();

        contentPanel();
    }

    private void pageChangeButtonPanel() {
        bottomPanel = new JPanel();
        bottomPanel.setBackground(Color.white);
        frame.add(bottomPanel, BorderLayout.PAGE_END);
    }

    private void contentPanel() {
        contentPanel = new JPanel();
        frame.add(contentPanel);
    }

    private void categoryButton() {
        bottomPanel.add(createReservationButton());

        bottomPanel.add(createCheckTicketButton());

        JButton profileEditButton = new JButton("회원정보 관리");
        bottomPanel.add(profileEditButton);

    }


    private JButton createReservationButton() {
        JButton reservationButton = new JButton("승차권 예매");
        reservationButton.addActionListener(event->{
            ReservationPanel reservationPanel = new ReservationPanel(regionList);
            showContentPanel(reservationPanel);

        });
        return reservationButton;
    }

    private JButton createCheckTicketButton() {
        JButton checkTheTicketButton = new JButton("승차권 확인");
        checkTheTicketButton.addActionListener(event->{
            CheckTheTicketPanel checkTheTicketPanel = new CheckTheTicketPanel();
            showContentPanel(checkTheTicketPanel);
        });
        return checkTheTicketButton;
    }

    private void showContentPanel(JPanel Panel) {
        contentPanel.removeAll();
        contentPanel.add(Panel);
        contentPanel.setVisible(false);
        contentPanel.setVisible(true);
        frame.setVisible(true);
    }
}