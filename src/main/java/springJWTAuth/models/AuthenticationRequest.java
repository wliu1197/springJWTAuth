package springJWTAuth.models;

public class AuthenticationRequest {
    private String clientId;

    public AuthenticationRequest() {
    }

    public AuthenticationRequest(String clientId) {
        this.clientId = clientId;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }


}
