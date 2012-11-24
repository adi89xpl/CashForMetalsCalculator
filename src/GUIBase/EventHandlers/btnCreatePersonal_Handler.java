package GUIBase.EventHandlers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import GUIBase.PersonalModel;
import java.awt.Component;

public class btnCreatePersonal_Handler implements ActionListener {
     protected Component mFrame;
    public btnCreatePersonal_Handler(Component mainFrame){
        mFrame = mainFrame;
    }
    public void actionPerformed(ActionEvent e) {
        PersonalModel p = new PersonalModel();
        p.DisplayFrame();
        mFrame.setVisible(false);
    }
}
