package III.oop.collecting;

public class Queues {

    public static void main(String[] args) {
//        LinkingQueue<Integer> numbers = new LinkingQueue<>();
//        numbers.peek();

        LinkingQueue<Player> players = new LinkingQueue<>();
        players.enqueue(new Player("Jarmil"));
        players.enqueue(new Player("Adam"));
        players.enqueue(new Player("Stein"));
        players.enqueue(new Player("Karel"));
        players.enqueue(new Player("Boris"));
        while (players.start != players.end){
            System.out.println("prave hraje: " + players.peek().name);
            Player playerTurn = players.dequeue();
            if (Math.random() <= 0.16){
                System.out.println(playerTurn.name + " bohuzel");
            } else{
                System.out.println(playerTurn.name + " prezil");
            }
        }

        System.out.println("Last man standing " + players.peek().name);
    }

    static void magicPause() throws InterruptedException{
        try{
            Thread.sleep(500);
        }    catch (InterruptedException e){
            throw new RuntimeException(e);
        }
    }

}
class Player {
    String name;
    public Player(String name) {
        this.name = name;
    }
}
class QLink<E>{
    E data;
    QLink<E> next;
}
class LinkingQueue<E>{
    QLink<E> start;
    QLink<E> end;


    void enqueue(E data){
        QLink newLink = new QLink<>();
        newLink.data = data;

       if (start == null){ //Fronta je prazdna
           start = newLink;
           end = start;
       }else{
           end.next = newLink;
           end = newLink;
       }
    }

    E peek(){
        if(start == null){
            return null; //Idealne chybu
        }
        return start.data;
    }
    E dequeue(){
        if(start == null){
            return null; //Idealne chybu
        }
        E tmp = start.data;
        start = start.next;
        return null;
    }
}
