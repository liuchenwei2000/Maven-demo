## 编写 Maven 插件 ##

大量的 Maven 插件可以从 Apache 和 Codehaus 获得，这里的近百个插件几乎能够满足所有 Maven 项目的需要。在一些非常情况下有特殊的需求，并且无法找到现成的插件可供使用，那就只能自己编写 Maven 插件。


### 编写 Maven 插件的一般步骤 ###

* 1，创建一个 maven-plugin 项目

	插件本身也是 Maven 项目，它的 packaging 必须是 maven-plugin，可以使用 `maven-archetype-plugin` 快速创建一个 Maven 插件项目。

* 2，为插件编写目标（`goal`）

	每个插件都必须包含一个或者多个目标，Maven 称之为 `MOJO`（Maven Old Java Object）。编写插件的时候必须提供一个或者多个继承自 `AbstractMojo` 的类。

* 3，为目标提供配置点

	大部分 Maven 插件及其目标都是可配置的，因此在编写 `Mojo` 的时候需要注意提供可配置的参数。

* 4，编写代码实现目标行为

	根据实际的需要实现 `Mojo`。

* 5，错误处理及日志

	当 `Mojo` 发生异常时，根据情况控制 Maven 的运行状态。在代码中编写必要的日志以便为用户提供足够的信息。

* 6，测试插件

	编写自动化的测试代码测试行为，然后再实际运行插件以验证其行为。

具体示例见 `maven-demo-plugin` 项目，使用该自定义插件详见 `Basic\basic_jdbc\pom.xml`。

