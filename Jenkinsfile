pipeline {
    agent any

    tools {
        maven "Maven3"
        jdk 'Java21'
        
    }

    stages {

        stage('clean workspace'){
            steps{
                cleanWs()
            }
        }

        stage('GitHub') {
            steps {
                echo 'Uygulamayı GitHub çek.'
                checkout scmGit(branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/erdincekiztas/devops_004_pipeline']])
            }
        }
        

        stage('Build Maven') {
            steps {
               echo 'Maven başlıyor'
                script {
                    if (isUnix()) {
                        sh "mvn  clean install"
                    } else {
                        bat "mvn clean install"
                    }
                }
                echo 'Maven sonu'
            }
        }

        

        stage('Test') {
            steps {
                echo 'Uygulamayı test et.'
                 script {
                    if (isUnix()) {
                        sh "mvn  test"
                    } else {
                        bat "mvn test"
                    }
                 }
            }
        }
        stage('SonarQube') {
           
            steps {
                echo 'SonarQube ile kod analizi yap.'

                 script {
                    withSonarQubeEnv(credentialId: 'TOKEN_ID_SONARQUBE') {
                         if (isUnix()) {
                            sh "mvn  sonar:sonar"
                        } else {
                            bat "mvn  sonar:sonar"
                        }
                    }
                 }
            }
        }
        /*
        stage('Docker Image') {
            steps {
                echo 'Image yap.'
                script {
                    if (isUnix()) {
                        sh "docker build -t erdincekzts/devops-application:latest ."
                    } else {
                        bat "docker build -t erdincekzts/devops-application:latest ."
                    }
                 }
                
            }
        }

        stage('DockerHub') {
            steps {
                
                echo "Image DockerHub'a gönder."
                withCredentials([string(credentialsId: 'DockerHub_id', variable: 'DockerHub')]) {
                //login
                 script {
                    if (isUnix()) {
                        sh "docker push erdincekzts/devops-application:latest"
                    } else {
                        bat "docker push erdincekzts/devops-application:latest"
                    }
                 }
               
                
                }
            }
        }

        stage('Kubernetes (K8s)') {
            steps {
                script{
                   echo "K8s içinde image'ı çalıştır."
                   kubernetesDeploy (configs:'deployment-service.yaml', kubeconfigId: 'Kubernetes_id')}
            }
        }

        stage('Clean') {
            steps {
                echo "Makinedeki fazlalık imageları temizle."
                 script {
                    if (isUnix()) {
                        sh "docker prune -f"
                    } else {
                        bat "docker prune -f"
                    }
                 }

            }
        } */
    }
}
