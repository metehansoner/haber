/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Functions;

import java.io.IOException;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 *
 * @author durmus METEHAN
 */
@Named
@SessionScoped
public class SopDate implements Serializable {

    public String gunceltarih() {
        SimpleDateFormat bicim = new SimpleDateFormat("dd EE MM yyyy hh:mm:ss");
        Date tarihSaat = new Date();
        return bicim.format(tarihSaat);
    }

    public  String encrypt(String str) {
        Random rand = new Random((new Date()).getTime());
        BASE64Encoder encoder = new BASE64Encoder();

        byte[] salt = new byte[8];

        rand.nextBytes(salt);

        return encoder.encode(salt) + encoder.encode(str.getBytes());

    }

    public  String decrypt(String encstr) {

        if (encstr.length() > 12) {

            String cipher = encstr.substring(12);

            BASE64Decoder decoder = new BASE64Decoder();

            try {

                return new String(decoder.decodeBuffer(cipher));

            } catch (IOException e) {

                
            }

        }

        return null;
    }
}
