
pipeline{

    agent any
    tools {
    maven 'maven_3_5_0'}

    stages {

        stage ('Compile Stage') {

            steps {

                bat "mvn clean compile"
                //sh 'mvn clean install'
            }
        }
    stage ('Test Stage') {

            steps {


                    sh 'mvn test'



            }
        }


        stage ('Cucumber Reports') {

            steps {
                cucumber buildStatus: "UNSTABLE",
                    fileIncludePattern: "**/cucumber.json",
                    jsonReportDirectory: 'target'

            }

        }

    }

}
