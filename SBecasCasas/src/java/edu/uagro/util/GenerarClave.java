
package edu.uagro.util;

import java.security.SecureRandom;

/**
 *
 * @author Fernando
 */
public class GenerarClave {

    static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    static SecureRandom rnd = new SecureRandom();

    public String randomString(int len) {
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        }
        return sb.toString();
    }

//    public static void main(String[] arg) {
//        GenerarClave gClave = new GenerarClave();
//        System.out.println(gClave.randomString(8));
//        System.out.println(gClave.randomString(6));
//    }

}
