import javax.swing.*;
import javax.swing.text.StringContent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.util.concurrent.TimeUnit;

/**
 * Created by inf.marchisios1106 on 23/02/2016.
 */
public class Race extends JFrame {
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Race race = new Race();
            }
        });
    }

    private Race() {
        initUI();
    }

    private void initUI() {
        setTitle("Gokart Race!");
        setSize(625, 500);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        // NORTH
        JLabel lblGokart = new JLabel("Gokart");
        JTextField txtGokart = new JTextField(7);
        JLabel lblTratti = new JLabel("Tratti");
        JTextField txtTratti = new JTextField(7);

        JPanel pnlNorth = new JPanel();
        pnlNorth.add(lblGokart);
        pnlNorth.add(txtGokart);
        pnlNorth.add(lblTratti);
        pnlNorth.add(txtTratti);

        // CENTER
        JButton btnStart = new JButton("Start Race!");

        JPanel pnlCenter = new JPanel(new FlowLayout());
        pnlCenter.add(btnStart);

        // SOUTH
        JTextArea txtRace = new JTextArea(10, 10);
        MyTableModel model = new MyTableModel();
        JTable tblData = new JTable(model);

        JScrollPane pnlLog = new JScrollPane(txtRace);
        JScrollPane pnlData = new JScrollPane(tblData);
        JPanel pnlSouth = new JPanel(new GridLayout(1, 2, 2, 2));
        pnlSouth.add(pnlData);
        pnlSouth.add(pnlLog);

        // MAIN
        add(pnlNorth, BorderLayout.NORTH);
        add(pnlCenter, BorderLayout.CENTER);
        add(pnlSouth, BorderLayout.SOUTH);

        // EVENTS
        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String gokart = txtGokart.getText();
                String tratti = txtTratti.getText();
                String log = "";
                Integer[] dati = new Integer[2];
                String[] intestazioneTbl = new String[2];
                intestazioneTbl[0] = "Tratto n°";
                intestazioneTbl[1] = "Pericolosità";

                int nGokart = Integer.parseInt(gokart);
                int nTratti = Integer.parseInt(tratti);
                int i = 0;

                txtRace.setText(null);

                if((nGokart <= 0) || (nTratti <= 0))
                    // Messagebox
                    return;

                Races race = new Races(nTratti, 5);
                model.addColumn(intestazioneTbl);
                for(i = 0; i < nTratti; i++) {
                    dati[0] = i+1;
                    dati[1] = race.getPericolosita(i);
                    model.addRow(dati);
                }
                Vector<Gokart> partecipanti = new Vector<>();

                // Creo i kart partecipanti

                for(i = 0; i < nGokart; i++)
                    partecipanti.add(new Gokart());

                // faccio eseguire la corsa ad ogni kart
                for(i = 0; i < partecipanti.size(); i++) {
                    log += race.corsa(partecipanti.get(i));
                    txtRace.setText(log);
                }

                // Stampo il numero del/dei vincitore/i
                txtRace.setText(log + race.vincitori());
            }
        });

    }
}
