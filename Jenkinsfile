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
                       sh 'docker kill finance-app-boot1 && docker run -p 8085:8085  -d=true  finance-app-boot'
                    }
                }

    }
}