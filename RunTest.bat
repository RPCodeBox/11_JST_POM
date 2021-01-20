echo on
set projectLocation=D:\PROJECTS\Workspace\JST_POM
cd %projectLocation%
set classpath=%projectLocation%\bin;%projectLocation%\lib\*
java org.testng.TestNG testng.xml
