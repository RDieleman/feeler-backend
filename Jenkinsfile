pipeline {

    agent any

    stages {

        stage('Build') {
            steps {
                sh '''
                    chmod +x ./jenkins/build/mvn.sh
                    ./jenkins/build/mvn.sh mvn -B -DskipTests clean package
                    chmod +x ./jenkins/build/build.sh
                    ./jenkins/build/build.sh
                '''
            }
        }

        stage('Test') {
            steps {
                sh '''
                    chmod +x ./jenkins/test/mvn.sh
                    ./jenkins/test/mvn.sh mvn test
                '''
            }
        }

        stage('Push') {
            steps {
                sh '''
                    chmod +x ./jenkins/push/push.sh
                    ./jenkins/push/push.sh
                '''
            }
        }

        stage('Deploy') {
            steps {
                sh 'docker-compose -f ./jenkins/deploy/docker-compose-deploy.yml up -d'
            }
        }
    }
}