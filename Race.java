import javax.swing.*;
import javax.swing.text.StringContent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        setSize(400, 268);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        JLabel lblGokart = new JLabel("Gokart");
        JTextField txtGokart = new JTextField(7);
        JLabel lblTratti = new JLabel("Tratti");
        JTextField txtTratti = new JTextField(7);

        JPanel pnlNorth = new JPanel();
        pnlNorth.add(lblGokart);
        pnlNorth.add(txtGokart);
        pnlNorth.add(lblTratti);
        pnlNorth.add(txtTratti);

        JButton btnStart = new JButton("Start Race!");

        JPanel pnlCenter = new JPanel(new FlowLayout());
        pnlCenter.add(btnStart);

        JTextArea txtRace = new JTextArea(10, 10);

        JScrollPane pnlSouth = new JScrollPane(txtRace);

        add(pnlNorth, BorderLayout.NORTH);
        add(pnlCenter, BorderLayout.CENTER);
        add(pnlSouth, BorderLayout.SOUTH);

        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String gokart = txtGokart.getText();
                String tratti = txtTratti.getText();

                int nGokart = Integer.parseInt(gokart);
                int nTratti = Integer.parseInt(tratti);

                if((nGokart <= 0) || (nTratti <= 0))
                    // Messagebox
                    return;

                txtRace.setText(null);
            }
        });

    }
}

/* REGEX
    Regular Expression
    identifica un insieme di stringhe che rispettano certi parametri
    ^ carattere inizio stringa
    $ carattere di fine stringa
 */