node {
  stage('SCM') {
    checkout scm
  }
  stage('build && SonarQube analysis') {
            steps {
                //tools {
                //    sonarQube 'SonarQube Scanner 7.9.1.27448'
               // }
                //withSonarQubeEnv(installationName: 'sq1') {
                    // Optionally use a Maven environment you've configured already
                    //    sh './mvnw clean org.sonarsource.scanner.maven:sonar-maven-plugin:3.9.0.2155:sonar'
                 //   sh 'sonar-scanner'
                //}
                script {
                def scannerHome = tool 'sonarqube';
                withSonarQubeEnv(installationName: 'sq1') {
                    bat "mvn sonar:sonar \
                   -Dsonar.projectKey=cicdjenkins \
                   -Dsonar.host.url=http://localhost:9000 \
                   }
               }
            }
}
