package com.cemal.utility;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import com.cemal.repository.entity.Type;
import com.cemal.repository.entity.UserProfile;
import com.cemal.service.UserProfileService;
import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Optional;

@Component

public class JwtTokenManager {
    @Value("${authservices.secrets.secret-key}")
    String secretKey;
    @Value("${authservices.secrets.issuer}")
    String issuer;
    Long exDate = 5000L * 60; //5dk

    //1. token üret.





    public Optional<String> createToken(Long id, String  type) {
        String token = "";
        System.out.println(type);


        try {
            token = JWT.create().withAudience()
                    .withClaim("id", id)
                  .withClaim("type", type)

                    .withClaim("whichpage", "UserProfileService")
                    .withClaim("lastjoin", System.currentTimeMillis())
                    .withClaim("ders", "Java JWT")
                    .withClaim("grup", "Java 9")
                    .withIssuer(issuer) //jwt token oluşturan yapı
                    .withIssuedAt(new Date()) //jwt token oluşturulma zamanı
                    .withExpiresAt(new Date(System.currentTimeMillis() + exDate))
                    .sign(Algorithm.HMAC512(secretKey));
            return Optional.of(token);
        } catch (Exception ex) {
            return Optional.empty();
        }

    }

    //2. tokeni doğrula
    public Boolean verifyToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC512(secretKey);
            JWTVerifier verifier = JWT.require(algorithm).withIssuer(issuer).build();
            DecodedJWT decodedJWT = verifier.verify(token);
            if (decodedJWT == null) return false;
        }
        catch (Exception e){
            return false;
        }
        return true;
    }

    //3. tokendan bilgi çıkarımı yap.
    public Optional<Long> getIdFromToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC512(secretKey);
            JWTVerifier verifier = JWT.require(algorithm).withIssuer(issuer).build();
            DecodedJWT decodedJWT = verifier.verify(token);
            if (decodedJWT == null) return Optional.empty() ;
            Long id=decodedJWT.getClaim("id").asLong();
            String whichpage=decodedJWT.getClaim("whichpage").asString();
            //System.out.println("Tokendaki which page:"+whichpage);
            return Optional.of(id);
        }
        catch (Exception e){
            return Optional.empty();
        }
    }

    public Optional<String> gettypeFromToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC512(secretKey);
            JWTVerifier verifier = JWT.require(algorithm).withIssuer(issuer).build();
            DecodedJWT decodedJWT = verifier.verify(token);
            if (decodedJWT == null) return Optional.empty() ;
           String type=decodedJWT.getClaim("type").asString();
            String whichpage=decodedJWT.getClaim("whichpage").asString();
            //System.out.println("Tokendaki which page:"+whichpage);
            System.out.println(type);
            return Optional.of(type);
        }
        catch (Exception e){
            return Optional.empty();
        }
    }
}
