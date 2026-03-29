import java.util.LinkedList;
import java.util.Queue;
import java.util.Map;
import java.util.HashMap;
import java.util.Random;

// ANSI Color Codes for enhanced terminal output
class Colors {
    public static final String RESET = "\u001B[0m";
    public static final String BOLD = "\u001B[1m";
    public static final String CYAN = "\u001B[36m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String MAGENTA = "\u001B[35m";
    public static final String BLUE = "\u001B[34m";
    public static final String RED = "\u001B[31m";
    public static final String BG_BLUE = "\u001B[44m";
    public static final String BG_GREEN = "\u001B[42m";
    public static final String WHITE = "\u001B[37m";
    public static final String BRIGHT_WHITE = "\u001B[97m";
    public static final String BRIGHT_CYAN = "\u001B[96m";
    public static final String BRIGHT_YELLOW = "\u001B[93m";
    public static final String BRIGHT_GREEN = "\u001B[92m";
}

// Class representing a process that implements Runnable to be run by a thread
class Process implements Runnable {
    private String name; // Name of the process
    private int burstTime; // Total time the process requires to complete (in milliseconds)
    private int timeQuantum; // Time slice (time quantum) allowed per CPU access (in milliseconds)
    private int remainingTime; // Time left for the process to finish its execution

    // Feature 1: Add process priority
    private int priority;

    // Feature 3: Track waiting time
    public long totalWaitingTime = 0;
    public long lastStartTime;

    // Constructor
    public Process(String name, int burstTime, int timeQuantum, int priority) {
        this.name = name;
        this.burstTime = burstTime;
        this.timeQuantum = timeQuantum;
        this.remainingTime = burstTime;
        this.priority = priority;
    }

    @Override
    public void run() {
        // Feature 3: Track waiting time (start of execution slice)
        lastStartTime = System.currentTimeMillis();

        int runTime = Math.min(timeQuantum, remainingTime);

        // Show execution start
        String quantumBar = createProgressBar(0, 15);
        System.out.println(Colors.BRIGHT_GREEN + "  ▶️ " + Colors.BOLD + Colors.CYAN + name +
                Colors.RESET + Colors.GREEN + " executing quantum" + Colors.RESET +
                " [" + runTime + "ms] ");

        try {
            int steps = 5;
            int stepTime = Math.max(1, runTime / steps);

            for (int i = 1; i <= steps; i++) {
                Thread.sleep(stepTime);
                int quantumProgress = (i * 100) / steps;
                quantumBar = createProgressBar(quantumProgress, 15);
                System.out.print("\r  " + Colors.YELLOW + "⚡️" + Colors.RESET +
                        " Quantum progress: " + quantumBar);
            }
            System.out.println();
        } catch (InterruptedException e) {
            System.out.println(Colors.RED + "\n  ✗ " + name + " was interrupted." + Colors.RESET);
        }

        remainingTime -= runTime;

        int overallProgress = (int) (((double) (burstTime - remainingTime) / burstTime) * 100);
        String overallProgressBar = createProgressBar(overallProgress, 20);

        System.out.println(Colors.YELLOW + "  ⏸️ " + Colors.CYAN + name + Colors.RESET +
                " completed quantum " + Colors.BRIGHT_YELLOW + runTime + "ms" + Colors.RESET +
                " │ Overall progress: " + overallProgressBar);
        System.out.println(Colors.MAGENTA + "     Remaining time: " + remainingTime + "ms" + Colors.RESET);

        if (remainingTime > 0) {
            System.out.println(Colors.BLUE + "  ↻ " + Colors.CYAN + name + Colors.RESET +
                    " yields CPU for context switch" + Colors.RESET);
        } else {
            System.out.println(Colors.BRIGHT_GREEN + "  ✓ " + Colors.BOLD + Colors.CYAN + name +
                    Colors.RESET + Colors.BRIGHT_GREEN + " finished execution!" +
                    Colors.RESET);
        }
        System.out.println();
    }

    private String createProgressBar(int progress, int width) {
        int filled = (progress * width) / 100;
        StringBuilder bar = new StringBuilder("[");
        for (int i = 0; i < width; i++) {
            if (i < filled) {
                bar.append(Colors.GREEN + "█" + Colors.RESET);
            } else {
                bar.append(Colors.WHITE + "░" + Colors.RESET);
            }
        }
        bar.append("] ").append(progress).append("%");
        return bar.toString();
    }

