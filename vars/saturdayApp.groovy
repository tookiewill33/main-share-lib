def call(String repoUrl){
  pipeline{
	agent any 
	stages{
		stage('1-git-clone'){
			steps{
				sh 'git --version'
				sh 'git clone'
			}
		}
		stage('2-mavenbuild'){
			steps{
				sh 'mvn package'
			}
		}
		stage('3-codeQuality'){
			steps{
				sh 'mvn sonar:sonar'
			}
		}
		stage('4-deploy'){
			steps{
				sh 'mvn deploy'
			}
		}
	}	
	
}
 }