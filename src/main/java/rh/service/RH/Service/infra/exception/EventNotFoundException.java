package rh.service.RH.Service.infra.exception;

public class EventNotFoundException extends RuntimeException{
    public EventNotFoundException(){
        super("Evento está lotado!");
    }

    public EventNotFoundException(String message) {
        super(message);
    }
}
