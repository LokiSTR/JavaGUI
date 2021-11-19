package model.Personen;

public class Kunde extends Personen{

    int _kundennummer;

    public Kunde(String vorname, String nachname, int kundennummer, int alter) {
        super(vorname, nachname, alter);
        setKundennummer(kundennummer);
    }

    public void setKundennummer(int _kundennummer) {
        this._kundennummer = _kundennummer;
    }
    public int getKundennummer() {
        return _kundennummer;
    }
    
}