import java.io.*;

public class InOut {
    
    static double[] method(String str, int col) {
        int i;

        String[] splitArray = str.split(" ");
        double[] array = new double[col];

        // parsing the String argument as a signed decimal integer object and
        // storing that integer into the array
        for (i = 0; i < col; i++) {
            array[i] = Double.parseDouble(splitArray[i]);
        }
        return array;
    }

    public int colTxt(String fileName) {
        int col = 0 ;
        try {
            FileReader reader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(reader);

            String line;

            line = bufferedReader.readLine();
            String[] splitArray = line.split(" ");
            col = splitArray.length;
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();//TODO: handle exception
        }
        return col;
    }
    
    public int rowTxt(String fileName) {
        int row=0;
        try {
            FileReader reader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(reader);

            while ((bufferedReader.readLine()) != null) {
                row++;
            }
            reader.close();

        } catch (Exception e) {
            e.printStackTrace();//TODO: handle exception
        }
        return row;
    }

    public Matriks bacaTxtMatriks(String fileName) {
        Matriks matrix;
        try {
            FileReader reader = new FileReader(fileName);
            matrix = new Matriks(rowTxt(fileName),colTxt(fileName));
            BufferedReader bufferedReader = new BufferedReader(reader);

            String line;
            int i = 0;
            while ((line = bufferedReader.readLine()) != null) {
                matrix.Mat[i] = method(line, matrix.col);
                i++;
            }
            reader.close();
            

        } catch (IOException e) {
            matrix = new Matriks(-1, -1);
            System.out.println("Tidak terdapat file dengan nama tersebut.");
        }
        return matrix;        
    }

    public void tulisTxtMatriks(String fileName, Matriks m1) {
        int i, j;
        try {
            FileOutputStream outputStream = new FileOutputStream(fileName);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, "UTF-16");
            BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);

            
            for (i = 0; i < m1.row; i++) { // Masih hard coded harus diganti dengan efektif dari matriks
                for (j = 0; j < m1.col; j++) {
                    bufferedWriter.write(Double.toString(m1.Mat[i][j]));

                    if (j != m1.col-1) {
                        bufferedWriter.write(" ");
                    }
                } // Masih hard coded harus diganti dengan efektif dari matriks
                if (i != 2) {
                    bufferedWriter.newLine();
                }
            }
            bufferedWriter.close();
        } catch (Exception e) {
            e.printStackTrace();// TODO: handle exception
        }

    }
    
}