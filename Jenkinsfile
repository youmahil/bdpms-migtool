pipeline{
	// Jenkins에 의해 선택된 가용 Agent 사용 
	agent any
	
	stages{
		// 1.GIT Repository에서 개발자에 의해 Push된 소스를 가져온다.
		//stage('SCM Update From GITHUB'){
		//	steps{
		//		git url: 'https://github.com/youmahil/HelloWorld.git', branch: 'master'
		//	}
		//}
		
		
		// 2.가져온 소스를 Gradle로 빌드한다.  //sh "./gradlew clean"
       stage('Gradle Build Java Source') {
           steps {
                sh "chmod 700 gradlew"
                sh "./gradlew bootJar --parallel --continue"
            }
        }
	
		// 3.Docker Image을 빌드하고, Docker Hub Repository에 Push한다.
       stage('Docker Build and Push to Docker Hub') {
            steps {
            	withDockerRegistry([credentialsId: "Yaong-Docker-Credentials", url: "https://index.docker.io/v1/"]) {
	            	sh '''
	            	docker build -t yaongdocker/bdpms-migtool:0.2 .
	              docker push yaongdocker/bdpms-migtool:0.2 
	                '''
                }
            }
        }
	}
}