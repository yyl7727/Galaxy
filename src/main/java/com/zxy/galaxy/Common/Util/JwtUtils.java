package com.zxy.galaxy.Common.Util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * jwt工具类
 */
@Data
@Component
@ConfigurationProperties(prefix = "galaxy.jwt")
public class JwtUtils {
    private String secretKey;
    private long expire;
    private String header;

    public String genetateToken(String username) {
        Date dateNow = new Date();
        Date expireDate = new Date(dateNow.getTime() + expire * 1000);
        return Jwts.builder()
                .setHeaderParam("type", "token")
                .setSubject(username)
                .setIssuedAt(dateNow)
                .setExpiration(expireDate)
                .signWith(SignatureAlgorithm.HS512, secretKey)
                .compact();
    }

    public Claims getClamiByToken(String token) {
        try {
            return Jwts.parser()
                    .setSigningKey(secretKey)
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * token是否过期
     * @param expiration
     * @return
     */
    public boolean isTokenExpired(Date expiration) {
        return expiration.before(new Date());
    }
}
