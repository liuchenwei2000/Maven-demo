echo start building 

@echo off
rem 关闭回显，不再显示命令

rem 设置 cmd_home 变量值为此 bat 文件所在目录
set cmd_home=%cd%

rem 调用 build_basic.bat 
call %cmd_home%/build_basic.bat
call %cmd_home%/build_app.bat
call %cmd_home%/run_app.bat

pause