package ua.goit;

import ua.goit.service.ClientService;
import ua.goit.service.DatabaseQueryService;
import ua.goit.service.entity.Client;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {

        ClientService clientService = new ClientService();
        long it_company = clientService.create("My company");
        System.out.println("it_company = " + it_company);
        System.out.println("clientService.getById(it_company) = " + clientService.getById(it_company));
        clientService.setName(it_company, "My second Company");
        System.out.println("clientService.getById(it_company) after update = " + clientService.getById(it_company));
        clientService.deleteById(it_company);
        List<Client> clients = clientService.listAll();
        System.out.println("clients = " + clients);
    }
}
