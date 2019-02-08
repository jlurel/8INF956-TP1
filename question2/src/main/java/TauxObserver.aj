public aspect TauxObserver extends ObserverProtocol {

    declare parents: Banque implements Subject;
    declare parents: Client implements Observer;

    protected pointcut subjectChange(Subject s):
            (call(void Banque.setTauxLivretA(double))) && target(s);

    protected void updateObserver(Subject s, Observer o) {
        double nouveauTaux = ((Banque) s).getTauxLivretA();
        String nomClient = ((Client) o).getNom();
        String output = String.format("%s - Nouveau taux pour le livret A : %f", nomClient, nouveauTaux);
        System.out.println(output);
    }

    after (Banque banque): target(banque) && call(void addClient(..)) {
        int addedClientId = banque.getNbClients() - 1;
        Client client = banque.getClient(addedClientId);
        TauxObserver.aspectOf().addObserver((Subject) banque, (Observer) client);
    }
}
