package CoffeeShop;

public class Main {
    public static void main(String[] args) {

        CoffeeOrderBoard board = new CoffeeOrderBoard();
        board.add("Nikita"); board.add("Anna"); board.add("Arvid");
        board.deliver();
        board.deliver();
        board.deliver();
       // board.draw();
        board.add("Alex");
        //board.draw();
        board.deliver();
        //board.draw();
        board.add("Helena");
        board.add("Lauren");
        board.draw();
        board.deliver("Lauren", 2);
        board.draw();

    }
}
