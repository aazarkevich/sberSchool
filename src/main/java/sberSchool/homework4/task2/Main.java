package sberSchool.homework4.task2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Введите url адрес.");
            readContent(scanner.next());
        }

    }


    public static void readContent(String urlSource) {
        URLConnection urlConnection;
        try {
            urlConnection = new URL(urlSource).openConnection();
            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(urlConnection.getInputStream()));
            while ((bufferedReader.readLine()) != null) {
                System.out.println(bufferedReader.readLine());
            }
            System.exit(0);
        } catch (MalformedURLException e) {
            System.out.println("Неверный формат url.");
        }catch (ConnectException e) {
            System.out.println("Connection not found.");
        } catch (IOException e) {
            System.out.println("read error");
        }

    }
}
