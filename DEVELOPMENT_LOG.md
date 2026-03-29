# Development Log

## Instructions
Document your development process as you work on the assignment. Add entries showing:
- What you worked on
- Problems you encountered
- How you solved them
- Time spent

Requirements: Minimum 5 entries showing progression over time.

---

## Example Entry Format:

### Entry 1 - [April 1, 2026, 2:30 PM]
What I did: Forked the repository and set up my student ID

Details: 
- Created GitHub account with university email   
- Forked the starter repository
- Changed student ID on line 92 to my actual ID (441234567)
- Compiled and ran the program successfully

Challenges: Had to install JDK first because javac wasn't recognized

Solution: Downloaded JDK 17 from Oracle website and set PATH variable

Time spent: 30 minutes

---

## Your Development Log:

### Entry 1 - [March 25, 2026, 3:00 PM]
What I did: Set up the project and understood the starter code

Details: 
- Opened the project in VS Code  
- Set my student ID in the code  
- Ran the program and observed the output  
- Tried to understand how the Process and SchedulerSimulation classes work  

Challenges: At first, I was confused about how threads are connected to processes  

Solution: I carefully read the code and followed the execution step by step  

Time spent: 2 hours

---

### Entry 2 - [March 26, 2026, 4:30 PM]
What I did: Implemented Feature 1 (Process Priority)

Details: 
- Added a priority variable to the Process class  
- Modified the constructor to include priority  
- Generated random priority values when creating processes  
- Displayed priority in the ready queue output  

Challenges: I was not sure where to add the priority and how to display it correctly  

Solution: I added it inside the Process class and used a getter to display it  

Time spent: 3 hours

---

### Entry 3 - [March 27, 2026, 5:00 PM]
What I did: Implemented Feature 2 (Context Switch Counter)

Details: 
- Added a static variable to count context switches  
- Incremented the counter inside the scheduler loop  
- Printed the total number of context switches at the end  

Challenges: I did not know the correct place to increment the counter  

Solution: I placed it before starting each thread inside the loop  

Time spent: 1.5 hours

---

### Entry 4 - [March 28, 2026, 6:00 PM]
What I did: Implemented Feature 3 (Waiting Time)

Details: 
- Added variables to track waiting time  
- Used System.currentTimeMillis() to calculate timing  
- Updated waiting time after each execution  
- Printed a summary table at the end  

Challenges: Understanding when to calculate waiting time correctly  

Solution: I calculated it after thread execution using join()  

Time spent: 2 hours

---

### Entry 5 - [March 29, 2026, 7:00 PM]
What I did: Testing and fixing issues

Details: 
- Ran the program multiple times  
- Fixed small bugs in the logic  
- Verified that all features work correctly  
- Checked Git commits and pushed changes  

Challenges: Faced issues with Git authentication and commit names  

Solution: Configured Git settings and fixed the account connection  

Time spent: 5 hours maybe i spent a lot here ._.

---

### Entry 6 - [March 29, 2026, 9:00 PM]
What I did: Final review and documentation

Details: 
- Completed REFLECTION.md and ANSWERS.md  
- Reviewed all files before submission  
- Ensured everything matches assignment requirements  

Challenges: Making sure all files follow the required format  

Solution: Carefully reviewed instructions and adjusted formatting  

Time spent: 1 hour

---

## Summary

Total time spent on assignment: [15 hours]

Most challenging part: [Implementing waiting time and understanding the scheduler loop]

Most interesting learning: [Understanding how Round-Robin scheduling works with threads]

What I would do differently next time: [Start earlier and test each feature step by step before moving to the next one]
