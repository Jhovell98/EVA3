/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author CIESPN
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[] datos = new int[20];
        /*long ini, fin;
        llenar(datos);
        System.out.println("Arreglo original ");
        Imprimir(datos);
        ini = System.nanoTime();
        selectionSort(datos);
        fin = System.nanoTime();
        System.out.println("Selection Sort");
        Imprimir(datos);
        System.out.println("Tiempo: " + (fin-ini));
        /*char a = 'A';
        char b = 'B';
        if (a<b) {
            System.out.println("MENOR");
        }
        System.out.println("Insertion Sort ");
        ini = System.nanoTime();
        insertionSort(datos);
        fin = System.nanoTime();
        Imprimir(datos);
        System.out.println("Tiempo: " + (fin-ini));
        System.out.println("Bubble sort");
        ini = System.nanoTime();
        bubbleSort(datos);
        fin= System.nanoTime();
        Imprimir(datos);
        System.out.println("Tiempo: " + (fin-ini)); */
        llenar(datos);
        Imprimir(datos);
        quickSort(datos);
        Imprimir(datos);
    }

    public static void llenar(int[] arreglo) {
        for (int i = 0; i < arreglo.length; i++) {
            arreglo[i] = (int) (Math.random() * 100);
        }
    }

    public static void Imprimir(int[] arreglo) {
        for (int i = 0; i < arreglo.length; i++) {
            System.out.print("[" + arreglo[i] + "]");
        }
        System.out.println("");
    }

    public static void selectionSort(int[] arreglo) { //Hace mas comparaciones, menos intercambios
        for (int i = 0; i < arreglo.length; i++) {
            int iMin = i;
            for (int j = (i + 1); j < arreglo.length; j++) {
                if (arreglo[j] < arreglo[iMin]) {
                    iMin = j;
                }

            }//Final for J
            int iTemp = arreglo[i];
            arreglo[i] = arreglo[iMin];
            arreglo[iMin] = iTemp;
        }
    }//Final Selection Sort

    public static void insertionSort(int[] arreglo) { //Hace mas intercambios, menos comparaciones 
        //Recorre y compara a los elementos que supuestamente ya están ordenados
        for (int i = 1; i < arreglo.length; i++) {
            int iTemp = arreglo[i];
            for (int insP = i; insP > 0; insP--) { //Comparar

                /*if (arreglo[iPrev]<iTemp) {
                   //Swap
                   arreglo[insP]= arreglo[iPrev];
                   }else if(arreglo[iPrev]==iTemp){
                   arreglo[insP]=arreglo[i];
                }else{
                   arreglo[j]=iTemp;
                   }*/
                if (insP != 0) {
                    int iPrev = insP - 1;
                    if (arreglo[iPrev] > iTemp) {
                        arreglo[insP] = arreglo[iPrev];
                    } else {
                        arreglo[insP] = iTemp;
                        break;
                    }
                } else {
                    arreglo[insP] = iTemp;
                }
            }
        }
    }

    public static void bubbleSort(int[] arreglo) {
        for (int i = 0; i < arreglo.length; i++) {
            for (int j = 0; j < arreglo.length - 1; j++) {
                if (arreglo[j] > arreglo[j + 1]) {
                    int iTemp = arreglo[j];
                    arreglo[j] = arreglo[j + 1];
                    arreglo[j + 1] = iTemp;
                }
            }
        }
    }// Final BubbleSort

    public static void quickSort(int[] arreglo) {//Divide y venceras 
        quickSortRec(arreglo, 0, arreglo.length - 1);

    }

    private static void quickSortRec(int[] arreglo, int ini, int fin) {
        //Detenernos
        if ((ini < fin) && (ini >= 0) && (fin < arreglo.length)) {
            int iPiv = ini;
            int too_big = ini + 1;
            int too_small = fin;
            int iTemp;
            while (too_big < too_small) {

                while ((too_big < fin) && (arreglo[too_big] < arreglo[iPiv])) {
                    too_big++;
                }
                while ((too_small > (ini + 1)) && (arreglo[too_small] > arreglo[iPiv])) {
                    too_small--;
                }
                if (too_big < too_small) {//No se han cruzado
                    iTemp = arreglo[too_big];
                    arreglo[too_big] = arreglo[too_small];
                    arreglo[too_small] = iTemp;
                }
            }//Final de while

//Swap el pivote
            iTemp = arreglo[iPiv];
            arreglo[iPiv] = arreglo[too_small];
            arreglo[too_small] = iTemp;

            quickSortRec(arreglo, ini, too_small - 1);//Izquierda
            quickSortRec(arreglo, too_small + 1, fin);//Derecha

        }//Final de primer IF

    }//Fianl de quickSort

    public static int busquedaBin(int[] arreglo, int val) {
        return busquedaBinRec(arreglo, val, 0, arreglo.length - 1);
    }

    public static int busquedaBinRec(int[] arreglo, int val, int ini, int fin) {
        if (ini <= fin) {
            int mid = ini + ((fin - ini) / 2);
            if (val == arreglo[mid]) {//Igual
                return mid;
            } else if (val > arreglo[mid]) {//Mayor
                return busquedaBinRec(arreglo, val, mid + 1, fin);
            } else {//Menor
                return busquedaBinRec(arreglo, val, ini, mid - 1);
            }
        } else {
            return -1;
        }
    }//Final busqueda binaria
}
