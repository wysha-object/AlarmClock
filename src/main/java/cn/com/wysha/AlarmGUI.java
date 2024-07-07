package cn.com.wysha;

import javax.swing.*;
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.*;

public class AlarmGUI extends JFrame{
    private JPanel contentPane;
    private JButton button;
    boolean b;
    public AlarmGUI(String audioURL){
        setContentPane(contentPane);
        Dimension dimension=Toolkit.getDefaultToolkit().getScreenSize();
        setSize(dimension.width/3,dimension.height/3);
        setLocationRelativeTo(null);
        AudioClip audioClip= Applet.newAudioClip(audioURL);
        b=true;
        button.addActionListener(_ -> {
            b=false;
            audioClip.stop();
            dispose();
        });
        while (b){
            audioClip.play();
        }
    }
}
