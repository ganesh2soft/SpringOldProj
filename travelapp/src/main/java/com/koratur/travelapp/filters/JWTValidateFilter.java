package com.koratur.travelapp.filters;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import javax.crypto.SecretKey;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import com.koratur.travelapp.constants.SecurityConstants;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JWTValidateFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		String jwt = request.getHeader(SecurityConstants.JWT_HEADER);
		System.out.println("Received jwt"+jwt);
		if (null != jwt) {
		
			try {
				
				SecretKey key = Keys.hmacShaKeyFor(SecurityConstants.JWT_KEY.getBytes(StandardCharsets.UTF_8));
				/*
				 * String 'jwt' contains Bearer <jwttoken>
				 * So, using Substring operation , First 7 characters have to be removed. Remaining
				 * String will be named as 'jwtsub' and it will be parsed to ParseClaimsJws function 		
				 */
				String jwtsub=jwt.substring(7);
			
				Claims claims = Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(jwtsub).getBody();
				System.out.println("__________Value of Claims____________"+claims.toString());
				
				String username = String.valueOf(claims.get("username"));
				
				String authorities = (String) claims.get("authorities");
				System.out.println("______________________AT JwtValidate _ Inside if ________usernmae is __"+username);
				Authentication auth = new UsernamePasswordAuthenticationToken(username, null,
						AuthorityUtils.commaSeparatedStringToAuthorityList(authorities));
				System.out.println("_________________Auth Object______________"+auth);
				SecurityContextHolder.getContext().setAuthentication(auth);
			} 
			catch (BadCredentialsException e) {
				throw new BadCredentialsException("Error at Token");
			}	
			
			catch (Exception e) {
				System.out.println("*************************");
				e.printStackTrace();
				System.out.println("************************");
			}

		}
		else {System.out.println("________________ELSE Block entered________Means NO TOKEN supplied");
		}
		filterChain.doFilter(request, response);

	}

	@Override
	protected boolean shouldNotFilter(HttpServletRequest request) {
		return request.getServletPath().equals("/login");
	}

}
