package ru.otus.java.basic.homework14.Exeptions;

public class AppArraySizeException extends RuntimeException {
    public AppArraySizeException(String message) {
        super(message);
    }
}
