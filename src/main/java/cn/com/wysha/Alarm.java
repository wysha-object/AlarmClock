package cn.com.wysha;

import java.time.LocalTime;

public class Alarm {
    private String name;
    private String audioURL;
    private byte hour;
    private byte minute;
    private boolean enabled;
    public void setName(String name) {
        this.name = name;
    }

    public void setHour(byte hour) {
        this.hour = hour;
    }

    public void setMinute(byte minute) {
        this.minute = minute;
    }
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
    @Override
    public String toString() {
        return name+"   "+hour+":"+minute;
    }

    public Alarm(String name, String audioURL, byte hour, byte minute) {
        this.name = name;
        this.audioURL = audioURL;
        this.hour = hour;
        this.minute = minute;
        this.enabled = true;
        Main.addAlarm(this);
        Main.execute(() -> {
            while (Main.containsAlarm(this)){
                try {
                    if (enabled){
                        LocalTime localTime=LocalTime.now();
                        if (localTime.getHour()==hour&&localTime.getMinute()==minute){
                            this.enabled=false;
                            new AlarmGUI(audioURL).setVisible(true);
                        }
                    }
                    Thread.sleep(100);
                } catch (Exception _) {
                }
            }
        });
    }
}
