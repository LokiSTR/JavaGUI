package model.Fahrzeuge;

public class Fahrzeug {
    String _marke;
    int _ps;
    String _typ;
    

    public Fahrzeug(String marke, int ps, String typ){
        setMarke(marke);
        setPs(ps);
        setTyp(typ);
    }

    /**
     * 
     * SETTER UND GETTER
     */
    public String getMarke() {
        return _marke;
    }

    public int getPs() {
        return _ps;
    }

    public String getTyp() {
        return _typ;
    }

    public void setMarke(String marke) {
        this._marke = marke;
    }

    public void setPs(int ps) {
        this._ps = ps;
    }

    public void setTyp(String typ) {
        this._typ = typ;
    }

}
