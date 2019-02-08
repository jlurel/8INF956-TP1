package constructeur;

public class Quizz implements QuizzMaster {
    private String type;
    private String question;
    private String [] choix;
    private int reponse;

    public Quizz(String type, String question, String choix1, String choix2, String choix3, String choix4, int reponse) {
        this.type = type;
        this.question = question;
        this.choix = new String[4];
        this.choix[0] = choix1;
        this.choix[1] = choix2;
        this.choix[2] = choix3;
        this.choix[3] = choix4;
        this.reponse = reponse;
    }

    @Override
    public String getQuestion() {
        return question;
    }

    @Override
    public String getChoix(int indice) {
        return choix[indice];
    }

    @Override
    public int getReponse() {
        return reponse;
    }

    @Override
    public String getType() {
        return type;
    }
}
