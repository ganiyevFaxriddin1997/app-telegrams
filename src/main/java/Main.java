import constant.Constant;
import dto.response.UserResponseDto;

import java.lang.constant.Constable;
import java.util.Scanner;

public class Main implements Constant {
    static Scanner scannerInt = new Scanner(System.in);
    static Scanner scannerStr = new Scanner(System.in);
    static int option;
    public static void main(String[] args) {
        while (true) {
            System.out.println(ENTRANCE);
            option = scannerInt.nextInt();
            if (option == 1) {
                signUp();
            } else if (option == 2) {
                signIn();
            } else if (option == 0) {
                break;
            } else
                System.out.println(WRONG_OPTION);
        }

    }

    private static void home(UserResponseDto user){

    }
    private static void signIn() {

    }

    private static void signUp() {
    }
}