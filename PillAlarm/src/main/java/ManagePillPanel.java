
import javax.swing.*;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class ManagePillPanel extends BackGroundPanel {


    private final JTextField pillNameTextField;

    public ManagePillPanel() throws IOException {
        super("/Users/jangjun-yeong/Desktop/Project1/PillAlarm/src/main/java/배경화면.png");
        setLayout(null);

        question();

        pillNameTextField = new JTextField();
        pillNameTextField.setBounds(50, 100, 320, 70);
        this.add(pillNameTextField);

        addButton();

        deleteButton();

        backButton();
    }

    private void question() {
        JLabel label = new JLabel("무슨 약이에요?");
        label.setBounds(50, 40, 80, 40);
        this.add(label);
    }

    private void addButton() {
        JButton addButton = new JButton("추가하기");
        addButton.setBounds(50, 410, 100, 30);

        this.add(addButton);

        DefaultListModel<String> model = new DefaultListModel<>();
        JList<String> pillList = new JList<>(model);
        pillList.setBounds(50, 180, 320, 200);

        add(pillList);

        addButton.addActionListener(event -> {

            String inputPillName = pillNameTextField.getText();

            model.addElement(inputPillName);

            pillNameTextField.setText("");
        });
    }

    private void deleteButton() {
        JButton deleteButton = new JButton("삭제하기");
        deleteButton.addActionListener(event -> {
        });
        deleteButton.setBounds(170, 410, 100, 30);
        this.add(deleteButton);
    }

    private void backButton() {
        JButton backButton = new JButton("뒤로가기");
        backButton.addActionListener(event -> {
            AlarmApp alarmApp = new AlarmApp();
            this.removeAll();

            alarmApp.back();

            this.setVisible(false);
            this.setVisible(true);
        });
        backButton.setBounds(290, 410, 100, 30);
        this.add(backButton);
    }
}
