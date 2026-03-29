# Assignment Questions

## Instructions
Answer all 4 questions with detailed explanations. Each answer should be 3-5 sentences minimum and demonstrate your understanding of the concepts.

---

## Question 1: Thread vs Process

Question: Explain the difference between a thread and a process. Why did we use threads in this assignment instead of creating separate processes?

Your Answer:

[A process is an independent program that has its own memory space and system resources, while a thread is a smaller unit of execution within the same process that shares memory with other threads. Processes are heavier and require more time and resources to create, while threads are lightweight and faster to manage.

In this assignment, threads were used instead of processes because they are more efficient for simulating CPU scheduling. Since all threads share the same environment, communication between them is faster and easier. This makes threads more suitable for implementing the Round-Robin scheduling algorithm in this simulation.]

---

## Question 2: Ready Queue Behavior

Question: In Round-Robin scheduling, what happens when a process doesn't finish within its time quantum? Explain using an example from your program output.

Your Answer:

[In Round-Robin scheduling, if a process does not finish within its assigned time quantum, it is moved to the end of the ready queue. This allows other processes to use the CPU, ensuring fairness. The process will get another chance to execute when its turn comes again in the queue.]

Example from my output:

[P14 executing quantum [1059ms]  
P14 completed quantum 1059ms │ Overall progress: [████████████████████] 100%  
Remaining time: 0ms  
P14 finished execution]

Explanation of example:

[In this example, process P14 was given a time quantum to execute. If it had remaining time after the quantum, it would be placed back in the ready queue and wait for its next turn. This cycle continues until the process completes execution. This behavior ensures that no single process can monopolize the CPU and all processes are treated fairly.]

---

## Question 3: Thread States

Question: A thread can be in different states: New, Runnable, Running, Waiting, Terminated. Walk through these states for one process (P1) from your simulation.

Your Answer:

[In this simulation, each process goes through different thread states as it is scheduled and executed. These states represent the lifecycle of a thread from creation to completion.]

1. New: [P1 is in the New state when the thread object is created using new Thread(process) before calling start().]

2. Runnable: [After calling start(), P1 enters the Runnable state where it is ready to be scheduled by the CPU.]

3. Running: [P1 becomes Running when the CPU starts executing its run() method during its time quantum.]

4. Waiting: [P1 enters the Waiting state when the main thread calls join(), which causes it to wait until the current thread finishes execution.]

5. Terminated: [P1 reaches the Terminated state when it finishes execution and its remaining time becomes zero.]

---

## Question 4: Real-World Applications

Question: Give TWO real-world examples where Round-Robin scheduling with threads would be useful. Explain why this scheduling algorithm works well for those scenarios.

Your Answer:

### Example 1: [Web Server Handling Multiple Requests]

Description: 
[A web server handles multiple client requests at the same time, where each request is processed by a separate thread.]

Why Round-Robin works well here: 
[Round-Robin ensures that each request gets a fair share of CPU time. This prevents any single request from blocking others and improves overall responsiveness.]

### Example 2: [Operating System Task Scheduling]

Description: 
[Operating systems manage multiple applications running at the same time, such as browsers, editors, and background processes.]

Why Round-Robin works well here: 
[Round-Robin scheduling provides fairness by giving each process a fixed time slice. This prevents starvation and ensures that all applications remain responsive.]
---

## Summary

Key concepts I understood through these questions:
1. [The difference between processes and threads and why threads are more efficient.]
2. [How Round-Robin scheduling ensures fairness using time quantum.]
3. [The lifecycle of threads and their different states.]

Concepts I need to study more:
1. [Advanced CPU scheduling algorithms such as Priority Scheduling.]
2. [Thread synchronization and avoiding race conditions.]
