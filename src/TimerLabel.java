import javax.swing.*;
import java.util.Timer;
import java.util.TimerTask;

public class TimerLabel extends JLabel {
    private int t;
    public TimerLabel(Timer timer) {
        timer.scheduleAtFixedRate(timerTask, 0, 1000);
    }

    private TimerTask timerTask = new TimerTask() {
        public volatile int time = -1;

        private Runnable refresher = new Runnable() {
            @Override
            public void run() {
                t = time;
                TimerLabel.this.setText(String.format("%02d:%02d", t / 60, t % 60));
            }
        };

        @Override
        public void run() {
            time++;
            SwingUtilities.invokeLater(refresher);
        }

    };
    public int getTime(){
        return t;
    }
}