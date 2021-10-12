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
                       sh 'docker stop finance-app-boot1 && docker start finance-app-boot1'
                    }
                }

    }
}