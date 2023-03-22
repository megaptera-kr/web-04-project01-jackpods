
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class CheckListPanel extends JPanel {

    private String timeView;

    public CheckListPanel(Pill pill,User user) {
        setLayout(new GridLayout(pill.getPillList().getSize(), 1));
        for (int i = 0; i < pill.getPillList().getSize(); i += 1) {
            String pillName = pill.getPillList().getElementAt(i);
            JCheckBox checkBox = new JCheckBox(pillName);

            checkBox.setBounds(80, (50 + i * 30), 100, 50);

            checkBox.addActionListener(event -> {

                pill.addPillNameAtList(pillName);

                timeSets();

                user.transfer(timeView);
            });
            this.add(checkBox);
        }
    }

    private void timeSets() {
////        while (true) {
        Calendar time = Calendar.getInstance();
        int year = time.get(Calendar.YEAR);
        int month = time.get(Calendar.MONTH);
        int date = time.get(Calendar.DATE);
        int amPM = time.get(Calendar.AM_PM);
        int hour = time.get(Calendar.HOUR);
        int min = time.get(Calendar.MINUTE);
        int sec = time.get(Calendar.SECOND);
        String ampm = amPM == Calendar.AM ? "AM" : "PM";
        int day = time.get(Calendar.DAY_OF_WEEK);

        timeView = year + "년" + month + "월" + date + "일 " + ampm + hour + "시 " + min + "분 " + sec + "초";

//        JLabel timeLabel = new JLabel(timeView);
//        this.add(timeLabel);

        try {
            Thread.sleep(1000);//0.1초
            this.repaint();
        } catch (Exception e) {
        }
    }
}

