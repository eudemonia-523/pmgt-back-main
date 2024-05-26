package com.pmgt.krish.utils;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.security.SecureRandom;
import java.util.Date;

public class JwtTokenUtil {

    // JWT secret key
    private static final String SECRET_KEY = generateSecretKey();

    // JWT expiration time (in milliseconds)
    private static final long EXPIRATION_TIME = 864_000_000; // 10 days

    // Generate JWT token
    public static String generateToken(String userId) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + EXPIRATION_TIME);

        return Jwts.builder()
                .setSubject(userId)
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
                .compact();
    }

    private static String generateSecretKey() {
        // 定义密钥长度
        int keyLength = 256;
        // 定义字符集合（Base64 支持的字符集）
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=";
        // 定义一个安全的随机数生成器
        SecureRandom random = new SecureRandom();
        // 用于保存生成的随机密钥
        StringBuilder sb = new StringBuilder(keyLength);

        // 循环生成随机字符拼接成密钥
        for (int i = 0; i < keyLength; i++) {
            int randomIndex = random.nextInt(characters.length());
            sb.append(characters.charAt(randomIndex));
        }

        return sb.toString();
    }
}

