#!/bin/bash

# Compile the Kotlin file into a JAR
kotlinc src/main/kotlin/Main.kt -include-runtime -d Main.jar

# Check if compilation was successful
if [ $? -eq 0 ]; then
    echo "Kotlin compilation successful. Running the program..."
    # Run the compiled JAR
    java -jar Main.jar
else
    echo "Kotlin compilation failed."
fi