package BigProject.services;

import BigProject.services.model.Client;

import java.io.IOException;
import java.util.List;

public interface ClientService {

    void addClient() throws IOException;

    void editClient(int indexId, String editParam) throws IOException;

    void removeClient(int indexId);

    void showClientsList();

    int getReadId() throws IOException;

    List<Client> getClients();
}