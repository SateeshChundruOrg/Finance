pipeline {
    agent any

    stages {
        stage('Compile') {
            steps {
               sh 'mvn clean compile'
            }
        }
        stage('Build') {
            steps {
               sh 'mvn clean install'
            }
        }
        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }
        stage('Docker build') {
            steps {
               sh 'sudo docker build -f Dockerfile -t finace-app-boot .'
            }
        }
    }
}