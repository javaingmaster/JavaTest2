cd Exam1
mvn clean
mvn package
mvn install
java -jar target/exam1.jar
cd ..
cd Exam2
mvn clean
mvn package
mvn install
java cp target/exam2.jar com.hand.socket.MainOfServer
java cp target/exam2.jar com.hand.socket.MainOfClient
cd ..
cd Exam3
mvn clean
mvn package
mvn install
java -jar target/exam3.jar
cd ..