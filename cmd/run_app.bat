cd /d %~dp0
cd..
rem 进去 App/web 目录运行 web 应用
cd App/web
mvn tomcat7:run

