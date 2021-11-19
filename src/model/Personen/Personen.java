package model.Personen;

public class Personen {
    String _vorname;
    String _nachname;
    int _alter;


    public Personen(String vorname, String nachname, int alter){
        setVorname(vorname);
        setNachname(nachname);
        setAlter(alter);
    }
    public void setNachname(String _nachname) {
        this._nachname = _nachname;
    }
    public void setVorname(String _vorname) {
        this._vorname = _vorname;
    }
    public void setAlter(int _alter) {
        this._alter = _alter;
    }
    public String getNachname() {
        return _nachname;
    }
    public String getVorname() {
        return _vorname;
    }
    public int getAlter() {
        return _alter;
    }

}
