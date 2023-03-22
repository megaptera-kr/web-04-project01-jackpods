import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Pill {
    DefaultListModel<String> pillList = new DefaultListModel<>();

    List<String> arrayList = new ArrayList<>();

    public Pill() {
    }

    public void transfer(String inputPillName) {
        pillList.addElement(inputPillName);
    }

    public DefaultListModel<String> getPillList() {
        return pillList;
    }

    public void addPillNameAtList(String pillName) {
        arrayList.add(pillName);
    }

    public List<String> getCheckedPillList() {
        return arrayList;
    }
}
