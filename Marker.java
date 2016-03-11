public enum Marker {

    X("X"),
    O("O"),
    EMPTY(" ");

    public final char input;
    Marker(String input){
        this.input = input.charAt(0);
    }

    public char getInput(){
        return this.input;
    }


}