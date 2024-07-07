package cn.com.wysha;

import javax.swing.*;
import java.awt.*;

public class MainGUI extends JFrame{
    private JPanel contentPane;
    private JList<String> alarmList;
    private JButton newBut;
    private JButton removeBut;
    private JButton editBut;
    private JButton flush;
    public void setData(String[] data){
        alarmList.setListData(data);
    }
    public MainGUI(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(contentPane);
        Dimension dimension=Toolkit.getDefaultToolkit().getScreenSize();
        setSize(dimension.width/2,dimension.height/2);
        setLocationRelativeTo(null);
        new Thread(() -> {
            while(true){
                repaint();
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();
    }
}
