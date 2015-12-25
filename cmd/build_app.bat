cd /d %~dp0
cd..
cd App
mvn clean install -Dmaven.test.skip=true