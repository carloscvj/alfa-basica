package es.cvjpy;

import es.cvjpy.cobol.ServidorConfiguracion;
import es.cvjpy.cobol.ServidorConfiguracionDialog;
import es.cvjpy.cobol.servidor.SockCobol;
import es.cvjpy.cobol.servidor.SockJava;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * Hello world!
 *
 */
public class AlfaS {

    public AlfaS() {
    }

    public void inicio(String appBase, String userName) throws Exception {
        ServidorConfiguracion sc = new ServidorConfiguracion(appBase, userName);
        if (sc.getMostrarInicial()) {
            ServidorConfiguracionDialog scd = new ServidorConfiguracionDialog();
            scd.setDatos(sc);
            scd.setVisible(true);
            sc = new ServidorConfiguracion(appBase, userName); //Pa que vuelva a cargar lo modificado en el dialogo.
        }
        sc.grabar();
        SockJava sj = new SockJava(sc);
        SockCobol sp = new SockCobol(sc);
        sp.start();
        sj.start();
    }

    public static void main(String[] args) {
        String appBase = "alfa";
        String userName = System.getProperty("user.name", "desconocido");
        AlfaS main = new AlfaS();
        try {
            main.inicio(appBase, userName);
        } catch (Exception ex) {
            Logger.getLogger(AlfaS.class.getName()).log(Level.SEVERE, null, ex);
            System.exit(-1);
        }
    }
}
