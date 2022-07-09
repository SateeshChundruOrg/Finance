pipeline {
  agent {
    node {
      label 'EC2_NODE'
    }

  }
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

  }
}