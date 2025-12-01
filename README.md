# Assignment 1 part 1. For passing grade E-D

This assignment consists of three parts
 * A practice part for writing and running automated test suites and measure coverage.
 * A second practice part for writing tests with a mocking framework
 * An oral exam that you book in a spreadsheet (see slack for link)

Note that the practice parts are mandatory for passing grade but that we examine YOUR knowledge and not only the code. You also need to be able to during oral examination write a unit test for a code given to you during examination without AI-support. You are supposed to use a suitable assert/expect so you need to study your framwork.

This means it is essential that you practice writing tests yourself, and not only copy, or generate a solution to the practice tasks. 


Each practice task is designed to let you learn what you need to pass the examination.


## Practice tasks:
Find the code and practice tasks here
https://github.com/dntoll/1dv609_a1_part_1

![fork](fork.png)
 * [Fork](https://docs.github.com/en/pull-requests/collaborating-with-pull-requests/working-with-forks/fork-a-repo) this repo on GitHub 
 * [Clone](https://docs.github.com/en/repositories/creating-and-managing-repositories/cloning-a-repository) the forked repo to your own computer. 
 * You can make the fork private if you want. This is not really submitted to anyone.  
 * Follow the instructions in the two Markdown files in the root directory.
   * Start with this: Practice_ write_run_tests.md 
   * Continue with this: Practice_write_mocked_tests.md
 * Select Java or .js versions and check their instructions (README.md in each folder)
 * Dont forget to answer the reflection questions in the bottom of this file. You may discuss these with other students.
 * Ask questions in Slack!

## Examination 

Examinations are booked in a spreadsheet given in a pinned Slack-post. 
 * You may only book one session. A session can be more than one slot (see below)
   * Each slot is 15 minutes
   * For A1 p1 book one slot a 15 minutes
   * For A1 p2 (higher grade) book two sequential slots ( 30minutes )
   * Students with written permission can book up double amount of sequential slots
* Notify course management if we run out of slots!

If time runs out before a passing grade can be set, a Fail is recorded.

Prepare: 
* Disable AI in your editor for the examination. No tab to complete.
* Be prepared to show the results of the two practice tasks.
* Be prepared to run the tests, to measure coverage, and use mocking.
* Be prepared to edit and write code.
* Be prepared to answer questions about any part of your code.
* During examination you will write one or more unit test for new a function that you will be given during examination. You should be able to write unit-tests for that function, run the test, measure coverage. You should be able to select "assert/expect method" depending on the type of function to one of the suitable used in practice tasks. 
* During the examination you are also asked a couple of questions related to the practice task and the study material specified.
* You are not allowed to use AI to solve the task during the examination. You may look at the practice tasks during this examination.
* You will also be asked questions from the list below.



### Reflection Questions

During Examination you may be asked these or related questions. You should be able to answer these questions in depth. 

- How many tests are needed to find all bugs in the examples? Do you think this is enough testing for these problems? Too much?
**Svar: Jag gjorde 22 tester för att hitta alla buggar. Jag tycker att det är tillräckligt med tester med tanke på att Password har 5 metoder och 6 tester för 100% coverage, SwedishSocialSecurityNumber har 7 tester för att testa interaktionen med SSNHelpers 5 metoder, SSNHelper har 5 metoder och 9 tester. Anledningen till att SSNHelper har fler tester är för att koden är mer komplex med flera conditions, ju fler conditions man har desto fler branches behöver man testa för att testa båda positiv och negativ väg.**
- What are the missing tests you think would be good to add? 
**Svar: Jag saknar två tester i SSNHelper för att testa isCorrectLength och isLuhnCorrect. Jag testar endast mot om längden är == 11 och inte != 11 samt ifall returvärdet sum % 10 != 0. Detta testar de båda metodernas negativa väg. Just nu testar jag bara ifall metoden uppfyller att SN är == 11 och att divisionen inte lämnar någon rest == 0.**
- What is **good test data** for this example and why?
**Svar: Bra test data är att testa alla branches (conditions sant/falskt exempelvis) så man testar alla vägar, att testerna är realistiska (något som en programmerare hade kunnat råka göra fel, eller en användare råka fylla i).** 
* Should private methods be tested? What are the pros and cons of having a "helper class" instead of private methods?
**Svar: Privata metoder kan testas indirekt genom att testa det publika APIet där metoden används. Problemet där är att man inte vet om det är fel i det publika APIet eller den privata metoden om testet misslyckas. Extraherar man logiken till en hjälpklass (abstraktion) med en publik metod istället så kan man direkttesta metoden och bevara inkapslingen. Är logiken inte så komplex så går det bra att testa den privata metoden indirekt, men ökar komplexiteten så är det bra att kunna testa metoden direkt.**
- What kind of "asserts"/"expects" can be done in your testing framework?
**Svar: I JUnit så finns det AssertTrue, AssertFalse, AssertEquals, AssertNotEquals, AssertThrows, AssertThrowsExactly, AssertDoesNotThrow, AssertNull, AssertNotNull, AssertArrayEquals, AssertSame, AssertNotSame, AssertThat, AssertAll, AssertIterableEquals, AssertLinesMatch, AssertInstanceOf, AssertTimeOut, AssertTimeOutPreemptively, fail(), fail(String message).**
- What kind(s) of Code Coverage is shown in your code coverage tool? What does the different coverage values mean?
**Svar: I JaCoCo så visas coverage för antalet rader, branches (conditions), instruktioner (alla kodsnuttar) och metoder. Verktyget hjälper till att visa vad som har körts i nuvarande tester och vad som saknas.**
- Why should a single test only have one assert/expect?
**Svar: Helst vill man följa denna principen för att om du har fler asserts/expects i en testmetod och testet failar, så vet man inte direkt om det är båda asserts/expect som failar eller om det bara är en. Har man endast 1 av dem så vet man direkt vad det är som failar. Genom namngivningen av testmetoden så vet man också exakt vad det är den testar, man behöver inte djupdyka mer i testet eller koden för att förstå vad det är som inte gick bra. Skulle det behövas göras mer än 1 assert så kanske man ska fundera över om metoden man testar endast gör en sak/har ett beteende.**
* What is the two main purposes of using mocks?
**Svar: Om en klass har ett beroende av en annan klass och du vill testa den beroende klassens interaktion med den andra klassen, så är det bra att använda mocks för att skapa en imitation av den klassen man är beroende av. Detta utesluter beteendet av den klassen man är beroende av och testar endast samspelet mellan klasserna. Du verifierar även genom verify() ifall interaktionen gick igenom eller inte. Det som också är positivt är att du kan välja hur den imiterade klassen ska bete sig för att få fram testresultaten du är ute efter, istället för att använda den riktiga klassen.**
* Why is it good if a test for a SUT is independent of the classes that the SUT depends on?
**Svar: Det är bra eftersom du endast vill testa interaktionen mellan klasserna. Du vill inte "råka" testa den andra klassens beteende i detta fallet av test, därför är det bäst att testa oberoende av den andra klassens beteende och eventuella buggar.**
* Can all bugs be found by testing?
**Svar: Nej alla buggar kan inte hittas genom testning. Ta ett datorspel exempelvis, det finns bara X-antal utvecklare som jobbar på spelet och det är omöjligt för dessa utvecklare att hitta alla eventuella buggar som spelare kommer att lyckas upptäcka. Spelarna är många fler än utvecklarna, har ett annat tänk och ibland vill "breaka" spelet bara för att. Därför har datorspel väldigt frekvent patcher etc som fixar buggar som de själva eller spelarna upptäckt genom åren.**
- Do all tests need asserts/expects?
**Svar: Det beror på vad du gör för typ av testning. Gör man manuella tester på en webbapplikation exempelvis så testar man manuellt med tangentbord/datormus. Men skriver du enhetstester med ett ramverk som JUnit så behöver man skriva åtminstone en assert för att berätta för datorn vad det är man förväntar sig ska hända när man kör testet. Det finns säkert fall där man endast vill testa att anropa en metod utan att systemet kraschar, men då skulle man också kunna använda assertDoesNotThrow för att säkerställa att metoden anropades utan att kasta ett undantag.**
- Can we with testing prove that we are 100% bug free?
**Svar: Nej det kan vi inte göra. Det finns många parametrar som kan gå fel vid testning. Skriva dåliga tester, inte förstått kraven tillräckligt bra, inte tänkt på alla möjliga edge cases som kan uppstå etc.**