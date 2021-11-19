package model.Personen;

public class Verkaeufer extends Personen {

    public Verkaeufer(String vorname, String nachname, int personalnummer, int alter) {
        super(vorname, nachname, alter);
        setPersonalnummer(personalnummer);
    }
    int _personalnummer;

    public int getPersonalnummer() {
        return _personalnummer;
    }
    public void setPersonalnummer(int _personalnummer) {
        this._personalnummer = _personalnummer;
    }
    
}
