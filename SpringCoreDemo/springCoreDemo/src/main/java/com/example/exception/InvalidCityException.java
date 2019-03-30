package com.example.exception;

public class InvalidCityException extends Exception
{
                private static final long serialVersionUID = 1L;
                public InvalidCityException(String message)
                {
                                super(message);
                }
}