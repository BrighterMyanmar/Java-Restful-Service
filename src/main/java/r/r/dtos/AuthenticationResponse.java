package r.r.dtos;

import java.io.Serializable;

public class AuthenticationResponse implements Serializable {

   private final String jwt;

   public AuthenticationResponse(String jwt) {
      this.jwt = jwt;
   }

   public String getJWt() {
      return jwt;
   }

}
