public class Program {
    public static void main(String[] args) {
        Banque banque = new Banque(0.80);
        Client client1 = new Client("Gilbert", 1);
        Client client2 = new Client("Emilie", 2);
        Client client3 = new Client("Michael", 3);

        banque.addClient(client1);
        banque.addClient(client2);
        banque.addClient(client3);
        banque.setTauxLivretA(0.75);
    }
}
