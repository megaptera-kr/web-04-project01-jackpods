import javax.lang.model.type.ArrayType;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Calendar;

public class AlarmApp {
    private JPanel buttonPanel;
    private JFrame frame;
//    private Background contentPanel;
//    private JLabel timeLabel;
    private ImageIcon manageButtonIcon;
    private ImageIcon checkButtonIcon;
    private ImageIcon listButtonIcon;
    private final Pill pill = new Pill();
    private User user = new User("jack");
    private JPanel contentPanel;

    public static void main(String[] args)  {
        AlarmApp application = new AlarmApp();
        application.run();
    }

    public void run() {

        frameSetting();

        buttonSets();

        frame.setVisible(true);
    }

    private void frameSetting() {

        frame = new JFrame("약먹언");
        frame.setSize(400, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        initContent();

    }

    private void buttonSets()  {

        buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.cyan);
        frame.add(buttonPanel, BorderLayout.PAGE_END);

        buttonImage();

        createCheckButton(checkButtonIcon);

        createManageButton(manageButtonIcon);

        createListButton(listButtonIcon);

    }

    private void buttonImage() {
        manageButtonIcon = new ImageIcon("/Users/jangjun-yeong/Desktop/Project1/PillAlarm/src/main/java/병아리.png");
        checkButtonIcon = new ImageIcon("/Users/jangjun-yeong/Desktop/Project1/PillAlarm/src/main/java/알약.png");
        listButtonIcon = new ImageIcon("/Users/jangjun-yeong/Desktop/Project1/PillAlarm/src/main/java/리스트.png");
    }

    private void createCheckButton(ImageIcon checkButtonIcon) {
        JButton checkListButton = new JButton(checkButtonIcon);

        checkListButton.addActionListener(event -> {

            CheckListPanel checkListPanel = new CheckListPanel(pill,user);

            updatePanel(checkListPanel);

        });
        buttonPanel.add(checkListButton);
    }

    private void createManageButton(ImageIcon manageButtonIcon) {
        JButton managePillButton = new JButton(manageButtonIcon);

        managePillButton.addActionListener(event -> {

            ManagePillPanel managePillPanel = new ManagePillPanel(pill,user);

            updatePanel(managePillPanel);
        });
        buttonPanel.add(managePillButton);
    }

    private void createListButton(ImageIcon listButtonIcon) {
        JButton inquiryButton = new JButton(listButtonIcon);

        inquiryButton.addActionListener(event -> {

            InquiryPanel inquiryPanel = new InquiryPanel(pill,user);

            updatePanel(inquiryPanel);
        });
        buttonPanel.add(inquiryButton);
    }

    private void initContent() {
        contentPanel = new JPanel();
        frame.add(contentPanel);
    }

    private void updatePanel(JPanel panel) {
        contentPanel.removeAll();
        contentPanel.add(panel);

        frame.setVisible(false);
        frame.setVisible(true);
    }

//    private void timeSets() {
////        while (true) {
//        Calendar time = Calendar.getInstance();
//        int year = time.get(Calendar.YEAR);
//        int month = time.get(Calendar.MONTH);
//        int date = time.get(Calendar.DATE);
//        int amPM = time.get(Calendar.AM_PM);
//        int hour = time.get(Calendar.HOUR);
//        int min = time.get(Calendar.MINUTE);
//        int sec = time.get(Calendar.SECOND);
//        String ampm = amPM == Calendar.AM ? "AM" : "PM";
//        int day = time.get(Calendar.DAY_OF_WEEK);
//
//        String timeView = year + "년" + month + "월" + date + "일 " + ampm + hour + "시 " + min + "분 " + sec + "초";
//
//        timeLabel = new JLabel(timeView);
//        timeLabel.setBounds(0, 0, 250, 60);
//        contentPanel.add(timeLabel);
//
//        try {
//            Thread.sleep(1000);//0.1초
//            frame.repaint();
//        } catch (Exception e) {
//        }
//    }
}
