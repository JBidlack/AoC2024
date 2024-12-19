import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        File file = new File("C:\\Users\\jbidlack\\Documents\\NetBeansProjects\\AoC2024\\Day2\\AoCDay2\\src\\input.txt");
        
        int total = 0;
        
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String fullLine;

            while ((fullLine = reader.readLine()) != null){
                String[] line = fullLine.split(" ");
                int[] lineI = new int[line.length];
                boolean increasing = false;
                boolean decreasing = false;
                boolean valid = false;

                for(int a = 0; a<line.length; a++){
                    lineI[a] = Integer.parseInt(line[a]);
                }

                for(int i = 1; i<lineI.length; i++){
                    
                    if(lineI[0] > lineI[1]){
                        decreasing = true;
                    }
                    if(lineI[0] < lineI[1]){
                        increasing = true;
                    }
                    
                    int diff = lineI[i]-lineI[i-1];
                    diff = Math.abs(diff);

                    if(diff < 1 || diff > 3){
                        valid = removedOne(lineI, i);
                        break;
                    }

                    if(lineI[i]-lineI[i-1] > 0 && decreasing){
                        valid = removedOne(lineI, i);
                        break;
                    }
                    if(lineI[i]-lineI[i-1] < 0 && increasing){
                        valid = removedOne(lineI, i);
                        break;
                    }
                    valid = true;
                }
                if(valid){
                    total++;
                }
    
            }
            System.out.println(total);
            
        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    public static boolean removedOne(int[] seq, int prob){
        boolean removed = false;
        boolean increasing = false;
        boolean decreasing = false;

        for(int i = 1; i<seq.length; i++){
            if(seq[i-1] > seq[i]){
                decreasing = true;
            }
            if(seq[i-1] < seq[i]){
                increasing = true;
            }
            for (int j=1; j<seq.length; j++){       
                if(j == prob) {
                    continue;
                } 
                
                int diff = seq[j]-seq[j-1];
                diff = Math.abs(diff);

                if(diff < 1 || diff > 3){
                    return false;
                }

                if(seq[j]-seq[j-1] > 0 && decreasing){
                    return false;
                }
                if(seq[j]-seq[j-1] < 0 && increasing){
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean isDecValid(int[] seq){
        for (int i = 1; i<seq.length-1; i++){
            
        }
        return true;
    }
}
