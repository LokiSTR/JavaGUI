package controller;

import java.util.ArrayList;

import model.Auto;
import model.LKW;
import view.MainWindow;

public class MainController {

    MainWindow _mainWindow;
    ArrayList<Auto> _autos;
    ArrayList<LKW> _lkws;
    



    public MainController(){
        setAutos(new ArrayList<Auto>());
        setLKWs(new ArrayList<LKW>());

        // das this ist das schlüsselwort, dafür, dass das mainwindow aus der view im kontakt mit dem maincontroller steht, damit man auch mit model interagieren kann, so kann auch der controller auf die view zugreifen und anders herum
        setMainWindow(new MainWindow(this));
        //togglemainwindow schaltet um, ob das mainwindow sichtbar ist oder nicht
        getMainWindow().toggleMainWindow();
    }
    //changeview ändert die ansicht
    public void changeView(String target){
        System.out.println("Ansicht wechseln auf: " + target);

        getMainWindow().getMainFrame().setVisible(false);

        if(target == "newcarwindow"){
            new NewCarController(this);
        }
        else if(target == "mainwindow"){
            getMainWindow().getMainFrame().setVisible(true);
            getMainWindow().updateTable();
        }
        if(target == "newlkwwindow"){
            new NewLKWController(this);
        }
        else if(target == "mainwindow"){
            getMainWindow().getMainFrame().setVisible(true);
            getMainWindow().updateTable();
        }
    }
    //ein neues auto hinzufügen
    public void addNewCar(Auto a){
        getAutos().add(a);
        System.out.println("Neues Auto erstellt!");
    }

    //einen neuen lkw hinzufügen
    public void addNewLKW(LKW l){
        getLKWs().add(l);
        System.out.println("Neuen LKW erstellt!");
    }

    /**
     * 
     * SETTER UND GETTER
     */
    //Setter
    public void setMainWindow(MainWindow mainWindow) {
        this._mainWindow = mainWindow;
    }

    public void setAutos(ArrayList<Auto> _autos) {
        this._autos = _autos;
    }

    public void setLKWs(ArrayList<LKW> _lkws) {
        this._lkws = _lkws;
    }


    //Getter
    public ArrayList<LKW> getLKWs() {
        return _lkws;
    }

    public MainWindow getMainWindow() {
        return _mainWindow;
    }

    public ArrayList<Auto> getAutos() {
        return _autos;
    }

}
