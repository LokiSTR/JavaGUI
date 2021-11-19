package controller.FahrzeugeController;

import controller.MainController;
import model.Fahrzeuge.Motorrad;
import view.FahrzeugeWindow.NewMotorradWindow;

public class NewMotorradController {

    NewMotorradWindow _NewMotorradWindow;
    MainController _mc;

    public NewMotorradController(MainController mc){
        setNewMotorradWindow(new NewMotorradWindow(this));
        setMainController(mc);
    }


    public void addNewMotorrad(String marke, String ps, String typ, String reifenanzahl){
        // Neues Objekt vom Typ Auto erstellen und dieses dem Maincontroller mitgeben
        Motorrad m = new Motorrad(marke, Integer.parseInt(ps), typ, Integer.parseInt(reifenanzahl));
        getMainController().addNewMotorrad(m);

        // Nachdem das Auto erstellt wurde kümmert sich der Controller um den Wechsel der Ansicht.
        getMainController().changeView("mainwindow");
    }

    /**
     * 
     * SETTER UND GETTER
     */
    public void setNewMotorradWindow(NewMotorradWindow mainWindow) {
        this._NewMotorradWindow = mainWindow;
    }

    public NewMotorradWindow getNewMotorradWindow() {
        return _NewMotorradWindow;
    }

    public MainController getMainController() {
        return _mc;
    }

    public void setMainController(MainController _mc) {
        this._mc = _mc;
    }
    
}