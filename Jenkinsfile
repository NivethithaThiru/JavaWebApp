pipeline{
    agent any
    environment {
        PATH = "$PATH:C:/apache-maven-3.8.3/bin"
    }
    stages{
       stage('Checkout SCM'){
            steps{
                git url: "https://github.com/NivethithaThiru/javaWebApp.git"
            }
        } 
        stage('Build Code'){
            steps{
                bat 'mvn clean package -Dmaven.test.skip=true'
            }
        }
        stage('Test Code') {
            steps{
                bat 'mvn test'
            }
        }
        stage('SonarQube Analysis') {
            steps{
                withSonarQubeEnv('sonarqube1') { 
                    bat "mvn sonar:sonar"
                }
            }
        }
        stage('Deploy war file and build info to Artifactory') {
            steps {
                rtUpload (
                    serverId: "Jfrog-Server",
                    spec: ''' {
                        "files": [
                            {
                                "pattern": "*.war",
                                "target": "java-webapp1-libs-snapshot-local/com/example/maven-project/webapp/1.0-SNAPSHOT/"
                            },
                            {
                                "pattern": "*.jar",
                                "target": "java-webapp1-libs-release-local/com/example/maven-project/server/1.0-SNAPSHOT/"
                            }
                        ]
                    } '''
                )
                rtPublishBuildInfo (
                    serverId: "Jfrog-Server"
                )
            }
        } 
    }
}
