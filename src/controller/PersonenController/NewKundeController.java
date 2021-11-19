package controller.PersonenController;

import controller.MainController;
import model.Personen.Kunde;
import view.PersonenWindow.NewKundeWindow;

public class NewKundeController {

    NewKundeWindow _newKundeWindow;
    MainController _mc;

    public NewKundeController(MainController mc){
        setNewKundeWindow(new NewKundeWindow(this));
        setMainController(mc);
    }


    public void addNewKunde(String vorname, String nachname, String kundennummer, String alter){
        Kunde b = new Kunde(vorname, nachname, Integer.parseInt(kundennummer), Integer.parseInt(alter));

        getMainController().addNewKunde(b);

        // Nachdem das Auto erstellt wurde kümmert sich der Controller um den Wechsel der Ansicht.
        getMainController().changeView("mainwindow");
    }

    /**
     * 
     * SETTER UND GETTER
     */
    public void setNewKundeWindow(NewKundeWindow mainWindow) {
        this._newKundeWindow = mainWindow;
    }

    public NewKundeWindow getNewKundeWindow() {
        return _newKundeWindow;
    }

    public MainController getMainController() {
        return _mc;
    }

    public void setMainController(MainController _mc) {
        this._mc = _mc;
    }
    
}
