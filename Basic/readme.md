## POM 文件简介 ##

Maven 项目的核心是 pom.xml，放在项目的根目录中。POM（Project Object Model）定义了项目的基本信息，用于描述项目如何构建，声明项目依赖。

没有任何实际的 Java 代码也能够定义一个 Maven 项目的POM，这能让项目对象模型最大程度地与实际代码相独立，避免了 Java 代码和 POM 代码相互影响。比如当项目需要升级版本时，只需要修改 POM，而不需要更改 Java 代码；而在 POM 稳定之后，日常的 Java 代码开发工作基本不涉及 POM 的修改。


项目主代码会被打包到最终的构件中（如 jar），而测试代码只在运行测试时用到，不会被打包。

Maven 约定项目主代码位于 `src/main/java` 目录，它会自动搜寻该目录找到项目主代码；
约定项目测试代码位于 `src/test/java` 目录，测试时会自动搜寻该目录。

可以使用 maven 的 archetype 来创建新项目的骨架，命令如下：
`mvn archetype:generate`