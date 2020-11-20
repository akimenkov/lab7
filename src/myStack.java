import java.util.Scanner;
import java.util.Stack;

public class myStack {
    static Stack<Integer> f = new Stack<>();
    static Stack<Integer> s = new Stack<>();
    static int countSteps = 0;

    public static void fillStack(Stack<Integer> stack){
        Scanner in = new Scanner(System.in);
        int inpNum;
        for (int i = 0; i < 5; i++) {
            inpNum = in.nextInt();
            stack.push(inpNum);
        }
    }
    public static Stack<Integer> reverse(Stack<Integer> oldStack){
        Stack<Integer> newStack = new Stack<>();
        while(!(oldStack.empty())){
            newStack.push(oldStack.peek());
            oldStack.pop();
        }
        return newStack;
    }
    public static Stack<Integer> addToBottom(Stack<Integer> oldStack, int val1, int val2){
        Stack<Integer> temp = new Stack<>();
        temp.push(val1);
        temp.push(val2);
        oldStack = reverse(oldStack);
        while(!(oldStack.empty())){
            temp.push(oldStack.peek());
            oldStack.pop();
        }
        return temp;
    }
    public static void ex1() {
        System.out.println("Заполнение колоды первого игрока: ");
        fillStack(f);
        System.out.println("Заполнение колоды второго игрока: ");
        fillStack(s);
        f = reverse(f);
        s = reverse(s);

        while(!(f.empty()) && !(s.empty()) && countSteps < 107) {
            if (f.peek() == 0 && s.peek() == 9){
                f = addToBottom(f, f.peek(), s.peek());
            }
            else if (f.peek() == 9 && s.peek() == 0){
                s = addToBottom(s, f.peek(), s.peek());
            }
            else if (f.peek() > s.peek()) {
                f = addToBottom(f, f.peek(), s.peek());
            }
            else {
                s = addToBottom(s, f.peek(), s.peek());
            }
            f.pop();
            s.pop();
            countSteps++;
        }
        if (countSteps == 106){
            System.out.println("botva");
        }
        else{
            if (f.empty()){
                System.out.println("second " + countSteps);
            }
            else{
                System.out.println("first " + countSteps);
            }
        }
    }

    public static void main(String[] args) {
        ex1();
    }
}