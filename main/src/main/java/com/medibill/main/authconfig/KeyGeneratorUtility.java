package com.medibill.main.authconfig;

import java.security.KeyPair;
import java.security.KeyPairGenerator;

public class KeyGeneratorUtility {
    public static KeyPair generateRsaKey(){
        KeyPair keyPair;
        try{
            KeyPairGenerator keyPaiGenerator = KeyPairGenerator.getInstance("RSA");
            keyPaiGenerator.initialize(2048);
            keyPair = keyPaiGenerator.generateKeyPair();
        } catch (Exception e){
            throw new IllegalStateException();
        }
        return keyPair;
    }
}
