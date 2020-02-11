package felulet;

import logika.MEFEGYclass;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.LinkedList;

public class Felulet extends JFrame {
    private Container foAblak;
    private LinkedList lstEgyenletek;
    private JButton bttnAdatokBetoltese;
    private JPanel pnlEgyenletek, pnlEgyenletMegoldasa;
    private JFileChooser fcFajl;
    private DefaultListModel dlm;
    private JList lst;

    public Felulet(){
        initComponents();
    }

    private void initComponents(){
        this.setTitle("MEFEGY - Másodfokú egyenletek gyökei");

        this.setSize(800, 500);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        this.foAblak = this.getContentPane();
        this.foAblak.setLayout(null);

        this.bttnAdatokBetoltese = new JButton();
        this.bttnAdatokBetoltese.setText("Adatok betöltése");
        this.bttnAdatokBetoltese.setSize(200, 25);
        this.bttnAdatokBetoltese.setLocation(20, 20);

        this.foAblak.add(this.bttnAdatokBetoltese);

        this.bttnAdatokBetoltese.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adatokBetoltese(e);
            }
        });

        this.pnlEgyenletek = new JPanel();
        this.pnlEgyenletek.setSize(250, 400);
        this.pnlEgyenletek.setBorder(new TitledBorder("Egyenletek"));
        this.pnlEgyenletek.setLocation(20, 60);

        this.foAblak.add(this.pnlEgyenletek);

        this.pnlEgyenletMegoldasa = new JPanel();
        this.pnlEgyenletMegoldasa.setSize(475, 400);
        this.pnlEgyenletMegoldasa.setBorder(new TitledBorder("Kiválasztott egyenlet megoldása"));
        this.pnlEgyenletMegoldasa.setLocation(300, 60);

        this.foAblak.add(this.pnlEgyenletMegoldasa);

        dlm = new DefaultListModel();
        lst = new JList(dlm);
        JScrollPane listScroller = new JScrollPane(this.lst);
        listScroller.setPreferredSize(new Dimension(650, 100));
        this.lst.setSize(300, 100);
        this.lst.setLocation(22, 62);

        
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    private void adatokBetoltese(ActionEvent ae){
        this.fcFajl = new JFileChooser();
        if (fcFajl.showDialog(this, "Fájl megnyitása") != -1){
            String fajlnev = fcFajl.getSelectedFile().toString();
            fajlBeolvas(fajlnev);
        }
    }
    private void fajlBeolvas(String fajlnev){
        this.lstEgyenletek = new LinkedList<MEFEGYclass>();
        try{
            FileReader fr = new FileReader(fajlnev);
            BufferedReader br = new BufferedReader(fr);

            String sor = br.readLine();
            while(sor != null){
                MEFEGYclass mefegyclass = new MEFEGYclass(sor);
                this.lstEgyenletek.add(mefegyclass);
                sor = br.readLine();
            }
            br.close();
            fr.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
