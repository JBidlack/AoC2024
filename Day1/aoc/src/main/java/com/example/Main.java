package com.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;


public class Main {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\bidl17234\\Documents\\NetBeansProjects\\AoC2024\\Day1\\aoc\\src\\main\\resources\\input.txt");
        ArrayList<Integer> lineL = new ArrayList<Integer>();
        ArrayList<Integer> lineR = new ArrayList<Integer>();
        ArrayList<Integer> lineTotals = new ArrayList<Integer>();
        int total = 0;
        
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String fullLine;

            while ((fullLine = reader.readLine()) != null){
                String[] line = fullLine.split(" ");
                int left = Integer.parseInt(line[0].trim());
                int right = Integer.parseInt(line[line.length-1].trim());
                lineL.add(left);
                lineR.add(right);
            }
            // Day 1 Part 1
            Collections.sort(lineL);
            Collections.sort(lineR);

            for (int i=0; i<lineL.size(); i++){
                int linetotal = 0;
                for (int j=0; j<lineL.size(); j++){
                    if(lineR.get(j).equals(lineL.get(i))){
                        linetotal++;
                    }
                }
                lineTotals.add(lineL.get(i)*linetotal);
                // Day 1 Part 1
                // int line1 = lineL.get(i);
                // int line2 = lineR.get(i); 
                // int diff = line2-line1;
                // if(diff < 0){
                //     diff = diff*-1;
                // }
                // total = total + diff;
            }

            for (int num:lineTotals){
                total = total+num;
            }

            System.out.println(total);

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}