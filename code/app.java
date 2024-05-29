package code;

import java.util.LinkedList;

import javax.swing.JOptionPane;

public class app {
    static LinkedList<cls_pacientes> pacientes = new LinkedList<>(); //Creacion de la lista de pacientes
    static LinkedList<cls_citas> citas = new LinkedList<>(); //Creacion de la lista citas

    public static void main(String[] args) {
        fnt_menu(true);
    }

    private static void fnt_pacientes(boolean menuPacientes){
        while (menuPacientes){
            String opcionesPacientes = JOptionPane.showInputDialog(null, "MENU PACIENTES\n" +
                "1. Registrar\n" +
                "2. Consultar\n" +
                "3. Salir");
            
            if (opcionesPacientes.equals("3")){
                menuPacientes = false;
            }

            if (opcionesPacientes.equals("1")) {
                boolean sw =false;
                String id = JOptionPane.showInputDialog(null, "Ingrese el id del paciente: ");
                for (int i =0; i<pacientes.size();i++){
                    if (pacientes.get(i).getIdStr().equals(id)){
                        sw = true;
                        break;
                    }
                }
                if (sw == false){
                    String nombre = JOptionPane.showInputDialog(null, "Ingrese el nombre del paciente: ");
                    int edad = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la edad del paciente: "));
                    String contacto = JOptionPane.showInputDialog(null, "Ingrese el contacto del paciente: ");
                    String historia = JOptionPane.showInputDialog(null, "Ingresar historia del paciente: ");
                    pacientes.add(new cls_pacientes(nombre, id, edad, contacto, historia));
                    JOptionPane.showMessageDialog(null, "Registro hecho con exito");
                }else{
                    JOptionPane.showMessageDialog(null, "El paciente ya existe");
                }
            }
            if(opcionesPacientes.equals("2")){
                boolean sw =false;
                int pos = 0;
                String id = JOptionPane.showInputDialog(null, "Ingrese el id del paciente: ");
                for (int i =0; i<pacientes.size();i++){
                    if (pacientes.get(i).getIdStr().equals(id)){
                        sw = true;
                        pos = i;
                        break;
                    }
                }
                if (sw){
                    JOptionPane.showMessageDialog(null,
                    "ID: " + pacientes.get(pos).getIdStr() + "\n" +
                    "Nombre: "+pacientes.get(pos).getNombreStr()+"\n"+
                    "Edad: " + pacientes.get(pos).getEdadInt() + "\n" +
                    "Contacto: " + pacientes.get(pos).getContactoStr() + "\n" +
                    "Historia: " + pacientes.get(pos).getHistoriaStr());
                }else{
                    JOptionPane.showMessageDialog(null, "Paciente no se encuentra registrado");
                }
            }
            if (opcionesPacientes.equals("3")){
                menuPacientes = false;
            }
        }
    }

    public static void  fnt_citas (){
        boolean sw = false;

        String id = JOptionPane.showInputDialog(null, "ID: ");
        for (int i =0; i<citas.size();i++){
            if (citas.get(i).getIdStr().equals(id)){
                sw = true;
                break;
            }
        }
        if (sw == true){
            JOptionPane.showMessageDialog(null, "La cita ya existe");
        }else{
            String fecha = JOptionPane.showInputDialog(null, "Fecha: ");
            String Hora = JOptionPane.showInputDialog(null, "Hora: ");
            String Detalle = JOptionPane.showInputDialog(null, "Detalles de la cita: ");
            citas.add(new cls_citas(id, fecha, Hora, Detalle));
        }
    }

    public static void fnt_reporte (String idConsultar){
        boolean sw =false;
        int pos = 0;
        for (int i =0; i<pacientes.size();i++){
            if (pacientes.get(i).getIdStr().equals(idConsultar)){
                sw = true;
                pos = i;
                break;
            }
        }
        if (sw == true){
            String paciente = "Nombre paciente: " + pacientes.get(pos).getNombreStr() + "Contacto: " + pacientes.get(pos).getContactoStr() + "\n";
            sw = false;
            for (int i =0; i<citas.size();i++){
                if(citas.get(i).getIdStr().equals(idConsultar)){
                     JOptionPane.showMessageDialog(null, "FECHA: " + citas.get(i).getFechaStr() +
                     "\nHora: " + citas.get(i).getHoraStr() +
                     "\nDetalles de la cita: " + citas.get(i).getDetInformacion());
                }
                if (sw == false){
                 JOptionPane.showMessageDialog(null, "Este paciente no tien citasregistradas");
                }
             }
        }else{
            JOptionPane.showMessageDialog(null, "El paciente no existe");
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
                fnt_pacientes(true);
            }
            if (opcionesStr.equals("2")){
                fnt_citas();
            }
            if (opcionesStr.equals("3")){
                fnt_reporte(JOptionPane.showInputDialog(null, "ID: "));
            }
        }
    }
}
