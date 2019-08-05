package ro.msg.learning.shop.exception;

public class ObjectNotFoundException extends RuntimeException {
    public ObjectNotFoundException() {
        super("Object does not exist!");
    }
}
