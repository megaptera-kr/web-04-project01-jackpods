import models.*;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class SrtApp {
    private JFrame frame;
    private JPanel bottomPanel;
    private JPanel contentPanel;
    private ArrayList<Region> regionList;
    private ControlCenter controlCenter;
    private ArrayList<Train> trainList;
    private User user;
    private Reservation reservation;
    private ArrayList<String> saveList = new ArrayList<>();

    public static void main(String[] args) {
        SrtApp application = new SrtApp();
        application.run();
    }

    private void run() {


        trainInformation();

        reservation = new Reservation("");

        controlCenter = new ControlCenter("","",0,0);

        ReginListInformation();

        User();

        frameSet();

        panelSets();

        categoryButton();

        frame.setVisible(true);
    }

    private void trainInformation() {
        trainList = new ArrayList<>();
        trainList.add( new Train("SRT 343", 15,"05"));
        trainList.add( new Train("SRT 351", 16,"05"));
        trainList.add( new Train("SRT 361", 18,"37"));
        trainList.add( new Train("SRT 363", 19,"00"));
        trainList.add( new Train("SRT 371", 20,"28"));
        trainList.add( new Train("SRT 377", 22,"00"));
    }

    private void ReginListInformation() {
        regionList = new ArrayList<>();

        regionList.add(new Region("수서",0));
        regionList.add(new Region("동탄",30));
        regionList.add(new Region("평택",60));
        regionList.add(new Region("천안",80));
        regionList.add(new Region("오송",90));
        regionList.add(new Region("대전",120));
    }

    private void User() {
        user = new User("jack","");
    }

    private void frameSet() {
        frame = new JFrame("SRT");
        frame.setSize(400,700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
            ReservationPanel reservationPanel = new ReservationPanel(regionList,controlCenter,trainList,user,reservation,saveList);
            showContentPanel(reservationPanel);

        });
        return reservationButton;
    }

    private JButton createCheckTicketButton() {
        JButton checkTheTicketButton = new JButton("승차권 확인");
        checkTheTicketButton.addActionListener(event->{
            CheckTheTicketPanel checkTheTicketPanel = null;
            try {
                checkTheTicketPanel = new CheckTheTicketPanel(controlCenter,reservation,saveList);
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
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