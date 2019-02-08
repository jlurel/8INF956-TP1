package setter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class QuizzMasterService {
    private JFrame ecran;
    private JRadioButton [] lesBoutons;
    private QuizzMaster quizzMaster;

    public void lancer()
    {
        this.ecran = new JFrame();
        lesBoutons = new JRadioButton [4];
        ecran.setSize( 450, 200 );
        this.ecran.setTitle(quizzMaster.getType());
        // Fermeture de la fenêtre
        ecran.addWindowListener( new WindowAdapter() {
            public void windowClosing( WindowEvent we ) {
                QuizzMasterService.this.terminer();
            }
        } );
        // Le panneau central
        JPanel panneauCentral = new JPanel( new BorderLayout() );
        ecran.add( panneauCentral );
        ActionListener listener = new ActionListener() {
            public void actionPerformed (ActionEvent e) {
                AbstractButton aButton = (AbstractButton) e.getSource();
                String message=aButton.getText();
                if(message.equals(quizzMaster.getChoix(quizzMaster.getReponse())))
                    JOptionPane.showMessageDialog( ecran, "Bonne réponse" );
                else
                    JOptionPane.showMessageDialog( ecran, "Mauvaise réponse" );

            };
        };
        JPanel panneauQuestion= new JPanel( new FlowLayout( FlowLayout.LEADING ) );
        panneauQuestion.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder()));
        JLabel monlabel=new JLabel(quizzMaster.getQuestion());
        panneauQuestion.add(monlabel);
        panneauCentral.add( panneauQuestion, BorderLayout.NORTH );
        JPanel panneauChoix = new JPanel( new FlowLayout( FlowLayout.LEFT ) );
        ButtonGroup groupe = new ButtonGroup ();
        for(int i=0; i<4; i++)
        {
            lesBoutons[i] = new JRadioButton (quizzMaster.getChoix(i));
            groupe.add(lesBoutons[i]);
            panneauChoix.add(lesBoutons[i]);
            lesBoutons[i].addActionListener(listener);
        }
        panneauCentral.add( panneauChoix, BorderLayout.CENTER);
        ecran.setVisible( true );
    }

    private void terminer() {

        this.ecran.dispose();
        System.exit( 0 );
    }

    public void setQuizzMaster(QuizzMaster quizzMaster) {
        this.quizzMaster = quizzMaster;
    }

    public QuizzMaster getQuizzMaster() {
        return quizzMaster;
    }
}
