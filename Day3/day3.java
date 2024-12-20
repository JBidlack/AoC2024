import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class day3 {
    public static void main(String[] args) {
        String mul = "mul\\((\\d+),(\\d+)\\)";
        String doit = "do\\(\\)";
        String dontdoit = "don't\\(\\)";
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

            String mem = input.toString();

            Matcher matcher = pattern.matcher(mem);
            Matcher yesMatch = yesPat.matcher(mem);
            Matcher noMatch = noPat.matcher(mem);

            boolean isEnabled = true;

            int position = 0;

            while(position < mem.length()){
                int next = matcher.find(position) ? matcher.start():Integer.MAX_VALUE;
                int nextDo = yesMatch.find(position) ? yesMatch.start():Integer.MAX_VALUE;
                int nextDont = noMatch.find(position) ? noMatch.start():Integer.MAX_VALUE;

                int instruction = Math.min(next, Math.min(nextDo, nextDont));

                if (instruction == Integer.MAX_VALUE){
                    break;
                }

                if(instruction == next){
                    if(isEnabled){
                        int a = Integer.parseInt(matcher.group(1));
                        int b = Integer.parseInt(matcher.group(2));
                        total += a*b;
                    }
                    position = matcher.end();
                }
                else if ( instruction == nextDo){
                    isEnabled = true;
                    position = yesMatch.end();
                }
                else if (instruction == nextDont){
                    isEnabled= false;
                    position = noMatch.end();
                }


            }

            System.out.println(total);
        
        }
        catch(Exception e){
            e.printStackTrace();
        }      
    }
}
