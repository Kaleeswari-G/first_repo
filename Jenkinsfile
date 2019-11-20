pipeline
{
   agent any
   stages
   {
     stage('Hello')
     {
        steps
        {     
           echo "Hello"
           lastChanges since: 'LAST_SUCCESSFUL_BUILD', format:'SIDE',matching: 'LINE'
           sh "echo ${BUILD_URL}last-changes/"
        }
     }
     stage("last-changes") {
         steps{
             git url: 'https://github.com/jenkinsci/last-changes-plugin.git'
             script{
              def publisher = LastChanges.getLastChangesPublisher "LAST_SUCCESSFUL_BUILD", "SIDE", "LINE", true, true, "", "", "", "", ""
              publisher.publishLastChanges()
              def changes = publisher.getLastChanges()
              //println(changes.getEscapedDiff())
              for (commit in changes.getCommits()) {
                  //println(commit)
                  def commitInfo = commit.getCommitInfo()
                  //println(commitInfo)
                  println(commitInfo.getCommitMessage())
                  //println(commit.getChanges())
              }
           }
         }
      }
   }
   post{
       always{
           addBadge(icon: "folder.gif", text: "Git Commit Path", link: "${BUILD_URL}last-changes/");
           addBadge(icon: "folder.gif", text: "Git Commit Path", link: "${BUILD_URL}/changes/");
       }
   }
}
