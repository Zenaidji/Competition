all:  play  

play:classes
	java -classpath classes game.Game 16
		
doc:
	javadoc -sourcepath src -d docs -subpackages competition game competitor matchs util competition.division competition.selection competition.observers competition.score competitio.infos 

compileTest:classes
	javac -sourcepath src -d classes test/competition/MockSelection.java 
	javac -sourcepath src -d classes test/competition/observers/MookObserver.java 
	javac -cp classes:junit-platform-console-standalone-1.9.1.jar -d classes test/*/*.java
	javac -cp classes:junit-platform-console-standalone-1.9.1.jar -d classes test/*/*/*.java
	
runAllTests:compileTest classes
	java -jar junit-platform-console-standalone-1.9.1.jar  -cp classes --scan-class-path
	
classes: 
	javac -sourcepath src -d classes src/*/*.java
	
	
jar:classes
	jar cvfe game.jar game.Game -C classes .
	
playwithjar:jar classes
	java -jar game.jar 8
	



clean:
	rm -rf classes 
	rm -rf docs
	rm -f game.jar



