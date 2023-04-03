import java.util.Arrays;
 
class Main
{
    // возвращает левого потомка `A[i]`
    private static int LEFT(int i) {
        return (2*i + 1);
    }
 
    // возвращает правого потомка `A[i]`
    private static int RIGHT(int i) {
        return (2*i + 2);
    }
 
    // функция для замены двух индексов в массиве
    private static void swap(int[] A, int i, int j)
    {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
 

    private static void heapify(int[] A, int i, int size)
    {
        // возвращает левого и правого потомкa узла с индексом `i`
        int left = LEFT(i);
        int right = RIGHT(i);
 
        int largest = i;
 
        // сравниваем A[i] с его потомками
        // и находим наибольшее значение
        if (left < size && A[left] > A[i]) {
            largest = left;
        }
 
        if (right < size && A[right] > A[largest]) {
            largest = right;
        }
 
        if (largest != i)
        {
            swap(A, i, largest);
            heapify(A, largest, size);
        }
    }
 
    // Функция для удаления элемента 
    public static int pop(int[] A, int size)
    {
        // если в куче пуста
        if (size <= 0) {
            return -1;
        }
 
        int top = A[0];
 
        // заменяем корень кучи последним элементом
        // массива
        A[0] = A[size-1];
 
        // вызовите heapify-down на корневом узле
        heapify(A, 0, size - 1);
 
        return top;
    }
 
    // Функция для выполнения пирамидальной сортировки массива
    public static void heapsort(int[] A)
    {
        int n = A.length;
        int i = (n - 2) / 2;

        while (i >= 0) {
            heapify(A, i--, n);
        }
 
        // до опустошения кучи
        while (n > 0)
        {
            A[n - 1] = pop(A, n);
            n--;
        }
    }
 
    // Реализация алгоритма Heapsort в Java
    public static void main(String[] args)
    {
        int[] A = { 34, 2, 29, -5, 94, 2 };
 
        // выполняем сортировку массива
        heapsort(A);
 
        // печатаем отсортированный массив
        System.out.println(Arrays.toString(A));
    }
}