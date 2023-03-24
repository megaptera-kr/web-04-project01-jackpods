import models.CompletePayment;
import models.User;

import javax.swing.*;
import java.awt.*;

public class ProfileEditPanel extends JPanel {
    private JPanel contentPanel;
    private JPanel userInformationPanel;

    ProfileEditPanel(CompletePayment completePayment, User user) {
        this.setLayout(new GridLayout(3, 1));

        panelSets(completePayment);

        userInformation(user);

        paymentTransactions(completePayment, user);
    }

    private void panelSets(CompletePayment completePayment) {
        userInformationPanel = new JPanel();
        this.add(userInformationPanel);

        for (int i = 0; i<completePayment.getList().size(); i+=1) {
            contentPanel = new JPanel();

            contentPanel.setLayout(new GridLayout(5, 1));
            this.add(contentPanel);
        }


    }

    private void userInformation(User user) {
        userInformationPanel.add(new JLabel("사용자 이름: " + user.getId()));
    }

    private void paymentTransactions(CompletePayment completePayment, User user) {
        for (String content : completePayment.getList()) {
            contentPanel.add(new JLabel(content));
        }
    }
}
