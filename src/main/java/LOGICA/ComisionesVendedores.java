/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package LOGICA;

import CLASES.Vendedores;
import CLASES.Ventas;
import CLASES.Excel;
import CLASES.PanelLocal;
import VENTANAS.VentanaPrincipal;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.apache.commons.compress.harmony.unpack200.bytecode.forms.ThisFieldRefForm;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author DELL
 */
public class ComisionesVendedores {

//--------------DECLARACIONES DE VARIABLES GLOBALES-----------------------------------------------------
    public static ArrayList<Vendedores> arrFinal = new ArrayList();
//-------------------------MAIN CLASS-------------------------------------------------------------------

    public static void principal(String link) throws IOException {
        ArrayList<Excel> convertirExcelaArrayList = convertirExcelaArrayList(System.getProperty("user.dir") + link);

        arrFinal = llenarArrayListVendedores(hacerVendedores(convertirExcelaArrayList), convertirExcelaArrayList);
        mostrarArrFinal(arrFinal);
        llenarcomboxVendedores(arrFinal);

    }
//-----------------------METODO QUE LEE EXCEL Y RETORNA UN ARRAYLIST-----------------------------------------

    public static ArrayList<Excel> convertirExcelaArrayList(String path) throws FileNotFoundException, IOException {
        System.out.println("path " + path);
        ArrayList<Excel> arrExcel = new ArrayList<>();

        InputStream ExcelFileToRead = new FileInputStream(new File(path));

        HSSFWorkbook wb = new HSSFWorkbook(ExcelFileToRead);
        HSSFSheet sheet = wb.getSheetAt(0);
        Row row;

        Cell cell;
        Iterator rows = sheet.rowIterator();
        // estos rows.next() ven las celdas en donde comenzar a leer el excel.
        rows.next();
        rows.next();
        int contador = 0;
        while (rows.hasNext()) {
            int cont = 0;
            Excel excel = new Excel();

            row = (Row) rows.next();
            Iterator cells = row.cellIterator();

            while (cells.hasNext()) {

                cell = (Cell) cells.next();
                switch (cont) {
                    case 0: {
                        if (cell.getCellType() == CellType.FORMULA) {
                            if (cell.getCachedFormulaResultType() == CellType.NUMERIC) {
                                excel.setNombre(String.valueOf(cell.getNumericCellValue()));
//                               vendedor.add(String.valueOf(cell.getNumericCellValue()));
//                                System.out.println("1 " + String.valueOf(cell.getNumericCellValue()));
                            } else if (cell.getCachedFormulaResultType() == CellType.STRING) {
                                excel.setNombre(cell.getStringCellValue());
//                                arrPersonasInicio.add(cell.getStringCellValue());
//                                System.out.println("2 " + cell.getStringCellValue());
                            }
                        } else {
                            try {
                                excel.setNombre(cell.getStringCellValue());
//                                arrPersonasInicio.add(cell.getStringCellValue());
//                                System.out.println("3 " + cell.getStringCellValue());
                            } catch (Exception e) {
                                excel.setNombre(String.valueOf(cell.getNumericCellValue()));
//                                arrPersonasInicio.add(String.valueOf(cell.getNumericCellValue()));
//                                System.out.println("4 " + String.valueOf(cell.getNumericCellValue()));
                            }
                        }
                    }
                    case 1: {
                        if (cell.getCellType() == CellType.FORMULA) {
                            if (cell.getCachedFormulaResultType() == CellType.NUMERIC) {
                                excel.setRutCliente(String.valueOf(cell.getNumericCellValue()));
//                               vendedor.add(String.valueOf(cell.getNumericCellValue()));
//                                System.out.println("1 " + String.valueOf(cell.getNumericCellValue()));
                            } else if (cell.getCachedFormulaResultType() == CellType.STRING) {
                                excel.setRutCliente(cell.getStringCellValue());
//                                arrPersonasInicio.add(cell.getStringCellValue());
//                                System.out.println("2 " + cell.getStringCellValue());
                            }
                        } else {
                            try {
                                excel.setRutCliente(cell.getStringCellValue());
//                                arrPersonasInicio.add(cell.getStringCellValue());
//                                System.out.println("3 " + cell.getStringCellValue());
                            } catch (Exception e) {
                                excel.setRutCliente(String.valueOf(cell.getNumericCellValue()));
//                                arrPersonasInicio.add(String.valueOf(cell.getNumericCellValue()));
//                                System.out.println("4 " + String.valueOf(cell.getNumericCellValue()));
                            }
                        }
                    }
                    case 2: {
                        if (cell.getCellType() == CellType.FORMULA) {
                            if (cell.getCachedFormulaResultType() == CellType.NUMERIC) {
                                excel.setRazonSocial(String.valueOf(cell.getNumericCellValue()));
//                               vendedor.add(String.valueOf(cell.getNumericCellValue()));
//                                System.out.println("1 " + String.valueOf(cell.getNumericCellValue()));
                            } else if (cell.getCachedFormulaResultType() == CellType.STRING) {
                                excel.setRazonSocial(cell.getStringCellValue());
//                                arrPersonasInicio.add(cell.getStringCellValue());
//                                System.out.println("2 " + cell.getStringCellValue());
                            }
                        } else {
                            try {
                                excel.setRazonSocial(cell.getStringCellValue());
//                                arrPersonasInicio.add(cell.getStringCellValue());
//                                System.out.println("3 " + cell.getStringCellValue());
                            } catch (Exception e) {
                                excel.setRazonSocial(String.valueOf(cell.getNumericCellValue()));
//                                arrPersonasInicio.add(String.valueOf(cell.getNumericCellValue()));
//                                System.out.println("4 " + String.valueOf(cell.getNumericCellValue()));
                            }
                        }
                    }
                    case 3: {
                        if (cell.getCellType() == CellType.FORMULA) {
                            if (cell.getCachedFormulaResultType() == CellType.NUMERIC) {
                                excel.setNumeroDoc(String.valueOf(cell.getNumericCellValue()));
//                               vendedor.add(String.valueOf(cell.getNumericCellValue()));
//                                System.out.println("1 " + String.valueOf(cell.getNumericCellValue()));
                            } else if (cell.getCachedFormulaResultType() == CellType.STRING) {
                                excel.setNumeroDoc(cell.getStringCellValue());
//                                arrPersonasInicio.add(cell.getStringCellValue());
//                                System.out.println("2 " + cell.getStringCellValue());
                            }
                        } else {
                            try {
                                excel.setNumeroDoc(cell.getStringCellValue());
//                                arrPersonasInicio.add(cell.getStringCellValue());
//                                System.out.println("3 " + cell.getStringCellValue());
                            } catch (Exception e) {
                                excel.setNumeroDoc(String.valueOf(cell.getNumericCellValue()));
//                                arrPersonasInicio.add(String.valueOf(cell.getNumericCellValue()));
//                                System.out.println("4 " + String.valueOf(cell.getNumericCellValue()));
                            }
                        }
                    }
                    case 4: {
                        if (cell.getCellType() == CellType.FORMULA) {
                            if (cell.getCachedFormulaResultType() == CellType.NUMERIC) {
                                excel.setFechaEmision(String.valueOf(cell.getNumericCellValue()));
//                               vendedor.add(String.valueOf(cell.getNumericCellValue()));
//                                System.out.println("1 " + String.valueOf(cell.getNumericCellValue()));
                            } else if (cell.getCachedFormulaResultType() == CellType.STRING) {
                                excel.setFechaEmision(cell.getStringCellValue());
//                                arrPersonasInicio.add(cell.getStringCellValue());
//                                System.out.println("2 " + cell.getStringCellValue());
                            }
                        } else {
                            try {
                                excel.setFechaEmision(cell.getStringCellValue());
//                                arrPersonasInicio.add(cell.getStringCellValue());
//                                System.out.println("3 " + cell.getStringCellValue());
                            } catch (Exception e) {
                                excel.setFechaEmision(String.valueOf(cell.getNumericCellValue()));
//                                arrPersonasInicio.add(String.valueOf(cell.getNumericCellValue()));
//                                System.out.println("4 " + String.valueOf(cell.getNumericCellValue()));
                            }
                        }
                    }
                    case 5: {
                        if (cell.getCellType() == CellType.FORMULA) {
                            if (cell.getCachedFormulaResultType() == CellType.NUMERIC) {
                                excel.setMedioPago(String.valueOf(cell.getNumericCellValue()));
//                               vendedor.add(String.valueOf(cell.getNumericCellValue()));
//                                System.out.println("1 " + String.valueOf(cell.getNumericCellValue()));
                            } else if (cell.getCachedFormulaResultType() == CellType.STRING) {
                                excel.setMedioPago(cell.getStringCellValue());
//                                arrPersonasInicio.add(cell.getStringCellValue());
//                                System.out.println("2 " + cell.getStringCellValue());
                            }
                        } else {
                            try {
                                excel.setMedioPago(cell.getStringCellValue());
//                                arrPersonasInicio.add(cell.getStringCellValue());
//                                System.out.println("3 " + cell.getStringCellValue());
                            } catch (Exception e) {
                                excel.setMedioPago(String.valueOf(cell.getNumericCellValue()));
//                                arrPersonasInicio.add(String.valueOf(cell.getNumericCellValue()));
//                                System.out.println("4 " + String.valueOf(cell.getNumericCellValue()));
                            }
                        }
                    }
                    case 6: {
                        if (cell.getCellType() == CellType.FORMULA) {
                            if (cell.getCachedFormulaResultType() == CellType.NUMERIC) {
                                excel.setNeto(String.valueOf(cell.getNumericCellValue()));
//                               vendedor.add(String.valueOf(cell.getNumericCellValue()));
//                                System.out.println("1 " + String.valueOf(cell.getNumericCellValue()));
                            } else if (cell.getCachedFormulaResultType() == CellType.STRING) {
                                excel.setNeto(cell.getStringCellValue());
//                                arrPersonasInicio.add(cell.getStringCellValue());
//                                System.out.println("2 " + cell.getStringCellValue());
                            }
                        } else {
                            try {
                                excel.setNeto(cell.getStringCellValue());
//                                arrPersonasInicio.add(cell.getStringCellValue());
//                                System.out.println("3 " + cell.getStringCellValue());
                            } catch (Exception e) {
                                excel.setNeto(String.valueOf(cell.getNumericCellValue()));
//                                arrPersonasInicio.add(String.valueOf(cell.getNumericCellValue()));
//                                System.out.println("4 " + String.valueOf(cell.getNumericCellValue()));
                            }
                        }
                    }
                    case 7: {
                        if (cell.getCellType() == CellType.FORMULA) {
                            if (cell.getCachedFormulaResultType() == CellType.NUMERIC) {
                                excel.setDoc(String.valueOf(cell.getNumericCellValue()));
//                               vendedor.add(String.valueOf(cell.getNumericCellValue()));
//                                System.out.println("1 " + String.valueOf(cell.getNumericCellValue()));
                            } else if (cell.getCachedFormulaResultType() == CellType.STRING) {
                                excel.setDoc(cell.getStringCellValue());
//                                arrPersonasInicio.add(cell.getStringCellValue());
//                                System.out.println("2 " + cell.getStringCellValue());
                            }
                        } else {
                            try {
                                excel.setDoc(cell.getStringCellValue());
//                                arrPersonasInicio.add(cell.getStringCellValue());
//                                System.out.println("3 " + cell.getStringCellValue());
                            } catch (Exception e) {
                                excel.setDoc(String.valueOf(cell.getNumericCellValue()));
//                                arrPersonasInicio.add(String.valueOf(cell.getNumericCellValue()));
//                                System.out.println("4 " + String.valueOf(cell.getNumericCellValue()));
                            }
                        }
                    }
                }
                cont++;
            }
            arrExcel.add(excel); //agregar persona al arreglo
            contador++;
        }

        ExcelFileToRead.close();

        return arrExcel;
    }
//------------SACAR INFORMACIÓN DE ARRAYLIST EXCEL Y AGREGARLA A LISTA STRING VENDEDORES----------------------------------------------------------------

