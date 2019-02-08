public class Client {
    private String nom;
    private int numClient;

    public Client(String nom, int numClient) {
        this.nom = nom;
        this.numClient = numClient;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getNumClient() {
        return numClient;
    }

    public void setNumClient(int numClient) {
        this.numClient = numClient;
    }
}
