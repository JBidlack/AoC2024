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
                ArrayList<Integer> lineI = new ArrayList<>();
                boolean valid = false;

                for(int a = 0; a<line.length; a++){
                    lineI.add(Integer.parseInt(line[a]));
                }

                valid = removedOne(lineI);

                if(!valid){
                    for (int i=0; i < lineI.size(); i++){
                        ArrayList<Integer> list = new ArrayList<>();
                        for (int j=0; j<lineI.size(); j++){
                            if(j != i){
                                list.add(lineI.get(j));
                            }
                        }
                        valid = removedOne(list);
                        if(valid){
                            break;
                        }
                    }
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

    public static boolean removedOne(ArrayList<Integer> seq){
        
        boolean increasing = false;
        boolean decreasing = false;

        if(seq.get(0) > seq.get(1)){
            decreasing = true;
        }
        if(seq.get(0) < seq.get(1)){
            increasing = true;
        }

        for(int i = 1; i < seq.size(); i++){
            
            int diff = seq.get(i)-seq.get(i-1);
            diff = Math.abs(diff);

            if(diff < 1 || diff > 3){
                return false;
            }

            if(seq.get(i)-seq.get(i-1) > 0 && decreasing){
                return false;
            }
            if(seq.get(i)-seq.get(i-1) < 0 && increasing){
                return false;
            }
        }
        return true;
    }
}
