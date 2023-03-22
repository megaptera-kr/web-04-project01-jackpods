import javax.swing.*;

public class LoginFrame extends JFrame {
    public LoginFrame() {

        JPanel panel = new JPanel();
        this.add(panel);

        JLabel label = new JLabel("ID : ");

        JLabel passwordLabel = new JLabel("PassWord : ");

        JTextField txtID = new JTextField(10);

        JPasswordField txtPass = new JPasswordField(10);

        JButton loginButton = new JButton("Login");

        panel.add(label);
        panel.add(txtID);
        panel.add(passwordLabel);
        panel.add(txtPass);
        panel.add(loginButton);


    }
}
