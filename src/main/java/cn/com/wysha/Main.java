package cn.com.wysha;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    private static final ExecutorService EXECUTOR_SERVICE = Executors.newCachedThreadPool();
    public static void execute(Runnable runnable){
        EXECUTOR_SERVICE.execute(runnable);
    }
    private static final ArrayList<Alarm> ALARM_ARRAY_LIST =new ArrayList<>();
    public static boolean containsAlarm(Alarm alarm){
        return ALARM_ARRAY_LIST.contains(alarm);
    }
    public static boolean addAlarm(Alarm alarm){
        return ALARM_ARRAY_LIST.add(alarm);
    }
    public static Alarm removeAlarm(int index){
        return ALARM_ARRAY_LIST.remove(index);
    }
    public static Alarm getAlarm(int index){
        return ALARM_ARRAY_LIST.get(index);
    }

    private static final MainGUI mainGUI=new MainGUI();
    public static void main(String[] args) {
        mainGUI.setVisible(true);
    }
}