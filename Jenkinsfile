library identifier: 'first_repo@master', retriever: modernSCM(
    [$class: 'GitSCMSource',
    remote: 'https://github.com/Kaleeswari-G/first_repo.git'])
pipeline
{
   agent any
   environment{
      buser=""
      gc=""
       gitcommit=""
   }
   stages
   {
     stage('Hello')
     {
        steps
        {     
           echo "Hello"
        }
     }
     stage('world')
     {
        steps
        {
           script{
              buser=wrap([$class: 'BuildUser']) {
                    return env.BUILD_USER
              }
              echo "${buser}"
              echo "inside script"
             //  gc=calling("${buser}")
               gc=calling("${buser}")
           echo "${gc}"
           }
           echo "World"
           
        }
     }
   }
   post{
       always{
           script{
              cd("STAGE")
           }
       }
   }
}
def cd(VAL){
    build job:'cd-test' , parameters:[string(name: 'ENVIRONMENT',value: VAL)]
}
