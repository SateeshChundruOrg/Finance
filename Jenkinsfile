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
                sh 'mvn test'
            }
        }
        stage('Docker build') {
            steps {
               sh 'docker build -f Dockerfile -t finace-app-boot .'
            }
        }
    }
}