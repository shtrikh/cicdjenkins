pipeline {
    agent any
    
    environment {
        SONAR_TOKEN = credentials('sonarqube-token') // Assuming you have a Jenkins credential named 'sonarqube-token' for the SonarQube token
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean package'
                // Your build steps here
            }
        }

        stage('SonarQube Analysis') {
            steps {
                script {
                    def scannerHome = tool name: 'SonarQubeScanner', type: 'hudson.plugins.sonar.SonarRunnerInstallation'
                    withSonarQubeEnv('SonarQubeServer') {
                        bat "${scannerHome}/bin/sonar-scanner -Dsonar.projectKey=cicdjenkins -Dsonar.host.url=http://localhost:9000/ -Dsonar.login=${env.SONAR_TOKEN}"
                    }
                }
            }
        }

        stage('Publish Quality Gate') {
            steps {
                script {
                    def qualitygate = waitForQualityGate() // Assuming you have the 'SonarQube Quality Gates' plugin installed
                    if (qualitygate.status != 'OK') {
                        error "Quality Gate did not pass"
                    }
                }
            }
        }
    }

    post {
        failure {
            script {
                // Additional failure handling or notifications
            }
        }
    }
}
// pipeline {
//     agent any

//     stages {
//         stage('Checkout') {
//             steps {
//                 // Checkout your GitHub repository
//                 checkout scm
//             }
//         }

//         stage('Build') {
//             steps {
//                 // Add your build steps here
//                 // For example, if you're using Maven:
//                 sh 'mvn clean package'
//             }
//         }

//         stage('SonarQube Analysis') {
//             steps {
//                 withSonarQubeEnv('SonarQube') {
//                     // You need to configure the "Your_SonarQube_Environment" in Jenkins
//                     sh 'sonar-scanner'
//                 }
//             }
//         }
//     }

//     post {
//         always {
//             // Archive the SonarQube scan results
//             archiveArtifacts(artifacts: 'target/sonar/report-task.txt', allowEmptyArchive: true)
//         }
//     }
// }
