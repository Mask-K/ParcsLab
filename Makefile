all: run

clean:
	rm -f out/Main.jar out/IntegralCalc.jar

out/Main.jar: out/parcs.jar src/Main.java
	@javac -cp out/parcs.jar src/Main.java
	@jar cf out/Main.jar -C src Main.class
	@rm -f src/Main.class

out/IntegralCalc.jar: out/parcs.jar src/IntegralCalc.java
	@javac -cp out/parcs.jar src/IntegralCalc.java
	@jar cf out/IntegralCalc.jar -C src IntegralCalc.class
	@rm -f src/IntegralCalc.class

build: out/Main.jar out/IntegralCalc.jar

run: out/Main.jar out/IntegralCalc.jar
	@cd out && java -cp 'parcs.jar:Main.jar' Main