/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conf;

import Admin.addp;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class openweb {
    
    public void open(String url) throws IOException {
		Desktop desktop = java.awt.Desktop.getDesktop();
		 String s=url;
        openweb op=new openweb();
        try {
            op.open(s);
        } catch (IOException ex) {
            Logger.getLogger(addp.class.getName()).log(Level.SEVERE, null, ex);
        }
	}
}
