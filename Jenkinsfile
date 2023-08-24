pipeline {
    agent any
    
    stages {
        stage('SCM') {
            steps {
                checkout scm
            }
        }
        
        stage('SonarQube Analysis') {
            environment {
                // Define your SonarQube token
                SONAR_TOKEN = credentials('sonarqube-token')
            }
            steps {
                script {
                    def mvnHome = tool name: 'Maven', type: 'hudson.tasks.Maven$MavenInstallation'
                    
                    withSonarQubeEnv('sonarserver') {
                          bat "${mvnHome}/bin/mvn clean verify sonar:sonar " +
                           "-Dsonar.projectKey=cicdjenkins " +
                           "-Dsonar.sources=src " +
                           "-Dsonar.host.url=http://localhost:9000/ " +
                           "-Dsonar.login=${SONAR_TOKEN}"
                    }
                }
            }
        }
    }
}
// node {
//   stage('SCM') {
//     checkout scm
//   }
//   stage('SonarQube Analysis') {
//     withSonarQubeEnv('SonarQube') {
//       bat "${mvn}/bin/mvn clean verify sonar:sonar -Dsonar.projectKey=cicdjenkins -Dsonar.projectName='cicdjenkins' -Dsonar.host.url='http://localhost:9000/' -Dsonar.login=${env.sonarqube-token}"
//     }
//   }
// }
//             withSonarQubeEnv('SonarQube') {
//                 bat "${scannerHome}/bin/sonar-scanner.bat -Dsonar.projectKey='cicdjenkins' -Dsonar.host.url='http://localhost:9000/' -Dsonar.login=${env.SONAR_TOKEN}"
