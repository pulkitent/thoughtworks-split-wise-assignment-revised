# PROBLEM STATEMENT

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


# What the company is looking for?
They are looking for people who can write code that has flexibility built in, by adhering to the principles of Object Oriented Development, and have the ability to deal with the real-life constraints / trade-offs while designing a system.

It is important to note that they are not looking for a GUI and they are not assessing you on the capabilities around code required to do the I/O. The focus is on the overall design. So, while building a solution, it would be nicer if input to the code is provided either via unit tests or a file. Using command line (for input) can be tedious and difficult to test, so it is best avoided. Following is a list of things to keep in mind, before you submit your code:

1. Is behaviour of an object distinguished from its state and is the state encapsulated?

2. Have you applied SOLID principles to your code?

3. Have you applied principles of YAGNI and KISS (additional info here)?

4. Have you looked at basic refactoring to improve design of your code?

5. Finally, and foremost, are the principles applied in a pragmatic way.

Simplicity is the strongest of the trait of a piece of code. However, easily written code may not necessarily be simple code.


# Things I tried to follow:

1. Tried to create all the required domain entities/models as per problem statement

2. Tried not to break encapsulation by avoiding getters & setters (as much as possible)

3. Tried to have immutable state with value objects (as much as possible) so as to avoid concurrency issues (Thread safety)

4. Tried to have readable methods & variables naming so as to clear the intention (4 rules of simple design).

5. Tried to have small & logical commits

6. Tried to avoid code duplication by refactoring/reusing duplicate code (DRY) but still code duplication can be improved if given more time

7. Didn't make interfaces as per YAGNI principles because for now I don't feel the need for the same (Yes, I am aware of this principle also - "Program to interfaces rather than concrete implementation")

8. Tried to put some comments so as to make business logic more understandable

9. Wrote the job on every class so as to clear it's use case

This is a gradle project based on java. It's an Objected Oriented Design(OOD) problem generally asked in interviews. Main reason behind asking these kind of problems in interview is to see whether a candidate can do following :

1. Can a candidate write a working code in given short span of time.

2. Can a candidate write higly readbale code. Intention must be clear by reading the code.

3. Can a candidate follow the principle the of DRY (Don't Repeat Yourself) and avoid to break encapsulation by following Domain Driven Design(DDD).

4. Can a candidate achieve the solution with minimum number of elements using YAGNI principle (that is without creating unnecesarry interfaces etc).


# Things I could have done/improved if given more time :

1. TDD with 100% code coverage

2. Code duplication can be further reduced at some extent

3. Level of indentation can be further reduced in some methods by breaking them into smaller methods

4. Encapsulation of behaviour in some classes can be further improved

5. More mocking and stubbing of test data in unit tests
