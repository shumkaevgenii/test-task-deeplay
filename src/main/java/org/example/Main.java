package org.example;


import java.util.*;


public class Main {
    public static void main(String[] args) {
        int ARR_SIZE = 10;
        int[] arr = new int[ARR_SIZE];

        System.out.println("First Task:");
        firstTask(arr, ARR_SIZE);

        System.out.println("Second Task:");
        secondTask(arr, ARR_SIZE);

        System.out.println("Fourth Task:");
        List<List<Integer>> groups = fourthTask(arr, ARR_SIZE);

        if (groups != null) {
            for (List<Integer> item : groups) {
                System.out.println(item.toString());
            }
        }
    }

    public static void input(int[] arr, int ARR_SIZE){
        Random random = new Random();
        for (int i = 0; i < ARR_SIZE; i++) {
            arr[i] = random.nextInt(10);
        }
    }

    public static void firstTask(int[] arr, int ARR_SIZE) {
        input(arr, ARR_SIZE);

        // Вывод исходного массива
        for (int val : arr) {
            System.out.print(val + " ");
        }
        System.out.println();

        // Сортировка массива по возрастанию
        Arrays.sort(arr);


        int[] resultArr = new int[ARR_SIZE];
        int fillIndex = 0;
        // Поиск нечетных элементов
        for (int i = 0; i < ARR_SIZE; i++) {
            if (arr[i] % 2 != 0) {
                resultArr[fillIndex] = arr[i];
                fillIndex++;
            }
        }

        // Поиск нулей
        for (int i = 0; i < ARR_SIZE; i++) {
            if (arr[i] == 0) {
                resultArr[fillIndex] = arr[i];
                fillIndex++;
            }
        }

        // Остальное
        for (int i = ARR_SIZE - 1; i >= 0; i--) {
            if (arr[i] != 0 && arr[i] % 2 == 0) {
                resultArr[fillIndex] = arr[i];
                fillIndex++;
            }
        }

        // Вывод результата
        for (int val : resultArr) {
            System.out.print(val + " ");
        }
        System.out.println();
    }

    public static void secondTask(int[] arr, int ARR_SIZE) {
        input(arr, ARR_SIZE);

        // Вывод массива
        for (int val : arr) {
            System.out.print(val + " ");
        }
        System.out.println();


        // Поиск индексов наиболее часто встречающихся чисел
        List<Integer> indicesOfPopularValues = new ArrayList<>();
        int count = 0;
        int max = 0;
        for (int i = 0; i < ARR_SIZE; i++) {
            for (int j = 0; j < ARR_SIZE; j++) {
                if (arr[i] == arr[j]) {
                    count++;
                }
            }
            if (count == max) {
                indicesOfPopularValues.add(i);
            }
            if (count > max) {
                max = count;
                indicesOfPopularValues.clear();
                indicesOfPopularValues.add(i);
            }
            count = 0;
        }

        // Добавление наиболее часто встречающихся чисел в Set, чтобы избавиться от повторений
        Set<Integer> result = new HashSet<>();
        for (Integer index : indicesOfPopularValues) {
            result.add(arr[index]);
        }

        // Вывод результата
        for (Integer integer : result) {
            System.out.print(integer + " ");
        }
        System.out.println();
    }

//    public static void thirdTask() {
//        int sequenceSize = 100;
//        int[] playerSequence1 = new int[3];
//        int[] playerSequence2 = new int[3];
//        Random random = new Random();
//
//        for (int i = 0; i < 3; i++) {
//            playerSequence1[i] = random.nextInt(6) + 1;
//            playerSequence2[i] = random.nextInt(6) + 1;
//        }
//
//        System.out.println("Числа 1-го игрока: ");
//        for (int val : playerSequence1) {
//            System.out.print(val + " ");
//        }
//        System.out.println('\n' + "Числа 2-го игрока: ");
//        for (int val : playerSequence2) {
//            System.out.print(val + " ");
//        }
//        System.out.println();
//
//
//        int[] sequence = new int[sequenceSize];
//        for (int i = 0; i < sequenceSize; i++) {
//            sequence[i] = random.nextInt(6) + 1;
//        }
//
//        System.out.println("Последовательность: ");
//        for (int val : sequence) {
//            System.out.print(val + " ");
//        }
//        System.out.println();
//
//        int scorePlayer1 = getPlayerScore(sequenceSize, playerSequence1, sequence);
//        int scorePlayer2 = getPlayerScore(sequenceSize, playerSequence2, sequence);
//
//        System.out.println("Player1 score: " + scorePlayer1);
//        System.out.println("Player2 score: " + scorePlayer2);
//
//
//    }
//
//    public static int getPlayerScore(int sequenceSize, int[] playerSequence, int[] sequence) {
//        int score = 0;
//        for (int i = 0; i < sequenceSize - 2; i++) {
//            int count = 0;
//            for (int j = 0; j < 3; j++) {
//                if (playerSequence[j] == sequence[i + j]) {
//                    count++;
//                }
//            }
//            if (count == 3) {
//                score++;
//                i += 2;
//            }
//            count = 0;
//        }
//        return score;
//    }

    public static List<List<Integer>> fourthTask(int[] arr, int ARR_SIZE) {
        Scanner in = new Scanner(System.in);
        int requiredSumOfEveryGroup;
        int arraySum = 0;
        System.out.println("Введите количество групп:");
        int numOfGroups = in.nextInt();

        System.out.println("Введите значения массива: ");
        for (int i = 0; i < ARR_SIZE; i++) {
            arr[i] = in.nextInt();
        }

        for (Integer i : arr) {
            arraySum += i;
        }

        if (numOfGroups > arr.length) {
            System.out.println("Error");
            return null;
        }

        if (arraySum % numOfGroups != 0) {
            System.out.println("Error");
            return null;
        }

        // Получение суммы каждой группы
        requiredSumOfEveryGroup = arraySum / numOfGroups;

        List<List<Integer>> groups = new ArrayList<>();
        List<Integer> group = new ArrayList<>();

        int baseIndex = 1;
        int sumOfGroup = 0;
        int start = 0, end = 1;
        int numOfFinedGroups = 0;

        // Перебор всех чисел массива, которые равны requiredSumOfEveryGroup
        for (int i = 0; i < ARR_SIZE; i++) {
            if (arr[i] == requiredSumOfEveryGroup) {
                groups.add(List.of(arr[i]));
                numOfFinedGroups++;
            }
            if (numOfFinedGroups == numOfGroups) {
                return groups;
            }
        }

        // Перебор всех комбинаций массива, сумма которых равна requiredSumOfEveryGroup
        for (int k = 2; k < ARR_SIZE; k++) {

            for (int r = 1; r < ARR_SIZE; r++) {

                for (int i = baseIndex; i < ARR_SIZE; i++) {

                    for (int j = i; j < i + 1; j++) {


                        for (int g = start; g < end; g++) {
                            sumOfGroup += arr[g];
                            group.add(arr[g]);
                        }

                        sumOfGroup += arr[j];
                        group.add(arr[j]);
                    }

                    if (sumOfGroup == requiredSumOfEveryGroup) {
                        groups.add(new ArrayList<>(group));
                        numOfFinedGroups++;
                        if (numOfFinedGroups == numOfGroups) {
                            return groups;
                        }
                    }
                    group.clear();
                    sumOfGroup = 0;
                }
                baseIndex++;
                start++;
                end++;
            }
            start = 0;
            end = k;
            baseIndex = k;
        }
        return null;
    }
}
