job('ejemplo2-job-DSL') {
	description('Job DSL de ejemplo para el curso de Jenkins')
  	scm {
      		git('https://github.com/josecordovac/jenkins.job.parametrizado.git', 'main') { node ->
        		node / gitConfigName('josecordovac')
        		node / gitConfigEmail('josecordovac@gmail.com')
      		}
    	} 
  	parameters {
   		stringParam('nombre', defaultValue = 'Jaccx', description = 'Parametro de cadena para el Job Booleano')
      		choiceParam('planeta', ['Mercurio', 'Venus', 'Tierrra', 'Marte', 'Jupiter', 'Saturno', 'Urano', 'Neptuno'])
      		booleanParam('agente', false)
    	}
  	triggers {
    		githubPush()
    	}
  	steps {
    		shell("bash jobscript.sh")
    	}
}
