package view.FahrzeugeWindow;
import javax.swing.*;

import controller.FahrzeugeController.NewMotorradController;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewMotorradWindow {
    
    JFrame _mainFrame;
    JPanel _mainPanel;
    JButton _addMotorradBtn;

    JTextField _tf_marke;
    JTextField _tf_typ;
    JTextField _tf_ps;
    JTextField _tf_reifenanzahl;

    NewMotorradController _mc;



    public NewMotorradWindow(NewMotorradController newMotorradController){
        setNewMotorradController(newMotorradController);
        setMainPanel(new JPanel());
        getMainPanel().setLayout(new FlowLayout());
        // Neues Hauptfenster erstellen
        setMainFrame(new JFrame());
        getMainFrame().setTitle("Neuen Motorrad erstellen");
        
        // Eingabefelder für das Auto erstellen
        JLabel l_marke = new JLabel("Marke");
        getMainPanel().add(l_marke);
        // Textfeld erstellen
        _tf_marke = new JTextField("", 15);
        // Textfeld dem Panel hinzufügen
        getMainPanel().add(_tf_marke);

        // Eingabefelder für das Auto erstellen
        JLabel l_ps = new JLabel("PS");
        getMainPanel().add(l_ps);
        // Textfeld erstellen
        _tf_ps = new JTextField("", 15);
        // Textfeld dem Panel hinzufügen
        getMainPanel().add(_tf_ps);

        // Eingabefelder für das Auto erstellen
        JLabel l_typ = new JLabel("Typ");
        getMainPanel().add(l_typ);
        // Textfeld erstellen
        _tf_typ = new JTextField("", 15);
        // Textfeld dem Panel hinzufügen
        getMainPanel().add(_tf_typ);

        // Eingabefelder für das Auto erstellen
        JLabel l_reifenanzahl = new JLabel("Reifenanzahl");
        getMainPanel().add(l_reifenanzahl);
        // Textfeld erstellen
        _tf_reifenanzahl = new JTextField("", 15);
        // Textfeld dem Panel hinzufügen
        getMainPanel().add(_tf_reifenanzahl);


        _addMotorradBtn = new JButton("Motorrad speichern");
        _addMotorradBtn.setBounds(0,0,0,0);
        _addMotorradBtn.addActionListener(new saveMotorradListener());
        getMainPanel().add(_addMotorradBtn);

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
    class saveMotorradListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == _addMotorradBtn){
                System.out.println("Motorrad speichern - Daten aktualisieren und in neue Ansicht wechseln.");
                System.out.println(_tf_marke.getText());
                System.out.println(_tf_ps.getText());
                System.out.println(_tf_typ.getText());
                System.out.println(_tf_reifenanzahl.getText());
                // Fenster ausblenden
                getMainFrame().setVisible(false);

                // Dem Controller die Daten übergeben
                getNewMotorradController().addNewMotorrad(_tf_marke.getText(), _tf_ps.getText(), _tf_typ.getText(), _tf_reifenanzahl.getText());
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

    public void setNewMotorradController(NewMotorradController _mc) {
        this._mc = _mc;
    }

    public NewMotorradController getNewMotorradController() {
        return _mc;
    }
}
