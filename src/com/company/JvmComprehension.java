package com.company;

public class JvmComprehension {

    public static void main(String[] args) {
        int i = 1;                      // 1 в Stack в блоке main() создается переменная "i" типа int (т.к. примитивный тип)
        Object o = new Object();        // 2 в heap создается объект класса Object, затем в Stack в блоке main() создается ссылочная переменная "o" типа Object
        Integer ii = 2;                 // 3 в heap создается объект класса Integer, затем в Stack в блоке main() создается ссылочная переменная "ii" типа Integer
        printAll(o, i, ii);             // 4 в Stack поверх блока main() создается блок printAll(), в который передаются все значения ссылочных переменных их блока main()
        System.out.println("finished"); // 7 в Stack создается новый блок, в который передается ссылка на строку "finished". После чего блок main() завершается, память для данного метода в Stack уничтожается. После чего Java runtime освобождает всю память, т.к. программа заканчивается
    }

    private static void printAll(Object o, int i, Integer ii) {
        Integer uselessVar = 700;                   // 5 в heap создается объект класса Integer, затем в Stack в блоке printAll() создается ссылочная переменная "uselessVar" типа Integer
        System.out.println(o.toString() + i + ii);  // 6 в Stack поверх блока main() и блока printAll() создается новый блок, при этом в heap создается String Pool, ссылка на который передается в новый созданный в Stack блок
    }
}

