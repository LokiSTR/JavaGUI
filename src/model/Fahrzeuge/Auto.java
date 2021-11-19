package model.Fahrzeuge;

public class Auto extends Fahrzeug{

    int _sitze;

    public Auto(String marke, int ps, String typ, int sitze) {
        super(marke, ps, typ);
        setSitze(sitze);

    }

    public void setSitze(int _sitze) {
        this._sitze = _sitze;
    }
    public int getSitze() {
        return _sitze;
    }
}
