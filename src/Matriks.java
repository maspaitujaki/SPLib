import java.util.Scanner;

public class Matriks {
    // Atribut
    public int row;
    public int col;
    public double[][] Mat; // Masih hard coded harus diganti dengan efektif dari matriks
    final int UNVAL_INDEX = -1;

    // Method:
    Matriks(int row,int col) {
        this.col = col;
        this.row = row;
        
        int i, j;
        
        if (row > UNVAL_INDEX && col > UNVAL_INDEX) {
            this.Mat = new double[this.row][this.col];
            for (i = 0; i < row; i++) {
                for (j = 0; j < col; j++) {
                    this.Mat[i][j] = 0;
                }
            }
        }
    }
    public static double Kofaktor(Matriks m){
        // Kamus Lokal
        int i,j,k;
        int kolom, baris;
        int itemp,jtemp;
        double det = 0;
        // Algoritma
        baris = m.row;
        kolom = m.col;
        if(baris == 1) {
            return m.Mat[0][0];
        } else {
            if(baris == 2) {
                return m.Mat[0][0] * m.Mat[1][1] - m.Mat[0][1] * m.Mat[1][0];
            }
            for(i = 0;i < baris;i++) {
                Matriks mtemp = new Matriks(baris-1,kolom-1);
                itemp = 0;
                jtemp = 0;
                for(j = 1;j < baris;j++) {
                    for(k = 0;k < kolom;k++) {
                        if(k != i) {
                            mtemp.Mat[itemp][jtemp] = m.Mat[k][j];
                            itemp += 1;
                        }
                    }
                    jtemp += 1;
                    itemp = 0;
                }
                if(i % 2 == 1) {
                    det += -1 * m.Mat[i][0] * Kofaktor(mtemp);
                } else {
                    det += m.Mat[i][0] * Kofaktor(mtemp);
                }
            }
            return det;
        }
    }

    public static Matriks readMatrix() {
//        Kamus Lokal
        int i, j;
        int row,col;
//        Algoritma
        Scanner sc = new Scanner(System.in);
        System.out.println();
        System.out.print("Masukkan jumlah baris: "); row = sc.nextInt();
        System.out.print("Masukkan jumlah kolom: "); col = sc.nextInt();
        System.out.println("Masukkan elemen dalam matriks: ");
        Matriks M = new Matriks(row,col);
        for (i = 0; i < row; i++) {
                for (j = 0; j < col; j++) {
                    M.Mat[i][j] = sc.nextDouble();
            }
        }
        return M;
    }
    public static void printMatrix(Matriks M) {
//        Kamus Lokal
        int i, j;
        int row, col;
//        Algoritma
        row = M.row;
        col = M.col;
        System.out.println("Elemen matriks m adalah: ");
        for(i = 0; i < row; i++)
        {
            for(j = 0; j < col; j++)
            {
                if(j == col-1) {
                    System.out.print(M.Mat[i][j]);
                } else {
                    System.out.print(M.Mat[i][j] + " ");
                }
            }
            System.out.println("");
        }
    }
}