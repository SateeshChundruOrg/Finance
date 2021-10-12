pipeline {
    agent any

    stages {
        stage('Compile') {
            steps {
               sh 'pwd && mvn clean compile'
            }
        }
        stage('Build') {
            steps {
               sh 'mvn clean install'
            }
        }
        stage('Test') {
            steps {
                sh 'pwd'
            }
        }
        stage('Docker build') {
            steps {
               sh 'docker build -f Dockerfile -t finance-app-boot .'
            }
        }
         stage('Docker deploy') {
                    steps {
                       sh 'docker container rm -f finance-app-boot && docker run -p 8085:8085  -d=true --name=finance-app-boot finance-app-boot'
                    }
                }

    }
}