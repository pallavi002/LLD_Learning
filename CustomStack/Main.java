class MyStack<T> {
    private Object[] arr;
    private int top;
    private static final int MAX = 1000;

    public MyStack() {
        arr = new Object[MAX];
        top = -1;
    }

    public void push(T x) {
        if (top == MAX - 1) return; // overflow protection
        arr[++top] = x;
    }

    @SuppressWarnings("unchecked")
    public T pop() {
        if (top < 0) return null; // underflow
        return (T) arr[top--];
    }
}