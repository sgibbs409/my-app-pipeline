// CODE_CHANGES = getGitChanges()
pipeline {
    agent any
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
            steps {
                echo "Testing The Application..."
                echo "Testing with credentials: ${SERVER_CREDENTIALS}"
            }
        }

        stage("deploy"){

            steps {
                echo "Deploying The Application..."
                withCredentials([
                    usernamePassword(credentials: 'server-user-id', usernameVariable: USER, passwordVariable:PASSWORD)
                ]){
                    echo "user ${USER} password ${PASSWORD}"
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
