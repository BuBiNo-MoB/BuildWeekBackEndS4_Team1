package it.epicode.entities.travel_documents_managment;


import it.epicode.entities.constants.Tables;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = Tables.Names.AUTHORIZED_RETAILER)
@DiscriminatorValue(Tables.Discriminators.AUTHORIZED_RETAILER)
public class AuthorizedRetailer extends TravelDocumentsManager {

    public AuthorizedRetailer() {
    }

    @Override
    public String toString() {
        return "AuthorizedRetailer{" + super.toString() + "}";
    }
}
