package com.neu;

import com.neu.builder_pattern.ProductBuilder;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class FileUtility {
    private static final Logger LOGGER = Logger.getLogger(FileUtility.class.getName());
    
 // Method to retrieve data from a file and return it as a list of strings
    public static List<String> getFileData(String fileName) {
        File file = new File(fileName);
        
     // If the file doesn't exist, create it
        if (!file.exists()) {
            System.out.println(file.getAbsoluteFile());
            try {
                file.createNewFile();
            } catch (IOException ex) {
                System.err.println("An error occurred during creating file");
                Logger.getLogger(FileUtility.class.getName()).log(Level.SEVERE, "An error occurred while creating the file", ex);

            }

        }
        FileReader fr = null;
        BufferedReader br = null;
        List<String> data = new ArrayList<String>();
        try {
            fr = new FileReader(fileName);
            br = new BufferedReader(fr);
            
         // Read lines from the file and store them in the data list
            while (br.ready()) {
                String line = br.readLine();
                data.add(line);
            }
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "An exception occurred while reading the file", e);
        } finally {
            try {
                fr.close();
                br.close();
            } catch (IOException e) {
                LOGGER.log(Level.SEVERE, "An exception occurred while closing the file", e);
                e.printStackTrace();
            }
        }
        return data;
    }

    // Method to get a BufferedReader for a given file name
    public static BufferedReader getFileReader(String filename) {
        File f = new File(filename);
        
        // If the file doesn't exist, create it
        if (!f.exists()) {
            try {
                f.createNewFile();
            } catch (Exception e) {
                LOGGER.log(Level.SEVERE, "An exception occurred while creating the file", e);
            }
        }
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(filename));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return br;
    }
    
 // Method to write product details to a file
    public static void writeToFile(String filename, ProductBuilder productBuilder) {
        try {
            FileWriter fw = new FileWriter(filename, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw);
            
            // Write product details to the file
            out.println(productBuilder.getProductId());
            out.println(productBuilder.getProductName());
            out.println(productBuilder.getProductPrice());
            out.println(productBuilder.getProductCategory());
            out.println(productBuilder.getProductManufacturer());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
    // Method to append product details to a file
    public static void appendEntryToFile(String fileName, ProductBuilder productBuilder) {
        FileWriter fr = null;
        BufferedWriter bw = null;
        try {
            fr = new FileWriter(fileName, true);
            bw = new BufferedWriter(fr);
            
         // Append product details to the file
            bw.append(productBuilder.getProductId() + ",");
            bw.append(productBuilder.getProductName() + ",");
            bw.append(productBuilder.getProductPrice() + ",");
            bw.append(productBuilder.getProductCategory() + ",");
            bw.append(productBuilder.getProductManufacturer() + "\n");
        } catch (IOException ex) {
            LOGGER.log(Level.SEVERE, "An error occurred while reading the file", ex);
        } finally {
            try {
                if (bw != null) {
                    bw.close();
                }
                if (fr != null) {
                    fr.close();
                }
            } catch (IOException ex) {
                LOGGER.log(Level.SEVERE, "An error occurred while closing the file", ex);
            }
        }
    }
    
 // Method to remove a specific entry from the file
    public static void removeEntryInFile(String fileName, String lineData) {
        FileReader fin = null;
        BufferedReader bin = null;
        FileWriter fout = null;
        BufferedWriter bout = null;

        String tempFileName = fileName + "temp";
        try {
            fin = new FileReader(fileName);
            bin = new BufferedReader(fin);
            fout = new FileWriter(tempFileName);
            bout = new BufferedWriter(fout);
            
            
         // Copy lines from original file to temporary file, excluding the line to be removed
            while (bin.ready()) {
                String currentLine = bin.readLine();
                if (!currentLine.equals(lineData)) {
                    bout.write(currentLine + "\n");
                }
            }
        } catch (IOException ex) {
            LOGGER.log(Level.SEVERE, "An error occurred reading the file", ex);
        } finally {
            try {
                if (bin != null) {
                    bin.close();
                }
                if (fin != null) {
                    fin.close();
                }
                if (bout != null) {
                    bout.close();
                }
                if (fout != null) {
                    fout.close();
                }
            } catch (IOException ex) {
                LOGGER.log(Level.SEVERE, "An Error occurred while closing the file", ex);
            }
        }
     // Rename the temporary file to the original file
        new File(tempFileName).renameTo(new File(fileName));
    }
    
 // Method to modify an entry in the file
    public static void modifyEntryInFile(String fileName, String oldData, String newData) {
        FileReader fin = null;
        BufferedReader bin = null;
        FileWriter fout = null;
        BufferedWriter bout = null;

        String tempFileName = fileName + "temp";
        try {
            fin = new FileReader(fileName);
            bin = new BufferedReader(fin);
            fout = new FileWriter(tempFileName);
            bout = new BufferedWriter(fout);
         // Copy lines from original file to temporary file, modifying the specified line

            while (bin.ready()) {
                String currentLine = bin.readLine();
                if (currentLine.equals(oldData)) {
                    bout.write(newData + "\n");
                } else {
                    bout.write(currentLine + "\n");
                }
            }
        } catch (IOException ex) {
            LOGGER.log(Level.SEVERE, "An error occured while reading the file", ex);
        } finally {
            try {
                if (bin != null) {
                    bin.close();
                }
                if (fin != null) {
                    fin.close();
                }
                if (bout != null) {
                    bout.close();
                }
                if (fout != null) {
                    fout.close();
                }
            } catch (IOException ex) {
                LOGGER.log(Level.SEVERE, "An error occured while closing the file", ex);
            }
        }
        // Rename the temporary file to the original file
        new File(tempFileName).renameTo(new File(fileName));
    }
}


