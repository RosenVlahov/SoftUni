package Exams;

import java.util.Scanner;

public class Username {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String userName = scanner.nextLine();
        StringBuilder names = new StringBuilder();

        for (int i = 0; i < userName.length(); i++) {
            names.append(userName.charAt(i));

        }

        String command = scanner.nextLine();

        while (!command.equals("Sign up")) {
            String[] token = command.split(" ");
            String type = token[0];
            switch (type) {
                case "Case": {
                    if (token[1].equals("lower")) {
                        userName = userName.toLowerCase();
                        System.out.println(userName);

                    } else {
                        userName = userName.toUpperCase();
                        System.out.println(userName);

                    }
                }
                break;
                case "Reverse": {
                    int startIndex = Integer.parseInt(token[1]);
                    int endIndex = Integer.parseInt(token[2]);
                    reverse(userName, startIndex, endIndex);
                }

                break;
                case "Cut": {
                    String substring = token[1];
                    cutString( userName, substring);
                }
                break;
                case "Replace":{
                    String symbols = token[1];
                    replace(userName,symbols);
                }
                    break;
                case "Check":{
                    String symbs = token[1];
                    checks(userName,symbs);
                }
                    break;
            }


            command = scanner.nextLine();

        }
    }

    private static void checks(String userName, String symbs) {
        if(userName.contains(symbs)){
            System.out.println("Valid");
        }else {
            System.out.println(String.format("Your username must contain %s.",symbs));
        }

    }

    private static void replace(String userName, String symbols) {
//        if (userName.contains(symbols)){
//            userName = userName.replace(symbols, "*");
//            System.out.println(userName);
//        }
        userName = userName.replaceAll(symbols,"*");
        System.out.println(userName);
    }

    private static void cutString(String userName, String substring) {
        if (userName.contains(substring)) {
            userName = userName.replace(substring,"");
            System.out.println(userName);

        } else {
            System.out.println(String.format("The word %s doesn't contain %s.", userName, substring));
        }

    }

    private static void reverse(String userName, int startIndex, int endIndex) {
        if (isValidIndex(userName, startIndex) && isValidIndex(userName, endIndex)) {
            for (int i = endIndex; i >= startIndex; i--) {
                System.out.print(userName.charAt(i));

            }
            System.out.println();
        }


    }

    public static boolean isValidIndex(String input, int index) {
        return 0 <= index && index < input.length();
    }
}
