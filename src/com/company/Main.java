package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main
    {
        public static void modifyFile(String filePath, String oldString, String newString)
        {
            File file = new File(filePath);

            StringBuilder oldContent = new StringBuilder();

            BufferedReader br = null;

            FileWriter fw = null;

            File fileToBeModified = new File("E:/JavaTest1.txt");

            System.out.println("Original file = " +file.getPath());
            System.out.println("Modified file = " +fileToBeModified.getPath());

            try
            {
                br = new BufferedReader(new FileReader(file));

                //Reading all the lines of input text file into oldContent

                String line = br.readLine();

                while (line != null)
                {
                    oldContent.append(line).append(System.lineSeparator());

                    line = br.readLine();
                }

                //Replacing oldString with newString in the oldContent

                String newContent = oldContent.toString().replaceAll(oldString, newString);

                //Rewriting the input text file with newContent

                fw = new FileWriter(fileToBeModified);

                fw.write(newContent);
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            finally
            {
                try
                {
                    //Closing the resources

                    br.close();
                    
                    fw.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }

        public static void main(String[] args)
        {
            modifyFile("E:/JavaTest.txt", "consectetur adipiscing elit", "########### ########## ####");


            System.out.println("done");
        }
    }