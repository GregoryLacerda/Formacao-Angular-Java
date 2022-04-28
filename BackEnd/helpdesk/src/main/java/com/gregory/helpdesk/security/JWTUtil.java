package com.gregory.helpdesk.security;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JWTUtil {
	
	@Value("${jwt.expiration}")
	private Long expiration;
	
	@Value("${jwt.secret}")
	private String secret;
	
	//metodo que vai gerar o token
	public String generateToken(String email) {
		
		return Jwts.builder()
				.setSubject(email)//gera o assunto com o email
				.setExpiration(new Date(System.currentTimeMillis() + expiration))//usa a variavel de expiração
				.signWith(SignatureAlgorithm.HS512, secret.getBytes())//usa o algoritimo hs512 para embaralhar a palavra secreta
				.compact();//compacta o corpo do jwt
	}
}
