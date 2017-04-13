enum Signal {

    WINK (1),
    DOUBLE_BLINK(2),
    CLOSE_YOUR_EYES(4),
    JUMP(8),
    REVERSE(16);

    private final int mask;

    Signal(int mask) {
        this.mask = mask;
    }

    public boolean isInHandshake (int handshake) {
        return this.mask == (this.mask & handshake);
    }
}
