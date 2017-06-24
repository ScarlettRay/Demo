#dubbo+zookeeper+springmvc整合的一个Demo </br>
此项目共有三个模块，分别为Customer,provider,和一个共用Api模块 </br>
 </br>
customer模块我部属在本机，provider和zookeeper安装在阿里云服务器上 </br>
然后访问本地的customer提供的服务，customer就调用远程服务器上暴露的接口获取服务并返回给用户。 </br>
 </br>
整个项目大部分是一些配置，但需要做很多的部署工作。 </br>
将这个项目部署到我的云服务器上，由于阿里云给我的内存只有1G,tomcat上发布完这个项目，直接让我运行着的nginx宕机了。致使个人网站无法访问，呵呵。。。 </br>
 </br> </br>
在阿里云服务器上发布provider有个巨坑，就是阿里云服务器上的主机名默认指向服务器的内网IP,而dubbo获取IP是通过主机名，进而在zookeeper主册的服务URI暴露的是内网iP, </br>
而客户端是无法通过内网IP访问到provider的，最终会报连接超时的错误。 </br>
解决办法就是修改hosts文件，在其中添加一行 </br>
#下面这行</br>
公网ip    hostname(你的主机名)
