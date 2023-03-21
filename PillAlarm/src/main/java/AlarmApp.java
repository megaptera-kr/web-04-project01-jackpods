import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Calendar;

public class AlarmApp {
    private JPanel mainPanel;
    private JFrame frame;
    private BackGroundPanel backGroundPanel;

    public static void main(String[] args) throws IOException {
        AlarmApp application = new AlarmApp();
        application.run();
    }

    public void run() throws IOException {

        frameSetting();

        buttonSets();

        timeSets();

        frame.setVisible(true);
    }

//    }
    private void frameSetting() throws IOException {

        frame = new JFrame("약먹언");
        frame.setSize(640, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        backGroundPanel = new BackGroundPanel("/Users/jangjun-yeong/Desktop/Project1/PillAlarm/src/main/java/배경화면.png");
        backGroundPanel.setLayout(null);
        frame.add(backGroundPanel);
    }

    private void buttonSets() throws IOException {

        mainPanel = new JPanel();
        mainPanel.setBackground(Color.cyan);
        frame.add(mainPanel, BorderLayout.PAGE_END);

        ImageIcon manageButtonIcon = new ImageIcon("/Users/jangjun-yeong/Desktop/Project1/PillAlarm/src/main/java/병아리.png");
        ImageIcon checkButtonIcon = new ImageIcon("/Users/jangjun-yeong/Desktop/Project1/PillAlarm/src/main/java/알약.png");
        ImageIcon listButtonIcon = new ImageIcon("/Users/jangjun-yeong/Desktop/Project1/PillAlarm/src/main/java/리스트.png");

        JButton checkListButton = new JButton(checkButtonIcon);
        checkListButton.addActionListener(event -> {
            CheckListPanel checkListPanel = new CheckListPanel();
            frame.add(checkListPanel);
            frame.setVisible(false);
            frame.setVisible(true);
        });
        mainPanel.add(checkListButton);

        JButton managePillButton = new JButton(manageButtonIcon);
        managePillButton.addActionListener(event -> {
            frame.getContentPane().removeAll();
            ManagePillPanel managePillPanel = null;
            try {
                managePillPanel = new ManagePillPanel();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            frame.add(managePillPanel);
            frame.setVisible(false);
            frame.setVisible(true);
        });
        mainPanel.add(managePillButton);

        JButton inquiryButton = new JButton(listButtonIcon);
        mainPanel.add(inquiryButton);

    }

    private void timeSets() {
//        while (true) {
        Calendar time = Calendar.getInstance();
        int year = time.get(Calendar.YEAR);
        int month = time.get(Calendar.MONTH);
        int date = time.get(Calendar.DATE);
        int amPM = time.get(Calendar.AM_PM);
        int hour = time.get(Calendar.HOUR);
        int min = time.get(Calendar.MINUTE);
        int sec = time.get(Calendar.SECOND);
        String ampm = amPM == Calendar.AM ? "PM" : "AM";
        int day = time.get(Calendar.DAY_OF_WEEK);

        String timeView = year + "년" + month + "월" + date + "일 " + ampm + hour + "시 " + min + "분 " + sec + "초";
        JLabel label = new JLabel(timeView);
        label.setBounds(0, 0, 200, 60);
        backGroundPanel.add(label);

        try {
            Thread.sleep(1000);//0.1초
            frame.repaint();
        } catch (Exception e) {
        }
    }

    public JFrame getFrame() {
        return frame;
    }

    public void back() {
    }
}
