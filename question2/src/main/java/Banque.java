import java.util.ArrayList;
import java.util.List;

public class Banque {
    private List<Client> clients;
    private List<Client> anciensClients;
    private double tauxLivretA;

    public Banque(double tauxLivretA) {
        this.tauxLivretA = tauxLivretA;
        this.clients = new ArrayList<>();
        this.anciensClients = new ArrayList<>();
    }

    public Client getClient(int id) {
        return this.clients.get(id);
    }

    public Client getAncienClient(int id) {
        return this.anciensClients.get(id);
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public double getTauxLivretA() {
        return tauxLivretA;
    }

    public void setTauxLivretA(double tauxLivretA) {
        this.tauxLivretA = tauxLivretA;
    }

    public void addClient(Client client) {
        this.clients.add(client);
    }

    public void removeClient(Client client) {
        this.clients.remove(client);
        this.anciensClients.add(client);
    }

    public int getNbClients() {
        return this.clients.size();
    }

    public int getNbAnciensClients() {
        return this.anciensClients.size();
    }
}
