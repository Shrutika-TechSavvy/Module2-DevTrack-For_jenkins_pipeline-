pipeline {
    agent any
     options {
        skipDefaultCheckout(true)
    }
    tools {
        maven 'Maven'
    }

    stages {

        stage('Checkout SCM') {
            steps {
                echo 'Fetching code from GitHub...'
                checkout scm
            }
        }
        stage('Clone') {
            steps {
                echo 'Cloning repository...'
            }
        }

        stage('Build') {
            steps {
                echo 'Building project...'
                bat 'mvn clean compile'
            }
        }

        stage('Test') {
            steps {
                echo 'Running tests...'
                bat 'mvn test'
            }
        }
        stage('Package') {
            steps {
                echo 'Packaging application (creating JAR)...'
                bat 'mvn package'
            }
        }
    }
      post {
        success {
            echo '✅ Pipeline completed successfully!'
        }
        failure {
            echo '❌ Pipeline failed!'
        }
    }
}
