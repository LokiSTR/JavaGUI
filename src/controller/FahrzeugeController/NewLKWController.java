package controller.FahrzeugeController;

import controller.MainController;
import model.Fahrzeuge.LKW;
import view.FahrzeugeWindow.NewLKWWindow;

public class NewLKWController {

    NewLKWWindow _NewLKWWindow;
    MainController _mc;

    public NewLKWController(MainController mc){
        setNewLKWWindow(new NewLKWWindow(this));
        setMainController(mc);
    }


    public void addNewLKW(String marke, String ps, String typ, String last){
        // Neues Objekt vom Typ Auto erstellen und dieses dem Maincontroller mitgeben
        LKW l = new LKW(marke, Integer.parseInt(ps), typ, Integer.parseInt(last));
        getMainController().addNewLKW(l);

        // Nachdem das Auto erstellt wurde kümmert sich der Controller um den Wechsel der Ansicht.
        getMainController().changeView("mainwindow");
    }

    /**
     * 
     * SETTER UND GETTER
     */
    public void setNewLKWWindow(NewLKWWindow mainWindow) {
        this._NewLKWWindow = mainWindow;
    }

    public NewLKWWindow getNewLKWWindow() {
        return _NewLKWWindow;
    }

    public MainController getMainController() {
        return _mc;
    }

    public void setMainController(MainController _mc) {
        this._mc = _mc;
    }
    
}