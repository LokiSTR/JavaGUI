package view;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import controller.MainController;
import model.Fahrzeuge.Auto;
import model.Fahrzeuge.Fahrzeug;
import model.Fahrzeuge.LKW;
import model.Fahrzeuge.Motorrad;

import model.Personen.Kunde;
import model.Personen.Verkaeufer;
import model.Personen.Personen;

public class MainWindow {
    
    JFrame _mainFrame;
    JPanel _mainPanel;  
    JTable _carTable;
    JTable _lkwTable;
    JTable _motorradTable;
    JTable _kundeTable;
    JTable _verkaeuferTable;
    JButton _createCar;
    JButton _createLKW;
    JButton _createMotorrad;
    JButton _createKunde;
    JButton _createVerkaeufer;

    MainController _mc;


    public MainWindow(MainController mc){
        setMainController(mc);
        // Neues Hauptfenster erstellen (mainwindow wird von controller aus maincontroller erzeugt)
        _mainFrame = new JFrame();
        
        // Breite und Höhe des Fensters setzen
        _mainFrame.setSize(1300,300);
        createMainOverview();

        // Standard-Operation, wenn das Fenster geschlossen wird
        //heißt, damit man es schließen kann und nicht alles zusammen bricht muss man diese zeile hinzufügen
        _mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void createMainOverview(){        
        // Hauptpanel erstellen und Elemente für das MainWindow hinzufügen
        setMainPanel(new JPanel());
        getMainPanel().setLayout(new FlowLayout());

        

        _createCar = new JButton("Neues Auto");
        _createCar.setBounds(0,0,0,0);
        _createCar.addActionListener(new createFahrzeugListener());
        _createLKW = new JButton("Neuer LKW");
        _createLKW.setBounds(0,0,0,0);
        _createLKW.addActionListener(new createFahrzeugListener());
        _createMotorrad = new JButton("Neues Motorrad");
        _createMotorrad.setBounds(0,0,0,0);
        _createMotorrad.addActionListener(new createFahrzeugListener());
        _createKunde = new JButton("Neuer Kunde");
        _createKunde.setBounds(0,0,0,0);
        _createKunde.addActionListener(new createPersonenListener());
        _createVerkaeufer = new JButton("Neuer Verkaeufer");
        _createVerkaeufer.setBounds(0,0,0,0);
        _createVerkaeufer.addActionListener(new createPersonenListener());

        DefaultTableModel model = new DefaultTableModel(); 
        setCarTable(new JTable(model));
        setLKWTable(new JTable(model));
        setMotorradTable(new JTable(model));
        setKundeTable(new JTable(model));
        setVerkaeuferTable(new JTable(model));


        // Create a couple of columns 
        model.addColumn("Marke/Vorname"); 
        model.addColumn("PS/Nachname"); 
        model.addColumn("Typ/Alter"); 
        model.addColumn("Spezial");
        

        getMainPanel().add(getCarTable());
        getMainPanel().add(_createCar);
        getMainPanel().add(_createLKW);
        getMainPanel().add(_createMotorrad);
        getMainPanel().add(_createKunde);
        getMainPanel().add(_createVerkaeufer);

        //hier gibt es erst den inhalt des windows
        getMainFrame().add(getMainPanel());
    }

    public void updateTable(){
        // Autos laden

        DefaultTableModel model = (DefaultTableModel) getCarTable().getModel();

        // Entferne alle aktuellen Elemente
        // sorgt dafür, dass am ende alle zeilen leer sind, bzw die tabelle gelöscht wird, bei jedem weiteren hinzufügen würde alles, was bereits hinzugefügt wurde nochmal hinzugefügt
        for(int i = model.getRowCount()-1; i >= 0; i--){
            model.removeRow(i);
        }

        for(Fahrzeug a : getMainController().getFahrzeuge()){
            if(a instanceof Auto){
                Auto a_temp = (Auto) a;
                model.addRow(new Object[]{a_temp.getMarke(), a_temp.getPs(), a_temp.getTyp(), a_temp.getSitze()});
            }
            else if(a instanceof LKW){
                LKW a_temp = (LKW) a;
                model.addRow(new Object[]{a_temp.getMarke(), a_temp.getPs(), a_temp.getTyp(), a_temp.getLast()});
            }
            else if(a instanceof Motorrad){
                Motorrad a_temp = (Motorrad) a;
                model.addRow(new Object[]{a_temp.getMarke(), a_temp.getPs(), a_temp.getTyp(), a_temp.getReifenanzahl()});
            }
        }

        for(Personen b : getMainController().getPersonen()){
            if(b instanceof Kunde){
                Kunde b_temp = (Kunde) b;
                model.addRow(new Object[]{b_temp.getVorname(), b_temp.getNachname(), b_temp.getAlter(), b_temp.getKundennummer()});
            }
            else if(b instanceof Verkaeufer){
                Verkaeufer b_temp = (Verkaeufer) b;
                model.addRow(new Object[]{b_temp.getVorname(), b_temp.getNachname(), b_temp.getAlter(), b_temp.getPersonalnummer()});
            }
        }
    }

    // Zeigt oder versteckt (toggle) das Hauptfenster
    public void toggleMainWindow(){
        if(getMainFrame().isVisible()){
            getMainFrame().setVisible(false);
        }
        else{
            getMainFrame().setVisible(true);
        }
    }

    /**
     * 
     * Action Listener
     */

    //für auto

    //implements heißt, dass diese klasse auch beutzt werden muss
    class createFahrzeugListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == _createCar){
                System.out.println("Auto erstellen - wechsle Ansicht zu newCarWindow");
                getMainController().changeView("newcarwindow");
            }
            else if(e.getSource() == _createLKW){
                System.out.println("LKW erstellen - wechsle Ansicht zu newLKWWindow");
                getMainController().changeView("newlkwwindow");
            }
            else if(e.getSource() == _createMotorrad){
                System.out.println("Motorrad erstellen - wechsle Ansicht zu newMotorradWindow");
                getMainController().changeView("newmotorradwindow");
            }

        }
    }

