library identifier: 'first_repo@master', retriever: modernSCM(
    [$class: 'GitSCMSource',
    remote: 'https://github.com/Kaleeswari-G/first_repo.git'])
pipeline
{
   agent any
   environment{
      buser=""
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
           }
           echo "World"
           calling()
        }
     }
   }
}
