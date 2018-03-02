echo off
set projectLocation=E:\PROJECTS\JavaWorkSpace\JST_POM
cd %projectLocation%
set classpath=%projectLocation%\bin;%projectLocation%\lib\*
java org.testng.TestNG testng.xml
