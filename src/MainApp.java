import UI.AlarmClockUI;

import java.awt.*;

public class MainApp {
    public static void main(String[] args) {
        EventQueue.invokeLater(()->new AlarmClockUI(5));
    }
}
