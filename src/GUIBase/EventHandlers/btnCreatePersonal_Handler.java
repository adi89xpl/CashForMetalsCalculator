package GUIBase.EventHandlers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import GUIBase.PersonalModel;

public class btnCreatePersonal_Handler implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        PersonalModel p = new PersonalModel();
        p.DisplayFrame();
    }
}
