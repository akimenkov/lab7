import java.util.LinkedList;
import java.util.Scanner;
import java.util.Deque;

public class myDeque {
    static Deque<Integer> f = new LinkedList<>();
    static Deque<Integer> s = new LinkedList<>();
    static int countSteps = 0;

    public static void fillQueue(Deque<Integer> q){
        Scanner in = new Scanner(System.in);
        int inpNum;
        for (int i = 0; i < 5; i++){
            inpNum = in.nextInt();
            q.add(inpNum);
        }
    }

    public static void ex3(){
        System.out.println("Заполнение колоды первого игрока: ");
        fillQueue(f);
        System.out.println("Заполнение колоды второго игрока: ");
        fillQueue(s);

        while(!(f.isEmpty()) && !(s.isEmpty()) && countSteps < 107) {
            if (f.peek() == 0 && s.peek() == 9){
                f.offer(f.peek());
                f.offer(s.peek());
            }
            else if (f.peek() == 9 && s.peek() == 0){
                s.offer(f.peek());
                s.offer(s.peek());
            }
            else if (f.peek() > s.peek()) {
                f.offer(f.peek());
                f.offer(s.peek());
            }
            else {
                s.offer(f.peek());
                s.offer(s.peek());
            }
            f.poll();
            s.poll();
            countSteps++;
        }
        if (countSteps == 106){
            System.out.println("botva");
        }
        else{
            if (f.isEmpty()){
                System.out.println("second " + countSteps);
            }
            else{
                System.out.println("first " + countSteps);
            }
        }
    }
    public static void main(String[] args) {
        ex3();
    }
}