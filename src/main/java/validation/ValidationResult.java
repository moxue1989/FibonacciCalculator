package validation;

import java.util.Objects;

public class ValidationResult {
    private final boolean isValid;
    private final String message;

    private ValidationResult(boolean isValid, String message) {
        this.isValid = isValid;
        this.message = message;
    }

    public static ValidationResult validResult() {
        return new ValidationResult(true, null);
    }

    public static ValidationResult invalidResult(String reason) {
        return new ValidationResult(false, reason);
    }

    public boolean isValid() {
        return isValid;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ValidationResult that = (ValidationResult) o;
        return isValid == that.isValid &&
                Objects.equals(message, that.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isValid, message);
    }

    @Override
    public String toString() {
        return "validation.ValidationResult{" +
                "isValid=" + isValid +
                ", message='" + message + '\'' +
                '}';
    }
}
