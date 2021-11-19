package controller;

import java.util.ArrayList;

import model.Auto;
import model.Fahrzeug;
import model.LKW;
import model.Motorrad;
import view.MainWindow;

public class MainController {

    MainWindow _mainWindow;
    ArrayList<Fahrzeug> _fahrzeuge;




    public MainController(){
        setFahrzeuge(new ArrayList<Fahrzeug>());

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
        getFahrzeuge().add(a);
        System.out.println("Neues Auto erstellt!");
    }

    //einen neuen lkw hinzufügen
    public void addNewLKW(LKW a){
        getFahrzeuge().add(a);
        System.out.println("Neuen LKW erstellt!");
    }

    //ein neues motorrad hinzufügen
    public void addNewMotorrad(Motorrad a){
        getFahrzeuge().add(a);
        System.out.println("Neues Motorrad erstellt!");
    }

    /**
     * 
     * SETTER UND GETTER
     */
    //Setter
    public void setMainWindow(MainWindow mainWindow) {
        this._mainWindow = mainWindow;
    }

    public void setFahrzeuge(ArrayList<Fahrzeug> _fahrzeuge) {
        this._fahrzeuge = _fahrzeuge;
    }


    //Getter
    public MainWindow getMainWindow() {
        return _mainWindow;
    }

    public ArrayList<Fahrzeug> getFahrzeuge() {
        return _fahrzeuge;
    }

}
