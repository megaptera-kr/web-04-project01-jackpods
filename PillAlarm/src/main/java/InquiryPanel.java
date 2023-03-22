import javax.swing.*;
import java.awt.*;

public class InquiryPanel extends JPanel {

    InquiryPanel(Pill pill,User user)  {
        setLayout(new GridLayout(pill.arrayList.size(),1));

        for (int i = 0; i < pill.arrayList.size(); i += 1) {
            JLabel checkedPillLabel = new JLabel(pill.getCheckedPillList().get(i));
            this.add(checkedPillLabel);
            JLabel timeLabel = new JLabel(user.getTime());
            this.add(timeLabel);
        }
    }
}
