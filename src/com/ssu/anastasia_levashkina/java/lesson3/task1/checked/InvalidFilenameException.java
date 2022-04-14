package com.ssu.anastasia_levashkina.java.lesson3.task1.checked;

import java.io.FileNotFoundException;

public class InvalidFilenameException extends MyException {

    public InvalidFilenameException(String message) {
        super(message);
    }
}
