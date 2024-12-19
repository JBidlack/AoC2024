import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class day3 {
    public static void main(String[] args) {
        String mul = "mul\\((\\d+),(\\d+)\\)";
        String doit = "do\\(\\)";
        String dontdoit = "don\\'t\\(\\)";
        String input = "";
        File file = new File("C:\\Users\\jbidlack\\Documents\\NetBeansProjects\\AoC2024\\Day3\\text.txt");

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;

            int total = 0;
            while((line = reader.readLine()) != null){
                input = input+line;
            }

            Pattern pattern = Pattern.compile(mul);
            Pattern yesPat = Pattern.compile(doit);
            Pattern noPat = Pattern.compile(dontdoit);
            Matcher matcher = pattern.matcher(input);
            Matcher yesMatch = yesPat.matcher(input);
            Matcher noMatch = noPat.matcher(input);

            System.out.println(matcher);

            while(matcher.find()){
                int a = Integer.parseInt(matcher.group(1));
                int b = Integer.parseInt(matcher.group(2));
                total += a*b;
            }

            System.out.println(total);
        
        }
        catch(Exception e){
            e.printStackTrace();
        }      
    }
}
