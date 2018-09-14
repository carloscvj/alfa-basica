/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mirarversion;

import es.cvjpy.aplicacion.VersionAlfa;


/**
 *
 * @author carlos
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        if (args.length > 0) {
            VersionAlfa.say("alfa." + args[0]);
        } else {
            VersionAlfa.say("alfa.aplicacion");
            VersionAlfa.say("alfa.version");
            VersionAlfa.say("alfa.actualizacion");
            VersionAlfa.say("alfa.carpeta");

        }

    }
}
