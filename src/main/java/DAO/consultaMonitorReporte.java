package DAO;

import static VENTANAS.VentanaPrincipal.conex;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class consultaMonitorReporte {

    public static String ConsultaLocalMonitorReporte(String usuario, String local) {
        String string = "";
        try ( Statement estatuto = conex.getConnection().createStatement()) {
            try ( ResultSet res = estatuto.executeQuery("SELECT Local from dbo.MonitorReporte WHERE Usuario = '" + usuario + "' AND Local = '" + local + "'")) {
                if (res.next()) {
                    string = res.getString("local");
                }
                res.close();
            }
            estatuto.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return string;
    }

    public static void registraMonitorReporte(String reporte, String usuario, String local) {

        try ( Statement estatuto = conex.getConnection().createStatement()) {
            estatuto.executeUpdate("INSERT INTO dbo.MonitorReporte (Reporte, Usuario, Local) VALUES ('"
                    + reporte + "', '"
                    + usuario + "', '"
                    + local + "')"
            );
            estatuto.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void actualizaMonitorReporte(String reporte, String usuario, String local) {
        try ( Statement estatuto = conex.getConnection().createStatement()) {
            estatuto.executeUpdate("UPDATE dbo.MonitorReporte SET Reporte ='" + reporte + "' WHERE Usuario = '" + usuario + "' AND Local = '" + local + "'");
            estatuto.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void actualizaReportesFecha(String usuario, String local) {
        try ( Statement estatuto = conex.getConnection().createStatement()) {
            estatuto.executeUpdate("UPDATE dbo.DescargaReporte SET " + local + " = " + null + " WHERE Usuario = '" + usuario + "'");
            estatuto.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void registraReportesFechaNull(String usuario) {

        try ( Statement estatuto = conex.getConnection().createStatement()) {
            estatuto.executeUpdate("INSERT INTO dbo.DescargaReporte (Usuario) VALUES ('" + usuario + "')");
            estatuto.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static byte[] ConsultaLocal(String local, String extencion, String usuario) {
        byte[] bytes = null;
        try ( Statement estatuto = conex.getConnection().createStatement()) {
            try ( ResultSet res = estatuto.executeQuery("SELECT " + local + " from dbo.DescargaReporte WHERE Usuario ='" + usuario + "'")) {
                if (res.next()) {
                    bytes = res.getBytes(local);

                    File fileExel = new File(System.getProperty("user.dir") + "\\ventas\\" + local.toUpperCase() + "\\SAF2_Visor_Diario_Listado_de_Ventas_x_Fechas." + extencion);
                    if (!fileExel.exists()) {
                        fileExel.createNewFile();
                    }
                    try ( FileOutputStream fos = new FileOutputStream(fileExel)) {
                        fos.write(bytes);
                    }
                }
                res.close();
            }
            estatuto.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(consultaMonitorReporte.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(consultaMonitorReporte.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bytes;
    }

    public static String ConsultaLocalReportesfecha(String usuario, String local) {
        String string = "";
        try ( Statement estatuto = conex.getConnection().createStatement()) {
            try ( ResultSet res = estatuto.executeQuery("SELECT " + local + " from dbo.DescargaReporte WHERE Usuario = '" + usuario + "'")) {
                if (res.next()) {
                    string = res.getString(local);
                }
                res.close();
            }
            estatuto.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }
        return string;
    }
}
