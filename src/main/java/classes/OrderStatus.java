package classes;

public enum OrderStatus {
    PENDING("Pending"),
    COMPLETED("Complete"),
    CANCELED("Cancel");
    private String status;
    OrderStatus(String status) {
        this.status=status;
    }

    @Override
    public String toString() {
        return status;
    }
}
