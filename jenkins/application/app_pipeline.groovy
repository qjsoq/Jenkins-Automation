def call() {
    podTemplate(
        label: 'ansible-agent-application',
        serviceAccount: 'jenkins-service-account', 
        containers: [
            containerTemplate(
                name: 'ansible',
                image: 'artamonovdima/application_agent:1.0', // твій образ
                command: 'cat',
                ttyEnabled: true
            )
        ]
    ) {
        node('ansible-agent-application') {
            container('ansible') {
                stage('Clone Repositories') {
                    dir('config') {
                        git branch: 'DI-34-Develop', credentialsId: 'ssh_privatekey_github', url: 'git@github.com:iviul/Config.git'
                        sh 'ls -la'
                    }
                    dir('milestone') {
                        git branch: 'main', url: 'https://github.com/iviul/Milestone-2.git'
                        sh 'ls -la'
                    }
                }

                stage('Test access to cluster') {
                    sh 'kubectl get nodes'
                }
            }
        }
    }
}
return this
