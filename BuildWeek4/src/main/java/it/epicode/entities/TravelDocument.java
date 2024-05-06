package it.epicode.entities;

public abstract class TravelDocument extends BaseEntity {
    private boolean valid;

    public TravelDocument() {
        this.valid = true;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    @Override
    public String toString() {
        return "TravelDocument{" + "valid=" + valid + '}';
    }
}
