package luxoft.example.springboot.exceptions;

public class TodoNotFoundException extends RuntimeException{

    public TodoNotFoundException(String msg){
        super(msg);
    }
}
