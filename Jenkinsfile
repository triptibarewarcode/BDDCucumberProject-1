pipeline {
    agent any

    tools {
        maven 'Maven'
        jdk 'JDK25'
    }

    stages {

        stage('Build') {
            steps {
                bat 'mvn clean compile'
            }
        }

        stage('Test') {
            steps {
                bat 'mvn test'
            }
        }

        stage('Report') {
            steps {
                echo 'Tests executed, check Extent Reports'
            }
        }
    }
}
