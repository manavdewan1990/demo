node {
    stage 'Clone the project'
    git 'https://github.com/manavdewan1990/demo.git'

        stage("Compilation and Analysis") {
            parallel 'Compilation': {
                sh "pwd"
                sh "./mvnw clean install -DskipTests"
            }, 'Static Analysis': {
                stage("Checkstyle") {

                }
            }
        }

        stage("Tests and Deployment") {
            stage("Staging") {

                    sh 'nohup ./mvnw spring-boot:run -Dserver.port=8989 &'
              }
        }

}