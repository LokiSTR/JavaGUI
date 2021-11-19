package controller;

import java.util.ArrayList;

import controller.FahrzeugeController.NewCarController;
import controller.FahrzeugeController.NewLKWController;
import controller.FahrzeugeController.NewMotorradController;
import model.Fahrzeuge.Auto;
import model.Fahrzeuge.Fahrzeug;
import model.Fahrzeuge.LKW;
import model.Fahrzeuge.Motorrad;

import controller.PersonenController.NewKundeController;
import controller.PersonenController.NewVerkaeuferController;

import model.Personen.Kunde;
import model.Personen.Verkaeufer;
import model.Personen.Personen;

import view.MainWindow;

public class MainController {

    MainWindow _mainWindow;
    ArrayList<Fahrzeug> _fahrzeuge;
    ArrayList<Personen> _personen;




    public MainController(){
        setFahrzeuge(new ArrayList<Fahrzeug>());
        setPersonen(new ArrayList<Personen>());

        // das this ist das schlüsselwort, dafür, dass das mainwindow aus der view im kontakt mit dem maincontroller steht, damit man auch mit model interagieren kann, so kann auch der controller auf die view zugreifen und anders herum
        setMainWindow(new MainWindow(this));
        //togglemainwindow schaltet um, ob das mainwindow sichtbar ist oder nicht
        getMainWindow().toggleMainWindow();
    }
    //changeview ändert die ansicht
    public void changeView(String target){
        System.out.println("Ansicht wechseln auf: " + target);

        getMainWindow().getMainFrame().setVisible(false);

        //auto
        if(target == "newcarwindow"){
            new NewCarController(this);
        }
        else if(target == "newlkwwindow"){
            new NewLKWController(this);
        }
        else if(target == "newmotorradwindow"){
            new NewMotorradController(this);
        }
        else if(target == "newkundewindow"){
            new NewKundeController(this);
        }
        else if(target == "newverkaeuferwindow"){
            new NewVerkaeuferController(this);
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

    //einen neuen kunden hinzufügen
    public void addNewKunde(Kunde b){
        getPersonen().add(b);
        System.out.println("Neuer Kunde erstellt!");
    }

    //ein neues motorrad hinzufügen
    public void addNewVerkaeufer(Verkaeufer b){
        getPersonen().add(b);
        System.out.println("Neuer Verkaeufer erstellt!");
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
    public void setPersonen(ArrayList<Personen> _personen) {
        this._personen = _personen;
    }

    //Getter
    public MainWindow getMainWindow() {
        return _mainWindow;
    }

    public ArrayList<Fahrzeug> getFahrzeuge() {
        return _fahrzeuge;
    }
    public ArrayList<Personen> getPersonen() {
        return _personen;
    }

}
