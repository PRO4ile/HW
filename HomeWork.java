package src;

import java.util.Scanner;

public class HomeWork {
    public static void main(String[] args) {
        //2+3
        //X+V=XV
        src.Converter converter = new src.Converter();
        String[] actions = {"+", "-", "/", "*"};
        String[] regexActions = {"\\+", "-", "/", "\\*"};
        Scanner scn = new Scanner(System.in);
        System.out.print("Введите выражение: ");
        String exp = scn.nextLine();
        //Определяем арифметическое действие:
        int actionIndex=-1;
        for (int i=0; i < actions.length; i++) {
            if(exp.contains(actions[i])){
                actionIndex = i;
                break;
            }
        }
        //Если не нашли арифметического действия, завершаем программу
        if(actionIndex==-1){
            System.out.println("Некорректное выражение");
            return;
        }
        //Делим строчку по найденому арифметическому знаку

        String[] data = exp.split(regexActions[actionIndex]);
        //Определяем, находятся ли числа в одному формате
        if(converter.isRoman(data[0]) == converter.isRoman(data[1])){
            int a,b;
            //Определяем римкие ли это цифры
            boolean isRoman = converter.isRoman(data[0]);
            if(isRoman){
                //Если римкие, то конвертируем их в арабские
                //X+V
                //x-10
                //v - 5
                a = converter.romanToInt(data[0]);
                b = converter.romanToInt(data[1]);

            }else{
                //Если арабские, конвертируем из строчки в число
                a = Integer.parseInt(data[0]);
                b = Integer.parseInt(data[1]);
            }
            //Выполняем с числами арифметическое действие
            int result = 0;
            switch (actions[actionIndex]){
                case "+":
                    result = a+b;
                    break;
                case "-":
                    result = a-b;
                    break;
                case "/":
                    result = a/b;
                    break;
                case "*":
                    result = a*b;
                    break;
            }
            // 15->XV
            if(isRoman){
                //Если числа были римские, возвращаем результат в римском числе
                System.out.println(converter.intToRoman(result));
            }
            else{
                //Если числа были арабские, возвращаем результат в арабском числе
                System.out.println(result);
            }
        }else{
            System.out.println("Числа должны быть в одном формате");
        }


    }
}