package com.metanit;
import  java.io.FileReader;
import java.util.Scanner;
import java.lang.String;
import java.util.List;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws Exception {
        FileReader reader = new FileReader("C:\\Users\\honey\\IdeaProjects\\DKA\\src\\com\\metanit\\text.txt");
        Scanner scan = new Scanner(reader);

        String str = new String(scan.nextLine());
        System.out.println(str);
        int count = str.length();
        char[] array = str.toCharArray();
        List<Character> string = new ArrayList<Character>();


        int flag = 0;
        int countElementsOfList = 0;
        int countElementsOfStar = 0;
        int countElementsOfA = 0;
        int enterOneTime = 0;

        for (int i = 0; i < count; i++) {
            if (array[i] == '%') {
                if (flag == 0) {
                    if (i < (count - 5) && (array[i + 1] == '*') && (array[i + 2] == 'a')) {
                        flag = 1;
                        string.add(array[i]);
                        countElementsOfList++;
                    }
                } else{
                    if (flag == 1) {
                    string.add(array[i]);
                    countElementsOfList++;
                    if ((countElementsOfA > 0) && (countElementsOfStar % 2 == 0) && !string.isEmpty()) {
                        enterOneTime++;
                        for (int j = 0; j < countElementsOfList; j++) {
                            System.out.print(string.get(j));
                        }
                        System.out.println();
                    }
                        flag = 0;
                        string.clear();
                        countElementsOfList = 0;
                        countElementsOfStar = 0;
                        countElementsOfA = 0;
                    }
                }
            }

            if (array[i] == '*') {
                if (flag == 0) continue;
                if (flag == 1){
                    if ((array[i + 1] == 'a') && array[i - 1] == '%'){
                            string.add(array[i]);
                            countElementsOfList++;
                    } else {
                        if ((array[i + 1] == 'a') && (array[i - 1] != '%') && (countElementsOfA == 0)){
                                flag = 0;
                                string.clear();
                                countElementsOfList = 0;
                                countElementsOfStar = 0;
                                countElementsOfA = 0;
                        } else {
                            if (countElementsOfA > 0) {
                                countElementsOfStar++;
                                string.add(array[i]);
                                countElementsOfList++;
                            }
                        }
                    }
                }
            }

            if (array[i] == 'a') {
                if (flag == 0) continue;
                if (flag == 1) {
                    if ((i > 2) && (array[i - 2] == '%') && (array[i - 1] == '*')) {
                        string.add(array[i]);
                        countElementsOfList++;
                        countElementsOfA++;
                    } else {
                        if ((countElementsOfStar % 2 != 0) && (countElementsOfA > 0)) {
                            string.add(array[i]);
                            countElementsOfList++;
                            countElementsOfA++;
                            countElementsOfStar = 0;
                        } else {
                            flag = 0;
                            string.clear();
                            countElementsOfList = 0;
                            countElementsOfStar = 0;
                            countElementsOfA = 0;
                        }
                    }
                }
            }
        }
        if (enterOneTime == 0) System.out.println("Nothing!");
    }
}
