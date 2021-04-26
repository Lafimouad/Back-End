package ConsomiTounsi.configuration.token;

public class JwtResponse {
    public String getJwtToken() {
        return jwtToken;
    }

    public JwtResponse(String jwtToken) {
        this.jwtToken = jwtToken;
    }

    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }

    private String jwtToken;

    public JwtResponse() {
    }
}
