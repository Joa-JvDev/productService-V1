package jva.dev.producservicev1.enums;

import org.springframework.http.HttpStatus;

public enum APIError {
    // Validation Errors
    VALIDATION_ERROR(HttpStatus.BAD_REQUEST, "There are attributes with invalid values"),
    BAD_FORMAT(HttpStatus.BAD_REQUEST, "The request does not have a correct format"),
    MISSING_REQUIRED_FIELDS(HttpStatus.BAD_REQUEST, "Required fields are missing"),

    // Product Errors
    PRODUCT_NOT_FOUND(HttpStatus.NOT_FOUND, "Product not found"),
    DUPLICATE_PRODUCT(HttpStatus.BAD_REQUEST, "A product with the same details already exists"),
    PRODUCT_SAVE_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "Failed to save the product"),
    PRODUCT_DELETE_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "Failed to delete the product"),
    PRODUCT_UPDATE_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "Failed to update the product"),

    // Inventory or Stock Errors
    INSUFFICIENT_STOCK(HttpStatus.BAD_REQUEST, "Insufficient stock for the requested product"),
    INVALID_STOCK_VALUE(HttpStatus.BAD_REQUEST, "Stock value cannot be negative"),
    EMPTY_PRODUCT_LIST(HttpStatus.NOT_FOUND, "No products found"),


    // Pricing Errors
    INVALID_PRICE(HttpStatus.BAD_REQUEST, "The price must be a positive number"),
    PRICE_UPDATE_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "Failed to update the product price"),

    // General Errors
    UNKNOWN_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "An unknown error occurred"),
    UNAUTHORIZED_ACCESS(HttpStatus.UNAUTHORIZED, "Unauthorized access to the resource");

    private final HttpStatus httpStatus;
    private final String message;

    APIError(HttpStatus httpStatus, String message){
        this.httpStatus = httpStatus;
        this.message = message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public String getMessage() {
        return message;
    }
}
