def call() {
    
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
}
return this
