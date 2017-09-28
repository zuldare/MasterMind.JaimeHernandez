package es.upm.miw.mastermind.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import es.upm.miw.mastermind.views.IOView; 

public class  IO extends IOView{
    
    private BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private final String PATTERN_YES_NO = "[YN]{1}";
    
    public String readString(String title) {
        String input = null;
        boolean ok = false;
        do {
            this.write(title);
            try {
                input = bufferedReader.readLine();
                ok = true;
            } catch (Exception ex) {
                this.writeError("de cadena de caracteres");
            }
        } while (!ok);
        return input;
    }
    
    public String readStringYesNo(String title) {
        String input = null;
        boolean ok = false;
        do {
            this.write(title);
            try {
                input = bufferedReader.readLine();
                ok = isYesNo(input);
            } catch (Exception ex) {
                this.writeError("de cadena de caracteres");
            }
        } while (!ok);
        return input;
    }
    
    private boolean isYesNo(String option) {
        assert(option != null);
        Pattern pattern = Pattern.compile(PATTERN_YES_NO);
        Matcher matcher = pattern.matcher(option);
        return matcher.matches();
    }
    


    public int readInt(String title) {
        int input = 0;
        boolean ok = false;
        do {
            try {
                input = Integer.parseInt(this.readString(title));
                ok = true;
            } catch (Exception ex) {
                this.writeError("entero");
            }
        } while (!ok);
        return input;
    }

    public void writeln() {
        System.out.println();
    }
    
    public void write(String title) {
        System.out.print(title);
    }

    public void writeln(String title) {
        System.out.println(title);
    }

    private void writeError(String formato) {
        System.out.println("ERROR DE FORMATO! "
                + "Introduzca un valor con formato " + formato + ".");
    }
}
