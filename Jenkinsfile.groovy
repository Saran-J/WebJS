def notify(message) {
    def token = "cNBwjB1XflcJoQRDAGCvlF1BS8I7w2VxQK4al8wLep6";
    def jobName = env.BRANCH_NAME;
    def buildNo = env.BUILD_NUMBER;
      
    def url = "https://notify-api.line.me/api/notify";
    def lineMessage = "${jobName} [#${buildNo}] : ${message} \r\n";
    sh "curl ${url} -H 'Authorization: Bearer ${token}' -F 'message=${lineMessage}'";
}
pipeline {
    
    agent any  

    stages {

        stage('Notify Start') {
            steps {
                    script {
                        notify("Test Repo for new pipeline")
                    }
                }
        }
    }
}