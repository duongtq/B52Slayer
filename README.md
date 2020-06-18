# B52Shooting
## Shoot as many B52s as you can!

Install JavaFx [here](https://gluonhq.com/products/javafx/)

Compile and run (on Windows, using CMD)
Set path to JavaFx library
```bash
set PATH_TO_FX="path\to\your\javafx-sdk-14\lib"

```

Compile and run the server
```bash
javac Server.java UserThread.java
java Server 5000

```

Compile and run the client
```bash
javac --module-path %PATH_TO_FX% --add-modules javafx.controls PlayGround.java Client.java ClientReadThread.java Message.java

java --module-path %PATH_TO_FX% --add-modules javafx.controls PlayGround

```