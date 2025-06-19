def call() {
    
    stage('Clone Config Repo') {
        dir('config') {
            git branch: 'main', credentialsId: 'ssh_privatekey_github', url: 'git@github.com:iviul/Config.git'
            sh 'ls -la'
        }
    }
}
return this
