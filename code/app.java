package code;

import java.util.LinkedList;

import javax.swing.JOptionPane;

public class app {
    static LinkedList<cls_pacientes> pacientes = new LinkedList<>(); //Creacion de la lista de pacientes
    public static void main(String[] args) {
        fnt_menu(true);
    }

    private static void fnt_pacientes(){
        String opcionesPacientes = JOptionPane.showInputDialog(null, "MENU PACIENTES\n" +
                "1. Registrar\n" +
                "2. Consultar\n" +
                "3. Salir");
        if (opcionesPacientes.equals("1")) {
            String nombre = JOptionPane.showInputDialog(null, "Ingrese el nombre del paciente: ");
            String id = JOptionPane.showInputDialog(null, "Ingrese el id del paciente: ");
            int edad = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la edad del paciente: "));
            String contacto = JOptionPane.showInputDialog(null, "Ingrese el contacto del paciente: ");
            String historia = JOptionPane.showInputDialog(null, "Ingresar historia del paciente: ");
            pacientes.add(new cls_pacientes(nombre, id, edad, contacto, historia));
            JOptionPane.showMessageDialog(null, "registro hecho con exito");
        }
    }

    public static void fnt_menu(boolean menu){
        while (menu) {
            String opcionesStr = JOptionPane.showInputDialog(null, "Menu Principal\n"+
            "1. Nuevo paciente\n" +
            "2. Nueva cita\n" +
            "3. Reporte\n" +
            "4. Salir");

            if (opcionesStr.equals("1")){
                fnt_pacientes();
            }
        }
    }
}
