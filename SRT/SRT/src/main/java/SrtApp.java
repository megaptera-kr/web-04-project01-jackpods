import models.CheckTheTicketPanel;
import models.ReservationPanel;

import javax.swing.*;
import java.awt.*;

public class SrtApp {
    private JFrame frame;
    private JPanel bottomPanel;
    private JPanel contentPanel;

    public static void main(String[] args) {
        SrtApp application = new SrtApp();
        application.run();
    }

    private void run() {
        frame = new JFrame("SRT");
        frame.setSize(400,800);
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
            ReservationPanel reservationPanel = new ReservationPanel();
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