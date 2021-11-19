package model.Fahrzeuge;

public class Motorrad extends Fahrzeug{
    
    public Motorrad(String marke, int ps, String typ, int reifenanzahl) {
        super(marke, ps, typ);
        setReifenanzahl(reifenanzahl);
    }

    int _reifenanzahl;



    public void setReifenanzahl(int _reifenanzahl) {
        this._reifenanzahl = _reifenanzahl;
    }

    public int getReifenanzahl() {
        return _reifenanzahl;
    }


}
