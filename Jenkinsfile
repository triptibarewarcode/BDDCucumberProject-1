pipeline {
    agent any

    tools {
        maven 'Maven'
        jdk 'JDK25'
    }

    stages {

    stage('Build') {
            steps {
                dir('BDDCucumber') {
                    bat 'mvn clean compile'
                }
            }
        }

        stage('Test') {
            steps {
                dir('BDDCucumber') {
                    bat 'mvn test'
                }
            }
        }

        stage('Report') {
            steps {
                echo 'Tests executed, check Extent Reports'
            }
        }
    }
}
