package setter;

public class Quizz implements QuizzMaster {
    private String type;
    private String question;
    private String [] choix;
    private int reponse;

    public Quizz() {
        this.choix = new String[4];
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setChoix(String[] choix) {
        this.choix = choix;
    }

    public void setReponse(int reponse) {
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
