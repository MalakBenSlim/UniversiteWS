package modele;

public class Note {
    private String etudiantId;
    private String matiereId;
    private double valeur;

    public Note() { }   // obligatoire pour JAXB

    public Note(String etudiantId, String matiereId, double valeur) {
        this.etudiantId = etudiantId;
        this.matiereId = matiereId;
        this.valeur = valeur;
    }

    public String getEtudiantId() {
        return etudiantId;
    }
    public void setEtudiantId(String etudiantId) {
        this.etudiantId = etudiantId;
    }
    public String getMatiereId() {
        return matiereId;
    }
    public void setMatiereId(String matiereId) {
        this.matiereId = matiereId;
    }
    public double getValeur() {
        return valeur;
    }
    public void setValeur(double valeur) {
        this.valeur = valeur;
    }
}
