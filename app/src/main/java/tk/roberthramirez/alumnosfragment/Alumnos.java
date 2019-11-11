package tk.roberthramirez.alumnosfragment;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Alumnos {
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String correo;
    private int edad;

    private static String sFecha;
    private static GregorianCalendar parseSFecha = new GregorianCalendar();

    public Alumnos(String nombre, String apellido1, String apellido2, String correo, String sFecha) {
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.correo = correo;


        this.edad = calcularAnos(sFecha);
    }

    private static int calcularAnos(String sFecha) {

        GregorianCalendar fechaActual = new GregorianCalendar();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            parseSFecha.setGregorianChange(sdf.parse(sFecha));
        }catch (ParseException parEx) {
            System.out.println("Error al parsear fecha");
        }
        fechaActual.roll(Calendar.DAY_OF_MONTH, parseSFecha.get(Calendar.DAY_OF_MONTH));
        fechaActual.roll(Calendar.MONTH, parseSFecha.get(Calendar.MONTH));
        fechaActual.roll(Calendar.YEAR, parseSFecha.get(Calendar.YEAR));


        return fechaActual.get(Calendar.YEAR);


    }
}
