import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DbFunctions {

    public Connection connect_to_db(){

        Connection conn=null;

        try {
            Class.forName("org.postgresql.Driver");
            conn= DriverManager.getConnection("jdbc:postgresql://tyke.db.elephantsql.com/"+"xmbbmykr", "xmbbmykr", "PzxHPxa0Gx9P0QsWd25ErJ1l9RzbH90d");

            if(conn!=null){
                System.out.println("Connection established");
            }else{
                System.out.println("Connection failed");
            }
        }catch (Exception e){
            System.out.println(e);
        }

        return conn;
    }

    public String izpis_uporabnikov(Connection conn){
        Statement statement;
        ResultSet rs=null;
        String s = "";
        try {
            String query="SELECT preberi_uporabnike();";
            statement=conn.createStatement();
            rs=statement.executeQuery(query);
            while (rs.next()){
                s=s+rs.getString(1);
            }
        }catch (Exception e){
            System.out.println(e);
        }
        System.out.println(s);
        return s;
    }

    public void read_data(Connection conn, String table_name){
        Statement statement;
        ResultSet rs=null;
        String s = null;
        int i = 1;
        try {
            String query="SELECT * FROM " + table_name +";";
            statement=conn.createStatement();
            rs=statement.executeQuery(query);
            while (rs.next()){
                s=s+rs.getString(i);
                i++;
            }
        }catch (Exception e){
            System.out.println(e);
        }

    }

    public int prijava(Connection conn, String mail, String password){
        Statement statement;
        ResultSet rs=null;
        int x = 0;
        try {
            String query="SELECT prijava('"+mail+"', '" + password + "');";
            System.out.println("1");
            statement=conn.createStatement();
            System.out.println("2");
            rs = statement.executeQuery(query);
            while (rs.next()){
                x = rs.getInt(1);
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return x;
    }
}
