import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {
    String time = "";

    private String name;

    User(String name) {

        this.name = name;
    }

    public void transfer(String timeView) {
        this.time = timeView;
    }

    public String getTime() {
        return time;
    }
}
