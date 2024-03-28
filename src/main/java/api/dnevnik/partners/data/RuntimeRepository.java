package api.dnevnik.partners.data;

public class RuntimeRepository implements DnevnikClientRepository {

    private String accessToken;


    @Override
    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    @Override
    public String getAccessToken() {
        return accessToken;
    }
}
