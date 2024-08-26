package com.prameswaradev.crud_demo_product_supplier.exception;

public class NotFoundException extends RuntimeException {
    public NotFoundException() {
        super("Your data not found!");
    }

    public NotFoundException(String message) {
        super(message);
    }
}
