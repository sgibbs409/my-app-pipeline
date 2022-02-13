def buildApp() {
    echo 'building the application...'
    echo "Building version ${NEW_VERSION}"
}

def testApp() {
    echo 'testing the applicaiton...'
}

def deployApp(){
    echo 'deploying the application...'
    echo "Prod version: ${params.VERSION_PROD}"
    echo "Deploying Version ${params.VERSION}"
}

return this