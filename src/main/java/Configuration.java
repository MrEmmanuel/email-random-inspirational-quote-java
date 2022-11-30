import java.util.Map;

public class Configuration {

    Map<String, String> env = System.getenv();
    private String login;
    private String  server;
    private String port;
    private String password;

    public Configuration(){
        this.login = env.get("SMTP_LOGIN");
        this.server  = env.get("SMTP_SERVER");
        this.port  = env.get("SMTP_PORT");
        this.password = env.get("SMTP_PASSWORD");
    }
    public String getLogin(){
        return  login;
    }
    public String getServer(){
        return server;
    }
    public String getPort(){
        return port;
    }
    public String getPassword(){
        return password;
    }
}
