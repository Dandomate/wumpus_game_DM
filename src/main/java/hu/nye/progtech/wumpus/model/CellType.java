package hu.nye.progtech.wumpus.model;

public enum CellType {
    WALL('W'), // FAL karakterrel jelölve
    PITFALL('P'), // VEREM karakterrel jelölve
    WUMPUS('U'), // WUMPUSZ karakterrel jelölve
    HERO('H'), // HŐS karakterrel jelölve
    GOLD('G'), // ARANY karakterrel jelölve
    EMPTY('_'); // Új enum érték, amit hozzáadtunk


    private final char symbol; // A karakter, amely a pályán ezt a típust reprezentálja

    CellType(char symbol) {
        this.symbol = symbol;
    }

    public char getSymbol() {
        return symbol;
    }

    public static CellType fromSymbol(char symbol) {
        for (CellType cellType : values()) {
            if (cellType.symbol == symbol) {
                return cellType;
            }
        }
        throw new IllegalArgumentException("Ismeretlen pályaelem: " + symbol);
    }

}
