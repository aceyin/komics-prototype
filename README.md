# 开启JVM Hot Swap 
> 如果一个maven项目由多个模块构成，那么在本机调试的时候，如果没有开启 Hot Swap，JVM是没办法动态reload修改过的java类的。因此如果修改了代码，往往要重新启动JVM才能对新代码进行测试。这就导致本地测试需要频繁的启动JVM，从而导致测试效率很低。

## 请参照以下步骤开启JVM Hot Swap：
1. 安装 DCEM
   项目的 "hotswap" 目录已经包含了JDK 1.8u92版本的DCEM和0.4.0-SNAPSHOT版本的hotswap agent。
   如果你本机的JDK版本不是1.8u92，请在以下地址下载合适你JVM版本的DCEM:
   - [DCEM Download](https://github.com/dcevm/dcevm/releases)
   如果hotswap-agent有最新的版本，请从以下地址下载最新的版本:
   - [Hotswap Agent Download](https://github.com/HotswapProjects/HotswapAgent/releases)
2. 安装 DCEVM
   0. 请先备份你本机的JDK
   1. 以管理员身份运行 DECM-light-8u92-installer.jar
   2. 在弹出的界面，选择你本机JDK的安装目录
   3. 点击界面的"Install DCEM as altjvm"按钮

  
