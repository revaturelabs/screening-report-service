package com.revature.screenforce.security;

import java.io.IOException;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.util.Enumeration;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.filter.GenericFilterBean;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.swagger.models.HttpMethod;

public class CustomFilter extends GenericFilterBean {

	String pbKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA4lBSDVhmXm/T0XcT5iAG7iQ75D9cjpO+4wj08y6kOnIk32VPx1Z4hgE0oakCyCiNxaFInZ5ipHrdleROvKl6K+6/nuqLhLcaejbjJOa7Zf1OfugARrI0rq1PAZJdJEoDjDb5VRHi/ULWsTJW6tlNaUX+7ndRyqsA52k8BMe+h03Lrjy0sq7msf9+80Dmdv444jlMFhYIo6J5jSXaHethfZ5xOJoImcga7eueaIT5aDP4zRuG5Ah23TNIRVRciGDaCIuPBZbrzQ64EQIAXy86XYDSYd6i7c/xmCnd64KNO7YV5cH9uLUf2911kTxNYq9Z7My1QXzK9UDTS8m3wceZHwIDAQAB";

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		System.out.println("-------------------------- REQUEST IN CUSTOMFILTER --------------------------");
		System.out.println(request.toString());

		HttpServletRequest req = (HttpServletRequest) request;
		Enumeration<String> names = req.getHeaderNames();

		if (!req.getMethod().equals(HttpMethod.OPTIONS)) {

			while (names.hasMoreElements()) {
				System.out.println(names.nextElement());
			}
			String token = req.getHeader("tokens");

			try {
				byte[] publicBytes = Base64.getDecoder().decode(pbKey);
				X509EncodedKeySpec keySpec = new X509EncodedKeySpec(publicBytes);
				KeyFactory keyFactory = KeyFactory.getInstance("RSA");
				PublicKey pubKey = keyFactory.generatePublic(keySpec);

				Jws<Claims> parsedToken = Jwts.parser().setSigningKey(pubKey).parseClaimsJws(token);

				System.out.println(parsedToken.getBody());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		chain.doFilter(request, response);
	}

}
