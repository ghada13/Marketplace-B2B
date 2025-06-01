package tniteam.marketplaceb2b;

import jakarta.xml.ws.Endpoint;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tniteam.marketplaceb2b.Soap.PersonneSoap;

@SpringBootApplication
public class MarketplaceB2bApplication {

    public static void main(String[] args) {
        SpringApplication.run(MarketplaceB2bApplication.class, args);

        // URL for WSDL deployment
        String url = "http://localhost:8085/PersonneWS";

        try {
            PersonneSoap personneSoap = new PersonneSoap();
            Endpoint.publish(url, personneSoap);
            System.out.println("Personne Soap is running at " + url);
        } catch (Exception e) {
            System.err.println("Failed to publish SOAP endpoint at " + url + ": " + e.getMessage());
            e.printStackTrace();
        }
    }
}