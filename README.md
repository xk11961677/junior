[//]: # (<p align="center">)

[//]: # (	<a href=""><img src="docs/images/logo.jpg" width="400"></a>)

[//]: # (</p>)
<p align="center">
	<strong>JUNIOR[小学生]</strong>
</p>
<p align="center">
	<a href="">
		<img src="https://img.shields.io/badge/版本-0.0.1-blue.svg">
	</a>
	<a target="_blank" href="https://mit-license.org/license.html">
		<img src="https://img.shields.io/:license-mit-blue.svg" >
	</a>
	<a target="_blank" href="https://img.shields.io/badge/gradle-7.5-blue">
		<img src="https://img.shields.io/badge/gradle-7.5-blue">
	</a>
	<a target="_blank" href="https://www.oracle.com/technetwork/java/javase/downloads/jdk17-downloads-5066655.html">
		<img src="https://img.shields.io/badge/JDK-17+-green.svg" >
	</a>
	<a target="_blank" href="https://spring.io/projects/spring-boot">
		<img src="https://img.shields.io/badge/Spring%20Boot-2.6+-green.svg" alt="Spring%20Boot Version">
	</a>
	<a target="_blank" href="https://spring.io/projects/spring-cloud">
		<img src="https://img.shields.io/badge/Spring%20Cloud-Greenwich+-green.svg" alt="Spring%20Cloud Version">
	</a>
</p>


-------------------------------------------------------------------------------

## 介绍

junior是一个轻量级基础工具库。

## 工程结构

```
. junior 基础库
├── docs  文档
│   ├── images  图片
│   └── other   其它
├── scripts   脚本
├── junior-all  junior所有模块对外bom (废弃，想是本项目对外模块bom ，后来想太啰嗦直接放到bom)
├── junior-parent  junior引用的三方JAR包
├── junior-bom  对外bom、包含本项目模块、一方包、二方包、三方包
├── junior-dubbo
│   ├── junior-dubbo-registry-spectrum
│   └── junior-dubbo-xxx
├── junior-migration
│   ├── junior-migration-base
│   └── junior-migration-flyway
├── starters  标准springboot starter工程
│   ├── sass-spring-boot-starter
│   └── migration-spring-boot-starter
├── examples  基础库示例
│   ├── junior-dubbo-demo
│   └── junior-migration-demo
└── junior end
```

## 快速使用

## 模块说明

## 问题反馈

## 待处理问题
1. maven-surefire-plugin 测试集成插件 、antlr
2. 有时间看下extra和ext区别，ext好像是标准的，extra是kotlin的 ?
3. 

## LICENSE
[MIT © junior](LICENSE)
