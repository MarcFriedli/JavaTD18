package ch.dlm.td18;

/**
 * @Author : Marc Friedli
 * 
 * Héritage de JFrame qui positionne les différents éléments du programme.
 * C'est également le seul Observer. Gère la sélection du dossier
 */

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MyJFrame extends JFrame implements Observer
{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    private File file;
    private SelectZone selectZone;
    private MyMenu myMenu;
    private JButton startButton;
    private MySwingWorker mySwingWorker;
    private JLabel answerLabel;
    private JPanel imAPanel;

    public MyJFrame()
    {
        setDefaultCloseOperation(EXIT_ON_CLOSE); //Tue le thread lorsqu'on clique sur la croix rouge
        setTitle("File counter");
        setSize(600,300); //Donne juste les dimensions de la fenêtre
        setLocationRelativeTo(null); //positionne la fenêtre au centre

        //Déclaration des différents éléments du programme
        myMenu = new MyMenu();
        selectZone = new SelectZone();
        imAPanel = new JPanel();
        startButton = new JButton("Start");
        answerLabel = new JLabel("Sélectionnez un répertoire svp");
        mySwingWorker = new MySwingWorker();
        
        //Instensiation du menu
        this.setJMenuBar(myMenu);
        
        //Layouts
        imAPanel.add(startButton);
        this.setLayout(new BorderLayout());
        this.add(selectZone,BorderLayout.NORTH);
        this.add(imAPanel,BorderLayout.CENTER);
        this.add(answerLabel,BorderLayout.SOUTH);
        
        setVisible(true);
        
        //Add aux observables
        myMenu.addObserver(this); 
        selectZone.addObserver(this); 
        mySwingWorker.addObserver(this);
        
        //Quand on appuis sur startButton
        startButton.addActionListener(new ActionListener()
        {           
            @Override
            public void actionPerformed(ActionEvent e)
            {
                // TODO Auto-generated method stub
                if(file!=null)
                {
                    mySwingWorker.setFile(file);                   
                    mySwingWorker.work();
                }
            }
        });
        
    }

    //Selectionne le dossier
    @Override
    public void selectFolder()
    {
        // TODO Auto-generated method stub
        JFileChooser jFileChooser = new JFileChooser();
        jFileChooser.setCurrentDirectory(new java.io.File("."));
        jFileChooser.setDialogTitle("Select a Directory");
        jFileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        
        if (jFileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) { 
            file = jFileChooser.getSelectedFile();
            selectZone.jTextField.setText(file.getName());
        }
        else {
            System.out.println("No Selection ");
        }
    }

    //Affiche le nombre de fichiers du dossier
    @Override
    public void showAnswer(int answer)
    {
        // TODO Auto-generated method stub
        String totoro = "Il y a "+answer+" fichiers dans le dossier";
        answerLabel.setText(totoro);
        //this.add(answerLabel,BorderLayout.SOUTH);
        System.out.println(totoro);
        
    }
}
