package org.example.week11;

import java.util.NoSuchElementException;

public class EmptyStudentListException extends NoSuchElementException {
    public EmptyStudentListException() {

        }
    public EmptyStudentListException(String message) {
            super(message);
        }
    public EmptyStudentListException(Throwable cause) {
        super(cause);
    }
}

