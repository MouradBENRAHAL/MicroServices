package gateway_microservice.gateway_microservice;




import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class token {

	private String secret = "NOTESAPI";

	byte[] s = secret.getBytes();

   public Claims getAllClaimsFromToken(String token) { 
        return Jwts.parser().setSigningKey(s).parseClaimsJws(token).getBody();
        
   }

    private boolean isTokenExpired(String token) {
    	
       return this.getAllClaimsFromToken(token).getExpiration().before(new Date());
    }

    public boolean isInvalid(String token) {
       
        return this.isTokenExpired(token);
    }

    
    
    
    
//   	Map<String, Object> claims = new HashMap<>();
//	claims.put("id", 1);
//	claims.put("role","admin")
//  String str=Jwts.builder().setClaims(claims).setSubject("balade").setIssuedAt(new Date(System.currentTimeMillis()))
 //     .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
//	     .signWith(SignatureAlgorithm.HS256, secret).compact();
  //System.out.println(str);
}