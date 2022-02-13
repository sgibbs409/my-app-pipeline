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
            }
        }
    }
    post {
        // Run logic after all stages executed
        // Condition on Build Status or Build Status Changes
        always {
            // run always   
        }
        success {
            // run only on success
        }
        failure {
            // run only on failure
        }
    }
}