<<<<<<< HEAD
    
    Fahrzeug maxPS;

    class createPSListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            
            //hier gibt es erst den inhalt des windows
            if(e.getSource() == _maxPS){
                System.out.println("MaxPS berechnen");
                //Version mit dem produkt
                for(Fahrzeug a : controller.MainController.getFahrzeuge()){
                    if(a.getPs() > maxPS.getPs()){
                    maxPS = a;
                    }
                }       
            System.out.println(maxPS.getMarke() + " " + maxPS.getPs());                    
            }
        }
    }

=======
>>>>>>> parent of 6bc3891 (maxPS azsgeben, mit fehlern)
    class createPersonenListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == _createKunde){
                System.out.println("Kunde erstellen - wechsle Ansicht zu newKundeWindow");
                getMainController().changeView("newkundewindow");
            }
            else if(e.getSource() == _createVerkaeufer){
                System.out.println("Verkäufer erstellen - wechsle Ansicht zu newVerkaeuferWindow");
                getMainController().changeView("newverkaeuferwindow");
            }
        }
    }
 
    /**
     * 
     * SETTER UND GETTER
     */

    //Getter
    public JFrame getMainFrame() {
        return _mainFrame;
    }

    public JTable getCarTable() {
        return _carTable;
    }

    public JTable getLKWTable() {
        return _lkwTable;
    }

    public JTable getMotorradTable() {
        return _motorradTable;
    }
    public JTable getKundeTable() {
        return _kundeTable;
    }
    public JTable getVerkaeuferTable() {
        return _verkaeuferTable;
    }
    
    public JPanel getMainPanel() {
        return _mainPanel;
    }

    //Setter
    public void setMainFrame(JFrame _mainFrame) {
        this._mainFrame = _mainFrame;
    }

    public void setCarTable(JTable _carTable) {
        this._carTable = _carTable;
    }

    public void setLKWTable(JTable _lkwTable) {
        this._lkwTable = _lkwTable;
    }

    public void setMotorradTable(JTable _motorradTable) {
        this._motorradTable = _motorradTable;
    }
    public void setKundeTable(JTable kundeTable) {
        this._kundeTable = kundeTable;
    }
    public void setVerkaeuferTable(JTable verkaeuferTable) {
        this._verkaeuferTable = verkaeuferTable;
    }

    public void setMainPanel(JPanel _mainPanel) {
        this._mainPanel = _mainPanel;
    }

    public void setMainController(MainController _mc) {
        this._mc = _mc;
    }

    public MainController getMainController() {
        return _mc;
    }
}
