# RPN Calculator
Command-line based RPN calculator.

## Running the application

Ensure that you have `Docker` installed on your computer.

Build the docker image.
```sh
docker build -t rpn-calculator .
```

Run the docker image.
```sh
docker run -it rpn-calculator
```

Now you can interact with the CLI.
```sh
2 sqrt  
stack: 1.4142135623
2 clear 1 3 +
stack: 4
```

Press `Ctrl+C` to exit from the CLI.

## Running tests

Ensure that you have JDK 8 or higher installed on the computer.

Navigate to the root directory of the project.

```sh
./gradlew clean test
```

