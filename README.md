# Android-IPC-demo
使用Messenger实现的进程间通讯，可以用于实现本地逻辑划分，运算逻辑放到另外一个进程进行，主进程只负责更新界面

# 目的
减少ui进程的操作，提升ui流畅性，同时运算逻辑出现问题崩溃时不影响ui进程，只需重启远程服务即可继续提交运算请求，提高了应用的稳定性
