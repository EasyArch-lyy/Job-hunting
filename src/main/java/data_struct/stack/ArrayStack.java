package data_struct.stack;

import java.lang.reflect.Array;

/**
 * 栈练习
 * @author lyy
 */
public class ArrayStack<T> {

	/**栈的默认大小*/
	private final static int DEFAULT_SIZE = 10;
	/**栈的数组结构*/
	private T[] mArray;
	/**栈“指针”*/
	private int top;
	/**栈中元素的个数*/
	private int count;

	public ArrayStack(Class<T> type) {
		//调用下面的构造函数
		this(type, DEFAULT_SIZE);
	}
	
	public ArrayStack(Class<T> type, int size) {
		//通过java反射机制创建动态数组
		mArray = (T[])Array.newInstance(type, DEFAULT_SIZE);
		count = 0;
		top = -1;
	}
	
	//进栈
	public void push(T data) {
		mArray[++top] = data;
		count++;
	}
	
	//判断栈是否为空
	public boolean isEmpty() {
		return top == -1;
	}
	
	//判断栈是否满
	public boolean isFull() {
		return count == DEFAULT_SIZE;
	}
	
	//出栈
	public T pop() {
		T m = mArray[top];
		top--; count--;
		return m;
	}
	
	//获取栈顶元素,不删除栈顶元素
	public T peek() {
		return mArray[count-1];
	}
	
	//打印栈
	public void print() {
		if(!isEmpty()) {
			for(int i = 0; i <= top; i++) {
				System.out.println(mArray[i]);
			}
		}
		System.out.println("count="+count);
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayStack<String> stack = new ArrayStack<String>(String.class);
		//依次进栈10,20,30
		System.out.println("依次进栈：");
		stack.push("10");
		stack.push("20");
		stack.push("30");
		
		//打印栈
		stack.print();
		
		//获取栈顶元素
		System.out.println("栈顶元素为："+stack.peek());
		
		//判断栈是否为空
		System.out.println("isEmpty:"+stack.isEmpty());
		
		//判断栈是否为满
		System.out.println("isFull:"+stack.isFull());
		
		//依次出栈
		System.out.println("\n"+"依次出栈：");
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		stack.print();
		System.out.println("isEmpty:"+stack.isEmpty());
		System.out.println("isFull:"+stack.isFull());
	}

}