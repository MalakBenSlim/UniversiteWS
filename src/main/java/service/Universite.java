package service;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import modele.Enseignant;
import modele.Etudiant;
import modele.Matiere;
import modele.Note;

import java.util.List;

@WebService(serviceName = "UniversiteService",
        portName = "UniversitePort",
        endpointInterface = "service.IUniversite",
        targetNamespace = "http://service/")
public class Universite implements IUniversite {


    private final List<Etudiant> etudiants = List.of(
            new Etudiant("E1", "Ben Ali", "Sami", "sami.benali@fss.tn", "LSI3"),
            new Etudiant("E2", "Trabelsi", "Amel", "amel.trabelsi@fss.tn", "LSI2"),
            new Etudiant("E3", "Gharbi", "Yassine", "yassine.gharbi@fss.tn", "LSI3"),
            new Etudiant("E4", "Mansouri", "Nour", "nour.mansouri@fss.tn", "LSI1"));

    private final List<Enseignant> enseignants = List.of(
            new Enseignant("T1", "Karray", "Mohamed", "Architecture logicielle"),
            new Enseignant("T2", "Chaabane", "Leila", "Bases de donnees"),
            new Enseignant("T3", "Jlassi", "Walid", "Programmation"));

    private final List<Matiere> matieres = List.of(
            new Matiere("M1", "Architecture SOA", 3, "T1"),
            new Matiere("M2", "Bases de donnees", 2, "T2"),
            new Matiere("M3", "Programmation Java", 3, "T3"));

    private final List<Note> notes = List.of(
            new Note("E1", "M1", 16),
            new Note("E1", "M2", 12.5),
            new Note("E2", "M1", 14),
            new Note("E3", "M1", 17.5),
            new Note("E3", "M3", 15),
            new Note("E4", "M2", 9));

    @Override
    @WebMethod(operationName = "etudiantsParNiveau")
    public List<Etudiant> etudiantsParNiveau(@WebParam(name = "niveau") String niveau) {
        if (niveau == null || !List.of("LSI1", "LSI2", "LSI3").contains(niveau)) {
            throw new IllegalArgumentException("Niveau invalide : LSI1, LSI2 ou LSI3 attendu");
        }
        return etudiants.stream().filter(e -> e.getNiveau().equals(niveau)).toList();
    }

    @Override
    @WebMethod(operationName = "listerEtudiants")
    public List<Etudiant> listerEtudiants() {
        return etudiants;
    }

    @Override
    @WebMethod(operationName = "listerEnseignants")
    public List<Enseignant> listerEnseignants() {
        return enseignants;
    }

    @Override
    @WebMethod(operationName = "enseignantParMatiere")
    public Enseignant enseignantParMatiere(@WebParam(name = "nom") String nom) {
        Matiere matiere = rechercherMatiere(nom);
        return enseignants.stream()
                .filter(t -> t.getId().equals(matiere.getEnseignantId()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Enseignant introuvable pour : " + nom));
    }

    @Override
    @WebMethod(operationName = "rechercherMatiere")
    public Matiere rechercherMatiere(@WebParam(name = "nom") String nom) {
        return matieres.stream()
                .filter(m -> m.getNom().equalsIgnoreCase(nom))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Matiere introuvable : " + nom));
    }

    @Override
    @WebMethod(operationName = "notesSuperieures")
    public List<Note> notesSuperieures(@WebParam(name = "seuil") double seuil) {
        return notes.stream().filter(n -> n.getValeur() >= seuil).toList();
    }
}
