package model.Fahrzeuge;

public class LKW extends Fahrzeug {
    
    public LKW(String marke, int ps, String typ, int last) {
        super(marke, ps, typ);
        setLast(last);
    }

    int _last;

    public void setLast(int _last) {
        this._last = _last;
    }
    public int getLast() {
        return _last;
    }
    
}
