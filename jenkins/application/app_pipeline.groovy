def call() {
    podTemplate(
        label: 'ansible-agent',
        containers: [
            containerTemplate(
                name: 'ansible',
                image: 'artamonovdima/application_agent:1.0',
                command: 'cat',
                ttyEnabled: true,
                resourceRequestCpu: '100m',
                resourceRequestMemory: '256Mi',
                resourceLimitCpu: '200m',
                resourceLimitMemory: '512Mi'
            )
        ],
        serviceAccount: 'jenkins',
        namespace: 'jenkins'
    ) {
        node('ansible-agent') {
            container('ansible') {
                stage('Clone Repositories') {
                    dir('config') {
                        git branch: 'DI-34-Develop', credentialsId: 'ssh_privatekey_github', url: 'git@github.com:iviul/Config.git'
                        sh 'ls -la'
                        sh 'pwd'
                    }
                    dir('milestone') {
                        git branch: 'main', url: 'https://github.com/iviul/Milestone-2.git'
                        sh 'ls -la'
                        sh 'pwd'
                    }
                }

                stage('Copy Configurations') {
                    sh 'cp /home/jenkins/agent/workspace/Main Pipeline Job/config/config-kuber.json Running in /home/jenkins/agent/workspace/Main Pipeline Job/milestone/terraform'
                }
                stage('Run Ansible Playbook') {
                    sh 'ansible-playbook /home/jenkins/agent/workspace/Main Pipeline Job/milestone/ansible/app_deploy.yml'
                }
            }
        }
    }
}
return this
