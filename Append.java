import java.io.*;
import java.util.Scanner;

public class Append {

    public void append(String path, String toAppend) throws PathException {

        File input = new File(path);

        try {

            BufferedReader br = new BufferedReader(new FileReader(input));
            BufferedWriter bw = new BufferedWriter(new FileWriter(input, false));
            bw.write(toAppend);

            br.close();
            bw.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("Enter the path to the file:");
        String path = scan.nextLine();

        System.out.println("Enter the line to append:");
        String toAppend = scan.nextLine();

        Append a = new Append();
        try {
            a.append(path, toAppend);
        } catch (PathException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}