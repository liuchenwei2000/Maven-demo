## 构建 Web 应用 ##

Maven 对 Web 项目的布局结构也有通用的约定：类及资源文件同一般 JAR 项目一样，默认位置都是 `src/main/java` 和 `src/main/resources`，测试类及测试资源文件的默认位置是 `src/test/java` 和 `src/test/resources`。除此之外，Web 项目还有一个 Web 资源目录，默认位置是 `src/main/wepapp`，它里面含有 WEB-INF 目录和 html、css、js、jsp 等文件，其中 WEB-INF 目录是必须的，其内还必须要有 web.xml 文件。

WAR 包中有一个 lib 目录，包含所有依赖 JAR 包，但 Maven 项目结构中没有这样一个目录，这是因为依赖都配置在 POM 中，Maven 在用 WAR 方式打包的时候会根据 POM 的配置从本地仓库复制相应的 JAR 文件。


用户必须为 Web 项目显式指定打包方式为 war。详见 pom.xml。