import java.awt.Dimension;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
/**
 * This class is a simple JFrame implementation to explain how to
 * display time dynamically on the JSwing-based interface.
 * @author Edison
 *
 */
public class TimePanel extends JPanel 
{
 /*
 * Variables 
 */
 private JPanel timePanel;
 private JLabel timeLabel;
 private JLabel displayArea;
 private String DEFAULT_TIME_FORMAT = "HH:mm:ss";
 private String time;
 private int ONE_SECOND = 1000;
  
 public TimePanel(){
 timeLabel = new JLabel("CurrentTime: ");
 displayArea = new JLabel();
  
 configTimeArea();
  
 this.add(timeLabel);
 this.add(displayArea);
 }
  
 /**
 * This method creates a timer task to update the time per second
 */
 private void configTimeArea() {
 Timer tmr = new Timer();
 tmr.scheduleAtFixedRate(new JLabelTimerTask(),new Date(), ONE_SECOND);
 }
  
 /**
 * Timer task to update the time display area
 *
 */
 protected class JLabelTimerTask extends TimerTask{
 SimpleDateFormat dateFormatter = new SimpleDateFormat(DEFAULT_TIME_FORMAT);
 @Override
 public void run() {
  time = dateFormatter.format(Calendar.getInstance().getTime());
  displayArea.setText(time);
 }
 }
}