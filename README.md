# cellphoneplan_java

I've tried to compile. It works.

# Commands to Compile 

I first used this command to start compiling
```
javac -d bin -cp bin src/CellPhonePlan.java
```

The instructions told me to also use this command after the first one, but it never seemed to work

```
java -cp bin CellPhonePlan
```

So I would just skip that command, and go right on to use this command, it would compile most of the time:

```
javac -d bin -cp "bin:lib/*" test/CellPhonePlanTest.java
``` 

After compiling the file, using junit on Test file using the following command:

```
java -jar lib/junit-platform-console-standalone-1.6.2.jar -cp bin -c CellPhonePlanTest
```

# Junit testing gives error
Portion of the error code:

```
org.junit.platform.commons.JUnitException: TestEngine with ID 'junit-jupiter' failed to discover tests
	at org.junit.platform.launcher.core.DefaultLauncher.discoverEngineRoot(DefaultLauncher.java:189)
	at org.junit.platform.launcher.core.DefaultLauncher.discoverRoot(DefaultLauncher.java:168)
	at org.junit.platform.launcher.core.DefaultLauncher.execute(DefaultLauncher.java:132)
	at org.junit.platform.console.tasks.ConsoleTestExecutor.executeTests(ConsoleTestExecutor.java:66)
	at org.junit.platform.console.tasks.ConsoleTestExecutor.lambda$execute$0(ConsoleTestExecutor.java:58)
	at org.junit.platform.console.tasks.CustomContextClassLoaderExecutor.replaceThreadContextClassLoaderAndInvoke(CustomContextClassLoaderExecutor.java:41)

```


