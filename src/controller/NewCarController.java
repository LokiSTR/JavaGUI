package controller;

import model.Auto;
import view.NewCarWindow;

public class NewCarController {

    NewCarWindow _newCarWindow;
    MainController _mc;

    public NewCarController(MainController mc){
        setNewCarWindow(new NewCarWindow(this));
        setMainController(mc);
    }


    public void addNewCar(String marke, String ps, String typ, String sitze){
        // Neues Objekt vom Typ Auto erstellen und dieses dem Maincontroller mitgeben
        Auto a = new Auto(marke, Integer.parseInt(ps), typ, Integer.parseInt(sitze));
        getMainController().addNewCar(a);

        // Nachdem das Auto erstellt wurde kümmert sich der Controller um den Wechsel der Ansicht.
        getMainController().changeView("mainwindow");
    }

    /**
     * 
     * SETTER UND GETTER
     */
    public void setNewCarWindow(NewCarWindow mainWindow) {
        this._newCarWindow = mainWindow;
    }

    public NewCarWindow getNewCarWindow() {
        return _newCarWindow;
    }

    public MainController getMainController() {
        return _mc;
    }

    public void setMainController(MainController _mc) {
        this._mc = _mc;
    }
    
}
