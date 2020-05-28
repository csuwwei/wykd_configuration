第一步：安装：otp_win64_21.3.exe
第二步：安装：rabbitmq-server-3.7.14.exe

第三步：设置path
第四步：安装界面
第五步：设置账号
	查看是否安装成功命令：rabbitmqctl status
	添加用户命令：rabbitmqctl add_user wangwei wangwei
	设置角色命令：rabbitmqctl set_user_tags wangwei administrator
	设置图形化界面命令：rabbitmq-plugins enable rabbitmq_management
第六步：http://127.0.0.1:15672/#/
	登录：账号：wangwei  密码：wangwei	