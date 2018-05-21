@echo off
java -Xmx500M -cp "lib\antlr-4.7-complete.jar" org.antlr.v4.Tool -Dlanguage=Java -package "ANTLR" -visitor "src/Gramatika/Princess.g4" -o "src/ANTLR"
pause