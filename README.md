This is a gradle project based on java. It's an Objected Oriented Design(OOD) problem generally asked in interviews. Main reason behind asking these kind of problems in interview is to see whether a candidate can do following :
1. Can a candidate write a working code in given short span of time.
2. Can a candidate write higly readbale code. Intention must be clear by reading the code.
3. Can a candidate follow the principle the of DRY (Don't Repeat Yourself) and avoid to break encapsulation by following Domain Driven Design(DDD).
4. Can a candidate achieve the solution with minimum number of elements using YAGNI principle (that is without creating unnecesarry interfaces etc).

**PROBLEM STATEMENT**

A group of friends go out for an outing to explore Chennai. On the trip, they incur various expenses like bus tickets, taxi fare, museum tickets and food etc. One of them paid for taxi while other one paid for the evening snacks. Similarly, different expenses were paid by them in a random manner. Also, for some expenses, only few people are part of it.

Now they need need an application that can tell how much a person owes and how much he needs to give.

Sample Input : (you can keep this sample input in your code/file - ie no need for user input, but you should not hardcode the number of friends in the group)
————————
A spent 100 for Snacks for A, B, C, D.
B spent 500 for Taxi for C, D.
D spent 300 for Bus for A, B.

Sample output:

A gives 75,
B gets 325,
C gives 275,
D gets 25

Extensions:
    •Find the person to person transactions:
          C needs to pay 275 to B,
          A needs to pay 50 to B,
          A needs to pay 25 to D
    •Introduce weightage (uneven split). For an expense of 100, Person A incurs 75 and Person B incurs 25. For eg. {A: 0.1}, {B: 0.2}, {C: 0.7}
    
    
PS - trunk based development was followed as was hosting this project on gitlab with proper CI/CD but in the end migrated here on Github, Hence only master branch
