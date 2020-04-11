package com.snake19870227.stiger.shopping;

import cn.hutool.core.codec.Base64;
import cn.hutool.core.lang.Console;
import cn.hutool.crypto.asymmetric.RSA;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.security.KeyPair;

/**
 * @author Bu HuaYang (buhuayang1987@foxmail.com)
 * 2020/04/10
 */
public class JwtKeyGenerator {

    public static void main(String[] args) {
        KeyPair keyPair = Keys.keyPairFor(SignatureAlgorithm.RS256);
        String publicStr = Base64.encode(keyPair.getPublic().getEncoded());
        String privateStr = Base64.encode(keyPair.getPrivate().getEncoded());
        Console.log("publicStr:{}", publicStr);
        Console.log("privateStr:{}", privateStr);

        RSA rsa = new RSA(privateStr, publicStr);
        Console.log("publicKey:{}", rsa.getPublicKey());
        Console.log("privateKey:{}", rsa.getPrivateKey());
    }
}
