import java.io.File;
import java.util.Scanner;

public class Task4 {

    // Calculate total directory size
    public static long calculateSize(File directory) {

        long totalSize = 0;

        File[] files = directory.listFiles();

        if (files != null) {

            for (File file : files) {

                if (file.isFile()) {
                    totalSize += file.length();
                }

                else if (file.isDirectory()) {
                    totalSize += calculateSize(file);
                }
            }
        }

        return totalSize;
    }

    // Display individual directory sizes
    public static void showDirectorySizes(File directory) {

        File[] files = directory.listFiles();

        if (files != null) {

            for (File file : files) {

                if (file.isDirectory()) {

                    long size = calculateSize(file);

                    System.out.println(
                            file.getName() + " : " +
                                    size + " Bytes"
                    );

                    showDirectorySizes(file);
                }
            }
        }
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter directory path: ");

        String path = input.nextLine();

        File directory = new File(path);

        if (!directory.exists() || !directory.isDirectory()) {

            System.out.println("Error: Directory does not exist!");

        } else {

            long totalSize = calculateSize(directory);

            double kb = totalSize / 1024.0;
            double mb = totalSize / (1024.0 * 1024.0);

            System.out.println("\nTotal Directory Size:");

            System.out.println("Bytes: " + totalSize);
            System.out.println("KB: " + kb);
            System.out.println("MB: " + mb);

            System.out.println("\nIndividual Directory Sizes:");

            showDirectorySizes(directory);
        }

        input.close();
    }
}