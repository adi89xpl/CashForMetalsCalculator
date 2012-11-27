import GUIBase.GUIBase;
import GUIBase.GUIModel;
import GUIBase.Helper.*;

public class CashForMetals {
    public static void main(String[] args) {
        GUIBase mainFrame = new GUIBase();
        mainFrame.DisplayGUI();
        GUIModel mainPanel = new GUIModel();
        mainPanel.addEventHandlers(mainFrame.getFrame());
        GUIHelper.SetDisplay(mainFrame.getFrame(), mainPanel.getContentPanel(), "Cash For Metals Calculator");
    }
}
