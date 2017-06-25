package com.golestan.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.golestan.rests.viewmodels.TokenModel;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class JwtService {
	@Value("${token.secret}")
	String tokenSecret;

	@Value("${fifteenMins.accessToken}")
	private long accessTokenMilliSeconds;

	

	public TokenModel generateToken(Long userid) {
		TokenModel tokenModel = new TokenModel();
		Long expire = System.currentTimeMillis();
		tokenModel.setAccessTokenExipreTime(expire + accessTokenMilliSeconds);
		tokenModel.setAccessToken(generateJwtToken(userid, (expire + accessTokenMilliSeconds)));
		return tokenModel;
	}


	private String generateJwtToken(Long userid, Long expireDate) {
		String generatedToken = Jwts.builder().setSubject(String.valueOf(userid))
				.signWith(SignatureAlgorithm.HS256, tokenSecret).setExpiration(new Date(expireDate)).compact();
		return generatedToken;
	}
}

