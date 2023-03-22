import javax.swing.*;
import java.awt.*;

public class ManagePillPanel extends JPanel {

    private final JTextField pillNameTextField;
    private final JPanel textPanel;
    private final JPanel buttonPanel;
    private JList<String> pillList;

    public ManagePillPanel(Pill pill, User user) {

        this.setLayout(new GridLayout(4,1));

        question();

        textPanel = new JPanel();
        textPanel.setLayout(new GridLayout(2,1));
        this.add(textPanel);

        buttonPanel = new JPanel();
        this.add(buttonPanel);

        pillNameTextField = new JTextField();
        textPanel.add(pillNameTextField);

        addButton(pill);

        deleteButton();

    }

    private void question() {
        JLabel label = new JLabel("무슨 약이에요?");
        this.add(label);
    }

    private void addButton(Pill pill) {
        JLabel blank = new JLabel();
        this.add(blank);
        JButton addButton = new JButton("추가하기");
        buttonPanel.add(addButton);

        pillList = new JList<>(pill.getPillList());
        textPanel.add(pillList);

        addButton.addActionListener(event -> {

            String inputPillName = pillNameTextField.getText();

            pill.transfer(inputPillName);

            pillNameTextField.setText("");
        });
    }

    private void deleteButton() {
        JButton deleteButton = new JButton("삭제하기");
        deleteButton.addActionListener(event -> {
            int[] selectedIndices = pillList.getSelectedIndices();
            if (selectedIndices.length > 0) {
                DefaultListModel<String> model = (DefaultListModel<String>) pillList.getModel();
                for (int i = selectedIndices.length - 1; i >= 0; i--) {
                    model.remove(selectedIndices[i]);
                }
            }
        });
        buttonPanel.add(deleteButton);
    }
}
