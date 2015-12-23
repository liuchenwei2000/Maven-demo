## Maven简介 ##

Maven 主要服务于基于 Java 平台的项目构建、依赖管理和项目信息管理。

构建是指编译、运行单元测试、生成文档、打包和部署等繁琐且不起眼的工作。如果用软件的方法让这一系列工作完全自动化，使得软件的构建可以像全自动流水线一样，只需要一条简单的命令，所有繁琐的步骤都能够自动完成，很快就能得到最终结果。这就是 Maven 的产生背景。

Maven 首先是一个强大的 **构建工具**，能够自动化整个构建过程，从清理、编译、测试到生成报告，再到打包和部署。使用 Maven 配置好项目，然后输入简单的命令（如 `mvn clean install`），Maven 就会处理那些繁琐的任务。

Maven 最大化地消除了构建的重复，它抽象了一个完整的构建生命周期模型，这个模型吸取了大量其他的构建脚本和构建工具的优点，总结了大量项目的实际需求。如果遵循这个模型，可以避免很多不必要的错误，可以直接使用大量成熟的 Maven 插件来完成任务。如果有非常特殊的需求，也可以轻松实现自己的插件。

Maven 提供了一个优秀的解决方案，它通过一个坐标系统准确地定位每一个构件（artifact），也就是通过一组坐标 Maven 能够找到任何一个 Java 类库（jar文件）。因此，可以借助它来有序地**管理依赖**，解决那些繁杂的依赖问题。

Maven 对于项目目录结构、测试用例命名方式等内容都有既定的规则，只要遵循了这些成熟的规则，用户在项目间切换的时候就免去了额外的学习成本，可以说是约定优于配置（COC）。