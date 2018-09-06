package es.cvjpy;

import javax.swing.UIManager;

/**
 * Hello world!
 *
 */
public class AlfaZ {

    private static AlfaPro alfaEjb;

    public static AlfaPro getAlfaPro() {
        if (alfaEjb == null) {
            alfaEjb = new AlfaEjb();
        }
        return alfaEjb;
    }

    public static void reiniciar() throws Exception {
        alfaEjb = null;
        System.gc();
        String base = "alfa";
        String userName = System.getProperty("user.name", "desconocido");
        AlfaZ main = new AlfaZ();
        main.inicio(base, userName);
        //System.out.println("gc----------------------------------------------------");
        System.gc();
    }
    private final AlfaUI principalUI;

    private AlfaZ() {
        this.principalUI = new AlfaUI();
    }

    private AlfaUI getPrincipalUI() {
        return principalUI;
    }

    private void inicio(String base, String userName) throws Exception {
        getPrincipalUI().setBase(base);
        getPrincipalUI().setUsuarioRemoto(userName);
        getPrincipalUI().inicio();
    }

    public static void main(String[] args) throws Exception {
        String base = "alfa";
        String userName = System.getProperty("user.name", "desconocido");
        AlfaZ main = new AlfaZ();
        main.inicio(base, userName);
    }

}
