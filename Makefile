all: run

clean:
	rm -f out/Main.jar out/IntegralCalc.jar

out/Main.jar: out/parcs.jar src/Main.java src/Interval.java
	@javac -cp out/parcs.jar src/Main.java src/Interval.java
	@jar cf out/Main.jar -C src Main.class -C src Interval.class
	@rm -f src/Main.class src/Interval.class

out/IntegralCalc.jar: out/parcs.jar src/IntegralCalc.java src/Interval.java
	@javac -cp out/parcs.jar src/IntegralCalc.java src/Interval.java
	@jar cf out/IntegralCalc.jar -C src IntegralCalc.class -C src Interval.class
	@rm -f src/IntegralCalc.class src/Interval.class

build: out/Main.jar out/IntegralCalc.jar

run: out/Main.jar out/IntegralCalc.jar
	@cd out && java -cp 'parcs.jar:Main.jar' Main