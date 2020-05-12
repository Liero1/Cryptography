package cryptography.base;

public enum OperationType {
    ENCRYPT("Szyfrowanie"), DECRYPT("Deszyfrowanie");

    private String label;


    OperationType(String label) {
        this.label=label;
    }


    public String toString(){
        return label;
    }
}