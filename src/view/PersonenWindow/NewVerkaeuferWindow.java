package view.PersonenWindow;

import javax.swing.*;

import controller.PersonenController.NewVerkaeuferController;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewVerkaeuferWindow {
    
    JFrame _mainFrame;
    JPanel _mainPanel;
    JButton _addVerkaeuferBtn;

    JTextField _tf_vorname;
    JTextField _tf_nachname;
    JTextField _tf_alter;
    JTextField _tf_personalnnummer;
    

    NewVerkaeuferController _mc;

    public NewVerkaeuferWindow(NewVerkaeuferController newVerkaeuferController){
        setNewVerkaeuferController(newVerkaeuferController);
        setMainPanel(new JPanel());
        getMainPanel().setLayout(new FlowLayout());
        // Neues Hauptfenster erstellen
        setMainFrame(new JFrame());
        getMainFrame().setTitle("Neuen Verkäufer erstellen");
        
        // Eingabefelder für den Verkaeufer erstellen
        JLabel l_vorname = new JLabel("Vorname");
        getMainPanel().add(l_vorname);
        // Textfeld erstellen
        _tf_vorname = new JTextField("", 15);
        // Textfeld dem Panel hinzufügen
        getMainPanel().add(_tf_vorname);

        // Eingabefelder für den Kunden erstellen
        JLabel l_nachname = new JLabel("Nachname");
        getMainPanel().add(l_nachname);
        // Textfeld erstellen
        _tf_nachname = new JTextField("", 15);
        // Textfeld dem Panel hinzufügen
        getMainPanel().add(_tf_nachname);

        // Eingabefelder für den Kunden erstellen
        JLabel l_alter = new JLabel("Alter");
        getMainPanel().add(l_alter);
        // Textfeld erstellen
        _tf_alter = new JTextField("", 15);
        // Textfeld dem Panel hinzufügen
        getMainPanel().add(_tf_alter);

        // Eingabefelder für den Kunden erstellen
        JLabel l_personalnummer = new JLabel("Personalnummer");
        getMainPanel().add(l_personalnummer);
        // Textfeld erstellen
        _tf_personalnnummer = new JTextField("", 15);
        // Textfeld dem Panel hinzufügen
        getMainPanel().add(_tf_personalnnummer);



        _addVerkaeuferBtn = new JButton("Verkäufer speichern");
        _addVerkaeuferBtn.setBounds(0,0,0,0);
        _addVerkaeuferBtn.addActionListener(new saveVerkaeuferListener());
        getMainPanel().add(_addVerkaeuferBtn);

        // Breite und Höhe des Fensters setzen
        getMainFrame().setSize(800,100);

        // Fenster anzeigen
        getMainFrame().setVisible(true);
        
        // Standard-Operation, wenn das Fenster geschlossen wird
        getMainFrame().setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        getMainFrame().add(getMainPanel());
    }

     /**
     * 
     * Action Listener
     */
    class saveVerkaeuferListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == _addVerkaeuferBtn){
                System.out.println("Verkäufer speichern - Daten aktualisieren und in neue Ansicht wechseln.");
                System.out.println(_tf_vorname.getText());
                System.out.println(_tf_nachname.getText());
                System.out.println(_tf_alter.getText());
                System.out.println(_tf_personalnnummer.getText());
                // Fenster ausblenden
                getMainFrame().setVisible(false);

                // Dem Controller die Daten übergeben
                getNewVerkaeuferController().addNewVerkaeufer(_tf_vorname.getText(), _tf_nachname.getText(),  _tf_alter.getText(),_tf_personalnnummer.getText());
            }
        }
    }


     /**
     * 
     * SETTER UND GETTER
     */
    public JFrame getMainFrame() {
        return _mainFrame;
    }

    public void setMainFrame(JFrame _mainFrame) {
        this._mainFrame = _mainFrame;
    }

    public void setMainPanel(JPanel _mainPanel) {
        this._mainPanel = _mainPanel;
    }

    public JPanel getMainPanel() {
        return _mainPanel;
    }

    public void setNewVerkaeuferController(NewVerkaeuferController _mc) {
        this._mc = _mc;
    }

    public NewVerkaeuferController getNewVerkaeuferController() {
        return _mc;
    }
}
