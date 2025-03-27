job('ejemplo2-job-DSL') {
	description('Job DSL ejemplo para el curso')
  scm {
    git('https://github.com/alealbaladejo/jenkins.job.parametrizado.git', 'main'){ node -> 
    	node / gitConfigName ('alealbaladejo')
      	node / gitConfigEmail ('alealbaladejo29s@gmail.com')
    	}      
    }  
  parameters {
    	stringParam ('nombre', defaultValue = 'ALEJANDRO', description = 'Ejemplo cadena job booleano')
    	choiceParam ('planeta', ['Mercurio', 'Venus', 'Tierra'])
    	booleanParam('agente', false)
  }
  triggers{
  		cron ('H/7 * * * *')
  }
  steps {
   		shell("bash jobscript.sh") 	
  }
  publishers {
  		mailer ('alealbaladejo29s@gmail.com', true, true)
  }
 
}
