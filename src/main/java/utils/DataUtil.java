package utils;

import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;

public class DataUtil {

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");

    public static String formatarData(Date data) {
        SimpleDateFormat formato = new SimpleDateFormat("dd 'de' MMMM 'de' yyyy, EEEE, HH:mm");
        return formato.format(data);
    }

    public static Date stringToDate(String dateStr) {
        try {
            return DATE_FORMAT.parse(dateStr);
        } catch (ParseException e) {
            System.out.println("Erro ao converter a data. Formato esperado: dd/MM/yyyy");
            return null;
        }
    }
}
