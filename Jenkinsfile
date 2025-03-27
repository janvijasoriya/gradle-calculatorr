pipeline {
    agent any
    
    parameters {
        string(name: 'num1', defaultValue: '5', description: 'First number')
        string(name: 'num2', defaultValue: '3', description: 'Second number')
        string(name: 'OPERATION', defaultValue: '+', description: 'Operation (+, -, *, /)')
    }
    
    triggers {
        cron('H 10 * * *') 
    }
    
    stages {
        stage('Checkout') {
            steps {
                cleanWs()
                git branch: 'main', 
                   url: 'https://github.com/janvijasoriya/gradle-calculatorr.git'
            }
        }
        
        stage('Build') {
            steps {
                bat 'gradlew.bat clean build -Dsonar.gradle.skipCompile=true'
            }
        }
        
        stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv('SonarQube') {
                    bat 'gradlew.bat sonar -Dsonar.gradle.skipCompile=true'
                }
            }
        }
        
        stage('Run Calculator') {
            steps {
                script {
                    def validOps = ['+', '-', '*', '/']
                    if (!validOps.contains(params.OPERATION)) {
                        error("Invalid operation. Must be one of ${validOps}")
                    }
                    bat "gradlew.bat runCalculator -Pnum1=${params.NUM1} -Pnum2=${params.NUM2} -Poperation=${params.OPERATION}"
                }
            }
        }
        
        stage('Archive Artifacts') {
            steps {
                archiveArtifacts artifacts: '**/build/libs/*.jar', fingerprint: true
            }
        }
    }
    
    post {
        always {
            cleanWs()
        }
        success {
            echo 'Build successful! SonarQube results available at http://localhost:9000'
        }
        failure {
            echo 'Build failed! Check logs for details.'
        }
    }
}
