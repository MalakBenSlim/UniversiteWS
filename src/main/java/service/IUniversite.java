package service;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import modele.Enseignant;
import modele.Etudiant;
import modele.Matiere;
import modele.Note;

import java.util.List;

@WebService(name = "IUniversite", targetNamespace = "http://service/")
public interface IUniversite {

    @WebMethod(operationName = "etudiantsParNiveau")
    List<Etudiant> etudiantsParNiveau(@WebParam(name = "niveau") String niveau);

    @WebMethod(operationName = "listerEtudiants")
    List<Etudiant> listerEtudiants();

    @WebMethod(operationName = "listerEnseignants")
    List<Enseignant> listerEnseignants();

    @WebMethod(operationName = "enseignantParMatiere")
    Enseignant enseignantParMatiere(@WebParam(name = "nom") String nom);

    @WebMethod(operationName = "rechercherMatiere")
    Matiere rechercherMatiere(@WebParam(name = "nom") String nom);

    @WebMethod(operationName = "notesSuperieures")
    List<Note> notesSuperieures(@WebParam(name = "seuil") double seuil);
}
