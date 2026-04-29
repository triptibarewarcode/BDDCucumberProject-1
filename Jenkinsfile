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

        stage('Publish Report') {
    steps {
        publishHTML([
            allowMissing: false,
            alwaysLinkToLastBuild: true,
            keepAll: true,
            reportDir: 'BDDCucumber/Reports',  // adjust if needed
            reportFiles: 'ExtentReport.html',
            reportName: 'Extent Report'
        ])
    }
}
        stage('Report') {
            steps {
                echo 'Tests executed, check Extent Reports'
            }
        }
    }
}
