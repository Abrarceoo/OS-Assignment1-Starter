# Reflection Questions

## Instructions
Answer the following questions about your learning experience. Each answer should be at least 5-7 sentences and show your understanding.

---

## Question 1: What did you learn about multithreading?

Your Answer:

[Through this assignment, I learned how multithreading works in Java using the Runnable interface and how threads are created and started using start(). I understood that each process in the simulation is represented as a thread, which allows multiple processes to be executed in a way that simulates concurrency.

I also learned about different thread states such as New, Runnable, Running, Waiting, and Terminated, and how a thread transitions between these states during execution. One important concept that became clear to me is how the CPU switches between threads quickly, which creates the illusion of parallel execution.

I was also introduced to the use of join(), which ensures that one thread waits for another to complete before continuing. This helped me understand synchronization between threads. Overall, this assignment gave me a practical understanding of how threads behave and how they are used in scheduling algorithms.]

---

## Question 2: What was the most challenging part of this assignment?

Your Answer:

[The most challenging part of this assignment was understanding how the scheduler loop works and how processes are managed within the ready queue. At first, I found it confusing to determine when a process should be re-added to the queue and when it should run until completion.

Another difficulty was implementing the waiting time feature correctly. I had trouble identifying the correct place in the code to calculate the waiting time and how to track it accurately. Since the behavior depends on execution order and timing, debugging this part required careful testing.

In addition, I faced some challenges when working with Git and commits, especially with authentication and commit history. However, these challenges helped me improve both my programming and development workflow skills.]

---

## Question 3: How did you overcome the challenges you faced?

Your Answer:

[To overcome these challenges, I started by analyzing the code step by step and focusing on understanding the flow of execution instead of rushing to fix errors. I broke the problem into smaller parts and worked on each feature separately, which made the overall task more manageable.

I also ran the program multiple times and carefully observed the output to understand how processes move within the ready queue. This helped me identify logical mistakes and fix them.

When I encountered issues with Git, I followed the correct steps to configure my account and fix authentication problems. I also made small incremental changes and tested them regularly. This approach helped me build confidence and complete the assignment successfully.]

---

## Question 4: How can you apply multithreading concepts in real-world applications?

Your Answer:

[Multithreading is widely used in real-world applications such as web browsers, where multiple tabs run at the same time. Each tab can be handled by a separate thread, allowing users to interact with multiple pages without performance issues.

Another example is video streaming applications, where tasks such as video playback, buffering, and user interaction run concurrently using multiple threads. This ensures smooth performance and responsiveness.

Multithreading is also used in operating systems to manage multiple applications running simultaneously. Scheduling algorithms like Round-Robin help distribute CPU time fairly between processes. This assignment helped me understand how these concepts are applied in real systems.]

---

## Additional Reflections (Optional)

### What would you like to learn more about?

[I would like to learn more about advanced scheduling algorithms such as Priority Scheduling and Multilevel Queue Scheduling. I am also interested in learning about thread synchronization and how to avoid issues like race conditions.
Additionally, I want to understand how operating systems manage large numbers of threads efficiently and how performance is optimized in real-world systems.]

---

### How confident do you feel about multithreading concepts now?

[Intermediate

I feel more confident than before because I now understand the basic concepts of threads, scheduling, and execution flow. I can explain how threads are created, how they run, and how they are managed by the scheduler.

However, I still need more practice with advanced topics such as synchronization and more complex scheduling algorithms. With more hands-on experience, I believe I can reach a higher level of confidence.]

---

### Feedback on the assignment

[Overall, I found this assignment very helpful in understanding multithreading concepts in a practical way. It allowed me to apply theoretical knowledge from the course to a real simulation.

The assignment was challenging at times, especially when implementing new features and working with Git, but it helped me improve my problem solving skills. I believe the assignment is welldesigned and gives a good balance between theory and practice. It would be even better if more examples or guidance were provided for beginners.]
