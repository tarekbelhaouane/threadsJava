pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                checkout([$class: 'GitSCM', 
                    branches: [[name: '*/master']], 
                    doGenerateSubmoduleConfigurations: false, 
                    extensions: [], 
                    submoduleCfg: [], 
                    userRemoteConfigs: [[url: 'https://github.com/tarekbelhaouane/threadsJava.git']]
                ])
            }
        }

        stage('Build') {
            steps {
                script {
                    sh 'mvn clean package'
                }
            }
        }

        stage('Deploy to Tomcat') {
            steps {
                script {
                    ansiblePlaybook( 
                     playbook: '/var/lib/jenkins/jobs/ansiblePipeline/deploy.yml',
                     inventory: '/var/lib/jenkins/jobs/ansiblePipeline/inventory.ini'
                    )   
                }
            }
        }
    }
}
