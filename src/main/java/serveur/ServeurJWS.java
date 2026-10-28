package serveur;

import jakarta.xml.ws.Endpoint;
import service.Universite;

public class ServeurJWS {
    public static void main(String[] args) {
        String url = "http://localhost:8089/universite";
        Endpoint.publish(url, new Universite());
        System.out.println("Service publie sur : " + url);
        System.out.println("WSDL : " + url + "?wsdl");
    }
}
