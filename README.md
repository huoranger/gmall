# 购物商城项目后端

## 接口文档
地址：http://localhost:8001/swagger-ui.html

## 环境准备

### FastDFS安装
拉取镜像
```shell 
docker pull delron/fastdfs
```
运行
```shell
docker run -d --name tracker -p 22122:22122 -v /Users/huoranger/enviroment/fastdfs/tracker:/var/fdfs delron/fastdfs tracker
```
```shell
docker run -d --name storage -p 8888:8888 -p 23000:23000 -e TRACKER_SERVER=192.168.3.10:22122 -v /Users/huoranger/enviroment/fastdfs/storage:/var/fdfs -e GROUP_NAME=group1 delron/fastdfs storage
```