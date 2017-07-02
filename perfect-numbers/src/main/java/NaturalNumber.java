class NaturalNumber {

    private int value;
    private Classification classification;

    public int getValue() {
        return value;
    }
    public Classification getClassification() {
        return classification;
    }

    public NaturalNumber(int value) {
        if (value < 1) {
            throw new IllegalArgumentException("You must supply a natural number (positive integer)");
        }
        this.value = value;
        this.classification = Classification.createClassification(value);
    }
}
