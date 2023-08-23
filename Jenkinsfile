pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                // Checkout your GitHub repository
                checkout scm
            }
        }

        stage('Build') {
            steps {
                // Add your build steps here
                // For example, if you're using Maven:
                sh 'mvn clean package'
            }
        }

        stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv('SonarQube') {
                    // You need to configure the "Your_SonarQube_Environment" in Jenkins
                    sh 'sonar-scanner'
                }
            }
        }
    }

    post {
        always {
            // Archive the SonarQube scan results
            archiveArtifacts(artifacts: 'target/sonar/report-task.txt', allowEmptyArchive: true)
        }
    }
}
