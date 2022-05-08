import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

public class loginFrame extends JFrame{
    private JPanel mainPanel;
    private JTextField tfMail;
    private JPasswordField tfPass;
    private JButton btnLogin;

    public void loginForm(){
        setContentPane(mainPanel);
        setTitle("Prijava");
        setSize(450, 300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        DbFunctions db= new DbFunctions();
        Connection conn=db.connect_to_db();

        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = tfMail.getText();
                String password = tfPass.getText();
                int x = 0;
                System.out.println("Username: " + username);
                System.out.println("Password: " + password);

                x = db.prijava(conn, username, password);

                System.out.println(x);

                if (x!=0){
                    //kliče nov frame
                    displayData displaydata = new displayData(x);
                    //mainFrame mainframe = new mainFrame();
                    dispose();
                }else{
                    JOptionPane.showMessageDialog(null, "Prijava neuspešna!");
                }


            }
        });
    }
}
