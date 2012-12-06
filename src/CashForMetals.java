import GUIBase.GUIBase;
import GUIBase.GUIModel;
import GUIBase.Helper.GUIHelper;

public class CashForMetals {
    public static void main(String[] args) {
        //This main class creates a GUI Base model and then all it does
        //is swapping out panels resonsible for different views/models
        GUIBase mainFrame = new GUIBase();
        mainFrame.DisplayGUI();
        GUIModel mainPanel = new GUIModel();
        mainPanel.addEventHandlers(mainFrame.getFrame());
        GUIHelper.SetDisplay(mainFrame.getFrame(), mainPanel.getContentPanel(), "Cash For Metals Calculator");
    }
}
