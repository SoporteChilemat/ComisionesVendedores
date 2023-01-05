package Connect;

import VENTANAS.VentanaPrincipal;
import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class DbConnection {

    Connection connection = null;

    public DbConnection() throws IOException {

        try {
            //Class.forName("com.mysql.cj.jdbc.Driver");
            //connection = DriverManager.getConnection(url, login, password);

            SQLServerDataSource ds = new SQLServerDataSource();
            ds.setUser("sa");
            ds.setPassword("qweASDzxc123*");
            ds.setServerName("servidor-toso.ddns.net");
            ds.setPortNumber(1433);
            ds.setDatabaseName("Comisiones");
            connection = ds.getConnection();

            if (connection != null) {
//                System.out.println("Conexión a base de datos " + bd + " OK\n");
            }
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(VentanaPrincipal.ventanaPrincipal, e.toString(), "Error", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void desconectar() throws SQLException {
        connection.close();
    }
}