    public void runToCompletion() {
        try {
            System.out.println(Colors.BRIGHT_CYAN + "  ⚡️ " + Colors.BOLD + Colors.CYAN + name +
                    Colors.RESET + Colors.BRIGHT_CYAN + " is the last process, running to completion" +
                    Colors.RESET + " [" + remainingTime + "ms]");
            Thread.sleep(remainingTime);
            remainingTime = 0;
            System.out.println(Colors.BRIGHT_GREEN + "  ✓ " + Colors.BOLD + Colors.CYAN + name +
                    Colors.RESET + Colors.BRIGHT_GREEN + " finished execution!" + Colors.RESET);
            System.out.println();
        } catch (InterruptedException e) {
            System.out.println(Colors.RED + "  ✗ " + name + " was interrupted." + Colors.RESET);
        }
    }

    public String getName() {
        return name;
    }

    public int getBurstTime() {
        return burstTime;
    }

    public int getRemainingTime() {
        return remainingTime;
    }

    public boolean isFinished() {
        return remainingTime <= 0;
    }

    // Feature 1: Getter for priority
    public int getPriority() {
        return priority;
    }

    // Feature 3: Getter for waiting time
    public long getWaitingTime() {
        return totalWaitingTime;
    }
}

public class SchedulerSimulation {

    // Feature 2: Count context switches
    static int contextSwitches = 0;

    public static void main(String[] args) {
        // SET MY ID :445052098
        int studentID = 445052098;

        Random random = new Random(studentID);

        int timeQuantum = 2000 + random.nextInt(4) * 1000;
        int numProcesses = 10 + random.nextInt(11);

        Queue<Thread> processQueue = new LinkedList<>();
        Map<Thread, Process> processMap = new HashMap<>();

        // Header
        System.out.println("\nCPU SCHEDULER SIMULATION");
        System.out.println("Processes: " + numProcesses);
        System.out.println("Time Quantum: " + timeQuantum);
        System.out.println("Student ID: " + studentID + "\n");

        // Create processes
        for (int i = 1; i <= numProcesses; i++) {
            int burstTime = timeQuantum / 2 + random.nextInt(2 * timeQuantum + 1);

            // Feature 1: Add process priority
            int priority = 1 + random.nextInt(5);

            Process process = new Process("P" + i, burstTime, timeQuantum, priority);
            addProcessToQueue(process, processQueue, processMap);
        }

        // Scheduler loop
        while (!processQueue.isEmpty()) {
            Thread currentThread = processQueue.poll();

            // Feature 2: Count context switches
            contextSwitches++;

            // Ready queue view
            System.out.println(
                    Colors.BOLD + Colors.MAGENTA + "┌─ Ready Queue ───────────────────────────────" + Colors.RESET);
            System.out.print(Colors.MAGENTA + "│ " + Colors.RESET + "[");
            for (Thread t : processQueue) {
                Process p = processMap.get(t);
                System.out.print(p.getName() + " ");
            }
            System.out.println("]");
            System.out.println(
                    Colors.BOLD + Colors.MAGENTA + "└────────────────────────────────────────────" + Colors.RESET);

            currentThread.start();

            try {
                currentThread.join();
            } catch (InterruptedException e) {
                System.out.println("Main interrupted");
            }

            Process process = processMap.get(currentThread);

            // Feature 3: Track waiting time
            process.totalWaitingTime += (System.currentTimeMillis() - process.lastStartTime);
            if (!process.isFinished()) {
                if (!processQueue.isEmpty()) {
                    addProcessToQueue(process, processQueue, processMap);
                } else {
                    process.runToCompletion();
                }
            }
        }

        System.out.println("All processes completed");

        // Feature 2: Display context switches
        System.out.println("Total context switches: " + contextSwitches);

        // Feature 3: Waiting time summary
        System.out.println("\nProcess Summary:");
        System.out.println("Name\tBurst Time\tWaiting Time");
        for (Process p : processMap.values()) {
            System.out.println(p.getName() + "\t" + p.getBurstTime() + "\t\t" + p.getWaitingTime());
        }
    }

    public static void addProcessToQueue(Process process, Queue<Thread> processQueue,
            Map<Thread, Process> processMap) {

        Thread thread = new Thread(process);
        processQueue.add(thread);
        processMap.put(thread, process);

        // Feature 1: Display priority
        System.out.println(Colors.BLUE + "  ➕ " + Colors.BOLD + Colors.CYAN + process.getName() +
                Colors.RESET + Colors.BLUE + " added to ready queue" + Colors.RESET +
                " │ Priority: " + Colors.MAGENTA + process.getPriority() +
                Colors.RESET + " │ Burst time: " + Colors.YELLOW + process.getBurstTime() + "ms" +
                Colors.RESET);
    }
}