    public static List<String> hacerVendedores(ArrayList<Excel> arrExcel) {
        Excel jose = new Excel();
        List<String> arrNombresString = new ArrayList<String>();
        String temporalNombre = new String();

        for (int i = 0; i < arrExcel.size(); i++) {
            jose = arrExcel.get(i);
            temporalNombre = (jose.getNombre());
            arrNombresString.add(temporalNombre);
        }

        System.out.println(arrNombresString.size());

        Set<String> hashSet = new HashSet<String>(arrNombresString);
        arrNombresString.clear();
        arrNombresString.addAll(hashSet);
        System.out.println(arrNombresString.size());

        System.out.println(arrNombresString);

        return arrNombresString;

    }

//-------------LLENAR ARRAYLIST DE VENDEDORES CON LOS NOMBRES E INSERTAR ARRAY DE VENTAS------------------------------------------------------------------------------
    public static ArrayList<Vendedores> llenarArrayListVendedores(List<String> arrNombresString, ArrayList<Excel> arrExcel) {
        ArrayList<Vendedores> arrVendedores = new ArrayList<>();

        for (int i = 0; i < arrNombresString.size(); i++) {
            Vendedores vendedor = new Vendedores();
            String nombre = arrNombresString.get(i);

            vendedor.setNombre(nombre);

            ArrayList<Ventas> arrVentas = new ArrayList();

            for (int j = 0; j < arrExcel.size(); j++) {
                Excel excel = arrExcel.get(j);

                if (nombre.equals(excel.getNombre())) {
//                    System.out.println("nombre            " + nombre);
//                    System.out.println("excel.getNombre() " + excel.getNombre());

                    Ventas venta = new Ventas();
                    venta.setRutCliente(excel.getRutCliente());
                    venta.setRazonSocial(excel.getRazonSocial());
                    venta.setNumeroDoc(excel.getNumeroDoc());
                    venta.setFechaEmision(excel.getFechaEmision());
                    venta.setMedioPago(excel.getMedioPago());
                    venta.setNeto(excel.getNeto());
                    venta.setDoc(excel.getDoc());
                    arrVentas.add(venta);
                }
            }
            vendedor.setArrVentas(arrVentas);
            arrVendedores.add(vendedor);
        }
        return arrVendedores;
    }

//----------------------MOSTRAR ARREGLO FINAL A VER COMO QUEDÓ---------------------------------------------------------------    
    public static void mostrarArrFinal(ArrayList<Vendedores> arrFinal) {
        for (int k = 0; k < arrFinal.size(); k++) {

            Vendedores vendedor = arrFinal.get(k);
            System.out.println(vendedor.getNombre());
            ArrayList<Ventas> arrPrueba = vendedor.getArrVentas();

            for (int i = 0; i < arrPrueba.size(); i++) {

                Ventas prueba = arrPrueba.get(i);
                System.out.println("    " + prueba.getNumeroDoc());
            }
        }
    }
//-----------------------------------llenarcombox--------------------------------------------------------------------------------

    public static void llenarcomboxVendedores(ArrayList<Vendedores> arrFinal) {
        System.out.println("arrFinal.size() " + arrFinal.size());

//        VentanaPrincipal.jComboBoxVendedoresVA.removeAllItems();
        for (int k = 0; k < arrFinal.size(); k++) {

            Vendedores vendedor = arrFinal.get(k);

            PanelLocal.jComboBoxVendedoresVA.addItem(vendedor.getNombre());
//            VentanaPrincipal.jComboBoxVendedoresPB.addItem(vendedor.getNombre());
//            VentanaPrincipal.jComboBoxVendedoresOL.addItem(vendedor.getNombre());

            VentanaPrincipal.ventanaPrincipal.repaint();
            VentanaPrincipal.ventanaPrincipal.revalidate();
        }
    }
//---------------------------------------------------------------------------------------    

}
