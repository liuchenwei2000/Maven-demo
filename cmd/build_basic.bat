rem 快捷进入当前 bat 所在目录
cd /d %~dp0
cd..
rem 进去 Basic 目录执行构建
cd Basic
mvn clean install -Dmaven.test.skip=true
