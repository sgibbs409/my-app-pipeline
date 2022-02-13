// CODE_CHANGES = getGitChanges()
pipeline {
    agent any
    // tools {
    //     maven 'Maven-3.8'
    // }
    parameters {
        string(name: 'VERSION_PROD', defaultValue: '', description: 'Version to deploy on prod')
        choice(name: 'VERSION', choices: ['1.1.0', '1.2.0', '1.3.0'], description: '')
        booleanParam(name: 'executeTests', defaultValue: true, description: '')
    }
    environment {
        NEW_VERSION = '1.3.0'
        SERVER_CREDENTIALS = credentials('server-user-id')
    }
    stages {

        stage("build") {
            steps {
                echo "Building The Application..."
                echo "Building version ${NEW_VERSION}"
            }
        }

        stage("test") {
            // when {
            //     expression {
            //         BRANCH_NAME == 'dev' && CODE_CHANGES == true
            //     }
            // }
            when {
                expression {
                    params.executeTests == true
                }
            }
            steps {
                echo "Testing The Application..."
                // echo "Testing with credentials: ${SERVER_CREDENTIALS}"
            }
        }

        stage("deploy"){

            steps {
                echo "Deploying The Application..."
                echo "Prod version: ${params.VERSION_PROD}"
                echo "Deploying Version ${params.VERSION}"

                withCredentials([usernamePassword(
                    credentialsId: 'server-user-id',
                    usernameVariable: 'USERNAME',
                    passwordVariable: 'PASSWORD')]) {
                        // available as an env variable, but will be masked if you try to print it out any which way
                        // note: single quotes prevent Groovy interpolation; expansion is by Bourne Shell, which is what you want
                        sh 'echo $PASSWORD'
                        // also available as a Groovy variable
                        echo USERNAME
                        // or inside double quotes for string interpolation
                        echo "username is $USERNAME"
                        echo "password is ${PASSWORD}"
                }
            }
        }
    }
    post {
        // Run logic after all stages executed
        // Condition on Build Status or Build Status Changes
        always {
            // run always 
            echo "This always runs"  
        }
        success {
            // run only on success
            echo "This runs on success"
        }
        failure {
            // run only on failure
            echo "This runs on failure"
        }
    }
}
