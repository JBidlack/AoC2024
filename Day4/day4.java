import java.io.FileReader;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.File;

public class day4 {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\jbidlack\\Documents\\NetBeansProjects\\AoC2024\\Day4\\text.txt");

        String xmas = "XMAS";

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            ArrayList<char[]> puzzle = new ArrayList<>();
            int total = 0;
            

            while((line = reader.readLine()) != null){
               puzzle.add(line.toCharArray());
                
            }
            for (int i = 0; i< puzzle.size(); i++){
                System.out.println(puzzle.get(i));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
