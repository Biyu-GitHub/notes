package 快速入门;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class TalkingClock {
    private int interval;
    private boolean beep;

    public TalkingClock(int interval, boolean beep) {
        this.interval = interval;
        this.beep = beep;
    }

    public void start() {
        System.out.println("TalkingClock start ...");
    }

    /**
     * 内部类可以使用外部类的私有属性beep
     */
    public class TimePrinter implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("At the tone , the time is " + new Date());
            if (beep) {
                Toolkit.getDefaultToolkit().beep();
            }
        }
    }
}
