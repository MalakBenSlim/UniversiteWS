package modele;

public class Etudiant {
    private String id;
    private String nom;
    private String prenom;
    private String email;
    private String niveau;

    public Etudiant() { }   // obligatoire pour JAXB

    public Etudiant(String id, String nom, String prenom, String email, String niveau) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.niveau = niveau;
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
    public String getPrenom() {

        return prenom;
    }
    public void setPrenom(String prenom) {

        this.prenom = prenom;
    }
    public String getEmail() {

        return email;
    }
    public void setEmail(String email) {

        this.email = email;
    }
    public String getNiveau() {

        return niveau;
    }
    public void setNiveau(String niveau) {

        this.niveau = niveau;
    }
}
