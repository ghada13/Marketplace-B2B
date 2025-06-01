package tniteam.marketplaceb2b.Soap;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import tniteam.marketplaceb2b.model.Personne;


import java.util.ArrayList;
import java.util.List;

@WebService(serviceName = "PersonneWS")
public class PersonneSoap {

    private List<Personne> personnes = new ArrayList<>();

    // Ajouter une personne
    @WebMethod(operationName = "ajouterPersonne")
    public String ajouterPersonne(@WebParam(name = "id") int id,
                                  @WebParam(name = "nom") String nom,
                                  @WebParam(name = "prenom") String prenom) {
        Personne personne = new Personne(id, nom, prenom); // Create a new Personne object
        personnes.add(personne); // Add to the list
        return "Ajouté : " + prenom + " " + nom + " (ID: " + id + ")";
    }

    // Récupérer une personne par son ID
    @WebMethod
    public Personne getPersonne(@WebParam(name = "id") int id) {
        for (Personne personne : personnes) {
            if (personne.getId() == id) {
                return personne;
            }
        }
        return null; // Si la personne n'existe pas
    }

    // Supprimer une personne par son ID
    @WebMethod
    public String deletePersonne(@WebParam(name = "id") int id) {
        for (Personne personne : personnes) {
            if (personne.getId() == id) {
                personnes.remove(personne);
                return "Personne supprimée avec succès";
            }
        }
        return "Personne non trouvée";
    }

    // Mettre à jour les informations d'une personne
    @WebMethod
    public String updatePersonne(@WebParam(name = "personne") Personne updatedPersonne) {
        for (Personne personne : personnes) {
            if (personne.getId() == updatedPersonne.getId()) {
                personne.setNom(updatedPersonne.getNom());
                personne.setPrenom(updatedPersonne.getPrenom());
                return "Personne mise à jour avec succès";
            }
        }
        return "Personne non trouvée";
    }
}