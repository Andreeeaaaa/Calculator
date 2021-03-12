package andrealanocita.calcolatore;

import java.awt.*;
import java.awt.event.*;

public class GUI extends Frame implements ActionListener{
    private Panel panelButtons;
    private Panel panelInput;

    private Label lblInput;
    private Label lblRisultato;

    private Button btnInvia;
    private Button[] btnNumeri;
    private Button btnPiu, btnMeno, btnPer;
    private Button btnParA, btnParC;
    private Button btnFrazione, btnRadice;
    private Button btnPotenza;
    private Button btnVirgola;
    private Button btnCancella;
    private Button btnC;


    private TextField tfRisultato;
    private TextField tfEspressione;

    private String Risultato;

    private Integer num = 0;



    public GUI() {

        setLayout(new BorderLayout(1, 1));

        panelInput = new Panel(new FlowLayout());


        lblInput = new Label("Espressione:");

        tfEspressione = new TextField("", 20);
        tfEspressione.setFont(new Font("TimesRoman", Font.PLAIN, 30));
        tfEspressione.setEditable(false);

        btnInvia = new Button("-->");

        btnInvia.addActionListener(this);

        lblRisultato = new Label("Risultato:");
        lblRisultato.setAlignment(Label.CENTER);

        tfRisultato = new TextField("", 20);
        tfRisultato.setEditable(false);

        panelInput.add(lblInput);
        panelInput.add(tfEspressione);
        panelInput.add(btnInvia);
        panelInput.add(lblRisultato);
        panelInput.add(tfRisultato);
        add(panelInput, BorderLayout.NORTH);


        //OUTPUT
        //panelOutput = new Panel(new FlowLayout());





        //Pannello Calcolatore
        panelButtons = new Panel(new GridLayout(7, 3));

        btnNumeri = new Button[10];

        //Aggiungo segni, parentesi...
        btnParA = new Button("(");
        btnParC = new Button(")");
        btnFrazione = new Button("/");
        btnRadice = new Button("V");
        btnPotenza = new Button("^ ");
        btnPer = new Button("*");
        btnMeno = new Button("-");
        btnPiu = new Button("+");
        btnVirgola = new Button(".");
        btnCancella = new Button("<---");
        btnC = new Button("C");

        //aggiungo i listener per i bottoni
        btnParA.addActionListener(this);
        btnParC.addActionListener(this);
        btnFrazione.addActionListener(this);
        btnRadice.addActionListener(this);
        btnPotenza.addActionListener(this);
        btnPer.addActionListener(this);
        btnMeno.addActionListener(this);
        btnPiu.addActionListener(this);
        btnVirgola.addActionListener(this);
        btnCancella.addActionListener(this);
        btnC.addActionListener(this);


        panelButtons.add(btnParA);
        panelButtons.add(btnParC);
        panelButtons.add(btnFrazione);
        panelButtons.add(btnRadice);
        panelButtons.add(btnPotenza);
        panelButtons.add(btnPer);
        panelButtons.add(btnMeno);
        panelButtons.add(btnPiu);
        panelButtons.add(btnVirgola);
        panelButtons.add(btnCancella);


        //Aggiungo i numeri da 1 a 9
        while(num < 10) {
            btnNumeri[num] = new Button(num.toString());
            btnNumeri[num].addActionListener(this);
            btnNumeri[num].setPreferredSize(new Dimension(40, 40));
            panelButtons.add(btnNumeri[num]);
            num++;
        }
        panelButtons.add(btnC);


        add(panelButtons, BorderLayout.CENTER);





        //titolo, grandezza finestra iniziale e background
        setTitle("Calcolatore");
        setSize(780, 600);
        setVisible(true);
        setBackground(Color.white);



        //Chiusura Finistra
        addWindowListener(new WindowEventListener());


    }

    public static void main(String[] args) {

        new GUI();

    }


    @Override
    public void actionPerformed(ActionEvent evt) {

        //controllo quale bottone è stato premuto
        String Button = evt.getActionCommand();


        //se il bottone è l'invio calcolo il risultato
        if (Button == "-->") {

            System.out.println("Triggered the if statement in that listener");

            String Epr = tfEspressione.getText();

                Risultato = Espressioni.Es(Epr);
                tfRisultato.setText(Risultato);

                System.out.println("RISULTATO FINALE DA AGGIUNGERE" + Risultato);

        }


        else if (Button == "<---") {      //backspace
            if (tfEspressione.getText().length() > 0) {
                StringBuilder strB = new StringBuilder(tfEspressione.getText());
                tfEspressione.setText(strB.deleteCharAt(tfEspressione.getText().length() - 1).toString());
            }
        } else if (Button == "C") {
            tfEspressione.setText("");
            tfRisultato.setText("");
        }

        else {          //aggiungo un carattere uguale al tasto premuto
            tfEspressione.setText(tfEspressione.getText() + Button);
        }
    }
}