package GUIBase.EventHandlers;

import GUIBase.GUIModel;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddPersonal_Cancel_Handler implements ActionListener{
    private Container cFrame;
    public AddPersonal_Cancel_Handler(Container currentFrame){
        cFrame = currentFrame;
    }
    public void actionPerformed(ActionEvent e) {
        GUIModel mainFrame = new GUIModel();
        cFrame.setVisible(false);
        mainFrame.DisplayFrame();
    }
}
