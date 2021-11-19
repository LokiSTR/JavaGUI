package controller.PersonenController;

import controller.MainController;
import model.Personen.Verkaeufer;
import view.PersonenWindow.NewVerkaeuferWindow;

public class NewVerkaeuferController {

    NewVerkaeuferWindow _newVerkaeuferWindow;
    MainController _mc;

    public NewVerkaeuferController(MainController mc){
        setNewVerkaeuferWindow(new NewVerkaeuferWindow(this));
        setMainController(mc);
    }


    public void addNewVerkaeufer(String vorname, String nachname, String personalnummer, String alter){
        Verkaeufer b = new Verkaeufer(vorname, nachname, Integer.parseInt(personalnummer), Integer.parseInt(alter));

        getMainController().addNewVerkaeufer(b);

        // Nachdem das Auto erstellt wurde kümmert sich der Controller um den Wechsel der Ansicht.
        getMainController().changeView("mainwindow");
    }

    /**
     * 
     * SETTER UND GETTER
     */
    public void setNewVerkaeuferWindow(NewVerkaeuferWindow mainWindow) {
        this._newVerkaeuferWindow = mainWindow;
    }

    public NewVerkaeuferWindow getNewVerkaeuferWindow() {
        return _newVerkaeuferWindow;
    }

    public MainController getMainController() {
        return _mc;
    }

    public void setMainController(MainController _mc) {
        this._mc = _mc;
    }
    
}
