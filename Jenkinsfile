pipeline
{
   agent { label 'master'}
   stages
   {
     stage('Hello')
     {
        steps
        {     
           echo "Hello"
           lastChanges since: 'LAST_SUCCESSFUL_BUILD', format:'SIDE',matching: 'LINE'
        }
     }
     stage('world')
     {
        steps{
           echo "World"
        }
     }
   }
}
