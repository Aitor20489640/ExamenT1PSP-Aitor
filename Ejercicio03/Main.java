package Ejercicio03;

import java.io.*;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        String cmd1 = "";
        String cmd2 = "";
        Scanner sc = new Scanner(System.in);
        boolean ok;

        do {
            ok = true;
            try {
                System.out.println("Escribe el primer comando: ");
                cmd1 = sc.nextLine();
                System.out.println("Escribe el segundo comando: ");
                cmd2 = sc.nextLine();


                /*List<String> result;
                List<Process> processes = ProcessBuilder.startPipeline(List.of(
                        new ProcessBuilder(cmd1.split(" "))
                                .inheritIO().redirectOutput(ProcessBuilder.Redirect.PIPE),
                        new ProcessBuilder(cmd2.split(" "))
                                .redirectError(ProcessBuilder.Redirect.INHERIT)
                ));
                try (Scanner s = new Scanner(processes.get(processes.size() - 1).getInputStream())) {
                    result = s.useDelimiter("\\R").tokens().toList();
                }
                System.out.println(result);*/


                Process process1 = new ProcessBuilder(cmd1.split(" ")).start();
                Process process2 = new ProcessBuilder(cmd2.split(" ")).start();

                String out = new BufferedReader(new InputStreamReader(process1.getInputStream())).lines().collect(Collectors.joining("\n"));

                BufferedWriter bfr = new BufferedWriter(new OutputStreamWriter(process2.getOutputStream()));

                bfr.write(out);
                bfr.close();

                System.out.println(new BufferedReader(new InputStreamReader(process2.getInputStream())).lines().collect(Collectors.joining("\n")));


            } catch (IOException e) {
                System.out.println("No existe este comando");
                ok = false;
            }
        } while (!ok);
    }
}
