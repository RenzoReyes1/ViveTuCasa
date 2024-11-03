package Util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Funciones {
    public static String getHoraActual(){
        Date hora = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        return sdf.format(hora);
    }
    
     public static String getFechaActual(){
        Date hora = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(hora);
    }
}
