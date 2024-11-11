package III.oop.collecting;

public class Queues {

}
class QLink{
    int data;
    QLink next;
}
class LinkingStack{
    QLink start;
    QLink end;


    void enqueue(int data){
       if (start == null){ //Fronta je prazdna
           start = new QLink();
           start.data = data;
           end = start;
       }else{
           end.next = new QLink();
           end.next.data = data;
           end = end.next;
       }
    }

    int dequeue(){
        return 0;
    }
}
