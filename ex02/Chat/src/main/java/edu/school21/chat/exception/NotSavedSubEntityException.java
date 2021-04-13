package edu.school21.chat.exception;

public class NotSavedSubEntityException extends RuntimeException{
    public NotSavedSubEntityException() {
    }

    public NotSavedSubEntityException(String s) {
        super(s);
    }

    public NotSavedSubEntityException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public NotSavedSubEntityException(Throwable throwable) {
        super(throwable);
    }
}
