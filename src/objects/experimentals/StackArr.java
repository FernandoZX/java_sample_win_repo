package objects.experimentals;

public class StackArr {
    int maxLength;
    int top;
    int list[];

    public StackArr(int max) {
        maxLength = max;
        list = new int[maxLength];
        top = -1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == list.length - 1;
    }

    public int size() {
        return list.length;
    }

    public void push(int element) throws InterruptedException {
        if (size() < 0) {
            System.out.println("Please define the stack size before pushing elements");
            return;
        }
        if (!isFull()) {
            top = top + 1;
            System.out.println(top);
            Thread.sleep(5000);
            list[top] = element;
            System.out.println("Element : " + element + " was pushed to this stack with remaning spaces:" + checkRemainingSpace());
        } else {
            System.out.println("Cannot push this element: " + element + " the size of the stack is :" + maxLength);
        }
    }

    public int checkRemainingSpace() {
        return (list.length - (top + 1));
    }

    public int pop() {
        if (size() < 0) {
            System.out.println("Please define the stack size before popping elements");
            return 1;
        }
        if (top >= 0) {
            int element = list[--top];
            System.out.println("Element : " + element + " was removed of this stack :" + list);
            return element;
        } else {
            System.out.println("Cannot remove further elements of this list" + list);
        }
        return 1;
    }
}
