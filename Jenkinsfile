pipeline {
    agent any
    
    environment {
        JAVA_HOME = 'D:\\DevOps Training\\zulu21.48.15-ca-jdk21.0.10-win_x64'
        PATH = "${env.JAVA_HOME}\\bin;${env.PATH}"
    }
    
    stages {
        stage('Checkout') {
            steps {
                echo 'Checking out source code...'
                checkout scm
            }
        }
        
        stage('Clean') {
            steps {
                echo 'Cleaning previous build artifacts...'
                bat 'mvn clean'
            }
        }
        
        stage('Compile') {
            steps {
                echo 'Compiling the application...'
                bat 'mvn compile'
            }
        }
        
        /*stage('Package') {
            steps {
                echo 'Packaging the application...'
                bat 'mvn package -DskipTests'
            }
            post {
                success {
                    archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
                    echo "Successfully created JAR file"
                }
            }
        }*/
    }
    
    post {
        always {
            echo 'Pipeline execution completed!'
            cleanWs()
        }
        
        success {
            echo 'Pipeline executed successfully!'
        }
        
        failure {
            echo 'Pipeline failed!'
        }
    }
}
