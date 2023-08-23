node {
  stage('SCM') {
    checkout scm
  }
  stage('SonarQube Analysis') {
    withSonarQubeEnv('SonarQube') {
      bat "${mvn}/bin/mvn clean verify sonar:sonar -Dsonar.projectKey=cicdjenkins -Dsonar.projectName='cicdjenkins' -Dsonar.host.url='http://localhost:9000/' -Dsonar.login=${env.sonarqube-token}"
    }
  }
}
//             withSonarQubeEnv('SonarQube') {
//                 bat "${scannerHome}/bin/sonar-scanner.bat -Dsonar.projectKey='cicdjenkins' -Dsonar.host.url='http://localhost:9000/' -Dsonar.login=${env.SONAR_TOKEN}"
