package view;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import controller.MainController;
import model.Auto;
import model.LKW;

public class MainWindow {
    
    JFrame _mainFrame;
    JPanel _mainPanel;
    JTable _carTable;
    JTable _lkwTable;
    JButton _createCar;
    JButton _createLKW;

    MainController _mc;


    public MainWindow(MainController mc){
        setMainController(mc);
        // Neues Hauptfenster erstellen (mainwindow wird von controller aus maincontroller erzeugt)
        _mainFrame = new JFrame();
        
        // Breite und Höhe des Fensters setzen
        _mainFrame.setSize(600,400);
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
        _createCar.addActionListener(new createCarListener());
        _createLKW = new JButton("Neuer LKW");
        _createLKW.setBounds(0,0,0,0);
        _createLKW.addActionListener(new createLKWListener());

        DefaultTableModel model = new DefaultTableModel(); 
        setCarTable(new JTable(model));
        setLKWTable(new JTable(model));

        // Create a couple of columns 
        model.addColumn("Marke"); 
        model.addColumn("PS"); 
        model.addColumn("Typ"); 
        model.addColumn("Sitze");
        model.addColumn("Last");

        getMainPanel().add(getCarTable());
        getMainPanel().add(_createCar);
        getMainPanel().add(_createLKW);

        //hier gibt es erst den inhalt des windows
        getMainFrame().add(getMainPanel());
    }

    public void updateTable(){
        // Autos laden

        DefaultTableModel model = (DefaultTableModel) getCarTable().getModel();

        // Entferne alle aktuellen Elemente
        // model.getrowcount()-1 die 1 steht für die anzahl an zeilen, die hinzugefügt wird
        for(int i = model.getRowCount()-1; i >= 0; i--){
            model.removeRow(i);
        }

        for(Auto a : getMainController().getAutos()){
            model.addRow(new Object[]{a.getMarke(), a.getPs(), a.getTyp(), a.getSitze()});
        }

        // LKWs laden
        //Entferne alle aktuellen Elemente
        

        for(LKW l : getMainController().getLKWs()){
            model.addRow(new Object[]{l.getMarke(), l.getPs(), l.getTyp(), l.getLast()});
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

    class createCarListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == _createCar){
                System.out.println("Auto erstellen - wechsle Ansicht zu newCarWindow");
                getMainController().changeView("newcarwindow");
            }
        }
    }


    //für lkw

    class createLKWListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == _createLKW){
                System.out.println("LKW erstellen - wechsle Ansicht zu newLKWWindow");
                getMainController().changeView("newlkwwindow");
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
