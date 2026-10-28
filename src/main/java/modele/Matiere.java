package modele;

public class Matiere {
    private String id;
    private String nom;
    private double coefficient;
    private String enseignantId;   // enseignant responsable

    public Matiere() { }   // obligatoire pour JAXB

    public Matiere(String id, String nom, double coefficient, String enseignantId) {
        this.id = id;
        this.nom = nom;
        this.coefficient = coefficient;
        this.enseignantId = enseignantId;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public double getCoefficient() {
        return coefficient;
    }
    public void setCoefficient(double coefficient) {
        this.coefficient = coefficient;
    }
    public String getEnseignantId() {
        return enseignantId;
    }
    public void setEnseignantId(String enseignantId) {
        this.enseignantId = enseignantId;
    }
}