package luxoft.example.springboot.bean;

public class WelcomeBean {

    private String message;


    public WelcomeBean(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
