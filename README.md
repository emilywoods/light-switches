Spring Boot Application for turning on and off a set of coloured lights.

### Running locally: 
```
./gradlew clean build && java -jar build/libs/coloured-lights-0.1.0.jar
```

The user is asked to input a number of lights. If no input is received, the program defaults to 20.
The set of lights is a repeating set of colours. Each light is turned on for 1 second then turned off. 

Output format:
```
    {current time: HH:MM:SS} {light position} {colour} Light {light state}
```

For example:
```
12:00:01: 1 Red Light On
12:00:02: 1 Red Light Off
12:00:02: 2 Green Light On
12:00:03: 2 Green Light Off
etc.
etc.
```

