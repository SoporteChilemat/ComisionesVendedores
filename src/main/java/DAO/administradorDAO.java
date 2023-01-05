package DAO;

import static VENTANAS.VentanaPrincipal.conex;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class administradorDAO {

    public static String contraseñaAdministrador() throws IOException, SQLException {
        String contraseña = "";
        try ( PreparedStatement estatuto = conex.getConnection().prepareStatement("SELECT passgod FROM dbo.god");  ResultSet res = estatuto.executeQuery()) {
            while (res.next()) {
                contraseña = res.getString("passgod");
            }
            estatuto.close();
        }
        return contraseña;
    }
}
