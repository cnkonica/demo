pipeline {
    agent any

    tools{
            maven 'apache-maven-3.6.1'
        }

    stages {
        stage('拉取代码') {
            steps {
                git credentialsId: 'eadd004e-5cff-4ccd-8745-20a3d263fb5f', url: 'https://gitee.com/wudikaka/demo.git'
                echo '拉取成功'
            }
        }
        stage('执行构建') {
            steps {
            // 如果maven可以运行，那么执行以下代码，这里需要注意一下，pom.xml文件是否在你创建的任务目录下
                sh "mvn clean package -U -pl demo-eureka -am -Dmaven.test.skip=true"
                echo '构建完成'
            }
        }
        stage('把jar包构建为docker镜像并运行') {
            steps {
                echo '运行成功'
            }
        }
    }
}
