package hu.nye.progtech.wumpus.service;

public class TestInputScanner implements InputScanner {

    private final int input;

    public TestInputScanner(int input) {
        this.input = input;
    }

    @Override
    public int nextInt() {
        return input;
    }
}



