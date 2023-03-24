import models.*;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
    private List<User> userList = new ArrayList<>();
    private List<Token> tokenList = new ArrayList<>();
    private CompletePayment completePayment;
    private TemporaryStorage temporaryStorage;

    public static void main(String[] args) {
        SrtApp application = new SrtApp();
        application.run();
    }

    private void run() {

        trainInformation();

        temporaryStorage = new TemporaryStorage();

        reservation = new Reservation("");

        controlCenter = new ControlCenter("","",0,0);

        completePayment = new CompletePayment();

        ReginListInformation();

        User();

        frameSet();

        panelSets();

        categoryButton(completePayment);

//        login(userList,tokenList);

        frame.setVisible(true);
    }

    private void trainInformation() {
        trainList = new ArrayList<>();
        trainList.add( new Train("SRT 343", 15,"00"));
        trainList.add( new Train("SRT 351", 16,"00"));
        trainList.add( new Train("SRT 361", 18,"00"));
        trainList.add( new Train("SRT 363", 19,"00"));
        trainList.add( new Train("SRT 371", 20,"00"));
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
        user = new User("jack","1234");
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

//    private void login(List<User> userList,List<Token>tokenList) {


//        JLabel idLabel = new JLabel("아이디: ");
//        contentPanel.add(idLabel);
//
//        JTextField idTextField = new JTextField(30);
//        contentPanel.add(idTextField);
//
//        JLabel passwordLabel = new JLabel("비밀번호: ");
//        contentPanel.add(passwordLabel);
//
//        JTextField passwordTextField = new JTextField(30);
//        contentPanel.add(passwordTextField);
//
//        JButton loginButton = new JButton("로그인");
//        contentPanel.add(loginButton);
//
//        loginButton.addActionListener((event) -> {
//            for (User user : userList) {
//                if (idTextField.getText().equals(user.getId()) && passwordTextField.getText().equals(user.getPassword())) {
//                    Token token = new Token(idTextField.getText());
//                    tokenList.add(token);
//                }
//            }
//            idTextField.setText("");
//            passwordTextField.setText("");
//        });
//
//        JButton registerButton = new JButton("회원가입");
//        contentPanel.add(registerButton);
//
//        registerButton.addActionListener((event) -> {
//            User user = new User(idTextField.getText(), passwordTextField.getText());
//            userList.add(user);
//
//            idTextField.setText("");
//            passwordTextField.setText("");
//        });
//    }



    private JButton createReservationButton(CompletePayment completePayment) {
        JButton reservationButton = new JButton("승차권 예매");
        reservationButton.addActionListener(event->{
            ReservationPanel reservationPanel = new ReservationPanel(regionList,controlCenter,trainList,user,reservation,saveList,completePayment);
            showContentPanel(reservationPanel);

        });
        return reservationButton;
    }

    private JButton createCheckTicketButton() {
        JButton checkTheTicketButton = new JButton("승차권 확인");
        checkTheTicketButton.addActionListener(event->{
            CheckTheTicketPanel checkTheTicketPanel = null;
            try {
                checkTheTicketPanel = new CheckTheTicketPanel(regionList,controlCenter,reservation,saveList,completePayment,temporaryStorage);
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
            showContentPanel(checkTheTicketPanel);
        });
        return checkTheTicketButton;
    }

    private void categoryButton(CompletePayment completePayment) {
        bottomPanel.add(createReservationButton(completePayment));

        bottomPanel.add(createCheckTicketButton());

        JButton profileEditButton = new JButton("회원정보 관리");
        profileEditButton.addActionListener(event->{
            ProfileEditPanel profileEditPanel = new ProfileEditPanel(completePayment,user);
            showContentPanel(profileEditPanel);
            showContentPanel(profileEditPanel);
        });
        bottomPanel.add(profileEditButton);

    }

    private void showContentPanel(JPanel Panel) {
        contentPanel.removeAll();
        contentPanel.add(Panel);
        contentPanel.setVisible(false);
        contentPanel.setVisible(true);
        frame.setVisible(true);
    }
}