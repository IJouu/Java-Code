import java.util.Scanner;
import java.io.*;

class Process {
    int[] current;
    int[] max;
    int[] need;
    int t;
    boolean isFinished;
    public Process(int t) {
        current = new int[t];
        max = new int[t];
        need = new int[t];
        isFinished = false;
        this.t = t;
    }
    public void print() {
        for (int i = 0; i < t; i++) {
            System.out.print(current[i] + " ");
        }
        System.out.printf("%7s", " ");
        for (int i = 0; i < t; i++) {
            System.out.print(max[i] + " ");
        }
        System.out.printf("%3s", " ");
        for (int i = 0; i < t; i++) {
            System.out.print(need[i] + " ");
        }
        System.out.printf("%3s", " ");
    }
}

public class Banker {
    int[] total;
    int[] remain;
    int[] fixedRemain;
    static int n, t;
    static String seq;
    public Banker() {
        total = new int[t];
        remain = new int[t];
        fixedRemain = new int[t];
    }

    public void print(Process[] p) {
        String str = String.format("%-8s %-12s %-8s %-8s %-8s", "Process", "Allocation", "Max", "Need", "Available");
        System.out.println(str);
        for (int i = 0; i < n; i++) {
            System.out.printf("P %-7d", i);
            p[i].print();
            if (i == 0) {
                for (int j = 0; j < t; j++) {
                    System.out.print(remain[j] + " ");
                }
            }
            System.out.println();
        }
    }
    public boolean canAllocate(Process p) {
        for (int i = 0; i < t; i++) {
            if (p.need[i] > remain[i]) {
                return false;
            }
        }
        return true;
    }

    public void allocate(Process[] p) {
        boolean state = true;
        while (state) {
            state = false;
            for (int i = 0; i < n; i++) {
                if (!p[i].isFinished && canAllocate(p[i])) {
                    p[i].isFinished = true;
                    seq += "P" + i + " -> ";
                    for (int j = 0; j < t; j++) {
                        remain[j] += p[i].current[j];
                    }
                    state = true;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (p[i].isFinished == false) {
                System.out.println("Unsafe!");
                return;
            }
        }
        System.out.println(seq + "Safe!");
    }

    public static void main(String[] argv) {
        // n -> process number
        // t -> resource type
        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        t = input.nextInt();
        seq = "";
        // init Banker
        Banker b = new Banker();
        // init Process
        Process[] p = new Process[n];
        for (int i = 0; i < n; i++) {
            p[i] = new Process(t);
        }
        // input data
        // input Banker.total
        for (int i = 0; i < t; i++) {
            b.total[i] = input.nextInt();
        }
        // input Process current
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < t; j++) {
                p[i].current[j] = input.nextInt();
            }
        }
        // input Process max
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < t; j++) {
                p[i].max[j] = input.nextInt();
                p[i].need[j] = p[i].max[j] - p[i].current[j];
            }
        }
        // init Banker remain
        for (int i = 0; i < t; i++) {
            for (int j = 0; j < n; j++) {
                b.remain[i] += p[j].current[i];
            }
            b.remain[i] = b.total[i] - b.remain[i];
            b.fixedRemain[i] = b.remain[i];
        }
        b.print(p);
        b.allocate(p);

        int x;
        int[] a = new int[t];
        boolean useBanker = true;
        while(true) {
            seq = "";
            for (int i = 0; i < n; i++) {
                p[i].isFinished = false;
            }
            useBanker = true;
            b.remain = b.fixedRemain.clone();
            System.out.print("Enter a Process : ");
            x = input.nextInt();
            System.out.print("Enter request : ");
            for (int i = 0; i < t; i++) {
                a[i] = input.nextInt();
                p[x].current[i] += a[i]; // add request to current
                p[x].need[i] -= a[i];
                b.remain[i] -= a[i];
            }
            b.print(p);
            for (int i = 0; i < t; i++) {
                if (p[x].current[i] > p[x].max[i]) {
                    System.out.println("Unsafe! Restart again.");
                    useBanker = false;
                    break;
                }
            }
            if (useBanker) {
                b.allocate(p);
            }
            for (int i = 0; i < t; i++) {
                p[x].current[i] -= a[i];
                p[x].need[i] += a[i];
            }
        }
    }
}
