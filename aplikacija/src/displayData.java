import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;

public class displayData extends JFrame {
    private JPanel mainPanel;
    private JList list1;

    DefaultListModel listM = new DefaultListModel(){

    };

    public displayData(Integer x){
        setContentPane(mainPanel);
        setTitle("Uporabniki");
        setSize(750, 300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        DbFunctions db= new DbFunctions();
        Connection conn=db.connect_to_db();

        String elements = db.izpis_uporabnikov(conn);
        elements=elements.replace("(", "");
        elements=elements.replace(",", ", ");
        elements=elements.replace(")", "#");
        String[] zaposleni = elements.split("#");

        for (String i : zaposleni) {
            listM.addElement(i);
        }

        list1.setModel(listM);
    }
}
