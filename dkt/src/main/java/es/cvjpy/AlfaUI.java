/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cvjpy;

import es.cvjpy.aplicacion.ConfiguracionDialog;
import es.cvjpy.aplicacion.AplicacionMenuUI;
import es.cvjpy.aplicacion.ConfiguracionCli;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author carlos
 */
public class AlfaUI extends PrincipalUIAbs implements PrincipalUIPro {

    @Override
    protected void llamaConfiguracionInicial(ConfiguracionCli confCli) {
        ConfiguracionDialog cf = new ConfiguracionDialog();
        cf.setDatos(confCli);
        cf.setVisible(true);
    }

    @Override
    protected JMenuBar crearBarraMenu() {
        JMenuBar root = new JMenuBar();
        JMenu aplic = AplicacionMenuUI.crearAplicacionJM();
        root.add(aplic);
        aplic = AplicacionMenuUI.crearUtilidadesJM();
        root.add(aplic);

        return root;
    }

    @Override
    protected void reiniciaTu() {
        try {
            AlfaZ.reiniciar();
        } catch (Exception ex) {
            Logger.getLogger(AlfaUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected String getUsuarioEnTitulo() {
        return getUsuarioRemoto();
    }

    @Override
    public PrincipalPro getServidor() {
        return AlfaZ.getAlfaPro();
    }

    @Override
    public boolean sePermite(Class mitem) throws Exception {
        return true;
    }

}
