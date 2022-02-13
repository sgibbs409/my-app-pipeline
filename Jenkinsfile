pipeline {
    agent any

    stages {

        stage("build") {
            steps {
                echo "Building The Application..."
            }
        }

        stage("test") {
            when {
                expression {
                    env.BRANCH_NAME == 'dev' || BRANCH_NAME == 'master'
                }
            }
            steps {
                echo "Testing The Application..."
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
